package victor.raphael.atenacrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.raphael.atenacrud.models.TaskModel;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
