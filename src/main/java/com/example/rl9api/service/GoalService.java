package com.example.rl9api.service;

import com.example.rl9api.dao.GoalDao;
import com.example.rl9api.model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GoalService {
    private final GoalDao goalDao;

    @Autowired
    public GoalService(@Qualifier("postgres") GoalDao goalDao) {
        this.goalDao = goalDao;
    }

    public int addGoal(Goal goal){
        return goalDao.addGoal(goal);
    }

    public List<Goal> selectGoals(){
        return goalDao.selectGoals();
    }

    public Goal selectGoalById(UUID id){
        return goalDao.selectGoalById(id);
    }

    public int updateGoalById(UUID id, Goal goal){
        return goalDao.updateGoalById(id, goal);
    }

    public int deleteGoalById(UUID id){
        return goalDao.deleteGoalById(id);
    }

}
