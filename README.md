# PersonManagement
Front End Implement using Angular version 8
Backend Implement using JAVA 8, Spring Rest, Spring AOP for Logging

# Running application follow below steps
clone application from below url
https://github.com/DevKumRos/PersonManagement.git
mvn clean install
mvn spring-boot:run
# We can access application with below url
http://localhost:9091/
No need to do any additional step for running angular code its already included in resouces/static folder

 
# Way of Integrate Angular and Spring Boot
Create a file proxy-conf.json under project root folder
{
	"/api":{
	"target": "http://localhost:8080",
	"secure": false
	}
}
# Edit package.json file for start script:
"scripts": {
    "ng": "ng",
    "start": "ng serve --proxy-config proxy-conf.json",
    "build": "ng build --prod",
    "postbuild": "npm run deploy",
    "predeploy": "rimraf ../resources/static/ && mkdirp ../resources/static",
    "deploy": "copyfiles -f dist/** ../resources/static",
    "lint": "ng lint",
    "e2e": "ng e2e"
  }
# Edit angular.json file with where destination folder should generate code, which we are going to copy to springboot application
"options": {
            "outputPath": "dist/personManagement",
            "index": "src/index.html",
            "main": "src/main.ts", 

# Build and Run Angular project seperatly with below commands and copy files from 
# dist folder to resoucre/static folder of springboot project

ng build
# Generate dist/personManagement folder copy the file from there & place in resoucre/static folder of springboot project 
# Build SPringBoot application
mvn clean install
mvn spring-boot:run

# Access application from this url http://localhost:9091/
 
