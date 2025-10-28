package core.basesyntax.handler;

import core.basesyntax.db.FruitTransaction;

import java.util.Map;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        int currentNumber = storage.getOrDefault(transaction.getProduct(), 0);
        storage.put(transaction.getProduct(), transaction.getQuantity() + currentNumber);
    }
}
