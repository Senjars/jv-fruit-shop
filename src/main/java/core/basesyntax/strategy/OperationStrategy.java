package core.basesyntax.strategy;

import core.basesyntax.db.Operation;
import core.basesyntax.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
