pipeline {
    agent any

    stages {

        stage('Pull') {
            steps {
                git 'https://github.com/chetansomkuwar254/studentapp.ui.git'
                echo 'Hello World'
            }
        }

        stage('Build') {
            steps {
                sh '/opt/apache-maven-3.6.3/bin/mvn clean package'
                echo 'Hello World'
            }
        }
stage('testing') {
            steps {
                sh '/opt/apache-maven-3.6.3/bin/mvn sonar:sonar -Dsonar.projectKey=test -Dsonar.host.url=http://65.2.143.231:9000 -Dsonar.login=430c30e705b43f13c089e317b784786a4da07c38'
                echo 'Testing done'
            }
        }
stage('Deployment') {
            steps {
                deploy adapters: [tomcat8(url: 'http://13.201.89.207:8080/' , credentialsId: 'Tomcat_credentials')], contextPath: '/', war: '**/*.war'
                echo 'Deployment Done successfully'
            }
        }
    }
}
