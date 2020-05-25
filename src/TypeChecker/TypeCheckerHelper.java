package TypeChecker;

import AST.Abstract.ASTNode;
import AST.NonAbstract.Node.*;
import Parser.parser;
import SymbolTable.ArrayVariable;
import SymbolTable.ServoPositionVariable;
import SymbolTable.Symbol;
import SymbolTable.Variable;

import java.util.ArrayList;

public class TypeCheckerHelper {
    static int errorDetected = 0;

    public static void reportError(String message) {
        errorDetected++;
        System.out.println(message);
    }

    public static String convertToType(int convert) {
        switch (convert) {
            case 0:
                return "int";
            case 1:
                return "double";
            case 2:
                return "boolean";
            case 3:
                return "String";
            case 4:
                return "Robot";
            case 5:
                return "ServoPosition";
            case 6:
                return "Servo";
            case 7:
                return "void";
            case 8:
                return "int Array";
            case 9:
                return "double Array";

            default:
                System.out.println("Type does not exist");
                return "Unknown";
        }
    }

    public static int convertFromType(String convert) {
        switch (convert) {
            case "int":
                return 0;
            case "double":
                return 1;
            case "boolean":
                return 2;
            case "String":
                return 3;
            case "Robot":
                return 4;
            case "ServoPosition":
                return 5;
            case "Servo":
                return 6;
            case "void":
                return 7;
            case "intArray":
                return 8;
            case "doubleArray":
                return 9;

            default:
                System.out.println("Type does not exist");
                return -1;
        }
    }

    public static void CheckForLoopAndSetupInFunctionList(ArrayList<String> setupAndLoopList, int linePlaceholder) {
        if (setupAndLoopList.size() >= 2) {
            if (!setupAndLoopList.get(0).equals("setup")) {
                reportError("Line " + linePlaceholder + ": void setup() and void loop() must be declared as the first two functions, in respective order");
            } else if (!setupAndLoopList.get(1).equals("loop")) {
                reportError("Line " + linePlaceholder + ": void setup() and void loop() must be declared as the first two functions, in respective order");
            }
        }
    }

    public static boolean isCompatible(int left, int right) {
        switch (left) {
            case 0:
            case 6:
                return (right == 0 || right == 6);
            case 1:
                return (right == 1 || right == 0);
            case 2:
                return (right == 2);
            case 3:
                return (right == 3);
            case 4:
                return (right == 4);
            case 5:
                return (right == 5);
            default:
                return false;
        }
    }

    public static boolean isComparable(int left, int right) {
        switch (left) {
            case 0:
            case 1:
                return (right == 0 || right == 1);
            default:
                return false;
        }
    }

    public static boolean isComparableEquality(int left, int right) {
        switch (left) {
            case 0:
            case 1:
                return (right == 0 || right == 1);
            case 2:
                return (right == 2);
            default:
                return false;
        }
    }

    public static int EvaluateExpression(int left, int right) {
        switch (left) {
            case 0:
                if (right == 0)
                    return 0;
                if (right == 1)
                    return 1;
                break;
            case 1:
                return 1;
            default:
                return -1;
        }
        return -1;
    }

    public static int evalChild2(ASTNode child2, String identifierChild2, int typeofChild1, int typeOfChild2, int ln, ASTNode parent) {
        if (child2 instanceof IdentifierExpression) {
            Symbol identChild2 = parser.st.returnSymbol(identifierChild2);
            if (identChild2 instanceof ArrayVariable || identChild2 instanceof ServoPositionVariable) {

                if (typeOfChild2 == 8 || typeOfChild2 == 9) {
                    reportError("Line " + ln + ": \"" + convertToType(typeOfChild2) + "\" and \"" + convertToType(typeofChild1) + "\" is incompatible types");
                }
            } else if (identChild2 instanceof Variable) {
                if (identChild2.type.equals("boolean")) {
                    reportError("Line " + ln + ": " + identifierChild2 + "(boolean) can not be evaluated in a " + returnTypeofExpression(parent));
                } else {
                    return EvaluateExpression(typeofChild1, convertFromType(identChild2.type));
                }
            }
        } else if (child2 instanceof FloatLiteral) {
            return EvaluateExpression(typeofChild1, 1);
        } else if (child2 instanceof IntegerLiteral) {
            return EvaluateExpression(typeofChild1, 0);
        } else {
            return EvaluateExpression(typeofChild1, typeOfChild2);
        }
        return -1;
    }

    public static int EvaluateExpression(ASTNode parent, ASTNode child1, ASTNode child2, String identifierChild1, String identifierChild2, int ln, int typeChild1, int typeChild2) {
        if (child1 instanceof IdentifierExpression) {
            Symbol identChild1 = parser.st.returnSymbol(identifierChild1);
            if (identChild1 instanceof ArrayVariable || identChild1 instanceof ServoPositionVariable) {
                if (typeChild1 == 8 || typeChild1 == 9) {
                    reportError("Line " + ln + ": \"" + convertToType(typeChild1) + "\" and \"" + convertToType(typeChild2) + "\" is incompatible types");
                }

            } else if (identChild1 instanceof Variable) {
                if (identChild1.type.equals("boolean")) {
                    reportError("Line " + ln + ": " + identifierChild1 + "(boolean) can not be evaluated in a " + returnTypeofExpression(parent));
                } else {
                    return evalChild2(child2, identifierChild2, convertFromType(identChild1.type), typeChild2, ln, parent);
                }
            }
        } else if (child1 instanceof BoolLiteral) {
            reportError("Line " + ln + ": Boolean can not be evaluated in expression ");
        } else if (child1 instanceof IntegerLiteral) {

            return evalChild2(child2, identifierChild2, 0, typeChild2, ln, parent);
        } else if (child1 instanceof FloatLiteral) {
            return evalChild2(child2, identifierChild2, 1, typeChild2, ln, parent);
        } else {
            return evalChild2(child2, identifierChild2, typeChild1, typeChild2, ln, parent);
        }

        return -1;
    }

    public static String returnTypeofExpression(ASTNode child) {
        if (child instanceof PlusExpression) {
            return "plus expression";
        }
        if (child instanceof MinusExpression) {
            return "minus expression";
        }
        if (child instanceof MultiplicationExpression) {
            return "multiplication expression";
        }
        if (child instanceof DivisionExpression) {
            return "division expression";
        }
        if (child instanceof ModuloExpression) {
            return "modulo expression";
        }
        return "";

    }
}
