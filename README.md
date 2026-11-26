# jenkins-playwright-demo

Sample Playwright + Java + Cucumber project for practising a Jenkins pipeline.
Target site: https://www.saucedemo.com

## Run locally
Requirements: JDK 17+, Maven 3.8+

    mvn clean test

Report: target/cucumber-report.html

First run downloads the Playwright browsers automatically. If it fails, install them manually:

    mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install chromium"

## Push to GitHub

    git init
    git add .
    git commit -m "Initial commit"
    git branch -M main
    git remote add origin https://github.com/<your-username>/jenkins-playwright-demo.git
    git push -u origin main

## Jenkins
1. Manage Jenkins > Tools: add JDK named `JDK17` and Maven named `Maven3`.
2. New Item > Pipeline > "Pipeline script from SCM" > Git > your repo URL > branch `*/main` > script path `Jenkinsfile`.
3. Build Now. For auto-triggers use a GitHub webhook (`http://<jenkins-url>/github-webhook/`) or Poll SCM (`H/2 * * * *`).
