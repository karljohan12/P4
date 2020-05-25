package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import Interfaces.IVisitor;

public class Equal extends Expression {

    public Equal(int ln){
        super(ln);

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
