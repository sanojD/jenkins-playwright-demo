pipeline {
    agent any

    tools {
        maven 'Maven3'   // names must match Manage Jenkins > Tools
        jdk   'JDK17'
    }

    options {
        timestamps()
        timeout(time: 20, unit: 'MINUTES')
    }

    stages {
        stage('Install Browsers') {
            steps {
                // On a Windows agent, replace sh with bat
                sh 'mvn -B exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install --with-deps chromium"'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn -B clean test'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/cucumber-report.html', allowEmptyArchive: true
        }
    }
}
