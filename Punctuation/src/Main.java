public class Main {

    public static void main(String[] args) {
        String input = args[0];

        System.out.println(getRidOfPunctuation(input));
    }

    public static String getRidOfPunctuation(String input) {

        return input.replaceAll("\\p{Punct}", "");
    }
}
