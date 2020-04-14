package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.List.FunctionStatementList;
import AST.Visitor.Visitor;

 public class Program extends ASTNode {
    public FunctionStatementList sl;

     public Program(FunctionStatementList sl, int ln){
         super(ln);
         this.sl = sl;
     }

     public void accept(Visitor v) {
         v.visit(this);
     }
}
