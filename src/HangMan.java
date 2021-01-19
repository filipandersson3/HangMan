import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        boolean win = false;
        while (!win) {
            String word = RandomWord();
            System.out.println(word);
            String in = ReadInput();
            System.out.println(in);
            boolean isLetter = CheckIfLetter(in);
            if (isLetter) {
                System.out.println("it's a letter");
            } else {
                if (in.equals(word)) {
                    System.out.println("you guessed the word!");
                    win = true;
                } else {
                    WrongAnswer();
                }
            }
        }
    }

    private static void WrongAnswer() {

    }

    private static boolean CheckIfLetter(String in) {
        boolean isLetter = true;
        if (in.length() > 1) {
            isLetter = false;
        }
        return isLetter;
    }

    private static String ReadInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine().toLowerCase();
    }

    private static String RandomWord() {
        Scanner input = null;
        try {
            input = new Scanner(new File("wordList.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> wordList = new ArrayList<>();
        while (true) {
            assert input != null;
            if (!input.hasNext()) break;
            wordList.add(input.nextLine());
        }
        Random randNum = new Random();
        return wordList.get(randNum.nextInt(wordList.size()));
    }
}