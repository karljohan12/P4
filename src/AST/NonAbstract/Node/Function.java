package AST.NonAbstract.Node;
import AST.Abstract.*;

public class Function extends AbstractFunctionStmtsOpts {
    public AbstractFunctionStmts afs;

    public Function(AbstractFunctionStmts afs1, int ln){
        super(ln);
        afs = afs1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
