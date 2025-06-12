package victor.raphael.atenacrud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import victor.raphael.atenacrud.enums.PriorityEnum;

@Entity(name = "Tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subtitle;

    private String description;

    private Boolean isCompleted;

    @Enumerated(EnumType.STRING)
    private PriorityEnum priority;

}
