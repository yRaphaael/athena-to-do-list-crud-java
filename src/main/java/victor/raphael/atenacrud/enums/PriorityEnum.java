package victor.raphael.atenacrud.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PriorityEnum {
    URGENT(0),
    HIGH(1),
    MEDIUM(2),
    LOW(3),
    NONE(4);

    private final int level;

    public static PriorityEnum fromLevel(int level) {
        return Arrays.stream(values())
                .filter(p -> p.level == level)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid priority level: " + level));
    }

}
