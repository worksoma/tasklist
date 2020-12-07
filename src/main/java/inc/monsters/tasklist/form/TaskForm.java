package inc.monsters.tasklist.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *
 * @author tcurtis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TaskForm {
    private Long id;
    @NotBlank(message = "Please enter a title.")
    private String title;
    @NotNull(message = "Invalid form.")
    private Long tasklistId;
}
