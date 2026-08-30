package com.cl.demo.controllers;

import com.cl.demo.requestobjects.UserNameCreateRequest;
import com.cl.demo.requestobjects.UserNameUpdateRequest;
import com.cl.demo.responseobjects.UserNameCreateResponse;
import com.cl.demo.responseobjects.UserNameUpdateResponse;
import com.cl.demo.services.UserNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userName")
public class UserNameController {

    @Autowired
    private UserNameService userNameService;

    @PostMapping("add")
    public UserNameCreateResponse addUserName(@RequestBody UserNameCreateRequest request) {
        return UserNameCreateResponse.convert(userNameService.addUserName(request));
    }

    @GetMapping("getById")
    public UserNameCreateResponse getUserNameById(@RequestParam String uuid) {
        return UserNameCreateResponse.convert(userNameService.getUserNameById(uuid));
    }

    @GetMapping("getAll")
    public List<UserNameCreateResponse> getAllUserNames() {
        return UserNameCreateResponse.convert(userNameService.getAllUserNames());
    }

    @PutMapping("update")
    public UserNameUpdateResponse updateUserName(@RequestBody UserNameUpdateRequest updateObj) {
        return UserNameUpdateResponse.convert(userNameService.updateUserName(updateObj));
    }

    @DeleteMapping("deleteById")
    public Boolean deleteById(@RequestParam String id) {
        return userNameService.deleteById(id);
    }
}