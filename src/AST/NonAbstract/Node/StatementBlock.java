package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.Statement;
import AST.Visitor.Visitor;

public class StatementBlock extends Statement {
  public Statement s;

  public StatementBlock(Statement s, int ln){
      super(ln);
      this.s = s;
  }

    public void add(Statement e) {

    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
