/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.tasklist.model.service;

import inc.monsters.tasklist.model.repository.TasklistRepository;
import inc.monsters.tasklist.model.entity.Tasklist;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tcurtis
 */
@Service
@Transactional
public class TasklistService {
    private TasklistRepository tasklistRepository;
    
    public TasklistService(TasklistRepository tasklistRepository) {
        this.tasklistRepository = tasklistRepository;
    }
    
    public List<Tasklist> findAll() {
        return tasklistRepository.findAll();
    }
    
    public void save(Tasklist tasklist) {
        tasklistRepository.save(tasklist);
    }
    
    public Tasklist getOne(Long id) {
        return tasklistRepository.getOne(id);
    }
}
