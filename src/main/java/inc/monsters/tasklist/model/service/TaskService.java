package inc.monsters.tasklist.model.service;

import java.util.List;
import inc.monsters.tasklist.model.entity.Task;
import inc.monsters.tasklist.model.repository.TaskRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tcurtis
 */
@Service
@Transactional
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public List<Task> findByTasklistId(Long id) {
        return taskRepository.findByTasklistId(id);
    }
    
    public void save(Task task) {
        taskRepository.save(task);
    }
    
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }
    
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
    
    public Task getOne(Long id) {
        return taskRepository.getOne(id);
    }
}
