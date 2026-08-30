package com.cl.demo.requestobjects;

import com.cl.demo.entities.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//Make the request classes - TaskUpdateRequest
@Getter
@Setter
public class TaskUpdateRequest {
    String uuid;
    String titleToUpdate;
    String descriptionToUpdate;
    TaskStatus taskStatusToUpdate;
    Date dueDateToUpdate;
    Boolean isAssignedToUpdate;
}