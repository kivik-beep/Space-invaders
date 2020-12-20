package spaceinvaders.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * For keeping up the high scores.
 *
 * @author kxkivi
 */
public class Records {

    ArrayList<Player> scores = new ArrayList<>();

    /**
     * This method reads the file containing high score information.
     * 
     * @return high scores in arrayList
     */
    public ArrayList<Player> getHighScores() {

        try (Scanner reader = new Scanner(new File("highscores.csv"))) {
            while (reader.hasNextLine()) {
                String score = reader.nextLine();

                if (score.trim().length() == 0) {
                    continue;
                }

                String[] parts = score.split(",");

                String name = parts[0];
                int points = Integer.valueOf(parts[1]);

                Player i = new Player(name, points);

                scores.add(i);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Records.class.getName()).log(Level.SEVERE, null, ex);
        }

        trim(this.scores);
        return this.scores;
    }

    /**
     * Method used to add a player in top 10.Used by End in package UI.
     *
     * @param player 
     */
    public void addScore(Player player) {
        this.getHighScores();
        scores.add(player);

        File added = new File("highscores.csv");
        try {
            PrintWriter write = new PrintWriter(added);
            for (int i = 0; i < this.scores.size(); i++) {
                write.println(this.scores.get(i).toSave());
            }
            write.close();
            scores.clear();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Records.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method trims the top10 to 10, and arrays data.
     * 
     * @param list the top10 list
     * @return trimmed version of top10
     */
    public ArrayList trim(ArrayList list) {

        Collections.sort(list);
        while(list.size()>10){
            list.remove(10);
        }
        return list;
    }
}
