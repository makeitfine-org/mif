/*
 * Created under not commercial project "Make it fine"
 *
 * Copyright 2017-2019
 * @author stingion
 */

package com.stingion.makeitfine.data.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.stingion.makeitfine.data.model.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

// todo: add testing of user_profile many-to-many relation
public class UserServiceIT extends EntityServiceITAncestor<User> {

  @Autowired
  private UserService userService;

  @Test
  void findBySSO() {
    User userExcepted = userService.findById(5);
    User userActual = userService.findBySSO("kenny");

    assertEquals(userExcepted, userActual);
  }

  @Test
  void findByEmail() {
    User userExcepted = userService.findById(3);
    User userActual = userService.findByEmail("SAMY@XYZ.COM");

    assertEquals(userExcepted, userActual);
  }
}
