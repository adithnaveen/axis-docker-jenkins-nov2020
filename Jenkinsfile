pipeline {
    agent any

parameters {
    choice(name="VERSION", choices:['1.0', '2.0', '3.0','4.0'], description:"choose the version")
    booleanParam(name="executeTests", defaultValue:true, description:"Execute Test")
}
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}