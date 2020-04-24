package SymbolTable;
import Parser.parser;

public class SymbolTable {
    int currentLevel;    // nesting level of current scope
    Variable udefinedVariable;    // object node for erroneous symbols
    public Scope topmostScope;    // topmost procedure scope
    public Scope lastClosedScope;
    int intType = 0, doubleType = 1, booleanType = 2, stringType = 3, robotType = 4, servoPosition = 5, servo = 6;


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

    public boolean addFunction(String name, String returnType) {
        Function function = new Function(name, returnType);
        return this.topmostScope.addSymbol(function);
    }

    public boolean addVariable(String name, String type) {
        Variable var = new Variable(name, type);
        if (!lookupSymbol(name)) {
            return this.topmostScope.addSymbol(var);
        }
        return false;
    }

    public int ReturnType(String symbolName) {
        boolean lastScopeChecked = false;
        Symbol type;
        Scope scope = this.topmostScope;
        while (scope != null || lastScopeChecked == false) {

            if (lastScopeChecked == true) {
                type = scope.ReturnType(symbolName);
            } else {
                type = lastClosedScope.ReturnType(symbolName);
            }


            if (type != null) {

                switch (type.type) {
                    case "int":
                        return intType;
                    case "double":
                        return doubleType;
                    case "boolean":
                        return booleanType;
                    case "ServoPosition":
                        return servoPosition;
                    case "Servo":
                        return servo;
                    case "string":
                        return stringType;
                    case "Robot":
                        return robotType;

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
        Variable var;
        boolean lastScopeChecked = false;
        Scope scope = this.topmostScope;
        while (scope != null || lastScopeChecked == false) {

            if (lastScopeChecked == true) {
                var = scope.IsConstant(symbolName);
            } else {
                var = lastClosedScope.IsConstant(symbolName);
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

}
