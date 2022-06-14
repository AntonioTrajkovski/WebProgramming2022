package mk.ukim.finki.wbaud.service;

import mk.ukim.finki.wbaud.model.User;

public interface AuthService {

    User login(String username, String password);


}
