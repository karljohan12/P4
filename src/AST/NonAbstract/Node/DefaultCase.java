package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import Interfaces.IVisitor;

public class DefaultCase extends Statement {

    public DefaultCase(int ln){
        super(ln);

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }


}
