package victor.raphael.atenacrud.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import victor.raphael.atenacrud.enums.PriorityEnum;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskDTO {

    private String title;

    private String subtitle;

    private String description;

    private Boolean isCompleted;

    private PriorityEnum priority;
}
