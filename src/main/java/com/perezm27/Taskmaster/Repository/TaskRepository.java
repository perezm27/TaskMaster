package com.perezm27.Taskmaster.Repository;

import com.perezm27.Taskmaster.Models.Task;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface TaskRepository extends CrudRepository<Task, String> {
        Optional<Task> findById(String id);
        List<Task> findByAssignee(String name);
}
