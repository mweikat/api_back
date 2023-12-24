package cl.back.api.src.exceptions.admin;

import cl.back.api.src.exceptions.ErrorResponse;
import cl.back.api.src.exceptions.customs.UserExistHandler;
import cl.back.api.src.exceptions.customs.UserWrongOldPassHandler;
import cl.back.api.src.messages.UserMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(basePackages = "cl.back.api.src.admin.user")
public class UserExceptionHandler extends ResponseEntityExceptionHandler {


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

    @ExceptionHandler(UserWrongOldPassHandler.class)
    public ResponseEntity<Object> wrongPassHandler(HttpServletRequest req, UserWrongOldPassHandler ex){
        return buildResponseEntity(new ErrorResponse(HttpStatus.UNAUTHORIZED, UserMessage.WRONG_PASS));
    }
    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
    }
}
