package br.com.carolinavn.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carolinavn.taskmanager.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}