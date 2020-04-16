package SymbolTable;

import java.util.ArrayList;

public class Function extends Symbol {
    public int label;
    public ArrayList<Variable> parameters = new ArrayList<>();

    public Function(String name, int type, int label) {
        super(name, type);
        this.label = label;
    }

    public void addParameter(Variable var) {
        this.parameters.add(var);
    }
}
