package inc.monsters.tasklist.controller;

import inc.monsters.tasklist.model.service.TaskService;
import inc.monsters.tasklist.model.entity.Task;
import inc.monsters.tasklist.form.TaskForm;
import inc.monsters.tasklist.model.service.TasklistService;
import java.util.List;
import java.util.Optional;
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
public class TaskController {
    private final TaskService taskService;
    private final TasklistService tasklistService;
    private TaskForm taskForm;

    public TaskController(TaskService taskService, TasklistService tasklistService, TaskForm taskForm) {
        this.taskService = taskService;
        this.tasklistService = tasklistService;
        this.taskForm = taskForm;
    }
    
    @GetMapping("/task/edit")
    public String editTask(@RequestParam(value= "id", required = false) Long id, Model model) {
        Optional<Task> task =  taskService.findById(id);
        task.ifPresent(taskToEdit -> model.addAttribute("task", toForm(taskToEdit)));
        
        return "editTask";
    }
    
    @PostMapping("/task/save")
    public String saveTask(@ModelAttribute TaskForm taskForm, Model model) {
        System.out.println("Testing: " + taskForm.getTasklistId() + taskForm.getTitle());
        var tasklistId = taskForm.getTasklistId();
        
        taskService.save(toEntity(taskForm));
        
        TaskForm newForm = new TaskForm();
        newForm.setTasklistId(tasklistId);
        List<Task> tasks = taskService.findByTasklistId(tasklistId);
        model.addAttribute("tasks", tasks);
        model.addAttribute("taskForm", newForm);
        
        return "redirect:/tasklist?id=" + taskForm.getTasklistId();
    }
    
    private TaskForm toForm(Task task) {
        return new TaskForm(task.getId(), task.getTitle(), task.getTasklist().getId());
    }
    
    private Task toEntity(TaskForm taskForm) {
        Task task = new Task();
        
        task.setId(taskForm.getId());
        task.setTitle(taskForm.getTitle());
        task.setTasklist(tasklistService.getOne(taskForm.getTasklistId()));
        
        return task;
    }
}
