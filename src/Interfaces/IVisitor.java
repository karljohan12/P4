package Interfaces;

import AST.List.*;
import AST.NonAbstract.Node.*;

public interface IVisitor {

    public void visit(ArrayType n);

    public void visit(AssignmentExpression n);

    public void visit(BoolLiteral n);

    public void visit(BoolType n);

    public void visit(ConstantExpression n);

    public void visit(Equal n);

    public void visit(EqualExpression n);

    public void visit(FloatLiteral n);

    public void visit(FloatType n);

    public void visit(Function n);

    public void visit(GreaterThan n);

    public void visit(GreaterThanEqual n);

    public void visit(Identifier n);

    public void visit(IntegerLiteral n);

    public void visit(IntType n);

    public void visit(LessThan n);

    public void visit(LessThanEqual n);

    public void visit(MinusEqual n);

    public void visit(MinusMinusUnaryExpression n);

    public void visit(NotEqualExpression n);

    public void visit(NotUnaryExpression n);

    public void visit(PlusEqual n);

    public void visit(PlusExpression n);

    public void visit(PlusPlusUnaryExpression n);

    public void visit(PostfixExpressionMinusMinus n);

    public void visit(PostfixExpressionPlusPlus n);

    public void visit(ReturnStatementExpression n);

    public void visit(RobotType n);

    public void visit(ServoPrimitiveType n);

    public void visit(ServoType n);

    public void visit(StatementBlock n);

    public void visit(StrLiteral n);

    public void visit(Switch n);

    public void visit(SwitchBlockLabels n);

    public void visit(SwitchGroups n);

    public void visit(SwitchLabelBlock n);

    public void visit(SwitchLabels n);

    public void visit(TernaryExpression n);

    public void visit(UnaryExpression n);

    public void visit(IdentifierExpression n);

    public void visit(AndExpression n);

    public void visit(OrExpression n);

    public void visit(MinusExpression n);

    public void visit(ModuloExpression n);

    public void visit(DivisionExpression n);

    public void visit(MultiplicationExpression n);

    public void visit(ArrayAccessIndex n);

    public void visit(ReturningFunctionCall n);

    public void visit(ForLoop n);

    public void visit(WhileLoop n);

    public void visit(IfElse n);

    public void visit(If n);

    public void visit(NonReturningFunctionCall n);

    public void visit(Break n);

    public void visit(ConstantVariableDeclaration n);

    public void visit(VariableDeclaration n);

    public void visit(DefaultCase n);

    public void visit(EmptySwitch n);

    public void visit(LocalVariableDeclarationStatement n);

    public void visit(Block n);

    public void visit(ServoPositionVariables n);

    public void visit(EmptyArray n);

    public void visit(ConstantFormalParameter n);

    public void visit(FormalParameter n);

    public void visit(VoidFunctionHeader n);

    public void visit(TypeFunctionHeader n);

    public void visit(VariableAssignmentDeclaration n);

    public void visit(IdentifierVariable n);

    public void visit(ABlockStatement n);

    public void visit(FunctionDeclarator n);

    public void visit(ArrayVariables n);

    public void visit(Program program);

    public void visit(GlobalVariablePlusFunctionStatements globalVariablePlusFunctionStatements);

    void visit(FunctionList functionList);

    void visit(StringType n);
}
