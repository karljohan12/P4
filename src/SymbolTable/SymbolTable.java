package SymbolTable;

import java.util.ArrayList;

public class SymbolTable {
    int currentLevel;
    public Scope topmostScope;
    public Scope lastClosedScope;
    public Scope setupScope;
    int intType = 0, doubleType = 1, booleanType = 2, stringType = 3, robotType = 4, servoPosition = 5, servo = 6,
            voidType = 7, intArray = 8, doubleArray = 9;


    public SymbolTable() {
        this.topmostScope = new Scope(3);
        this.currentLevel = 0;
    }

    /**
     * Create a new scope.
     */
    public void createScope() {
        Scope newScope = new Scope(this.currentLevel++);
        newScope.link = topmostScope;
        this.topmostScope = newScope;
    }

    /**
     * Close the current scope.
     */
    public void closeScope() {
        lastClosedScope = this.topmostScope;
        this.topmostScope = topmostScope.link;
        this.currentLevel--;
    }

    /**
     * Look up a given symbol.
     *
     * @param symbolName The name of the symbol
     * @return True if found, false if not
     */
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

    /**
     * Find and return a symbol
     *
     * @param identifier The identifier of the symbol
     * @return Symbol The found symbol
     */
    public Symbol returnSymbol(String identifier) {
        Scope scope = this.topmostScope;
        while (scope != null) {
            Symbol symbol = scope.getSymbol(identifier);
            if (symbol != null) {
                return symbol;
            }
            scope = scope.link;
        }
        return null;
    }

    /**
     * Look up a variable
     *
     * @param symbolName The name of the variable
     * @return True if found, false if not
     */
    public boolean lookupVariable(String symbolName) {
        Scope scope = this.topmostScope;
        while (scope != null) {
            boolean error = scope.lookupVariable(symbolName);
            if (error) {
                return true;
            }
            scope = scope.link;
        }
        return false;
    }

    /**
     * Add a function
     *
     * @param name       The name of the function
     * @param returnType The return type of the function
     * @param varList    The parameters of the function
     * @return True if success, false if not
     */
    public boolean addFunction(String name, String returnType, ArrayList<Symbol> varList) {
        Function function = new Function(name, returnType, varList);

        return this.topmostScope.addSymbol(function);
    }

    /**
     * Add a variable
     *
     * @param name The name of the variable
     * @param type The type of the variable
     * @return True if success, false if not
     */
    public boolean addVariable(String name, String type) {
        Variable var = new Variable(name, type);
        if (!lookupSymbol(name)) {
            return this.topmostScope.addSymbol(var);
        }
        return false;
    }

    /**
     * Add an arrayvariable
     *
     * @param av The variable
     * @return True if success, false if not
     */
    public boolean addArrayVariable(ArrayVariable av) {
        return this.topmostScope.addSymbol(av);
    }

    /**
     * Get the type of a variable
     *
     * @param symbolName The name of the variable
     * @return int An integer representing the type
     */
    public int typeOfVariable(String symbolName) {
        boolean lastScopeChecked = false;
        Symbol type = null;
        Scope scope = this.topmostScope;
        while (scope != null || lastScopeChecked == false) {

            if (lastScopeChecked == true) {
                type = scope.returnType(symbolName);
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
                    case "String":
                        return stringType;
                    case "Robot":
                        return robotType;
                    case "void":
                        return voidType;

                    default:
                        //System.out.println("Error ReturnType lookup");
                }
            }
            if (lastScopeChecked == true) {
                scope = scope.link;
            }
            lastScopeChecked = true;
        }
        //System.out.println("Error ReturnType lookup");
        return -1;
    }

    /**
     * Set the latest read variable to a constant
     */
    public void setToConstant() {
        topmostScope.setToConstant();
    }

    /**
     * Check if a variable is a constant
     *
     * @param symbolName The name of the variable
     * @return True if found, false if not
     */
    public boolean isConstant(String symbolName) {
        Variable var = null;
        boolean lastScopeChecked = false;
        Scope scope = this.topmostScope;
        while (scope != null || lastScopeChecked == false) {

            if (lastScopeChecked == true) {
                var = scope.returnVariable(symbolName);
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
        //System.out.println("Error constantLookup");
        return false;

    }

    /**
     * Set a variable as initialized
     *
     * @param symbolName The name of the variable
     */
    public void setVariableInit(String symbolName) {
        Scope scope = this.topmostScope;

        while (scope != null) {
            scope.setVariableInit(symbolName);
            scope = scope.link;
        }
    }

    /**
     * Check if a variable is initialized
     *
     * @param symbolName The name of the variable
     * @return True if initialized, false if not
     */
    public boolean isVariableInitialized(String symbolName) {
        Scope scope = this.topmostScope;
        boolean found = false;

        while (scope != null) {
            found = scope.getVariableInit(symbolName);
            scope = scope.link;
            if (found) {
                return true;
            }

        }
        return found;
    }

    /**
     * Set a variable as a constant
     *
     * @param symbolName The name of the variable
     */
    public void setVariableConstant(String symbolName) {
        Scope scope = this.topmostScope;

        while (scope != null) {
            scope.setVariableConstant(symbolName);
            scope = scope.link;
        }
    }

    /**
     * Get the return type of a function
     *
     * @param symbolName The name of the function
     * @return int An integer representing the type
     */
    public int returnTypeOfFunction(String symbolName) {
        Scope scope = this.topmostScope;
        Symbol var;

        while (scope != null) {

            var = scope.returnType(symbolName);
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
                        case "String":
                            return stringType;
                        case "void":
                            return voidType;
                        case "int Array":
                            return intArray;
                        case "double Array":
                            return doubleArray;
                        default:
                            //System.out.println("Error ReturnType lookup");
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Get the formal parameters of a function
     *
     * @param symbolName The name of the function
     * @return A list with the formal parameters
     */
    public ArrayList<Symbol> returnFormalParameters(String symbolName) {
        Scope scope = this.topmostScope;
        Symbol var;

        while (scope != null) {

            var = scope.returnType(symbolName);
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

    /**
     * Get the type of an array
     * @param symbolName The name of the array
     * @return int An integer representing the type
     */
    public int returnTypeOfArray(String symbolName) {
        Scope scope = this.topmostScope;
        Symbol var;

        while (scope != null) {

            var = scope.returnType(symbolName);
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
                       //System.out.println("Error ReturnType lookup");
                }
            }
        }
        return -1;
    }

    /**
     * Add a variable of type ServoPosition
     * @param symbol The name of the symbol
     * @param av The list of variables
     * @return True is success, false if not
     */
    public boolean addServoPositionVariable(String symbol, ArrayList<Variable> av) {
        ServoPositionVariable spv = new ServoPositionVariable(symbol, "servoPosition", av);
        return this.topmostScope.addSymbol(spv);
    }

    /**
     * Get type of an identifier
     * @param symbolName The name of the identifier
     * @return The found symbol
     */
    public Symbol getIdentifierType(String symbolName) {
        Scope scope = this.topmostScope;
        Symbol found;

        while (scope != null) {
            found = scope.returnType(symbolName);
            scope = scope.link;
            if (found != null) {
                return found;
            }

        }
        return null;
    }

    /**
     * Remove a variable
     * @param symbolName The name of the symbol
     */
    public void removeVariable(String symbolName) {
        Scope scope = this.topmostScope;
        Symbol var;

        while (scope != null) {
            scope.removeVariable(symbolName);
            scope = scope.link;
        }
    }

    /**
     * Save the current scope for required functions
     */
    public void setSetupScope() {
        setupScope = this.topmostScope;
    }

    /**
     * Get variable of type Robot
     * @param symbolName The name of the variable
     * @return Symbol The found variable
     */
    public Symbol retrieveRobot(String symbolName) {
        return setupScope.returnType(symbolName);
    }
}
