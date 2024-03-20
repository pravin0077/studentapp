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
                sh '/opt/apache-maven-3.6.3/bin/mvn sonar:sonar -Dsonar.projectKey=test -Dsonar.host.url=http://43.205.237.12:9000 -Dsonar.login=430c30e705b43f13c089e317b784786a4da07c38'
                echo 'Testing done'
            }
        }
stage('Deploy') {
            steps {
                echo 'Deploy done'
            }
        }
    }
}
