package com.example.rl9api.dao;

import com.example.rl9api.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres_match")
public class MatchDataAccessService implements MatchDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MatchDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Match> mapMatchFromDb(){
        return ((resultSet, i)->
            new Match(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getDate("date"),
                    resultSet.getInt("goals"),
                    resultSet.getInt("assists"),
                    resultSet.getInt("yellow_cards"),
                    resultSet.getInt("red_cards"),
                    resultSet.getString("team"),
                    resultSet.getString("opponent"),
                    resultSet.getString("competition"),
                    resultSet.getString("season")
            ));
    }

    @Override
    public int addMatch(UUID id, Match match) {
        String sql = "INSERT INTO t_match (id, " +
                "date, " +
                "goals, " +
                "assists, " +
                "yellow_cards, " +
                "red_cards, " +
                "team, " +
                "opponent, " +
                "competition, " +
                "season) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        return jdbcTemplate.update(sql,
                id,
                match.getDate(),
                match.getGoals(),
                match.getAssists(),
                match.getYellow_cards(),
                match.getRed_cards(),
                match.getTeam(),
                match.getOpponent(),
                match.getCompetition(),
                match.getSeason());
    }

    @Override
    public Optional<Match> selectMatchById(UUID id) {
        String sql = "SELECT * FROM t_match WHERE id=?;";
        Match match = jdbcTemplate.queryForObject(sql, new Object[]{id}, mapMatchFromDb());
        return Optional.ofNullable(match);
    }

    @Override
    public List<Match> selectAllMatches() {
        String sql = "SELECT * FROM t_match;";
        return jdbcTemplate.query(sql, mapMatchFromDb());
    }

    @Override
    public int updateMatchById(UUID id, Match match) {
        String sql = "UPDATE t_match SET " +
                "date=? " +
                "goals=? " +
                "assists=?" +
                "yellow_cards=? " +
                "red_cards=? " +
                "team=? " +
                "opponent=? " +
                "competition=? " +
                "season=? " +
                "WHERE id=?;";
        return jdbcTemplate.update(sql,
                match.getDate(),
                match.getGoals(),
                match.getAssists(),
                match.getYellow_cards(),
                match.getRed_cards(),
                match.getTeam(),
                match.getOpponent(),
                match.getCompetition(),
                match.getSeason(),
                id);
    }

    @Override
    public int deleteMatchById(UUID id) {
        String sql = "DELETE FROM t_match WHERE id=?;";
        return jdbcTemplate.update(sql, id);
    }
}