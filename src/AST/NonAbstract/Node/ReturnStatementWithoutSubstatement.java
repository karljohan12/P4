package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;

import AST.Visitor.Visitor;

public class ReturnStatementWithoutSubstatement extends AbstractStmtWithoutTrailingSubstatement {
    public ReturnStmtExpr rs;

    public ReturnStatementWithoutSubstatement(ReturnStmtExpr ars, int ln){
        super(ln);
        rs = ars;


    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
