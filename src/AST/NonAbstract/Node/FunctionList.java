package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.Initial;
import AST.List.FunctionStatementList;
import AST.Visitor.Visitor;

public class FunctionList extends Initial {
    public FunctionStatementList fsl;

    public FunctionList(FunctionStatementList fsl, int ln){
        super(ln);
        this.fsl = fsl;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }

}
