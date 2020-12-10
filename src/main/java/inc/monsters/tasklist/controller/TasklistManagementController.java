package inc.monsters.tasklist.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import inc.monsters.tasklist.model.entity.Tasklist;
import inc.monsters.tasklist.model.service.TasklistService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author tcurtis
 */
@Controller
public class TasklistManagementController {
    
private List<Tasklist> tasklists;
    private TasklistService tasklistService;
    private Tasklist tasklist;

    public TasklistManagementController(TasklistService tasklistService, Tasklist tasklist) {
        this.tasklistService = tasklistService;
        this.tasklist = tasklist;
    }
    
    @GetMapping("/tasklistMgmt")
    public String TasklistListing(Model model) {
        List<Tasklist> list = tasklistService.findAll();
        model.addAttribute("tasklists", list);
        model.addAttribute("tasklist", tasklist);
        
        return "tasklistManagement";
    }
    
    @PostMapping("/tasklistMgmt")
    public String addTasklist(@ModelAttribute Tasklist tasklist, Model model) {
        tasklistService.save(tasklist);
        List<Tasklist> list = tasklistService.findAll();
        model.addAttribute("tasklists", list);
        
        return "tasklistManagement";
    }
}
