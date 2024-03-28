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
        assertEquals("[Word not in dictionary.]", definitions.toString());
    }

    @Test
    public void getDefinition() throws CsvValidationException, IOException {
        // given
        EnglishDictionary dictionary = new EnglishDictionary();

        // when
        List<String> definitions = dictionary.getDefinition("chariot");

        // then
        assertEquals("[A two-wheeled car or vehicle for war, racing, state processions, etc.]",
                definitions.toString());
    }
}