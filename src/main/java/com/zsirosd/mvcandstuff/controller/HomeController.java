package com.zsirosd.mvcandstuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @GetMapping("/home")
  @ResponseBody
  public String home() {
    return "home";
  }

  @GetMapping("/custom")
  public ModelAndView custom(@RequestParam(required = false) String message) {
    return new ModelAndView("custom", "message", message);
  }

  @GetMapping("/bold")
  public ModelAndView toBold(@RequestParam(required = false) String message) {
    return new ModelAndView("bold", "message", message);
  }

  @GetMapping("/italic")
  public ModelAndView toItalic(@RequestParam(required = false) String message) {
    return new ModelAndView("italic", "message", message);
  }

  @GetMapping("/home-jsp")
  public ModelAndView homeJsp(@RequestParam String message) {
    return new ModelAndView("home", "message", message);
  }
}
