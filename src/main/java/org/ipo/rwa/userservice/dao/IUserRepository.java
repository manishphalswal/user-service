package org.ipo.rwa.userservice.dao;

import org.ipo.rwa.userservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, String> {
}
