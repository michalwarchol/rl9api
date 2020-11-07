package com.example.rl9api.service;

import com.example.rl9api.dao.MatchDao;
import com.example.rl9api.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MatchService {
    private final MatchDao matchDao;

    @Autowired
    public MatchService(@Qualifier("postgres_match") MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    public int addMatch(Match match){ return matchDao.addMatch(match);}

    public Optional<Match> selectMatchById(UUID id){
        return matchDao.selectMatchById(id);
    }

    public List<Match> selectAllMatches() {
        return matchDao.selectAllMatches();
    }

    public int updateMatchById(UUID id, Match match){ return matchDao.updateMatchById(id, match);}

    public int deleteMatchById(UUID id){ return matchDao.deleteMatchById(id);}
}
