package mk.ukim.finki.wbaud.model.exceptions;

public class InvalidUserCredentialsException extends  RuntimeException{

    public InvalidUserCredentialsException(){
        super("Invalid user credentials");
    }

}
