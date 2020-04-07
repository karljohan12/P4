package AST.NonAbstract.Node;

import AST.Abstract.AbstractStmtWithoutTrailingSubstatement;
import AST.NonAbstract.Nonterminal.Block;
import AST.Visitor.Visitor;

public class StatementBlock extends AbstractStmtWithoutTrailingSubstatement {
  public Block b;

  public StatementBlock(Block ab, int ln){
      super(ln);
      b = ab;


  }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
