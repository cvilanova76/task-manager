package br.com.carolinavn.taskmanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.carolinavn.taskmanager.model.entities.Task;
import br.com.carolinavn.taskmanager.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping
@AllArgsConstructor
@Log4j2
public class TaskController {

    TaskService taskService;

   @GetMapping("/tasks")
    public String createTask(Model model){
        model.addAttribute("task", new Task());
        return "tasks";
   }
   
   @PostMapping
   public String save(@ModelAttribute("task") Task task){
    log.info("Tarefa salva [{}]", task);
    return "tasks";
   }
   
    @GetMapping("/list-tasks")
    public List<Task> getAllTasks(){
        return taskService.listAllTasks();
    }
  
    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable (value = "id") Long id){
        return taskService.findTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTaskById(@PathVariable (value = "id") Long id, @RequestBody Task task){
        log.info("Tarefa atualizada [{}]", id, task);
        return taskService.updateTaskById(task, id);
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById(@PathVariable (value = "id") Long id){
        log.info("Tarefa excluída [{}]", id);
        return taskService.deleteById(id);
    }
    
}