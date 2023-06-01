import java.util.Random;
import java.util.Scanner;

public class MathQuiz {
    public static void main(String[] args) {
        int numberOfQuestions = 10;
        int score = 0;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= numberOfQuestions; i++) {
            int number1 = random.nextInt(10) + 1;
            int number2 = random.nextInt(10) + 1;
            int operator = random.nextInt(4); // 0: addition, 1: subtraction, 2: multiplication, 3: division
            int correctAnswer = 0;
            String operatorSymbol = "";

            switch (operator) {
                case 0:
                    correctAnswer = number1 + number2;
                    operatorSymbol = "+";
                    break;
                case 1:
                    correctAnswer = number1 - number2;
                    operatorSymbol = "-";
                    break;
                case 2:
                    correctAnswer = number1 * number2;
                    operatorSymbol = "*";
                    break;
                case 3:
                    correctAnswer = number1 / number2;
                    operatorSymbol = "/";
                    break;
            }

            System.out.print("Question " + i + ": ");
            System.out.print(number1 + " " + operatorSymbol + " " + number2 + " = ");

            int userAnswer = scanner.nextInt();
            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + numberOfQuestions);
    }
}
