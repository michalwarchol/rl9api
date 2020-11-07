package com.example.rl9api.api;


import com.example.rl9api.model.Goal;
import com.example.rl9api.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/goal")
@RestController
public class goalController {
    private final GoalService goalService;

    @Autowired
    public goalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public int addGoal(@RequestBody Goal goal){
        return goalService.addGoal(goal);
    }

    @GetMapping
    public List<Goal> selectGoals(){
        return goalService.selectGoals();
    }

    @GetMapping(path = "{id}")
    public Optional<Goal> selectGoalById(@PathVariable("id") UUID id){
        return goalService.selectGoalById(id);
    }

    @PutMapping(path="{id}")
    public int updateGoalById(@PathVariable("id") UUID id, @RequestBody Goal goal){
        return goalService.updateGoalById(id, goal);
    }

    @DeleteMapping(path="{id}")
    public int deleteGoalById(@PathVariable("id") UUID id){
        return goalService.deleteGoalById(id);
    }

}
