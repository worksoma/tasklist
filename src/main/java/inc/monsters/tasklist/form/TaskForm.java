package inc.monsters.tasklist.form;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * @author tcurtis
 */
@Data
@Component
public class TaskForm {
    private Long id;
    private String title;
    private Long tasklistId;
}
