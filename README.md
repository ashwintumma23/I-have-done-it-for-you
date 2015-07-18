# LinkedInHackDay
IHDITFY - I have done it for you : Code repository for automation tool that we built at the LinkedIn Hack Day

### IHDIFY: I have done it for you - Increasing Developer Productivity
`I have done it for you` is a tool which runs automated test suites on a product, and looks for errors in the logs. All errors identified are noted, and a issue is created in [GitHub](https://github.com/ashwintumma23/LinkedInHackDay) on the product's code repository and on [Atlassian Jira Project](https://linkedinhackday.atlassian.net/projects/LHD).

### Build Status
[![Build Status](http://ec2-52-10-66-119.us-west-2.compute.amazonaws.com:8080/job/LinkedInHackDay/badge/icon)](http://ec2-52-10-66-119.us-west-2.compute.amazonaws.com:8080/job/LinkedInHackDay) IHDIFY Jenkins Build

### Contributors
Team Name: [Pizzazz](https://www.google.com/search?q=pizzazz) 

Ashwin Tumma - ashwin.tumma23@gmail.com

Nikhil Ambekar - nikhil.a.ambekar@gmail.com

Computer Science Graduate Students,

Stony Brook University, New York

### Why?
Why did we build this hack? Simple, because, we wish we had it :smile: After a collective experience of around 5 years in the industry, we observed, that usually, when there are build failures, the first task that developers do, is to browse to the Output Console of the Continuous Delivery tool ([Jenkins](http://ec2-52-10-66-119.us-west-2.compute.amazonaws.com:8080/job/LinkedInHackDay/) in our case) and check for the error logs. The Output Console usually, has a stack trace printed highlighting the reason of failure. Of course, if the error is trivial, it is easy to fix; but in most of the cases, the developer heads to a programmer aid website like StackExchange. So, we thought that why not integrate all the above steps, present a consolidated console to the developer. Thus, IHDIFY!

Additionally, since, a issue is created, in either Jenkins or Jira, for the build error, the entire engineering team can align together including the developers, managers, and product management. We strongly believe that, if such an integration tool is made available to the developers, we can definitely optimize the mundane tasks of the engineering team, thus contributing to increase in productivity! Having said that, there are umpteen possible enhancements that are possible to this tool, again left to the imagination of teams! 

### How it works
In this section, we elaborate upon how the tool works. For demonstation purposes we have two applications which create log files for any issues faced during their core program execution and during test cases.

##### Java Application
The Twitter REST API application uses [twitter4j](http://twitter4j.org) to fetch followers for the user, fetch recent tweets, Geolocation based tweet search. Each operation is an independent test case and logs to error file upon exception. Open building the project the tools parses the log files and logs on exceptions to Github Issues, Atlassian Jira Issues depending on the build number. The issue is searched using Stackoverflow API for possible fixes. The issue description contains the Stackoverflow links for the possible fixes.

##### Python Application
On similar lines to Java application, the Python application is also failed deliberately, so that there are exceptions raised. Instead of failing the build completely, we make the build unstable, in order to indicate the fact that there were issues seen. 

Again, the choice of whether to fail the build, or to make it unstable, will be dependent on the implementing teams.

### Infrastructural Details
Public API's used: [Github](https://developer.github.com/v3/), [Atlassian Jira](https://docs.atlassian.com/jira/REST/latest/), [Stack Exchange](https://api.stackexchange.com/)
Jenkins Runs on : Amazon EC2
Altassian Jira: Free Edition on Atlassian Cloud
