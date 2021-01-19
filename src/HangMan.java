import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        while (true) {
            String word = RandomWord();
            System.out.println(word);
            String in = ReadInput();
            System.out.println(in);
        }
    }

    private static String ReadInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
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