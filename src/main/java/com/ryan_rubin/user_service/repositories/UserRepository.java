package com.ryan_rubin.user_service.repositories;

import com.ryan_rubin.user_service.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
