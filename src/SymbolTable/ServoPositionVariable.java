package SymbolTable;

import java.util.ArrayList;

public class ServoPositionVariable extends Symbol {
    ArrayList<Variable> variables = new ArrayList<>();
    public boolean hasBeenInit = false;

    public ServoPositionVariable(String name, String type, ArrayList<Variable> var) {
        super(name, type);
        this.variables = var;
    }

    /**
     * Get the list of variables
     * @return The list of variables
     */
    public ArrayList<Variable> getVariables(){
        return variables;
    }
}
