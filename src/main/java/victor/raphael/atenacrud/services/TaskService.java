package victor.raphael.atenacrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import victor.raphael.atenacrud.dtos.CreateTaskDTO;
import victor.raphael.atenacrud.dtos.UpdateTaskDTO;
import victor.raphael.atenacrud.enums.PriorityEnum;
import victor.raphael.atenacrud.models.TaskModel;
import victor.raphael.atenacrud.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public TaskModel createTask(CreateTaskDTO createTaskDTO) {
        TaskModel taskModel = new TaskModel();
        taskModel.setTitle(createTaskDTO.getTitle());
        taskModel.setSubtitle(createTaskDTO.getSubtitle());
        taskModel.setDescription(createTaskDTO.getDescription());
        taskModel.setPriority(createTaskDTO.getPriority() != null ? createTaskDTO.getPriority() : PriorityEnum.NONE);

        return taskRepository.save(taskModel);
    }

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskModel> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskModel updateTask(Long id, UpdateTaskDTO updateTaskDTO) {
        Optional<TaskModel> optionalTask = taskRepository.findById(id);

        TaskModel taskModel = optionalTask.get();

        if (updateTaskDTO.getTitle() != null) {
            taskModel.setTitle(updateTaskDTO.getTitle());
        }

        if (updateTaskDTO.getSubtitle() != null) {
            taskModel.setSubtitle(updateTaskDTO.getSubtitle());
        }

        if (updateTaskDTO.getDescription() != null) {
            taskModel.setDescription(updateTaskDTO.getDescription());
        }

        if (updateTaskDTO.getIsCompleted() != null) {
            taskModel.setIsCompleted(updateTaskDTO.getIsCompleted());
        }

        if (updateTaskDTO.getPriority() != null) {
            taskModel.setPriority(updateTaskDTO.getPriority());
        }

        return taskRepository.save(taskModel);
    }

}
