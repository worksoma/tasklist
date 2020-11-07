/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.tasklist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 *
 * @author tcurtis
 */
@Controller
public class TasklistController {
    
    public String tasklistForm(Model model) {
        return "tasklistForm";
    }
    
}
