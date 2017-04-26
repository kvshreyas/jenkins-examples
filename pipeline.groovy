node('master') {
    stage('Clone'){
   checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'http://github.com/savishy/spring-petclinic']]])
    }
    stage('Install'){
   bat 'mvn install'
    }
    stage('Test'){
   bat 'mvn test'
    }
    stage('Archive'){
   archiveArtifacts '**/target/*.war'
    }
}