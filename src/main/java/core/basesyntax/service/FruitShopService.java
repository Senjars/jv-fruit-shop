package core.basesyntax.service;

import core.basesyntax.db.FruitTransaction;
import java.util.List;

public interface FruitShopService {
    void process(List<FruitTransaction> transactions);
}
