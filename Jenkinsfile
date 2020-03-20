pipeline{
    agent any

    stages {
        stage ('Compile Stage') {
            steps{
                withMaven(maven: 'maven_3_5_0'){
                    bat('mvn clean install')
                }
            }
        }
        stage ('Test Stage') {
            steps{
                withMaven(maven: 'maven_3_6_3'){
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