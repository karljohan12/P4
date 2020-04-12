package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class StatementExpression extends ASTNode {

    public StatementExpression(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
