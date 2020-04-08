package AST.NonAbstract.Node;

import AST.Abstract.AbstractFunctionBody;
import AST.Visitor.Visitor;

public class SemiColonFunction extends AbstractFunctionBody {


    public SemiColonFunction(int ln) {
        super(ln);

    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
