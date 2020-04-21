package SymbolTable;
import Parser.parser;

public class SymbolTable {
    int currentLevel;	// nesting level of current scope
    Variable udefinedVariable;	// object node for erroneous symbols
    public Scope topmostScope;	// topmost procedure scope

    public SymbolTable() {
        this.topmostScope = new Scope(3, 0); // new Scope();
        this.currentLevel = 0;
        udefinedVariable = new Variable("undefined", "ost");
    }

    public void createScope(int type) {
        Scope newScope = new Scope(type, this.currentLevel++);
        newScope.link = topmostScope;
        this.topmostScope = newScope;
    }

    public void closeScope() {
        this.topmostScope = topmostScope.link;
        this.currentLevel--;
    }

    public boolean lookupSymbol(String symbolName) {
        Scope scope = this.topmostScope;
        while (scope != null) {
            boolean error = scope.lookupSymbol(symbolName);
            if (error) {
                return true;
            }
            scope = scope.link;
        }
        return false;
    }

    public boolean addFunction(String name) {
        Function function = new Function(name);
        return this.topmostScope.addSymbol(function);
    }

    public boolean addVariable(String name, String type) {
        Variable var = new Variable(name, type);
        if(!lookupSymbol(name)) {
            return this.topmostScope.addSymbol(var);
        }
        return false;
    }
}
