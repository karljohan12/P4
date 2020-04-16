package SymbolTable;

public class Variable extends Symbol {
    public int adr;
    public int level;

    public Variable(String name, int type) {
        super(name, type);
    }
}
