package AST.Visitor;

import AST.List.ArrayVariables;
import AST.NonAbstract.Node.*;
import SymbolTable.ArrayVariable;
import SymbolTable.ServoPositionVariable;
import SymbolTable.Symbol;
import Parser.parser;
import SymbolTable.Variable;

import java.util.ArrayList;

public class CodeGeneratorVisitor implements Visitor {

    public StringBuilder code = new StringBuilder();
    StringBuilder indent = new StringBuilder();
    int preEmitpoint = 20;
    boolean omitEncode = false;
    boolean isSetupfunction = false;
    boolean ignoreNewLine = false;
    boolean noKeepIndent = true;
    private void emit(String emit){

        if(emit.contains("\n") && ignoreNewLine){
            emit = emit.replace("\n", "");
        }
        if(ignoreNewLine && noKeepIndent){
            if(emit.contains("    ")){
                emit = emit.substring(4, emit.length());
            }
        }
        if (!omitEncode) {
            code.append(emit);
        }
        else if(emit.contains(";")){
            omitEncode = false;
        }
    }

    private void reduce(){
    code.deleteCharAt(code.length()-1);
    }

    private void preEmit(String emit){
        code.insert(preEmitpoint, emit);
        preEmitpoint = preEmitpoint + emit.length();
    }
    private void increaseIndent(){
        indent.append("    ");
    }
    private void decreaseIndent(){
        indent.deleteCharAt(indent.length()-1);
        indent.deleteCharAt(indent.length()-1);
        indent.deleteCharAt(indent.length()-1);
        indent.deleteCharAt(indent.length()-1);
    }
    private void reduceIndent(){code.delete(code.length()-5, code.length()-1);}



    @Override
    public void visit(ArrayType n) {
        n.t.accept(this);

    }

    @Override
    public void visit(AssignmentExpression n) {
        emit("\n"+indent);
        n.e1.accept(this);
        n.e2.accept(this);
        n.e3.accept(this);
        emit(";");
    }

    @Override
    public void visit(BoolLiteral n) {
        emit(n.toString());
    }

    @Override
    public void visit(BoolType n) {
        emit(indent +"bool ");
    }

    @Override
    public void visit(ConstantExpression n) {
        n.e.accept(this);
    }

    @Override
    public void visit(Equal n) {
        emit(" = ");
    }

    @Override
    public void visit(EqualExpression n) {
        n.e1.accept(this);
        emit(" == ");
        n.e2.accept(this);
    }

    @Override
    public void visit(FloatLiteral n) {
        emit(n.toString());
    }

    @Override
    public void visit(FloatType n) {
        emit(indent +"double ");
    }

    @Override
    public void visit(Function n) {
        n.a1.accept(this);
        n.a2.accept(this);
    }

    @Override
    public void visit(GreaterThan n) {
        n.e1.accept(this);
        emit(" > ");
        n.e2.accept(this);
    }

    @Override
    public void visit(GreaterThanEqual n) {
        n.e1.accept(this);
        emit(" >= ");
        n.e2.accept(this);
    }

    @Override
    public void visit(Identifier n) {
        emit(n.s);
    }

    @Override
    public void visit(IntegerLiteral n) {
        emit(n.toString());
    }

    @Override
    public void visit(IntType n) {
        emit(indent +"int ");

    }

    @Override
    public void visit(LessThan n) {
        n.e1.accept(this);
        emit(" < ");
        n.e2.accept(this);
    }

    @Override
    public void visit(LessThanEqual n) {
        n.e1.accept(this);
        emit(" <= ");
        n.e2.accept(this);

    }

    @Override
    public void visit(MinusEqual n) {
        emit(" -= ");
    }

    @Override
    public void visit(MinusMinusUnaryExpression n) {
        emit("\n" +indent +"--");
        n.e.accept(this);
        emit(";");
    }

    @Override
    public void visit(NotEqualExpression n) {
        n.e1.accept(this);
        emit(" != ");
        n.e2.accept(this);
    }

    @Override
    public void visit(NotUnaryExpression n) {
        emit("!");
        n.e.accept(this);
    }

    @Override
    public void visit(PlusEqual n) {
        emit(" += ");
    }

    @Override
    public void visit(PlusExpression n) {
        n.e1.accept(this);
        emit(" + ");
        n.e2.accept(this);
    }

    @Override
    public void visit(PlusPlusUnaryExpression n) {
        emit("\n"+indent +"++");
        n.e.accept(this);
        emit(";");
    }

    @Override
    public void visit(PostfixExpressionMinusMinus n) {
        emit("\n" + indent);
        n.e.accept(this);
        emit("--;");
    }

    @Override
    public void visit(PostfixExpressionPlusPlus n) {
        emit("\n"+indent);
        n.e.accept(this);
        emit("++;");
    }

    @Override
    public void visit(ReturnStatementExpression n) {
        emit("\n"+ indent +"return ");
        n.e.accept(this);
        emit(";");
    }

    @Override
    public void visit(RobotType n) {
        omitEncode = true;
        StringBuilder hej = code.reverse();
        String ost;
        ost = hej.toString().replaceFirst("\n", "");
        StringBuilder st = new StringBuilder(ost);
        code = st.reverse();
    }

    @Override
    public void visit(ServoPrimitiveType n) {
        preEmit("Servo");
    }

    @Override
    public void visit(ServoType n) {
        omitEncode = true;

    }

    @Override
    public void visit(StatementBlock n) {
        n.s.accept(this);
    }

    @Override
    public void visit(StrLiteral n) {

    }

    @Override
    public void visit(Switch n) {
        emit("\n"+indent+"switch(");
        n.e.accept(this);
        emit(") {");
        increaseIndent();
        n.s.accept(this);
        decreaseIndent();
        emit("\n"+indent+"}");

    }

    @Override
    public void visit(SwitchBlockLabels n) {

        for ( int i = 0; i < n.s1.list.size(); i++ ) {
            n.s1.list.get(i).accept(this);
        }

        for ( int i = 0; i < n.s2.list.size(); i++ ) {
            n.s2.list.get(i).accept(this);
        }
    }

    @Override
    public void visit(SwitchGroups n) {
        for ( int i = 0; i < n.s.list.size(); i++ ) {
            n.s.list.get(i).accept(this);
        }
    }

    @Override
    public void visit(SwitchLabelBlock n) {
        for ( int i = 0; i < n.s.size(); i++ ) {
            if(n.s.list.get(i) instanceof DefaultCase){
                emit("\n"+indent+"default");
            }
            else {
                emit("\n"+indent+"case ");
            }
            n.s.list.get(i).accept(this);

                emit(":");

        }

        for ( int i = 0; i < n.bs.size(); i++ ) {
            emit("\n");
            if (i == 0){
                ignoreNewLine = true;
                noKeepIndent = false;
            }

            increaseIndent();
            n.bs.get(i).accept(this);
            decreaseIndent();
            ignoreNewLine = false;
            noKeepIndent = true;
        }
    }

    @Override
    public void visit(SwitchLabels n) {
        for ( int i = 0; i < n.s.size(); i++ ) {
            n.s.get(i).accept(this);
        }
    }

    @Override
    public void visit(TernaryExpression n) {
        n.e1.accept(this);
        emit(" ? ");
        n.e2.accept(this);
        emit(" : ");
        n.e3.accept(this);
    }

    @Override
    public void visit(UnaryExpression n) {
        n.e.accept(this);
    }

    @Override
    public void visit(IdentifierExpression n) {
        emit(n.s);
    }

    @Override
    public void visit(AndExpression n) {
        n.e1.accept(this);
        emit(" && ");
        n.e2.accept(this);
    }

    @Override
    public void visit(OrExpression n) {
        n.e1.accept(this);
        emit(" || ");
        n.e2.accept(this);
    }

    @Override
    public void visit(MinusExpression n) {
        n.e1.accept(this);
        emit(" - ");
        n.e2.accept(this);
    }

    @Override
    public void visit(ModuloExpression n) {
        n.e1.accept(this);
        emit(" % ");
        n.e2.accept(this);
    }

    @Override
    public void visit(DivisionExpression n) {
        n.e1.accept(this);
        emit(" / ");
        n.e2.accept(this);
    }

    @Override
    public void visit(MultiplicationExpression n) {
        n.e1.accept(this);
        emit(" * ");
        n.e2.accept(this);
    }

    @Override
    public void visit(ArrayAccessIndex n) {

        n.i.accept(this);
        emit("[");
        n.e.accept(this);
        emit("]");

    }

    @Override
    public void visit(ReturningFunctionCall n) {
        n.i.accept(this);
        emit("(");
        for ( int i = 0; i < n.al.size(); i++ ) {
            n.al.get(i).accept(this);
        }
        emit(")");
    }

    @Override
    public void visit(ForLoop n) {
        emit("\n"+indent+"for(");
        ignoreNewLine = true;
        n.fi.accept(this);
        emit("; ");
        n.e.accept(this);
        emit("; ");
        n.sel.accept(this);
        code.deleteCharAt(code.length()-1);
        emit(") ");
        ignoreNewLine = false;
    }

    @Override
    public void visit(WhileLoop n) {
        emit("\nwhile(");
        n.e.accept(this);
        emit(")");
    }

    @Override
    public void visit(IfElse n) {
        emit("\n"+indent+"if(");
        n.e.accept(this);
        emit(") ");
        //increaseIndent();
        n.s1.accept(this);
       // decreaseIndent();
        //reduceIndent();
        emit("\n"+indent+"else ");
        //increaseIndent();
        n.s2.accept(this);
       // decreaseIndent();
        //reduceIndent();
    }

    @Override
    public void visit(If n) {
        emit("\n"+indent+"if(");
        n.e.accept(this);
        emit(") ");
        //increaseIndent();
        n.s.accept(this);
        //decreaseIndent();
        //reduceIndent();
    }

    @Override
    public void visit(NonReturningFunctionCall n) {
        emit("\n");
         Symbol robot = parser.st.retrieveRobot(n.i.toString());
         if(robot instanceof ArrayVariable){
             emit(indent + "//");
             n.i.accept(this);
             emit("(");
             for (int i = 0; i < n.al.size(); i++) {
                 n.al.get(i).accept(this);
             }
             emit(");");
            ArrayVariable robotCast = (ArrayVariable) robot;
            ArrayList<String> servosInRobot = robotCast.getVariables();
            Symbol servo = parser.st.retrieveRobot(n.al.get(0).toString());
            if(servo instanceof ArrayVariable){
                ArrayVariable servoCast = (ArrayVariable) servo;
                int counter = 0;
                for(var v : servoCast.getVariables()){
                    emit("\n"+ indent + servosInRobot.get(counter) + ".write(" + v + ");");
                    counter++;
                }
                emit("\n");

            }
            else{
                ServoPositionVariable servoCast = (ServoPositionVariable) servo;
                    for (var v : servoCast.getVariables()){
                        emit("\n"+ indent + v.name  +  ".write(" + v.value + ");");
                    }
                emit("\n");
            }
         }
        else {
            emit(indent +"");
             n.i.accept(this);
             emit("(");
             for (int i = 0; i < n.al.size(); i++) {
                 n.al.get(i).accept(this);
             }
             emit(");");
         }
    }

    @Override
    public void visit(Break n) {
        emit(indent + "break;");
    }

    @Override
    public void visit(ConstantVariableDeclaration n) {
        emit("const ");
        n.t.accept(this);

        for ( int i = 0; i < n.vdl.size(); i++ ) {
            n.vdl.get(i).accept(this);
        }
    }

    @Override
    public void visit(VariableDeclaration n) {
        n.t.accept(this);

        for ( int i = 0; i < n.vdl.size(); i++ ) {
            if(i != 0){
                emit(", ");
            }

            if(n.t instanceof ServoPrimitiveType && n.vdl.get(i) instanceof VariableAssignmentDeclaration){

                preEmit(" "+((VariableAssignmentDeclaration) n.vdl.get(i)).i.toString() + ";\n");
                String servoNumber = ((VariableAssignmentDeclaration) n.vdl.get(i)).a.toString();
                emit(indent + ((VariableAssignmentDeclaration) n.vdl.get(i)).i.toString()+ ".attach("+
                        (servoNumber + ")"));
            }
            else {
                n.vdl.get(i).accept(this);
            }
        }

    }

    @Override
    public void visit(DefaultCase n) {

    }

    @Override
    public void visit(EmptySwitch n) {

    }

    @Override
    public void visit(LocalVariableDeclarationStatement n) {
        emit("\n");
        n.s.accept(this);
        emit(";");
    }

    @Override
    public void visit(Block n) {
        emit("{");
        increaseIndent();

        if(isSetupfunction){
            emit("\n" +indent +"int SOFT_START_CONTROL_PIN = 12;\n" + indent +
                    "int LOW_LIMIT_TIMEOUT = 2000;\n" + indent +
                    "int HIGH_LIMIT_TIMEOUT = 6000;\n" + indent +
                    "pinMode(SOFT_START_CONTROL_PIN,OUTPUT);\n" + indent +
                    "digitalWrite(SOFT_START_CONTROL_PIN,LOW);");
            isSetupfunction = false;
        }

        for ( int i = 0; i < n.sl.size(); i++ ) {
            n.sl.get(i).accept(this);
        }
        emit("\n} \n");
        decreaseIndent();
    }

    @Override
    public void visit(ServoPositionVariables n) {
        for ( int i = 0; i < n.vi.list.size(); i++ ) {
            n.vi.list.get(i).accept(this);
        }
    }

    @Override
    public void visit(EmptyArray n) {

    }

    @Override
    public void visit(ConstantFormalParameter n) {
        emit(indent + "const ");
        n.t.accept(this);
        n.i.accept(this);
    }

    @Override
    public void visit(FormalParameter n) {
        n.t.accept(this);
        n.i.accept(this);



    }

    @Override
    public void visit(VoidFunctionHeader n) {
        emit("\nvoid ");
        n.a.accept(this);
    }

    @Override
    public void visit(TypeFunctionHeader n) {
        emit("\n");
        n.t.accept(this);
        n.a.accept(this);
    }

    @Override
    public void visit(VariableAssignmentDeclaration n) {


        n.i.accept(this);
        if(n.a instanceof ArrayVariables){
            emit("[]");
        }

        emit(" = ");
        n.a.accept(this);

    }

    @Override
    public void visit(IdentifierVariable n) {
        emit(n.s);
    }

    @Override
    public void visit(ABlockStatement n) {
        emit("{");
        increaseIndent();
        for ( int i = 0; i < n.sl.size(); i++ ) {
            n.sl.get(i).accept(this);
        }
        decreaseIndent();
        emit("\n"+indent+"}");
    }

    @Override
    public void visit(FunctionDeclarator n) {
        emit(n.i + "(");
        if(n.i.equals("setup")){
            isSetupfunction = true;
        }

        for ( int i = 0; i < n.fplo.list.size(); i++ ) {
            n.fplo.list.get(i).accept(this);
        }
        emit(") ");
    }

    @Override
    public void visit(ArrayVariables n) {
        emit("{");
        for ( int i = 0; i < n.il.list.size(); i++ ) {
            if(i != 0){
                emit(", ");
            }
            n.il.list.get(i).accept(this);
        }
        emit("}");
    }

    @Override
    public void visit(Program program) {
        emit("#include <Servo.h> \n");
        program.sl.accept(this);
        System.out.println(code);
    }

    @Override
    public void visit(GlobalVariablePlusFunctionStatements globalVariablePlusFunctionStatements) {
        for ( int i = 0; i < globalVariablePlusFunctionStatements.v.size(); i++ ) {
            globalVariablePlusFunctionStatements.v.get(i).accept(this);
        }

        for ( int i = 0; i < globalVariablePlusFunctionStatements.sl.size(); i++ ) {
            globalVariablePlusFunctionStatements.sl.get(i).accept(this);
        }
    }

    @Override
    public void visit(FunctionList functionList) {
        for ( int i = 0; i < functionList.fsl.size(); i++ ) {
            functionList.fsl.get(i).accept(this);
        }
    }
}
