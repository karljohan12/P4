package SymbolTable;

import java.util.ArrayList;

public class ArrayVariable extends Symbol {
    ArrayList<String> variables = new ArrayList<>();
    public boolean hasBeenInit = false;

    public ArrayVariable(String name, String type) {
        super(name, type);
    }

    public ArrayVariable(String name, String type, ArrayList<String> al) {
        super(name, type);
        variables = al;
    }

    /**
     * Add a variable
     * @param var The variable
     */
    public void addParameter(String var) {
        variables.add(var);
    }

    /**
     * Get the list of variable
     * @return List of variables
     */
    public ArrayList<String> getVariables(){
        return variables;
    }
}
