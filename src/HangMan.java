import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        boolean gameEnd = false;
        String word = RandomWord();
        char[] feedback = getFeedback(word);
        while (!gameEnd) {
            System.out.println(word);
            System.out.println(feedback);
            String in = ReadInput();
            if (CheckIfLetter(in)) {
                System.out.println("it's a letter");
                if (word.contains(in)) {
                    System.out.println("Right letter");
                    ArrayList<Integer> letterPlaces = getLetterPlaces(word, in);
                    for (int k = 0; k < letterPlaces.size(); k++) {
                        feedback[letterPlaces.get(k)] = in.charAt(0);
                    }
                } else {
                    System.out.println("Wrong letter");
                }
            } else {
                gameEnd = CheckWordGuess(word, in);
            }
        }
    }

    private static char[] getFeedback(String word) {
        char[] feedback = new char[word.length()];
        for (int o = 0; o < word.length(); o++) {
            feedback[o] = '_';
        }
        return feedback;
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

    private static ArrayList<Integer> getLetterPlaces(String word, String in) {
            ArrayList<Integer> places = new ArrayList<>();
            int j = 0;
            System.out.println("at");
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == in.charAt(0)) {
                    places.add(i);
                }
            }
            return places;
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