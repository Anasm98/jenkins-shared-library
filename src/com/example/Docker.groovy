#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {
    def script
    Docker(scirpt) {
        this.script = scirpt
    }
    def buildDockerImage(String imageName) {
        script.echo "building the docker image..."
            script.sh "docker build -t $imageName ."
    }
    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-cred', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }
    def dockerPush() {
        script.sh "docker push $imageName"

    }
}