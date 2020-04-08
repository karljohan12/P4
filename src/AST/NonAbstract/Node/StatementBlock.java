package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.Visitor.Visitor;

public class StatementBlock extends AbstractStmtWithoutTrailingSubstatement {
  public BlockStmtsOpt b;

  public StatementBlock(BlockStmtsOpt ab, int ln){
      super(ln);
      b = ab;


  }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
