public class WordWrap {
    public String wrap(String text, int numberOfColumns) {
        if (text.length() <= numberOfColumns){
            return text;
        }
        int endOfFirstWrap = numberOfColumns;
        int beginningOfSecondWrap = numberOfColumns;
        int positionOfFirstSpace = text.indexOf(" ");
        if (hasSpacesWithinColumns(text, numberOfColumns)){
            endOfFirstWrap = positionOfFirstSpace;
            beginningOfSecondWrap = positionOfFirstSpace + 1;
        }
        return text.substring(0, endOfFirstWrap)
                + "\n"
                + wrap(text.substring(beginningOfSecondWrap), numberOfColumns);
    }

    private boolean hasSpacesWithinColumns(String text, int numberOfColumns) {
        int positionOfFirstSpace = text.indexOf(" ");
        return positionOfFirstSpace > -1 && positionOfFirstSpace <= numberOfColumns;
    }

}
