package com.cl.demo.responseobjects;

import com.cl.demo.entities.UserName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserNameUpdateResponse {
    private String userNameId;
    private String userName;

    public static UserNameUpdateResponse convert(UserName userName) {
        if (userName == null || userName.getId() == null || !Boolean.TRUE.equals(userName.getIsActive())) {
            return null;
        }
        UserNameUpdateResponse response = new UserNameUpdateResponse();
        response.setUserNameId(userName.getId().toString());
        response.setUserName(userName.getActiveUserName());
        return response;
    }

    public static List<UserNameUpdateResponse> convert(List<UserName> userNameList) {
        List<UserNameUpdateResponse> responseList = new ArrayList<>();
        if (userNameList != null) {
            for (UserName un : userNameList) {
                UserNameUpdateResponse converted = convert(un);
                if (converted != null) {
                    responseList.add(converted);
                }
            }
        }
        return responseList;
    }
}