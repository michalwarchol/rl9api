package com.example.rl9api.api;

import com.example.rl9api.model.Match;
import com.example.rl9api.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/match")
@RestController
public class matchController {
    private final MatchService matchService;

    @Autowired
    public matchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public int addMatch(@RequestBody Match match){
        return matchService.addMatch(match);
    }

    @GetMapping(path="{id}")
    public Optional<Match> selectMatchById(@PathVariable("id") UUID id){
        return matchService.selectMatchById(id);
    }

    @GetMapping
    public List<Match> selectAllMatches(){
        return matchService.selectAllMatches();
    }

    @PutMapping(path="{id}")
    public int updateMatchById(@PathVariable("id") UUID id, @RequestBody Match match){
        return matchService.updateMatchById(id, match);
    }

    @DeleteMapping(path="{id}")
    public int deleteMatchById(@PathVariable("id") UUID id){
        return matchService.deleteMatchById(id);
    }
}
