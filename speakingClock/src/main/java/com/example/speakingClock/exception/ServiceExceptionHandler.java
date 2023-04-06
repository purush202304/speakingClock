package com.example.speakingClock.exception;

import com.example.speakingClock.response.ApiError;
import lombok.val;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Component
public class ServiceExceptionHandler {

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handle(MissingServletRequestParameterException exception, WebRequest request){
        val errorMessage = exception.getLocalizedMessage();
        return buildResponse(HttpStatus.BAD_REQUEST,errorMessage,getRequestURI(request));
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handle(MethodArgumentTypeMismatchException exception, WebRequest request){
        val errorMessage = exception.getLocalizedMessage();
        return buildResponse(HttpStatus.BAD_REQUEST,errorMessage,getRequestURI(request));
    }


    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handle(Exception exception, WebRequest request){
        val errorMessage =exception.getLocalizedMessage();
        return buildResponse(HttpStatus.BAD_REQUEST,errorMessage,getRequestURI(request));
    }

    private ResponseEntity<ApiError> buildResponse(HttpStatus httpStatus,String errorMessage,String requestURI) {
        ApiError response = new ApiError(httpStatus, errorMessage, requestURI);
        return new ResponseEntity<>(response,httpStatus);
    }

    private String getRequestURI(WebRequest request){
        return ((ServletWebRequest)request).getRequest().getRequestURI();
    }

}
