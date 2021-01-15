import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
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
        while (input.hasNext()) {
            wordList.add(input.nextLine());
            input.nextLine();
        }
        Random randNum = new Random();
        String word = wordList[randNum.nextInt(wordList.length)];
        return word;
    }
}