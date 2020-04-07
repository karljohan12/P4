package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractBracketEnclosureExprs extends ASTNode {
    public AbstractBracketEnclosureExprs(int ln) {
        super(ln);
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
