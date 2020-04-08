package AST.Abstract;

import AST.Visitor.Visitor;

abstract public class AbstractBracketEnclosureOpt extends ASTNode {
    public AbstractBracketEnclosureOpt(int ln) {
        super(ln);
    }
    public abstract void accept(Visitor v);
}
