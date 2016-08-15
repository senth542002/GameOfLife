package com.java.tutorial.Practice;

public class TwitterUser {
	
	String twitterHandle;
	Integer numberOfTweets;

	public TwitterUser(String twitterHandle) {
		this.twitterHandle = twitterHandle;
	}
	
	public void incrementCount(){
		numberOfTweets++;
	}

	public Integer getNumberOfTweets() {
		return numberOfTweets;
	}
	

}
