package dev.simpleapp.twitter.user.tweet.repository;

import dev.simpleapp.twitter.user.profile.model.UserProfile;
import dev.simpleapp.twitter.user.tweet.model.Tweet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findAllByUserProfile(UserProfile userProfile, Pageable pageable);
}
