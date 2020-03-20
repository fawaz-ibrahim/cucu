pipeline{
    agent any
    tools {
        maven 'Maven_3.5.2'
    }
    stages {
        stage ('Compile Stage') {
            steps{
                bat "mvn clean install"
            }
        }
        stage ('Test Stage') {
            steps{
                bat "mvn test"
            }
        }
        stage ('Cucumber Reports') {
            steps{
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'
            }
        }
    }
}