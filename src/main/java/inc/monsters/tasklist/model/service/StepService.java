/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.tasklist.model.service;

import inc.monsters.tasklist.model.repository.StepRepository;
import inc.monsters.tasklist.model.entity.Step;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author tcurtis
 */
@Service
public class StepService {
    private StepRepository stepRepository;

    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }
    
    public void save(Step step) {
        stepRepository.save(step);
    }
    
    public Optional findById(Long id) {
        return stepRepository.findById(id);
    }
    
    public List<Step> findByTaskId(Long id) {
        return stepRepository.findByTaskId(id);
    }
}
