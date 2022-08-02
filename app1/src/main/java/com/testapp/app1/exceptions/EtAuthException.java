package com.testapp.app1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class EtAuthException extends RuntimeException{

    public EtAuthException(String msg){
        super(msg);
        System.out.println(msg);
    }
}
