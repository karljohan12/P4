package SymbolTable;

import java.util.ArrayList;

public class ServoPositionVariable extends Symbol {
    ArrayList<Variable> variables = new ArrayList<>();

    public ServoPositionVariable(String name, String type, ArrayList<Variable> var) {
        super(name, type);
        this.variables = var;
    }
    public ArrayList<Variable> getVariables(){
        return variables;
    }
}
