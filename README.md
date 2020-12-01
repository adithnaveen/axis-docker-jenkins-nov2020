# axis-docker-jenkins-nov2020
For Axis Bank Training 


Known 

To know how to create containers / Images 
Concept of Containers 


docker pull ubuntu 
docker pull openjdk 

TODO 

Docker with Tags 

docker pull adithnaveen/helloworld

the tag name should always be the account name which is on hub.docker.com 

axis-app:1 
axis-app:latest 

> docker login 
> docker push axis-app:latest (will not work )
> docker tag axis-app:latest adithnaveen/axis-app:latest
> docker push adithnaveen/axis-app:latest


to host on private repository 

> docker push localhost:5000/helloworld


hub.docker.com 


axis-app:1 
axis-app:2 
axis-app:3 



























pushing -> hub.docker.com 
Docker Volumes 
Dockerfile 
	If you want to have your own docker images 

to remove all the images 
docker image rmi -f  $(docker image list -aq)

to remove all the containers 
docker container rm -f $(docker container list -aq)


when you are testing we can have alpine images 

openjdk
openjdk             latest              8f057dde245a        13 days ago         486MB


openjdk:8-apline - ~70 MB 
openjdk             8-alpine            a3562aa0b991        18 months ago       105MB



Deploy Java Project with Docker 
1. create a project 
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

mvn clean package 
2. deploy on docker 
	i) Create a Dockerfile 
		a) which jdk we need 
		b) what actions we have to do to execute the program 
		

> docker image build -t mvn-hello:6 .
> docker container run mvn-hello:6    
> docker container run  --name my-mvn-container mvn-hello:6    



Deploy SpringBoot Application with Docker 

1. https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.4.0.RELEASE&packaging=jar&jvmVersion=1.8&groupId=com.axis&artifactId=axis-works&name=axis-works&description=Demo%20project%20for%20Spring%20Boot&packageName=com.axis.axis-works&dependencies=web

2. create a method in the main class 

	@GetMapping("/hello")
	public String sayHi() {
		return "Hello World from Axis Bank on 30-Nov"; 
	}

3. Under build (pom.xml)
	<finalName>axis-work</finalName)
3_1. mvn clean install 
4. java -jar target/axis-work.jar 
5. Dockerfile 
	FROM openjdk:8 
	ADD target/axis-app.jar app.jar 
	EXPOSE 9090 
	ENTRYPOINT [ "java", "-jar", "app.jar" ]
6. create an image 
	docker build -t axis-image . 
7. Run the container 
	docker container run -p 9090:9090 --name my-spring-app  axis-image


Jenkins - 
	Simple Project 
	Pipeline project 
	Jenkinsfile 


// start jenkins with volume 
docker run --name myjenkins -d  -p 8080:8080 -p 50000:50000 -v /Volumes/Kanchan/MyTrainings/axis-bank-docker-jenkins/jenkins-volume:/var/jenkins_home jenkins

docker run --name myjenkins1 -p 9090:8080 -p 60000:50000 -v  /Volumes/Kanchan/MyTrainings/axis-bank-docker-jenkins/jenkins-volume:/var/jenkins_home jenkins

docker run --name myjenkins2 -p 9091:8080 -p 40000:50000 -v  /Volumes/Kanchan/MyTrainings/axis-bank-docker-jenkins/jenkins-volume:/var/jenkins_home jenkins


CMD (Jenkins)  CI/CD 	


1. java8 - Java Home 
2. git - .exe file 
3. Maven - Maven Home 


 


0.1. push to github 
0.2. pull the code  
1. build the application 
2. mvn clean compile package install deploy 
3. if you have the container running already then delete it 
4. then build the images from Dockerfile 
5. run the container 
6. have some post(after) job





pipeline {
	stages {
		stage('build') {
			script {
				groovy script (conditon, try-catch, loop )
				if script returns true 

				try{

					if(BRANCH_NAME='dev')
			
				}catch(e){
					print(e)
				}

				steps {	}
			}
			steps {
			}
		}
		stage('test') {
			steps {
			}
		}
		stage('deploy') {
			steps {
			}
		}				
	}
}







pipeline {
    agent any

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




 

> java -jar jenkins.war 


 



Docker compose 


- https://github.com/docker/compose
- https://docs.docker.com/compose/


Docker - docker pull / push (openjdk, jenkins, redis etc)
Dockerfile - deploying Java Application (You take the docker images which are publicliy available and build on top of it)

FROM openjdk 

FROM mongo 

FROM jenkins

FROM redis 

1 - depends - on another 

docker-compose
to install - https://docs.docker.com/compose/install/

.yml 
.yaml 


myserivce
  one: 
    image: redis 
	ports: 
	  - 9090:9090
	volume: 
	  /user/somefolder/somefolder/
  two: 
    image: mongo 


1. docker-compose.yml 
2. contents 
3. start -> docker-compose up 
4. to stop or kill -> docker-compose down 
5. to validate the yml file written docker-compose config 
6. if you have kept the docker-compose.yml file in another directory -f to be used 

to deploy spring boot application with docker-compose 

- Dockerfile 

list all volumes 
> docker volume ls 

create a volume  
> docker volume create mongo-data 

to know the location and other details of the docker volume 
> docker volume inspect mongo-data 

create a network 
> docker network create  axis-network  



