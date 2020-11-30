
pipeline {
    agent any 


    parameters {
        string(name:"VERSION", defaultValue:'', description:'version to deploy')
        choice(name:"Version", choices : ['1.1', '1.2', '1.3'], description:'')
        booleanParam(name:'executeTests', defaultValue:true, description:"skip tests")
    }

    tools {
        maven 'M3'
    }

    
    environment {
        ORG_NAME = "naveen"
        APP_NAME = "demo-app"
        APP_VERSION = "1.0-SNAPSHOT"
        APP_CONTEXT_ROOT = "/"
        APP_LISTENING_PORT = "9090"
        TEST_CONTAINER_NAME = "ci-${APP_NAME}-${BUILD_NUMBER}"
        PREV_CONTAINER_NAME="ci-${APP_NAME}-${currentBuild.previousBuild.number}"
    }

  stages {
    stage('Compile') {
        steps {
            echo "-=- compiling project -=-"
            sh "mvn clean compile"
        }
    }
  

    stage('Package') {

// to execute this stage when params.executeTest is true 
        when {
            expression {
                params.executeTests
            }
        }

        steps {
            echo "-=- packaging project -=-"
            sh "mvn package -DskipTests=${params.executeTests}"
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }

    stage ('Killing Containers') {
        steps {

            echo "====== killing Containers====="
            echo "Current Container: ${TEST_CONTAINER_NAME} "
            echo "Previous Container ${PREV_CONTAINER_NAME}"
            script {
                try {
                    sh "docker rm ${PREV_CONTAINER_NAME}"
                }catch(Exception e) {
                    echo e.getMessage() 
                    echo "Container not found ${PREV_CONTAINER_NAME}"
                }
            }
        }
    }



    stage('Build Docker image') {
        steps {
            echo "-=- build Docker image -=-"
            sh "docker build -t ${ORG_NAME}/${APP_NAME}:${APP_VERSION} -t ${ORG_NAME}/${APP_NAME}:latest ."
        }
    }

   stage('Run Docker image') {
            steps {
                echo "-=- run Docker image -=-"
                echo "Executing  ${VERSION}"
                sh "docker run --name=${TEST_CONTAINER_NAME} --detach --restart=always --network axis-network -p 9090:9090 ${ORG_NAME}/${APP_NAME}:latest"
            }
        }

  }
}