package core.basesyntax.converter;

import core.basesyntax.db.FruitTransaction;
import core.basesyntax.db.Operation;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convert(List<String> lines) {

        List<FruitTransaction> fruitTransactionList = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] oper = lines.get(i).split(","); // muszę użyć get w stosunku do lines bo chodzi mi o wartość pod indexem z listy

            Operation operation1 = Operation.formCode(oper[0]); // używam fromcode bo valueof wywali wyjątek bo jedno to enum(BALANCE PURCHASE etc a drugie to kody: b, p)
            String fruit = oper[1];
            int quantity = Integer.parseInt(oper[2]);

            fruitTransactionList.add(new FruitTransaction(operation1, fruit, quantity));
        }

        return fruitTransactionList;
    }
}
