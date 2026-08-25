package com.cl.demo.responseobjects;

import com.cl.demo.entities.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TaskUpdateResponse {
    String taskId;
    String title;
    String description;
    String taskNumber;
    String taskStatus;
    String dueDate;
    Boolean isAssigned;

    public static TaskUpdateResponse convert(Task task) {
        TaskUpdateResponse response = new TaskUpdateResponse();
        response.setTaskId(task.getId().toString());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setTaskNumber(task.getTaskNumber());
        response.setTaskStatus(task.getTaskStatus().toString());
        response.setDueDate(task.getDueDate().toString());
        response.setIsAssigned(task.getIsAssigned());
        return response;
    }

    public static List<TaskUpdateResponse> convert(List<Task> taskList) {
        List<TaskUpdateResponse> responseList = new ArrayList<>();
            for (Task t : taskList) {
                responseList.add(convert(t));
            }
        return responseList;
    }
}
