package AST.NonAbstract.Node;

import AST.Abstract.Initial;
import AST.List.FunctionStatementList;
import Interfaces.IVisitor;

public class FunctionList extends Initial {
    public FunctionStatementList fsl;

    public FunctionList(FunctionStatementList fsl, int ln){
        super(ln);
        this.fsl = fsl;

    }
    public void accept(IVisitor v) {
        v.visit(this);
    }

}
