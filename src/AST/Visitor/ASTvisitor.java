package AST.Visitor;

import AST.Abstract.ASTNode;
import AST.List.*;
import AST.NonAbstract.Node.*;
import Parser.parser;
import SymbolTable.Symbol;
import SymbolTable.Variable;

import java.util.ArrayList;


public class ASTvisitor implements Visitor {

    private int Indent = 0;
    private int lastType;
    private String lastIdentifier;
    private boolean isAssignmentDecl = false;
    private String functionType;
    private ArrayList<Variable> parameters = new ArrayList<Variable>();
    boolean constantFormalParameter = false;
    boolean isFunctionBlock = false;
    boolean checkingForPrototypes = true;

    private void increaseIndent() { Indent += 2; }
    private int errorDetected = 0;

    private void decreaseIndent() { Indent -= 2; }

    private void printNodeLine(String s) {
        String line = "";
        for (int i = 0; i < Indent; i++) { line += " "; }
        System.out.println(line + s);
    }
    private void reportError(String message){
        errorDetected++;
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

            default:
                System.out.println("Type does not exist");
                return "Unknown";
        }
    }


    @Override
    public void visit(ArrayType n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);


        decreaseIndent();
    }

    @Override
    public void visit(AssignmentExpression n) {
        printNode(n);
        increaseIndent();


        n.e1.accept(this);

        if(parser.st.IsConstant(lastIdentifier)){
            System.out.println("Line " + n.line + ": \"" + lastIdentifier +"\" is a constant, and therefore it can not be modified");
        }

        parser.st.setVariableInit(lastIdentifier);
        int left = lastType;
        if(left != -1) {
            if (parser.st.IsConstant(n.e1.toString())) {

                System.out.println(n.e1.toString() + " is constant");
            }
        }
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

        lastType = EvaluateExpression(left, right);

 /*       if(!isComparable(left, right)){
            String first = convertToType(left);
            String second = convertToType(right);
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not compatible");
        }*/
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
        
        String functionIdentifier = lastIdentifier;
        isFunctionBlock = true;
        n.a2.accept(this);

        if(!parser.st.addFunction(functionIdentifier, functionType, parameters)){
            reportError("Line " + n.line + ": \"" + lastIdentifier + "\" already declared");
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
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable");
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
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable");
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
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable");
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
            reportError("Line " + n.line + ": " + "Types \"" + first + "\" and \"" + second + "\" are not comparable");
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
        n.e2.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NotUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

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
            System.out.println("Line " + n.line + ": \"" + lastIdentifier +"\" is a constant, and therefore it can not be decremented");

        }

        decreaseIndent();
    }

    @Override
    public void visit(PostfixExpressionPlusPlus n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
         if(parser.st.IsConstant(lastIdentifier)){
            System.out.println("Line " + n.line + ": \"" + lastIdentifier +"\" is a constant, and therefore it can not be incremented");

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
        printNode(n);
    }

    @Override
    public void visit(ServoType n) {
        printNode(n);
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
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(Switch n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        if (lastType == -1){
            System.out.println("Line " + n.line + ": \"" + lastIdentifier +"\" is not declared");
        }

        else if(lastType != 0){
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
        if(!parser.st.lookupSymbol(lastIdentifier)){
            System.out.println("Line " + n.line + ": \"" + lastIdentifier +"\" is not declared");

        }

        else if(!parser.st.isVariableInitialized(lastIdentifier)){
            reportError("Line " + n.line + ": " + lastIdentifier + " has not been initialized");

        }
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(AndExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        n.e2.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(OrExpression n) {
        printNode(n);
        increaseIndent();

        n.e1.accept(this);
        n.e2.accept(this);

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

        n.i.accept(this);
        n.e.accept(this);


        decreaseIndent();
    }

    @Override
    public void visit(ReturningFunctionCall n) {
        printNode(n);
        increaseIndent();
        String AssignedTo = lastIdentifier;
        n.i.accept(this);
        int wsefs = parser.st.ReturnType(n.i.toString());


        if(!(parser.st.ReturnType(AssignedTo) == parser.st.ReturnType(n.i.toString()))){
//            reportError("Line " + n.line + ": " + "Function" + "\"" + n.i.toString() + "\"" + "has type" + "\"" +
//                    convertToType(parser.st.ReturnType(n.i.toString())) + "\"" + "which can not be assigned to" + AssignedTo
//                    + "(" + convertToType(parser.st.ReturnType(AssignedTo)) + ")"   );
        }

        for ( int i = 0; i < n.al.size(); i++ ) {
            n.al.get(i).accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(ForLoop n) {
        printNode(n);
        increaseIndent();

        n.fi.accept(this);
        n.e.accept(this);
        n.sel.accept(this);


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

        n.e.accept(this);
        n.s.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NonReturningFunctionCall n) {
        printNode(n);
        increaseIndent();

        n.i.accept(this);

        for ( int i = 0; i < n.al.size(); i++ ) {
            n.al.get(i).accept(this);
        }

        decreaseIndent();
    }

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
            else {
                parser.st.ConvertToConstant();
            }

        }

        decreaseIndent();
    }

    @Override
    public void visit(VariableDeclaration n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        int left = lastType;


        for ( int i = 0; i < n.vdl.size(); i++ ) {
            n.vdl.get(i).accept(this);
            int right = lastType;
            if (!isCompatible(left, right) && right != -1) {
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
            for(Variable p : parameters){
                parser.st.addVariable(p.name, p.type);
                parser.st.setVariableInit(p.name);
                if(p.isConstant){
                    parser.st.setVariableConstant(p.name);
                }

            }

            isFunctionBlock = false;
        }


        for ( int i = 0; i < n.sl.size(); i++ ) {
            n.sl.get(i).accept(this);
        }
        parser.st.closeScope();

        decreaseIndent();
    }

    @Override
    public void visit(ServoPositionVariables n) {
        printNode(n);
        increaseIndent();

        for ( int i = 0; i < n.vi.list.size(); i++ ) {
            n.vi.list.get(i).accept(this);
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
        n.a.accept(this);
        n.i.accept(this);
        isAssignmentDecl = true;




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

        parser.st.createScope(0);
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

        parameters = new ArrayList<>();
        for ( int i = 0; i < n.fplo.list.size(); i++ ) {
            n.fplo.list.get(i).accept(this);
            parameters.add(new Variable(lastIdentifier, convertToType(lastType), constantFormalParameter));
            constantFormalParameter = false;
        }
        lastIdentifier = n.i;

        decreaseIndent();
    }

    @Override
    public void visit(ArrayVariables n) {
        printNode(n);
        increaseIndent();

        for ( int i = 0; i < n.il.list.size(); i++ ) {
            n.il.list.get(i).accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(Program program) {
        printNode(program);
        increaseIndent();

        program.sl.accept(this);

        if(!parser.st.checkForLoopAndSetup()){
            reportError("void setup() and void loop() must be declared");
            throw new RuntimeException("Fatal Syntax Error");
        }

        else if(errorDetected != 0){
            throw new RuntimeException("Fatal Syntax Error");
        }



        decreaseIndent();
    }

    @Override
    public void visit(GlobalVariablePlusFunctionStatements globalVariablePlusFunctionStatements) {
        printNode(globalVariablePlusFunctionStatements);
        increaseIndent();

        for ( int i = 0; i < globalVariablePlusFunctionStatements.v.size(); i++ ) {
            globalVariablePlusFunctionStatements.v.get(i).accept(this);
        }

        for (int i = 0; i < globalVariablePlusFunctionStatements.sl.size(); i++){
            globalVariablePlusFunctionStatements.sl.

        }


        for ( int i = 0; i < globalVariablePlusFunctionStatements.sl.size(); i++ ) {
            globalVariablePlusFunctionStatements.sl.get(i).accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(FunctionList functionList) {
        printNode(functionList);
        increaseIndent();
        for ( int i = 0; i < functionList.fsl.size(); i++ ) {
            functionList.fsl.get(i).accept(this);
        }

        decreaseIndent();
    }

    private boolean isCompatible(int left, int right){
        switch (left){
            case 0:
                return right == 0;
            case 1:
                return (right == 1 || right == 0);
            default:
                return false;
        }
    }

    public boolean isComparable(int left, int right){
        switch(left){
            case 0:
                return (right == 0 || right == 1);
            case 1:
                return (right == 0 || right == 1);
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


}
