package com.usermgmt.resources.users.v2;

import com.usermgmt.model.entities.UserEntity;
import com.usermgmt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller("userResourceV2")
@RequestMapping("/v2/users")
public class UserResource {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity post(@RequestBody final UserEntity user) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
  }

  @GetMapping("/{id}")
  public ResponseEntity get(@PathVariable("id") final Long id) {
    return ResponseEntity.ok(userService.getById(id));
  }

  @GetMapping
  public ResponseEntity get() {
    return ResponseEntity.ok(userService.getAll());
  }

  @PutMapping
  public ResponseEntity put(@RequestBody final UserEntity user) {
    return ResponseEntity.ok(userService.save(user));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") final Long id) {
    userService.delete(id);
  }
}
