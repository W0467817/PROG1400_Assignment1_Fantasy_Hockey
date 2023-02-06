/*
Project: Assignment 1, Fantasy Hockey
Author: Brett Longpre - W0467817
*/

import java.util.ArrayList;

public class Team {
    private int teamGoals = 0;
    private int teamAssists = 0;
    private double teamBudget = 000000.00;
    private int teamRating = 0;

    // Dedicated arraylist for team names as team objects haven't been created yet
    private static ArrayList<String> teamNames = new ArrayList<String>();


    // TEAM STATS CONSTRUCTOR
    public Team(int teamGoals, int teamAssists, double teamBudget, int teamRating) {
        this.teamGoals = teamGoals;
        this.teamAssists = teamAssists;
        this.teamBudget = teamBudget;
        this.teamRating = teamRating;
    }


    public int getTeamGoals() {
        return teamGoals;
    }

    public int getTeamAssists() {
        return teamAssists;
    }

    public int getTeamTotal() {
        return teamAssists + teamGoals;
    }

    public double getTeamBudget() {
        return teamBudget;
    }

    public int getTeamRating() {
        return teamRating;
    }


    public static String getTeamName(int x) {
        return teamNames.get(x);
    }

    public static void addTeamName(String x) {
        teamNames.add(x);
    }

    public static int getTeamNamesSize() {
        return teamNames.size();
    }
}