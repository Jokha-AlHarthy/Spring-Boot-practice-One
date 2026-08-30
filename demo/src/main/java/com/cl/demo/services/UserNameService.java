package com.cl.demo.services;

import com.cl.demo.DemoApplication;
import com.cl.demo.entities.UserName;
import com.cl.demo.requestobjects.UserNameCreateRequest;
import com.cl.demo.requestobjects.UserNameUpdateRequest;
import com.cl.demo.utils.HelperUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserNameService {

    public UserName addUserName(UserNameCreateRequest requestObj) {
        if (requestObj == null || requestObj.getUserName() == null || requestObj.getUserName().trim().isEmpty()) {
            return new UserName();
        }

        UserName userName = new UserName();
        userName.setId(UUID.randomUUID());
        userName.setIsActive(Boolean.TRUE);
        userName.setCreatedDate(new Date());
        userName.setActiveUserName(requestObj.getUserName());
        DemoApplication.UserName_List.add(userName);
        return userName;
    }

    public UserName getUserNameById(String uuid) {
        if (uuid == null) return new UserName();
        for (UserName un : DemoApplication.UserName_List) {
            if (un.getId() != null && un.getId().toString().equals(uuid) && Boolean.TRUE.equals(un.getIsActive())) {
                return un;
            }
        }
        return new UserName();
    }

    public List<UserName> getAllUserNames() {
        List<UserName> resultList = new ArrayList<>();
        for (UserName un : DemoApplication.UserName_List) {
            if (Boolean.TRUE.equals(un.getIsActive())) {
                resultList.add(un);
            }
        }
        return resultList;
    }

    public UserName updateUserName(UserNameUpdateRequest updateObj) {
        UserName userName = getUserNameById(updateObj.getUuid());
        if (userName == null || userName.getId() == null || !Boolean.TRUE.equals(userName.getIsActive())) {
            return new UserName();
        }

        DemoApplication.UserName_List.remove(userName);

        userName.setActiveUserName(HelperUtils.compare(userName.getActiveUserName(), updateObj.getUserNameToUpdate()));        userName.setUpdatedDate(new Date());

        DemoApplication.UserName_List.add(userName);
        return userName;
    }

    public Boolean deleteById(String uuid) {
        UserName userName = getUserNameById(uuid);
        if (userName == null || userName.getId() == null || !Boolean.TRUE.equals(userName.getIsActive())) {
            return false;
        }
        DemoApplication.UserName_List.remove(userName);
        userName.setIsActive(false);
        DemoApplication.UserName_List.add(userName);
        return true;
    }
}