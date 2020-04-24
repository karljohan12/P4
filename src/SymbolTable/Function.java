package SymbolTable;

import java.util.ArrayList;

public class Function extends Symbol {
    public String returnType;
    public ArrayList<Variable> parameters = new ArrayList<>();

    public Function(String name, String returnType) {
        super(name, "function");
        this.returnType = returnType;
    }

    public void addParameter(Variable var) {
        this.parameters.add(var);
    }
}
