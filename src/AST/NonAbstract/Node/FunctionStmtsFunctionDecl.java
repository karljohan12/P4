package AST.NonAbstract.Node;
import AST.Abstract.*;

public class FunctionStmtsFunctionDecl extends AbstractFunctionStmts {
    public AbstractFunctionStmts afs;
    public FunctionDecl fd;

    public FunctionStmtsFunctionDecl(AbstractFunctionStmts afs1, FunctionDecl fd1, int ln){
        super(ln);
        afs = afs1;
        fd = fd1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
