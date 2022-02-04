package com.ryan_rubin.user_service.services;

import com.ryan_rubin.user_service.models.ServiceException;
import com.ryan_rubin.user_service.models.UserGroup;
import com.ryan_rubin.user_service.repositories.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserGroupService {
    @Autowired
    private UserGroupRepository userGroupRepository;

    public Iterable<UserGroup> getAll() {
        return userGroupRepository.findAll();
    }

    public Optional<UserGroup> get(Integer id) {
        return userGroupRepository.findById(id);
    }

    public UserGroup create(UserGroup userGroup) throws Exception {
        String validation = validate(userGroup);
        if (!validation.isBlank()) {
            throw new ServiceException(validation);
        }
        return userGroupRepository.save(userGroup);
    }

    public Optional<UserGroup> update(Integer id, UserGroup userGroup) throws Exception {
        String validation = validate(userGroup);
        if (!validation.isBlank()) {
            throw new ServiceException(validation);
        }
        Optional<UserGroup> userGroupOpt = userGroupRepository.findById(id);
        if (userGroupOpt.isPresent()) {
            UserGroup userGroupGet = userGroupOpt.get();
            userGroupGet.setName(userGroup.getName());
            userGroupGet.setEmail(userGroup.getEmail());
            return Optional.of(userGroupRepository.save(userGroupGet));
        } else {
            return userGroupOpt;
        }
    }

    public void delete(Integer id) {
        userGroupRepository.deleteById(id);
    }

    private String validate(UserGroup userGroup) {
        if (userGroup.getName() == null || userGroup.getName().isBlank()) {
            return "Name is required.";
        }
        if (userGroup.getEmail() == null || userGroup.getEmail().isBlank()) {
            return "Email is required.";
        }
        return "";
    }
}
