pipeline {
    agent any

    // tools {
    //     // Install the Maven version configured as "M3" and add it to the path.
    //     maven "M3"
    // }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                //git branch: 'main', changelog: false, poll: false, url: 'ssh://roz/srv/git/tasklist', credentialsId: 'tcurtis'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"

                // sh "podman build --tag springlist -f ./Dockerfile"
                // sh "podman run -dt --net=host --rm tasklist"
            }
	}
        
        stage('Deploy') {
            steps {
		sh 'pwd'
                sh '''
                    scp -i ~/.ssh/roz_rsa target/tasklist*.jar tcurtis@roz:~/
'''
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
