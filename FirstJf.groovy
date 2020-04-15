#!groovy
//letsgo
properties([disableConcurrentBuilds()])

pipeline {
    agent {
        label 'ubuntu'
        }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
        }
    stages {
        stage("First step") {
            steps {
                sh 'pwd'
            }
        }
        stage("Second step") {
            steps {
                sh 'ifconfig'
            }
        }
    }
}
