#!/bin/bash +e

# Run Java Application, and its JUnit Test Cases 
cd java_src/Testng
/home/ubuntu/jdk1.7.0_79/bin/javac -cp .:lib/* TestClass.java
/home/ubuntu/jdk1.7.0_79/bin/java -cp .:lib/* org.junit.runner.JUnitCore TestClass 

# Run tool for parsing the logs and in case of errors, log errors to Github Issues
cd ../../
pwd
python validate_src/parseLogFiles.py > /dev/null
