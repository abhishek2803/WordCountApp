# WordCountApp

Prerequisites
============
1. preinstalled JDK 11 - verify by running java "java -version" from Terminal
2. preinstlled maven 3.6.3 - verify by runnning "mvn -v" from Terminal
3. Access to internet 
4. Git  - able to checkout git project


Repository contains included:
===========

1. SRC - 
      a. contains java classes under main/java/om/as/wordcount. Main.java contains the main method. There are couple of Java interface namely FieReader.java and WordCountService.java. DefaultFieReader constructor takes filePath as argument to initialise. It has a readContent mentod which reads the content of the file and returns the content. If file is not found, then it throws FileHandlingExcpetion(Runtime). Second interface is WordCountService which has a default implementation namely DefaultWordCountService.java, it is a no argument constructor. Then it uses java11 stream and collectors api to convert it into a List of a immutable DTO object WordCount in a descending order. Each WordCount DTO object contains Word and its Count.
      b.test folder contains junit classes and resources.
      c. Validation is used to make no null content or filename is passed to the methods. If file not found then FileHandlingExcpetion is throwns. 
      d. 
2. target directory which is generated while packaging the maven project. This primarly contains containing compiled files, executable jar, executable jar with dependencies, junit test classes and report. This is generated when  maven build life cycle commands are run.
3. README file - description 
4. pom.xml - contains the dependency and build management. 
      a. For project dependency - Used lombok for annotation, junit5 and assertj for junit test class, logback for logging.  
      b. For build, assemply plugins for generating jar with dependecies was used. Jacoco plugin for generating junit test covergage report etc were used



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
3. In order to execute the Application, you can use one of the 2 ways :
      a. If an external file has to be passed as argument ->  mvn compile exec:java -Dexec.mainClass="com.as.wordcount.Main" -Dexec.args="/Users/abhisheksingh/Projects/file.txt"
      <img width="1680" alt="image" src="https://user-images.githubusercontent.com/9560912/231017347-fb42a993-e4e8-4c70-a670-be7e4be25aa3.png">

      b. If not argument is passed , Then the Application will use a default file present in the root directory  -> mvn compile exec:java -Dexec.mainClass="com.as.wordcount.Main"
      <img width="847" alt="image" src="https://user-images.githubusercontent.com/9560912/231017272-ababe6d2-88ae-46ed-8769-789a39060f91.png">

4. In order to see the junit coverage report, run command "mvn clean package" under the project directory WordCountApp. You should see all the junit test cases ran successfully and coverage report generated as below:
![image](https://user-images.githubusercontent.com/9560912/231019395-b3e94786-1777-48d6-85ce-d61111fe6b8f.png)

Some important highlights of file produced are as below:
WordCountApp/target/wordcount-1.0-SNAPSHOT-jar-with-dependencies.jar - executable jar with the maven dependencies
WordCountApp/target/wordcount-1.0-SNAPSHOT.jar - executable jar  without the dependency
WordCountApp/target/test-classes - compiled test classes
WordCountApp/target/site/jacoco/index.html - jacoco test covergae report

5. If you want to run using the JAR file
 Goto root project folder and execute :  java -cp target/wordcount-1.0-SNAPSHOT-jar-with-dependencies.jar  com.as.wordcount.Main
 
![image](https://user-images.githubusercontent.com/9560912/231026726-c641cd71-c7fb-462a-a1b3-2dca202c9374.png)




