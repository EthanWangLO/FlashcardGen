import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Flashcard{
  private String front;
  private String back;
  //setting up constructors and getfront getback
  public Flashcard(String fr, String ba)
  {
    this.front = fr;
    this.back = ba;
  }
  public String getFront()
  { return front;}
  public String getBack()
  { return back;}
}
public class Deck{
  private ArrayList<Flashcard> cards;
  public Deck()
  {
    cards = new ArrayList<>();
  }
  public void addCard(Flashcard card)
  { cards.add(card); }
  public void removeCard(int index)
  {
    if (index>=0 && index<cards.size()) //make sure cant remove a 0
    {
      cards.remove(index);
    }
    else
    {
      System.out.println("Invalid index. Card not removed.");
    }
  }
  public Flaschard getCard(int index)
  {
      if (index >=0 && index<cards.size())
      {
        return cards.get(index);
      }
      else
      {
        System.out.println("Invalid index. Returning null.");
        return null;
      }
  }
  public void shuffle()
  {
    Collections.shuffle(cards); // shuffle the cards
  }
  public int size()
  {
    return cards.size();
  }
  pubic void printAllCards()
  {
    for (int i = 0; i <cards.size();i++) // for loop to print all of the cards
      {
        System.out.println("Card" + (i+1) + ":\n" + cards.get(i) + "\n");
      }
  }
}
public class QuizSession
  {
    private Deck deck;
    private Scanner scanner;

    public Quizsession(Deck d)
    {
      this.deck = deck;
      this.scanner = new Scanner(System.in);
    }
    //Standard quiz: user types the answer
    public void startStandardQuiz()
    {
      ArrayList<Flashcard> cards = neww ArrayList<>(deck.getAllCards());
      Collections.shuffle(cards);

      System.out.println("\n--- Standard Quiz ===");
      int correct = 0;

      for (Flashcard card: cards)
        {  //setting up the question for each card
          System.out.println("Front: " + card.getFront());
          System.out.print("Your answer: ");
          String answer = scanner.nextLine();

          if (answer.equalsIgnoreCase(card.getBack()))
          {
            System.out.println("Correct!\n");
            correct++;
          }
          else
          {
            System,out.println("Incorrect. The correct answer was: " + card.getBack() + "\n");
          }
        } //prints the total correct
      System.out.println("You got " + correct + "/" + cards.size() + " correct.");
    }
    //Multiple choice quiz: user picks from 4 options
    public void startMultipleChoiceQuiz()
    {
      ArrayList<Flashcard> cards = new ArrayList<>(deck.getAllCards());
      Random rand = new Random();
      Collections.shuffle(cards);

      System.out.println("\n--- Multiple Choice Quiz ---");
      int correct = 0;

      for (Flashcard card: cards)
        {
          ArrayList<String> options = new ArrayList<>();
          options.add(card.getBack());

          //Get 3 random incorrect answers
          while (options.size() < 4)
            {
              Flashcard randomCard = cards.get(rand.nextInt(cards.size()));
              String back = randomCard.getBack();
              if (!options.contains(back))
              {
                options.add(back);
              }
            }
          Collections.shuffle(options);
          //print out the options to see
          System.out.println("Front: " + card.getFront());
          for (int i = 0; i<4; i++)
            {
              System.out.println((i+1)+": "+options.get(i));
            }
          System.out.print("Choose 1-4: ");
          int choice = scanner.nextInt();
          scanner.nextLine(); //consume newline

          if (options.get(choice-1).equals(card.getBack()))
          {
            System.out.println("Correct!\n");
            correct++;
          }
          else
          {
            System.out.println("Incorrect. The correct answer was: " + card.getBack() + "\n");
          }
        }//print total score
      System.out.println("You got " + correct + "/" + cards.size() + " correct.");
    }
    //Flashcard review session
    public void startFlashcardSession(boolean frontFirst){
      ArrayList<Flashcard> cards = new ArrayList<>(deck.getAllCards());
      Collections.shuffle(cards);

      System.out.println("\n--- Flashcard Review ---");
        for (Flashcard card : cards) {
            boolean showingFront = frontFirst;
            boolean flipping = true;
            
            while (flipping) {
                if (showingFront) {
                    System.out.println("Front: " + card.getFront());
                } else {
                    System.out.println("Back: " + card.getBack());
                }
                //show the front/back and then show the opposite based on user input
                System.out.print("Type 'flip' to see the other side, or 'next' to move on: ");
                String command = scanner.nextLine().toLowerCase();

                if (command.equals("flip")) {
                    showingFront = !showingFront;
                } else if (command.equals("next")) {
                    flipping = false;
                } else {
                    System.out.println("Invalid command.");
                }
            }
        }

        System.out.println("Flashcard review complete.");
    }
}
