package dev.simpleapp.twitter.security.mapper;

import dev.simpleapp.twitter.security.model.UserAccount;
import dev.simpleapp.twitter.security.web.model.RegisterRequest;

public interface RegisterRequestToUserAccoundMapper extends Mapper<UserAccount, RegisterRequest> {
}
