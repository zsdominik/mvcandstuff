package com.zsirosd.mvcandstuff.controller.secured;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/secured")
public class SecuredController {

  @GetMapping("/my-secret")
  public ModelAndView myHiddenShame() {
    return new ModelAndView("secret_page");
  }

}
