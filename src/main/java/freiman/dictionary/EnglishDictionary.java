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
    public static void main(String[] args) throws CsvValidationException, IOException {
        EnglishDictionary d = new EnglishDictionary();
        System.out.println(d.getDefinition("second"));
    }
    private ArrayList<String[]> dictionary = new ArrayList<>();

    public EnglishDictionary() throws CsvValidationException, IOException {

        // Create an object of filereader class with CSV file as a parameter.
        FileReader filereader = new FileReader(
                "src/main/resources/englishDictionary.csv");
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
            if (word.equalsIgnoreCase(entry[0])) {
                definition.addAll(Arrays.asList(entry[2].split(";")));
                break;
            }
        }

        return definition;
    }



}