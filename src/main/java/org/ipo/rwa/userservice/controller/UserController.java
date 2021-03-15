package org.ipo.rwa.userservice.controller;

import org.ipo.rwa.userservice.bean.UserBean;
import org.ipo.rwa.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserBean> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public UserBean getUser(@PathVariable("id") final String id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("/saveUser")
    public UserBean saveUser(@RequestBody UserBean userBean) {
        return this.userService.saveUser(userBean);
    }

    @PutMapping("/updateUser")
    public UserBean updateUser(@RequestBody UserBean userBean) {
        return this.userService.updateUser(userBean);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") final String id) {
        this.userService.deleteUserById(id);
    }
}
