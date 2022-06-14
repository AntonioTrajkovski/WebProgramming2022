package mk.ukim.finki.wbaud.service;

import mk.ukim.finki.wbaud.model.Role;
import mk.ukim.finki.wbaud.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {

    User register(String username, String password,
                  String repeatPassword, String name, String surname,
                  Role role);

}
