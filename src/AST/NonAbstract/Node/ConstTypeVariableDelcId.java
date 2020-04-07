package AST.NonAbstract.Node;

import AST.Abstract.AbstractFormalParam;
import AST.Abstract.AbstractType;
import AST.Abstract.AbstractVariableDeclId;
import AST.Visitor.Visitor;

public class ConstTypeVariableDelcId extends AbstractFormalParam {
    public AbstractType at;
    public AbstractVariableDeclId avdi;

    public ConstTypeVariableDelcId(AbstractType at, AbstractVariableDeclId avdi, int ln) {
        super(ln);
        this.at = at;
        this.avdi = avdi;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
