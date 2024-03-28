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
        FileReader filereader = new FileReader(
                "/Users/annafreiman/Desktop/MCON152/freiman-dictionary-2024/src/main/resources/englishDictionary.csv");

        CSVReader reader = new CSVReader(filereader);
        String[] nextRecord;

        // we are going to read data line by line
        while ((nextRecord = reader.readNext()) != null) {
            dictionary.add(nextRecord);
        }

    }


    /**
     * @param word to look up.
     * @return a List of definitions, or an empty list if the word doesn't exist.
     */
    public List<String> getDefinition(String word) {
        List<String> definition = new ArrayList<>();

        for (String[] entry : dictionary) {
            if (word.compareToIgnoreCase(entry[0]) == 0) {
                definition.addAll(Arrays.asList(entry[2].split(";")));
                break;
            }
        }

        if (definition.isEmpty()) {
            definition.add("Word not in dictionary.");
        }
        return definition;
    }



}