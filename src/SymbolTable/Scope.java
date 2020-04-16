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

    public boolean lookupSymbol(String symbolName) {
        return symbolTable.get(symbolName) != null;
    }

    public void checkAvailability(String name) {

    }

    public void addSymbol(Function f) {
        this.checkAvailability(f.name);
        this.symbolTable.put(f.name, f);
    }

    public boolean addSymbol(Variable v) {
        if(!this.lookupSymbol(v.name)) {
            this.symbolTable.put(v.name, v);
            return true;
        }
        return false;
    }

    public void printScopeContent() {
        // TODO: Print shits
    }
}