package victor.raphael.atenacrud.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import victor.raphael.atenacrud.enums.PriorityEnum;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTaskDTO {


    @NotBlank
    private String title;

    private String subtitle;

    private String description;

    private Boolean isCompleted = false;

    private PriorityEnum priority;

}
