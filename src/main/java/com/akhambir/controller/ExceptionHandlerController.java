package com.akhambir.controller;


import com.akhambir.controller.exceptions.UserAlreadyRegisteredException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Throwable.class)
    public ModelAndView handleAll() {
        ModelAndView m = new ModelAndView();
        m.setViewName("error");
        return m;
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public ResponseEntity<String> alreadyRegistered() {
        return ResponseEntity.status(409).body("User already registered");
    }
}
