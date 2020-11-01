package com.example.rl9api.api;


import com.example.rl9api.model.Goal;
import com.example.rl9api.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public List<Goal> selectGoals(){
        return goalService.selectGoals();
    }

    public Optional<Goal> selectGoalById(UUID id){
        return goalService.selectGoalById(id);
    }

    public int updateGoalById(UUID id, Goal goal){
        return goalService.updateGoalById(id, goal);
    }

    public int deleteGoalById(UUID id){
        return goalService.deleteGoalById(id);
    }

}
