def isFailed = false

pipeline{
    agent any

    stages {
        stage ('Compile Stage') {
            steps{
                withMaven(maven: 'maven_3.6.3'){
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
            post {
                success {
                    isFailed = false
                }
                failure {
                    isFailed = true
                }
            }
        }
        stage ('Stop Execution if failure') {
            if(isFailed){
                echo "Cucumber failed"
            }else{
                echo "Build continues"
            }
        }
    }
}