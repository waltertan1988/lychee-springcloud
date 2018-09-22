#!/usr/bin/env groovy

node {
	try {
		stage('Checkout') {
			echo "Stage - Checkout"
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