# WordCountApp

included:
source/test source files
target directory containing compiled files, executable jar with dependencies, junit test report
README file
pom.xml

Prerequisites
============
1. preinstalled JDK 11 - verify by running java "java -version" from Terminal
2. preinstlled maven 3.6.3 - verify by runnning "mvn -v" from Terminal
3. Access to internet 
4. Git  - able to checkout git project

Description
===========
- A Java application built on jdk11 using maven which takes input as filename (absolute path), then reads the content of the file and returns the distinct words and their count in a descensing order.
- Maven is used for dependency/build management
- Intellj IDE for development
- It was built on MAC OS 


How to Run
===========
1. Download the application from git location : https://github.com/abhishek2803/WordCountApp.git using command "git clone https://github.com/abhishek2803/WordCountApp.git" into a directory named "WordCountApp"
2. Using terminal, navigate to folder WordCountApp and make sure you are under the directory
3. In order to run the Main method you can use one of the 2 ways :
      a. If you want to run the Main class using your own file then use ->  mvn compile exec:java -Dexec.mainClass="com.as.wordcount.Main" -Dexec.args="/Users/abhisheksingh/Projects/file.txt"
      <img width="1680" alt="image" src="https://user-images.githubusercontent.com/9560912/231017347-fb42a993-e4e8-4c70-a670-be7e4be25aa3.png">

      b. The file is already there in the root directory so you can run it without giving the argument by running the following -> mvn compile exec:java -Dexec.mainClass="com.as.wordcount.Main"
      <img width="847" alt="image" src="https://user-images.githubusercontent.com/9560912/231017272-ababe6d2-88ae-46ed-8769-789a39060f91.png">


