public class WordWrap {
    public String wrap(String text, int numberOfColumns) {
        if (text.length() <= numberOfColumns){
            return text;
        }
        int positionOfFirstSpace = text.indexOf(" ");
        int endOfFirstWrap = hasSpacesWithinColumns(text, numberOfColumns) ? positionOfFirstSpace : numberOfColumns;
        int beginningOfSecondWrap = hasSpacesWithinColumns(text, numberOfColumns) ? positionOfFirstSpace + 1 : numberOfColumns;
        return text.substring(0, endOfFirstWrap)
                + "\n"
                + wrap(text.substring(beginningOfSecondWrap), numberOfColumns);
    }

    private boolean hasSpacesWithinColumns(String text, int numberOfColumns) {
        int positionOfFirstSpace = text.indexOf(" ");
        return positionOfFirstSpace > -1 && positionOfFirstSpace <= numberOfColumns;
    }

}
