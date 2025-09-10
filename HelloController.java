package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Value("${app.welcome:Hello from Kubernetes!}")
  private String welcome;

  @GetMapping("/")
  public String hello() {
    return welcome + " (pod: " + System.getenv("HOSTNAME") + ")";
  }

  @GetMapping("/health")
  public String health() {
    return "OK";
  }
}
