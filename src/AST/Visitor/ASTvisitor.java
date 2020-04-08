package AST.Visitor;


import AST.Abstract.ASTNode;
import AST.NonAbstract.Node.*;

public class ASTvisitor implements Visitor {

    private int Indent = 0;

    private void increaseIndent() { Indent += 2; }

    private void decreaseIndent() { Indent -= 2; }

    private void printNodeLine(String s) {
        String line = "";
        for (int i = 0; i < Indent; i++) { line += " "; }
        System.out.println(line + s);
    }

    private void printNode(ASTNode a) {
        printNodeLine(a.getClass().getSimpleName() + "'" + a.lineNumber);
    }

    private void printNodeWithValue(ASTNode a, String s) {
        printNodeLine(a.getClass().getSimpleName() + ":" + s + "'" + a.lineNumber);
    }


    @Override
    public void visit(Program n) {
        printNode(n);
        increaseIndent();

        n.s.accept(this);

        decreaseIndent();

    }

    @Override
    public void visit(ArgumentList n) {

        printNode(n);
        increaseIndent();

        n.aal.accept(this);

        decreaseIndent();

    }

    @Override
    public void visit(ArgumentListCommaExpression n) {
        printNode(n);
        increaseIndent();

        n.al.accept(this);
        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ArrayAccess n) {
        printNode(n);
        increaseIndent();

        n.aa.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ArrayAccessNoNewArray n) {
        printNode(n);
        increaseIndent();

        n.aa.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ArrayInit n) {
        printNode(n);
        increaseIndent();

        n.avi.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ArrayType n) {
        printNode(n);
        increaseIndent();

        n.aat.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ArrCreate n) {
        printNode(n);
        increaseIndent();

        n.aace.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(AssignmentExpr n) {
        printNode(n);
        increaseIndent();

        n.alhs.accept(this);
        n.aao.accept(this);
        n.aas.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(AssignmentExpression n) {
        printNode(n);
        increaseIndent();

        n.aae.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(AssignmentStmt n) {
        printNode(n);
        increaseIndent();

        n.aae.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(Beginings n) {
        printNode(n);
    }

    @Override
    public void visit(BlockStmt n) {
        printNode(n);
        increaseIndent();

        n.abs.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(BlockStmts n) {
        printNode(n);
        increaseIndent();

        n.abs.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(BlockStmtsOpt n) {
        printNode(n);
        increaseIndent();


        if(n.abso != null) {
            n.abso.accept(this);
        }
        decreaseIndent();
    }

    @Override
    public void visit(BlockStmtstmt n) {
        printNode(n);
        increaseIndent();

        n.abss.accept(this);
        n.abs.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(BoolLiteral n) {
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(BoolType n) {
        printNode(n);
    }

    @Override
    public void visit(BracketEnc n) {
        printNode(n);
        increaseIndent();

        n.abe.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(BracketEnclosureBrack n) {
        printNode(n);
        increaseIndent();

        n.abe.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(BracketEnclosureExpression n) {
        printNode(n);
        increaseIndent();

        n.bee.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(BracketEnclosureExprsExpr n) {
        printNode(n);
        increaseIndent();

        n.abee.accept(this);
        n.bee.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(BreakStatementWithoutSubstatement n) {
        printNode(n);
        increaseIndent();

        n.bs.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(BreakStmtExpr n) {
        printNode(n);
    }

    @Override
    public void visit(ComparableUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.aue.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ConditionalAndAndExpression n) {
        printNode(n);
        increaseIndent();

        n.acae.accept(this);
        n.aee.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ConditionalAndExpression n) {
        printNode(n);
        increaseIndent();

        n.acae.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ConditionalExpression n) {
        printNode(n);
        increaseIndent();

        n.ace.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ConditionalOrExpression n) {
        printNode(n);
        increaseIndent();

        n.acoe.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ConditionalOrExprOrOrConditionalAndExpr n) {
        printNode(n);
        increaseIndent();

        n.acoe.accept(this);
        n.acae.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ConstantExpression n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ConstExpr n) {
        printNode(n);
        increaseIndent();

        n.ce.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ConstTypeVariableDelcId n) {
        printNode(n);
        increaseIndent();

        n.at.accept(this);
        n.avdi.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(DEF n) {
        printNode(n);
    }

    @Override
    public void visit(EmptystmtWithoutSubstatement n) {
        printNode(n);
        increaseIndent();

        n.es.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(Equal n) {
        printNode(n);
    }

    @Override
    public void visit(EqualEqualExpression n) {
        printNode(n);
        increaseIndent();

        n.aee.accept(this);
        n.are.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(EqualExpression n) {
        printNode(n);
        increaseIndent();

        n.aee.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(expr n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(Expression n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ExpressionAssignment n) {
        printNode(n);
        increaseIndent();

        n.aae.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ExprStmtWithoutSubstatement n) {
        printNode(n);
        increaseIndent();

        n.es.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FloatLiteral n) {
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(FloatType n) {
        printNode(n);
    }

    @Override
    public void visit(ForExpr n) {
        printNode(n);
        increaseIndent();

        n.afi.accept(this);
        n.e.accept(this);
        n.asel.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FormalParam n) {
        printNode(n);
        increaseIndent();

        n.afp.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FormalParamList n) {
        printNode(n);
        increaseIndent();

        n.afpl.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FormalParamListFormalParam n) {
        printNode(n);
        increaseIndent();

        n.afpl.accept(this);
        n.afp.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ForStmtExpr n) {
        printNode(n);
        increaseIndent();

        n.fs.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FuncStmtOpt n) {
        printNode(n);
        increaseIndent();

        if(n.afso != null) {
            n.afso.accept(this);
        }
        decreaseIndent();
    }

    @Override
    public void visit(Function n) {
        printNode(n);
        increaseIndent();

        n.afs.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FunctionBlock n) {
        printNode(n);
        increaseIndent();

        n.b.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FunctionCallArray n) {
        printNode(n);
        increaseIndent();

        n.fc.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FunctionCallStatement n) {
        printNode(n);
        increaseIndent();

        n.fc.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FunctionDeclerator n) {
        printNode(n);
        increaseIndent();

        if(n.afpo != null) {
            n.afpo.accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(FunctionDecleratorBrack n) {
        printNode(n);
        increaseIndent();

        n.afd.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FunctionDeclStatement n) {
        printNode(n);
        increaseIndent();

        n.fd.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FunctionHeaderBody n) {
        printNode(n);
        increaseIndent();

        n.afh.accept(this);
        n.afb.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(FunctionStmtsFunctionDecl n) {
        printNode(n);
        increaseIndent();

        n.afs.accept(this);
        n.fd.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(GlobalVarfuncStmtOpt n) {
        printNode(n);
        increaseIndent();

        n.agv.accept(this);
        n.afso.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(GlobalVariablesStmt n) {
        printNode(n);
        increaseIndent();

        n.agv.accept(this);
        n.gv.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(GlobalVaribaleStmt n) {
        printNode(n);
        increaseIndent();

        n.gv.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(GreaterThan n) {
        printNode(n);
        increaseIndent();

        n.are.accept(this);
        n.ape.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(GreaterThanEqual n) {
        printNode(n);
        increaseIndent();

        n.are.accept(this);
        n.ape.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(Ident n) {
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(Identifier n) {
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(IfLparenExprRparen n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        n.as.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(IfLparenExprRparenStmtIfWithoutElseElseStmt n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        n.asiwe.accept(this);
        n.as.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(IfLparenExprRparenStmtWithoutElseElseStmtIfWithoutElse n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        n.asiwe.accept(this);
        n.asiwe1.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(IfThenElseIfWithoutElseStatement n) {
        printNode(n);
        increaseIndent();

        n.itewe.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(IfThenElseStmtExpr n) {
        printNode(n);
        increaseIndent();

        n.ilersiwees.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(IfThenStmtExpr n) {
        printNode(n);
        increaseIndent();

        n.its.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(IntegerLiteral n) {
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(IntType n) {
        printNode(n);
    }

    @Override
    public void visit(LBraceCommaRBrace n) {
        printNode(n);
    }

    @Override
    public void visit(LBRACERBRACE n) {
        printNode(n);
    }

    @Override
    public void visit(LbrackexprRbrack n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(LbrackRbrack n) {
        printNode(n);
    }

    @Override
    public void visit(LeftParenthesisExpressionRightParenthesis n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(LessThan n) {
        printNode(n);
        increaseIndent();

        n.are.accept(this);
        n.ape.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(LessThanEqual n) {
        printNode(n);
        increaseIndent();

        n.are.accept(this);
        n.ape.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(Literal n) {
        printNode(n);
        increaseIndent();

        n.li.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(localVariableDecl n) {
        printNode(n);
        increaseIndent();

        n.alvd.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(localVariableDeclBlockStmt n) {
        printNode(n);
        increaseIndent();

        n.lvdbs.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(LocalVariableDeclStatement n) {
        printNode(n);
        increaseIndent();

        n.alvd.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(localVariableDeclStmtGlobal n) {
        printNode(n);
        increaseIndent();

        n.lvdsg.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(MinusEqual n) {
        printNode(n);
    }

    @Override
    public void visit(MinusMinusUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.pe.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(MultipicationExpression n) {
        printNode(n);
        increaseIndent();

        n.ame.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(MultiplicationExpresionDivisionUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.pme.accept(this);
        n.aue.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(MultiplicationExpressionModuloUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.ame.accept(this);
        n.aue.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(MultiplicationExpressionMultiplicationUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.ame.accept(this);
        n.aue.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NameAssign n) {
        printNode(n);
        increaseIndent();

        n.n.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NameExpression n) {
        printNode(n);
        increaseIndent();

        n.n.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NameLeftBracketExpressionRightBracket n) {
        printNode(n);
        increaseIndent();

        n.n.accept(this);
        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NameLeftParenthesisArgumentListOptionalRightParenthesis n) {
        printNode(n);
        increaseIndent();

        if(n.aalo != null) {
            n.n.accept(this);
            n.aalo.accept(this);
        }
        decreaseIndent();
    }

    @Override
    public void visit(NameType n) {
        printNode(n);
        increaseIndent();

        n.n.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NameTypeBrackEnc n) {
        printNode(n);
        increaseIndent();

        n.n.accept(this);
        n.abe.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NoArrayLiteral n) {
        printNode(n);
        increaseIndent();

        n.al.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NotEqualExpression n) {
        printNode(n);
        increaseIndent();

        n.aee.accept(this);
        n.are.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NotUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.aue.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(NullLiteral n) {
        printNodeWithValue(n, n.toString());
    }

    @Override
    public void visit(NumericType n) {
        printNode(n);
        increaseIndent();

        n.ant.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PlusEqual n) {
        printNode(n);
    }

    @Override
    public void visit(PlusExpression n) {
        printNode(n);
        increaseIndent();

        n.ape.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PlusExpressionMinusMtiplicationExpression n) {
        printNode(n);
        increaseIndent();

        n.pe.accept(this);
        n.me.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PlusExpressionPlusMultiplicationExpression n) {
        printNode(n);
        increaseIndent();

        n.ape.accept(this);
        n.ame.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PlusPlusUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.aue.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PlusUnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.aue.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PostDecrementExpression n) {
        printNode(n);
        increaseIndent();

        n.pde.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PostdecrementExprStmt n) {
        printNode(n);
        increaseIndent();

        n.pode.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PostfixExpression n) {
        printNode(n);
        increaseIndent();

        n.ape.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PostfixExpressionMinusMinus n) {
        printNode(n);
        increaseIndent();

        n.apfe.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(postfixExpressionPlusPlus n) {
        printNode(n);
        increaseIndent();

        n.apfe.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PostIncrementExpression n) {
        printNode(n);
        increaseIndent();

        n.pie.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PostincrementExprStmt n) {
        printNode(n);
        increaseIndent();

        n.pe.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PredecrementExpression n) {
        printNode(n);
        increaseIndent();

        n.pde.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PreDecrementExprStmt n) {
        printNode(n);
        increaseIndent();

        n.pde.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PreIncrementExpression n) {
        printNode(n);
        increaseIndent();

        n.pie.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PreIncrementExprStmt n) {
        printNode(n);
        increaseIndent();

        n.pie.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(Primary n) {
        printNode(n);
        increaseIndent();

        n.ap.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PrimaryNoNewArr n) {
        printNode(n);
        increaseIndent();

        n.apnna.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PrimaryNoNewArrayLeftBracketExpressionRightBracket n) {
        printNode(n);
        increaseIndent();

        n.apnna.accept(this);
        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PrimitiveType n) {
        printNode(n);
        increaseIndent();

        n.apt.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PrimitiveTypeBracketEnclosureArrayInit n) {
        printNode(n);
        increaseIndent();

        n.apt.accept(this);
        n.abe.accept(this);
        n.aai.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(PrimitiveTypeBracketEnclosureExpressionsBracketEnclosureOptional n) {
        printNode(n);
        increaseIndent();


        n.apt.accept(this);
        n.abee.accept(this);
        if(n.abeo != null) {
            n.abeo.accept(this);
        }

        decreaseIndent();
    }

    @Override
    public void visit(PrimTypeBrackEnc n) {
        printNode(n);
        increaseIndent();

        n.apt.accept(this);
        n.abe.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ReferenceType n) {
        printNode(n);
        increaseIndent();

        n.art.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(RelationExpression n) {
        printNode(n);
        increaseIndent();

        n.are.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ReturnStatementWithoutSubstatement n) {
        printNode(n);
        increaseIndent();

        n.rs.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ReturnStmtExpr n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(RobotType n) {
        printNode(n);
    }

    @Override
    public void visit(Semicolon n) {
        printNode(n);
    }

    @Override
    public void visit(SemiColonFunction n) {
        printNode(n);
    }

    @Override
    public void visit(ServoInitLiteral n) {
        printNode(n);
        increaseIndent();

        n.si.accept(this);
        n.l.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ServoInitsStmt n) {
        printNode(n);
        increaseIndent();

        n.si.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ServoInitStmt n) {
        printNode(n);
        increaseIndent();

        n.si.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(ServoPrimitiveType n) {
        printNode(n);
    }

    @Override
    public void visit(ServoType n) {
        printNode(n);
    }

    @Override
    public void visit(StatementBlock n) {
        printNode(n);
        increaseIndent();

        n.b.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(StExpr n) {
        printNode(n);
        increaseIndent();

        n.se.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(stmt n) {
        printNode(n);
        increaseIndent();

        n.as.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(StmtExpr n) {
        printNode(n);
        increaseIndent();

        n.se.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(StmtExprList n) {
        printNode(n);
        increaseIndent();

        n.sel.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(StmtExprListStmtExpr n) {
        printNode(n);
        increaseIndent();

        n.sel.accept(this);
        n.se.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(StmtWithoutTrailingSubstatement n) {
        printNode(n);
        increaseIndent();

        n.swtss.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(StmtWithoutTrailingSubstmt n) {
        printNode(n);
        increaseIndent();

        n.aswts.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(StrLiteral n) {
        printNodeWithValue(n, n.s);
    }

    @Override
    public void visit(Switch n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);
        n.sb.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(SwitchBlockGroup n) {
        printNode(n);
        increaseIndent();

        n.sbsg.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(SwitchBlockLabels n) {
        printNode(n);
        increaseIndent();

        n.sbsgs.accept(this);
        n.sl.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(switchBlockSwitchBlock n) {
        printNode(n);
        increaseIndent();

        n.sbsgs.accept(this);
        n.sbsg.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(SwitchGroups n) {
        printNode(n);
        increaseIndent();

        n.sbsgs.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(SwitchLabel n) {
        printNode(n);
        increaseIndent();

        n.sl.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(SwitchLabelBlock n) {
        printNode(n);
        increaseIndent();

        n.sls.accept(this);
        n.bls.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(SwitchLabels n) {
        printNode(n);
        increaseIndent();

        n.sls.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(SwitchLabelsLabel n) {
        printNode(n);
        increaseIndent();

        n.sls.accept(this);
        n.sl.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(SwitchStmtWithoutSubstatement n) {
        printNode(n);
        increaseIndent();

        n.ss.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(TernaryExpression n) {
        printNode(n);
        increaseIndent();

        n.coe.accept(this);
        n.e.accept(this);
        n.ce.accept(this);
        decreaseIndent();
    }

    @Override
    public void visit(TypeFunctionDeclerator n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        n.fd.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(TypeVariableDecls n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        n.vds.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(TypeVariableDelcId n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        n.vdi.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(UnaryExpressionNotPlusMinus n) {
        printNode(n);
        increaseIndent();

        n.uenpm.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(UnaryExpression n) {
        printNode(n);
        increaseIndent();

        n.ue.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(UnaryExpressionstmt n) {
        printNode(n);
        increaseIndent();

        n.ue.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(variableDecIDBrackBrack n) {
        printNode(n);
        increaseIndent();

        n.vdi.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(VariableDecl n) {
        printNode(n);
        increaseIndent();

        n.vd.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(VariableDeclId n) {
        printNode(n);
        increaseIndent();

        n.vdi.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(VariableDeclIdVariableInit n) {
        printNode(n);
        increaseIndent();

        n.vdi.accept(this);
        n.vi.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(VariableDecls n) {
        printNode(n);
        increaseIndent();

        n.t.accept(this);
        n.vds.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(variableDeclsVariableDecl n) {
        printNode(n);
        increaseIndent();

        n.vds.accept(this);
        n.vd.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(VariableInit n) {
        printNode(n);
        increaseIndent();

        n.vi.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(VariableInitsBracks n) {
        printNode(n);
        increaseIndent();

        n.vi.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(VariableInitsComma n) {
        printNode(n);
        increaseIndent();

        n.vi.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(VariableInitsInit n) {
        printNode(n);
        increaseIndent();

        n.vis.accept(this);
        n.vi.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(voidFunctionDeclerator n) {
        printNode(n);
        increaseIndent();

        n.fd.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(WhileExpr n) {
        printNode(n);
        increaseIndent();

        n.e.accept(this);

        decreaseIndent();
    }

    @Override
    public void visit(WhileStmtExpr n) {
        printNode(n);
        increaseIndent();

        n.st.accept(this);

        decreaseIndent();
    }
}
