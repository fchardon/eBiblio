node {
   stage 'Build PRoject '
   echo "Source code checked"
   checkout scm
   
   stage 'Run unit tests'
   echo 'Running Unit tests'
   def mvnHome = tool 'maven-3.3.9'
   sh "${mvnHome}/bin/mvn -B test"


   stage 'Run acceptance tests'
   echo 'Running acceptance tests'
   def mvnHome = tool 'maven-3.3.9'
   sh "${mvnHome}/bin/mvn -B verify"


   stage 'deploy to test environment'
   echo 'deploying app to test'
   stage 'Run performace-Load test' 
   echo 'Running performance and load test' 
   stage 'deploy to prod' 
   echo 'Deployed to Production'
}