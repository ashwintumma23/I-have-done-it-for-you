import json
import requests 
import urllib2 


def queryStackExchange():
	url = "https://api.stackexchange.com/2.2/search/advanced?order=desc&sort=activity&q=ZeroDivisionError: integer division or modulo by zero&site=stackoverflow"
	with requests.Session() as session:
		js_response = session.get(url).json()
		print js_response['items'][0]['link']
		print js_response['items'][1]['link']
		print js_response['items'][2]['link']
		print js_response['items'][3]['link']
		print js_response['items'][4]['link']
		print js_response['items'][5]['link']

queryStackExchange()
