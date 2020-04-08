package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class FunctionDeclStatement extends AbstractFunctionStmts {
    public FunctionHeaderBody fd;

    public FunctionDeclStatement(FunctionHeaderBody fd1, int ln){
        super(ln);
        fd = fd1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
