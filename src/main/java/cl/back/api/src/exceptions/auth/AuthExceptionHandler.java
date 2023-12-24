package cl.back.api.src.exceptions.auth;

import cl.back.api.src.exceptions.ErrorResponse;
import cl.back.api.src.exceptions.customs.UserExistHandler;
import cl.back.api.src.exceptions.customs.UserNotExistHandler;
import cl.back.api.src.messages.AuthMessages;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(basePackages = "cl.back.api.src.auth")
public class AuthExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserExistHandler.class)
    public ResponseEntity<Object> handleUserHandler(HttpServletRequest req, UserExistHandler ex){
        return buildResponseEntity(new ErrorResponse(HttpStatus.CONFLICT, AuthMessages.USER_EXISTS));
    }

    @ExceptionHandler(UserNotExistHandler.class)
    public ResponseEntity<Object> handleUserNotExists(HttpServletRequest req, UserNotExistHandler ex){
        return buildResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND, AuthMessages.USER_NOT_EXISTS));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleUserHandler(HttpServletRequest req, BadCredentialsException ex){
        return buildResponseEntity(new ErrorResponse(HttpStatus.UNAUTHORIZED, AuthMessages.USER_WRONG_CREDENCIALS));
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        String field = ex.getFieldErrors().get(0).getField();
        //List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError->fieldError.getDefaultMessage()).collect(Collectors.toList());
        ErrorResponse errorResponse = new ErrorResponse((HttpStatus) status,field+": "+errorMessage);
        return buildResponseEntity(errorResponse);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
    }

}
