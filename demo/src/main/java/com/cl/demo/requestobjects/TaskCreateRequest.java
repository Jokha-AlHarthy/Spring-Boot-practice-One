package com.cl.demo.requestobjects;

import com.cl.demo.entities.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// Make the request classes - TaskCreateRequest
@Getter
@Setter
public class TaskCreateRequest {
    private String title;
    private String description;
    private Date dueDate;
    private Date startDate;
    private TaskStatus taskStatus;
    private boolean isAssigned;
}
