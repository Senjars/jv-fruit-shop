package core.basesyntax.handler;

import core.basesyntax.db.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getProduct(), transaction.getQuantity());
    }
}
