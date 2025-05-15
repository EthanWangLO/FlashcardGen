import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);

        QuizSession session = new QuizSession(deck);

        System.out.println("📚 Welcome to Flashcard Quiz App!");
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Standard Quiz");
            System.out.println("2. Multiple Choice Quiz");
            System.out.println("3. Flashcard Review");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            String choice = scanner.nextLine();

            if (choice ==1)
            {session.startStandardQuiz();
                    break;}
            if (choice ==2)                    
            {session.startMultipleChoiceQuiz();
                    break;}
            if (choice ==3)
            {System.out.print("Do you want to see the front side first? (yes/no): ");
                    String frontFirst = scanner.nextLine().toLowerCase();
                    session.startFlashcardSession(frontFirst.equals("yes"));
                    break;}
            if (choice ==4)
            {System.out.println("Goodbye!");
                    running = false;
                    break;}
            else
            {System.out.println("❗ Invalid choice. Please enter 1–4.");}
            }
        }

        scanner.close();
    }
}
  
