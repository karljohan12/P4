package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractStmt extends ASTNode {
    public AbstractStmt(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
