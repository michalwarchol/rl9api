package com.example.rl9api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.UUID;

public class Goal {
    final UUID id;
    final int minute;
    final UUID match_id;

    public Goal(@JsonProperty("id") UUID id,
                @JsonProperty("minute") int minute,
                @JsonProperty("match_id") UUID match_id) {
        this.id = id;
        this.minute = minute;
        this.match_id=match_id;
    }

    public UUID getId() {
        return id;
    }

    public int getMinute() {
        return minute;
    }

    public UUID getMatch_id() {
        return match_id;
    }

}
