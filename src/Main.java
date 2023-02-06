/*
Project: Assignment 1, Fantasy Hockey
Author: Brett Longpre - W0467817
*/

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Main {

    // Method to validate input as integer
    public static int validateInt(Scanner input, String promptText) {
        int y = 0;
        boolean inputValid = false;
        while (!inputValid) {
            System.out.print(promptText);
            if (input.hasNextInt()) {
                y = input.nextInt();
                input.nextLine();
                inputValid = true;
            } else {
                System.out.println("Invalid input. Enter a positive integer.");
                input.nextLine();
            }
        }
        return y;
    }

    // Method to validate input as string and ensure they are a minimum of 3 characters
    public static String validateString(Scanner input, String promptText) {
        String x = "";
        boolean inputValid = false;

        while (!inputValid) {
            System.out.print(promptText);
            x = input.nextLine();
            if (x.length() >= 3) {
                inputValid = true;
            } else {
                System.out.println("Invalid input. Enter a string with a minimum of 3 characters.");
            }
        }
        return x;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Initial output text on program start
        System.out.println("\nFANTASY HOCKEY APPLICATION\n\n\n" + "TEAM ENTRY\n" + "================================");

        // Team input
        int teamCount = validateInt(input, "Enter number of teams: ");

        for (int i = 0; i < teamCount; i++) {
            String teamName = validateString(input, "\nEnter name for team # " + (i + 1) + ": ");
            Team.addTeamName(teamName);
        }


        // Multidimensional array for each team's set of players
        Player[][] teamPlayers = new Player[Team.getTeamNamesSize()][3];


        // Player input
        System.out.print("\n\nPLAYER ENTRY\n" + "================================");
        for (int y = 0; y < Team.getTeamNamesSize(); y++) {
            System.out.print("\nEnter players for " + Team.getTeamName(y));
            for (int i = 0; i < Team.getTeamNamesSize(); i++) {

                // Call one of the two validation methods within the Main class. validateInt for integers and validateString for strings
                String playerName = validateString(input, "\nEnter name for Player # " + (i + 1) + ": ");
                int playerGoals = validateInt(input, "Enter number of goals for " + playerName + ": ");
                int playerAssists = validateInt(input, "Enter number of assists for " + playerName + ": ");

                // Player object constructed
                Player currentPlayer = new Player(playerName, playerGoals, playerAssists);
                // Add player object to teamPlayers object array
                teamPlayers[y][i] = currentPlayer;
            }
        }


        // Calculate team goals and assists
        int teamGoals = 0;
        int teamAssists = 0;

        if (Team.getTeamNamesSize() > 0) {
            for (int y = 0; y < Team.getTeamNamesSize(); y++) {
                for (int i = 0; i < Team.getTeamNamesSize(); i++) {
                    teamGoals += teamPlayers[y][i].getPlayerGoals();
                    teamAssists += teamPlayers[y][i].getPlayerAssists();
                }
            }
        }


        // Team rating
        int teamTotal = teamGoals + teamAssists;
        int rating;
        if (teamTotal > 20) {
            rating = 3;
        } else if (teamTotal >= 10) {
            rating = 2;
        } else if (teamTotal > 0) {
            rating = 1;
        } else {
            rating = 0;
        }


        // Create object array for team stats objects
        Team[] team = new Team[Team.getTeamNamesSize()];

        for (int i = 0; i < Team.getTeamNamesSize(); i++) {
            // Team budget
            double rand = Math.random() * 100000.00;  // 0 to 100000
            BigDecimal budgetOutput = new BigDecimal(rand).setScale(2, RoundingMode.HALF_UP);

            // Team object creation
            Team currentTeam = new Team(teamGoals, teamAssists, budgetOutput.doubleValue(), rating);
            team[i] = currentTeam;
        }


        // Team stats
        System.out.println("REPORT: Stats per Team\n" + "================================");

        for (int i = 0; i < Team.getTeamNamesSize(); i++) {
            // Calculate team's star rating
            String ratingOutput;

            if (team[i].getTeamRating() == 3) {
                ratingOutput = "***";
            } else if (team[i].getTeamRating() == 2) {
                ratingOutput = "**";
            } else if (team[i].getTeamRating() == 1) {
                ratingOutput = "*";
            } else {
                ratingOutput = "No";
            }

            // Retrieve team stats from the team object array then print them
            System.out.println(Team.getTeamName(i) +
                    "    G - " + team[i].getTeamGoals() +
                    "    A - " + team[i].getTeamAssists() +
                    "    Total - " + team[i].getTeamTotal() +
                    "    Budget - $" + team[i].getTeamBudget() +
                    "\nRating: " + ratingOutput + " stars\n"
            );
        }


        // PLAYER STATS
        System.out.println("REPORT: Stats per player\n" + "================================");
        for (int y = 0; y < Team.getTeamNamesSize(); y++) {
            int temp = team.length;

            // The for-loop retrieves each player's stats from object array and prints them
            for (int i = 0; i < temp; i++) {
                System.out.println(Team.getTeamName(y) + "\n" +
                        teamPlayers[y][i].getPlayerName() +
                        "    G - " + teamPlayers[y][i].getPlayerGoals() +
                        "    A - " + teamPlayers[y][i].getPlayerAssists() +
                        "    Total - " + teamPlayers[y][i].getPlayerTotal()
                );
            }
            // This is for consistent formatting of the output, outside the nested for loop
            System.out.print("\n");
        }
    }
}