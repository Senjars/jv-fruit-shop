package core.basesyntax.service;

import core.basesyntax.db.FruitTransaction;
import core.basesyntax.db.Storage;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;

import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService{
    private final OperationStrategy strategy;
    private final Map<String, Integer> storage;

    public FruitShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
        this.storage = Storage.storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {

        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = strategy.getHandler(transaction.getOperation());
            handler.apply(transaction, storage);
        }
    }
}
