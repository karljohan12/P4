package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class FunctionStatementsOptional extends ASTNode {

    public FunctionStatementsOptional(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
