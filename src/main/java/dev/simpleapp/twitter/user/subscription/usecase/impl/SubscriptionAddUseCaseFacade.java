package dev.simpleapp.twitter.user.subscription.usecase.impl;

import dev.simpleapp.twitter.user.profile.model.UserProfile;
import dev.simpleapp.twitter.user.subscription.mapper.SubscribeRequestToSubscriptionMapper;
import dev.simpleapp.twitter.user.subscription.model.Subscription;
import dev.simpleapp.twitter.user.subscription.service.SubscriptionService;
import dev.simpleapp.twitter.user.subscription.usecase.SubscriptionAddUseCase;
import dev.simpleapp.twitter.user.subscription.web.model.SubscribeRequest;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionAddUseCaseFacade implements SubscriptionAddUseCase {

    private final SubscribeRequestToSubscriptionMapper subscriptionMapper;
    private final SubscriptionService subscriptionService;

    public SubscriptionAddUseCaseFacade(SubscribeRequestToSubscriptionMapper subscriptionMapper,
                                        SubscriptionService subscriptionService) {
        this.subscriptionMapper = subscriptionMapper;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public void subscribe(SubscribeRequest subscribeRequest) {
        Subscription subscription = subscriptionMapper.map(subscribeRequest);
        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();

        if (follower.equals(followed)) {
            throw new RuntimeException("Подписка на самого себя не имеет никакого смысла!");
        }

        if(subscriptionService.existsSubscription(subscription)) {
            String errorMessage = String.format(
                    "Вы уже подписаны на %s,",
                    followed.getNickname()
            );
            throw new RuntimeException(errorMessage);
        }

        subscriptionService.createSubscription(subscription);
    }
}
