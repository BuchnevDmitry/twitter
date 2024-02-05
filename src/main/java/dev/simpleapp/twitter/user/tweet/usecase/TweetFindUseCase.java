package dev.simpleapp.twitter.user.tweet.usecase;

import dev.simpleapp.twitter.user.tweet.web.model.TweetFindRequest;
import dev.simpleapp.twitter.user.tweet.web.model.TweetResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;

@Validated
public interface TweetFindUseCase {
    Collection<TweetResponse> findTweets(@Valid TweetFindRequest findRequest);
}
