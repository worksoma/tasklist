package inc.monsters.tasklist.controller;

import inc.monsters.tasklist.model.service.TaskService;
import inc.monsters.tasklist.form.TaskForm;
import inc.monsters.tasklist.model.entity.Task;
import inc.monsters.tasklist.model.service.TasklistService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tcurtis
 */
@Controller
public class TasklistController {
    private TasklistService tasklistService;
    private TaskService taskService;
    private TaskForm taskForm;
    private Task task;

    public TasklistController(TasklistService tasklistService, TaskService taskService, TaskForm taskForm, Task task) {
        this.tasklistService = tasklistService;
        this.taskService = taskService;
        this.taskForm = taskForm;
        this.task = task;
    }

    @GetMapping("/tasklist")
    public String showTasklist(@RequestParam(value= "id", required = false) Long id, Model model) {
        List<Task> tasks = taskService.findByTasklistId(id);
        model.addAttribute("tasks", tasks);
        this.taskForm.setTasklistId(id);
        model.addAttribute("taskForm", this.taskForm);
        
        return "tasklist";
    }
    
    @PostMapping("/tasklist")
    public String addTask(@ModelAttribute TaskForm taskForm, Model model) {
        var tasklistId = taskForm.getTasklistId();
        
        taskService.save(toEntity(taskForm));
        
        TaskForm newForm = new TaskForm();
        newForm.setTasklistId(tasklistId);
        List<Task> tasks = taskService.findByTasklistId(tasklistId);
        model.addAttribute("tasks", tasks);
        model.addAttribute("taskForm", newForm);
        
        return "tasklist";
    }
    
    private Task toEntity(TaskForm taskForm) {
        task.setTitle(taskForm.getTitle());
        task.setTasklist(tasklistService.getOne(taskForm.getTasklistId()));
        
        return task;
    }
}
