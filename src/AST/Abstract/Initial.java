package AST.Abstract;

import Interfaces.IVisitor;

public abstract class Initial extends ASTNode {

    public Initial(int ln) {
        super(ln);
    };
    public abstract void accept(IVisitor v);
}
