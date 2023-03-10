package inc.monsters.tasklist.controller;

import inc.monsters.tasklist.model.service.TaskService;
import inc.monsters.tasklist.form.TaskForm;
import inc.monsters.tasklist.model.entity.Task;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tcurtis
 */
@Controller
public class TasklistController { 
    private TaskService taskService;
    private TaskForm taskForm;

    public TasklistController(TaskService taskService, TaskForm taskForm) {
        this.taskService = taskService;
        this.taskForm = taskForm;
    }

    @GetMapping("/tasklist")
    public String showTasklist(@RequestParam(value= "id", required = false) Long id, Model model) {
        List<Task> tasks = taskService.findByTasklistId(id);
        model.addAttribute("tasks", tasks);
        this.taskForm.setTasklistId(id);
        model.addAttribute("taskForm", this.taskForm);
        
        return "tasklist";
    }
}
