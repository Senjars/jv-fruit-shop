package core.basesyntax.reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class CSVReaderImpl implements CSVReader {

    @Override
    public List<String> read(String pathFile) {
        try {
            return Files.readAllLines(Paths.get(pathFile));
        } catch (IOException e) {
            System.out.println("Cannot read file:" + pathFile);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
