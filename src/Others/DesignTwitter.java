package Others;

import java.util.*;

public class DesignTwitter {
    public static void main(String[] args) {
        DesignTwitter twitter = new DesignTwitter();
//        twitter.postTweet(1, 4);
//        twitter.postTweet(2, 5);
//        twitter.unfollow(1, 2);
//        twitter.follow(1, 2);
        twitter.getNewsFeed(1).stream().forEach(System.out::println);
    }

    private HashMap<Integer, Set<Integer>> followMap;
    private HashMap<Integer, List<TweetData>> tweetMap;
    private int count;

    public DesignTwitter() {
        this.count = 0;
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        this.count++;
        List<TweetData> tweetData;
        if (this.tweetMap.containsKey(userId)) {
            tweetData = this.tweetMap.get(userId);
        } else {
            tweetData = new ArrayList<>();
        }
        tweetData.add(new TweetData(tweetId, this.count));
        this.tweetMap.put(userId, tweetData);
        follow(userId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<UserNewsFeed> maxHeap = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(o -> o.count)));
        List<Integer> result = new ArrayList<>();
        Set<Integer> followers = this.followMap.get(userId);
        if (followers == null) {
            return new ArrayList<>();
        }
        for (Integer followee : followers) {
            if (this.tweetMap.containsKey(followee)) {
                int idx = this.tweetMap.get(followee).size() - 1;
                List<TweetData> followeeTweetData = this.tweetMap.get(followee);
                maxHeap.add(new UserNewsFeed(idx - 1, followeeTweetData.get(idx).tweetId, followee, followeeTweetData.get(idx).count));
            }
        }
        while (!maxHeap.isEmpty() && result.size() < 10) {
            UserNewsFeed newsFeed = maxHeap.poll();
            result.add(newsFeed.tweetId);
            if (newsFeed.index >= 0) {
                TweetData tweetData = this.tweetMap.get(newsFeed.followeeId).get(newsFeed.index);
                maxHeap.add(new UserNewsFeed(newsFeed.index - 1, tweetData.tweetId, newsFeed.followeeId, tweetData.count));
            }
        }
        return result;
    }

    public static class TweetData {
        int tweetId;
        int count;

        TweetData(int tweetId, int count) {
            this.count = count;
            this.tweetId = tweetId;
        }

    }

    public static class UserNewsFeed {
        int index;
        int tweetId;
        int followeeId;
        int count;

        UserNewsFeed(int index, int tweetId, int followeeId, int count) {
            this.index = index;
            this.followeeId = followeeId;
            this.tweetId = tweetId;
            this.count = count;
        }
    }

    public void follow(int followerId, int followeeId) {
        if (this.followMap.containsKey(followerId)) {
            this.followMap.get(followerId).add(followeeId);
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(followeeId);
            this.followMap.put(followerId, set);
        }

    }

    public void unfollow(int followerId, int followeeId) {
        if (this.followMap.containsKey(followerId) && this.followMap.get(followerId).contains(followeeId)) {
            this.followMap.get(followerId).remove(followeeId);
        }
    }
}
