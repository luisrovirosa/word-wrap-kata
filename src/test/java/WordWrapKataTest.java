import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WordWrapKataTest {
    @Test
    public void does_not_wrap_when_line_is_smaller_than_the_number_of_columns(){
        assertThat(wrap("hola a todos", 20), is("hola a todos"));
    }

    @Test
    public void one_word_bigger_than_number_of_columns_is_wrapped_by_the_number_of_columns(){
        assertThat(wrap("hola", 2), is("ho\nla"));
        assertThat(wrap("hola", 1), is("h\no\nl\na"));
    }

    @Test
    public void two_words_each_of_them_smaller_than_the_number_of_columns_split_the_content_without_splitting_words(){
        assertThat(wrap("hola luis", 6), is("hola\nluis"));
    }

    @Test
    public void with_multiple_words_and_the_first_is_bigger_than_number_of_columns_splits_the_first_word_by_the_number_of_columns(){
        assertThat(wrap("hola luis", 2), is("ho\nla\nlu\nis"));
        assertThat(wrap("hola luis", 3), is("hol\na\nlui\ns"));
    }

    @Test
    public void wrap_more_than_one_word_together(){
        assertThat(wrap("hola a todos", 6), is("hola a\ntodos"));
    }

    private String wrap(String text, int numberOfColumns) {
        WordWrap wrapper = new WordWrap();
        return wrapper.wrap(text, numberOfColumns);
    }
}
