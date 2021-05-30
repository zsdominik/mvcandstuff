package com.zsirosd.mvcandstuff.controller.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorControllerAdvisor {

  @ExceptionHandler(NoHandlerFoundException.class)
  public ModelAndView handle(Exception ex) {

    var modelAndView = new ModelAndView();
    modelAndView.addObject("message", ex.getMessage());
    modelAndView.setViewName("error/404");

    return modelAndView;
  }

}
