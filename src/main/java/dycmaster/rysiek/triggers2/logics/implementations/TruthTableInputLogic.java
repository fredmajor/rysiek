package dycmaster.rysiek.triggers2.logics.implementations;


import dycmaster.rysiek.triggers2.InputTriggerLogic;
import dycmaster.rysiek.triggers2.TruthTable;

import java.util.Map;

public class TruthTableInputLogic extends InputTriggerLogic {

    private final TruthTable truthTable;

    public TruthTableInputLogic(String description, TruthTable truthTable) {
        super(description);
        this.truthTable = truthTable;
    }

    @Override
    public boolean processTriggerInputs(Map<String, Boolean> triggerInputStates,
                                        Map<Integer, String> triggerDeclaredInputs) {
        boolean [] inputStates = new boolean[triggerInputStates.size()];
        int c = 0;
        for(String inputHeader: truthTable.getHeader()){
            inputStates[c] = triggerInputStates.get(inputHeader);
            c++;
        }

        return truthTable.findOutputForValues(inputStates);
    }
}
