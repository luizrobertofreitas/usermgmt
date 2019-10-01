package com.usermgmt.model;

import com.usermgmt.model.entities.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  List<UserEntity> findByNameLike(final String name);
}
