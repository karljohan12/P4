package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import Interfaces.IVisitor;

public class LocalVariableDeclarationStatement extends Statement {
    public Statement s;

    public LocalVariableDeclarationStatement(Statement s, int ln){
        super(ln);
        this.s = s;

    }

    public void accept(IVisitor v) {
        v.visit(this);
    }


}
