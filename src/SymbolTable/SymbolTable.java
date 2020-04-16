package SymbolTable;
import Parser.parser;

public class SymbolTable {
    int currentLevel;	// nesting level of current scope
    Variable udefinedVariable;	// object node for erroneous symbols
    public Scope topmostScope;	// topmost procedure scope

    public SymbolTable() {
        this.topmostScope = new Scope(3, 0); // new Scope();
        this.currentLevel = 0;
        udefinedVariable = new Variable("undefined", 0);
    }

    // open a new scope and make it the current scope (topScope)
    public void createScope(int type) {
        Scope newScope = new Scope(type, this.currentLevel++);
        newScope.link = topmostScope;
        this.topmostScope = newScope;
    }

    // close the current scope
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

    public Function addFunction(String name, int type, int label) {
        Function new_function = new Function(name, type, label);
        this.topmostScope.addSymbol(new_function);
        return new_function;
    }

    public boolean addVariable(String name, int type) {
        Variable var = new Variable(name, type);
        return this.topmostScope.addSymbol(var);
    }
}
