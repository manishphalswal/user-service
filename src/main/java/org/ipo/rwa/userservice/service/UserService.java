package org.ipo.rwa.userservice.service;

import org.ipo.rwa.userservice.bean.UserBean;
import org.ipo.rwa.userservice.dao.IUserRepository;
import org.ipo.rwa.userservice.dao.UserDAOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserDAOWrapper userDAOWrapper;

    @Autowired
    public UserService(final UserDAOWrapper userDAOWrapper) {
        super();
        this.userDAOWrapper = userDAOWrapper;
    }


    public List<UserBean> getUsers() {
        return this.userDAOWrapper.getUsers();
    }

    public UserBean getUserById(final String id) {
        return this.userDAOWrapper.getUserById(id);
    }

    public UserBean saveUser(final UserBean userBean) {
        return this.userDAOWrapper.saveUser(userBean);
    }

    public UserBean updateUser(final UserBean userBean) {
        return this.userDAOWrapper.updateUser(userBean);
    }

    public void deleteUserById(final String id) {
        this.userDAOWrapper.deleteUserById(id);
    }

}
