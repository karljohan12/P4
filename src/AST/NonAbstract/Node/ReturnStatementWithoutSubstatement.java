package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.NonAbstract.Nonterminal.ReturnStmt;
import AST.Visitor.Visitor;

public class ReturnStatementWithoutSubstatement extends AbstractStmtWithoutTrailingSubstatement {
    public ReturnStmt rs;

    public ReturnStatementWithoutSubstatement(ReturnStmt ars, int ln){
        super(ln);
        rs = ars;


    }





    public void accept(Visitor v) {
        v.visit(this);
    }
}
