package AST.Abstract;

import AST.Visitor.Visitor;

public abstract class Initial extends ASTNode {

    public Initial(int ln) {
        super(ln);
    };
    public abstract void accept(Visitor v);
}
