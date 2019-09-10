package com.perezm27.Taskmaster.Controllers;

import com.perezm27.Taskmaster.Models.Task;
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


    @PostMapping("/tasks")
    public Task addNewTask (@RequestBody Task task) {
        Task c = new Task();
        c.setTitle(task.getTitle());
        c.setDescription(task.getDescription());
        c.setStatus("available");
        taskRepository.save(c);

        return c;
    }

    @PutMapping("/tasks/{id}/state")
    public Task updateStatus(@PathVariable String id){
        Task t = taskRepository.findById(id).get();
        if (t.getStatus().equals("available")) {
            t.setStatus("assigned");
        } else if (t.getStatus().equals("assigned")) {
            t.setStatus("accepted");
        } else if (t.getStatus().equals("accepted")) {
            t.setStatus("finished");
        }
        taskRepository.save(t);
        return t;
    }

}
