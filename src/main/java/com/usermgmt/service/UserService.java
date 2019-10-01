package com.usermgmt.service;

import com.usermgmt.model.UserRepository;
import com.usermgmt.model.entities.UserEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public UserEntity save(final UserEntity userEntity) {
    return userRepository.save(userEntity);
  }

  public UserEntity getById(final Long id) {
    return userRepository.getOne(id);
  }

  public List<UserEntity> getAll() {
    return userRepository.findAll();
  }

  public void delete(final Long id) {
    userRepository.deleteById(id);
  }
}
