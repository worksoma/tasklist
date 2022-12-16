pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
	}
        
        stage('Deploy') {
            steps {
                sh 'scp -i ~/.ssh/roz_rsa deploy/Dockerfile deploy/docker-tasklist.service target/tasklist*.jar tcurtis@roz:~/deploy'

		withCredentials([string(credentialsId: 'SUDOPASSWD', variable: 'SUDOPASSWD')]) {
		    sh 'ansible-playbook -i roz, playbook.yml --user=tcurtis --private-key=/usr/local/jenkins/.ssh/roz_rsa --extra-vars "ansible_sudo_pass=$SUDOPASSWD"'
		}
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
