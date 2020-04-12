package AST.NonAbstract.Node;
import AST.Abstract.AbstractFunctionDeclerator;
import AST.Abstract.AbstractFunctionHeader;
import AST.Visitor.Visitor;

public class voidFunctionDeclerator extends AbstractFunctionHeader {
    public AbstractFunctionDeclerator fd;

    public voidFunctionDeclerator(AbstractFunctionDeclerator afd, int ln){
        super(ln);
        fd=afd;

    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
