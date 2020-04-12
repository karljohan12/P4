package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Visitor.Visitor;

public class Identifier extends ASTNode {
    public String s;

    public Identifier(String s, int ln){
        super(ln);
        this.s = s;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString() {
        return s;
    }
}
