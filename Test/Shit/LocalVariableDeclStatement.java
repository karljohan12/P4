package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractLocalVariableDecl;
import AST.Visitor.Visitor;

public class LocalVariableDeclStatement extends ASTNode {
    public AbstractLocalVariableDecl alvd;

    public LocalVariableDeclStatement(AbstractLocalVariableDecl alvd, int ln) {
        super(ln);
        this.alvd = alvd;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
