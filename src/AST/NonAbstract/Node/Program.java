package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.AbstractStart;
import AST.Visitor.Visitor;

public class Program extends ASTNode {
    public AbstractStart s;

    public Program(AbstractStart as, int ln){
        super(ln);
        s = as;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
