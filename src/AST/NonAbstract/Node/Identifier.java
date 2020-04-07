package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Visitor.Visitor;

public class Identifier extends ASTNode {
    public Identifier i;

    public Identifier(Identifier i1, int ln){
        super(ln);
        i = i1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
