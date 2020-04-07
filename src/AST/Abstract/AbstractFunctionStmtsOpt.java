package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractFunctionStmtsOpt extends ASTNode {
    public AbstractFunctionStmtsOpt(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
