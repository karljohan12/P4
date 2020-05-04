package SymbolTable;

import java.util.ArrayList;

public class Function extends Symbol {
    public String returnType;
    public ArrayList<Symbol> parameters = new ArrayList<>();

    public Function(String name, String returnType, ArrayList<Symbol> varList) {
        super(name, "function");
        this.returnType = returnType;
        this.parameters = InitParameters(varList);
    }

    private ArrayList<Symbol> InitParameters(ArrayList<Symbol> varList) {
        for (Symbol v : varList) {
            if (v instanceof Variable) {
                Variable va = (Variable) v;
                va.hasBeenInit = true;
            }
        }
        return varList;
    }
}
