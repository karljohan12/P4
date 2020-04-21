package SymbolTable;

import java.util.ArrayList;

public class Function extends Symbol {
    public ArrayList<Variable> parameters = new ArrayList<>();

    public Function(String name) {
        super(name, "function");
    }

    public void addParameter(Variable var) {
        this.parameters.add(var);
    }
}
