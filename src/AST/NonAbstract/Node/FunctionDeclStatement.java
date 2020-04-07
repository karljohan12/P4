package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.NonAbstract.Nonterminal.FunctionDecl;
import AST.Visitor.Visitor;

public class FunctionDeclStatement extends AbstractFunctionStmts {
    public FunctionDecl fd;

    public FunctionDeclStatement(FunctionDecl fd1, int ln){
        super(ln);
        fd = fd1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
