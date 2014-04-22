homework
========
Requirements:
- download this project
- make sure that you have Firefox and Chrome browsers installed
- make sure that you have Maven installed
- download Selenium Chrome Driver from: http://chromedriver.storage.googleapis.com/index.html:
	- open config.properties file in homework/homework-wikia/settings/ directory
	- change path for chrome.driver property accordingly to path where you've downloaded Selenium Chrome Driver
	- save and close config.properties file

To run tests:
- open console
- navigate to 'homework-wikia' folder in project directory
- to run tests in Chrome browser, type "mvn clean install -Dbrowser=chrome"
- to run tests in Firefox browser, type "mvn clean install -Dbrowser"