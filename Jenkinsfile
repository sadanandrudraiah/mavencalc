node {
    env.JAVA_HOME="${tool 'JDK'}"
    env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/sadanandrudraiah/mavencalc.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
   
   stage('Email Notification'){
      mail bcc: '', body: '''Jenkins build success!
      Thanks
      Sada''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'sadanand.rud@gmail.com'
   }   
   
}
