package inc.monsters.tasklist.model.repository;

import inc.monsters.tasklist.model.entity.Tasklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tcurtis
 */
@Repository
public interface TasklistRepository extends JpaRepository<Tasklist, Long> {
}
