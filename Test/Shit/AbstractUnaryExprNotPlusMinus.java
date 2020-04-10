package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractUnaryExprNotPlusMinus extends ASTNode {
    public AbstractUnaryExprNotPlusMinus(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);

}
