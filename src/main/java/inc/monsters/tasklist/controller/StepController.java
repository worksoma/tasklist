/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.tasklist.controller;

import inc.monsters.tasklist.model.entity.Step;
import inc.monsters.tasklist.model.service.StepService;
import inc.monsters.tasklist.form.StepForm;
import inc.monsters.tasklist.model.service.TaskService;
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
public class StepController {
    private StepService stepService;
    private StepForm stepForm;
    private TaskService taskService;

    public StepController(StepService stepService, StepForm stepForm, TaskService taskService) {
        this.stepService = stepService;
        this.stepForm = stepForm;
        this.taskService = taskService;
    }
    
    @GetMapping("/step/edit")
    public String editStep(@RequestParam(value= "taskId", required = false) Long taskId, Model model) {
        List<Step> steps =  stepService.findByTaskId(taskId);
        stepForm.setTaskId(taskId);
        model.addAttribute("steps", steps);
        model.addAttribute("step", stepForm);
        
        return "editStep";
    }
    
    @PostMapping("/step/save")
    public String saveStep(@ModelAttribute StepForm stepForm, Model model) {
        var taskId = stepForm.getTaskId();
        stepService.save(toEntity(stepForm));
        
        StepForm newForm = new StepForm();
        newForm.setTaskId(taskId);
        List<Step> steps = stepService.findByTaskId(taskId);
        model.addAttribute("stepForm", newForm);
        
        return "redirect:/step/edit?taskId=" + taskId;
    }
    
//    @GetMapping("/step/delete")
//    public String deleteStep(@RequestParam(value= "id", required = false) Long id, Model model) {
//        
//        return null;
//    }
    
    private StepForm toForm(Step step) {
        return new StepForm(step.getId(), step.getDescription(), step.getTask().getId());
    }
    
    private Step toEntity(StepForm stepForm) {
        Step step = new Step();
        
        step.setId(stepForm.getId());
        step.setDescription(stepForm.getDescription());
        var taskId = stepForm.getTaskId();
        var task = taskService.getOne(taskId);
        step.setTask(task);
        
        return step;
    }
}
