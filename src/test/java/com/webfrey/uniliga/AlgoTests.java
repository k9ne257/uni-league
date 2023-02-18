package com.webfrey.uniliga;

public class AlgoTests {

    public static void main(String[] args) {
        roundRobinWithBye(8);
    }


    public static void roundRobinWithBye(int n) {
        if (n % 2 != 0) {
            // If the number of teams is odd, add a dummy team to make it even
            n++;
        }

        String[][] rounds = new String[n - 1][n / 2];

        int[] teams = new int[n];
        for (int i = 0; i < n; i++) {
            teams[i] = i + 1;
        }

        int[] fixed = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            fixed[i] = teams[i];
        }

        int[] rotating = new int[(n / 2) - 1];
        for (int i = n / 2; i < n - 1; i++) {
            rotating[i - n / 2] = teams[i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n / 2; j++) {
                int team1 = fixed[j];
                int team2 = rotating[j];

                rounds[i][j] = team1 + "," + team2;

                int temp = rotating[0];
                for (int k = 0; k < n / 2 - 2; k++) {
                    rotating[k] = rotating[k + 1];
                }
                rotating[n / 2 - 2] = fixed[n / 2 - 1];
                fixed[n / 2 - 1] = temp;
            }
        }

        // Remove the dummy team if added
        if (n % 2 != 0) {
            n--;
        }

        // Print the schedule
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Round " + (i + 1) + ": ");
            for (int j = 0; j < n / 2; j++) {
                System.out.println(rounds[i][j]);
            }
            System.out.println();
        }
    }

}
