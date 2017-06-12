public class WordWrap {
    public String wrap(String text, int numberOfColumns) {
        if (text.length() <= numberOfColumns){
            return text;
        }
        int endOfFirstWrap = numberOfColumns;
        int beginningOfSecondWrap = numberOfColumns;
        return text.substring(0, endOfFirstWrap)
                + "\n"
                + wrap(text.substring(beginningOfSecondWrap), numberOfColumns);
    }
}
