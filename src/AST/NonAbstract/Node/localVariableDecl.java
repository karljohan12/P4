package AST.NonAbstract.Node;

import AST.Abstract.AbstractForInit;
import AST.Abstract.AbstractLocalVariableDecl;
import AST.Visitor.Visitor;

public class localVariableDecl extends AbstractForInit {
    public AbstractLocalVariableDecl alvd;

    public localVariableDecl(AbstractLocalVariableDecl alvd, int ln) {
        super(ln);
        this.alvd = alvd;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
