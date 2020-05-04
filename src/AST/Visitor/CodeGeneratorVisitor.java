package AST.Visitor;

import AST.List.ArrayVariables;
import AST.NonAbstract.Node.*;

public class CodeGeneratorVisitor implements Visitor {

    StringBuilder code = new StringBuilder();

    private void emit(String emit){
        code.append(emit);
    }
    private void reduce(){
    code.deleteCharAt(code.length()-1);
    }



    @Override
    public void visit(ArrayType n) {
        n.t.accept(this);

    }

    @Override
    public void visit(AssignmentExpression n) {
        emit("\n");
        n.e1.accept(this);
        n.e2.accept(this);
        emit(" = ");
        n.e3.accept(this);
        emit(";");
    }

    @Override
    public void visit(BoolLiteral n) {
        emit(n.toString());
    }

    @Override
    public void visit(BoolType n) {
        emit("bool ");
    }

    @Override
    public void visit(ConstantExpression n) {
        n.e.accept(this);
    }

    @Override
    public void visit(Equal n) {

    }

    @Override
    public void visit(EqualExpression n) {
        n.e1.accept(this);
        emit(" == ");
        n.e2.accept(this);
    }

    @Override
    public void visit(FloatLiteral n) {

    }

    @Override
    public void visit(FloatType n) {
        emit("double ");
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
        emit("int ");

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
        n.e2.accept(this);

    }

    @Override
    public void visit(MinusEqual n) {

    }

    @Override
    public void visit(MinusMinusUnaryExpression n) {
        n.e.accept(this);
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

    }

    @Override
    public void visit(PlusExpression n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    @Override
    public void visit(PlusPlusUnaryExpression n) {
        n.e.accept(this);
    }

    @Override
    public void visit(PostfixExpressionMinusMinus n) {
        n.e.accept(this);
    }

    @Override
    public void visit(PostfixExpressionPlusPlus n) {
        n.e.accept(this);
        emit("++");
    }

    @Override
    public void visit(ReturnStatementExpression n) {
        n.e.accept(this);
    }

    @Override
    public void visit(RobotType n) {

    }

    @Override
    public void visit(ServoPrimitiveType n) {

    }

    @Override
    public void visit(ServoType n) {

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
        emit("\nswitch(");
        n.e.accept(this);
        emit("){");
        n.s.accept(this);
        emit("\n}");
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
                emit("\ndefault");
            }
            else {
                emit("\ncase ");
            }
            n.s.list.get(i).accept(this);
            emit(":\n");
        }

        for ( int i = 0; i < n.bs.size(); i++ ) {
            n.bs.get(i).accept(this);
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
        n.e2.accept(this);
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
        n.e2.accept(this);
    }

    @Override
    public void visit(OrExpression n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    @Override
    public void visit(MinusExpression n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    @Override
    public void visit(ModuloExpression n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    @Override
    public void visit(DivisionExpression n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    @Override
    public void visit(MultiplicationExpression n) {
        n.e1.accept(this);
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

        for ( int i = 0; i < n.al.size(); i++ ) {
            n.al.get(i).accept(this);
        }
    }

    @Override
    public void visit(ForLoop n) {
        emit("\nfor(");
        n.fi.accept(this);
        emit("; ");
        n.e.accept(this);
        emit("; ");
        n.sel.accept(this);
        emit(")");

    }

    @Override
    public void visit(WhileLoop n) {
        emit("\nwhile(");
        n.e.accept(this);
        emit(")");
    }

    @Override
    public void visit(IfElse n) {
        emit("\nif(");
        n.e.accept(this);
        emit(")");
        n.s1.accept(this);
        emit("\nelse");
        n.s2.accept(this);
    }

    @Override
    public void visit(If n) {
        emit("\nif(");
        n.e.accept(this);
        emit(")");
        n.s.accept(this);
    }

    @Override
    public void visit(NonReturningFunctionCall n) {
        n.i.accept(this);

        for ( int i = 0; i < n.al.size(); i++ ) {
            n.al.get(i).accept(this);
        }
    }

    @Override
    public void visit(Break n) {
        emit("break;");
    }

    @Override
    public void visit(ConstantVariableDeclaration n) {
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
            n.vdl.get(i).accept(this);
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

        for ( int i = 0; i < n.sl.size(); i++ ) {
            n.sl.get(i).accept(this);
        }
        emit("\n} \n");
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
        emit("void ");
        n.a.accept(this);
    }

    @Override
    public void visit(TypeFunctionHeader n) {
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
        for ( int i = 0; i < n.sl.size(); i++ ) {
            n.sl.get(i).accept(this);
        }
        emit("\n}");
    }

    @Override
    public void visit(FunctionDeclarator n) {
        emit(n.i + "(");

        for ( int i = 0; i < n.fplo.list.size(); i++ ) {
            n.fplo.list.get(i).accept(this);
        }
        emit(")");
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
