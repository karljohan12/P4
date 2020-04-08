package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class GlobalVariablesStmt extends AbstractGlobalVariables {
    public AbstractGlobalVariables agv;
    public GlobalVariable gv;

    public GlobalVariablesStmt(AbstractGlobalVariables agv1, GlobalVariable gv1, int ln){
        super(ln);
        agv = agv1;
        gv = gv1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
