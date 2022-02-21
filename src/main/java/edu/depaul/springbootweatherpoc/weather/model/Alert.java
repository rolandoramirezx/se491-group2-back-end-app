package edu.depaul.springbootweatherpoc.weather.model;

import java.sql.Timestamp;

public class Alert {

    private Timestamp timestamp;
    private String message;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
