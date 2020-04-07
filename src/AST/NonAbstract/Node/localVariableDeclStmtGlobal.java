package AST.NonAbstract.Node;
import AST.Abstract.*;
import AST.Visitor.Visitor;

public class localVariableDeclStmtGlobal extends ASTNode {
    public localVariableDeclStmtGlobal lvdsg;

    public localVariableDeclStmtGlobal(localVariableDeclStmtGlobal lvdsg1, int ln){
        super(ln);
        lvdsg = lvdsg1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
