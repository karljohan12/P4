package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import AST.Abstract.Statement;
import AST.List.FormalParameterList;
import AST.Visitor.Visitor;

public class FunctionDeclarator extends AFunction {
    public FormalParameterList fplo;

    public FunctionDeclarator(FormalParameterList fplo, int ln) {
        super(ln);
        this.fplo = fplo;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
