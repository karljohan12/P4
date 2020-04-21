package SymbolTable;

import java.util.ArrayList;

public class Function extends Symbol {
    public String label;
    public ArrayList<Variable> parameters = new ArrayList<>();

    public Function(String name, String type, String label) {
        super(name, type);
        this.label = label;
    }

    public void addParameter(Variable var) {
        this.parameters.add(var);
    }
}
