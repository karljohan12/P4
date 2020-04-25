package AST.NonAbstract.Node;

import AST.Abstract.AFunction;
import AST.Abstract.Statement;
import AST.List.FormalParameterList;
import AST.Visitor.Visitor;

public class FunctionDeclarator extends AFunction {
    public FormalParameterList fplo;
    public String i;

    public FunctionDeclarator(String i, FormalParameterList fplo, int ln) {
        super(ln);
        this.fplo = fplo;
        this.i = i;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
