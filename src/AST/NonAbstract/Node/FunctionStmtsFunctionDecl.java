package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class FunctionStmtsFunctionDecl extends AbstractFunctionStmts {
    public AbstractFunctionStmts afs;
    public FunctionHeaderBody fd;

    public FunctionStmtsFunctionDecl(AbstractFunctionStmts afs1, FunctionHeaderBody fd1, int ln){
        super(ln);
        afs = afs1;
        fd = fd1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
