package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 355. Design Twitter
 * @author hzf
 * @see https://leetcode-cn.com/problems/design-twitter/
 */
public class Twitter {
	private static long cur = 0L;
	
	private Map<Integer, Set<Integer>> followShip;
	
	private Map<Integer, List<Tweet>> feedShip;
	
	/** Initialize your data structure here. */
    public Twitter() {
        followShip = new HashMap<>();
        feedShip = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	Tweet tweet = new Tweet(tweetId, cur++);
    	LinkedList<Tweet> tweetList;
    	if(!feedShip.containsKey(userId)){
    		tweetList = new LinkedList<>();
    	}else{
    		tweetList = (LinkedList<Tweet>) feedShip.get(userId);
    	}
    	for(Tweet temp : tweetList){
    		if(temp.getId() == tweetId){
    			return;
    		}
    	}
    	tweetList.addFirst(tweet);
    	if(tweetList.size() > 10){
    		tweetList.removeLast();
    	}
    	feedShip.put(userId, tweetList);
    }

	/** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	LinkedList<Tweet> source = (LinkedList<Tweet>) feedShip.get(userId);
    	LinkedList<Tweet> list = new LinkedList<>();
    	if(source != null){
    		list.addAll(source);
    	}
        if(followShip.containsKey(userId)){
        	Iterator<Integer> iter = followShip.get(userId).iterator();
        	while(iter.hasNext()){
        		List<Tweet> tweets = feedShip.get(iter.next());
        		if(tweets != null){
	        		for(Tweet tweet : tweets){
	        			if(list.size() < 10){
	        				int i = 0;
	        				while(i < list.size() && tweet.getTime() < list.get(i).getTime()){
	        					i++;
	        				}
	        				list.add(i, tweet);
	        			}else if(list.size() >= 10 && list.getLast().getTime() > tweet.getTime()){
	        				break;
	        			}else{
	        				int i = 0;
	        				while(i < list.size() && tweet.getTime() < list.get(i).getTime()){
	        					i++;
	        				}
	        				list.add(i, tweet);
	        				list.removeLast();
	        			}
	        		}
        		}
        	}
        }
        
        List<Integer> result = new ArrayList<>(10);
        for(Tweet tweet : list){
        	result.add(tweet.getId());
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if(followerId == followeeId){
    		return;
    	}
    	Set<Integer> set;
        if(followShip.containsKey(followerId)){
        	set = followShip.get(followerId);
        }else{
        	set = new HashSet<Integer>();
        }
        set.add(followeeId);
        followShip.put(followerId, set);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followShip.get(followerId);
        if(set != null && !set.isEmpty()){
        	set.remove(followeeId);
        	followShip.put(followerId, set);
        }
    }
    
    class Tweet{
    	private int id;
    	private long time;
    	public Tweet(int id, long time){
    		this.id = id;
    		this.time = time;
    	}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public long getTime() {
			return time;
		}
		public void setTime(long time) {
			this.time = time;
		}
    }

	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5);
		twitter.follow(1, 1);
		twitter.postTweet(1, 5);
		System.out.println(twitter.getNewsFeed(1));
	}

}
