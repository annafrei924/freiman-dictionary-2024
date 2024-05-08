package freiman.dictionary;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reads the englishDictionary file ONCE.
 */
public class EnglishDictionary {

    private ArrayList<String[]> dictionary = new ArrayList<>();

    public EnglishDictionary() throws CsvValidationException, IOException {


        // Create an object of filereader class with CSV file as a parameter.
        InputStream in = EnglishDictionary.class.getResourceAsStream(
                "/englishDictionary.csv");
        CSVReader reader = new CSVReader((new InputStreamReader(in)));

        String[] nextRecord = null;


        // we are going to read data line by line
        while ((nextRecord = reader.readNext()) != null) {
            dictionary.add(nextRecord);
        }

        reader.close();

    }

    /**
     * @param word to look up.
     * @return a List of definitions, or an empty list if the word doesn't exist.
     */
    public List<String> getDefinition(String word) {
        List<String> definition = new ArrayList<>();

        for (String[] entry : dictionary) {
            if (word.equalsIgnoreCase(entry[0])) {
                definition.add(entry[2]);
            }
        }
        return definition;
    }
}





