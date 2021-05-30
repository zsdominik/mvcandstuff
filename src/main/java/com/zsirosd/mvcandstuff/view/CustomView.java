package com.zsirosd.mvcandstuff.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class CustomView implements View {
  @Override
  public String getContentType() {
    return "text/html";
  }

  @Override
  public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/html");
    PrintWriter writer = response.getWriter();

    writer.print("Hello World from CustomView</br>");
    var msg =
            null != model.get("message")
                    ? model.get("message").toString()
                    : "No query param, use ?message=something";

    writer.print("Your query param is: " + msg);
  }
}
