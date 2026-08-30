package com.cl.demo.responseobjects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNameUpdateRequest {
    private String uuid;
    private String userNameToUpdate;
}
