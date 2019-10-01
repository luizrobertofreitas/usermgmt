package com.usermgmt.resources;

import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserResource {

  @GetMapping("/ping")
  public ResponseEntity ping() {
    return ResponseEntity.ok("Ping at: " + LocalDateTime.now());
  }

}
