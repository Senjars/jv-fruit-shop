package core.basesyntax.model;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.db.*;
import core.basesyntax.handler.*;
import core.basesyntax.reader.CSVReader;
import core.basesyntax.reader.CSVReaderImpl;
import core.basesyntax.report.ReportService;
import core.basesyntax.report.ReportServiceImpl;
import core.basesyntax.report.ReportWriter;
import core.basesyntax.report.ReportWriterImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        String pathFile = "reportToRead.csv";
        CSVReader reader = new CSVReaderImpl();
        List<String> lines = reader.read(pathFile);

        DataConverter converter = new DataConverterImpl();
        List<FruitTransaction> transaction = converter.convert(lines);

        Map<Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.BALANCE, new BalanceOperation());
        handlers.put(Operation.PURCHASE, new PurchaseOperation());
        handlers.put(Operation.RETURN, new ReturnOperation());
        handlers.put(Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.process(transaction);

        ReportService reportService = new ReportServiceImpl();
        reportService.generateReport();

        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeReport();

    }
}
