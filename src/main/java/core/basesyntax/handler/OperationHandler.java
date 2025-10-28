package core.basesyntax.handler;

import core.basesyntax.db.FruitTransaction;

import java.util.Map;

public interface OperationHandler {
    void apply(FruitTransaction transaction, Map<String, Integer> storage);
}
