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
        stage("Docker HW") {
            steps {
                echo " ========== image build ========== "
                dir ('docker/lesson2') {
                    sh 'docker build . '
                }
        }
    }
}
