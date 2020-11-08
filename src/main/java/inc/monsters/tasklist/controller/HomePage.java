package inc.monsters.tasklist.controller;

import inc.monsters.tasklist.model.service.TasklistService;
import inc.monsters.tasklist.model.entity.Tasklist;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author tcurtis
 */ 
@Controller
public class HomePage {
    private List<Tasklist> tasklists;
    private TasklistService tasklistService;

    public HomePage(TasklistService tasklistService) {
        this.tasklistService = tasklistService;
    }
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasklists", tasklistService.findAll());
        
        return "index";
    }
}
