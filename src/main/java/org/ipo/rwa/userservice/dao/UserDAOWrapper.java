package org.ipo.rwa.userservice.dao;

import org.ipo.rwa.userservice.bean.UserBean;
import org.ipo.rwa.userservice.entity.User;
import org.springframework.beans.BeanUtils;
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

    public UserBean getUserById(final UserBean userBean) {
        return this.convertEntityToBean(this.userRepository.findById(userBean.getId()).get());
    }

    public UserBean saveUser(final UserBean userBean) {
        return this.convertEntityToBean(this.userRepository.save(convertBeanToEntity(userBean)));
    }

    public UserBean updateUser(final UserBean userBean) {
        return this.convertEntityToBean(this.userRepository.save(convertBeanToEntity(userBean)));
    }

    public void deleteUser(final UserBean userBean) {
        this.userRepository.delete(convertBeanToEntity(userBean));
    }

    private User convertBeanToEntity(final UserBean userBean) {
        User user = new User();
        BeanUtils.copyProperties(userBean, user);
        return user;
    }

    private UserBean convertEntityToBean(final User user) {
        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(user, userBean);
        return userBean;
    }
}
