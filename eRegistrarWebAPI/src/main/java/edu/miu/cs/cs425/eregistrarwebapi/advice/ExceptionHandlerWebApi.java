package edu.miu.cs.cs425.eregistrarwebapi.advice;

import edu.miu.cs.cs425.eregistrarwebapi.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerWebApi {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MyException.class)
    public Map<String,String> handlerNotFoundException(MyException exception){
        Map<String,String> errorMap= new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage());

        return errorMap;
    }
}
