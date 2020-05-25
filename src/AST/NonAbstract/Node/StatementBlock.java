package AST.NonAbstract.Node;

import AST.Abstract.Statement;
import Interfaces.IVisitor;

public class StatementBlock extends Statement {
  public Statement s;

  public StatementBlock(Statement s, int ln){
      super(ln);
      this.s = s;
  }

    public void add(Statement e) {

    }

    public void accept(IVisitor v) {
        v.visit(this);
    }
}
