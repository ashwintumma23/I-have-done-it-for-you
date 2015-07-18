# Script for parsing the standard error files generated by 
# Java and Python programs
import requests 
import os

def parse_java_logs():
	
	currentJavaExceptions = []
	# Open java log file and parse till the exception is detected
	fjava = open("java_src/Testng/test.log","r")
	for line in fjava:
		if "Exception" in line:
			exception_query_string = line.split(":")[0].strip()
			
			if exception_query_string in currentJavaExceptions:
				continue
			else:
				currentJavaExceptions.append(exception_query_string)
				stackExItems = queryStackExchange(exception_query_string)
				createGitHubIssue(exception_query_string, stackExItems)
				
	fjava.close()

def parse_python_logs():
	# Open Python log file and parse till the exception is detected
	fpython = open("python_src/python_program_log.log","r")
	for line in fpython:
		if "Error" in line:
			exception_query_string = line.strip()
			stackExItems = queryStackExchange(exception_query_string)
			createGitHubIssue(exception_query_string, stackExItems)
				
def queryStackExchange(query):
	stackExItems = []
        url = "https://api.stackexchange.com/2.2/search/advanced?order=desc&sort=activity&q="+query.strip()+"&site=stackoverflow"
        with requests.Session() as session:
                json_response = session.get(url).json()
	stackExItems.append(json_response['items'][0]['link'])
	stackExItems.append(json_response['items'][1]['link'])
	stackExItems.append(json_response['items'][2]['link'])
	stackExItems.append(json_response['items'][3]['link'])
	return stackExItems	

def createGitHubIssue(exception_query_string, stackExItems):
	jenkins_build_number = os.environ.get('BUILD_NUMBER')
	jenkins_build_url = os.environ.get('BUILD_URL')
	curl_command = 'curl --user "ashwintumma23:APGA2dPD" -i -d \'{"title": "Build '+jenkins_build_number+' Error: '+exception_query_string+'","body": "The Jenkins build failed with the exception marked in the title. \\nView the complete error log at: [Jenkins Build '+jenkins_build_number+'](['+jenkins_build_url+'])\\n\\nWe have the following possible solutions on Stack Exchange which match the Exception.\\n'+str(stackExItems[0])+'\\n'+str(stackExItems[1])+'","labels": ["bug"]}\' https://api.github.com/repos/ashwintumma23/LinkedInHackDay/issues'
	os.system(curl_command)
	print "Done Logging issue on Github Repository"

def main():
	parse_java_logs()
	parse_python_logs()

main()
