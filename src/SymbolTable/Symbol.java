package SymbolTable;

public class Symbol {
    String name;
    int type; // For functions this is the return type

    public Symbol(String name, int type) {
        this.name = name;
        this.type = type;
    }
}