package com.ryan_rubin.user_service.repositories;

import com.ryan_rubin.user_service.models.UserGroup;
import org.springframework.data.repository.CrudRepository;

public interface UserGroupRepository extends CrudRepository<UserGroup, Integer> {
}
