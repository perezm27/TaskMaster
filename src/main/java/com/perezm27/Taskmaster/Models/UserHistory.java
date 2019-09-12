package com.perezm27.Taskmaster.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.util.Date;

@DynamoDBDocument
public class UserHistory {
    private String date;
    private String action;

//  Empty Constructor
    public UserHistory() {}

//  UserHistory Constructor
    public UserHistory(String action)
    {
        this.date = new Date(System.currentTimeMillis()).toString();
        this.action = action;
    }


//  Getters && Setters
    public String getDate() { return this.date; }

    public void setDate(String date) { this.date = date; }

    public String getAction() { return action; }

    public void setAction(String action) { this.action = action; }
}
