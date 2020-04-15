def ISFAILED = "NO"

pipeline{
    agent any

    stages {
        stage ('Compile Stage') {
            steps{
                withMaven(maven: 'maven_3.6.3'){
                    bat('mvn clean install -DskipTests')
                }
            }
        }
        try{
            stage ('Test Stage') {
                steps{
                    withMaven(maven: 'maven_3.6.3'){
                        bat('mvn test')
                    }
                }
                post {
                    success {
                        script {
                            ISFAILED = false
                        }
                    }
                    failure {
                        script {
                            
                        }

                    }
                }
            }
        }catch(e) {
             ISFAILED = true
        }
        stage ('Cucumber Reports') {
            steps{
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'
            }
        }
        stage ('Stop Execution if failure') {
            steps {
                script {
                    if(ISFAILED == true){
                        echo "Cucumber failed"
                        currentBuild.result = "FAILURE"
                    }else{
                        echo "Build continues"
                        currentBuild.result = "SUCCESS"
                    }
                }
            }
        }
    }
}