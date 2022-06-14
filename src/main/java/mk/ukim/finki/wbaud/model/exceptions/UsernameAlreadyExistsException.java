package mk.ukim.finki.wbaud.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{

     public UsernameAlreadyExistsException(String userName){
         super(String.format("User with username: %s already exists", userName));
     }

}
