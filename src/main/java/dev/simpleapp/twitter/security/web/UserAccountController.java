package dev.simpleapp.twitter.security.web;

import dev.simpleapp.twitter.security.model.UserAccount;
import dev.simpleapp.twitter.security.usecase.RegisterUserAccountUseCase;
import dev.simpleapp.twitter.security.web.model.RegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class UserAccountController {

    private final RegisterUserAccountUseCase registerUserAccountUseCase;

    public UserAccountController(RegisterUserAccountUseCase registerUserAccountUseCase) {
        this.registerUserAccountUseCase = registerUserAccountUseCase;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);

        this.registerUserAccountUseCase.register(registerRequest);
    }
}
