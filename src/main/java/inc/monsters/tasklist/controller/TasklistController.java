package inc.monsters.tasklist.controller;

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

    @GetMapping("/tasklist")
    public String showTasklist(@RequestParam(value= "id", required = false) Integer id, Model model) {
        System.out.println(id);
        
        return "tasklist";
    }
}
