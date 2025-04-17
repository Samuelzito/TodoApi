package com.samuellmoraes.todoapi.controller;

import com.samuellmoraes.todoapi.model.Task;
import com.samuellmoraes.todoapi.model.TaskStatus;
import com.samuellmoraes.todoapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> criar(@RequestBody Task task) {
        Task nova = taskService.criar(task);
        return ResponseEntity.ok(nova);
    }

    @GetMapping
    public ResponseEntity<List<Task>> listarTodas() {
        return ResponseEntity.ok(taskService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizar(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.atualizar(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        taskService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status")
    public ResponseEntity<List<Task>> filtrarPorStatus(@RequestParam TaskStatus status) {
        return ResponseEntity.ok(taskService.filtrarPorStatus(status));
    }

    @GetMapping("/data")
    public ResponseEntity<List<Task>> filtrarPorData(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return ResponseEntity.ok(taskService.filtrarPorDataLimite(data));
    }
}
