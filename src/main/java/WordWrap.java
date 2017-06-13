public class WordWrap {
    public String wrap(String text, int numberOfColumns) {
        if (text.length() <= numberOfColumns) {
            return text;
        }
        return firstWrap(text, numberOfColumns)
                + "\n"
                + secondWrap(text, numberOfColumns);
    }

    private String firstWrap(String text, int numberOfColumns) {
        int endOfFirstWrap = hasSpacesWithinColumns(text, numberOfColumns) ? positionOfSpace(text, numberOfColumns) : numberOfColumns;
        return text.substring(0, endOfFirstWrap);
    }

    private String secondWrap(String text, int numberOfColumns) {
        int beginningOfSecondWrap = hasSpacesWithinColumns(text, numberOfColumns) ? positionOfSpace(text, numberOfColumns) + 1 : numberOfColumns;
        return wrap(text.substring(beginningOfSecondWrap), numberOfColumns);
    }

    private boolean hasSpacesWithinColumns(String text, int numberOfColumns) {
        int positionOfFirstSpace = positionOfSpace(text, numberOfColumns);
        return positionOfFirstSpace > -1;
    }

    private int positionOfSpace(String text, int numberOfColumns) {
        return positionOfSpace(text, numberOfColumns, 0);
    }

    private int positionOfSpace(String text, int numberOfColumns, int startingOn) {
        int positionOfNextSpace = text.indexOf(" ", startingOn + 1);
        if (positionOfNextSpace == -1 || positionOfNextSpace > numberOfColumns) {
            return -1;
        }
        return Math.max(positionOfNextSpace, positionOfSpace(text, numberOfColumns, positionOfNextSpace));
    }

}
