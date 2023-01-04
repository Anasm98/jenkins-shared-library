#!/usr/bin/env groovy

def call() {
    echo "building the application in brach $BRANCH_NAME"
    sh 'mvn package'
}
