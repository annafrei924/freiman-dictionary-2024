package freiman.dictionary;


import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnglishDictionaryTest {

    @Test
    public void getDefinitionEmpty() throws CsvValidationException, IOException {
        // given
        EnglishDictionary dictionary = new EnglishDictionary();

        // when
        List<String> definitions = dictionary.getDefinition("");

        // then
        assertEquals("[]", definitions.toString());
    }

    @Test
    public void getDefinition() throws CsvValidationException, IOException {
        // given
        EnglishDictionary dictionary = new EnglishDictionary();

        // when
        List<String> definitions = dictionary.getDefinition("second");

        // then
        assertEquals("[Immediately following the first,  next to the first in order of place or time,  "
                + "hence, occuring again,  another,  other.]", definitions.toString());
    }
}