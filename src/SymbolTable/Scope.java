package SymbolTable;
import java.util.ArrayList;
import java.util.HashMap;
import Parser.parser;

public class Scope {
    public Scope link;
    private HashMap<String, Symbol> symbolTable;
    public int level;
    public Variable lastDecl;

    public Scope(int level) {
        symbolTable = new HashMap<>();
        this.level = level;
    }

    /**
     * Check if a symbol exists
     * @param symbolName The name of the symbol
     * @return True if present, false if not
     */
    public boolean lookupSymbol(String symbolName) {
        return symbolTable.get(symbolName) != null;
    }

    /**
     * Check if function exists
     * @param name The name of the function
     * @return True if present, false if not
     */
    public boolean doesFunctionExist(String name) {
        return symbolTable.containsKey(name);
    }

    /**
     * Add a function
     * @param f The function
     * @return True if success, false if not
     */
    public boolean addSymbol(Function f) {
        if(!this.doesFunctionExist(f.name)) {
            this.symbolTable.put(f.name, f);
            return true;
        }
        return false;
    }

    /**
     * Add a variable
     * @param v The variable
     * @return True if success, false if not
     */
    public boolean addSymbol(Variable v) {
        lastDecl = v;
        if(!this.lookupSymbol(v.name)) {
            this.symbolTable.put(v.name, v);
            return true;
        }
        return false;
    }

    /**
     * Add an Array variable
     * @param av The ArrayVariable
     * @return True if success, false if not
     */
    public boolean addSymbol(ArrayVariable av) {
        if(!this.lookupSymbol(av.name)) {
            this.symbolTable.put(av.name, av);
            return true;
        }
        return false;
    }

    /**
     * Add a ServoPosition
     * @param spv The ServoPositionVariable
     * @return True if success, false if not
     */
    public boolean addSymbol(ServoPositionVariable spv) {
        if(!this.lookupSymbol(spv.name)) {
            this.symbolTable.put(spv.name, spv);
            return true;
        }
        return false;
    }

    /**
     * Get type of a symbol
     * @param symbolName The name of the symbol
     * @return Symbol The found symbol
     */
    public Symbol returnType(String symbolName){
        return symbolTable.get(symbolName);
    }

    /**
     * Set latest processed variable to constant
     */
    public void setToConstant(){
        lastDecl.isConstant = true;
        symbolTable.replace(lastDecl.name, lastDecl);
    }

    /**
     * Check if a variable is a constant
     * @param symbolName The name of the variable
     * @return Variable The
     */
    public Variable returnVariable(String symbolName) {
        Symbol e = symbolTable.get(symbolName);

        if (e instanceof Variable) {
            Variable v = (Variable) e;
            return v;
        }
        return null;
    }

    /**
     * Get function
     * @param symbolName The name of the function
     * @return Function The found function
     */
    public Function lookupFunction(String symbolName) {
        Symbol e = symbolTable.get(symbolName);

        if (e instanceof Function) {
            return (Function) e;
        }
        return null;
    }

    /**
     *Check if a variable exist
     * @param symbolName The name of the variable
     * @return True if present, false if not
     */
    public boolean lookupVariable(String symbolName){
        Symbol e = symbolTable.get(symbolName);

        if (e instanceof Variable) { return true; }
        if (e instanceof ArrayVariable) { return true; }
        if (e instanceof ServoPositionVariable) { return true; }
        return false;
    }

    /**
     * Set a variable to initialized
     * @param symbolName The name of the variable
     */
    public void setVariableInit(String symbolName){
        Symbol e = symbolTable.get(symbolName);

        if(e instanceof Variable){
            Variable v = (Variable)e;
            v.hasBeenInit = true;
        }
        else if(e instanceof ArrayVariable){
            ArrayVariable a = (ArrayVariable)e;
            a.hasBeenInit = true;
        }
        else if(e instanceof ServoPositionVariable){
            ServoPositionVariable s = (ServoPositionVariable)e;
            s.hasBeenInit = true;
        }
    }

    /**
     * Check if a variable has been initialized
     * @param symbolName The name of the symbol
     * @return True if initialized, false if not
     */
    public boolean getVariableInit(String symbolName) {
        Symbol e = symbolTable.get(symbolName);

        if(e instanceof Variable){
            Variable v = (Variable)e;
            return v.hasBeenInit;
        }
        if(e instanceof ArrayVariable){
            ArrayVariable v = (ArrayVariable)e;
            return v.hasBeenInit;
        }
        if(e instanceof ServoPositionVariable){
            ServoPositionVariable s = (ServoPositionVariable)e;
            return s.hasBeenInit;
        }
        return false;
    }

    /**
     * Set a variable to constant
     * @param symbolName The name of the variable
     */
    public void setVariableConstant(String symbolName) {
        Symbol e = symbolTable.get(symbolName);

        if(e instanceof Variable){
            Variable v = (Variable)e;
            v.isConstant = true;
        }
    }

    /**
     * Remove a variable
     * @param symbolName The name of the variable
     * @return True if success, false if not
     */
    public boolean removeVariable(String symbolName){
        Symbol e = symbolTable.get(symbolName);

        if(e instanceof Variable){
            symbolTable.remove(symbolName);
            return true;
        }
        return false;
    }

    /**
     * Get a symbol
     * @param identifier The name of the identifier
     * @return Symbol The found symbol
     */
    public Symbol getSymbol(String identifier) {
        return symbolTable.get(identifier);
    }
}