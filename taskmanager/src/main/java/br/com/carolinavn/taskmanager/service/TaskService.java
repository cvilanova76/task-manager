package br.com.carolinavn.taskmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.carolinavn.taskmanager.model.Task;
import br.com.carolinavn.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask (Task task){
        return taskRepository.save(task);
    }

    public List<Task> listAllTasks(){
        return taskRepository.findAll();
    }

    public ResponseEntity<Task> findTaskById(Long id){
        return taskRepository.findById(id)
        .map(task -> ResponseEntity.ok().body(task))
        .orElse(ResponseEntity.notFound().build());
    }
    
}