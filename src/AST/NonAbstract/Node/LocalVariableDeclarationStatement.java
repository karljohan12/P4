package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import AST.Visitor.Visitor;

public class LocalVariableDeclarationStatement extends Statement {
    public Statement s;

    public LocalVariableDeclarationStatement(Statement s, int ln){
        super(ln);
        this.s = s;

    }

    public void accept(Visitor v) {
        v.visit(this);
    }


}
