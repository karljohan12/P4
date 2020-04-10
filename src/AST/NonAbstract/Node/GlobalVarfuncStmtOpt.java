package AST.NonAbstract.Node;
import AST.Visitor.Visitor;

public class GlobalVarfuncStmtOpt extends AbstractStart {
    public AbstractGlobalVariables agv;
    public AbstractFunctionStmtsOpt afso;


    public GlobalVarfuncStmtOpt(AbstractGlobalVariables agv1, AbstractFunctionStmtsOpt afso1, int ln){
        super(ln);
        agv = agv1;
        afso = afso1;
    }


    public void accept(Visitor v) {
        v.visit(this);
    }
}
