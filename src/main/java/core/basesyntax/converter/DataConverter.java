package core.basesyntax.converter;

import core.basesyntax.db.FruitTransaction;

import java.util.List;

public interface DataConverter {

    List<FruitTransaction> convert(List<String> lines);
}
