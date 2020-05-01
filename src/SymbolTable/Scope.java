package SymbolTable;
import java.util.ArrayList;
import java.util.HashMap;
import Parser.parser;

public class Scope {
    public Scope link;
    HashMap<String, Symbol> symbolTable;
    public int returnType;
    public int level;
    public Variable lastDecl;

    public Scope(int returnType, int level) {
        symbolTable = new HashMap<>();
        this.returnType = returnType;
        this.level = level;
    }

    public boolean lookupSymbol(String symbolName) {
        return symbolTable.get(symbolName) != null;
    }

    public boolean isFunctionAvailable(String name) {
        return !symbolTable.containsKey(name);
    }

    public boolean addSymbol(Function f) {
        if(this.isFunctionAvailable(f.name)) {
            this.symbolTable.put(f.name, f);
            return true;
        }
        return false;
    }

    public boolean addSymbol(Variable v) {
        lastDecl = v;
        if(!this.lookupSymbol(v.name)) {
            this.symbolTable.put(v.name, v);
            return true;
        }
        return false;
    }

    public boolean addSymbol(ArrayVariable av) {
        if(!this.lookupSymbol(av.name)) {
            this.symbolTable.put(av.name, av);
            return true;
        }
        return false;
    }

    public boolean addSymbol(ServoPositionVariable spv) {
        if(!this.lookupSymbol(spv.name)) {
            this.symbolTable.put(spv.name, spv);
            return true;
        }
        return false;
    }

    public Symbol ReturnType(String symbolName){
        return symbolTable.get(symbolName);
    }

    public void ConvertToConstant(){
        lastDecl.isConstant = true;
        symbolTable.replace(lastDecl.name, lastDecl);
    }

    public Variable IsConstant(String symbolName) {
        Symbol e = symbolTable.get(symbolName);

        if (e instanceof Variable) {
            Variable v = (Variable) e;
            return v;
        }
        return null;
    }
    public Function lookupFunction(String symbolName) {
        Symbol e = symbolTable.get(symbolName);

        if (e instanceof Function) {
            return (Function) e;
        }
        return null;
    }

    public boolean lookupVariable(String symbolName){
        Symbol e = symbolTable.get(symbolName);


        if (e instanceof Variable) { return true; }
        if (e instanceof ArrayVariable) { return true; }
        if (e instanceof ServoPositionVariable) { return true; }
        return false;
    }

    public void printScopeContent() {
        // TODO: Print shits
    }

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

    public void setVariableConstant(String symbolName) {
        Symbol e = symbolTable.get(symbolName);

        if(e instanceof Variable){
            Variable v = (Variable)e;
            v.isConstant = true;
        }
    }
    public boolean removeVariable(String symbolName){
        Symbol e = symbolTable.get(symbolName);

        if(e instanceof Variable){
            symbolTable.remove(symbolName);
            return true;
        }
        return false;
    }
}