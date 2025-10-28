package core.basesyntax.model;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.db.FruitTransaction;
import core.basesyntax.db.Operation;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.BalanceOperation;
import core.basesyntax.handler.PurchaseOperation;
import core.basesyntax.handler.ReturnOperation;
import core.basesyntax.handler.SupplyOperation;
import core.basesyntax.reader.CsvReader;
import core.basesyntax.reader.CsvReaderImpl;
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
        CsvReader reader = new CsvReaderImpl();
        List<String> lines = reader.read(pathFile);

        DataConverter converter = new DataConverterImpl();
        final List<FruitTransaction> transaction = converter.convert(lines);

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
