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
}