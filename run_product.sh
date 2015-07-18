#!/bin/bash +e

cd java_src/Testng

javac -cp .:lib/* TestClass.java
java -cp .:lib/* org.junit.runner.JUnitCore TestClass 
