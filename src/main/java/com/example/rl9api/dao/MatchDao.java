package com.example.rl9api.dao;

import com.example.rl9api.model.Match;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MatchDao {
    int addMatch(UUID id, Match match);

    default int addMatch(Match match){
        UUID id = UUID.randomUUID();
        return addMatch(id, match);
    }

    Optional<Match> selectMatchById(UUID id);

    List<Match> selectAllMatches();

    int updateMatchById(UUID id, Match match);

    int deleteMatchById(UUID id);
}
