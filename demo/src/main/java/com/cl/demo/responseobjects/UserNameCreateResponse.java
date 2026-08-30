package com.cl.demo.responseobjects;

import com.cl.demo.entities.UserName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserNameCreateResponse {
    private String userNameId;
    private String userName;

    public static UserNameCreateResponse convert(UserName userName) {
        if (userName == null || userName.getId() == null || !Boolean.TRUE.equals(userName.getIsActive())) {
            return null;
        }
        UserNameCreateResponse response = new UserNameCreateResponse();
        response.setUserNameId(userName.getId().toString());
        response.setUserName(userName.getActiveUserName());
        return response;
    }

    public static List<UserNameCreateResponse> convert(List<UserName> userNameList) {
        List<UserNameCreateResponse> responseList = new ArrayList<>();
        if (userNameList != null) {
            for (UserName un : userNameList) {
                UserNameCreateResponse converted = convert(un);
                if (converted != null) {
                    responseList.add(converted);
                }
            }
        }
        return responseList;
    }
}