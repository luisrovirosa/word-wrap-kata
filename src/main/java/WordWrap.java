public class WordWrap {
    public String wrap(String text, int numberOfColumns) {
        if (text.length() <= numberOfColumns){
            return text;
        }
        return text.substring(0, numberOfColumns) + "\n" + text.substring(numberOfColumns);
    }
}
