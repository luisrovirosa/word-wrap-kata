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

    private String wrap(String text, int numberOfColumns) {
        WordWrap wrapper = new WordWrap();
        return wrapper.wrap(text, numberOfColumns);
    }
}
