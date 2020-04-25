package SymbolTable;

public class Variable extends Symbol {
    public boolean isConstant = false;
    public boolean hasBeenInit = false;

    public Variable(String name, String type) {
        super(name, type);
    }

    public Variable(String name, String type, boolean isConstant) {
        super(name, type);
        this.isConstant = isConstant;
    }
}
