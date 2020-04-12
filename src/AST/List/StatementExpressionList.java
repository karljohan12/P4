package AST.List;

public class StatementExpressionList extends ASTNode {
    private List<?> list;

    public FormalParamList(int ln) {
        super(ln);
        list = new ArrayList<?>();
    }

    public void add(? e) { list.add(e); }

    public ? get(int i) { return list.get(i); }

    public int size() { return list.size(); }{
}
