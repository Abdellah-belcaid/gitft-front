package ma.fsa.appwebcadeaux.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PanierNotFoundException extends Exception {

    public PanierNotFoundException(String message) {
        super(message);
    }
}
