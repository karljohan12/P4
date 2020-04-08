package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractBracketEnclosureExprs extends ASTNode {
    public AbstractBracketEnclosureExprs(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
