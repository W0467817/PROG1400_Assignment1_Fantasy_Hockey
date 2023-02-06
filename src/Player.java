/*
Project: Assignment 1, Fantasy Hockey
Author: Brett Longpre - W0467817
*/

public class Player {
    private String playerName;
    private int playerGoals;
    private int playerAssists;


    // PLAYER STATS CONSTRUCTOR
    public Player(String playerName, int playerGoals, int playerAssists) {
        this.playerName = playerName;
        this.playerAssists = playerAssists;
        this.playerGoals = playerGoals;
    }


    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerAssists() {
        return playerAssists;
    }

    public int getPlayerGoals() {
        return playerGoals;
    }

    public int getPlayerTotal() {
        return playerAssists + playerGoals;
    }
}