package com.ryan_rubin.user_service.controllers;

import com.ryan_rubin.user_service.models.ResponseJson;
import com.ryan_rubin.user_service.models.User;
import com.ryan_rubin.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public @ResponseBody
    ResponseJson getAll() {
        ResponseJson response = new ResponseJson();
        try {
            response.setReturnValue(userService.getAll());
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
            response.setReturnValue(userService.get(id));
        } catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }
        return response;
    }

    @PostMapping(path = "")
    public @ResponseBody
    ResponseJson post(@RequestBody User user) {
        ResponseJson response = new ResponseJson();
        try {
            response.setReturnValue(userService.create(user));
        } catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }
        return response;
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseJson put(@PathVariable("id") Integer id, @RequestBody User user) {
        ResponseJson response = new ResponseJson();
        try {
            response.setReturnValue(userService.update(id, user));
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
            userService.delete(id);
        } catch (Exception ex) {
            response.setErrorMessage(ex.getMessage());
        }
        return response;
    }
}
