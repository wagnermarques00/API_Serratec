package org.serratec.projeto05.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    //private static final

    @ExceptionHandler(value
            = {ClienteException.class})
    protected ResponseEntity<Object> naoEncontrado(ClienteException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        apiError.setDebugMessage(ex.getLocalizedMessage());
//	       LOGGER.error(ex.getMessage(), ex);
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new R
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        private ResponseEntity<Object> buildResponseEntity (ApiError apiError){
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }

        private ResponseEntity<Object> buildResponseEntity (ApiError apiError){
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }

        @ExceptionHandler(value
                = {ClienteException.class})
        protected ResponseEntity<Object> naoEncontrado (ClienteException ex){
            ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
            apiError.setMessage(ex.getMessage());
            apiError.setDebugMessage(ex.getLocalizedMessage());
            return buildResponseEntity(apiError);
        }
        private ResponseEntity<Object> buildResponseEntity (ApiError apiError){
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }
    }
