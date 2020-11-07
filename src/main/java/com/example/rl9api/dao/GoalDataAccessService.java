package com.example.rl9api.dao;

import com.example.rl9api.model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class GoalDataAccessService implements GoalDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GoalDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Goal> mapGoalFromDb(){
        return ((resultSet, i) ->
                new Goal(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getInt("minute"),
                    UUID.fromString(resultSet.getString("match_id"))
        ));
    }

    @Override
    public int addGoal(UUID id, Goal goal) {
        String sql = "INSERT INTO t_goal("+
                "id, "+
                "minute, "+
                "match_id) "+
                "VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, id,
                goal.getMinute(),
                goal.getMatch_id());
    }

    @Override
    public List<Goal> selectGoals() {
        String sql = "SELECT * FROM t_goal;";
        return jdbcTemplate.query(sql, mapGoalFromDb());
    }

    @Override
    public Optional<Goal> selectGoalById(UUID id) {
        String sql = "SELECT * from t_goal WHERE id=?";
        Goal goal = jdbcTemplate.queryForObject(sql, new Object[]{id}, mapGoalFromDb());
        return Optional.ofNullable(goal);
    }

    @Override
    public int updateGoalById(UUID id, Goal goal) {
        String sql = "UPDATE t_goal " +
                "SET " +
                "minute=?" +
                "match_id=?" +
                "WHERE id=?";
        return jdbcTemplate.update(sql,
                goal.getMinute(),
                goal.getMatch_id(),
                id);
    }

    @Override
    public int deleteGoalById(UUID id) {
        String sql = "DELETE FROM t_goal WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
}
