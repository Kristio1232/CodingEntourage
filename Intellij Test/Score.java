import java.util.*;
public class Score {

   private  String[] scores;

   public Score()
   {
       this.scores = new String[2];
   }
   public void add(String name,Integer score)
   {
       String myScore = score.toString();
       this.scores[0] = name;
       this.scores[1] = myScore;
   }

    public String[] getScores() {
        return scores;
    }

    public String toString()
    {
        return Arrays.toString(scores);
    }

}



