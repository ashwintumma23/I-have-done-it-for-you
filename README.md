# LinkedInHackDay
IHDITFY - I have done it for you : Code repository for automation tool that we built at the LinkedIn Hack Day

### IHDIFY: I have done it for you
`I have done it for you` is a tool which runs automated test suites on a product, and looks for errors in the logs. All errors identified are noted, and a issue is created in GitHub on the product's code repository.

### Build Status
[![Build Status](http://ec2-52-10-66-119.us-west-2.compute.amazonaws.com:8080/job/LinkedInHackDay/badge/icon)](http://ec2-52-10-66-119.us-west-2.compute.amazonaws.com:8080/job/LinkedInHackDay) IHDIFY Jenkins Build

### Contributors
Ashwin Tumma - ashwin.tumma23@gmail.com
Nikhil Ambekar - nikhil.a.ambekar@gmail.com
Computer Science Graduate Students,
Stony Brook University, New York

### How it works
In this section, we elaborate upon how the tool works

For demonstation purposes we have two applications which log on to the log files for any issues faced during execution of test cases.

The twitter rest api application uses [twitter4j](http://twitter4j.org) to fetch 
