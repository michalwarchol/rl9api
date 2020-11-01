package com.example.rl9api.dao;

import com.example.rl9api.model.Goal;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class GoalDataAccessService implements GoalDao {
    @Override
    public int addGoal(UUID id, Goal goal) {
        return 0;
    }

    @Override
    public List<Goal> selectGoals() {
        return null;
    }

    @Override
    public Optional<Goal> selectGoalById(UUID id) {
        return null;
    }

    @Override
    public int updateGoalById(UUID id, Goal goal) {
        return 0;
    }

    @Override
    public int deleteGoalById(UUID id) {
        return 0;
    }
}
