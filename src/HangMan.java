import java.util.Random;

public class HangMan {
    public static void main(String[] args) {
        String word = RandomWord();
        System.out.println(word);
    }

    private static String RandomWord() {
        Random randNum = new Random();
        String[] wordList = {"hello","word","sample"};
        String word = wordList[randNum.nextInt(wordList.length)];
        return word;
    }
}