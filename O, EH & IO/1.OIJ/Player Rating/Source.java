abstract class Player {

   String firstName;
   String lastName;

   Player(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getName() {
      return getFirstName() + " " + getLastName();
   }

   public abstract int getRating();
}

class CricketPlayer extends Player {
   double avaerageRuns;

   CricketPlayer(String firstName, String lastName, double averageRuns) {
      super(firstName, lastName);
      this.avaerageRuns = averageRuns;
   }

   @Override
   public int getRating() {
      if (this.avaerageRuns > 55)
         return 7;
      else if (this.avaerageRuns > 50)
         return 6;
      else if (this.avaerageRuns > 40)
         return 5;
      else if (this.avaerageRuns > 30)
         return 3;
      else if (this.avaerageRuns > 20)
         return 2;
      else
         return 1;
   }
}

class FootballPlayer extends Player {
   int goals;

   FootballPlayer(String firstName, String lastName, int goals) {
      super(firstName, lastName);
      this.goals = goals;
   }

   @Override
   public int getRating() {
      if (this.goals > 20)
         return 5;
      else if (this.goals > 15)
         return 4;
      else if (this.goals > 10)
         return 3;
      else if (this.goals > 5)
         return 2;
      else
         return 1;
   }
}

public class Source {
   public static void main(String[] args) {
      // CODE HERE
   }
}