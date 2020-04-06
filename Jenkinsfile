pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven 'maven'
   }
   triggers {
        cron('H 7 * * *')
    }

   stages {
      stage('Retrieve') {
         steps {
            // Get some code from a GitHub repository
            git 'https://github.com/flaredragon/ps-assignments'
            sh 'git checkout week-1'  
            
         }

      }
      stage('Package') {
         steps {
            sh "mvn -Dmaven.test.failure.ignore=true clean package"

         }
      }
      stage('Run') {
         steps {
            sh "java -cp target/assignment-1-1.0-SNAPSHOT.jar training.maven.quick.App"
            
         }
      }
   }
}

