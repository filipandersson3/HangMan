import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        boolean gameEnd = false;
        String[][] hangingDrawings = HangManDrawings.hangingDrawings;
        String word = RandomWord();
        ArrayList<Character> wrongCharList = new ArrayList<>();
        char[] feedback = getFeedback(word);
        int points = 9;
        while (!gameEnd) {
            DrawHanging(hangingDrawings[9-points]);
            String feedbackString = FeedbackToString(feedback);
            if (feedbackString.equals(word)) {
                System.out.println("you guessed all letters and won!");
                gameEnd = true;
            } else if (points == 0) {
                System.out.println("you ran out of guesses");
                System.out.println("the word was "+word);
                gameEnd = true;
            } else {
                System.out.println(feedbackString);
                System.out.println("you have " + points + " guesses left");
                System.out.println("you have guessed: " + wrongCharList.toString());
                String in = ReadInput();
                if (word.equals("")) {
                    System.out.println("DON'T LEAVE THE GUESS BLANK IDOT YOU DON'T GET TO PLAY ANYMORE");
                    System.exit(0);
                } else if (CheckIfLetter(in)) {
                    points = CheckLetterGuess(word, feedback, in, wrongCharList, points);
                } else {
                    gameEnd = CheckWordGuess(word, in);
                }
            }
        }
    }

    /**
     * takes list of drawings and prints list of strings to console
     * @param hangingDrawing list of drawings
     */
    private static void DrawHanging(String[] hangingDrawing) {
        for (String s : hangingDrawing) {
            System.out.println(s);
        }
    }

    /**
     * turns feedback char array into string
     * @param feedback list of correct letter guesses and blank spaces
     * @return feedback as string
     */
    private static String FeedbackToString(char[] feedback) {
        StringBuilder feedbackString = new StringBuilder();
        for (char c : feedback) {
            feedbackString.append(c);
        }
        return feedbackString.toString();
    }

    private static int CheckLetterGuess(String word, char[] feedback, String in, ArrayList<Character> wrongCharList, int points) {
        if (word.contains(in)) {
            System.out.println("Right letter");
            ArrayList<Integer> letterPlaces = getLetterPlaces(word, in);
            for (Integer letterPlace : letterPlaces) {
                feedback[letterPlace] = in.charAt(0);
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
        if (in.equals(word)) {
            System.out.println("you guessed the word!");
        } else {
            System.out.println("wrong guess, you lose.");
            System.out.println("the word was "+word);
        }
        return true;
    }

    private static ArrayList<Integer> getLetterPlaces(String word, String in) {
            ArrayList<Integer> places = new ArrayList<>();
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
        return wordList.get(randNum.nextInt(wordList.size())).toLowerCase();
    }
}