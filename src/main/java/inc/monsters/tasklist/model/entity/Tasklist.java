package inc.monsters.tasklist.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 * @author tcurtis
 */
@Component
@Entity
@Data
@Table(name = "tasklists")
public class Tasklist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Titles can not be empty.")
    private String title;
    private String description;
    @OneToMany(mappedBy = "tasklist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks;
}
