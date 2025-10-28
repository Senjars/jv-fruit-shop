package core.basesyntax.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportWriterImpl implements ReportWriter{
    @Override
    public void writeReport() {
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
            writer.write(report);
            System.out.println("The report has been successfully saved!");
        } catch (IOException e) {
            throw new RuntimeException("Cannot save the report", e);
        }
    }
}
