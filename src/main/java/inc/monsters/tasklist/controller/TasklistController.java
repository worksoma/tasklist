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

/**
 *
 * @author tcurtis
 */
@Controller
public class TasklistController {
    
private List<Tasklist> tasklists;
    private TasklistService tasklistService;

    public TasklistController(TasklistService tasklistService) {
        this.tasklistService = tasklistService;
    }
    
    @GetMapping("/tasklistMgmt")
    public String TasklistListing(Model model) {
        List<Tasklist> list = tasklistService.findAll();
        model.addAttribute("tasklists", list);
        
        return "addTasklist";
    }
}
