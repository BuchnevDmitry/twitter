package dev.simpleapp.twitter.user.tweet.service.impl;

import dev.simpleapp.twitter.user.profile.model.UserProfile;
import dev.simpleapp.twitter.user.tweet.model.Tweet;
import dev.simpleapp.twitter.user.tweet.repository.TweetRepository;
import dev.simpleapp.twitter.user.tweet.service.TweetService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet updateTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Optional<Tweet> findTweetById(long tweetId) {
        return tweetRepository.findById(tweetId);
    }

    @Override
    public void deleteTweet(long tweetId) {
        tweetRepository.deleteById(tweetId);
    }

    @Override
    public Collection<Tweet> findAllTweets(UserProfile owner, Pageable pageable) {
        return tweetRepository.findAllByUserProfile(owner, pageable);
    }
}
