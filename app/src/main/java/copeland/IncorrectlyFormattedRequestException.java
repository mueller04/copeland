package copeland;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Incorrectly Formatted Request")  // 100
public class IncorrectlyFormattedRequestException extends RuntimeException {
}
