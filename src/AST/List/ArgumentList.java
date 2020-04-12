package AST.List;

import AST.Abstract.ASTNode;
import AST.Abstract.Expression;

import java.util.ArrayList;
import java.util.List;

public class ArgumentList extends ASTNode {
    private List<Expression> list;

    public ArgumentList(int ln) {
        super(ln);
        list = new ArrayList<Expression>();
    }

    public void add(Expression e) { list.add(e); }

    public Expression get(int i) { return list.get(i); }

    public int size() { return list.size(); }
}
