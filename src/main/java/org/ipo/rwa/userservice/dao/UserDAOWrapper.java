package org.ipo.rwa.userservice.dao;

import org.ipo.rwa.userservice.bean.UserBean;
import org.ipo.rwa.userservice.entity.User;
import org.ipo.rwa.userservice.utility.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDAOWrapper {

    private IUserRepository userRepository;

    @Autowired
    public UserDAOWrapper(final IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserBean> getUsers() {
        return this.userRepository.findAll()
                .parallelStream()
                .map(this::convertEntityToBean)
                .collect(Collectors.toList());
    }

    public UserBean getUserById(final String id) {
        return this.convertEntityToBean(this.userRepository.findById(id).get());
    }

    public UserBean saveUser(final UserBean userBean) {
        return this.convertEntityToBean(this.userRepository.save(convertBeanToEntity(userBean)));
    }

    public UserBean updateUser(final UserBean userBean) {
        return this.convertEntityToBean(this.userRepository.save(convertBeanToEntity(userBean)));
    }

    public void deleteUserById(final String id) {
        this.userRepository.deleteById(id);
    }

    private User convertBeanToEntity(final UserBean userBean) {
        User user = new User();
        System.out.println("Received Document with Details: " + userBean);

        BeanUtils.copyUserProperties(userBean, user);

        System.out.println("Saving Document with Details: " + user);
        return user;
    }

    private UserBean convertEntityToBean(final User user) {
        UserBean userBean = new UserBean();
        System.out.println("Found Document with Details: " + user);

        BeanUtils.copyUserProperties(user, userBean);

        System.out.println("Returning Document with Details: " + userBean);
        return userBean;
    }
}
