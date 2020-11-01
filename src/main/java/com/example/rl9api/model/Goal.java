package com.example.rl9api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Goal {
    final UUID id;
    final int minute;
    final int year;
    final int month;
    final int day;
    final String opponent;
    final String team;

    public Goal(@JsonProperty("id") UUID id,
                @JsonProperty("minute") int minute,
                @JsonProperty("year") int year,
                @JsonProperty("month") int month,
                @JsonProperty("day") int day,
                @JsonProperty("opponent") String opponent,
                @JsonProperty("team") String team) {
        this.id = id;
        this.minute = minute;
        this.year = year;
        this.month = month;
        this.day = day;
        this.opponent = opponent;
        this.team = team;
    }

    public UUID getId() {
        return id;
    }

    public int getMinute() {
        return minute;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getOpponent() {
        return opponent;
    }

    public String getTeam() {
        return team;
    }
}
