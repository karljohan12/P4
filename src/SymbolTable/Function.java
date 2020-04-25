package SymbolTable;

import java.util.ArrayList;

public class Function extends Symbol {
    public String returnType;
    public ArrayList<Variable> parameters = new ArrayList<>();

    public Function(String name, String returnType, ArrayList<Variable> varList) {
        super(name, "function");
        this.returnType = returnType;
        this.parameters = InitParameters(varList);
    }

    private ArrayList<Variable> InitParameters(ArrayList<Variable> varList) {
        for (Variable v : varList) {
            v.hasBeenInit = true;
        }
        return varList;
    }
}
