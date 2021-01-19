import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) {
        String word = RandomWord();
        System.out.println(word);
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
        String word = wordList.get(randNum.nextInt(wordList.size()));
        return word;
    }
}