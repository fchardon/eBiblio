node {
   
   stage('Build and Test') {
        checkout scm
        def mvnHome = tool 'maven-3.3.9'
        sh "${mvnHome}/bin/mvn -B test"
    }

   stage('Run acceptance tests') {'
      echo 'Running acceptance tests'
      def mvnHome = tool 'maven-3.3.9'
      sh "${mvnHome}/bin/mvn -B verify"
   }

   stage('Deployed to Server') {'
      echo 'Deployed to Production'
   }

}