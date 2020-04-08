package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractArgumentListOpt extends ASTNode {
    public AbstractArgumentListOpt(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
