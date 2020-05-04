package SymbolTable;
import Parser.parser;

import java.util.ArrayList;

public class SymbolTable {
    int currentLevel;    // nesting level of current scope
    Variable udefinedVariable;    // object node for erroneous symbols
    public Scope topmostScope;    // topmost procedure scope
    public Scope lastClosedScope;
    public Scope setupScope;
    int intType = 0, doubleType = 1, booleanType = 2, stringType = 3, robotType = 4, servoPosition = 5, servo = 6, voidType =7;


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
        lastClosedScope = this.topmostScope;
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

    public Symbol returnSymbol(String identifier) {
        Scope scope = this.topmostScope;
        while (scope != null) {
            Symbol symbol = scope.getSymbol(identifier);
            if(symbol != null) {
                return symbol;
            }
            scope = scope.link;
        }
        return null;
    }

    public boolean lookupSymbol(String symbolName, boolean lookUpVariable) {
        Scope scope = this.topmostScope;
        while (scope != null && lookUpVariable) {
            boolean error = scope.lookupVariable(symbolName);
            if (error) {
                return true;
            }
            scope = scope.link;
        }
        return false;
    }

    public boolean addFunction(String name, String returnType, ArrayList<Symbol> varList) {
        Function function = new Function(name, returnType, varList);

        return this.topmostScope.addSymbol(function);
    }



    public boolean addVariable(String name, String type) {
        Variable var = new Variable(name, type);
        if (!lookupSymbol(name)) {
            return this.topmostScope.addSymbol(var);
        }
        return false;
    }

    public boolean addArrayVariable(ArrayVariable av) {
        return this.topmostScope.addSymbol(av);
    }

    public int ReturnType(String symbolName) {
        boolean lastScopeChecked = false;
        Symbol type = null;
        Scope scope = this.topmostScope;
        while (scope != null || lastScopeChecked == false) {

            if (lastScopeChecked == true) {
                type = scope.ReturnType(symbolName);
            //} else {
               // type = lastClosedScope.ReturnType(symbolName);
            }


            if (type != null) {

                switch (type.type) {
                    case "int":
                        return intType;
                    case "double":
                        return doubleType;
                    case "boolean":
                        return booleanType;
                    case "servoPosition":
                    case "ServoPosition":
                        return servoPosition;
                    case "Servo":
                        return servo;
                    case "string":
                        return stringType;
                    case "Robot":
                        return robotType;
                    case "void":
                        return voidType;

                    default:
                        System.out.println("Error ReturnType lookup");
                }
            }
            if (lastScopeChecked == true) {
                scope = scope.link;
            }
            lastScopeChecked = true;
        }
        System.out.println("Error ReturnType lookup");
        return -1;
    }

    public void ConvertToConstant() {
        topmostScope.ConvertToConstant();
    }

    public boolean IsConstant(String symbolName) {
        Variable var = null;
        boolean lastScopeChecked = false;
        Scope scope = this.topmostScope;
        while (scope != null || lastScopeChecked == false) {

            if (lastScopeChecked == true) {
                var = scope.IsConstant(symbolName);
           // } else {
             //   var = lastClosedScope.IsConstant(symbolName);
            }
            if (var != null) {
                return var.isConstant;
            }
            if (lastScopeChecked == true) {
                scope = scope.link;
            }
            lastScopeChecked = true;
        }
        System.out.println("Error constantLookup");
        return false;

    }

    public boolean checkForLoopAndSetup() {
        Scope scope = this.topmostScope;
        String loop = "loop";
        String setup = "setup";

        Function loopCheck = scope.lookupFunction(loop);
        Function setupCheck = scope.lookupFunction(setup);
        if(loopCheck != null && setupCheck != null) {
            return (loopCheck.name.equals(loop) && setupCheck.name.equals(setup) && loopCheck.returnType.equals("void") && setupCheck.returnType.equals("void"));
        }
        return false;
        //{
            /*Symbol loopSymbol = scope.ReturnType(loop);
            Symbol setupSymbol = scope.ReturnType(loop);

            return (loopSymbol instanceof Function) && (setupSymbol instanceof Function) && (loopSymbol.type.equals("void")) && (setupSymbol.type.equals("void"));*/

    }

    public void setVariableInit(String symbolName){
        Scope scope = this.topmostScope;

        while(scope != null){
            scope.setVariableInit(symbolName);
            scope = scope.link;
        }
    }

    public boolean isVariableInitialized(String symbolName) {
        Scope scope = this.topmostScope;
        boolean found = false;

        while(scope != null){
            found = scope.getVariableInit(symbolName);
            scope = scope.link;
            if(found){
                return true;
            }

        }
        return found;
    }

    public void setVariableConstant(String symbolName) {
        Scope scope = this.topmostScope;

        while(scope != null){
            scope.setVariableConstant(symbolName);
            scope = scope.link;
        }
    }

    public int returnTypeOfFunction(String symbolName) {
        Scope scope = this.topmostScope;
        Symbol var;

        while (scope != null) {

            var = scope.ReturnType(symbolName);
            scope = scope.link;

            if (var instanceof Function) {
                Function e = (Function) var;
                if (e != null) {

                    switch (e.returnType) {
                        case "int":
                            return intType;
                        case "double":
                            return doubleType;
                        case "boolean":
                            return booleanType;
                        case "void":
                            return voidType;
                        default:
                            System.out.println("Error ReturnType lookup");
                    }
                }
            }
        }
        return -1;
    }

    public ArrayList<Symbol> returnFormalParameters(String symbolName) {
        Scope scope = this.topmostScope;
        Symbol var;

        while (scope != null) {

            var = scope.ReturnType(symbolName);
            scope = scope.link;

            if (var instanceof Function) {
                Function e = (Function) var;
                if (e != null) {
                    return e.parameters;
                }
            }
        }
        return null;
    }

        public int returnTypeOfArray(String symbolName) {
            Scope scope = this.topmostScope;
            Symbol var;

            while (scope != null) {

                var = scope.ReturnType(symbolName);
                scope = scope.link;

                if (var instanceof ArrayVariable) {
                    ArrayVariable e = (ArrayVariable) var;
                    switch (e.type) {
                        case "int":
                            return intType;
                        case "double":
                            return doubleType;
                        case "boolean":
                            return booleanType;
                        case "void":
                            return voidType;
                        case "ServoPosition":
                            return servoPosition;
                        default:
                            System.out.println("Error ReturnType lookup");
                    }
                }
            }
            return -1;
    }

    public boolean addServoPositionVariable(String symbol, ArrayList<Variable> av) {
        ServoPositionVariable spv = new ServoPositionVariable(symbol,"servoPosition", av);
        return this.topmostScope.addSymbol(spv);
    }

    public Symbol getIdentifierType(String symbolName) {
        Scope scope = this.topmostScope;
        Symbol found;

        while(scope != null){
            found = scope.ReturnType(symbolName);
            scope = scope.link;
            if(found != null){
                return found;
            }

        }
        return null;
    }

    public void removeVariable(String symbolName){
        Scope scope = this.topmostScope;
        Symbol var;

        while (scope != null) {
            scope.removeVariable(symbolName);
            scope = scope.link;
        }

    }
    public void setSetupScope(){
        setupScope = this.topmostScope;
    }
    public Symbol retrieveRobot(String symbolName){
        return setupScope.ReturnType(symbolName);
    }
}
