package com.zsirosd.mvcandstuff.view.resolver;

import com.zsirosd.mvcandstuff.view.BoldView;
import com.zsirosd.mvcandstuff.view.CustomView;
import com.zsirosd.mvcandstuff.view.ItalicView;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class CustomViewResolver implements ViewResolver, Ordered {
  @Override
  public View resolveViewName(String s, Locale locale) throws Exception {

    switch (s) {
      case "custom":
        return new CustomView();
      case "italic":
        return new ItalicView();
      case "bold":
        return new BoldView();
      default:
        return null;
    }
  }

  @Override
  public int getOrder() {
    return 0;
  }
}
