pipeline {
    agent any
    stages {
        stage('PMD') {
            steps {
                sh 'mvn pmd:pmd'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'UNSTABLE') {
                    sh 'mvn surefire:test '
                }
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('Javadoc') {
            steps {
                sh 'mvn javadoc:jar'
            }
            post {
                always {
                    archiveArtifacts artifacts: '**/target/site/apidocs/**', fingerprint: true
                }
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
        }
    }
}