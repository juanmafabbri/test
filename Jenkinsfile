pipeline {
  agent any
  stages {

    stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      //   git branch: 'main', url: 'https://github.com/hardeepsonatype/zippedtest.git', skipTag: true, shallow: true
      steps {
        git branch: 'main', url: 'https://github.com/juanmafabbri/test'
      }

    }
    stage('Build') {
      tools {
        jdk 'JAVA11'
        maven 'MAVEN3.9.9'
      }
      steps {

        sh 'java -version'            
        sh 'mvn -B -DskipTests clean install dependency:copy-dependencies'

        nexusPolicyEvaluation iqStage: 'build', iqApplication: 'testapp',
          iqScanPatterns: [
            [scanPattern: '*.zip']
          ],
          failBuildOnNetworkError: true,
          callflow: [
            enable: true,
            timeout: '10 minutes',
            logLevel: 'DEBUG',
            entrypointStrategy: [
              $class: 'NamedStrategy',
              name: 'JAVA_MAIN'
            ]
          ]
      }

    }
  }
}
