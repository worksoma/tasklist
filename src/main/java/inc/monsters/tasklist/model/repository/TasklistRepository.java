/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
