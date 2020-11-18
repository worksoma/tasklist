package inc.monsters.tasklist.controller;

import inc.monsters.tasklist.model.service.TaskService;
import inc.monsters.tasklist.model.entity.Task;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tcurtis
 */
@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GetMapping("/task/edit")
    public String editTask(@RequestParam(value= "id", required = false) Long id, Model model) {
        Optional<Task> task =  taskService.findById(id);
        task.ifPresent(taskToEdit -> model.addAttribute("task", taskToEdit));
        
        return "editTask";
    }
}
