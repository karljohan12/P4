package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class Expression extends AbstractArgumentList {
    public ExpressionAssignment e;

    public Expression(ExpressionAssignment e1, int ln){
        super(ln);
        e = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
