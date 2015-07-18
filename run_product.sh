#!/bin/bash +e

cd java_src/Testng

/home/ubuntu/jdk1.7.0_79/bin/javac -cp .:lib/* TestClass.java
/home/ubuntu/jdk1.7.0_79/bin/java -cp .:lib/* org.junit.runner.JUnitCore TestClass 
