#!/usr/bin/env groovy

node {
	try {
		stage('Checkout') {
			checkout scm
		}
		
		stage('Build') {
			echo "Stage - Build"
		}
			
		stage('Deploy') {
			echo "Stage - Deploy"
		}
	} catch (err) {
		currentBuild.result = "FAILED"
		throw err
	} finally {
	
	}
}