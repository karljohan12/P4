package TypeChecker;

import AST.Abstract.ASTNode;
import AST.List.ArrayVariables;
import AST.NonAbstract.Node.*;
import Interfaces.IVisitor;
import Parser.parser;
import SymbolTable.ArrayVariable;
import SymbolTable.ServoPositionVariable;
import SymbolTable.Symbol;
import SymbolTable.Variable;

import java.util.ArrayList;
import java.util.Arrays;


public class TypeCheckerIVisitor implements IVisitor {

    private int indentLevel = 0;
    private int lastType;
    private boolean isArrayType = false;
    private String lastIdentifier;
    private boolean isAssignmentDecl = false;
    private String functionType;
    private ArrayList<Variable> parameters = new ArrayList<Variable>();
    private boolean constantFormalParameter = false;
    private boolean isFunctionBlock = false;
    private boolean checkingForPrototypes = false;
    private int functionNumber = 0;
    private ArrayList<Symbol> prototypes = new ArrayList<Symbol>();
    private ArrayList<ArrayList<Symbol>> functionListParameterList = new ArrayList<ArrayList<Symbol>>();
    private String functionIdentifier = "global";
    private int linePlaceholder;
    private ArrayList<Integer> arrayPlaceholder = new ArrayList<Integer>();
    private boolean isAssigmentExpression = false;
    private boolean alternativeServoPosition = false;
    private ArrayList<Symbol> setupPlaceholder = new ArrayList<Symbol>();
    private ArrayList<String> identifierArray = new ArrayList<>();
    private boolean gatheringDeclaration = false;
    private int lastValue;
    private boolean lastBlockForLoop = false;
    private boolean NonAssigningReturningFunctionCall = false;
    private boolean checkingForArray = false;
    private boolean retStatement = false;
    private boolean PrintAST = false;


    private void increaseIndent() {
        indentLevel += 2;
    }

    private void decreaseIndent() {
        indentLevel -= 2;
    }

    private void printNodeLine(String s) {

        if (!checkingForPrototypes && PrintAST) {
            String line = "";
            for (int i = 0; i < indentLevel; i++) {
                line += " ";
            }
            System.out.println(line + s);
        }
    }

    private void printNode(ASTNode a) {
        printNodeLine(a.getClass().getSimpleName() + "'" + a.lineNumber);
    }

    private void printNodeWithValue(ASTNode a, String s) {
        printNodeLine(a.getClass().getSimpleName() + ":" + s + "'" + a.lineNumber);
    }




    @Override
    public void visit(ArrayType n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        if ((lastType == 2 || lastType == 3 || lastType == 4) && !checkingForPrototypes) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": array of " + TypeCheckerHelper.convertToType(lastType) + " is not possible");
        }
        isArrayType = true;


        decreaseIndent();
    }

    @Override
    public void visit(AssignmentExpression n) {
        printNode(n);
        increaseIndent();

        isAssigmentExpression = true;
        n.e1.accept(this);
        isAssigmentExpression = false;
        if (parser.st.isConstant(lastIdentifier)) {
            TypeCheckerHelper.reportError("Line " + n.line + ": \"" + lastIdentifier + "\" is a constant, and therefore it can not be modified");
        }

        parser.st.setVariableInit(lastIdentifier);
        int left = lastType;

        n.e2.accept(this);
        NonAssigningReturningFunctionCall = true;
        checkingForArray = true;
        n.e3.accept(this);
        NonAssigningReturningFunctionCall = false;
        checkingForArray = false;
        int right = lastType;

        if (left != -1) {
            if (!TypeCheckerHelper.isCompatible(left, right)) {
                String first = TypeCheckerHelper.convertToType(left);
                String second = TypeCheckerHelper.convertToType(right);
                TypeCheckerHelper.reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not compatible");
            }
        }

        decreaseIndent();
    }

    @Override
    public void visit(StringType n) {
        lastType = 3;
        printNode(n);
    }

    @Override
    public void visit(BoolLiteral n) {
        lastType = 2;
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(BoolType n) {
        lastType = 2;
        printNode(n);
    }

    @Override
    public void visit(ConstantExpression n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(Equal n) {
        printNode(n);
    }

    @Override
    public void visit(EqualExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        n.e2.accept(this);
        int right = lastType;

        if (!TypeCheckerHelper.isComparableEquality(left, right)) {
            String firstType = TypeCheckerHelper.convertToType(left);
            String secondType = TypeCheckerHelper.convertToType(right);

            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": " + "Types \"" + firstType + "\" and \"" + secondType + "\" are not comparable ("
                    + n.e1.toString() + " == " + n.e2.toString() + ")");
        }
        lastType = 2;
        decreaseIndent();
    }

    @Override
    public void visit(FloatLiteral n) {
        lastType = 1;
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(FloatType n) {
        lastType = 1;
        printNode(n);
    }

    @Override
    public void visit(Function n) {
        printNode(n);
        increaseIndent();

        n.a1.accept(this);

        functionIdentifier = lastIdentifier;
        if (!checkingForPrototypes) {

            isFunctionBlock = true;


            n.a2.accept(this);

        } else {
            functionIdentifier = lastIdentifier;
            linePlaceholder = n.line;
        }


        decreaseIndent();
    }

    @Override
    public void visit(GreaterThan n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        n.e2.accept(this);
        int right = lastType;

        if (!TypeCheckerHelper.isComparable(left, right)) {
            String first = TypeCheckerHelper.convertToType(left);
            String second = TypeCheckerHelper.convertToType(right);
            TypeCheckerHelper.reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable in Comparison Operators: <, <=, >, >=");
        }
        lastType = 2;


        decreaseIndent();
    }

    @Override
    public void visit(GreaterThanEqual n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        n.e2.accept(this);
        int right = lastType;

        if (!TypeCheckerHelper.isComparable(left, right)) {
            String first = TypeCheckerHelper.convertToType(left);
            String second = TypeCheckerHelper.convertToType(right);
            TypeCheckerHelper.reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable in Comparison Operators: <, <=, >, >=");
        }
        lastType = 2;


        decreaseIndent();
    }

    @Override
    public void visit(Identifier n) {
        lastIdentifier = n.toString();
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(IntegerLiteral n) {
        lastType = 0;
        lastValue = n.i;
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(IntType n) {
        lastType = 0;
        printNode(n);
    }

    @Override
    public void visit(LessThan n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        n.e2.accept(this);
        int right = lastType;

        if (!TypeCheckerHelper.isComparable(left, right)) {
            String first = TypeCheckerHelper.convertToType(left);
            String second = TypeCheckerHelper.convertToType(right);
            TypeCheckerHelper.reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable in Comparison Operators: <, <=, >, >=");
        }
        lastType = 2;

        decreaseIndent();
    }

    @Override
    public void visit(LessThanEqual n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        n.e2.accept(this);
        int right = lastType;

        if (!TypeCheckerHelper.isComparable(left, right)) {
            String first = TypeCheckerHelper.convertToType(left);
            String second = TypeCheckerHelper.convertToType(right);
            TypeCheckerHelper.reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable in Comparison Operators: <, <=, >, >=");
        }
        lastType = 2;

        decreaseIndent();
    }

    @Override
    public void visit(MinusEqual n) {
        printNode(n);
    }

    @Override
    public void visit(MinusMinusUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        int returnOfOperand = parser.st.typeOfVariable(lastIdentifier);
        if (!(returnOfOperand == 0 || returnOfOperand == 1)) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": \"" + TypeCheckerHelper.convertToType(returnOfOperand) + "\" can not be decremented");
        }
        if (parser.st.isConstant(lastIdentifier)) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": \"" + lastIdentifier + "\" is a constant, and therefore it can not be decremented");

        }

        decreaseIndent();
    }

    @Override
    public void visit(NotEqualExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        n.e2.accept(this);
        int right = lastType;
        if (!TypeCheckerHelper.isComparableEquality(left, right)) {
            String first = TypeCheckerHelper.convertToType(left);
            String second = TypeCheckerHelper.convertToType(right);
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable)");
        }
        lastType = 2;


        decreaseIndent();
    }

    @Override
    public void visit(NotUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        if (lastType != 2) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": \"" + TypeCheckerHelper.convertToType(lastType) + "\" can not be negated");
        }


        decreaseIndent();
    }

    @Override
    public void visit(PlusEqual n) {
        printNode(n);
    }

    @Override
    public void visit(PlusExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        String ident1 = lastIdentifier;
        n.e2.accept(this);
        int right = lastType;

        lastType = TypeCheckerHelper.EvaluateExpression(n, n.e1, n.e2, ident1, lastIdentifier, n.lineNumber, left, right);


        decreaseIndent();
    }

    @Override
    public void visit(PlusPlusUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        int returnOfOperand = parser.st.typeOfVariable(lastIdentifier);
        if (!(returnOfOperand == 0 || returnOfOperand == 1)) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": \"" + TypeCheckerHelper.convertToType(returnOfOperand) + "\" can not be incremented");
        }
        if (parser.st.isConstant(lastIdentifier)) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": \"" + lastIdentifier + "\" is a constant, and therefore it can not be incremented");

        }

        decreaseIndent();
    }

    @Override
    public void visit(PostfixExpressionMinusMinus n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        int returnOfOperand = parser.st.typeOfVariable(lastIdentifier);
        if (!(returnOfOperand == 0 || returnOfOperand == 1)) {
            TypeCheckerHelper.reportError("Line " + n.line + ": \"" + TypeCheckerHelper.convertToType(returnOfOperand) + "\" can not be decremented");
        }

        if (parser.st.isConstant(lastIdentifier)) {
            TypeCheckerHelper.reportError("Line " + n.line + ": \"" + lastIdentifier + "\" is a constant, and therefore it can not be decremented");
        }


        decreaseIndent();
    }

    @Override
    public void visit(PostfixExpressionPlusPlus n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        int returnOfOperand = parser.st.typeOfVariable(lastIdentifier);
        if (!(returnOfOperand == 0 || returnOfOperand == 1)) {
            TypeCheckerHelper.reportError("Line " + n.line + ": \"" + TypeCheckerHelper.convertToType(returnOfOperand) + "\" can not be incremented");
        }
        if (parser.st.isConstant(lastIdentifier)) {
            TypeCheckerHelper.reportError("Line " + n.line + ": \"" + lastIdentifier + "\" is a constant, and therefore it can not be incremented");

        }

        decreaseIndent();
    }

    @Override
    public void visit(ReturnStatementExpression n) {
        printNode(n);
        increaseIndent();
        int typeOfFunction = parser.st.returnTypeOfFunction(functionIdentifier);
        NonAssigningReturningFunctionCall = true;
        retStatement = true;
        n.e.accept(this);
        NonAssigningReturningFunctionCall = false;
        retStatement = false;

        if ((typeOfFunction != lastType) && !TypeCheckerHelper.convertToType(lastType).equals("Unknown")) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": invalid return type, expected: \"" + TypeCheckerHelper.convertToType(typeOfFunction) +
                    "\", provided: \"" + TypeCheckerHelper.convertToType(lastType) + "\"");


        }
        decreaseIndent();
    }

    @Override
    public void visit(RobotType n) {
        lastType = 4;
        printNode(n);
    }

    @Override
    public void visit(ServoPrimitiveType n) {
        lastType = 6;
        printNode(n);
    }

    @Override
    public void visit(ServoType n) {
        printNode(n);
        lastType = 5;
    }

    @Override
    public void visit(StatementBlock n) {
        printNode(n);
        increaseIndent();

        n.s.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(StrLiteral n) {
        printNodeWithValue(n, n.s);
        lastType = 3;
    }

    @Override
    public void visit(Switch n) {
        printNode(n);
        increaseIndent();
        NonAssigningReturningFunctionCall = true;
        n.e.accept(this);
        NonAssigningReturningFunctionCall = false;

        if (lastType != 0 && lastType != -1) {
            TypeCheckerHelper.reportError("Line " + n.line + ": " + TypeCheckerHelper.convertToType(lastType) + " is not compatible with a switch");
        }

        n.s.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(SwitchBlockLabels n) {
        printNode(n);
        increaseIndent();


        for (int i = 0; i < n.s1.list.size(); i++) {
            n.s1.list.get(i).accept(this);
        }

        for (int i = 0; i < n.s2.list.size(); i++) {
            n.s2.list.get(i).accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(SwitchGroups n) {
        printNode(n);
        increaseIndent();

        for (int i = 0; i < n.s.list.size(); i++) {
            n.s.list.get(i).accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(SwitchLabelBlock n) {
        printNode(n);
        increaseIndent();

        for (int i = 0; i < n.s.size(); i++) {
            n.s.get(i).accept(this);
        }
        parser.st.createScope();
        for (int i = 0; i < n.bs.size(); i++) {
            n.bs.get(i).accept(this);
        }
        parser.st.closeScope();

        decreaseIndent();
    }

    @Override
    public void visit(SwitchLabels n) {
        printNode(n);
        increaseIndent();

        for (int i = 0; i < n.s.size(); i++) {
            n.s.get(i).accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(TernaryExpression n) {
        printNode(n);
        increaseIndent();
        NonAssigningReturningFunctionCall = true;
        n.e1.accept(this);
        NonAssigningReturningFunctionCall = false;
        n.e2.accept(this);
        n.e3.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(UnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(IdentifierExpression n) {
        lastIdentifier = n.toString();
        lastType = Parser.parser.st.typeOfVariable(n.toString());

        if (parser.st.returnTypeOfFunction(lastIdentifier) != -1) {
            TypeCheckerHelper.reportError("Line " + n.line + ": \"" + lastIdentifier + "\" refers to a function, which cannot be used in the current context");
        } else if (!parser.st.lookupVariable(lastIdentifier)) {
            TypeCheckerHelper.reportError("Line " + n.line + ": \"" + lastIdentifier + "\" is not declared");
        } else if (!parser.st.isVariableInitialized(lastIdentifier) && !isAssigmentExpression) {
            TypeCheckerHelper.reportError("Line " + n.line + ": " + lastIdentifier + " has not been initialized");
        } else if (checkingForArray) {
            Symbol s = parser.st.returnSymbol(lastIdentifier);
            if (s instanceof ArrayVariable) {
                TypeCheckerHelper.reportError("Line " + n.line + ": \"" + lastIdentifier + "\" is an array use indexing in the current context");
            }
        }

        Symbol s = parser.st.returnSymbol(lastIdentifier);
        if (s instanceof ArrayVariable) {
            switch (lastType) {
                case 0:
                    lastType = 8;
                    break;
                case 1:
                    lastType = 9;
            }
        }
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(AndExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        n.e2.accept(this);
        int right = lastType;

        if (!TypeCheckerHelper.isComparableEquality(left, right)) {
            String first = TypeCheckerHelper.convertToType(left);
            String second = TypeCheckerHelper.convertToType(right);
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable)");
        }


        lastType = 2;
        decreaseIndent();
    }

    @Override
    public void visit(OrExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        n.e2.accept(this);
        int right = lastType;


        if (!TypeCheckerHelper.isComparableEquality(left, right)) {
            String first = TypeCheckerHelper.convertToType(left);
            String second = TypeCheckerHelper.convertToType(right);
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable");
        }

        lastType = 2;
        decreaseIndent();
    }

    @Override
    public void visit(MinusExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        String ident1 = lastIdentifier;
        n.e2.accept(this);
        int right = lastType;


        lastType = TypeCheckerHelper.EvaluateExpression(n, n.e1, n.e2, ident1, lastIdentifier, n.lineNumber, left, right);


        decreaseIndent();
    }

    @Override
    public void visit(ModuloExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        String ident1 = lastIdentifier;
        n.e2.accept(this);
        int right = lastType;


        lastType = TypeCheckerHelper.EvaluateExpression(n, n.e1, n.e2, ident1, lastIdentifier, n.lineNumber, left, right);


        decreaseIndent();
    }

    @Override
    public void visit(DivisionExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        String ident1 = lastIdentifier;
        n.e2.accept(this);
        int right = lastType;

        lastType = TypeCheckerHelper.EvaluateExpression(n, n.e1, n.e2, ident1, lastIdentifier, n.lineNumber, left, right);


        decreaseIndent();
    }

    @Override
    public void visit(MultiplicationExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        String ident1 = lastIdentifier;

        n.e2.accept(this);
        int right = lastType;


        lastType = TypeCheckerHelper.EvaluateExpression(n, n.e1, n.e2, ident1, lastIdentifier, n.lineNumber, left, right);


        decreaseIndent();
    }

    @Override
    public void visit(ArrayAccessIndex n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        n.i.accept(this);
        String s = n.e.toString();
        if (lastType != 0) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": " + lastIdentifier + "[" + s + "]" + " is illegal, as only int can be used to access an index (" +
                    TypeCheckerHelper.convertToType(lastType) + " provided) ");
        }

        lastType = parser.st.returnTypeOfArray(lastIdentifier);

        decreaseIndent();
    }

    @Override
    public void visit(ReturningFunctionCall n) {
        printNode(n);
        increaseIndent();
        String AssignedTo = lastIdentifier;
        boolean passSizeCheck = true;
        n.i.accept(this);


        if (!TypeCheckerHelper.isCompatible(parser.st.typeOfVariable(AssignedTo), parser.st.returnTypeOfFunction(n.i.toString())) && !NonAssigningReturningFunctionCall) {

            TypeCheckerHelper.reportError("Line " + n.line + ": " + "Function" + " \"" + n.i.toString() + "\" " + "has type " + "\"" +
                    TypeCheckerHelper.convertToType(parser.st.returnTypeOfFunction(n.i.toString())) + "\" " + "which can not be assigned to " + AssignedTo
                    + "(" + TypeCheckerHelper.convertToType(parser.st.typeOfVariable(AssignedTo)) + ")");
        } else if (NonAssigningReturningFunctionCall && TypeCheckerHelper.convertToType(parser.st.returnTypeOfFunction(n.i.toString())).equals("void")) {
            TypeCheckerHelper.reportError("Line " + n.line + ": void function " + "\"" + n.i.toString() + "\" can not be used i boolean expression");
        }
        ArrayList<Symbol> formal = parser.st.returnFormalParameters(n.i.toString());

        if (formal.size() != n.al.size()) {
            TypeCheckerHelper.reportError("Line " + n.line + ": " + "Function" + " \"" + n.i.toString() + "\" " + "expects " + formal.size()
                    + " parameters, but received " + n.al.size());
            passSizeCheck = false;
        }

        for (int i = 0; i < n.al.size(); i++) {
            n.al.get(i).accept(this);
            if (passSizeCheck && formal.size() > 0) {
                if (!TypeCheckerHelper.isCompatible(TypeCheckerHelper.convertFromType(formal.get(i).type), lastType)) {
                    TypeCheckerHelper.reportError("Line " + n.line + ": parameter " + (i + 1) + " of function expects type " + "\"" + formal.get(i).type
                            + "\" but \"" + TypeCheckerHelper.convertToType(lastType) + "\" was provided");
                }
            }
        }

        lastType = parser.st.returnTypeOfFunction(n.i.toString());


        decreaseIndent();
    }

    @Override
    public void visit(ForLoop n) {
        printNode(n);
        increaseIndent();
        parser.st.createScope();
        n.fi.accept(this);
        n.e.accept(this);
        n.sel.accept(this);

        lastBlockForLoop = true;

        decreaseIndent();
    }

    @Override
    public void visit(WhileLoop n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(IfElse n) {
        printNode(n);
        increaseIndent();
        NonAssigningReturningFunctionCall = true;
        n.e.accept(this);
        NonAssigningReturningFunctionCall = false;
        n.s1.accept(this);
        n.s2.accept(this);

        String node = n.e.toString();
        if (!node.contains("AssignmentExpression")) {
            n.e.accept(this);
        } else {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": Use == instead of =");
        }

        if (node.matches("\\-?\\d*\\.?\\d+")) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": \"" + node + "\" can not be used in this context");
        } else if (!TypeCheckerHelper.returnTypeofExpression(n.e).isBlank()) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": Boolean expression is required");
        }
        if (!(n.s1 instanceof ABlockStatement)) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": BEGIN END block is required");
        }
        if (!(n.s2 instanceof ABlockStatement)) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": BEGIN END block is required");
        }


        decreaseIndent();
    }

    @Override
    public void visit(If n) {
        NonAssigningReturningFunctionCall = true;
        printNode(n);
        increaseIndent();
        String node = n.e.toString();
        if (!node.contains("AssignmentExpression")) {
            n.e.accept(this);
        } else {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": Use == instead of =");
        }

        if (node.matches("\\-?\\d*\\.?\\d+")) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": \"" + node + "\" can not be used in this context");
        } else if (!TypeCheckerHelper.returnTypeofExpression(n.e).isBlank()) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": Boolean expression is required");
        }
        if (!(n.s instanceof ABlockStatement)) {
            TypeCheckerHelper.reportError("Line " + n.lineNumber + ": BEGIN END block is required");
        }
        NonAssigningReturningFunctionCall = false;
        n.s.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NonReturningFunctionCall n) {
        printNode(n);
        increaseIndent();
        boolean passSizeCheck = true;

        n.i.accept(this);
        if (parser.st.typeOfVariable(lastIdentifier) == 4) {
            String robotIdentifier = lastIdentifier;
            Symbol servoPositionObject;
            if (n.al.size() == 1) {
                n.al.get(0).accept(this);
                servoPositionObject = parser.st.getIdentifierType(lastIdentifier);
                if (servoPositionObject instanceof ArrayVariable && servoPositionObject.type.equals("ServoPosition")) {
                    ArrayVariable robotObject = (ArrayVariable) parser.st.getIdentifierType(robotIdentifier);
                    ArrayVariable servoPositionObjectArray = (ArrayVariable) servoPositionObject;
                    if (!(robotObject.getVariables().size() == servoPositionObjectArray.getVariables().size())) {
                        TypeCheckerHelper.reportError("Line " + n.line + ": " + robotObject.getVariables().size() + " parameters expected " +
                                +servoPositionObjectArray.getVariables().size() + " were provided");
                    }
                } else if (servoPositionObject instanceof ServoPositionVariable && servoPositionObject.type.equals("servoPosition")) {
                    ArrayList<String> variableNames = new ArrayList<>();
                    for (Variable element : ((ServoPositionVariable) servoPositionObject).getVariables()) {
                        variableNames.add(element.name);
                    }
                    ArrayVariable robotObject = (ArrayVariable) parser.st.getIdentifierType(robotIdentifier);
                    for (String element : variableNames) {
                        if (!robotObject.getVariables().contains(element)) {
                            TypeCheckerHelper.reportError("Line " + n.line + ": " + "Reference to element " + element + " was not found in " + robotObject.name);
                        }
                    }
                } else {
                    TypeCheckerHelper.reportError("Line " + n.line + ": " + "A ServoPosition type is expected here");
                }
            } else {
                if (n.al.size() > 1) {
                    TypeCheckerHelper.reportError("Line " + n.line + ": " + "The robot can only move to 1 position at a time, however" + n.al.size() +
                            "was provided");
                } else {
                    TypeCheckerHelper.reportError("Line " + n.line + ": " + "Position required");
                }
            }
        } else {
            ArrayList<Symbol> formal = parser.st.returnFormalParameters(n.i.toString());
            if (formal != null && formal.size() != n.al.size()) {
                TypeCheckerHelper.reportError("Line " + n.line + ": " + "Function" + " \"" + n.i.toString() + "\" " + "expects " + formal.size()
                        + " parameters, but received " + n.al.size());
                passSizeCheck = false;
            } else if (formal == null) {
                TypeCheckerHelper.reportError("Line " + n.line + ": " + "Function" + " \"" + n.i.toString() + "\" has not been declared");
                passSizeCheck = false;
            }

            for (int i = 0; i < n.al.size(); i++) {
                n.al.get(i).accept(this);
                if (passSizeCheck && formal.size() > 0) {
                    if (!TypeCheckerHelper.isCompatible(TypeCheckerHelper.convertFromType(formal.get(i).type), lastType)) {
                        TypeCheckerHelper.reportError("Line " + n.line + ": parameter " + (i + 1) + " of function expects type " + "\"" + formal.get(i).type
                                + "\" but \"" + TypeCheckerHelper.convertToType(lastType) + "\" was provided");
                    }
                }
            }
        }
        decreaseIndent();
    }

    @Override
    public void visit(Break n) {
        printNode(n);
        increaseIndent();


        decreaseIndent();
    }

    @Override
    public void visit(ConstantVariableDeclaration n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        int left = lastType;

        for (int i = 0; i < n.vdl.size(); i++) {
            n.vdl.get(i).accept(this);
            int right = lastType;
            if (!TypeCheckerHelper.isCompatible(left, right)) {
                String first = TypeCheckerHelper.convertToType(left);
                String second = TypeCheckerHelper.convertToType(right);
                TypeCheckerHelper.reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not compatible");
            } else if (!parser.st.addVariable(lastIdentifier, TypeCheckerHelper.convertToType(left))) {
                TypeCheckerHelper.reportError("Line " + n.line + ": \"" + lastIdentifier + "\" already declared");

            } else if (left == 4 || left == 5 || left == 6) {
                TypeCheckerHelper.reportError("Line " + n.line + ": Constant declaration can not be applied on \"" + TypeCheckerHelper.convertToType(left) + "\"");

            } else if (!isAssignmentDecl) {
                TypeCheckerHelper.reportError("Line " + n.line + ": Constant declaration of variable \"" + lastIdentifier + "\" needs to be initialized");
            } else {
                parser.st.setToConstant();
                parser.st.setVariableInit(lastIdentifier);
            }

        }

        decreaseIndent();
    }

    @Override
    public void visit(VariableDeclaration n) {
        printNode(n);
        increaseIndent();
        linePlaceholder = n.line;

        n.t.accept(this);
        int left = lastType;

        for (int i = 0; i < n.vdl.size(); i++) {

            VariableAssignmentDeclaration ChildLookup = new VariableAssignmentDeclaration(null, null, 0);

            if (n.vdl.get(i) instanceof VariableAssignmentDeclaration) {
                ChildLookup = (VariableAssignmentDeclaration) n.vdl.get(i);
                gatheringDeclaration = true;
                n.vdl.get(i).accept(this);
                gatheringDeclaration = false;

                if (n.t instanceof ArrayType) {
                    if (!(((VariableAssignmentDeclaration) n.vdl.get(i)).a instanceof ArrayVariables)) {

                        if (ChildLookup.a instanceof IdentifierExpression) {
                            TypeCheckerHelper.reportError("Line " + n.line + ": Array can not be assigned to an identifier");
                            isArrayType = false;
                        } else {
                            TypeCheckerHelper.reportError("Line " + n.line + ": " + TypeCheckerHelper.convertToType(left) + "[] is assigned to a non array");
                        }
                    }
                } else if (!(n.t.toString().contains("Type") && (((VariableAssignmentDeclaration) n.vdl.get(i)).a instanceof ReturningFunctionCall
                        || (ChildLookup.a instanceof BoolLiteral || ChildLookup.a instanceof IntegerLiteral || ChildLookup.a instanceof FloatLiteral)))) {

                    if (ChildLookup.a instanceof IdentifierExpression) {
                        Symbol s = parser.st.returnSymbol(ChildLookup.a.toString());
                        if (s != null && !(s instanceof Variable)) {
                            TypeCheckerHelper.reportError("Line " + n.line + ": " + TypeCheckerHelper.convertToType(left) + " is assigned to an array");
                        }
                    } else if (ChildLookup.a instanceof ArrayVariables && !(n.t instanceof RobotType) && !(n.t instanceof ServoType)) {
                        TypeCheckerHelper.reportError("Line " + n.line + ": " + TypeCheckerHelper.convertToType(left) + " is assigned to an array");
                    }


                }

                if (parser.st.addVariable(lastIdentifier, TypeCheckerHelper.convertToType(left))) {
                    n.vdl.get(i).accept(this);
                    parser.st.removeVariable(lastIdentifier);
                } else {
                    n.vdl.get(i).accept(this);
                }
            } else {
                n.vdl.get(i).accept(this);
            }
            int right = lastType;

            ArrayVariable av = new ArrayVariable(lastIdentifier, TypeCheckerHelper.convertToType(left));
            if (isArrayType || left == 4 || left == 5) {


                if (!alternativeServoPosition && !parser.st.addArrayVariable(av)) {
                    TypeCheckerHelper.reportError("Line " + n.line + ": \"" + lastIdentifier + "\" already declared");
                } else if (left == 4) {
                    int counter = 0;
                    for (String v : identifierArray) {
                        if (parser.st.typeOfVariable(v) != 6) {
                            if (!v.equals("error")) {
                                TypeCheckerHelper.reportError("Line " + n.line + ": " + "The robot type is only compatible with Servo type, \"" +
                                        v + "\" was provided on index: " + counter);
                                av.addParameter("error");
                            }
                        } else {
                            av.addParameter(v);
                        }
                        counter++;
                    }
                    if (isAssignmentDecl) {
                        av.hasBeenInit = true;
                        isAssignmentDecl = false;
                    }
                } else if (left == 5 && !alternativeServoPosition) {
                    int counter = 0;
                    for (Integer v : arrayPlaceholder) {


                        av.addParameter(v.toString());

                        if (isAssignmentDecl) {
                            av.hasBeenInit = true;
                            isAssignmentDecl = false;
                        }
                        counter++;
                    }


                } else if (left == 5) {
                    if (arrayPlaceholder.size() == parameters.size()) {
                        for (int q = 0; q < arrayPlaceholder.size(); q++) {
                            parameters.get(q).value = arrayPlaceholder.get(q).toString();
                        }
                    }

                    if (!parser.st.addServoPositionVariable(lastIdentifier, parameters)) {
                        TypeCheckerHelper.reportError("Line " + n.line + ": \"" + lastIdentifier + "\" already declared");
                    } else if (isAssignmentDecl) {
                        parser.st.setVariableInit(lastIdentifier);
                        isAssignmentDecl = false;
                    }

                } else {
                    int counter = 0;
                    for (Integer v : arrayPlaceholder) {
                        if (!TypeCheckerHelper.isCompatible(left, v)) {

                            TypeCheckerHelper.reportError("Line " + n.line + ": " + "Type \"" + TypeCheckerHelper.convertToType(v) + "\" can not be assigned to " + lastIdentifier
                                    + "(" + TypeCheckerHelper.convertToType(left) + ") " + "on index: " + counter);
                            av.addParameter("error");
                        } else {
                            av.addParameter(TypeCheckerHelper.convertToType(v));
                        }
                        counter++;
                    }
                    if (isAssignmentDecl) {
                        av.hasBeenInit = true;
                        isAssignmentDecl = false;
                    }
                }
                isArrayType = false;

            } else if (!TypeCheckerHelper.isCompatible(left, right) && right != -1 && !(ChildLookup.a instanceof ReturningFunctionCall)) {
                String first = TypeCheckerHelper.convertToType(left);
                String second = TypeCheckerHelper.convertToType(right);

                TypeCheckerHelper.reportError("Line " + n.line + ": " + "Type \"" + second + "\" cannot be assigned to \"" + first + "\"");

            } else if (!parser.st.addVariable(lastIdentifier, TypeCheckerHelper.convertToType(left))) {
                TypeCheckerHelper.reportError("Line " + n.line + ": \"" + lastIdentifier + "\" already declared");
            } else if (isAssignmentDecl) {
                parser.st.setVariableInit(lastIdentifier);
                isAssignmentDecl = false;
            }
            if ((left == 6 || left == 5 || left == 4) && !functionIdentifier.equals("setup")) {
                TypeCheckerHelper.reportError("Line " + n.line + ": The \"" + TypeCheckerHelper.convertToType(left) + "\" type can only be declared in setup function");
            }

            if (functionIdentifier.equals("setup")) {
                if (left == 6) {
                    setupPlaceholder.add(new Variable(lastIdentifier, TypeCheckerHelper.convertToType(left)));
                } else if (left == 5 || left == 4) {
                    if (alternativeServoPosition) {
                        setupPlaceholder.add(new ServoPositionVariable(lastIdentifier, TypeCheckerHelper.convertToType(left), parameters));
                    } else {
                        setupPlaceholder.add(new ArrayVariable(lastIdentifier, TypeCheckerHelper.convertToType(left), av.getVariables()));
                    }
                }
            }
            alternativeServoPosition = false;


        }
        decreaseIndent();
    }

    @Override
    public void visit(DefaultCase n) {
        printNode(n);
        increaseIndent();

        decreaseIndent();
    }

    @Override
    public void visit(EmptySwitch n) {
        printNode(n);
        increaseIndent();

        decreaseIndent();
    }

    @Override
    public void visit(LocalVariableDeclarationStatement n) {
        printNode(n);
        increaseIndent();

        n.s.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(Block n) {
        printNode(n);
        increaseIndent();

        parser.st.createScope();
        if (isFunctionBlock) {
            if (functionIdentifier.equals("loop")) {
                for (Symbol s : setupPlaceholder) {
                    if (s.type.equals("Servo")) {
                        parser.st.addVariable(s.name, s.type);
                        parser.st.setVariableConstant(s.name);
                        parser.st.setVariableInit(s.name);
                    } else if (s.type.equals("Robot")) {
                        parser.st.addArrayVariable((ArrayVariable) s);
                        parser.st.setVariableInit(s.name);
                    } else if (s.type.equals("ServoPosition")) {
                        if (s instanceof ArrayVariable) {
                            parser.st.addArrayVariable((ArrayVariable) s);
                            parser.st.setVariableInit(s.name);
                        } else {
                            ServoPositionVariable e = (ServoPositionVariable) s;
                            parser.st.addServoPositionVariable(s.name, e.getVariables());
                            parser.st.setVariableInit(s.name);
                        }
                    }
                }
            }
            for (Symbol p : functionListParameterList.get(functionNumber)) {
                if (p instanceof ArrayVariable) {
                    parser.st.addArrayVariable((ArrayVariable) p);
                    parser.st.setVariableInit(p.name);

                } else if (p instanceof Variable) {
                    parser.st.addVariable(p.name, p.type);
                    parser.st.setVariableInit(p.name);
                } else {
                    TypeCheckerHelper.reportError("Line " + linePlaceholder + ": FATAL ERROR, (this should not show)");
                }
            }
            functionNumber++;
            isFunctionBlock = false;
        }

        for (int i = 0; i < n.sl.size(); i++) {
            n.sl.get(i).accept(this);
        }
        if (functionIdentifier.equals("setup")) {
            parser.st.setSetupScope();
        }
        parser.st.closeScope();

        decreaseIndent();
    }

    @Override
    public void visit(ServoPositionVariables n) {
        printNode(n);
        increaseIndent();
        alternativeServoPosition = true;
        parameters = new ArrayList<Variable>();
        if (n.vi.list.size() == n.vi.ident.size()) {
            arrayPlaceholder = new ArrayList<>();
            for (int i = 0; i < n.vi.list.size(); i++) {
                n.vi.list.get(i).accept(this);
                arrayPlaceholder.add(lastValue);
                if (parser.st.lookupSymbol(n.vi.ident.get(i)) && lastType == 0) {
                    parameters.add(new Variable(n.vi.ident.get(i), TypeCheckerHelper.convertToType(lastType)));
                } else {
                    if (!parser.st.lookupSymbol(n.vi.ident.get(i))) {
                        TypeCheckerHelper.reportError("Line " + linePlaceholder + ": " + "Variable" + " \"" + n.vi.ident.get(i) + "\" has not been declared");
                    }
                    if (lastType != 0) {
                        TypeCheckerHelper.reportError("Line " + linePlaceholder + ": " + "ServoPosition is only compatible with int type, \"" +
                                TypeCheckerHelper.convertToType(lastType) + "\" was provided on index: " + i);
                    }
                }
            }
        } else {
            TypeCheckerHelper.reportError("Fatal error in ServoPosition");
        }
        decreaseIndent();
    }

    @Override
    public void visit(EmptyArray n) {
        printNode(n);
        increaseIndent();

        decreaseIndent();
    }

    @Override
    public void visit(ConstantFormalParameter n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        n.i.accept(this);
        constantFormalParameter = true;

        decreaseIndent();
    }

    @Override
    public void visit(FormalParameter n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        n.i.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(VoidFunctionHeader n) {
        printNode(n);
        increaseIndent();

        n.a.accept(this);
        functionType = "void";

        decreaseIndent();
    }

    @Override
    public void visit(TypeFunctionHeader n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        isArrayType = false;
        if (n.t instanceof ArrayType) {
            switch (lastType) {
                case 0:
                    lastType = 8;

                    break;
                case 1:
                    lastType = 9;

            }
        }
        functionType = TypeCheckerHelper.convertToType(lastType);
        n.a.accept(this);
        decreaseIndent();
    }

    @Override
    public void visit(VariableAssignmentDeclaration n) {
        printNode(n);
        increaseIndent();
        lastIdentifier = n.i.toString();

        if (!gatheringDeclaration) {
            NonAssigningReturningFunctionCall = true;
            n.a.accept(this);
            n.i.accept(this);
            isAssignmentDecl = true;
            NonAssigningReturningFunctionCall = false;
        }
        decreaseIndent();
    }

    @Override
    public void visit(IdentifierVariable n) {
        lastIdentifier = n.toString();
        printNodeWithValue(n, n.s);
    }

    @Override
    public void visit(ABlockStatement n) {
        printNode(n);
        increaseIndent();
        if (!lastBlockForLoop) {
            parser.st.createScope();
        } else {
            lastBlockForLoop = false;
        }
        for (int i = 0; i < n.sl.size(); i++) {
            if (n.sl.get(i) != null) {
                n.sl.get(i).accept(this);
            }
        }
        parser.st.closeScope();

        decreaseIndent();
    }

    @Override
    public void visit(FunctionDeclarator n) {
        printNodeWithValue(n, n.i);
        increaseIndent();

        for (int i = 0; i < n.fplo.list.size(); i++) {
            n.fplo.list.get(i).accept(this);

            if (checkingForPrototypes) {
                switch (lastType) {
                    case 0:
                    case 1:
                        if (isArrayType) {
                            prototypes.add(new ArrayVariable(lastIdentifier, TypeCheckerHelper.convertToType(lastType)));
                            isArrayType = false;
                        } else {
                            prototypes.add(new Variable(lastIdentifier, TypeCheckerHelper.convertToType(lastType), constantFormalParameter));
                        }
                        break;
                    case 2:
                    case 3:
                        prototypes.add(new Variable(lastIdentifier, TypeCheckerHelper.convertToType(lastType), constantFormalParameter));
                        constantFormalParameter = false;
                        break;

                    default:
                        TypeCheckerHelper.reportError("Line " + n.lineNumber + ": " + "type \"" + TypeCheckerHelper.convertToType(lastType) + "\" can not be used as a formal parameter");
                }
            } else {
                isArrayType = false;
            }
        }
        lastIdentifier = n.i;

        decreaseIndent();
    }

    @Override
    public void visit(ArrayVariables n) {
        printNode(n);
        increaseIndent();
        if (lastType == 5) {
            arrayPlaceholder = new ArrayList<Integer>();
            for (int i = 0; i < n.il.list.size(); i++) {
                n.il.list.get(i).accept(this);
                if (lastType != 0) {
                    TypeCheckerHelper.reportError("Line " + n.lineNumber + ": " + "The ServoPosition type is only compatible with int type, \"" +
                            TypeCheckerHelper.convertToType(lastType) + "\" was provided on index: " + i);
                    arrayPlaceholder.add(-1);
                } else {
                    arrayPlaceholder.add(lastValue);
                }

            }

        } else {
            identifierArray = new ArrayList<String>();
            arrayPlaceholder = new ArrayList<Integer>();
            if (lastType != 4) {
                for (int i = 0; i < n.il.list.size(); i++) {
                    n.il.list.get(i).accept(this);
                    arrayPlaceholder.add(lastType);
                }
            } else {
                for (int i = 0; i < n.il.list.size(); i++) {
                    n.il.list.get(i).accept(this);
                    if (lastType != 6) {
                        TypeCheckerHelper.reportError("Line " + n.lineNumber + ": " + "The robot type is only compatible with Servo type, \"" +
                                TypeCheckerHelper.convertToType(lastType) + "\" was provided on index: " + i);
                        identifierArray.add("error");
                    } else {
                        identifierArray.add(lastIdentifier);
                    }
                }
            }
        }
        decreaseIndent();
    }

    @Override
    public void visit(Program program) {
        printNode(program);
        increaseIndent();

        program.sl.accept(this);


        if (TypeCheckerHelper.errorDetected != 0) {
            TypeCheckerHelper.reportError("Errors: " + TypeCheckerHelper.errorDetected);
            throw new RuntimeException("Fatal Syntax Error");
        }
        decreaseIndent();
    }

    @Override
    public void visit(GlobalVariablePlusFunctionStatements globalVariablePlusFunctionStatements) {
        printNode(globalVariablePlusFunctionStatements);
        increaseIndent();
        ArrayList<String> setupAndLoopList = new ArrayList<String>();
        for (int i = 0; i < globalVariablePlusFunctionStatements.v.size(); i++) {
            globalVariablePlusFunctionStatements.v.get(i).accept(this);
        }

        parser.st.addFunction("delay", "void", new ArrayList<Symbol>(Arrays.asList(new Variable("Na", "int"))));
        checkingForPrototypes = true;
        for (functionNumber = 0; functionNumber < globalVariablePlusFunctionStatements.sl.size(); functionNumber++) {
            prototypes = new ArrayList<Symbol>();
            globalVariablePlusFunctionStatements.sl.get(functionNumber).accept(this);
            setupAndLoopList.add(functionIdentifier);
            if (!parser.st.addFunction(functionIdentifier, functionType, prototypes)) {
                TypeCheckerHelper.reportError("Line " + linePlaceholder + ": \"" + functionIdentifier + "\" already declared");
            }
            functionListParameterList.add(prototypes);
        }
        TypeCheckerHelper.CheckForLoopAndSetupInFunctionList(setupAndLoopList, globalVariablePlusFunctionStatements.lineNumber);
        checkingForPrototypes = false;
        functionNumber = 0;

        for (int i = 0; i < globalVariablePlusFunctionStatements.sl.size(); i++) {
            globalVariablePlusFunctionStatements.sl.get(i).accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(FunctionList functionList) {
        printNode(functionList);
        increaseIndent();
        ArrayList<String> setupAndLoopList = new ArrayList<String>();
        parser.st.addFunction("delay", "void", new ArrayList<Symbol>(Arrays.asList(new Variable("Na", "int"))));
        checkingForPrototypes = true;
        for (functionNumber = 0; functionNumber < functionList.fsl.size(); functionNumber++) {
            prototypes = new ArrayList<Symbol>();
            functionList.fsl.get(functionNumber).accept(this);
            setupAndLoopList.add(functionIdentifier);
            if (!parser.st.addFunction(functionIdentifier, functionType, prototypes)) {
                TypeCheckerHelper.reportError("Line " + linePlaceholder + ": \"" + functionIdentifier + "\" already declared");
            }
            functionListParameterList.add(prototypes);
        }
        TypeCheckerHelper.CheckForLoopAndSetupInFunctionList(setupAndLoopList, functionList.lineNumber);
        checkingForPrototypes = false;
        functionNumber = 0;

        for (int i = 0; i < functionList.fsl.size(); i++) {
            functionList.fsl.get(i).accept(this);
        }

        decreaseIndent();
    }
}