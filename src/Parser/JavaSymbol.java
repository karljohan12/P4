package Parser;

public class JavaSymbol extends java_cup.runtime.Symbol {
  private int line;
  private int column;

  public JavaSymbol(int id, int l, int r) {
    super(id, l, r, (Object)null);
  }

  public JavaSymbol(int id, int l, int r, Object o) {
    super(id);
    super.left = l;
    super.right = r;
    super.value = o;
  }

  public int getLine() {
    return left;
  }

  public int getColumn() {
    return right;
  }

  public String toString() {
    return "line "
        + left
        + ", column "
        + right
        + ", sym: "
        + sym
        + (value == null ? "" : (", value: '" + value + "'"));
  }
}
