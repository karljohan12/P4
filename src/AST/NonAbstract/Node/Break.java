package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.Visitor.Visitor;

public class Break extends Statement {

    public Break(int ln){
        super(ln);

    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
