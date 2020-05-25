package AST.NonAbstract.Node;

import AST.Abstract.ASTNode;
import AST.Abstract.Initial;
import Interfaces.IVisitor;

 public class Program extends ASTNode {
    public Initial sl;

     public Program(Initial sl, int ln){
         super(ln);
         this.sl = sl;
     }

     public void accept(IVisitor v) {
         v.visit(this);
     }
}
