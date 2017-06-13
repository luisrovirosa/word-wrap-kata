public class WordWrap {
    public String wrap(String text, int numberOfColumns) {
        if (text.length() <= numberOfColumns){
            return text;
        }
        int beginningOfSecondWrap = hasSpacesWithinColumns(text, numberOfColumns) ? positionOfSpace(text) + 1 : numberOfColumns;
        String secondWrap = wrap(text.substring(beginningOfSecondWrap), numberOfColumns);
        return firstWrap(text, numberOfColumns)
                + "\n"
                + secondWrap;
    }

    private String firstWrap(String text, int numberOfColumns) {
        int endOfFirstWrap = hasSpacesWithinColumns(text, numberOfColumns) ? positionOfSpace(text) : numberOfColumns;
        return text.substring(0, endOfFirstWrap);
    }

    private boolean hasSpacesWithinColumns(String text, int numberOfColumns) {
        int positionOfFirstSpace = positionOfSpace(text);
        return positionOfFirstSpace > -1 && positionOfFirstSpace <= numberOfColumns;
    }

    private int positionOfSpace(String text) {
        return text.indexOf(" ");
    }

}
