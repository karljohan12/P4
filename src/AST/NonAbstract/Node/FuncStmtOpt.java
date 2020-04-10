package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class FuncStmtOpt extends AbstractStart {
    public AbstractFunctionStmts afso;

    public FuncStmtOpt(AbstractFunctionStmts afso1, int ln){
        super(ln);
        afso = afso1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
