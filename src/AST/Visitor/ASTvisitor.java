package AST.Visitor;

import AST.Abstract.ASTNode;
import AST.List.*;
import AST.NonAbstract.Node.*;
import Parser.parser;
import SymbolTable.ArrayVariable;
import SymbolTable.ServoPositionVariable;
import SymbolTable.Symbol;
import SymbolTable.Variable;

import java.util.ArrayList;
import java.util.Arrays;


public class ASTvisitor implements Visitor {

    private int Indent = 0;
    private int lastType;
    private boolean isArrayType = false;
    private String lastIdentifier;
    private boolean isAssignmentDecl = false;
    private String functionType;
    private ArrayList<Variable> parameters = new ArrayList<Variable>();
    boolean constantFormalParameter = false;
    boolean isFunctionBlock = false;
    boolean checkingForPrototypes = false;
    int functionNumber = 0;
    private ArrayList<Symbol> prototypes = new ArrayList<Symbol>();
    private ArrayList<ArrayList<Symbol>> functionListParameterList = new ArrayList<ArrayList<Symbol>>();
    private String functionIdentifier = "global";
    int linePlaceholder;
    ArrayList<Integer> arrayPlaceholder = new ArrayList<Integer>();
    private boolean isAssigmenExpression = false;
    private boolean alternativeServoPosition = false;
    ArrayList<Symbol> setupPlaceholder = new ArrayList<Symbol>();
    ArrayList<String> identifierArray = new ArrayList<>();
    private int warningDetected = 0;
    private boolean gatheringDeclaration = false;
    private int lastValue;
    private boolean lastBlockForLoop = false;



    private void increaseIndent() { Indent += 2; }
    private int errorDetected = 0;

    private void decreaseIndent() { Indent -= 2; }

    private void printNodeLine(String s) {

        if(!checkingForPrototypes) {
            String line = "";
            for (int i = 0; i < Indent; i++) {
                line += " ";
            }
            System.out.println(line + s);
        }
    }
    private void reportError(String message){
        errorDetected++;
        System.out.println(message);
    }
    private void reportWarning(String message){
        warningDetected++;
        System.out.println(message);
    }
    private void printNode(ASTNode a) {
        printNodeLine(a.getClass().getSimpleName() + "'" + a.lineNumber);
    }

    private void printNodeWithValue(ASTNode a, String s) {
        printNodeLine(a.getClass().getSimpleName() + ":" + s + "'" + a.lineNumber);
    }

    private String convertToType(int convert){
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

            default:
                System.out.println("Type does not exist");
                return "Unknown";
        }
    }
    private int convertFromType(String convert){
        switch (convert){
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

            default:
                System.out.println("Type does not exist");
                return -1;
        }

    }


    @Override
    public void visit(ArrayType n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        isArrayType = true;


        decreaseIndent();
    }

    @Override
    public void visit(AssignmentExpression n) {
        printNode(n);
        increaseIndent();

        isAssigmenExpression = true;
        n.e1.accept(this);
        isAssigmenExpression = false;
        if(parser.st.IsConstant(lastIdentifier)){
            reportError("Line " + n.line + ": \"" + lastIdentifier +"\" is a constant, and therefore it can not be modified");
        }

        parser.st.setVariableInit(lastIdentifier);
        int left = lastType;
//        if(left != -1) {
//            if (parser.st.IsConstant(n.e1.toString())) {
//
//                System.out.println(n.e1.toString() + " is constant");
//            }
//        }
//        else{
//           errorDetected++;
//           System.out.println("Line " + n.line + ": \"" + lastIdentifier +"\" is not declared");
//        }

        n.e2.accept(this);
        n.e3.accept(this);
        int right = lastType;

        if(left != -1) {
            if (!isCompatible(left, right)) {
                String first = convertToType(left);
                String second = convertToType(right);
                reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not compatible");
            }
        }

        decreaseIndent();
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

       // lastType = EvaluateExpression(left, right);

        if(!(n.e1.toString().contains("@") || n.e1.toString().contains("@"))) {
            if (!isComparableEquality(left, right)) {
                String first = convertToType(left);
                String second = convertToType(right);
                reportError("Line " + n.lineNumber + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable ("
                        + n.e1.toString() + " == " + n.e2.toString() + ")");
            }
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
        if(!checkingForPrototypes) {

        isFunctionBlock = true;


        n.a2.accept(this);


//            if (!parser.st.addFunction(functionIdentifier, functionType, parameters)) {
////                reportError("Line " + n.line + ": \"" + lastIdentifier + "\" already declared");
////            }
        }
        else {
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

        if(!isComparable(left, right)){
            String first = convertToType(left);
            String second = convertToType(right);
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable in Comparison Operators: <, <=, >, >=");
        }

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

        if(!isComparable(left, right)){
            String first = convertToType(left);
            String second = convertToType(right);
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable in Comparison Operators: <, <=, >, >=");
        }

        decreaseIndent();
    }

    @Override
    public void visit(Identifier n) {
        lastIdentifier = n.toString();
       // lastType = Parser.parser.st.ReturnType(n.toString());
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

        if(!isComparable(left, right)){
            String first = convertToType(left);
            String second = convertToType(right);
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable in Comparison Operators: <, <=, >, >=");
        }

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

        if(!isComparable(left, right)){
            String first = convertToType(left);
            String second = convertToType(right);
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable in Comparison Operators: <, <=, >, >=");
        }

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
        if(!(n.e1.toString().contains("@") || n.e1.toString().contains("@"))) {
            if (!isComparableEquality(left, right)) {
                String first = convertToType(left);
                String second = convertToType(right);
                reportError("Line " + n.lineNumber + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable ("
                        + n.e1.toString() + " != " + n.e2.toString() + ")");
            }
        }
        lastType = 2;


        decreaseIndent();
    }

    @Override
    public void visit(NotUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        if(lastType != 2){
            reportError("Line " + n.lineNumber + ": \"" +convertToType(lastType) + "\" can not be negated");
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

        //lastType = EvaluateExpression(left, right);
        lastType = EvaluateExpression(n.e1, n.e2, ident1, lastIdentifier, n.lineNumber);

    /*    if(!isCompatible(left, right)){
            String first = convertToType(left);
            String second = convertToType(right);
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not compatible");
        }*/

        decreaseIndent();
    }

    @Override
    public void visit(PlusPlusUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PostfixExpressionMinusMinus n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        if(parser.st.IsConstant(lastIdentifier)){
            reportError("Line " + n.line + ": \"" + lastIdentifier +"\" is a constant, and therefore it can not be decremented");

        }

        decreaseIndent();
    }

    @Override
    public void visit(PostfixExpressionPlusPlus n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
         if(parser.st.IsConstant(lastIdentifier)){
             reportError("Line " + n.line + ": \"" + lastIdentifier +"\" is a constant, and therefore it can not be incremented");

        }
        decreaseIndent();
    }

    @Override
    public void visit(ReturnStatementExpression n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

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

        n.e.accept(this);

         if(lastType != 0 && lastType != -1){
            reportError("Line " + n.line + ": " + convertToType(lastType) + " is not compatible with a switch");
        }
        n.s.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(SwitchBlockLabels n) {
        printNode(n);
        increaseIndent();


        for ( int i = 0; i < n.s1.list.size(); i++ ) {
            n.s1.list.get(i).accept(this);
        }

        for ( int i = 0; i < n.s2.list.size(); i++ ) {
            n.s2.list.get(i).accept(this);
        }
        
        decreaseIndent();
    }

    @Override
    public void visit(SwitchGroups n) {
        printNode(n);
        increaseIndent();

        for ( int i = 0; i < n.s.list.size(); i++ ) {
            n.s.list.get(i).accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(SwitchLabelBlock n) {
        printNode(n);
        increaseIndent();

        for ( int i = 0; i < n.s.size(); i++ ) {
            n.s.get(i).accept(this);
        }

        for ( int i = 0; i < n.bs.size(); i++ ) {
            n.bs.get(i).accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(SwitchLabels n) {
        printNode(n);
        increaseIndent();

        for ( int i = 0; i < n.s.size(); i++ ) {
            n.s.get(i).accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(TernaryExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
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
        lastType = Parser.parser.st.ReturnType(n.toString());

        if(parser.st.returnTypeOfFunction(lastIdentifier) != -1){
            reportError("Line " + n.line + ": \"" + lastIdentifier +"\" refers to a function, which cannot be used in the current context");
        }
        else if(!parser.st.lookupSymbol(lastIdentifier, true)){
            reportError("Line " + n.line + ": \"" + lastIdentifier +"\" is not declared");
        }
        else if(!parser.st.isVariableInitialized(lastIdentifier) && !isAssigmenExpression){
            reportError("Line " + n.line + ": " + lastIdentifier + " has not been initialized");

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

            if (!(n.e1.toString().contains("@") || n.e1.toString().contains("@"))) {
                if (!isComparable(left, right)) {
                    String first = convertToType(left);
                    String second = convertToType(right);
                    reportError("Line " + n.lineNumber + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable ("
                            + n.e1.toString() + " != " + n.e2.toString() + ")");
                }
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

        if(!(n.e1.toString().contains("@") || n.e1.toString().contains("@"))) {
            if (!isComparable(left, right)) {
                String first = convertToType(left);
                String second = convertToType(right);
                reportError("Line " + n.lineNumber + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable ("
                        + n.e1.toString() + " != " + n.e2.toString() + ")");
            }
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
        n.e2.accept(this);
        int right = lastType;

        lastType = EvaluateExpression(left, right);

       /* if(!isCompatible(left, right)){
            String first = convertToType(left);
            String second = convertToType(right);
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not compatible");

        }*/

        decreaseIndent();
    }

    @Override
    public void visit(ModuloExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        n.e2.accept(this);
        int right = lastType;

        lastType = EvaluateExpression(left, right);


/*        if(!isCompatible(left, right)){
            String first = convertToType(left);
            String second = convertToType(right);
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not compatible");

        }*/

        decreaseIndent();
    }

    @Override
    public void visit(DivisionExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;
        n.e2.accept(this);
        int right = lastType;

        lastType = EvaluateExpression(left, right);


     /*   if(!isCompatible(left, right)){
            String first = convertToType(left);
            String second = convertToType(right);
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not compatible");
        }*/

        decreaseIndent();
    }

    @Override
    public void visit(MultiplicationExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        int left = lastType;

        n.e2.accept(this);
        int right = lastType;


        lastType = EvaluateExpression(left, right);


    /*    if(!isCompatible(left, right)){
            String first = convertToType(left);
            String second = convertToType(right);
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not compatible");

        }*/

        decreaseIndent();
    }

    @Override
    public void visit(ArrayAccessIndex n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        n.i.accept(this);
       String s = n.e.toString();
       if(lastType != 0){
           reportError("Line " + n.lineNumber + ": " +lastIdentifier + "[" + s + "]" + " is illegal, as only int can be used to access an index (" +
                   convertToType(lastType) + " provided) ");
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
        //int wsefs = parser.st.returnTypeOfFunction(n.i.toString());

        if(!isCompatible(parser.st.ReturnType(AssignedTo), parser.st.returnTypeOfFunction(n.i.toString()))){
       // if(!(parser.st.ReturnType(AssignedTo) == parser.st.returnTypeOfFunction(n.i.toString()))){
            reportError("Line " + n.line + ": " + "Function" + " \"" + n.i.toString() + "\" " + "has type " + "\"" +
                   convertToType(parser.st.returnTypeOfFunction(n.i.toString())) + "\" " + "which can not be assigned to " + AssignedTo
                    + "(" + convertToType(parser.st.ReturnType(AssignedTo)) + ")"   );
        }
        ArrayList<Symbol> formal = parser.st.returnFormalParameters(n.i.toString());

        if(formal.size() != n.al.size()){
            reportError("Line " + n.line + ": " + "Function" + " \"" + n.i.toString() + "\" " + "expects " + formal.size()
                    +" parameters, but received " + n.al.size());
            passSizeCheck = false;
        }

        for ( int i = 0; i < n.al.size(); i++ ) {
            n.al.get(i).accept(this);
            if(passSizeCheck && formal.size()>0){
                if(!isCompatible(convertFromType(formal.get(i).type), lastType)){
                    reportError("Line " + n.line + ": parameter " + (i+1) + " of function expects type " + "\"" + formal.get(i).type
                    + "\" but \"" + convertToType(lastType) + "\" was provided");
                }
            }
        }

        decreaseIndent();
    }

    @Override
    public void visit(ForLoop n) {
        printNode(n);
        increaseIndent();
        parser.st.createScope(0);
        n.fi.accept(this);
        n.e.accept(this);
        n.sel.accept(this);
        //parser.st.closeScope();
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

        n.e.accept(this);
        n.s1.accept(this);
        n.s2.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(If n) {
        printNode(n);
        increaseIndent();
        String node = n.e.toString();
        if(!node.contains("AssignmentExpression")) {
            n.e.accept(this);
        }
        else {
            reportError("Line " + n.lineNumber + ": Use == instead of =");
        }

        if(node.matches("[0-9]+[.0-9]*")){
            reportError("Line " + n.lineNumber + ": \"" + node + "\" can not be used in this context");
        }
        n.s.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NonReturningFunctionCall n) {
        printNode(n);
        increaseIndent();
        boolean passSizeCheck = true;

        n.i.accept(this);
        if(parser.st.ReturnType(lastIdentifier) == 4){
            String robotIdentifier = lastIdentifier;
            Symbol servoPositionObject;
            if(n.al.size() == 1){
               n.al.get(0).accept(this);
               servoPositionObject = parser.st.getIdentifierType(lastIdentifier);
                if(servoPositionObject instanceof ArrayVariable && servoPositionObject.type.equals("ServoPosition")){
                    ArrayVariable robotObject = (ArrayVariable) parser.st.getIdentifierType(robotIdentifier);
                    ArrayVariable servoPositionObjectArray = (ArrayVariable) servoPositionObject;
                    if(!(robotObject.getVariables().size() == servoPositionObjectArray.getVariables().size())){
                        reportError("Line " + n.line + ": " + robotObject.getVariables().size() + " parameters expected " +
                                + servoPositionObjectArray.getVariables().size() + " were provided");
                    }
                }
                else if(servoPositionObject instanceof ServoPositionVariable && servoPositionObject.type.equals("servoPosition")){
                    ArrayList<String> variableNames = new ArrayList<>();
                    for(Variable element : ((ServoPositionVariable) servoPositionObject).getVariables()) {
                        variableNames.add(element.name);
                    }
                    ArrayVariable robotObject = (ArrayVariable) parser.st.getIdentifierType(robotIdentifier);
                    for (String element: variableNames) {
                        if(!robotObject.getVariables().contains(element)) {
                            reportError("Line " + n.line + ": " + "Reference to element " + element + " was not found in " + robotObject.name);
                        }
                    }
                }
                else{
                    reportError("Line " + n.line + ": " + "A ServoPosition type is expected here");
                }
            }
            else {
                if(n.al.size() > 1) {
                    reportError("Line " + n.line + ": " + "The robot can only move to 1 position at a time, however" + n.al.size() +
                            "was provided");
                }
                else{
                    reportError("Line " + n.line + ": " + "Position required");
                }
            }
        } else {
            //DO NOT EDIT IF STATEMENTS IN THIS VISIT - Emil
            ArrayList<Symbol> formal = parser.st.returnFormalParameters(n.i.toString());
            if (formal != null && formal.size() != n.al.size()) {
                reportError("Line " + n.line + ": " + "Function" + " \"" + n.i.toString() + "\" " + "expects " + formal.size()
                        + " parameters, but received " + n.al.size());
                passSizeCheck = false;
            } else if (formal == null) {
                reportError("Line " + n.line + ": " + "Function" + " \"" + n.i.toString() + "\" has not been declared");
                passSizeCheck = false;
            }

            for (int i = 0; i < n.al.size(); i++) {
                n.al.get(i).accept(this);
                if (passSizeCheck && formal.size() > 0) {
                    if (!isCompatible(convertFromType(formal.get(i).type), lastType)) {
                        reportError("Line " + n.line + ": parameter " + (i + 1) + " of function expects type " + "\"" + formal.get(i).type
                                + "\" but \"" + convertToType(lastType) + "\" was provided");
                    }
                }
            }
        }
        decreaseIndent();
    }
//!formal.get(i).type.equals(convertToType(lastType))
    @Override
    public void visit(Break n) {
        printNode(n);
        increaseIndent();

        //TODO: WTF

        decreaseIndent();
    }

    @Override
    public void visit(ConstantVariableDeclaration n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        int left = lastType;

        for ( int i = 0; i < n.vdl.size(); i++ ) {
            n.vdl.get(i).accept(this);
            int right = lastType;
            if (!isCompatible(left, right)) {
                String first = convertToType(left);
                String second = convertToType(right);
                reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not compatible");
            } else if(!parser.st.addVariable(lastIdentifier, convertToType(left))){
                reportError("Line " + n.line + ": \"" + lastIdentifier + "\" already declared");

            }
            else if(!isAssignmentDecl){
                reportError("Line " + n.line + ": Constant declaration of variable \"" + lastIdentifier + "\" needs to be initialized");
            }
            else {
                parser.st.ConvertToConstant();
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

        for ( int i = 0; i < n.vdl.size(); i++ ) {

            VariableAssignmentDeclaration ChildLookup = new VariableAssignmentDeclaration(null, null, 0);

            if(n.vdl.get(i) instanceof VariableAssignmentDeclaration) {
                ChildLookup = (VariableAssignmentDeclaration) n.vdl.get(i);
                gatheringDeclaration = true;
                n.vdl.get(i).accept(this);
                gatheringDeclaration = false;

                if(n.t instanceof ArrayType){
                    if(!(((VariableAssignmentDeclaration) n.vdl.get(i)).a instanceof ArrayVariables)){

                        if(ChildLookup.a instanceof IdentifierExpression){
                            reportError("Line " + n.line + ": Array can not be assigned to an identifier");
                            isArrayType = false;
                        }
                        else {
                            reportError("Line " + n.line + ": " + convertToType(left) + "[] is assigned to a non array");
                        }
                    }
                }
                else if(!(n.t.toString().contains("Type") && (((VariableAssignmentDeclaration) n.vdl.get(i)).a instanceof ReturningFunctionCall
                        || (ChildLookup.a instanceof BoolLiteral || ChildLookup.a instanceof IntegerLiteral || ChildLookup.a instanceof FloatLiteral)))){

                    if(ChildLookup.a instanceof IdentifierExpression){
                        Symbol s = parser.st.returnSymbol(ChildLookup.a.toString());
                        if(s != null && !(s instanceof Variable)){
                            reportError("Line " + n.line + ": " + convertToType(left) + " is assigned to an array");
                        }
                    }
                    else if (ChildLookup.a instanceof ArrayVariables && !(n.t instanceof RobotType) && !(n.t instanceof ServoType )){
                        reportError("Line " + n.line + ": " + convertToType(left) + " is assigned to an array");
                    }


                }

               if (parser.st.addVariable(lastIdentifier, convertToType(left))){
                   n.vdl.get(i).accept(this);
                    parser.st.removeVariable(lastIdentifier);
                }
               else {
                   n.vdl.get(i).accept(this);
               }
            }
            else {
                n.vdl.get(i).accept(this);
            }
            int right = lastType;

            ArrayVariable av = new ArrayVariable(lastIdentifier, convertToType(left));
            if(isArrayType || left == 4 || left == 5){


                if(!alternativeServoPosition && !parser.st.addArrayVariable(av)){
                    reportError("Line " + n.line + ": \"" + lastIdentifier + "\" already declared");
                }
                else if(left == 4){
                    int counter = 0;
                    for (String v : identifierArray){
                            if(parser.st.ReturnType(v) != 6){
                                if(!v.equals("error")) {
                                    reportError("Line " + n.line + ": " + "The robot type is only compatible with Servo type, \"" +
                                            v + "\" was provided on index: " + counter);
                                    av.addParameter("error");
                                }
                            }
                            else {
                                av.addParameter(v);
                            }
                            counter++;
                        }
                    if(isAssignmentDecl){
                        av.hasBeenInit = true;
                        isAssignmentDecl = false;
                    }
                }
                else if(left == 5 && !alternativeServoPosition){
                    int counter = 0;
                    for (Integer v : arrayPlaceholder){


                            av.addParameter(v.toString());

                        if(isAssignmentDecl){
                            av.hasBeenInit = true;
                            isAssignmentDecl = false;
                        }
                        counter++;
                    }


                }
                else if(left == 5){
                    if(arrayPlaceholder.size() == parameters.size()){
                        for(int q = 0; q < arrayPlaceholder.size(); q++){
                            parameters.get(q).value = arrayPlaceholder.get(q).toString();
                        }
                    }

                    if(!parser.st.addServoPositionVariable(lastIdentifier, parameters)){
                        reportError("Line " + n.line + ": \"" + lastIdentifier + "\" already declared");
                    }
                    else if(isAssignmentDecl){
                        parser.st.setVariableInit(lastIdentifier);
                        isAssignmentDecl = false;
                    }

                }
                else {
                    int counter = 0;
                    for (Integer v : arrayPlaceholder) {
                        if (!isCompatible(left, v)) {

                            reportError("Line " + n.line + ": " + "Type \"" + convertToType(v) + "\" can not be assigned to " + lastIdentifier
                                    + "(" + convertToType(left) + ") " + "on index: " + counter);
                            av.addParameter("error");
                        } else {
                            av.addParameter(convertToType(v));
                        }
                        counter++;
                    }
                    if(isAssignmentDecl){
                        av.hasBeenInit = true;
                        isAssignmentDecl = false;
                    }
                }
                isArrayType = false;

            }

            else if (!isCompatible(left, right) && right != -1  && !(ChildLookup.a instanceof ReturningFunctionCall)) {
                String first = convertToType(left);
                String second = convertToType(right);

                    reportError("Line " + n.line + ": " + "Type \"" + second + "\" cannot be assigned to \"" + first + "\"");

            }
            else if (!parser.st.addVariable(lastIdentifier, convertToType(left))) {
                reportError("Line " + n.line + ": \"" + lastIdentifier + "\" already declared");
            }
            else if (isAssignmentDecl){
                parser.st.setVariableInit(lastIdentifier);
                isAssignmentDecl = false;
            }

           if(functionIdentifier.equals("setup")){
               if(left == 6){
                   setupPlaceholder.add(new Variable(lastIdentifier, convertToType(left)));
               }
               else if(left == 5 || left == 4){
                   if(alternativeServoPosition){
                    setupPlaceholder.add(new ServoPositionVariable(lastIdentifier, convertToType(left), parameters));
                   }
                   else{
                       setupPlaceholder.add(new ArrayVariable(lastIdentifier, convertToType(left), av.getVariables()));
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

        //TODO: WTF

        decreaseIndent();
    }

    @Override
    public void visit(EmptySwitch n) {
        printNode(n);
        increaseIndent();

        //TODO: WTF

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

        parser.st.createScope(0);
        if(isFunctionBlock){
            if(functionIdentifier.equals("loop")){
                for(Symbol s : setupPlaceholder){
                    if(s.type.equals("Servo")){
                        parser.st.addVariable(s.name, s.type);
                        parser.st.setVariableConstant(s.name);
                        parser.st.setVariableInit(s.name);
                    }
                    else if(s.type.equals("Robot")){
                        parser.st.addArrayVariable((ArrayVariable)s);
                        parser.st.setVariableInit(s.name);
                    }
                    else if(s.type.equals("ServoPosition")){
                        if(s instanceof ArrayVariable){
                            parser.st.addArrayVariable((ArrayVariable)s);
                            parser.st.setVariableInit(s.name);
                        }
                        else {
                            ServoPositionVariable e = (ServoPositionVariable)s;
                            parser.st.addServoPositionVariable(s.name, e.getVariables());
                            parser.st.setVariableInit(s.name);
                        }
                    }
                }
            }
            for(Symbol p : functionListParameterList.get(functionNumber)){
               if(p instanceof ArrayVariable){
                   parser.st.addArrayVariable((ArrayVariable) p);
               }
               else if(p instanceof Variable){
                   parser.st.addVariable(p.name, p.type);
               }
               else {
                   reportError("Line " + linePlaceholder + ": FATAL ERROR, (this should not show)");
               }


                /*if(!parser.st.addVariable(p.name, p.type)){
                    reportError("Line " + (n.line-1) + ": Global variable \"" + p.name + "\" and formal parameter \"" + p.name +
                            "\" in function \"" + functionIdentifier + "\" can not have the same identifier");
                }
                else {
                    parser.st.setVariableInit(p.name);
                    if (p.isConstant) {
                        parser.st.setVariableConstant(p.name);
                    }
                }*/
            }
            functionNumber++;
            isFunctionBlock = false;
        }

        for ( int i = 0; i < n.sl.size(); i++ ) {
            n.sl.get(i).accept(this);
        }
        if(functionIdentifier.equals("setup")){
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
        if(n.vi.list.size() == n.vi.ident.size()) {
            arrayPlaceholder = new ArrayList<>();
            for (int i = 0; i < n.vi.list.size(); i++) {
                n.vi.list.get(i).accept(this);
                arrayPlaceholder.add(lastValue);
                if(parser.st.lookupSymbol(n.vi.ident.get(i)) && lastType == 0) {
                    parameters.add(new Variable(n.vi.ident.get(i), convertToType(lastType)));
                }
                else {
                    if(!parser.st.lookupSymbol(n.vi.ident.get(i))){
                        reportError("Line " + linePlaceholder + ": " + "Variable" + " \"" + n.vi.ident.get(i) + "\" has not been declared");
                    }
                    if(lastType != 0){
                        reportError("Line " + linePlaceholder + ": " + "ServoPosition is only compatible with int type, \"" +
                                convertToType(lastType) + "\" was provided on index: " + i);
                    }
                }
            }
        }
        else{
            reportError("Fatal error in ServoPosition");
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
        functionType = convertToType(lastType);
        n.a.accept(this);


        decreaseIndent();
    }

    @Override
    public void visit(VariableAssignmentDeclaration n) {
        printNode(n);
        increaseIndent();
        lastIdentifier=n.i.toString();

        if(!gatheringDeclaration) {
            n.a.accept(this);
            n.i.accept(this);
            isAssignmentDecl = true;
        }



        decreaseIndent();
    }

    @Override
    public void visit(IdentifierVariable n) {
        lastIdentifier = n.toString();

        increaseIndent();
        printNodeWithValue(n, n.s);
        decreaseIndent();
    }

    @Override
    public void visit(ABlockStatement n) {
        printNode(n);
        increaseIndent();
        if(!lastBlockForLoop) {
            parser.st.createScope(0);
        }
        else{lastBlockForLoop = false;}
        for ( int i = 0; i < n.sl.size(); i++ ) {
            if(n.sl.get(i) != null) {
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

        //parameters = new ArrayList<>();
        for ( int i = 0; i < n.fplo.list.size(); i++ ) {
            n.fplo.list.get(i).accept(this);

            if(checkingForPrototypes) {
                switch(lastType) {
                    case 0:
                    case 1:
                        if(isArrayType){
                            prototypes.add(new ArrayVariable(lastIdentifier, convertToType(lastType)));
                            isArrayType = false;
                        }
                        else{
                            prototypes.add(new Variable(lastIdentifier, convertToType(lastType), constantFormalParameter));
                        }
                        break;
                    case 2:
                        prototypes.add(new Variable(lastIdentifier, convertToType(lastType), constantFormalParameter));
                        constantFormalParameter = false;
                        break;
                    default:
                        reportError("Line " + n.lineNumber + ": " + "type \"" + convertToType(lastType) + "\" can not be used as a formal parameter");
                }
            }
            else{
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
        if(lastType == 5){
            arrayPlaceholder = new ArrayList<Integer>();
            for (int i = 0; i < n.il.list.size(); i++) {

                n.il.list.get(i).accept(this);

                if (lastType != 0){
                    reportError("Line " + n.lineNumber + ": " + "The ServoPosition type is only compatible with int type, \"" +
                            convertToType(lastType) + "\" was provided on index: " + i);
                    arrayPlaceholder.add(-1);
                }
                else {
                    arrayPlaceholder.add(lastValue);
                }

            }

        }
        else {
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
                        reportError("Line " + n.lineNumber + ": " + "The robot type is only compatible with Servo type, \"" +
                                convertToType(lastType) + "\" was provided on index: " + i);
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

        if(!parser.st.checkForLoopAndSetup()){
            reportError("void setup() and void loop() must be declared, in respective order");
            reportError("Errors: " + errorDetected);
            throw new RuntimeException("Fatal Syntax Error");
        }

        else if(errorDetected != 0){
            reportError("Errors: " + errorDetected);
            throw new RuntimeException("Fatal Syntax Error");
        }
        decreaseIndent();
    }

    @Override
    public void visit(GlobalVariablePlusFunctionStatements globalVariablePlusFunctionStatements) {
        printNode(globalVariablePlusFunctionStatements);
        increaseIndent();
        ArrayList<String> setupAndLoopList = new ArrayList<String>();
        for ( int i = 0; i < globalVariablePlusFunctionStatements.v.size(); i++ ) {
            globalVariablePlusFunctionStatements.v.get(i).accept(this);
        }

        //parser.st.addFunction("delay", "void", new ArrayList<Variable>() { new Variable("delay", "int")});
        parser.st.addFunction("delay", "void", new ArrayList<Symbol>(Arrays.asList(new Variable("Na", "int"))));
        checkingForPrototypes = true;
        for (functionNumber = 0; functionNumber < globalVariablePlusFunctionStatements.sl.size(); functionNumber++){
            prototypes = new ArrayList<Symbol>();
            globalVariablePlusFunctionStatements.sl.get(functionNumber).accept(this);
            setupAndLoopList.add(functionIdentifier);
            if (!parser.st.addFunction(functionIdentifier, functionType, prototypes)) {
                reportError("Line " + linePlaceholder + ": \"" + functionIdentifier + "\" already declared");
            }
                functionListParameterList.add(prototypes);
            }


        CheckForLoopAndSetupInFunctionList(setupAndLoopList);


        for ( int i = 0; i < globalVariablePlusFunctionStatements.sl.size(); i++ ) {
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
        for (functionNumber = 0; functionNumber < functionList.fsl.size(); functionNumber++){
            prototypes = new ArrayList<Symbol>();
            functionList.fsl.get(functionNumber).accept(this);
            setupAndLoopList.add(functionIdentifier);
            if (!parser.st.addFunction(functionIdentifier, functionType, prototypes)) {
                reportError("Line " + linePlaceholder + ": \"" + functionIdentifier + "\" already declared");
            }
            functionListParameterList.add(prototypes);
        }
        CheckForLoopAndSetupInFunctionList(setupAndLoopList);


        for ( int i = 0; i < functionList.fsl.size(); i++ ) {
            functionList.fsl.get(i).accept(this);
        }

        decreaseIndent();
    }

    private void CheckForLoopAndSetupInFunctionList(ArrayList<String> setupAndLoopList) {
        if(setupAndLoopList.size() >= 2) {
            if (!setupAndLoopList.get(0).equals("setup")) {
                reportError("Line " + linePlaceholder + ": void setup() and void loop() must be declared as the first two functions, in respective order");
            } else if (!setupAndLoopList.get(1).equals("loop")) {
                reportError("Line " + linePlaceholder + ": void setup() and void loop() must be declared as the first two functions, in respective order");
            }
        }

        checkingForPrototypes = false;
        functionNumber = 0;
    }

    private boolean isCompatible(int left, int right){
        switch (left){
            case 0:
            case 6:
                return right == 0;
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

    public boolean isComparable(int left, int right, int ln){
        switch(left){
            case 0:
                if(right == 1){
                    reportWarning("WARNING Line " + ln + ": Checking if \"int\" equals \"double\" could result in errors");
                }
            case 1:
                if(right == 0){
                    reportWarning("WARNING Line " + ln + ": Checking if \"int\" equals \"double\" could result in errors");
                }
                return (right == 0 || right == 1);
            case 2:
                return (right == 2);
            default:
                return false;
        }
    }

    public boolean isComparable(int left, int right){
        switch(left){
            case 0:
            case 1:
                return (right == 0 || right == 1);
            default:
                return false;
        }
    }

    public boolean isComparableEquality(int left, int right){
        switch(left){
            case 0:
            case 1:
                return (right == 0 || right == 1);
            case 2:
                return (right == 2);
            default:
                return false;
        }
    }

    private int EvaluateExpression(int left, int right){
        switch (left){
            case 0:
                if(right == 0)
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

    private int evalChild2(ASTNode child2, String identifierChild2, int typeofChild1, int ln){
        if(child2 instanceof IdentifierExpression){
            Symbol identChild2 = parser.st.returnSymbol(identifierChild2);
            if(identChild2 instanceof ArrayVariable || identChild2 instanceof ServoPositionVariable){
                reportError("Line " + ln + ": Array can not be on right side ");
                //bool true
            }
            else if(identChild2 instanceof Variable){
                if(identChild2.type.equals("boolean")){
                    reportError("Line " + ln + ": Boolean can not be evaluated in expression ");
                }
                else {
                    return EvaluateExpression(typeofChild1, convertFromType(identChild2.type));
                }
            }
        }
        else if(child2 instanceof FloatLiteral){
            return EvaluateExpression(typeofChild1, 1);
        }
        else if(child2 instanceof IntegerLiteral){
            return EvaluateExpression(typeofChild1, 0);
        }
        return  -1 ;
    }

    private int EvaluateExpression(ASTNode child1, ASTNode child2, String identifierChild1, String identifierChild2, int ln){
        if(child1 instanceof IdentifierExpression){
            Symbol identChild1 = parser.st.returnSymbol(identifierChild1);
            if(identChild1 instanceof ArrayVariable || identChild1 instanceof ServoPositionVariable){
                reportError("Line " + ln + ": Array can not be on right side ");
                //bool true
            }

            else if(identChild1 instanceof Variable){
                if(identChild1.type.equals("boolean")){
                    reportError("Line " + ln + ": "+ identifierChild1 + " can not be evaluated with " + identifierChild2); // todo fix error message
                }
                else {
                    return evalChild2(child2, identifierChild2, convertFromType(identChild1.type), ln);
                }
            }
        }
        else if(child1 instanceof BoolLiteral){
            reportError("Line " + ln + ": Boolean can not be evaluated in expression ");
        }
        else if(child1 instanceof IntegerLiteral){

            return evalChild2(child2, identifierChild2, 0, ln);
        }
        else if (child1 instanceof FloatLiteral){
            return evalChild2(child2, identifierChild2, 1, ln);
        }


        return  -1 ;
    }
    public boolean checkArithmeticOperators(ASTNode child1, ASTNode child2, int ln){
        if (child1 instanceof PlusExpression || child2 instanceof PlusExpression){
            reportError("Line " + ln + ": + operator can not be used in boolean expression ");
            return false;
        }
        if(child1 instanceof MinusExpression || child2 instanceof MinusExpression){
            reportError("Line " + ln + ": - operator can not be used in boolean expression ");
            return false;
        }
        if(child1 instanceof MultiplicationExpression || child2 instanceof MultiplicationExpression){
            reportError("Line " + ln + ": * operator can not be used in boolean expression ");
            return false;
        }
        if(child1 instanceof DivisionExpression || child2 instanceof DivisionExpression){
            reportError("Line " + ln + ": / operator can not be used in boolean expression ");
            return false;
        }
        if(child1 instanceof ModuloExpression || child2 instanceof ModuloExpression){
            reportError("Line " + ln + ": % operator can not be used in boolean expression ");
            return false;
        }
        return true;

    }

}
