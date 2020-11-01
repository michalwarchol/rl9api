package com.example.rl9api.dao;

import com.example.rl9api.model.Goal;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GoalDao {
    int addGoal(UUID id, Goal goal);

    default int addGoal(Goal goal){
        UUID id = UUID.randomUUID();
        return addGoal(id,goal);
    }

    List<Goal> selectGoals();

    Optional<Goal> selectGoalById(UUID id);

    int updateGoalById(UUID id, Goal goal);

    int deleteGoalById(UUID id);
}
