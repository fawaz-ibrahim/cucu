pipeline{
    agent any

    stages {
        stage ('Compile Stage') {
            steps{
                withMaven(maven: 'maven_3.5.0'){
                    bat('mvn clean install')
                }
            }
        }
        stage ('Test Stage') {
            steps{
                withMaven(maven: 'maven_3.6.3'){
                    bat('mvn test')
                }
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