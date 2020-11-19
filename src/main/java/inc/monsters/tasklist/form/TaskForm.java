package inc.monsters.tasklist.form;

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
    private String title;
    private Long tasklistId;
}
