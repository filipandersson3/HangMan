import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        boolean gameEnd = false;
        String word = RandomWord();
        char[] correctCharList = new char[word.length()];
        for (int o = 0; o < word.length(); o++) {
            correctCharList[o] = '_';
        }
        while (!gameEnd) {
            System.out.println(word);
            System.out.println(correctCharList);
            String in = ReadInput();
            System.out.println(in);
            boolean isLetter = CheckIfLetter(in);
            if (isLetter) {
                System.out.println("it's a letter");
                CheckLetterGuess(word, in);
            } else {
                gameEnd = CheckWordGuess(word, in);
            }
        }
    }

    private static boolean CheckWordGuess(String word, String in) {
        boolean gameEnd;
        if (in.equals(word)) {
            System.out.println("you guessed the word!");
            gameEnd = true;
        } else {
            System.out.println("wrong guess, you lose.");
            gameEnd = true;
        }
        return gameEnd;
    }

    private static void CheckLetterGuess(String word, String in) {
        if (word.contains(in)) {
            System.out.println("at");
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == in.charAt(0)) {
                    System.out.println("place " + i);
                }
            }
        } else {
            System.out.println("wrong letter");
        }
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