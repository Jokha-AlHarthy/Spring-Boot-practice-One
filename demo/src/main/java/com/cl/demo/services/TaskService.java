package com.cl.demo.services;

import com.cl.demo.DemoApplication;
import com.cl.demo.entities.Task;
import com.cl.demo.entities.TaskStatus;
import com.cl.demo.requestobjects.TaskCreateRequest;
import com.cl.demo.requestobjects.TaskUpdateRequest;
import com.cl.demo.utils.HelperUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    public static final String TASK_SAVED = "Task Saved";
    public static final String ERROR_INVALID="Title can't be empty";

    //addTask(...) Map (text)
    public Map<String, String> addTask(TaskCreateRequest requestObj){
        Map<String , String> response = new HashMap<>();

        if(requestObj.getTitle() == null || requestObj.getTitle().trim().isEmpty()){
            response.put("error", ERROR_INVALID);
            return response;
        }

        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setIsActive(Boolean.TRUE);
        task.setCreatedDate(new Date());
        task.setTaskNumber(generateTaskNumber());
        task.setTitle(requestObj.getTitle());
        task.setDescription(requestObj.getDescription());
        task.setDueDate(requestObj.getDueDate());
        task.setStartDate(requestObj.getStartDate());
        task.setTaskStatus(requestObj.getTaskStatus());
        task.setIsAssigned(requestObj.isAssigned());

        Boolean result = DemoApplication.Task_List.add(task);

        if(result){
            response.put("response", TASK_SAVED);
        }
        return response;
    }

    //getTaskById(uuid)
    public Task getTaskById(String uuid){
        for(Task t: DemoApplication.Task_List){
            if(t.getId().toString().equals(uuid) && t.getIsActive()){
                return t;
            }
        }
        return new Task();
    }

    //getAllTasks()
    public List<Task> getAllTasks(){
        List<Task>resultList = new ArrayList<>();
        for(Task t : DemoApplication.Task_List){
            if(t.getIsActive()){
                resultList.add(t);
            }
        }
        return resultList;
    }

    //updateTask(...)
    public Task updateTask(TaskUpdateRequest updateObj) {
        Task task = getTaskById(updateObj.getUuid());
        if (task == null || task.getId() == null || !task.getIsActive()) {
            return task;
        }
        DemoApplication.Task_List.remove(task);

        task.setTitle(HelperUtils.compare(task.getTitle(), updateObj.getTitleToUpdate()));
        task.setDescription(HelperUtils.compare(task.getDescription(), updateObj.getDescriptionToUpdate()));
        task.setTaskStatus(HelperUtils.compare(task.getTaskStatus(), updateObj.getTaskStatusToUpdate()));
        task.setDueDate(HelperUtils.compare(task.getDueDate(), updateObj.getDueDateToUpdate()));
        task.setIsAssigned(HelperUtils.compare(task.getIsAssigned(), updateObj.getIsAssignedToUpdate()));
        task.setTitle(HelperUtils.compare(task.getTitle(), updateObj.getTitleToUpdate()));
        task.setUpdatedDate(new Date());
        DemoApplication.Task_List.add(task);
        return task;
    }

    //deleteById(uuid)
    public Boolean deleteById(String uuid) {
        Task task = getTaskById(uuid);
        if (task == null || task.getId() == null || task.getIsActive() != true) {
            return false;
        } else {
            DemoApplication.Task_List.remove(task);
            task.setIsActive(false);
            DemoApplication.Task_List.add(task);
            return true;
        }
    }

    //generating task number
    public String generateTaskNumber(){
        return "Task-" + (DemoApplication.Task_List.size() + 1);
    }
}
