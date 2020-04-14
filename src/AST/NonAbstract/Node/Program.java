package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.Initial;
import AST.List.FunctionStatementList;
import AST.Visitor.Visitor;

 public class Program extends ASTNode {
    public Initial sl;

     public Program(Initial sl, int ln){
         super(ln);
         this.sl = sl;
     }

     public void accept(Visitor v) {
         v.visit(this);
     }
}
