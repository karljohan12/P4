package AST.NonAbstract.Node;
import AST.Abstract.*;

public class localVariableDeclStmtGlobal extends GlobalVariable {
    public localVariableDeclStmtGlobal lvdsg;

    public localVariableDeclStmtGlobal(localVariableDeclStmtGlobal lvdsg1, int ln){
        super(ln);
        lvdsg = lvdsg1;
    }



    public void accept(Visitor v) {
        v.visit(this);
    }
}
