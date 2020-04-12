package AST.List;

public class ArgumentList extends ASTNode {
    private List<Expression> list;

    public ArguemntList(int ln) {
        super(ln);
        list = new ArrayList<Formal>();
    }

    public void add(Expression e) { list.add(e); }

    public Expression get(int i) { return list.get(i); }

    public int size() { return list.size(); }
}
