package AST.NonAbstract.Node;

import AST.Abstract.Expression;
import AST.Visitor.Visitor;

public class Equal extends Expression {

    public Equal(int ln){
        super(ln);

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
