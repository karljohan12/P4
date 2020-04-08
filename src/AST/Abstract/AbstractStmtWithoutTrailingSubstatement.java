package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractStmtWithoutTrailingSubstatement extends ASTNode {
    public AbstractStmtWithoutTrailingSubstatement(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);}
