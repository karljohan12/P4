package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import Interfaces.IVisitor;

public class Break extends Statement {

    public Break(int ln){
        super(ln);

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }
}
