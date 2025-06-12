package victor.raphael.atenacrud.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import victor.raphael.atenacrud.dtos.CreateTaskDTO;
import victor.raphael.atenacrud.dtos.UpdateTaskDTO;
import victor.raphael.atenacrud.models.TaskModel;
import victor.raphael.atenacrud.services.TaskService;

import java.util.List;

@RestController()
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskModel> createTask(@Valid @RequestBody CreateTaskDTO createTaskDTO) {
        return ResponseEntity.ok(taskService.createTask(createTaskDTO));
    }

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> updateTask(@PathVariable Long id, @RequestBody UpdateTaskDTO dto) {
        try {
            TaskModel updated = taskService.updateTask(id, dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
