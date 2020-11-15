/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public void detachTask(Long id);
}
