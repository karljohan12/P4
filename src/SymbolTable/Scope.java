package SymbolTable;
import java.util.ArrayList;
import java.util.HashMap;
import Parser.parser;

public class Scope {
    public Scope link;
    HashMap<String, Symbol> symbolTable;
    public int returnType;
    public int level;

    public Scope(int returnType, int level) {
        symbolTable = new HashMap();
        this.returnType = returnType;
        this.level = level;
    }

    public Symbol lookupSymbol(String symbolName) {
        return symbolTable.get(symbolName);
    }

    public void checkAvailabilityOfSymbol(String name) {

    }

    public void addSymbol(Function f) {
        this.checkAvailabilityOfSymbol(f.name);
        this.symbolTable.put(f.name, f);
    }

    public void addSymbol(Variable v) {
        this.checkAvailabilityOfSymbol(v.name);
        this.symbolTable.put(v.name, v);
    }

    public void printScopeContent() {
        // TODO: Print shits
    }
}