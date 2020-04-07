package AST.NonAbstract.Node;

import AST.Abstract.AbstractGlobalVariables;
import AST.NonAbstract.Nonterminal.GlobalVariable;
import AST.Visitor.Visitor;

public class GlobalVaribaleStmt extends AbstractGlobalVariables {
    public GlobalVariable gv;

    public GlobalVaribaleStmt(GlobalVariable gv1, int ln){
        super(ln);
        gv = gv1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
