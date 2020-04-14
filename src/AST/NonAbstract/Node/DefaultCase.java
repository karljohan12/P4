package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.Visitor.Visitor;

public class DefaultCase extends Statement {

    public DefaultCase(int ln){
        super(ln);

    }
    public void accept(Visitor v) {
        v.visit(this);
    }


}
