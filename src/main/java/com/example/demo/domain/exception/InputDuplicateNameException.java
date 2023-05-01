package com.example.demo.domain.exception;

//
public class InputDuplicateNameException extends RuntimeException{

    public InputDuplicateNameException(){
        super("Error : already have same name food");
    }

}
