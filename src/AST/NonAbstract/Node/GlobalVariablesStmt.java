package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class GlobalVariablesStmt extends AbstractGlobalVariables {
    public AbstractGlobalVariables agv;
    public localVariableDeclStmtGlobal gv;

    public GlobalVariablesStmt(AbstractGlobalVariables agv1, localVariableDeclStmtGlobal gv1, int ln){
        super(ln);
        agv = agv1;
        gv = gv1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
