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
        int endOfFirstWrap = hasSpaceWithinColumns(text, numberOfColumns)
                ? positionOfLastSpaceWithinColumns(text, numberOfColumns)
                : numberOfColumns;
        return text.substring(0, endOfFirstWrap);
    }

    private String secondWrap(String text, int numberOfColumns) {
        int beginningOfSecondWrap = hasSpaceWithinColumns(text, numberOfColumns)
                ? positionOfLastSpaceWithinColumns(text, numberOfColumns) + 1
                : numberOfColumns;
        return wrap(text.substring(beginningOfSecondWrap), numberOfColumns);
    }

    private boolean hasSpaceWithinColumns(String text, int numberOfColumns) {
        int positionOfFirstSpace = positionOfLastSpaceWithinColumns(text, numberOfColumns);
        return positionOfFirstSpace != -1;
    }

    private int positionOfLastSpaceWithinColumns(String text, int numberOfColumns) {
        return positionOfNextSpaceWithinColumns(text, numberOfColumns, 0);
    }

    private int positionOfNextSpaceWithinColumns(String text, int numberOfColumns, int startingOn) {
        int positionOfNextSpace = text.indexOf(" ", startingOn + 1);
        if (positionOfNextSpace == -1 || positionOfNextSpace > numberOfColumns) {
            return -1;
        }
        return Math.max(positionOfNextSpace, positionOfNextSpaceWithinColumns(text, numberOfColumns, positionOfNextSpace));
    }

}
