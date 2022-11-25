pipeline {
    agent any 
    
    triggers {
        pollSCM 'H/5 * * * *'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/matine-nassirpour/Continuous-integration.git'
            }
        }
        
        stage('Clean') {
            steps {
                bat './mvnw clean'
            }
        }
        
        stage('Compile') {
            steps {
                bat './mvnw compile'
            }
        }
        
        stage('Test') {
            steps {
                bat './mvnw test'
            }
        }
        
        stage('Package') {
            steps {
                bat './mvnw package'
            }
        }
        
        stage('Archive') {
            steps {
                bat 'rename target\\erphrense-0.0.1-SNAPSHOT.jar erphrense-%BUILD_NUMBER%.jar'
                archiveArtifacts artifacts: 'target\\erphrense-*.jar', followSymlinks: false
            }
        }
    }
}
