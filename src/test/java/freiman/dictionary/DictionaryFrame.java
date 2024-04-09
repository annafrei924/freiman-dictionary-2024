package freiman.dictionary;

import com.opencsv.exceptions.CsvValidationException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class DictionaryFrame extends JFrame {

    private JTextField wordInput;
    private JTextArea defTextArea;
    EnglishDictionary dict;

    {
        try {
            dict = new EnglishDictionary();
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DictionaryFrame() {
        setSize(800, 598);
        setTitle("Dictionary");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        setContentPane(main);

        wordInput = new JTextField();
        main.add(wordInput, BorderLayout.NORTH);

        defTextArea = new JTextArea();
        defTextArea.setEditable(false);
        defTextArea.setLineWrap(true); // Enable text wrapping
        defTextArea.setWrapStyleWord(true); // Wrap at word boundaries

        JScrollPane scrollPane = new JScrollPane(defTextArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        main.add(defTextArea, BorderLayout.CENTER);

        wordInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                define();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                define();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                define();
            }
        });
    }

    private void define() {
        String word = wordInput.getText();
        List<String> definitions = dict.getDefinition(word);

        StringBuilder result = new StringBuilder();
        for (String def : definitions) {
            result.append(def).append("\n");
        }

        defTextArea.setText(result.toString());
    }
}
