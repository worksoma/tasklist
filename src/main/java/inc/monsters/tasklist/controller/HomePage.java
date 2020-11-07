/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.tasklist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author tcurtis
 */
@Controller
public class HomePage {
    
    @GetMapping("/")
    public String home(Model model) {
        System.out.println("testing");
        
        return "index";
    }
    
    @GetMapping("/welcome")
    public String welcome(Model model) {
        String crazy="crazy town";
        System.out.println("welcome");
        
        model.addAttribute("welcome", "here is a message");
        model.addAttribute("ct", crazy);
        
        return "newthymeleaf";
    }
}
