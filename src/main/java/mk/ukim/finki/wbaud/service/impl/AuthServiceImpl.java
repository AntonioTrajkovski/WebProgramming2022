package mk.ukim.finki.wbaud.service.impl;

import mk.ukim.finki.wbaud.model.User;
import mk.ukim.finki.wbaud.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.wbaud.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.wbaud.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.wbaud.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.wbaud.repository.impl.InMemoryUserRepository;
import mk.ukim.finki.wbaud.repository.jpa.UserRepository;
import mk.ukim.finki.wbaud.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;


    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public User login(String username, String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            throw new InvalidArgumentException();
        }

        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialsException::new);
    }

}
