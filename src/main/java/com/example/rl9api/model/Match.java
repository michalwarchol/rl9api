package com.example.rl9api.model;

import java.util.Date;
import java.util.UUID;

public class Match {
    final UUID id;
    final Date date;
    final int goals;
    final int assists;
    final int yellow_cards;
    final int red_cards;
    final String team;
    final String opponent;
    final String competition;
    final String season;

    public Match(UUID id,
                 Date date,
                 int goals,
                 int assists,
                 int yellow_cards,
                 int red_cards,
                 String team,
                 String opponent,
                 String competition,
                 String season) {
        this.id = id;
        this.date = date;
        this.goals = goals;
        this.assists = assists;
        this.yellow_cards = yellow_cards;
        this.red_cards = red_cards;
        this.team = team;
        this.opponent = opponent;
        this.competition = competition;
        this.season = season;
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getYellow_cards() {
        return yellow_cards;
    }

    public int getRed_cards() {
        return red_cards;
    }

    public String getTeam() {
        return team;
    }

    public String getOpponent() {
        return opponent;
    }

    public String getCompetition() {
        return competition;
    }

    public String getSeason() {
        return season;
    }
}
