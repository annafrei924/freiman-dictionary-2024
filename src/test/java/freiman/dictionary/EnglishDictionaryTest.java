package freiman.dictionary;


import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        assertTrue(definitions.isEmpty());
    }

    @Test
    public void getDefinition() throws CsvValidationException, IOException {
        // given
        EnglishDictionary dictionary = new EnglishDictionary();

        // when
        List<String> definitions = dictionary.getDefinition("hub");

        // then
        List<String> expectedResult = Arrays.asList("The central part, usually cylindrical, of a wheel",
                " the nave. See Illust. of Axle box.");
        assertEquals(expectedResult, definitions);
    }
}