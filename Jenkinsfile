def ISFAILED = "NO"

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
                    script {
                        ISFAILED = "NO"
                    }
                }
                failure {
                    script {
                        ISFAILED = "YES"
                    }

                }
            }
        }
        stage ('Stop Execution if failure') {
            steps {
                script {
                    if(ISFAILED == "YES"){
                        echo "Cucumber failed"
                    }else{
                        echo "Build continues"
                    }
                }
            }
        }
    }
}