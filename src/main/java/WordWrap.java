public class WordWrap {
    public String wrap(String text, int numberOfColumns) {
        if (text.length() <= numberOfColumns){
            return text;
        }
        int endOfFirstWrap = hasSpacesWithinColumns(text, numberOfColumns) ? positionOfSpace(text) : numberOfColumns;
        int beginningOfSecondWrap = hasSpacesWithinColumns(text, numberOfColumns) ? positionOfSpace(text) + 1 : numberOfColumns;
        String firstWrap = text.substring(0, endOfFirstWrap);
        return firstWrap
                + "\n"
                + wrap(text.substring(beginningOfSecondWrap), numberOfColumns);
    }

    private boolean hasSpacesWithinColumns(String text, int numberOfColumns) {
        int positionOfFirstSpace = positionOfSpace(text);
        return positionOfFirstSpace > -1 && positionOfFirstSpace <= numberOfColumns;
    }

    private int positionOfSpace(String text) {
        return text.indexOf(" ");
    }

}
