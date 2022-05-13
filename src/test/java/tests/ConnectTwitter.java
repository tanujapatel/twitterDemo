package tests;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class ConnectTwitter {
	public static Twitter twitter;

	public void getTwitterinstance() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("consumer key")
		  .setOAuthConsumerSecret("consumer secret")
		  .setOAuthAccessToken("access token")
		  .setOAuthAccessTokenSecret("access token secret");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}
	
	public static void searchtweets(String queryString) throws TwitterException {
		StringBuilder strToConvert = new StringBuilder();
		int spltAtChar = 50, counter = 1, tweetsCount; 
		String tweetStr;
		
	    Query query = new Query(queryString);
	    QueryResult result = twitter.search(query);
	    
	    tweetsCount = result.getCount();

		System.out.println(tweetsCount+""+result.getTweets());
	    
		  for (Status status : result.getTweets()) { 
			  System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
			  strToConvert.append(status.getText());
		  
			  while(strToConvert.length()>spltAtChar) { 
				  tweetStr = "@"+status.getUser().getScreenName() +" "+ counter +"/"+ tweetsCount + strToConvert.substring(0,spltAtChar);
				  System.out.println(tweetStr);
				  createTweet(tweetStr);
				  
				  strToConvert.substring(spltAtChar); 
				  counter++;
			  }
		  tweetStr = "@"+status.getUser().getScreenName()+" "+ counter +"/"+tweetsCount + strToConvert.toString();
		  System.out.println(tweetStr); 
		  createTweet(tweetStr);
		  }
	}
	
	public static void createTweet(String tweet) throws TwitterException { 
		Status status = twitter.updateStatus(tweet); 
	}
}