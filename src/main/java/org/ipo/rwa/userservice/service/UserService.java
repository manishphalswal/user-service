package org.ipo.rwa.userservice.service;

import org.ipo.rwa.userservice.dao.IUserRepository;
import org.ipo.rwa.userservice.dao.UserDAOWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDAOWrapper userDAOWrapper;

    @Autowired
    public UserService(final UserDAOWrapper userDAOWrapper) {
        super();
        this.userDAOWrapper = userDAOWrapper;
    }


}
