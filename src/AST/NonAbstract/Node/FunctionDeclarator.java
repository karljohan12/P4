package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import AST.List.FormalParameterList;
import Interfaces.IVisitor;

public class FunctionDeclarator extends AFunction {
    public FormalParameterList fplo;
    public String i;

    public FunctionDeclarator(String i, FormalParameterList fplo, int ln) {
        super(ln);
        this.fplo = fplo;
        this.i = i;
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }
}
