package inc.monsters.tasklist.model.repository;

import org.springframework.stereotype.Repository;
import inc.monsters.tasklist.model.entity.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tcurtis
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    public List<Task> findByTasklistId(Long id);
}
