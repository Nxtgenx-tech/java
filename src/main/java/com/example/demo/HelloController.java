package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @Value("${app.welcome:Hello from Kubernetes!}")
  private String welcome;

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("welcome", welcome);
    model.addAttribute("pod", System.getenv("HOSTNAME"));
    return "index";
  }

  // keep simple health endpoint for readiness/liveness checks
  @GetMapping("/health")
  @ResponseBody
  public String health() {
    return "OK";
  }
}
