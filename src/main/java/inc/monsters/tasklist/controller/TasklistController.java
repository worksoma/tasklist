/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TasklistController {
    
private List<Tasklist> tasklists;
    private TasklistService tasklistService;
    private Tasklist tasklist;

    public TasklistController(TasklistService tasklistService, Tasklist tasklist) {
        this.tasklistService = tasklistService;
        this.tasklist = tasklist;
    }
    
    @GetMapping("/tasklistMgmt")
    public String TasklistListing(Model model) {
        List<Tasklist> list = tasklistService.findAll();
        model.addAttribute("tasklists", list);
        model.addAttribute("tasklist", tasklist);
        
        return "tasklists";
    }
    
    @PostMapping("/tasklistMgmt")
    public String addTasklist(@ModelAttribute Tasklist tasklist, Model model) {
        tasklistService.save(tasklist);
        List<Tasklist> list = tasklistService.findAll();
        model.addAttribute("tasklists", list);
        
        return "tasklists";
    }
}
