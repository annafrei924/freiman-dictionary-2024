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
        List<String> definitions = dictionary.getDefinition("film");
        List<String> expectedResult = Arrays.asList("A thin skin; a pellicle; a membranous covering, causing opacity; "
                        + "hence, any thin, slight covering.", "A slender thread, as that of a cobweb.",
                        "To cover with a thin skin or pellicle.");
        assertEquals(expectedResult, definitions);
    }
}