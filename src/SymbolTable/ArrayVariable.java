package SymbolTable;

import java.util.ArrayList;

public class ArrayVariable extends Symbol {
    ArrayList<String> variables = new ArrayList<>();

    public ArrayVariable(String name, String type) {
        super(name, type);
    }

    public ArrayVariable(String name, String type, ArrayList<String> al) {
        super(name, type);
        variables = al;
    }

    public void addParameter(String var) {
        variables.add(var);
    }

    public ArrayList<String> getVariables(){
        return variables;
    }
}
