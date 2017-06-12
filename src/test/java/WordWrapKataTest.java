import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WordWrapKataTest {
    @Test
    public void does_not_wrap_when_line_is_smaller_than_the_number_of_columns(){
        WordWrap wrapper = new WordWrap();

        String text = wrapper.wrap("hola a todos", 20);

        assertThat(text, is("hola a todos"));
    }

    @Test
    public void one_word_bigger_than_number_of_columns_is_wrapped_by_the_number_of_columns(){
        WordWrap wrapper = new WordWrap();

        String text = wrapper.wrap("hola", 2);

        assertThat(text, is("ho\nla"));
    }
}
