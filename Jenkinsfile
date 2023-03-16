pipeline {

  agent any

  tools{
       maven 'Maven'
  }

  environment {
        AWS_REGION = 'ap-south-1'
        ECR_REPO = 'restaurant-recommend'
        IMAGE_TAG = 'latest'
        DOCKERFILE = 'DockerFile'
        REGISTRY = '864464410255.dkr.ecr.ap-south-1.amazonaws.com/restaurant-recommend'
  }

    stages {
        stage('Git Checkout') {
            steps {
                echo " Job Ran by the ${creator}"

                checkout([$class: 'GitSCM',
                            branches: [[name: '*/main']],
                            userRemoteConfigs: [[url: 'https://github.com/developersfun/restaurant-recommand']]])

            }

        }

        stage('Maven Clean') {
            steps {
                sh "mvn clean install"
            }

        }

        stage('Docker Build') {
            steps {
                script{
                    dockerImage = docker.build ECR_REPO
                }
            }

        }

        // stage('Docker Push') {
            // steps {

            //     script {
            //         sh "aws ecr get-login-password --region ${AWS_REGION} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com"
            //         }

            //                         // Push the Docker image to ECR
            //     script {
            //         sh "aws ecr get-login-password --region ${AWS_REGION} | docker push 864464410255.dkr.ecr.ap-south-1.amazonaws.com/restaurant-recommend:latest"
            //     }
            // }
        // }
    }
}