package com.samuellmoraes.todoapi.service;

import com.samuellmoraes.todoapi.exception.TaskNotFoundException;
import com.samuellmoraes.todoapi.model.Task;
import com.samuellmoraes.todoapi.model.TaskStatus;
import com.samuellmoraes.todoapi.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task criar(Task task) {
        task.setDataCriacao(LocalDate.now());
        task.setStatus(TaskStatus.PENDENTE); // Default
        return taskRepository.save(task);
    }

    public List<Task> listarTodas() {
        return taskRepository.findAll();
    }

    public Task buscarPorId(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Tarefa com ID " + id + " não encontrada."));
    }

    public Task atualizar(Long id, Task novaTask) {
        Task taskExistente = buscarPorId(id);

        taskExistente.setTitulo(novaTask.getTitulo());
        taskExistente.setDescricao(novaTask.getDescricao());
        taskExistente.setStatus(novaTask.getStatus());
        taskExistente.setDataLimite(novaTask.getDataLimite());

        return taskRepository.save(taskExistente);
    }

    public void deletar(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> filtrarPorStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> filtrarPorDataLimite(LocalDate data) {
        return taskRepository.findByDataLimite(data);
    }



}
