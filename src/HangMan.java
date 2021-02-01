import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        boolean gameEnd = false;
        String word = RandomWord();
        ArrayList<Character> wrongCharList = new ArrayList<>();
        char[] feedback = getFeedback(word);
        int points = 10;
        while (!gameEnd) {
            String feedbackString = FeedbackToString(feedback);
            if (feedbackString.equals(word)) {
                System.out.println("you guessed all letters and won!");
                gameEnd = true;
            } else if (points == 0) {
                System.out.println("you ran out of guesses");
                gameEnd = true;
            } else {
                System.out.println(word);
                System.out.println(feedbackString);
                System.out.println("you have " + points + " guesses left");
                System.out.println("you have guessed: " + wrongCharList.toString());
                String in = ReadInput();
                if (CheckIfLetter(in)) {
                    System.out.println("it's a letter");
                    points = CheckLetterGuess(word, feedback, in, wrongCharList, points);
                } else {
                    gameEnd = CheckWordGuess(word, in);
                }
            }
        }
    }

    private static String FeedbackToString(char[] feedback) {
        String feedbackString = "";
        for (char c : feedback) {
            feedbackString += c;
        }
        return feedbackString;
    }

    private static int CheckLetterGuess(String word, char[] feedback, String in, ArrayList<Character> wrongCharList, int points) {
        if (word.contains(in)) {
            System.out.println("Right letter");
            ArrayList<Integer> letterPlaces = getLetterPlaces(word, in);
            for (int k = 0; k < letterPlaces.size(); k++) {
                feedback[letterPlaces.get(k)] = in.charAt(0);
            }
            return --points;
        } else {
            System.out.println("Wrong letter");
            if (!wrongCharList.contains(in.charAt(0))) {
                wrongCharList.add(in.charAt(0));
                return --points;
            } else {
                System.out.println("you have already guessed that");
            }
        }
        return points;
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