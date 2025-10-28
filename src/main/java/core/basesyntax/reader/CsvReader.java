package core.basesyntax.reader;

import java.util.List;

public interface CsvReader {
    List<String> read(String pathFile);
}
