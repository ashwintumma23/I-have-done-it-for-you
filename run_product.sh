#!/bin/bash +e

# Run Java Application, and its JUnit Test Cases 
cd java_src/Testng
/home/ubuntu/jdk1.7.0_79/bin/javac -cp .:lib/* TestClass.java
/home/ubuntu/jdk1.7.0_79/bin/java -cp .:lib/* org.junit.runner.JUnitCore TestClass 

cd ../../python_src
# Run Python Application, and wait for the errors to pop up
python python_sample_code.py > python_output.output 2> python_program_log.log

# Run tool for parsing the logs and in case of errors, log errors to Github Issues
cd ../
python validate_src/parseLogFiles.py > /dev/null
