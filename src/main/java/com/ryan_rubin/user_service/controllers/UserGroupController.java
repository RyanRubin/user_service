package com.ryan_rubin.user_service.controllers;

import com.ryan_rubin.user_service.models.ResponseJson;
import com.ryan_rubin.user_service.models.UserGroup;
import com.ryan_rubin.user_service.services.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/user-groups")
@CrossOrigin(origins = "*")
public class UserGroupController {
    @Autowired
    private UserGroupService userGroupService;

    @GetMapping(path = "")
    public @ResponseBody
    ResponseJson getAll() {
        ResponseJson response = new ResponseJson();
        try {
            response.setReturnValue(userGroupService.getAll());
        } catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }
        return response;
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseJson get(@PathVariable("id") Integer id) {
        ResponseJson response = new ResponseJson();
        try {
            response.setReturnValue(userGroupService.get(id));
        } catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }
        return response;
    }

    @PostMapping(path = "")
    public @ResponseBody
    ResponseJson post(@RequestBody UserGroup userGroup) {
        ResponseJson response = new ResponseJson();
        try {
            response.setReturnValue(userGroupService.create(userGroup));
        } catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }
        return response;
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseJson put(@PathVariable("id") Integer id, @RequestBody UserGroup userGroup) {
        ResponseJson response = new ResponseJson();
        try {
            response.setReturnValue(userGroupService.update(id, userGroup));
        } catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    ResponseJson delete(@PathVariable("id") Integer id) {
        ResponseJson response = new ResponseJson();
        try {
            userGroupService.delete(id);
        } catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }
        return response;
    }
}
