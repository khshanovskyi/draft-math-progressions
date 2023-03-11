package leetcode;

public class SortingTheSentence {

    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }

    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] res = new String[words.length];
        int inx;

        for (String word : words) {
            inx = Character.getNumericValue(word.charAt(word.length() - 1));
            res[inx - 1] = word.substring(0, word.length() - 1);
        }

        return String.join(" ", res);
    }

}
