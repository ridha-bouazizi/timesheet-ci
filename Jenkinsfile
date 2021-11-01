pipeline {
    agent any
    
    environment {
        // This can be nexus3 or nexus2 server
        NEXUS_VERSION = "nexus3"
        // This can be http or https
        NEXUS_PROTOCOL = "http"
        // Where your Nexus is running
        NEXUS_URL = "localhost:8081"
        // Repository where we will upload the artifact
        NEXUS_REPOSITORY_RELEASES = "maven-releases"
        NEXUS_REPOSITORY_SNAPSHOTS = "maven-snapshots"
        // Jenkins credential id to authenticate to Nexus OSS
        NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
    }
    
    stages {
        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Nexus Repository') {
            steps {
                bat "mvn deploy:deploy-file -DgroupId=tn.esprit -DartifactId=timesheet-ci -Dversion=3.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/#browse/browse:maven-releases/ -Dfile=target/timesheet-ci-${VERSION}.jar"
            }
        }
    }
}