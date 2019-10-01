package com.usermgmt.service;

import com.usermgmt.exceptions.NotFoundException;
import com.usermgmt.exceptions.PasswordConfirmationException;
import com.usermgmt.model.UserRepository;
import com.usermgmt.model.dtos.UserDTO;
import com.usermgmt.model.entities.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public UserDTO save(final UserDTO userDTO) {
    validate(userDTO);
    return convertUserEntityToUserDTO(
        userRepository.save(
            convertUserDTOToUserEntity(userDTO)));
  }

  public UserDTO getById(final Long id) {
    return convertUserEntityToUserDTO(
        userRepository.findById(id).orElseThrow(() -> NotFoundException.builder().resourceId(id).build()));
  }

  public List<UserDTO> getAll() {
    return userRepository.findAll()
        .parallelStream()
        .map(this::convertUserEntityToUserDTO)
        .collect(Collectors.toList());
  }

  public void delete(final Long id) {
    userRepository.deleteById(id);
  }

  private void validate(final UserDTO userDTO) {
    if (userDTO.shouldPasswordBeValidated() && !userDTO.isPasswordConfirmationValid())
      throw PasswordConfirmationException.builder().message("Password confirmation is invalid!").userId(userDTO.getId()).build();
  }

  private UserEntity convertUserDTOToUserEntity(final UserDTO userDTO) {
    return Optional.ofNullable(userDTO)
        .map(user -> UserEntity.builder()
            .id(user.getId())
            .email(user.getEmail())
            .name(user.getName())
            .password(user.getPassword())
            .build())
        .orElseThrow(RuntimeException::new);
  }

  private UserDTO convertUserEntityToUserDTO(final UserEntity userEntity) {
    return Optional.ofNullable(userEntity)
        .map(user -> UserDTO.builder()
            .id(user.getId())
            .email(user.getEmail())
            .name(user.getName())
            .build())
        .orElseThrow(RuntimeException::new);
  }
}
