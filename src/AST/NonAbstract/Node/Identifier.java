package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.Expression;
import Interfaces.IVisitor;

public class Identifier extends ASTNode {
    public String s;

    public Identifier(String s, int ln){
        super(ln);
        this.s = s;
    }

    public Identifier(Expression e, int ln) {
        super(ln);
        this.s = s;
    }



    public void accept(IVisitor v) {
        v.visit(this);
    }

    public String toString() {
        return s;
    }




}
