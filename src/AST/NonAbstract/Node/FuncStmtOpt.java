package AST.NonAbstract.Node;
import AST.Abstract.*;

public class FuncStmtOpt extends AbstractStart {
    public AbstractFunctionStmtsOps afso;

    public FuncStmtOpt(AbstractFunctionStmtsOps afso1, int ln){
        super(ln);
        afso = afso1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
