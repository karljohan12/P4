package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtIfWithoutElse;
import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.Visitor.Visitor;

public class StmtWithoutTrailingSubstatement extends AbstractStmtIfWithoutElse {
    public AbstractStmtWithoutTrailingSubstatement swtss;

    public StmtWithoutTrailingSubstatement(AbstractStmtWithoutTrailingSubstatement aswtss, int ln){
        super(ln);
        swtss = aswtss;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
