package AST.List;

import AST.Abstract.ASTNode;
import AST.Abstract.Statement;
import Interfaces.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class SwitchGroupList extends ASTNode {
    public List<Statement> list;

    public SwitchGroupList(int ln) {
        super(ln);
        list = new ArrayList<Statement>();
    }

    public void add(Statement e) {
        list.add(e);
    }

    public Statement get(int i) {
        return list.get(i);
    }

    public int size() {
        return list.size();
    }

    public void accept(IVisitor v) {
        v.visit(this);
    }


}
