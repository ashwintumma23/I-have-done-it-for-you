
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.GeoLocation;
import twitter4j.IDs;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TestClass {
	public static Logger logger = LoggerFactory.getLogger(TestClass.class);
	public static Twitter twitter;

	@BeforeClass
	public static void initialize(){
		try{
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("Q1zQ7csF8Uz2zvIOem3aZ5laQ")
				.setOAuthConsumerSecret(
						"Y1FbEdIuvRmsWcXKavj1yoKaK24ffui6SXQpWa6onhNkbX4RQa")
				.setOAuthAccessToken(
						"115901786-Nufx3VUyLt3WrMnnSCRzwUBJVvOq5hBbRfXaYv5Q")
				.setOAuthAccessTokenSecret(
						"BSKW0LJOcHGoUkftxQLWH51DzdwAMcmrnUiAi3RC6ru4b");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
		}catch(Exception e){
			logger.error("Issue with token ",shortenedStackTrace(e,1));
		}
	}

	@Test
	public void getHomeTimeline() {
		try {
			logger.info("logged in as {}", twitter.getScreenName());
			List<Status> list = null;
			list = twitter.getHomeTimeline();
			for (Status each : list) {

				/*System.out.println("Sent by: @"
						+ each.getUser().getScreenName() + " - "
						+ each.getUser().getName() + "\n" + each.getText()
						+ "\n");*/
			}
		} catch (TwitterException e) {
			logger.error("Issue with twitter4j getTimeline", shortenedStackTrace(e,1));
		}

	}

	@Test
	public void test() {
		logger.info("Fetching location tweets from San fransisco");
		try {
			Query query = new Query().geoCode(
					new GeoLocation(37.7833, 122.4167), 10, "km");
			query.count(15); // You can also set the number of tweets to return
								// per page, up to a max of 100
			QueryResult result = twitter.search(query);
			List<Status> list = result.getTweets();
			for (Status each : list) {

				System.out.println("Sent by: @"
						+ each.getUser().getScreenName() + " - "
						+ each.getUser().getName() + "\n" + each.getText()
						+ "\n");
			}
		} catch (TwitterException e) {
			logger.error("Issue with twitter4j getTimeline", e);
		}

	}
	
	@Test
	public void fetchFollowers(){
		logger.info("Fetching location tweets from San fransisco");
		try {
			
			long cursor =-1L;
	        IDs ids;
	        do {
	            ids = twitter.getFollowersIDs("srbachchan",cursor);
	            for(long userID : ids.getIDs()){
	            	twitter.showUser(userID).getName();
	            }
	        } while((cursor = ids.getNextCursor())!=0 );
			
		} catch (TwitterException e) {
			logger.error("Issue with twitter4j followers", e);
		}

	}
	
	public static String shortenedStackTrace(Exception e, int maxLines) {
	    StringWriter writer = new StringWriter();
	    e.printStackTrace(new PrintWriter(writer));
	    String[] lines = writer.toString().split("\n");
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < Math.min(lines.length, maxLines); i++) {
	        sb.append(lines[i]).append("\n");
	    }
	    return sb.toString();
	}

}
