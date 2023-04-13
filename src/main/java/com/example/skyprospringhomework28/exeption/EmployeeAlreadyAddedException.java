package com.example.skyprospringhomework28.exeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class EmployeeAlreadyAddedException extends RuntimeException{
}
