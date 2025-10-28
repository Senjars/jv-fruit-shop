package core.basesyntax.report;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    @Override
    public String generateReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            builder.append(entry.getKey() + "," + entry.getValue() + "\n");
        }

        return builder.toString();
    }
}
