package com.perezm27.Taskmaster.Controllers;

import com.perezm27.Taskmaster.Models.Task;
import com.perezm27.Taskmaster.Models.UserHistory;
import com.perezm27.Taskmaster.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getCustomers() {
        return (List) taskRepository.findAll();
    }

    @GetMapping("/users/{name}/tasks")
    public List<Task> getTasks(@PathVariable String name)
    {
        return (List) taskRepository.findByAssignee(name);
    }


    @PostMapping("/tasks")
    public Task addNewTask (@RequestBody Task task) {

        Task newTask = new Task(task.getId(), task.getTitle(), task.getDescription(), task.getAssignee());

        if (newTask.getAssignee() == null)
        {
            newTask.setStatus("Available");

        }
        else
        {
            newTask.setAssignee( task.getAssignee() );
            newTask.setStatus("Assigned");
        }

        UserHistory userHistory = new UserHistory(newTask.getStatus());

        newTask.addUserHistory(userHistory);
        taskRepository.save(newTask);
        return newTask;
    }


    @PutMapping("/tasks/{id}/state")
    public Task updateStatus(@PathVariable String id){

        Task task = taskRepository.findById(id).get();

        if (task.getStatus().equals("Available"))
        {
            task.setStatus("Assigned");
            UserHistory userHistory = new UserHistory(" - Changed status to Assigned.");
            task.addUserHistory(userHistory);
        }
        else if ( task.getStatus().equals("Assigned"))
        {
            task.setStatus("Accepted");
            UserHistory userHistory = new UserHistory( " - Changed status to Accepted.");
            task.addUserHistory(userHistory);
        }
        else if ( task.getStatus().equals("Accepted"))
        {
            task.setStatus("Finished");
            UserHistory userHistory = new UserHistory(" - Changed status to Finished.");
            task.addUserHistory(userHistory);
        }
        taskRepository.save(task);
        return task;

    }

    @PutMapping("/tasks/{id}/assign/{assignee}")
    public Task updateAssignee(@PathVariable String id, @PathVariable String assignee){
        Task task = taskRepository.findById(id).get();
        task.setAssignee(assignee);
        task.setStatus(task.getStatus());

        UserHistory userHistory = new UserHistory(task.getAssignee());
        task.addUserHistory(userHistory);

        taskRepository.save(task);
        return task;
    }

}
