package AST.NonAbstract.Node;
import AST.Abstract.*;

public class GlobalVarfuncStmtOpt extends AbstractStart {
    public AbstractGlobalVariables agv;
    public AbstractFunctionStmtsOps afso;

    public GlobalVarfuncStmtOpt(AbstractGlobalVariables agv1, AbstractFunctionStmtsOps afso1, int ln){
        super(ln);
        agv = agv1;
        afso = afso1;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
