package AST.NonAbstract.Node;

import AST.Abstract.AbstractGlobalVariables;
import AST.Visitor.Visitor;

public class GlobalVaribaleStmt extends AbstractGlobalVariables {
    public localVariableDeclStmtGlobal gv;

    public GlobalVaribaleStmt(localVariableDeclStmtGlobal gv1, int ln){
        super(ln);
        gv = gv1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
