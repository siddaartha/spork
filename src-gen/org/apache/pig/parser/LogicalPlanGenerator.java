// $ANTLR 3.4 /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g 2014-11-19 11:26:43

package org.apache.pig.parser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.impl.PigContext;
import org.apache.pig.impl.builtin.GFAny;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.streaming.StreamingCommand;
import org.apache.pig.impl.streaming.StreamingCommand.HandleSpec;
import org.apache.pig.impl.util.MultiMap;
import org.apache.pig.impl.util.NumValCarrier;
import org.apache.pig.impl.plan.PlanValidationException;
import org.apache.pig.newplan.Operator;
import org.apache.pig.newplan.logical.expression.AddExpression;
import org.apache.pig.newplan.logical.expression.AndExpression;
import org.apache.pig.newplan.logical.expression.BinCondExpression;
import org.apache.pig.newplan.logical.expression.CastExpression;
import org.apache.pig.newplan.logical.expression.ConstantExpression;
import org.apache.pig.newplan.logical.expression.DereferenceExpression;
import org.apache.pig.newplan.logical.expression.DivideExpression;
import org.apache.pig.newplan.logical.expression.EqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanEqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanExpression;
import org.apache.pig.newplan.logical.expression.IsNullExpression;
import org.apache.pig.newplan.logical.expression.LessThanEqualExpression;
import org.apache.pig.newplan.logical.expression.LessThanExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpressionPlan;
import org.apache.pig.newplan.logical.expression.MapLookupExpression;
import org.apache.pig.newplan.logical.expression.ModExpression;
import org.apache.pig.newplan.logical.expression.MultiplyExpression;
import org.apache.pig.newplan.logical.expression.NegativeExpression;
import org.apache.pig.newplan.logical.expression.NotEqualExpression;
import org.apache.pig.newplan.logical.expression.NotExpression;
import org.apache.pig.newplan.logical.expression.OrExpression;
import org.apache.pig.newplan.logical.expression.ProjectExpression;
import org.apache.pig.newplan.logical.expression.RegexExpression;
import org.apache.pig.newplan.logical.expression.ScalarExpression;
import org.apache.pig.newplan.logical.expression.SubtractExpression;
import org.apache.pig.newplan.logical.expression.UserFuncExpression;
import org.apache.pig.newplan.logical.relational.LOCache;
import org.apache.pig.newplan.logical.relational.LOCogroup;
import org.apache.pig.newplan.logical.relational.LOCube;
import org.apache.pig.newplan.logical.relational.LOFilter;
import org.apache.pig.newplan.logical.relational.LOForEach;
import org.apache.pig.newplan.logical.relational.LOGenerate;
import org.apache.pig.newplan.logical.relational.LOLimit;
import org.apache.pig.newplan.logical.relational.LOJoin;
import org.apache.pig.newplan.logical.relational.LOSort;
import org.apache.pig.newplan.logical.relational.LORank;
import org.apache.pig.newplan.logical.relational.LOSplitOutput;
import org.apache.pig.newplan.logical.relational.LogicalPlan;
import org.apache.pig.newplan.logical.relational.LogicalRelationalOperator;
import org.apache.pig.newplan.logical.relational.LogicalSchema;
import org.apache.pig.newplan.logical.relational.LogicalSchema.LogicalFieldSchema;
import org.apache.pig.newplan.logical.relational.LOCogroup.GROUPTYPE;
import org.apache.pig.newplan.logical.relational.LOJoin.JOINTYPE;
import org.apache.pig.FuncSpec;
import org.apache.pig.builtin.PigStreaming;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import java.util.Arrays;
import java.math.BigInteger;
import java.math.BigDecimal;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (for schema alias validation).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class LogicalPlanGenerator extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AMPERSAND", "AND", "ARROBA", "AS", "ASC", "BAG", "BIGDECIMAL", "BIGDECIMALNUMBER", "BIGINTEGER", "BIGINTEGERNUMBER", "BOOLEAN", "BY", "BYTEARRAY", "CACHE", "CASE", "CHARARRAY", "COGROUP", "COLON", "COMMA", "CROSS", "CUBE", "DATETIME", "DCOLON", "DEFINE", "DENSE", "DESC", "DIGIT", "DISTINCT", "DIV", "DOLLAR", "DOLLARVAR", "DOUBLE", "DOUBLENUMBER", "DOUBLE_PERIOD", "ELSE", "END", "EQUAL", "EXECCOMMAND", "FALSE", "FAT_ARROW", "FILTER", "FLATTEN", "FLOAT", "FLOATINGPOINT", "FLOATNUMBER", "FOREACH", "FULL", "GENERATE", "GROUP", "ID", "IDENTIFIER", "IF", "IMPORT", "IN", "INNER", "INPUT", "INT", "INTEGER", "INTO", "INVOKE", "IS", "JOIN", "LEFT", "LEFT_BRACKET", "LEFT_CURLY", "LEFT_PAREN", "LETTER", "LIMIT", "LOAD", "LONG", "LONGINTEGER", "MAP", "MAPREDUCE", "MINUS", "ML_COMMENT", "MULTILINE_QUOTEDSTRING", "NOT", "NULL", "NUM_OP_EQ", "NUM_OP_GT", "NUM_OP_GTE", "NUM_OP_LT", "NUM_OP_LTE", "NUM_OP_NE", "ONSCHEMA", "OR", "ORDER", "OTHERWISE", "OUTER", "OUTPUT", "PARALLEL", "PARTITION", "PERCENT", "PERIOD", "PLUS", "POUND", "QMARK", "QUOTEDSTRING", "RANK", "RETURNS", "RIGHT", "RIGHT_BRACKET", "RIGHT_CURLY", "RIGHT_PAREN", "ROLLUP", "SAMPLE", "SEMI_COLON", "SHIP", "SL_COMMENT", "SPECIALCHAR", "SPLIT", "STAR", "STDERROR", "STDIN", "STDOUT", "STORE", "STREAM", "STR_OP_EQ", "STR_OP_GT", "STR_OP_GTE", "STR_OP_LT", "STR_OP_LTE", "STR_OP_MATCHES", "STR_OP_NE", "THEN", "THROUGH", "TRUE", "TUPLE", "UNION", "USING", "VOID", "WHEN", "WS", "ANY", "BAG_TYPE", "BAG_TYPE_CAST", "BAG_VAL", "BIN_EXPR", "BOOL", "BOOL_COND", "CASE_COND", "CASE_EXPR", "CAST_EXPR", "COL_RANGE", "EXPR_IN_PAREN", "FIELD_DEF", "FIELD_DEF_WITHOUT_IDENTIFIER", "FOREACH_PLAN_COMPLEX", "FOREACH_PLAN_SIMPLE", "FUNC", "FUNC_EVAL", "FUNC_REF", "INVOKER_FUNC_EVAL", "JOIN_ITEM", "KEY_VAL_PAIR", "MACRO_BODY", "MACRO_DEF", "MACRO_INLINE", "MAP_TYPE", "MAP_VAL", "NEG", "NESTED_CMD", "NESTED_CMD_ASSI", "NESTED_PROJ", "PARAMS", "QUERY", "REALIAS", "RETURN_VAL", "SPLIT_BRANCH", "STATEMENT", "TOBAG", "TOMAP", "TOTUPLE", "TUPLE_TYPE", "TUPLE_TYPE_CAST", "TUPLE_VAL", "EVAL", "MATCHES"
    };

    public static final int EOF=-1;
    public static final int ALL=4;
    public static final int AMPERSAND=5;
    public static final int AND=6;
    public static final int ARROBA=7;
    public static final int AS=8;
    public static final int ASC=9;
    public static final int BAG=10;
    public static final int BIGDECIMAL=11;
    public static final int BIGDECIMALNUMBER=12;
    public static final int BIGINTEGER=13;
    public static final int BIGINTEGERNUMBER=14;
    public static final int BOOLEAN=15;
    public static final int BY=16;
    public static final int BYTEARRAY=17;
    public static final int CACHE=18;
    public static final int CASE=19;
    public static final int CHARARRAY=20;
    public static final int COGROUP=21;
    public static final int COLON=22;
    public static final int COMMA=23;
    public static final int CROSS=24;
    public static final int CUBE=25;
    public static final int DATETIME=26;
    public static final int DCOLON=27;
    public static final int DEFINE=28;
    public static final int DENSE=29;
    public static final int DESC=30;
    public static final int DIGIT=31;
    public static final int DISTINCT=32;
    public static final int DIV=33;
    public static final int DOLLAR=34;
    public static final int DOLLARVAR=35;
    public static final int DOUBLE=36;
    public static final int DOUBLENUMBER=37;
    public static final int DOUBLE_PERIOD=38;
    public static final int ELSE=39;
    public static final int END=40;
    public static final int EQUAL=41;
    public static final int EXECCOMMAND=42;
    public static final int FALSE=43;
    public static final int FAT_ARROW=44;
    public static final int FILTER=45;
    public static final int FLATTEN=46;
    public static final int FLOAT=47;
    public static final int FLOATINGPOINT=48;
    public static final int FLOATNUMBER=49;
    public static final int FOREACH=50;
    public static final int FULL=51;
    public static final int GENERATE=52;
    public static final int GROUP=53;
    public static final int ID=54;
    public static final int IDENTIFIER=55;
    public static final int IF=56;
    public static final int IMPORT=57;
    public static final int IN=58;
    public static final int INNER=59;
    public static final int INPUT=60;
    public static final int INT=61;
    public static final int INTEGER=62;
    public static final int INTO=63;
    public static final int INVOKE=64;
    public static final int IS=65;
    public static final int JOIN=66;
    public static final int LEFT=67;
    public static final int LEFT_BRACKET=68;
    public static final int LEFT_CURLY=69;
    public static final int LEFT_PAREN=70;
    public static final int LETTER=71;
    public static final int LIMIT=72;
    public static final int LOAD=73;
    public static final int LONG=74;
    public static final int LONGINTEGER=75;
    public static final int MAP=76;
    public static final int MAPREDUCE=77;
    public static final int MINUS=78;
    public static final int ML_COMMENT=79;
    public static final int MULTILINE_QUOTEDSTRING=80;
    public static final int NOT=81;
    public static final int NULL=82;
    public static final int NUM_OP_EQ=83;
    public static final int NUM_OP_GT=84;
    public static final int NUM_OP_GTE=85;
    public static final int NUM_OP_LT=86;
    public static final int NUM_OP_LTE=87;
    public static final int NUM_OP_NE=88;
    public static final int ONSCHEMA=89;
    public static final int OR=90;
    public static final int ORDER=91;
    public static final int OTHERWISE=92;
    public static final int OUTER=93;
    public static final int OUTPUT=94;
    public static final int PARALLEL=95;
    public static final int PARTITION=96;
    public static final int PERCENT=97;
    public static final int PERIOD=98;
    public static final int PLUS=99;
    public static final int POUND=100;
    public static final int QMARK=101;
    public static final int QUOTEDSTRING=102;
    public static final int RANK=103;
    public static final int RETURNS=104;
    public static final int RIGHT=105;
    public static final int RIGHT_BRACKET=106;
    public static final int RIGHT_CURLY=107;
    public static final int RIGHT_PAREN=108;
    public static final int ROLLUP=109;
    public static final int SAMPLE=110;
    public static final int SEMI_COLON=111;
    public static final int SHIP=112;
    public static final int SL_COMMENT=113;
    public static final int SPECIALCHAR=114;
    public static final int SPLIT=115;
    public static final int STAR=116;
    public static final int STDERROR=117;
    public static final int STDIN=118;
    public static final int STDOUT=119;
    public static final int STORE=120;
    public static final int STREAM=121;
    public static final int STR_OP_EQ=122;
    public static final int STR_OP_GT=123;
    public static final int STR_OP_GTE=124;
    public static final int STR_OP_LT=125;
    public static final int STR_OP_LTE=126;
    public static final int STR_OP_MATCHES=127;
    public static final int STR_OP_NE=128;
    public static final int THEN=129;
    public static final int THROUGH=130;
    public static final int TRUE=131;
    public static final int TUPLE=132;
    public static final int UNION=133;
    public static final int USING=134;
    public static final int VOID=135;
    public static final int WHEN=136;
    public static final int WS=137;
    public static final int ANY=138;
    public static final int BAG_TYPE=139;
    public static final int BAG_TYPE_CAST=140;
    public static final int BAG_VAL=141;
    public static final int BIN_EXPR=142;
    public static final int BOOL=143;
    public static final int BOOL_COND=144;
    public static final int CASE_COND=145;
    public static final int CASE_EXPR=146;
    public static final int CAST_EXPR=147;
    public static final int COL_RANGE=148;
    public static final int EXPR_IN_PAREN=149;
    public static final int FIELD_DEF=150;
    public static final int FIELD_DEF_WITHOUT_IDENTIFIER=151;
    public static final int FOREACH_PLAN_COMPLEX=152;
    public static final int FOREACH_PLAN_SIMPLE=153;
    public static final int FUNC=154;
    public static final int FUNC_EVAL=155;
    public static final int FUNC_REF=156;
    public static final int INVOKER_FUNC_EVAL=157;
    public static final int JOIN_ITEM=158;
    public static final int KEY_VAL_PAIR=159;
    public static final int MACRO_BODY=160;
    public static final int MACRO_DEF=161;
    public static final int MACRO_INLINE=162;
    public static final int MAP_TYPE=163;
    public static final int MAP_VAL=164;
    public static final int NEG=165;
    public static final int NESTED_CMD=166;
    public static final int NESTED_CMD_ASSI=167;
    public static final int NESTED_PROJ=168;
    public static final int PARAMS=169;
    public static final int QUERY=170;
    public static final int REALIAS=171;
    public static final int RETURN_VAL=172;
    public static final int SPLIT_BRANCH=173;
    public static final int STATEMENT=174;
    public static final int TOBAG=175;
    public static final int TOMAP=176;
    public static final int TOTUPLE=177;
    public static final int TUPLE_TYPE=178;
    public static final int TUPLE_TYPE_CAST=179;
    public static final int TUPLE_VAL=180;
    public static final int EVAL=181;
    public static final int MATCHES=182;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators

    protected static class GScope_scope {
        LogicalRelationalOperator currentOp;
    }
    protected Stack GScope_stack = new Stack();



    public LogicalPlanGenerator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public LogicalPlanGenerator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return LogicalPlanGenerator.tokenNames; }
    public String getGrammarFileName() { return "/home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g"; }


    private static Log log = LogFactory.getLog( LogicalPlanGenerator.class );

    private LogicalPlanBuilder builder = null;

    private boolean inForeachPlan = false;

    private boolean inNestedCommand = false;

    public LogicalPlan getLogicalPlan() {
        return builder.getPlan();
    }

    public Map<String, Operator> getOperators() {
        return builder.getOperators();
    }

    public String getLastRel() {
        return builder.getLastRel();
    }

    @Override
    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
    throws RecognitionException {
        throw new MismatchedTokenException( ttype, input );
    }

    @Override
    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
    throws RecognitionException {
        throw e;
    }

    public LogicalPlanGenerator(TreeNodeStream input, LogicalPlanBuilder builder) {
        this(input, new RecognizerSharedState());
        this.builder = builder;
    }

    public LogicalPlanGenerator(TreeNodeStream input, PigContext pigContext, String scope,
        Map<String, String> fileNameMap) {
        this( input );
        builder = new LogicalPlanBuilder( pigContext, scope, fileNameMap, input );
    }



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:1: query : ^( QUERY ( statement )* ) ;
    public final LogicalPlanGenerator.query_return query() throws RecognitionException {
        LogicalPlanGenerator.query_return retval = new LogicalPlanGenerator.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        LogicalPlanGenerator.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:7: ( ^( QUERY ( statement )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query87); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==CACHE||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query89);
                	    statement2=statement();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, statement2.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "query"


    protected static class statement_scope {
        String alias;
        Integer parallel;
        String inputAlias;
        int inputIndex;
    }
    protected Stack statement_stack = new Stack();


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:162:1: statement : ( general_statement | split_statement | realias_statement | rel_cache_statement );
    public final LogicalPlanGenerator.statement_return statement() throws RecognitionException {
        statement_stack.push(new statement_scope());
        LogicalPlanGenerator.statement_return retval = new LogicalPlanGenerator.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.general_statement_return general_statement3 =null;

        LogicalPlanGenerator.split_statement_return split_statement4 =null;

        LogicalPlanGenerator.realias_statement_return realias_statement5 =null;

        LogicalPlanGenerator.rel_cache_statement_return rel_cache_statement6 =null;




            ((statement_scope)statement_stack.peek()).inputIndex = 0;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:173:2: ( general_statement | split_statement | realias_statement | rel_cache_statement )
            int alt2=4;
            switch ( input.LA(1) ) {
            case STATEMENT:
                {
                alt2=1;
                }
                break;
            case SPLIT:
                {
                alt2=2;
                }
                break;
            case REALIAS:
                {
                alt2=3;
                }
                break;
            case CACHE:
                {
                alt2=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:173:4: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement111);
                    general_statement3=general_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, general_statement3.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:174:4: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement116);
                    split_statement4=split_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_statement4.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:175:4: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement121);
                    realias_statement5=realias_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, realias_statement5.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:176:4: rel_cache_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_cache_statement_in_statement126);
                    rel_cache_statement6=rel_cache_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_cache_statement6.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:179:1: split_statement : split_clause ;
    public final LogicalPlanGenerator.split_statement_return split_statement() throws RecognitionException {
        LogicalPlanGenerator.split_statement_return retval = new LogicalPlanGenerator.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.split_clause_return split_clause7 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:179:17: ( split_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:179:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement135);
            split_clause7=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause7.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_statement"


    public static class realias_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_statement"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:182:1: realias_statement : realias_clause ;
    public final LogicalPlanGenerator.realias_statement_return realias_statement() throws RecognitionException {
        LogicalPlanGenerator.realias_statement_return retval = new LogicalPlanGenerator.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.realias_clause_return realias_clause8 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:182:19: ( realias_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:182:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement144);
            realias_clause8=realias_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, realias_clause8.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_statement"


    public static class rel_cache_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_cache_statement"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:185:1: rel_cache_statement : rel_cache_clause ;
    public final LogicalPlanGenerator.rel_cache_statement_return rel_cache_statement() throws RecognitionException {
        LogicalPlanGenerator.rel_cache_statement_return retval = new LogicalPlanGenerator.rel_cache_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_cache_clause_return rel_cache_clause9 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:185:21: ( rel_cache_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:185:23: rel_cache_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_cache_clause_in_rel_cache_statement153);
            rel_cache_clause9=rel_cache_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel_cache_clause9.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_cache_statement"


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:188:1: general_statement : ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) ;
    public final LogicalPlanGenerator.general_statement_return general_statement() throws RecognitionException {
        LogicalPlanGenerator.general_statement_return retval = new LogicalPlanGenerator.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT10=null;
        LogicalPlanGenerator.op_clause_return oa =null;

        LogicalPlanGenerator.alias_return alias11 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause12 =null;


        CommonTree STATEMENT10_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:189:3: ( ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:189:3: ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT10=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement165); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT10_tree = (CommonTree)adaptor.dupNode(STATEMENT10);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT10_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:189:16: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:189:18: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement169);
                    alias11=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias11.getTree());


                    if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = (alias11!=null?alias11.name:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement180);
            oa=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, oa.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:189:79: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:189:79: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement182);
                    parallel_clause12=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause12.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  Operator op = builder.lookupOperator( (oa!=null?oa.alias:null) );
                  builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "general_statement"


    public static class realias_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:196:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final LogicalPlanGenerator.realias_clause_return realias_clause() throws RecognitionException {
        LogicalPlanGenerator.realias_clause_return retval = new LogicalPlanGenerator.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS13=null;
        CommonTree IDENTIFIER15=null;
        LogicalPlanGenerator.alias_return alias14 =null;


        CommonTree REALIAS13_tree=null;
        CommonTree IDENTIFIER15_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:197:3: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:197:3: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS13=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause199); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS13_tree = (CommonTree)adaptor.dupNode(REALIAS13);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS13_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause201);
            alias14=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias14.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER15=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER15_tree = (CommonTree)adaptor.dupNode(IDENTIFIER15);


            adaptor.addChild(root_1, IDENTIFIER15_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	    Operator op = builder.lookupOperator( (IDENTIFIER15!=null?IDENTIFIER15.getText():null) );
            	    if (op==null) {
            	        throw new UndefinedAliasException(input,
            	            new SourceLocation( (PigParserNode)IDENTIFIER15 ), (IDENTIFIER15!=null?IDENTIFIER15.getText():null));
            	    }
            	    builder.putOperator( (alias14!=null?alias14.name:null), (LogicalRelationalOperator)op );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_clause"


    public static class rel_cache_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_cache_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:208:1: rel_cache_clause : ^( CACHE IDENTIFIER ) ;
    public final LogicalPlanGenerator.rel_cache_clause_return rel_cache_clause() throws RecognitionException {
        LogicalPlanGenerator.rel_cache_clause_return retval = new LogicalPlanGenerator.rel_cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE16=null;
        CommonTree IDENTIFIER17=null;

        CommonTree CACHE16_tree=null;
        CommonTree IDENTIFIER17_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:209:3: ( ^( CACHE IDENTIFIER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:209:3: ^( CACHE IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE16=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_rel_cache_clause221); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE16_tree = (CommonTree)adaptor.dupNode(CACHE16);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE16_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER17=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rel_cache_clause223); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER17_tree = (CommonTree)adaptor.dupNode(IDENTIFIER17);


            adaptor.addChild(root_1, IDENTIFIER17_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    LOCache cacheOp = builder.createCacheOp();
                    String alias = builder.buildCacheOp(new SourceLocation( (PigParserNode) ((CommonTree)retval.start) ),
                        cacheOp, (IDENTIFIER17!=null?IDENTIFIER17.getText():null));
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_cache_clause"


    public static class parallel_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parallel_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:217:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final LogicalPlanGenerator.parallel_clause_return parallel_clause() throws RecognitionException {
        LogicalPlanGenerator.parallel_clause_return retval = new LogicalPlanGenerator.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL18=null;
        CommonTree INTEGER19=null;

        CommonTree PARALLEL18_tree=null;
        CommonTree INTEGER19_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:218:2: ( ^( PARALLEL INTEGER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:218:4: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL18=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause243); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL18_tree = (CommonTree)adaptor.dupNode(PARALLEL18);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL18_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER19=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause245); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER19_tree = (CommonTree)adaptor.dupNode(INTEGER19);


            adaptor.addChild(root_1, INTEGER19_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((statement_scope)statement_stack.peek()).parallel = Integer.parseInt( (INTEGER19!=null?INTEGER19.getText():null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parallel_clause"


    public static class alias_return extends TreeRuleReturnScope {
        public String name;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:1: alias returns [String name] : IDENTIFIER ;
    public final LogicalPlanGenerator.alias_return alias() throws RecognitionException {
        LogicalPlanGenerator.alias_return retval = new LogicalPlanGenerator.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER20=null;

        CommonTree IDENTIFIER20_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:27: ( IDENTIFIER )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:29: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER20=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias263); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER20_tree = (CommonTree)adaptor.dupNode(IDENTIFIER20);


            adaptor.addChild(root_0, IDENTIFIER20_tree);
            }


            if ( state.backtracking==0 ) { retval.name = (IDENTIFIER20!=null?IDENTIFIER20.getText():null); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias"


    public static class op_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:227:1: op_clause returns [String alias] : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause );
    public final LogicalPlanGenerator.op_clause_return op_clause() throws RecognitionException {
        LogicalPlanGenerator.op_clause_return retval = new LogicalPlanGenerator.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.define_clause_return define_clause21 =null;

        LogicalPlanGenerator.load_clause_return load_clause22 =null;

        LogicalPlanGenerator.group_clause_return group_clause23 =null;

        LogicalPlanGenerator.store_clause_return store_clause24 =null;

        LogicalPlanGenerator.filter_clause_return filter_clause25 =null;

        LogicalPlanGenerator.distinct_clause_return distinct_clause26 =null;

        LogicalPlanGenerator.limit_clause_return limit_clause27 =null;

        LogicalPlanGenerator.sample_clause_return sample_clause28 =null;

        LogicalPlanGenerator.order_clause_return order_clause29 =null;

        LogicalPlanGenerator.rank_clause_return rank_clause30 =null;

        LogicalPlanGenerator.cross_clause_return cross_clause31 =null;

        LogicalPlanGenerator.join_clause_return join_clause32 =null;

        LogicalPlanGenerator.union_clause_return union_clause33 =null;

        LogicalPlanGenerator.stream_clause_return stream_clause34 =null;

        LogicalPlanGenerator.mr_clause_return mr_clause35 =null;

        LogicalPlanGenerator.foreach_clause_return foreach_clause36 =null;

        LogicalPlanGenerator.cube_clause_return cube_clause37 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:227:33: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause )
            int alt5=17;
            switch ( input.LA(1) ) {
            case DEFINE:
                {
                alt5=1;
                }
                break;
            case LOAD:
                {
                alt5=2;
                }
                break;
            case COGROUP:
            case GROUP:
                {
                alt5=3;
                }
                break;
            case STORE:
                {
                alt5=4;
                }
                break;
            case FILTER:
                {
                alt5=5;
                }
                break;
            case DISTINCT:
                {
                alt5=6;
                }
                break;
            case LIMIT:
                {
                alt5=7;
                }
                break;
            case SAMPLE:
                {
                alt5=8;
                }
                break;
            case ORDER:
                {
                alt5=9;
                }
                break;
            case RANK:
                {
                alt5=10;
                }
                break;
            case CROSS:
                {
                alt5=11;
                }
                break;
            case JOIN:
                {
                alt5=12;
                }
                break;
            case UNION:
                {
                alt5=13;
                }
                break;
            case STREAM:
                {
                alt5=14;
                }
                break;
            case MAPREDUCE:
                {
                alt5=15;
                }
                break;
            case FOREACH:
                {
                alt5=16;
                }
                break;
            case CUBE:
                {
                alt5=17;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:228:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause289);
                    define_clause21=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause21.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:229:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause303);
                    load_clause22=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause22.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (load_clause22!=null?load_clause22.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:230:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause319);
                    group_clause23=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause23.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (group_clause23!=null?group_clause23.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:231:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause335);
                    store_clause24=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause24.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (store_clause24!=null?store_clause24.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:232:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause351);
                    filter_clause25=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause25.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (filter_clause25!=null?filter_clause25.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:233:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause367);
                    distinct_clause26=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause26.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (distinct_clause26!=null?distinct_clause26.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:234:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause383);
                    limit_clause27=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause27.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (limit_clause27!=null?limit_clause27.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:235:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause399);
                    sample_clause28=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause28.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (sample_clause28!=null?sample_clause28.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:236:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause415);
                    order_clause29=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause29.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (order_clause29!=null?order_clause29.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:237:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause431);
                    rank_clause30=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause30.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (rank_clause30!=null?rank_clause30.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:238:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause447);
                    cross_clause31=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause31.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (cross_clause31!=null?cross_clause31.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:239:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause463);
                    join_clause32=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause32.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (join_clause32!=null?join_clause32.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:240:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause479);
                    union_clause33=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause33.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (union_clause33!=null?union_clause33.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:241:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause495);
                    stream_clause34=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause34.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (stream_clause34!=null?stream_clause34.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:242:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause511);
                    mr_clause35=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause35.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (mr_clause35!=null?mr_clause35.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:243:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause527);
                    foreach_clause36=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause36.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (foreach_clause36!=null?foreach_clause36.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause543);
                    cube_clause37=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause37.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (cube_clause37!=null?cube_clause37.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "op_clause"


    public static class define_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "define_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:247:1: define_clause : ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) );
    public final LogicalPlanGenerator.define_clause_return define_clause() throws RecognitionException {
        LogicalPlanGenerator.define_clause_return retval = new LogicalPlanGenerator.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE38=null;
        CommonTree DEFINE41=null;
        LogicalPlanGenerator.alias_return alias39 =null;

        LogicalPlanGenerator.cmd_return cmd40 =null;

        LogicalPlanGenerator.alias_return alias42 =null;

        LogicalPlanGenerator.func_clause_return func_clause43 =null;


        CommonTree DEFINE38_tree=null;
        CommonTree DEFINE41_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:248:2: ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==DEFINE) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==DOWN) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==IDENTIFIER) ) {
                        int LA6_3 = input.LA(4);

                        if ( (LA6_3==EXECCOMMAND) ) {
                            alt6=1;
                        }
                        else if ( (LA6_3==FUNC||LA6_3==FUNC_REF) ) {
                            alt6=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:248:4: ^( DEFINE alias cmd[$alias.name] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE38=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause557); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE38_tree = (CommonTree)adaptor.dupNode(DEFINE38);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE38_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause559);
                    alias39=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias39.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause561);
                    cmd40=cmd((alias39!=null?alias39.name:null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd40.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineCommand( (alias39!=null?alias39.name:null), (cmd40!=null?cmd40.command:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:252:4: ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE41=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause576); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE41_tree = (CommonTree)adaptor.dupNode(DEFINE41);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE41_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause578);
                    alias42=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias42.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause580);
                    func_clause43=func_clause(FunctionType.UNKNOWNFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause43.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineFunction( (alias42!=null?alias42.name:null), (func_clause43!=null?func_clause43.funcSpec:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        public StreamingCommand command;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:258:1: cmd[String alias] returns [StreamingCommand command] : ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) ;
    public final LogicalPlanGenerator.cmd_return cmd(String alias) throws RecognitionException {
        LogicalPlanGenerator.cmd_return retval = new LogicalPlanGenerator.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND44=null;
        LogicalPlanGenerator.ship_clause_return ship_clause45 =null;

        LogicalPlanGenerator.cache_clause_return cache_clause46 =null;

        LogicalPlanGenerator.input_clause_return input_clause47 =null;

        LogicalPlanGenerator.output_clause_return output_clause48 =null;

        LogicalPlanGenerator.error_clause_return error_clause49 =null;


        CommonTree EXECCOMMAND44_tree=null;


            List<String> shipPaths = new ArrayList<String>();
            List<String> cachePaths = new ArrayList<String>();
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:264:2: ( ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:264:4: ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND44=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd609); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND44_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND44);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND44_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:264:19: ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )*
                loop7:
                do {
                    int alt7=6;
                    switch ( input.LA(1) ) {
                    case SHIP:
                        {
                        alt7=1;
                        }
                        break;
                    case CACHE:
                        {
                        alt7=2;
                        }
                        break;
                    case INPUT:
                        {
                        alt7=3;
                        }
                        break;
                    case OUTPUT:
                        {
                        alt7=4;
                        }
                        break;
                    case STDERROR:
                        {
                        alt7=5;
                        }
                        break;

                    }

                    switch (alt7) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:264:21: ship_clause[shipPaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd613);
                	    ship_clause45=ship_clause(shipPaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause45.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:264:46: cache_clause[cachePaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd618);
                	    cache_clause46=cache_clause(cachePaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause46.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:264:73: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd623);
                	    input_clause47=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause47.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:264:88: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd627);
                	    output_clause48=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause48.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:264:104: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd631);
                	    error_clause49=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause49.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop7;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.command = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND44!=null?EXECCOMMAND44.getText():null) ), shipPaths,
                       cachePaths, (input_clause47!=null?input_clause47.inputHandleSpecs:null), (output_clause48!=null?output_clause48.outputHandleSpecs:null),
                       (error_clause49!=null?error_clause49.dir:null), (error_clause49!=null?error_clause49.limit:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cmd"


    public static class ship_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ship_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:272:1: ship_clause[List<String> paths] : ^( SHIP ( path_list[$paths] )? ) ;
    public final LogicalPlanGenerator.ship_clause_return ship_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.ship_clause_return retval = new LogicalPlanGenerator.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP50=null;
        LogicalPlanGenerator.path_list_return path_list51 =null;


        CommonTree SHIP50_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:273:2: ( ^( SHIP ( path_list[$paths] )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:273:4: ^( SHIP ( path_list[$paths] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP50=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause654); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP50_tree = (CommonTree)adaptor.dupNode(SHIP50);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP50_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:273:12: ( path_list[$paths] )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:273:12: path_list[$paths]
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause656);
                        path_list51=path_list(paths);

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list51.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ship_clause"


    public static class path_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "path_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:276:1: path_list[List<String> paths] : ( QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.path_list_return path_list(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.path_list_return retval = new LogicalPlanGenerator.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING52=null;

        CommonTree QUOTEDSTRING52_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:277:2: ( ( QUOTEDSTRING )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:277:4: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:277:4: ( QUOTEDSTRING )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:277:6: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING52=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list673); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING52_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING52);


            	    adaptor.addChild(root_0, QUOTEDSTRING52_tree);
            	    }


            	    if ( state.backtracking==0 ) { paths.add( builder.unquote( (QUOTEDSTRING52!=null?QUOTEDSTRING52.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "path_list"


    public static class cache_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cache_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:280:1: cache_clause[List<String> paths] : ^( CACHE path_list[$paths] ) ;
    public final LogicalPlanGenerator.cache_clause_return cache_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.cache_clause_return retval = new LogicalPlanGenerator.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE53=null;
        LogicalPlanGenerator.path_list_return path_list54 =null;


        CommonTree CACHE53_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:281:2: ( ^( CACHE path_list[$paths] ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:281:4: ^( CACHE path_list[$paths] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE53=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause691); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE53_tree = (CommonTree)adaptor.dupNode(CACHE53);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE53_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause693);
            path_list54=path_list(paths);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list54.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cache_clause"


    public static class input_clause_return extends TreeRuleReturnScope {
        public List<HandleSpec> inputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:284:1: input_clause returns [List<HandleSpec> inputHandleSpecs] : ^( INPUT ( stream_cmd[true] )+ ) ;
    public final LogicalPlanGenerator.input_clause_return input_clause() throws RecognitionException {
        LogicalPlanGenerator.input_clause_return retval = new LogicalPlanGenerator.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT55=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd56 =null;


        CommonTree INPUT55_tree=null;


            retval.inputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:288:2: ( ^( INPUT ( stream_cmd[true] )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:288:4: ^( INPUT ( stream_cmd[true] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT55=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause716); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT55_tree = (CommonTree)adaptor.dupNode(INPUT55);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT55_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:288:13: ( stream_cmd[true] )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING||(LA10_0 >= STDIN && LA10_0 <= STDOUT)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:288:15: stream_cmd[true]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause720);
            	    stream_cmd56=stream_cmd(true);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd56.getTree());


            	    if ( state.backtracking==0 ) { retval.inputHandleSpecs.add( (stream_cmd56!=null?stream_cmd56.handleSpec:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "input_clause"


    public static class stream_cmd_return extends TreeRuleReturnScope {
        public HandleSpec handleSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:291:1: stream_cmd[boolean in] returns [HandleSpec handleSpec] : ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) );
    public final LogicalPlanGenerator.stream_cmd_return stream_cmd(boolean in) throws RecognitionException {
        LogicalPlanGenerator.stream_cmd_return retval = new LogicalPlanGenerator.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN57=null;
        CommonTree STDOUT59=null;
        CommonTree QUOTEDSTRING61=null;
        LogicalPlanGenerator.func_clause_return func_clause58 =null;

        LogicalPlanGenerator.func_clause_return func_clause60 =null;

        LogicalPlanGenerator.func_clause_return func_clause62 =null;


        CommonTree STDIN57_tree=null;
        CommonTree STDOUT59_tree=null;
        CommonTree QUOTEDSTRING61_tree=null;


            String handleName = null;
            FuncSpec fs = null;
            String deserializer = PigStreaming.class.getName() + "()";
            byte ft = in ? FunctionType.PIGTOSTREAMFUNC : FunctionType.STREAMTOPIGFUNC;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:303:2: ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case STDIN:
                {
                alt14=1;
                }
                break;
            case STDOUT:
                {
                alt14=2;
                }
                break;
            case QUOTEDSTRING:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:303:4: ^( STDIN ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN57=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd754); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN57_tree = (CommonTree)adaptor.dupNode(STDIN57);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN57_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdin"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:304:7: ( func_clause[ft] )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:304:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd766);
                                func_clause58=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause58.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause58!=null?func_clause58.funcSpec:null); }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:305:4: ^( STDOUT ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT59=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd781); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT59_tree = (CommonTree)adaptor.dupNode(STDOUT59);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT59_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdout"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:306:7: ( func_clause[ft] )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:306:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd793);
                                func_clause60=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause60.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause60!=null?func_clause60.funcSpec:null); }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:307:4: ^( QUOTEDSTRING ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING61=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING61_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING61);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING61_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = builder.unquote( (QUOTEDSTRING61!=null?QUOTEDSTRING61.getText():null) ); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:308:7: ( func_clause[ft] )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:308:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd820);
                                func_clause62=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause62.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause62!=null?func_clause62.funcSpec:null); }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                if( fs != null )
                    deserializer =  fs.toString();
                retval.handleSpec = new HandleSpec( handleName, deserializer );
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_cmd"


    public static class output_clause_return extends TreeRuleReturnScope {
        public List<HandleSpec> outputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:311:1: output_clause returns [List<HandleSpec> outputHandleSpecs] : ^( OUTPUT ( stream_cmd[false] )+ ) ;
    public final LogicalPlanGenerator.output_clause_return output_clause() throws RecognitionException {
        LogicalPlanGenerator.output_clause_return retval = new LogicalPlanGenerator.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT63=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd64 =null;


        CommonTree OUTPUT63_tree=null;


            retval.outputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:315:2: ( ^( OUTPUT ( stream_cmd[false] )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:315:4: ^( OUTPUT ( stream_cmd[false] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT63=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause848); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT63_tree = (CommonTree)adaptor.dupNode(OUTPUT63);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT63_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:315:14: ( stream_cmd[false] )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QUOTEDSTRING||(LA15_0 >= STDIN && LA15_0 <= STDOUT)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:315:16: stream_cmd[false]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause852);
            	    stream_cmd64=stream_cmd(false);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd64.getTree());


            	    if ( state.backtracking==0 ) { retval.outputHandleSpecs.add( (stream_cmd64!=null?stream_cmd64.handleSpec:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "output_clause"


    public static class error_clause_return extends TreeRuleReturnScope {
        public String dir;
        public Integer limit;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:318:1: error_clause returns [String dir, Integer limit] : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final LogicalPlanGenerator.error_clause_return error_clause() throws RecognitionException {
        LogicalPlanGenerator.error_clause_return retval = new LogicalPlanGenerator.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR65=null;
        CommonTree QUOTEDSTRING66=null;
        CommonTree INTEGER67=null;

        CommonTree STDERROR65_tree=null;
        CommonTree QUOTEDSTRING66_tree=null;
        CommonTree INTEGER67_tree=null;


            retval.limit = StreamingCommand.MAX_TASKS;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:322:2: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:322:4: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR65=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause880); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR65_tree = (CommonTree)adaptor.dupNode(STDERROR65);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR65_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:323:7: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:323:9: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING66=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause890); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING66_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING66);


                        adaptor.addChild(root_1, QUOTEDSTRING66_tree);
                        }


                        if ( state.backtracking==0 ) {
                                    retval.dir = builder.unquote( (QUOTEDSTRING66!=null?QUOTEDSTRING66.getText():null) );
                                }

                        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:327:9: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:327:11: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER67=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause912); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER67_tree = (CommonTree)adaptor.dupNode(INTEGER67);


                                adaptor.addChild(root_1, INTEGER67_tree);
                                }


                                if ( state.backtracking==0 ) {
                                              retval.limit = Integer.parseInt( (INTEGER67!=null?INTEGER67.getText():null) );
                                          }

                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "error_clause"


    public static class load_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:336:1: load_clause returns [String alias] : ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) ;
    public final LogicalPlanGenerator.load_clause_return load_clause() throws RecognitionException {
        LogicalPlanGenerator.load_clause_return retval = new LogicalPlanGenerator.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD68=null;
        LogicalPlanGenerator.filename_return filename69 =null;

        LogicalPlanGenerator.func_clause_return func_clause70 =null;

        LogicalPlanGenerator.as_clause_return as_clause71 =null;


        CommonTree LOAD68_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:337:2: ( ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:337:4: ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD68=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause965); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD68_tree = (CommonTree)adaptor.dupNode(LOAD68);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD68_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause967);
            filename69=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename69.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:337:21: ( func_clause[FunctionType.LOADFUNC] )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:337:21: func_clause[FunctionType.LOADFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause969);
                    func_clause70=func_clause(FunctionType.LOADFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause70.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:337:57: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:337:57: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause973);
                    as_clause71=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause71.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                  retval.alias = builder.buildLoadOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      (filename69!=null?filename69.filename:null), (func_clause70!=null?func_clause70.funcSpec:null), (as_clause71!=null?as_clause71.logicalSchema:null)  );
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "load_clause"


    public static class filename_return extends TreeRuleReturnScope {
        public String filename;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:345:1: filename returns [String filename] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.filename_return filename() throws RecognitionException {
        LogicalPlanGenerator.filename_return retval = new LogicalPlanGenerator.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING72=null;

        CommonTree QUOTEDSTRING72_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:346:2: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:346:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING72=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename993); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING72_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING72);


            adaptor.addChild(root_0, QUOTEDSTRING72_tree);
            }


            if ( state.backtracking==0 ) { retval.filename = builder.unquote( (QUOTEDSTRING72!=null?QUOTEDSTRING72.getText():null) ); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filename"


    public static class as_clause_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:349:1: as_clause returns [LogicalSchema logicalSchema] : ^( AS field_def_list ) ;
    public final LogicalPlanGenerator.as_clause_return as_clause() throws RecognitionException {
        LogicalPlanGenerator.as_clause_return retval = new LogicalPlanGenerator.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS73=null;
        LogicalPlanGenerator.field_def_list_return field_def_list74 =null;


        CommonTree AS73_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:350:2: ( ^( AS field_def_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:350:4: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS73=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause1010); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS73_tree = (CommonTree)adaptor.dupNode(AS73);


            root_1 = (CommonTree)adaptor.becomeRoot(AS73_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause1012);
            field_def_list74=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list74.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list74!=null?field_def_list74.schema:null));
                    retval.logicalSchema = (field_def_list74!=null?field_def_list74.schema:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "as_clause"


    public static class field_def_return extends TreeRuleReturnScope {
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:357:1: field_def[NumValCarrier nvc] returns [LogicalFieldSchema fieldSchema] : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) );
    public final LogicalPlanGenerator.field_def_return field_def(NumValCarrier nvc) throws RecognitionException {
        LogicalPlanGenerator.field_def_return retval = new LogicalPlanGenerator.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF75=null;
        CommonTree IDENTIFIER76=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER78=null;
        LogicalPlanGenerator.type_return type77 =null;

        LogicalPlanGenerator.type_return type79 =null;


        CommonTree FIELD_DEF75_tree=null;
        CommonTree IDENTIFIER76_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER78_tree=null;


            byte datatype = DataType.NULL;
            if (nvc==null) {
                nvc =new NumValCarrier();
            }

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:364:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==FIELD_DEF) ) {
                alt21=1;
            }
            else if ( (LA21_0==FIELD_DEF_WITHOUT_IDENTIFIER) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:364:4: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF75=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def1040); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF75_tree = (CommonTree)adaptor.dupNode(FIELD_DEF75);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF75_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER76=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def1042); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER76_tree = (CommonTree)adaptor.dupNode(IDENTIFIER76);


                    adaptor.addChild(root_1, IDENTIFIER76_tree);
                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:364:28: ( type )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==BIGDECIMAL||LA20_0==BIGINTEGER||LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DATETIME||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:364:30: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def1046);
                            type77=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type77.getTree());


                            if ( state.backtracking==0 ) { datatype = (type77!=null?type77.datatype:null);}

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                               retval.fieldSchema = new LogicalFieldSchema( (IDENTIFIER76!=null?IDENTIFIER76.getText():null), (type77!=null?type77.logicalSchema:null), datatype );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:368:4: ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER78=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1065); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER78_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER78);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER78_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:368:36: ( type )
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:368:38: type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def1069);
                    type79=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type79.getTree());


                    if ( state.backtracking==0 ) { datatype = (type79!=null?type79.datatype:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                               retval.fieldSchema = new LogicalFieldSchema ( nvc.makeNameFromDataType(datatype) , (type79!=null?type79.logicalSchema:null), datatype );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def"


    public static class field_def_list_return extends TreeRuleReturnScope {
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:374:1: field_def_list returns [LogicalSchema schema] : ( field_def[nvc] )+ ;
    public final LogicalPlanGenerator.field_def_list_return field_def_list() throws RecognitionException {
        LogicalPlanGenerator.field_def_list_return retval = new LogicalPlanGenerator.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.field_def_return field_def80 =null;




            retval.schema = new LogicalSchema();
            NumValCarrier nvc = new NumValCarrier();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:379:2: ( ( field_def[nvc] )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:379:4: ( field_def[nvc] )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:379:4: ( field_def[nvc] )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0 >= FIELD_DEF && LA22_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:379:6: field_def[nvc]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list1100);
            	    field_def80=field_def(nvc);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def80.getTree());


            	    if ( state.backtracking==0 ) { retval.schema.addField( (field_def80!=null?field_def80.fieldSchema:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        public Byte datatype;
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:383:1: type returns [Byte datatype, LogicalSchema logicalSchema] : ( simple_type | tuple_type | bag_type | map_type );
    public final LogicalPlanGenerator.type_return type() throws RecognitionException {
        LogicalPlanGenerator.type_return retval = new LogicalPlanGenerator.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type81 =null;

        LogicalPlanGenerator.tuple_type_return tuple_type82 =null;

        LogicalPlanGenerator.bag_type_return bag_type83 =null;

        LogicalPlanGenerator.map_type_return map_type84 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:384:2: ( simple_type | tuple_type | bag_type | map_type )
            int alt23=4;
            switch ( input.LA(1) ) {
            case BIGDECIMAL:
            case BIGINTEGER:
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt23=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt23=2;
                }
                break;
            case BAG_TYPE:
                {
                alt23=3;
                }
                break;
            case MAP_TYPE:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:384:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type1120);
                    simple_type81=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type81.getTree());


                    if ( state.backtracking==0 ) {
                            retval.datatype = (simple_type81!=null?simple_type81.datatype:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:388:4: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1130);
                    tuple_type82=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type82.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.TUPLE;
                           retval.logicalSchema = (tuple_type82!=null?tuple_type82.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:393:4: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1140);
                    bag_type83=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type83.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.BAG;
                           retval.logicalSchema = (bag_type83!=null?bag_type83.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:398:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1150);
                    map_type84=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type84.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.MAP;
                           retval.logicalSchema = (map_type84!=null?map_type84.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class simple_type_return extends TreeRuleReturnScope {
        public byte datatype;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:405:1: simple_type returns [byte datatype] : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
    public final LogicalPlanGenerator.simple_type_return simple_type() throws RecognitionException {
        LogicalPlanGenerator.simple_type_return retval = new LogicalPlanGenerator.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN85=null;
        CommonTree INT86=null;
        CommonTree LONG87=null;
        CommonTree FLOAT88=null;
        CommonTree DOUBLE89=null;
        CommonTree BIGINTEGER90=null;
        CommonTree BIGDECIMAL91=null;
        CommonTree DATETIME92=null;
        CommonTree CHARARRAY93=null;
        CommonTree BYTEARRAY94=null;

        CommonTree BOOLEAN85_tree=null;
        CommonTree INT86_tree=null;
        CommonTree LONG87_tree=null;
        CommonTree FLOAT88_tree=null;
        CommonTree DOUBLE89_tree=null;
        CommonTree BIGINTEGER90_tree=null;
        CommonTree BIGDECIMAL91_tree=null;
        CommonTree DATETIME92_tree=null;
        CommonTree CHARARRAY93_tree=null;
        CommonTree BYTEARRAY94_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:406:2: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
            int alt24=10;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt24=1;
                }
                break;
            case INT:
                {
                alt24=2;
                }
                break;
            case LONG:
                {
                alt24=3;
                }
                break;
            case FLOAT:
                {
                alt24=4;
                }
                break;
            case DOUBLE:
                {
                alt24=5;
                }
                break;
            case BIGINTEGER:
                {
                alt24=6;
                }
                break;
            case BIGDECIMAL:
                {
                alt24=7;
                }
                break;
            case DATETIME:
                {
                alt24=8;
                }
                break;
            case CHARARRAY:
                {
                alt24=9;
                }
                break;
            case BYTEARRAY:
                {
                alt24=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:406:4: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN85=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1168); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN85_tree = (CommonTree)adaptor.dupNode(BOOLEAN85);


                    adaptor.addChild(root_0, BOOLEAN85_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BOOLEAN; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:407:4: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT86=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1175); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT86_tree = (CommonTree)adaptor.dupNode(INT86);


                    adaptor.addChild(root_0, INT86_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.INTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:408:4: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG87=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1182); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG87_tree = (CommonTree)adaptor.dupNode(LONG87);


                    adaptor.addChild(root_0, LONG87_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.LONG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:409:4: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT88=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1189); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT88_tree = (CommonTree)adaptor.dupNode(FLOAT88);


                    adaptor.addChild(root_0, FLOAT88_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.FLOAT; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:410:4: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE89=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1196); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE89_tree = (CommonTree)adaptor.dupNode(DOUBLE89);


                    adaptor.addChild(root_0, DOUBLE89_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.DOUBLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:411:4: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER90=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1203); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER90_tree = (CommonTree)adaptor.dupNode(BIGINTEGER90);


                    adaptor.addChild(root_0, BIGINTEGER90_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BIGINTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:412:4: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL91=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1210); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL91_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL91);


                    adaptor.addChild(root_0, BIGDECIMAL91_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BIGDECIMAL; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:413:4: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME92=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1217); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME92_tree = (CommonTree)adaptor.dupNode(DATETIME92);


                    adaptor.addChild(root_0, DATETIME92_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.DATETIME; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:414:4: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY93=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1224); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY93_tree = (CommonTree)adaptor.dupNode(CHARARRAY93);


                    adaptor.addChild(root_0, CHARARRAY93_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.CHARARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:415:4: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY94=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1231); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY94_tree = (CommonTree)adaptor.dupNode(BYTEARRAY94);


                    adaptor.addChild(root_0, BYTEARRAY94_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BYTEARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:418:1: tuple_type returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final LogicalPlanGenerator.tuple_type_return tuple_type() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_return retval = new LogicalPlanGenerator.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE95=null;
        LogicalPlanGenerator.field_def_list_return field_def_list96 =null;


        CommonTree TUPLE_TYPE95_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:419:2: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:419:4: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE95=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1248); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE95_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE95);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE95_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:420:7: ( field_def_list )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0 >= FIELD_DEF && LA25_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:420:9: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1258);
                        field_def_list96=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list96.getTree());


                        if ( state.backtracking==0 ) {
                                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list96!=null?field_def_list96.schema:null));
                                    retval.logicalSchema = (field_def_list96!=null?field_def_list96.schema:null);
                                }

                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type"


    public static class bag_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:429:1: bag_type returns [LogicalSchema logicalSchema] : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final LogicalPlanGenerator.bag_type_return bag_type() throws RecognitionException {
        LogicalPlanGenerator.bag_type_return retval = new LogicalPlanGenerator.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE97=null;
        CommonTree IDENTIFIER98=null;
        LogicalPlanGenerator.tuple_type_return tuple_type99 =null;


        CommonTree BAG_TYPE97_tree=null;
        CommonTree IDENTIFIER98_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:430:2: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:430:4: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE97=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1298); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE97_tree = (CommonTree)adaptor.dupNode(BAG_TYPE97);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE97_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:430:16: ( IDENTIFIER )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==IDENTIFIER) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:430:16: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER98=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1300); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER98_tree = (CommonTree)adaptor.dupNode(IDENTIFIER98);


                        adaptor.addChild(root_1, IDENTIFIER98_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:430:28: ( tuple_type )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==TUPLE_TYPE) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:430:28: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1303);
                        tuple_type99=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type99.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   if ((tuple_type99!=null?tuple_type99.logicalSchema:null)!=null && (tuple_type99!=null?tuple_type99.logicalSchema:null).size()==1 && (tuple_type99!=null?tuple_type99.logicalSchema:null).getField(0).type==DataType.TUPLE) {
                       retval.logicalSchema = (tuple_type99!=null?tuple_type99.logicalSchema:null);
                   }
                   else {
                       LogicalSchema s = new LogicalSchema();
                       s.addField(new LogicalFieldSchema((IDENTIFIER98!=null?IDENTIFIER98.getText():null), (tuple_type99!=null?tuple_type99.logicalSchema:null), DataType.TUPLE));
                       retval.logicalSchema = s;
                   }
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:443:1: map_type returns [LogicalSchema logicalSchema] : ^( MAP_TYPE ( type )? ) ;
    public final LogicalPlanGenerator.map_type_return map_type() throws RecognitionException {
        LogicalPlanGenerator.map_type_return retval = new LogicalPlanGenerator.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE100=null;
        LogicalPlanGenerator.type_return type101 =null;


        CommonTree MAP_TYPE100_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:444:2: ( ^( MAP_TYPE ( type )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:444:4: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE100=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1326); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE100_tree = (CommonTree)adaptor.dupNode(MAP_TYPE100);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE100_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:444:16: ( type )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==BIGDECIMAL||LA28_0==BIGINTEGER||LA28_0==BOOLEAN||LA28_0==BYTEARRAY||LA28_0==CHARARRAY||LA28_0==DATETIME||LA28_0==DOUBLE||LA28_0==FLOAT||LA28_0==INT||LA28_0==LONG||LA28_0==BAG_TYPE||LA28_0==MAP_TYPE||LA28_0==TUPLE_TYPE) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:444:16: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1328);
                        type101=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type101.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   LogicalSchema s = null;
                   if( (type101!=null?type101.datatype:null) != null ) {
                       s = new LogicalSchema();
                       s.addField( new LogicalFieldSchema( null, (type101!=null?type101.logicalSchema:null), (type101!=null?type101.datatype:null) ) );
                   }
                   retval.logicalSchema = s;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_type"


    public static class func_clause_return extends TreeRuleReturnScope {
        public FuncSpec funcSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:455:1: func_clause[byte ft] returns [FuncSpec funcSpec] : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final LogicalPlanGenerator.func_clause_return func_clause(byte ft) throws RecognitionException {
        LogicalPlanGenerator.func_clause_return retval = new LogicalPlanGenerator.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF102=null;
        CommonTree FUNC104=null;
        LogicalPlanGenerator.func_name_return func_name103 =null;

        LogicalPlanGenerator.func_name_return func_name105 =null;

        LogicalPlanGenerator.func_args_return func_args106 =null;


        CommonTree FUNC_REF102_tree=null;
        CommonTree FUNC104_tree=null;


            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:459:2: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==FUNC_REF) ) {
                alt30=1;
            }
            else if ( (LA30_0==FUNC) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }
            switch (alt30) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:459:4: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF102=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1357); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF102_tree = (CommonTree)adaptor.dupNode(FUNC_REF102);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF102_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1359);
                    func_name103=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name103.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.funcSpec = builder.lookupFunction( (func_name103!=null?func_name103.funcName:null) );
                           if( retval.funcSpec == null )
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name103!=null?func_name103.funcName:null), new ArrayList<String>(), ft );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:465:4: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC104=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1373); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC104_tree = (CommonTree)adaptor.dupNode(FUNC104);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC104_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1375);
                    func_name105=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name105.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:465:22: ( func_args )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==MULTILINE_QUOTEDSTRING||LA29_0==QUOTEDSTRING) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:465:22: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1377);
                            func_args106=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args106.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.funcSpec = builder.lookupFunction( (func_name105!=null?func_name105.funcName:null) );
                           if( retval.funcSpec == null ) {
                               List<String> argList = new ArrayList<String>();
                               if( (func_args106!=null?func_args106.args:null) != null )
                                   argList = (func_args106!=null?func_args106.args:null);
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name105!=null?func_name105.funcName:null), argList, ft );
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_clause"


    public static class func_name_return extends TreeRuleReturnScope {
        public String funcName;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:477:1: func_name returns [String funcName] : p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* ;
    public final LogicalPlanGenerator.func_name_return func_name() throws RecognitionException {
        LogicalPlanGenerator.func_name_return retval = new LogicalPlanGenerator.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD107=null;
        CommonTree DOLLAR108=null;
        LogicalPlanGenerator.eid_return p1 =null;

        LogicalPlanGenerator.eid_return p2 =null;


        CommonTree PERIOD107_tree=null;
        CommonTree DOLLAR108_tree=null;

         StringBuilder buf = new StringBuilder(); 
        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:479:2: (p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:479:4: p1= eid ( ( PERIOD | DOLLAR ) p2= eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1407);
            p1=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, p1.getTree());


            if ( state.backtracking==0 ) { buf.append( (p1!=null?p1.id:null) ); }

            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:480:7: ( ( PERIOD | DOLLAR ) p2= eid )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==DOLLAR||LA32_0==PERIOD) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:480:9: ( PERIOD | DOLLAR ) p2= eid
            	    {
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:480:9: ( PERIOD | DOLLAR )
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==PERIOD) ) {
            	        alt31=1;
            	    }
            	    else if ( (LA31_0==DOLLAR) ) {
            	        alt31=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 31, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:480:11: PERIOD
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            PERIOD107=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_func_name1421); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PERIOD107_tree = (CommonTree)adaptor.dupNode(PERIOD107);


            	            adaptor.addChild(root_0, PERIOD107_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (PERIOD107!=null?PERIOD107.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;
            	        case 2 :
            	            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:480:52: DOLLAR
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            DOLLAR108=(CommonTree)match(input,DOLLAR,FOLLOW_DOLLAR_in_func_name1427); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DOLLAR108_tree = (CommonTree)adaptor.dupNode(DOLLAR108);


            	            adaptor.addChild(root_0, DOLLAR108_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (DOLLAR108!=null?DOLLAR108.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;

            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1443);
            	    p2=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, p2.getTree());


            	    if ( state.backtracking==0 ) { buf.append( (p2!=null?p2.id:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                   retval.funcName = buf.toString();
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_name"


    public static class func_args_return extends TreeRuleReturnScope {
        public List<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:487:1: func_args returns [List<String> args] : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.func_args_return func_args() throws RecognitionException {
        LogicalPlanGenerator.func_args_return retval = new LogicalPlanGenerator.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING109=null;
        CommonTree MULTILINE_QUOTEDSTRING110=null;

        CommonTree QUOTEDSTRING109_tree=null;
        CommonTree MULTILINE_QUOTEDSTRING110_tree=null;

         retval.args = new ArrayList<String>(); 
        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:489:3: ( ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:489:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:489:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            int cnt33=0;
            loop33:
            do {
                int alt33=3;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==QUOTEDSTRING) ) {
                    alt33=1;
                }
                else if ( (LA33_0==MULTILINE_QUOTEDSTRING) ) {
                    alt33=2;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:489:5: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING109=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1472); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING109_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING109);


            	    adaptor.addChild(root_0, QUOTEDSTRING109_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (QUOTEDSTRING109!=null?QUOTEDSTRING109.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:7: MULTILINE_QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    MULTILINE_QUOTEDSTRING110=(CommonTree)match(input,MULTILINE_QUOTEDSTRING,FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1482); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MULTILINE_QUOTEDSTRING110_tree = (CommonTree)adaptor.dupNode(MULTILINE_QUOTEDSTRING110);


            	    adaptor.addChild(root_0, MULTILINE_QUOTEDSTRING110_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (MULTILINE_QUOTEDSTRING110!=null?MULTILINE_QUOTEDSTRING110.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_args"


    protected static class cube_clause_scope {
        LOCube cubeOp;
        MultiMap<Integer, LogicalExpressionPlan> cubePlans;
        List<String> operations;
        int inputIndex;
    }
    protected Stack cube_clause_stack = new Stack();


    public static class cube_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:500:1: cube_clause returns [String alias] : ^( CUBE cube_item ) ;
    public final LogicalPlanGenerator.cube_clause_return cube_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        cube_clause_stack.push(new cube_clause_scope());
        LogicalPlanGenerator.cube_clause_return retval = new LogicalPlanGenerator.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE111=null;
        LogicalPlanGenerator.cube_item_return cube_item112 =null;


        CommonTree CUBE111_tree=null;


            ((cube_clause_scope)cube_clause_stack.peek()).cubeOp = builder.createCubeOp();
            ((GScope_scope)GScope_stack.peek()).currentOp = ((cube_clause_scope)cube_clause_stack.peek()).cubeOp;
            ((cube_clause_scope)cube_clause_stack.peek()).cubePlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((cube_clause_scope)cube_clause_stack.peek()).operations = new ArrayList<String>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:514:2: ( ^( CUBE cube_item ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:514:4: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE111=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1524); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE111_tree = (CommonTree)adaptor.dupNode(CUBE111);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE111_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1526);
            cube_item112=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item112.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                   retval.alias = builder.buildCubeOp( loc, ((cube_clause_scope)cube_clause_stack.peek()).cubeOp, ((statement_scope)statement_stack.peek()).alias,
                   ((statement_scope)statement_stack.peek()).inputAlias, ((cube_clause_scope)cube_clause_stack.peek()).operations, ((cube_clause_scope)cube_clause_stack.peek()).cubePlans );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            cube_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "cube_clause"


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:522:1: cube_item : rel ( cube_by_clause ) ;
    public final LogicalPlanGenerator.cube_item_return cube_item() throws RecognitionException {
        LogicalPlanGenerator.cube_item_return retval = new LogicalPlanGenerator.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_return rel113 =null;

        LogicalPlanGenerator.cube_by_clause_return cube_by_clause114 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:523:2: ( rel ( cube_by_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:523:4: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1543);
            rel113=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel113.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:523:8: ( cube_by_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:523:10: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1547);
            cube_by_clause114=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause114.getTree());


            if ( state.backtracking==0 ) {
                   ((cube_clause_scope)cube_clause_stack.peek()).cubePlans = (cube_by_clause114!=null?cube_by_clause114.plans:null);
                   ((cube_clause_scope)cube_clause_stack.peek()).operations = (cube_by_clause114!=null?cube_by_clause114.operations:null);
               }

            if ( state.backtracking==0 ) {
            }
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_item"


    public static class cube_by_clause_return extends TreeRuleReturnScope {
        public List<String> operations;
        public MultiMap<Integer, LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:530:1: cube_by_clause returns [List<String> operations, MultiMap<Integer, LogicalExpressionPlan> plans] : ^( BY cube_or_rollup ) ;
    public final LogicalPlanGenerator.cube_by_clause_return cube_by_clause() throws RecognitionException {
        LogicalPlanGenerator.cube_by_clause_return retval = new LogicalPlanGenerator.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY115=null;
        LogicalPlanGenerator.cube_or_rollup_return cube_or_rollup116 =null;


        CommonTree BY115_tree=null;


            retval.operations = new ArrayList<String>();
            retval.plans = new MultiMap<Integer, LogicalExpressionPlan>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:535:2: ( ^( BY cube_or_rollup ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:535:4: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY115=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY115_tree = (CommonTree)adaptor.dupNode(BY115);


            root_1 = (CommonTree)adaptor.becomeRoot(BY115_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1576);
            cube_or_rollup116=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup116.getTree());


            if ( state.backtracking==0 ) { retval.operations = (cube_or_rollup116!=null?cube_or_rollup116.operations:null); retval.plans = (cube_or_rollup116!=null?cube_or_rollup116.plans:null); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_clause"


    public static class cube_or_rollup_return extends TreeRuleReturnScope {
        public List<String> operations;
        public MultiMap<Integer, LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_or_rollup"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:538:1: cube_or_rollup returns [List<String> operations, MultiMap<Integer, LogicalExpressionPlan> plans] : ( cube_rollup_list )+ ;
    public final LogicalPlanGenerator.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        LogicalPlanGenerator.cube_or_rollup_return retval = new LogicalPlanGenerator.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.cube_rollup_list_return cube_rollup_list117 =null;




            retval.operations = new ArrayList<String>();
            retval.plans = new MultiMap<Integer, LogicalExpressionPlan>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:543:2: ( ( cube_rollup_list )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:543:4: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:543:4: ( cube_rollup_list )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==CUBE||LA34_0==ROLLUP) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:543:6: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1599);
            	    cube_rollup_list117=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list117.getTree());


            	    if ( state.backtracking==0 ) {
            	           retval.operations.add((cube_rollup_list117!=null?cube_rollup_list117.operation:null));
            	           retval.plans.put( ((cube_clause_scope)cube_clause_stack.peek()).inputIndex, (cube_rollup_list117!=null?cube_rollup_list117.plans:null));
            	           ((cube_clause_scope)cube_clause_stack.peek()).inputIndex++;
            	       }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_or_rollup"


    public static class cube_rollup_list_return extends TreeRuleReturnScope {
        public String operation;
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:551:1: cube_rollup_list returns [String operation, List<LogicalExpressionPlan> plans] : ^( ( CUBE | ROLLUP ) cube_by_expr_list ) ;
    public final LogicalPlanGenerator.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        LogicalPlanGenerator.cube_rollup_list_return retval = new LogicalPlanGenerator.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE118=null;
        CommonTree ROLLUP119=null;
        LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list120 =null;


        CommonTree CUBE118_tree=null;
        CommonTree ROLLUP119_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:555:2: ( ^( ( CUBE | ROLLUP ) cube_by_expr_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:555:4: ^( ( CUBE | ROLLUP ) cube_by_expr_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:555:7: ( CUBE | ROLLUP )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==CUBE) ) {
                alt35=1;
            }
            else if ( (LA35_0==ROLLUP) ) {
                alt35=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:555:9: CUBE
                    {
                    _last = (CommonTree)input.LT(1);
                    CUBE118=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE118_tree = (CommonTree)adaptor.dupNode(CUBE118);


                    adaptor.addChild(root_1, CUBE118_tree);
                    }


                    if ( state.backtracking==0 ) { retval.operation = "CUBE"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:555:41: ROLLUP
                    {
                    _last = (CommonTree)input.LT(1);
                    ROLLUP119=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP119_tree = (CommonTree)adaptor.dupNode(ROLLUP119);


                    adaptor.addChild(root_1, ROLLUP119_tree);
                    }


                    if ( state.backtracking==0 ) { retval.operation = "ROLLUP"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1641);
            cube_by_expr_list120=cube_by_expr_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_by_expr_list120.getTree());


            if ( state.backtracking==0 ) { retval.plans = (cube_by_expr_list120!=null?cube_by_expr_list120.plans:null); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_rollup_list"


    public static class cube_by_expr_list_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:558:1: cube_by_expr_list returns [List<LogicalExpressionPlan> plans] : ( cube_by_expr )+ ;
    public final LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        LogicalPlanGenerator.cube_by_expr_list_return retval = new LogicalPlanGenerator.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.cube_by_expr_return cube_by_expr121 =null;




            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:562:2: ( ( cube_by_expr )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:562:4: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:562:4: ( cube_by_expr )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==BIGDECIMALNUMBER||LA36_0==BIGINTEGERNUMBER||LA36_0==CUBE||LA36_0==DIV||LA36_0==DOLLARVAR||LA36_0==DOUBLENUMBER||LA36_0==FALSE||LA36_0==FLOATNUMBER||LA36_0==GROUP||LA36_0==IDENTIFIER||LA36_0==INTEGER||LA36_0==LONGINTEGER||LA36_0==MINUS||LA36_0==NULL||LA36_0==PERCENT||LA36_0==PLUS||LA36_0==QUOTEDSTRING||LA36_0==STAR||LA36_0==TRUE||(LA36_0 >= BAG_VAL && LA36_0 <= BIN_EXPR)||(LA36_0 >= CASE_COND && LA36_0 <= EXPR_IN_PAREN)||LA36_0==FUNC_EVAL||LA36_0==INVOKER_FUNC_EVAL||(LA36_0 >= MAP_VAL && LA36_0 <= NEG)||LA36_0==TUPLE_VAL) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:562:6: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1665);
            	    cube_by_expr121=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr121.getTree());


            	    if ( state.backtracking==0 ) { retval.plans.add( (cube_by_expr121!=null?cube_by_expr121.plan:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:565:1: cube_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
    public final LogicalPlanGenerator.cube_by_expr_return cube_by_expr() throws RecognitionException {
        LogicalPlanGenerator.cube_by_expr_return retval = new LogicalPlanGenerator.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR124=null;
        LogicalPlanGenerator.col_range_return col_range122 =null;

        LogicalPlanGenerator.expr_return expr123 =null;


        CommonTree STAR124_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:569:2: ( col_range[$plan] | expr[$plan] | STAR )
            int alt37=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt37=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt37=2;
                }
                break;
            case STAR:
                {
                int LA37_3 = input.LA(2);

                if ( (LA37_3==DOWN) ) {
                    alt37=2;
                }
                else if ( (LA37_3==EOF||LA37_3==UP||LA37_3==BIGDECIMALNUMBER||LA37_3==BIGINTEGERNUMBER||LA37_3==CUBE||LA37_3==DIV||LA37_3==DOLLARVAR||LA37_3==DOUBLENUMBER||LA37_3==FALSE||LA37_3==FLOATNUMBER||LA37_3==GROUP||LA37_3==IDENTIFIER||LA37_3==INTEGER||LA37_3==LONGINTEGER||LA37_3==MINUS||LA37_3==NULL||LA37_3==PERCENT||LA37_3==PLUS||LA37_3==QUOTEDSTRING||LA37_3==STAR||LA37_3==TRUE||(LA37_3 >= BAG_VAL && LA37_3 <= BIN_EXPR)||(LA37_3 >= CASE_COND && LA37_3 <= EXPR_IN_PAREN)||LA37_3==FUNC_EVAL||LA37_3==INVOKER_FUNC_EVAL||(LA37_3 >= MAP_VAL && LA37_3 <= NEG)||LA37_3==TUPLE_VAL) ) {
                    alt37=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }

            switch (alt37) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:569:4: col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1688);
                    col_range122=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range122.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:570:4: expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1694);
                    expr123=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr123.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:571:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR124=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1700); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR124_tree = (CommonTree)adaptor.dupNode(STAR124);


                    adaptor.addChild(root_0, STAR124_tree);
                    }


                    if ( state.backtracking==0 ) {
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR124 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp, 0, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr"


    protected static class group_clause_scope {
        MultiMap<Integer, LogicalExpressionPlan> groupPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack group_clause_stack = new Stack();


    public static class group_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:577:1: group_clause returns [String alias] : ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) );
    public final LogicalPlanGenerator.group_clause_return group_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        group_clause_stack.push(new group_clause_scope());
        LogicalPlanGenerator.group_clause_return retval = new LogicalPlanGenerator.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP125=null;
        CommonTree COGROUP129=null;
        LogicalPlanGenerator.group_item_return group_item126 =null;

        LogicalPlanGenerator.group_type_return group_type127 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause128 =null;

        LogicalPlanGenerator.group_item_return group_item130 =null;

        LogicalPlanGenerator.group_type_return group_type131 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause132 =null;


        CommonTree GROUP125_tree=null;
        CommonTree COGROUP129_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createGroupOp();
            ((group_clause_scope)group_clause_stack.peek()).groupPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((group_clause_scope)group_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((group_clause_scope)group_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            GROUPTYPE groupType = GROUPTYPE.REGULAR;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:595:2: ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==GROUP) ) {
                alt44=1;
            }
            else if ( (LA44_0==COGROUP) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }
            switch (alt44) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:595:4: ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    GROUP125=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_group_clause1739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP125_tree = (CommonTree)adaptor.dupNode(GROUP125);


                    root_1 = (CommonTree)adaptor.becomeRoot(GROUP125_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:595:13: ( group_item )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==ARROBA||LA38_0==COGROUP||(LA38_0 >= CROSS && LA38_0 <= CUBE)||LA38_0==DEFINE||LA38_0==DISTINCT||LA38_0==FILTER||LA38_0==FOREACH||LA38_0==GROUP||LA38_0==IDENTIFIER||LA38_0==JOIN||(LA38_0 >= LIMIT && LA38_0 <= LOAD)||LA38_0==MAPREDUCE||LA38_0==ORDER||LA38_0==RANK||LA38_0==SAMPLE||(LA38_0 >= STORE && LA38_0 <= STREAM)||LA38_0==UNION) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:595:13: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1741);
                    	    group_item126=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item126.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt38 >= 1 ) break loop38;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(38, input);
                                throw eee;
                        }
                        cnt38++;
                    } while (true);


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:595:25: ( group_type )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==QUOTEDSTRING) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:595:27: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1746);
                            group_type127=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type127.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type127!=null?group_type127.type:null); ((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:595:146: ( partition_clause )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==PARTITION) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:595:146: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1753);
                            partition_clause128=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause128.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause128!=null?partition_clause128.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:601:4: ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    COGROUP129=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_group_clause1768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP129_tree = (CommonTree)adaptor.dupNode(COGROUP129);


                    root_1 = (CommonTree)adaptor.becomeRoot(COGROUP129_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:601:15: ( group_item )+
                    int cnt41=0;
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==ARROBA||LA41_0==COGROUP||(LA41_0 >= CROSS && LA41_0 <= CUBE)||LA41_0==DEFINE||LA41_0==DISTINCT||LA41_0==FILTER||LA41_0==FOREACH||LA41_0==GROUP||LA41_0==IDENTIFIER||LA41_0==JOIN||(LA41_0 >= LIMIT && LA41_0 <= LOAD)||LA41_0==MAPREDUCE||LA41_0==ORDER||LA41_0==RANK||LA41_0==SAMPLE||(LA41_0 >= STORE && LA41_0 <= STREAM)||LA41_0==UNION) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:601:15: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1770);
                    	    group_item130=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item130.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt41 >= 1 ) break loop41;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(41, input);
                                throw eee;
                        }
                        cnt41++;
                    } while (true);


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:601:27: ( group_type )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==QUOTEDSTRING) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:601:29: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1775);
                            group_type131=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type131.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type131!=null?group_type131.type:null);((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:601:147: ( partition_clause )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==PARTITION) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:601:147: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1782);
                            partition_clause132=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause132.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause132!=null?partition_clause132.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).inputIndex = oldStatementIndex; }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            group_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        public GROUPTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:609:1: group_type returns [GROUPTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.group_type_return group_type() throws RecognitionException {
        LogicalPlanGenerator.group_type_return retval = new LogicalPlanGenerator.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING133=null;

        CommonTree QUOTEDSTRING133_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:610:2: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:610:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING133=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1803); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING133_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING133);


            adaptor.addChild(root_0, QUOTEDSTRING133_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type =builder.parseGroupType( (QUOTEDSTRING133!=null?QUOTEDSTRING133.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING133 ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_type"


    public static class group_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_item"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:616:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final LogicalPlanGenerator.group_item_return group_item() throws RecognitionException {
        LogicalPlanGenerator.group_item_return retval = new LogicalPlanGenerator.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL136=null;
        CommonTree ANY137=null;
        CommonTree INNER138=null;
        CommonTree OUTER139=null;
        LogicalPlanGenerator.rel_return rel134 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause135 =null;


        CommonTree ALL136_tree=null;
        CommonTree ANY137_tree=null;
        CommonTree INNER138_tree=null;
        CommonTree OUTER139_tree=null;

         boolean inner = false; 
        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:618:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:618:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1823);
            rel134=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel134.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:618:8: ( join_group_by_clause | ALL | ANY )
            int alt45=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt45=1;
                }
                break;
            case ALL:
                {
                alt45=2;
                }
                break;
            case ANY:
                {
                alt45=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }

            switch (alt45) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:618:10: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1827);
                    join_group_by_clause135=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause135.getTree());


                    if ( state.backtracking==0 ) {
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, (join_group_by_clause135!=null?join_group_by_clause135.plans:null) );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:622:12: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL136=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1851); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL136_tree = (CommonTree)adaptor.dupNode(ALL136);


                    adaptor.addChild(root_0, ALL136_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 ConstantExpression ce = new ConstantExpression( plan, "all");
                                 ce.setLocation( new SourceLocation( (PigParserNode)ALL136 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:631:12: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY137=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1875); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY137_tree = (CommonTree)adaptor.dupNode(ANY137);


                    adaptor.addChild(root_0, ANY137_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 UserFuncExpression udf = new UserFuncExpression( plan, new FuncSpec( GFAny.class.getName() ) );
                                 udf.setLocation( new SourceLocation( (PigParserNode)ANY137 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:640:11: ( INNER | OUTER )?
            int alt46=3;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==INNER) ) {
                alt46=1;
            }
            else if ( (LA46_0==OUTER) ) {
                alt46=2;
            }
            switch (alt46) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:640:13: INNER
                    {
                    _last = (CommonTree)input.LT(1);
                    INNER138=(CommonTree)match(input,INNER,FOLLOW_INNER_in_group_item1900); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER138_tree = (CommonTree)adaptor.dupNode(INNER138);


                    adaptor.addChild(root_0, INNER138_tree);
                    }


                    if ( state.backtracking==0 ) { inner =  true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:640:40: OUTER
                    {
                    _last = (CommonTree)input.LT(1);
                    OUTER139=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_group_item1906); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER139_tree = (CommonTree)adaptor.dupNode(OUTER139);


                    adaptor.addChild(root_0, OUTER139_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   ((group_clause_scope)group_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((group_clause_scope)group_clause_stack.peek()).innerFlags.add( inner );
                   ((group_clause_scope)group_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:649:1: rel : ( alias | previous_rel | inline_op );
    public final LogicalPlanGenerator.rel_return rel() throws RecognitionException {
        LogicalPlanGenerator.rel_return retval = new LogicalPlanGenerator.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_return alias140 =null;

        LogicalPlanGenerator.previous_rel_return previous_rel141 =null;

        LogicalPlanGenerator.inline_op_return inline_op142 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:650:2: ( alias | previous_rel | inline_op )
            int alt47=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt47=1;
                }
                break;
            case ARROBA:
                {
                alt47=2;
                }
                break;
            case COGROUP:
            case CROSS:
            case CUBE:
            case DEFINE:
            case DISTINCT:
            case FILTER:
            case FOREACH:
            case GROUP:
            case JOIN:
            case LIMIT:
            case LOAD:
            case MAPREDUCE:
            case ORDER:
            case RANK:
            case SAMPLE:
            case STORE:
            case STREAM:
            case UNION:
                {
                alt47=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }

            switch (alt47) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:650:4: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1924);
                    alias140=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias140.getTree());


                    if ( state.backtracking==0 ) {
                           ((statement_scope)statement_stack.peek()).inputAlias = (alias140!=null?alias140.name:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:654:4: previous_rel
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_previous_rel_in_rel1934);
                    previous_rel141=previous_rel();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, previous_rel141.getTree());


                    if ( state.backtracking==0 ) {
                           ((statement_scope)statement_stack.peek()).inputAlias = (previous_rel141!=null?previous_rel141.name:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:658:4: inline_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_inline_op_in_rel1944);
                    inline_op142=inline_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, inline_op142.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel"


    public static class previous_rel_return extends TreeRuleReturnScope {
        public String name;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "previous_rel"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:661:1: previous_rel returns [String name] : ARROBA ;
    public final LogicalPlanGenerator.previous_rel_return previous_rel() throws RecognitionException {
        LogicalPlanGenerator.previous_rel_return retval = new LogicalPlanGenerator.previous_rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARROBA143=null;

        CommonTree ARROBA143_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:661:35: ( ARROBA )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:661:37: ARROBA
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            ARROBA143=(CommonTree)match(input,ARROBA,FOLLOW_ARROBA_in_previous_rel1956); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARROBA143_tree = (CommonTree)adaptor.dupNode(ARROBA143);


            adaptor.addChild(root_0, ARROBA143_tree);
            }


            if ( state.backtracking==0 ) { retval.name = builder.getLastRel(new SourceLocation((PigParserNode)ARROBA143)); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "previous_rel"


    public static class inline_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inline_op"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:664:1: inline_op : op_clause ( parallel_clause )? ;
    public final LogicalPlanGenerator.inline_op_return inline_op() throws RecognitionException {
        LogicalPlanGenerator.inline_op_return retval = new LogicalPlanGenerator.inline_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.op_clause_return op_clause144 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause145 =null;




            String al = ((statement_scope)statement_stack.peek()).alias;
            ((statement_scope)statement_stack.peek()).alias = null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:672:2: ( op_clause ( parallel_clause )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:672:4: op_clause ( parallel_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_inline_op1978);
            op_clause144=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, op_clause144.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:672:14: ( parallel_clause )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==PARALLEL) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:672:14: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_inline_op1980);
                    parallel_clause145=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, parallel_clause145.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   Operator op = builder.lookupOperator( (op_clause144!=null?op_clause144.alias:null) );
                   builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
                   ((statement_scope)statement_stack.peek()).inputAlias = (op_clause144!=null?op_clause144.alias:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                ((statement_scope)statement_stack.peek()).alias = al;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "inline_op"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public boolean flattenFlag;
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:680:1: flatten_generated_item returns [LogicalExpressionPlan plan, boolean flattenFlag, LogicalSchema schema] : ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? ;
    public final LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        LogicalPlanGenerator.flatten_generated_item_return retval = new LogicalPlanGenerator.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR149=null;
        LogicalPlanGenerator.flatten_clause_return flatten_clause146 =null;

        LogicalPlanGenerator.col_range_return col_range147 =null;

        LogicalPlanGenerator.expr_return expr148 =null;

        LogicalPlanGenerator.field_def_list_return field_def_list150 =null;


        CommonTree STAR149_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:684:2: ( ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:684:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:684:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR )
            int alt49=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt49=1;
                }
                break;
            case COL_RANGE:
                {
                alt49=2;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt49=3;
                }
                break;
            case STAR:
                {
                int LA49_4 = input.LA(2);

                if ( (LA49_4==DOWN) ) {
                    alt49=3;
                }
                else if ( (LA49_4==EOF||LA49_4==UP||LA49_4==BIGDECIMALNUMBER||LA49_4==BIGINTEGERNUMBER||LA49_4==CUBE||LA49_4==DIV||LA49_4==DOLLARVAR||LA49_4==DOUBLENUMBER||LA49_4==FALSE||LA49_4==FLATTEN||LA49_4==FLOATNUMBER||LA49_4==GROUP||LA49_4==IDENTIFIER||LA49_4==INTEGER||LA49_4==LONGINTEGER||LA49_4==MINUS||LA49_4==NULL||LA49_4==PERCENT||LA49_4==PLUS||LA49_4==QUOTEDSTRING||LA49_4==STAR||LA49_4==TRUE||(LA49_4 >= BAG_VAL && LA49_4 <= BIN_EXPR)||(LA49_4 >= CASE_COND && LA49_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA49_4==FUNC_EVAL||LA49_4==INVOKER_FUNC_EVAL||(LA49_4 >= MAP_VAL && LA49_4 <= NEG)||LA49_4==TUPLE_VAL) ) {
                    alt49=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:684:6: flatten_clause[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item2006);
                    flatten_clause146=flatten_clause(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause146.getTree());


                    if ( state.backtracking==0 ) { retval.flattenFlag = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:685:6: col_range[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item2016);
                    col_range147=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range147.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:686:6: expr[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item2024);
                    expr148=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr148.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:687:6: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR149=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item2032); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR149_tree = (CommonTree)adaptor.dupNode(STAR149);


                    adaptor.addChild(root_0, STAR149_tree);
                    }


                    if ( state.backtracking==0 ) {
                             builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR149 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                 ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:693:4: ( field_def_list )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0 >= FIELD_DEF && LA50_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:693:6: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item2051);
                    field_def_list150=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list150.getTree());


                    if ( state.backtracking==0 ) { retval.schema = (field_def_list150!=null?field_def_list150.schema:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_generated_item"


    public static class flatten_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:696:1: flatten_clause[LogicalExpressionPlan plan] : ^( FLATTEN expr[$plan] ) ;
    public final LogicalPlanGenerator.flatten_clause_return flatten_clause(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.flatten_clause_return retval = new LogicalPlanGenerator.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN151=null;
        LogicalPlanGenerator.expr_return expr152 =null;


        CommonTree FLATTEN151_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:697:2: ( ^( FLATTEN expr[$plan] ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:697:4: ^( FLATTEN expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN151=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause2069); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN151_tree = (CommonTree)adaptor.dupNode(FLATTEN151);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN151_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause2071);
            expr152=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr152.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_clause"


    public static class store_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:700:1: store_clause returns [String alias] : ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) ;
    public final LogicalPlanGenerator.store_clause_return store_clause() throws RecognitionException {
        LogicalPlanGenerator.store_clause_return retval = new LogicalPlanGenerator.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE153=null;
        LogicalPlanGenerator.rel_return rel154 =null;

        LogicalPlanGenerator.filename_return filename155 =null;

        LogicalPlanGenerator.func_clause_return func_clause156 =null;


        CommonTree STORE153_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:701:2: ( ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:701:4: ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE153=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause2089); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE153_tree = (CommonTree)adaptor.dupNode(STORE153);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE153_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause2091);
            rel154=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel154.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause2093);
            filename155=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename155.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:701:26: ( func_clause[FunctionType.STOREFUNC] )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FUNC||LA51_0==FUNC_REF) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:701:26: func_clause[FunctionType.STOREFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause2095);
                    func_clause156=func_clause(FunctionType.STOREFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause156.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)STORE153 );
                   retval.alias = builder.buildStoreOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (filename155!=null?filename155.filename:null), (func_clause156!=null?func_clause156.funcSpec:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "store_clause"


    public static class filter_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:709:1: filter_clause returns [String alias] : ^( FILTER rel cond[exprPlan] ) ;
    public final LogicalPlanGenerator.filter_clause_return filter_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.filter_clause_return retval = new LogicalPlanGenerator.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER157=null;
        LogicalPlanGenerator.rel_return rel158 =null;

        LogicalPlanGenerator.cond_return cond159 =null;


        CommonTree FILTER157_tree=null;


            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createFilterOp();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:715:2: ( ^( FILTER rel cond[exprPlan] ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:715:4: ^( FILTER rel cond[exprPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER157=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause2129); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER157_tree = (CommonTree)adaptor.dupNode(FILTER157);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER157_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause2131);
            rel158=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel158.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause2133);
            cond159=cond(exprPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond159.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildFilterOp( new SourceLocation( (PigParserNode)FILTER157 ),
                       (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, exprPlan );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:723:1: cond[LogicalExpressionPlan exprPlan] returns [LogicalExpression expr] : ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | in_eval[$exprPlan] | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) );
    public final LogicalPlanGenerator.cond_return cond(LogicalExpressionPlan exprPlan) throws RecognitionException {
        LogicalPlanGenerator.cond_return retval = new LogicalPlanGenerator.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR160=null;
        CommonTree AND161=null;
        CommonTree NOT162=null;
        CommonTree NULL163=null;
        CommonTree NOT165=null;
        CommonTree STR_OP_MATCHES172=null;
        CommonTree BOOL_COND175=null;
        LogicalPlanGenerator.cond_return left =null;

        LogicalPlanGenerator.cond_return right =null;

        LogicalPlanGenerator.cond_return c =null;

        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.expr_return expr164 =null;

        LogicalPlanGenerator.rel_op_eq_return rel_op_eq166 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne167 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt168 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte169 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt170 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte171 =null;

        LogicalPlanGenerator.in_eval_return in_eval173 =null;

        LogicalPlanGenerator.func_eval_return func_eval174 =null;


        CommonTree OR160_tree=null;
        CommonTree AND161_tree=null;
        CommonTree NOT162_tree=null;
        CommonTree NULL163_tree=null;
        CommonTree NOT165_tree=null;
        CommonTree STR_OP_MATCHES172_tree=null;
        CommonTree BOOL_COND175_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:724:2: ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | in_eval[$exprPlan] | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) )
            int alt53=14;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt53=1;
                }
                break;
            case AND:
                {
                alt53=2;
                }
                break;
            case NOT:
                {
                alt53=3;
                }
                break;
            case NULL:
                {
                alt53=4;
                }
                break;
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt53=5;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt53=6;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt53=7;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt53=8;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt53=9;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt53=10;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt53=11;
                }
                break;
            case IN:
                {
                alt53=12;
                }
                break;
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt53=13;
                }
                break;
            case BOOL_COND:
                {
                alt53=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }

            switch (alt53) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:724:4: ^( OR left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR160=(CommonTree)match(input,OR,FOLLOW_OR_in_cond2157); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR160_tree = (CommonTree)adaptor.dupNode(OR160);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR160_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2163);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2170);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new OrExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)OR160 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:729:4: ^( AND left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND161=(CommonTree)match(input,AND,FOLLOW_AND_in_cond2185); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND161_tree = (CommonTree)adaptor.dupNode(AND161);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND161_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2191);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2198);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AndExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)AND161 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:734:4: ^( NOT c= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT162=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2213); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT162_tree = (CommonTree)adaptor.dupNode(NOT162);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT162_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2219);
                    c=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, c.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotExpression( exprPlan, (c!=null?c.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT162 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:739:4: ^( NULL expr[$exprPlan] ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL163=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond2234); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL163_tree = (CommonTree)adaptor.dupNode(NULL163);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL163_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2236);
                    expr164=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr164.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:739:28: ( NOT )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==NOT) ) {
                        alt52=1;
                    }
                    switch (alt52) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:739:28: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT165=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2239); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT165_tree = (CommonTree)adaptor.dupNode(NOT165);


                            adaptor.addChild(root_1, NOT165_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new IsNullExpression( exprPlan, (expr164!=null?expr164.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NULL163 ) );
                           if( NOT165 != null ) {
                               retval.expr = new NotExpression( exprPlan, retval.expr );
                               retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT165 ) );
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:748:4: ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_cond2254);
                    rel_op_eq166=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_eq166.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2260);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2267);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new EqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_eq166!=null?((CommonTree)rel_op_eq166.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:753:4: ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_cond2282);
                    rel_op_ne167=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_ne167.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2288);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2295);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_ne167!=null?((CommonTree)rel_op_ne167.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:758:4: ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_cond2310);
                    rel_op_lt168=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lt168.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2316);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2323);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lt168!=null?((CommonTree)rel_op_lt168.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:763:4: ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_cond2338);
                    rel_op_lte169=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lte169.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2344);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2351);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lte169!=null?((CommonTree)rel_op_lte169.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:768:4: ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_cond2366);
                    rel_op_gt170=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gt170.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2372);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2379);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gt170!=null?((CommonTree)rel_op_gt170.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:773:4: ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_cond2394);
                    rel_op_gte171=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gte171.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2400);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2407);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gte171!=null?((CommonTree)rel_op_gte171.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:778:4: ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES172=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_cond2422); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES172_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES172);


                    root_1 = (CommonTree)adaptor.becomeRoot(STR_OP_MATCHES172_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2428);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2435);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new RegexExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STR_OP_MATCHES172 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:783:4: in_eval[$exprPlan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond2448);
                    in_eval173=in_eval(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval173.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (in_eval173!=null?in_eval173.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:787:4: func_eval[$exprPlan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond2459);
                    func_eval174=func_eval(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval174.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval174!=null?func_eval174.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:791:4: ^( BOOL_COND e1= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND175=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond2472); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND175_tree = (CommonTree)adaptor.dupNode(BOOL_COND175);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND175_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2478);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = (e1!=null?e1.expr:null);
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)BOOL_COND175 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cond"


    public static class in_eval_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "in_eval"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:798:1: in_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( IN ( expr[$plan] )+ ) ;
    public final LogicalPlanGenerator.in_eval_return in_eval(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.in_eval_return retval = new LogicalPlanGenerator.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN176=null;
        LogicalPlanGenerator.expr_return expr177 =null;


        CommonTree IN176_tree=null;


            List<LogicalExpression> exprs = new ArrayList<LogicalExpression>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:802:2: ( ^( IN ( expr[$plan] )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:802:4: ^( IN ( expr[$plan] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN176=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval2507); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN176_tree = (CommonTree)adaptor.dupNode(IN176);


            root_1 = (CommonTree)adaptor.becomeRoot(IN176_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:802:10: ( expr[$plan] )+
            int cnt54=0;
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==BIGDECIMALNUMBER||LA54_0==BIGINTEGERNUMBER||LA54_0==CUBE||LA54_0==DIV||LA54_0==DOLLARVAR||LA54_0==DOUBLENUMBER||LA54_0==FALSE||LA54_0==FLOATNUMBER||LA54_0==GROUP||LA54_0==IDENTIFIER||LA54_0==INTEGER||LA54_0==LONGINTEGER||LA54_0==MINUS||LA54_0==NULL||LA54_0==PERCENT||LA54_0==PLUS||LA54_0==QUOTEDSTRING||LA54_0==STAR||LA54_0==TRUE||(LA54_0 >= BAG_VAL && LA54_0 <= BIN_EXPR)||(LA54_0 >= CASE_COND && LA54_0 <= CAST_EXPR)||LA54_0==EXPR_IN_PAREN||LA54_0==FUNC_EVAL||LA54_0==INVOKER_FUNC_EVAL||(LA54_0 >= MAP_VAL && LA54_0 <= NEG)||LA54_0==TUPLE_VAL) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:802:12: expr[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval2511);
            	    expr177=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, expr177.getTree());


            	    if ( state.backtracking==0 ) { exprs.add((expr177!=null?expr177.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt54 >= 1 ) break loop54;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(54, input);
                        throw eee;
                }
                cnt54++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert IN tree to nested or expressions. Please also see
                    // QueryParser.g for how IN tree is constructed from IN expression.
                    EqualExpression firstBoolExpr = new EqualExpression(plan, exprs.get(0), exprs.get(1));
                    if (exprs.size() == 2) {
                        retval.expr = firstBoolExpr;
                    } else {
                        OrExpression currOrExpr = null;
                        OrExpression prevOrExpr = null;
                        for (int i = 2; i < exprs.size(); i = i + 2) {
                            EqualExpression boolExpr = new EqualExpression(plan, exprs.get(i), exprs.get(i+1));
                            currOrExpr = new OrExpression( plan, prevOrExpr == null ? firstBoolExpr : prevOrExpr, boolExpr );
                            prevOrExpr = currOrExpr;
                        }
                        retval.expr = currOrExpr;
                    }
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "in_eval"


    public static class func_eval_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:823:1: func_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) | ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* ) );
    public final LogicalPlanGenerator.func_eval_return func_eval(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.func_eval_return retval = new LogicalPlanGenerator.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree package_name=null;
        CommonTree function_name=null;
        CommonTree is_static=null;
        CommonTree FUNC_EVAL178=null;
        CommonTree INVOKER_FUNC_EVAL181=null;
        LogicalPlanGenerator.func_name_return func_name179 =null;

        LogicalPlanGenerator.real_arg_return real_arg180 =null;

        LogicalPlanGenerator.real_arg_return real_arg182 =null;


        CommonTree package_name_tree=null;
        CommonTree function_name_tree=null;
        CommonTree is_static_tree=null;
        CommonTree FUNC_EVAL178_tree=null;
        CommonTree INVOKER_FUNC_EVAL181_tree=null;


            List<LogicalExpression> args = new ArrayList<LogicalExpression>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:827:2: ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) | ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==FUNC_EVAL) ) {
                alt57=1;
            }
            else if ( (LA57_0==INVOKER_FUNC_EVAL) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }
            switch (alt57) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:827:4: ^( FUNC_EVAL func_name ( real_arg[$plan] )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL178=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval2546); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL178_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL178);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL178_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval2548);
                    func_name179=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name179.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:827:27: ( real_arg[$plan] )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==BIGDECIMALNUMBER||LA55_0==BIGINTEGERNUMBER||LA55_0==CUBE||LA55_0==DIV||LA55_0==DOLLARVAR||LA55_0==DOUBLENUMBER||LA55_0==FALSE||LA55_0==FLOATNUMBER||LA55_0==GROUP||LA55_0==IDENTIFIER||LA55_0==INTEGER||LA55_0==LONGINTEGER||LA55_0==MINUS||LA55_0==NULL||LA55_0==PERCENT||LA55_0==PLUS||LA55_0==QUOTEDSTRING||LA55_0==STAR||LA55_0==TRUE||(LA55_0 >= BAG_VAL && LA55_0 <= BIN_EXPR)||(LA55_0 >= CASE_COND && LA55_0 <= EXPR_IN_PAREN)||LA55_0==FUNC_EVAL||LA55_0==INVOKER_FUNC_EVAL||(LA55_0 >= MAP_VAL && LA55_0 <= NEG)||LA55_0==TUPLE_VAL) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:827:29: real_arg[$plan]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval2552);
                    	    real_arg180=real_arg(plan);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg180.getTree());


                    	    if ( state.backtracking==0 ) { args.add( (real_arg180!=null?real_arg180.expr:null) ); }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)(func_name179!=null?((CommonTree)func_name179.start):null) );
                           retval.expr = builder.buildUDF( loc, plan, (func_name179!=null?func_name179.funcName:null), args );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:832:4: ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    INVOKER_FUNC_EVAL181=(CommonTree)match(input,INVOKER_FUNC_EVAL,FOLLOW_INVOKER_FUNC_EVAL_in_func_eval2572); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INVOKER_FUNC_EVAL181_tree = (CommonTree)adaptor.dupNode(INVOKER_FUNC_EVAL181);


                    root_1 = (CommonTree)adaptor.becomeRoot(INVOKER_FUNC_EVAL181_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    package_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2576); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    package_name_tree = (CommonTree)adaptor.dupNode(package_name);


                    adaptor.addChild(root_1, package_name_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    function_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2580); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    function_name_tree = (CommonTree)adaptor.dupNode(function_name);


                    adaptor.addChild(root_1, function_name_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    is_static=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2584); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    is_static_tree = (CommonTree)adaptor.dupNode(is_static);


                    adaptor.addChild(root_1, is_static_tree);
                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:832:95: ( real_arg[$plan] )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==BIGDECIMALNUMBER||LA56_0==BIGINTEGERNUMBER||LA56_0==CUBE||LA56_0==DIV||LA56_0==DOLLARVAR||LA56_0==DOUBLENUMBER||LA56_0==FALSE||LA56_0==FLOATNUMBER||LA56_0==GROUP||LA56_0==IDENTIFIER||LA56_0==INTEGER||LA56_0==LONGINTEGER||LA56_0==MINUS||LA56_0==NULL||LA56_0==PERCENT||LA56_0==PLUS||LA56_0==QUOTEDSTRING||LA56_0==STAR||LA56_0==TRUE||(LA56_0 >= BAG_VAL && LA56_0 <= BIN_EXPR)||(LA56_0 >= CASE_COND && LA56_0 <= EXPR_IN_PAREN)||LA56_0==FUNC_EVAL||LA56_0==INVOKER_FUNC_EVAL||(LA56_0 >= MAP_VAL && LA56_0 <= NEG)||LA56_0==TUPLE_VAL) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:832:97: real_arg[$plan]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval2588);
                    	    real_arg182=real_arg(plan);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg182.getTree());


                    	    if ( state.backtracking==0 ) { args.add( (real_arg182!=null?real_arg182.expr:null) ); }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)function_name );
                           retval.expr = builder.buildInvokerUDF( loc, plan, (package_name!=null?package_name.getText():null), (function_name!=null?function_name.getText():null), Boolean.parseBoolean((is_static!=null?is_static.getText():null)), args );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:839:1: real_arg[LogicalExpressionPlan plan] returns [LogicalExpression expr] : (e= expr[$plan] | STAR |cr= col_range[$plan] );
    public final LogicalPlanGenerator.real_arg_return real_arg(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.real_arg_return retval = new LogicalPlanGenerator.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR183=null;
        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.col_range_return cr =null;


        CommonTree STAR183_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:840:2: (e= expr[$plan] | STAR |cr= col_range[$plan] )
            int alt58=3;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt58=1;
                }
                break;
            case STAR:
                {
                int LA58_2 = input.LA(2);

                if ( (LA58_2==DOWN) ) {
                    alt58=1;
                }
                else if ( (LA58_2==EOF||LA58_2==UP||LA58_2==BIGDECIMALNUMBER||LA58_2==BIGINTEGERNUMBER||LA58_2==CUBE||LA58_2==DIV||LA58_2==DOLLARVAR||LA58_2==DOUBLENUMBER||LA58_2==FALSE||LA58_2==FLOATNUMBER||LA58_2==GROUP||LA58_2==IDENTIFIER||LA58_2==INTEGER||LA58_2==LONGINTEGER||LA58_2==MINUS||LA58_2==NULL||LA58_2==PERCENT||LA58_2==PLUS||LA58_2==QUOTEDSTRING||LA58_2==STAR||LA58_2==TRUE||(LA58_2 >= BAG_VAL && LA58_2 <= BIN_EXPR)||(LA58_2 >= CASE_COND && LA58_2 <= EXPR_IN_PAREN)||LA58_2==FUNC_EVAL||LA58_2==INVOKER_FUNC_EVAL||(LA58_2 >= MAP_VAL && LA58_2 <= NEG)||LA58_2==TUPLE_VAL) ) {
                    alt58=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt58=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }

            switch (alt58) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:840:4: e= expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg2620);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (e!=null?e.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:841:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR183=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg2628); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR183_tree = (CommonTree)adaptor.dupNode(STAR183);


                    adaptor.addChild(root_0, STAR183_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR183 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:846:4: cr= col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg2642);
                    cr=col_range(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cr.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (cr!=null?cr.expr:null);}

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:849:1: expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) );
    public final LogicalPlanGenerator.expr_return expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.expr_return retval = new LogicalPlanGenerator.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS184=null;
        CommonTree MINUS185=null;
        CommonTree STAR186=null;
        CommonTree DIV187=null;
        CommonTree PERCENT188=null;
        CommonTree NEG191=null;
        CommonTree CAST_EXPR192=null;
        CommonTree EXPR_IN_PAREN194=null;
        LogicalPlanGenerator.expr_return left =null;

        LogicalPlanGenerator.expr_return right =null;

        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.const_expr_return const_expr189 =null;

        LogicalPlanGenerator.var_expr_return var_expr190 =null;

        LogicalPlanGenerator.type_cast_return type_cast193 =null;


        CommonTree PLUS184_tree=null;
        CommonTree MINUS185_tree=null;
        CommonTree STAR186_tree=null;
        CommonTree DIV187_tree=null;
        CommonTree PERCENT188_tree=null;
        CommonTree NEG191_tree=null;
        CommonTree CAST_EXPR192_tree=null;
        CommonTree EXPR_IN_PAREN194_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:850:2: ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) )
            int alt59=10;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt59=1;
                }
                break;
            case MINUS:
                {
                int LA59_2 = input.LA(2);

                if ( (LA59_2==DOWN) ) {
                    alt59=2;
                }
                else if ( (LA59_2==BIGDECIMALNUMBER||LA59_2==BIGINTEGERNUMBER||LA59_2==DOUBLENUMBER||LA59_2==FLOATNUMBER||LA59_2==INTEGER||LA59_2==LONGINTEGER) ) {
                    alt59=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt59=3;
                }
                break;
            case DIV:
                {
                alt59=4;
                }
                break;
            case PERCENT:
                {
                alt59=5;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case NULL:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case MAP_VAL:
            case TUPLE_VAL:
                {
                alt59=6;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt59=7;
                }
                break;
            case NEG:
                {
                alt59=8;
                }
                break;
            case CAST_EXPR:
                {
                alt59=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt59=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }

            switch (alt59) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:850:4: ^( PLUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS184=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr2661); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS184_tree = (CommonTree)adaptor.dupNode(PLUS184);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS184_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2667);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2674);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AddExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PLUS184 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:855:4: ^( MINUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS185=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr2689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS185_tree = (CommonTree)adaptor.dupNode(MINUS185);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS185_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2695);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2702);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new SubtractExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)MINUS185 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:860:4: ^( STAR left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR186=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr2717); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR186_tree = (CommonTree)adaptor.dupNode(STAR186);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR186_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2723);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2730);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new MultiplyExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STAR186 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:865:4: ^( DIV left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV187=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2745); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV187_tree = (CommonTree)adaptor.dupNode(DIV187);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV187_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2751);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2758);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new DivideExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)DIV187 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:870:4: ^( PERCENT left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT188=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr2773); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT188_tree = (CommonTree)adaptor.dupNode(PERCENT188);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT188_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2779);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2786);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new ModExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PERCENT188 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:875:4: const_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr2799);
                    const_expr189=const_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr189.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (const_expr189!=null?const_expr189.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:879:4: var_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr2810);
                    var_expr190=var_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr190.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (var_expr190!=null?var_expr190.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:883:4: ^( NEG e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG191=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr2823); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG191_tree = (CommonTree)adaptor.dupNode(NEG191);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG191_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2829);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NegativeExpression( plan, (e!=null?e.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(e!=null?((CommonTree)e.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:888:4: ^( CAST_EXPR type_cast e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR192=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2844); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR192_tree = (CommonTree)adaptor.dupNode(CAST_EXPR192);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR192_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr2846);
                    type_cast193=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast193.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2852);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new CastExpression( plan, (e!=null?e.expr:null), (type_cast193!=null?type_cast193.fieldSchema:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(type_cast193!=null?((CommonTree)type_cast193.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:893:4: ^( EXPR_IN_PAREN e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN194=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr2868); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN194_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN194);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN194_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2874);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = (e!=null?e.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class type_cast_return extends TreeRuleReturnScope {
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:899:1: type_cast returns [LogicalFieldSchema fieldSchema] : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final LogicalPlanGenerator.type_cast_return type_cast() throws RecognitionException {
        LogicalPlanGenerator.type_cast_return retval = new LogicalPlanGenerator.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type195 =null;

        LogicalPlanGenerator.map_type_return map_type196 =null;

        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast197 =null;

        LogicalPlanGenerator.bag_type_cast_return bag_type_cast198 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:900:2: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt60=4;
            switch ( input.LA(1) ) {
            case BIGDECIMAL:
            case BIGINTEGER:
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt60=1;
                }
                break;
            case MAP_TYPE:
                {
                alt60=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt60=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt60=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }

            switch (alt60) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:900:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast2896);
                    simple_type195=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type195.getTree());


                    if ( state.backtracking==0 ) {
                            retval.fieldSchema = new LogicalFieldSchema( null, null, (simple_type195!=null?simple_type195.datatype:0) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:904:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast2906);
                    map_type196=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type196.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (map_type196!=null?map_type196.logicalSchema:null), DataType.MAP );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:908:4: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast2916);
                    tuple_type_cast197=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast197.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (tuple_type_cast197!=null?tuple_type_cast197.logicalSchema:null), DataType.TUPLE );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:912:4: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast2926);
                    bag_type_cast198=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast198.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (bag_type_cast198!=null?bag_type_cast198.logicalSchema:null), DataType.BAG );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type_cast"


    public static class tuple_type_cast_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:918:1: tuple_type_cast returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_cast_return retval = new LogicalPlanGenerator.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST199=null;
        LogicalPlanGenerator.type_cast_return type_cast200 =null;


        CommonTree TUPLE_TYPE_CAST199_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:922:2: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:922:4: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST199=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2951); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST199_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST199);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST199_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:922:23: ( type_cast )*
                loop61:
                do {
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==BIGDECIMAL||LA61_0==BIGINTEGER||LA61_0==BOOLEAN||LA61_0==BYTEARRAY||LA61_0==CHARARRAY||LA61_0==DATETIME||LA61_0==DOUBLE||LA61_0==FLOAT||LA61_0==INT||LA61_0==LONG||LA61_0==BAG_TYPE_CAST||LA61_0==MAP_TYPE||LA61_0==TUPLE_TYPE_CAST) ) {
                        alt61=1;
                    }


                    switch (alt61) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:922:25: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2955);
                	    type_cast200=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast200.getTree());


                	    if ( state.backtracking==0 ) { retval.logicalSchema.addField( (type_cast200!=null?type_cast200.fieldSchema:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop61;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type_cast"


    public static class bag_type_cast_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:925:1: bag_type_cast returns [LogicalSchema logicalSchema] : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final LogicalPlanGenerator.bag_type_cast_return bag_type_cast() throws RecognitionException {
        LogicalPlanGenerator.bag_type_cast_return retval = new LogicalPlanGenerator.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST201=null;
        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast202 =null;


        CommonTree BAG_TYPE_CAST201_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:929:2: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:929:4: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST201=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2982); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST201_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST201);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST201_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:929:21: ( tuple_type_cast )?
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==TUPLE_TYPE_CAST) ) {
                    alt62=1;
                }
                switch (alt62) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:929:21: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast2984);
                        tuple_type_cast202=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast202.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.logicalSchema.addField( new LogicalFieldSchema( null, (tuple_type_cast202!=null?tuple_type_cast202.logicalSchema:null), DataType.TUPLE ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:935:1: var_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : projectable_expr[$plan] ( dot_proj | pound_proj )* ;
    public final LogicalPlanGenerator.var_expr_return var_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.var_expr_return retval = new LogicalPlanGenerator.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.projectable_expr_return projectable_expr203 =null;

        LogicalPlanGenerator.dot_proj_return dot_proj204 =null;

        LogicalPlanGenerator.pound_proj_return pound_proj205 =null;




            List<Object> columns = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:940:2: ( projectable_expr[$plan] ( dot_proj | pound_proj )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:940:4: projectable_expr[$plan] ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr3011);
            projectable_expr203=projectable_expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr203.getTree());


            if ( state.backtracking==0 ) { retval.expr = (projectable_expr203!=null?projectable_expr203.expr:null); }

            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:941:4: ( dot_proj | pound_proj )*
            loop63:
            do {
                int alt63=3;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==PERIOD) ) {
                    alt63=1;
                }
                else if ( (LA63_0==POUND) ) {
                    alt63=2;
                }


                switch (alt63) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:941:6: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr3021);
            	    dot_proj204=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj204.getTree());


            	    if ( state.backtracking==0 ) {
            	             columns = (dot_proj204!=null?dot_proj204.cols:null);
            	             boolean processScalar = false;
            	             if( retval.expr instanceof ScalarExpression ) {
            	                 List<Operator> succs = plan.getSuccessors( retval.expr );
            	                 if( succs == null || succs.size() == 0 ) {
            	                     // We haven't process this scalar projection yet. Set the flag so as to process it next.
            	                     // This will handle a projection such as A.u.x, where we need to build ScalarExpression
            	                     // for A.u, while for x, we need to treat it as a normal dereference (on the output of
            	                     // the ScalarExpression.
            	                     processScalar = true;
            	                 }
            	             }

            	             if( processScalar ) {
            	                 // This is a scalar projection.
            	                 ScalarExpression scalarExpr = (ScalarExpression)retval.expr;

            	                 if( (dot_proj204!=null?dot_proj204.cols:null).size() > 1 ) {
            	                     throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                 }

            	                 Object val = (dot_proj204!=null?dot_proj204.cols:null).get( 0 );
            	                 int pos = -1;
            	                 LogicalRelationalOperator relOp = (LogicalRelationalOperator)scalarExpr.getImplicitReferencedOperator();
            	                 LogicalSchema schema = null;
            	                 try {
            	                     schema = relOp.getSchema();
            	                 } catch(FrontendException e) {
            	                     throw new PlanGenerationFailureException( input, loc, e );
            	                 }
            	                 if( val instanceof Integer ) {
            	                     pos = (Integer)val;
            	                     if( schema != null && pos >= schema.size() ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 } else {
            	                     String colAlias = (String)val;
            	                     pos = schema.getFieldPosition( colAlias );
            	                     if( schema == null || pos == -1 ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 }

            	                 ConstantExpression constExpr = new ConstantExpression( plan, pos);
            	                 plan.connect( retval.expr, constExpr );
            	                 constExpr = new ConstantExpression( plan, "filename"); // place holder for file name.
            	                 plan.connect( retval.expr, constExpr );
            	             } else {
            	                 DereferenceExpression e = new DereferenceExpression( plan );
            	                 e.setRawColumns( (dot_proj204!=null?dot_proj204.cols:null) );
            	                 e.setLocation( new SourceLocation( (PigParserNode)(dot_proj204!=null?((CommonTree)dot_proj204.start):null) ) );
            	                 plan.connect( e, retval.expr );
            	                 retval.expr = e;
            	             }
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:998:6: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr3035);
            	    pound_proj205=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj205.getTree());


            	    if ( state.backtracking==0 ) {
            	             MapLookupExpression e = new MapLookupExpression( plan, (pound_proj205!=null?pound_proj205.key:null) );
            	             e.setLocation( new SourceLocation( (PigParserNode)(pound_proj205!=null?((CommonTree)pound_proj205.start):null) ) );
            	             plan.connect( e, retval.expr );
            	             retval.expr = e;
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                  if( ( retval.expr instanceof ScalarExpression ) && columns == null ) {
                      throw new InvalidScalarProjectionException( input, loc, (ScalarExpression)retval.expr, " : A column needs to be projected from a relation for it to be used as a scalar" );
                  }
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1013:1: projectable_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] | case_expr[$plan] | case_cond[$plan] );
    public final LogicalPlanGenerator.projectable_expr_return projectable_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.projectable_expr_return retval = new LogicalPlanGenerator.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.func_eval_return func_eval206 =null;

        LogicalPlanGenerator.col_ref_return col_ref207 =null;

        LogicalPlanGenerator.bin_expr_return bin_expr208 =null;

        LogicalPlanGenerator.case_expr_return case_expr209 =null;

        LogicalPlanGenerator.case_cond_return case_cond210 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1014:2: ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] | case_expr[$plan] | case_cond[$plan] )
            int alt64=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt64=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt64=2;
                }
                break;
            case BIN_EXPR:
                {
                alt64=3;
                }
                break;
            case CASE_EXPR:
                {
                alt64=4;
                }
                break;
            case CASE_COND:
                {
                alt64=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;

            }

            switch (alt64) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1014:4: func_eval[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr3065);
                    func_eval206=func_eval(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval206.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval206!=null?func_eval206.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1018:4: col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr3076);
                    col_ref207=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref207.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (col_ref207!=null?col_ref207.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1022:4: bin_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr3087);
                    bin_expr208=bin_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr208.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (bin_expr208!=null?bin_expr208.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1026:4: case_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr3098);
                    case_expr209=case_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr209.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (case_expr209!=null?case_expr209.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1030:4: case_cond[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr3109);
                    case_cond210=case_cond(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond210.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (case_cond210!=null?case_cond210.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "projectable_expr"


    public static class dot_proj_return extends TreeRuleReturnScope {
        public List<Object> cols;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1036:1: dot_proj returns [List<Object> cols] : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final LogicalPlanGenerator.dot_proj_return dot_proj() throws RecognitionException {
        LogicalPlanGenerator.dot_proj_return retval = new LogicalPlanGenerator.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD211=null;
        LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index212 =null;


        CommonTree PERIOD211_tree=null;


            retval.cols = new ArrayList<Object>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1040:2: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1040:4: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD211=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj3135); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD211_tree = (CommonTree)adaptor.dupNode(PERIOD211);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD211_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1040:14: ( col_alias_or_index )+
            int cnt65=0;
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==CUBE||LA65_0==DOLLARVAR||LA65_0==GROUP||LA65_0==IDENTIFIER) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1040:16: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj3139);
            	    col_alias_or_index212=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index212.getTree());


            	    if ( state.backtracking==0 ) { retval.cols.add( (col_alias_or_index212!=null?col_alias_or_index212.col:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt65 >= 1 ) break loop65;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(65, input);
                        throw eee;
                }
                cnt65++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dot_proj"


    public static class col_alias_or_index_return extends TreeRuleReturnScope {
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1043:1: col_alias_or_index returns [Object col] : ( col_alias | col_index );
    public final LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        LogicalPlanGenerator.col_alias_or_index_return retval = new LogicalPlanGenerator.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_alias_return col_alias213 =null;

        LogicalPlanGenerator.col_index_return col_index214 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1044:2: ( col_alias | col_index )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==CUBE||LA66_0==GROUP||LA66_0==IDENTIFIER) ) {
                alt66=1;
            }
            else if ( (LA66_0==DOLLARVAR) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }
            switch (alt66) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1044:4: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index3159);
                    col_alias213=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias213.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_alias213!=null?col_alias213.col:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1044:43: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index3165);
                    col_index214=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index214.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_index214!=null?col_index214.col:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias_or_index"


    public static class col_alias_return extends TreeRuleReturnScope {
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1047:1: col_alias returns [Object col] : ( GROUP | CUBE | IDENTIFIER );
    public final LogicalPlanGenerator.col_alias_return col_alias() throws RecognitionException {
        LogicalPlanGenerator.col_alias_return retval = new LogicalPlanGenerator.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP215=null;
        CommonTree CUBE216=null;
        CommonTree IDENTIFIER217=null;

        CommonTree GROUP215_tree=null;
        CommonTree CUBE216_tree=null;
        CommonTree IDENTIFIER217_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1048:2: ( GROUP | CUBE | IDENTIFIER )
            int alt67=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt67=1;
                }
                break;
            case CUBE:
                {
                alt67=2;
                }
                break;
            case IDENTIFIER:
                {
                alt67=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }

            switch (alt67) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1048:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP215=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_col_alias3180); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP215_tree = (CommonTree)adaptor.dupNode(GROUP215);


                    adaptor.addChild(root_0, GROUP215_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (GROUP215!=null?GROUP215.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1049:4: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE216=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_col_alias3187); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE216_tree = (CommonTree)adaptor.dupNode(CUBE216);


                    adaptor.addChild(root_0, CUBE216_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (CUBE216!=null?CUBE216.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1050:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER217=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_col_alias3194); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER217_tree = (CommonTree)adaptor.dupNode(IDENTIFIER217);


                    adaptor.addChild(root_0, IDENTIFIER217_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (IDENTIFIER217!=null?IDENTIFIER217.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        public Integer col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1053:1: col_index returns [Integer col] : DOLLARVAR ;
    public final LogicalPlanGenerator.col_index_return col_index() throws RecognitionException {
        LogicalPlanGenerator.col_index_return retval = new LogicalPlanGenerator.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR218=null;

        CommonTree DOLLARVAR218_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1054:2: ( DOLLARVAR )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1054:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR218=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index3209); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR218_tree = (CommonTree)adaptor.dupNode(DOLLARVAR218);


            adaptor.addChild(root_0, DOLLARVAR218_tree);
            }


            if ( state.backtracking==0 ) { retval.col = builder.undollar( (DOLLARVAR218!=null?DOLLARVAR218.getText():null) ); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_index"


    public static class col_range_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1058:1: col_range[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) ;
    public final LogicalPlanGenerator.col_range_return col_range(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_range_return retval = new LogicalPlanGenerator.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE219=null;
        CommonTree DOUBLE_PERIOD220=null;
        LogicalPlanGenerator.col_ref_return startExpr =null;

        LogicalPlanGenerator.col_ref_return endExpr =null;


        CommonTree COL_RANGE219_tree=null;
        CommonTree DOUBLE_PERIOD220_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1059:2: ( ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1059:5: ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE219=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range3228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE219_tree = (CommonTree)adaptor.dupNode(COL_RANGE219);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE219_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1059:17: (startExpr= col_ref[$plan] )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==CUBE||LA68_0==DOLLARVAR||LA68_0==GROUP||LA68_0==IDENTIFIER) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1059:18: startExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range3235);
                    startExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, startExpr.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD220=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range3240); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD220_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD220);


            adaptor.addChild(root_1, DOUBLE_PERIOD220_tree);
            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1059:61: (endExpr= col_ref[$plan] )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==CUBE||LA69_0==DOLLARVAR||LA69_0==GROUP||LA69_0==IDENTIFIER) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1059:62: endExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range3247);
                    endExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, endExpr.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                    retval.expr = builder.buildRangeProjectExpr(
                                loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                ((statement_scope)statement_stack.peek()).inputIndex,
                                (startExpr!=null?startExpr.expr:null),
                                (endExpr!=null?endExpr.expr:null)
                            );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_range"


    public static class pound_proj_return extends TreeRuleReturnScope {
        public String key;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1071:1: pound_proj returns [String key] : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final LogicalPlanGenerator.pound_proj_return pound_proj() throws RecognitionException {
        LogicalPlanGenerator.pound_proj_return retval = new LogicalPlanGenerator.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND221=null;
        CommonTree QUOTEDSTRING222=null;
        CommonTree NULL223=null;

        CommonTree POUND221_tree=null;
        CommonTree QUOTEDSTRING222_tree=null;
        CommonTree NULL223_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1072:2: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1072:4: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND221=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj3273); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND221_tree = (CommonTree)adaptor.dupNode(POUND221);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND221_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1072:13: ( QUOTEDSTRING | NULL )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==QUOTEDSTRING) ) {
                alt70=1;
            }
            else if ( (LA70_0==NULL) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }
            switch (alt70) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1072:15: QUOTEDSTRING
                    {
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING222=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_pound_proj3277); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING222_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING222);


                    adaptor.addChild(root_1, QUOTEDSTRING222_tree);
                    }


                    if ( state.backtracking==0 ) { retval.key = builder.unquote( (QUOTEDSTRING222!=null?QUOTEDSTRING222.getText():null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1072:80: NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    NULL223=(CommonTree)match(input,NULL,FOLLOW_NULL_in_pound_proj3283); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL223_tree = (CommonTree)adaptor.dupNode(NULL223);


                    adaptor.addChild(root_1, NULL223_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pound_proj"


    public static class bin_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1075:1: bin_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) ;
    public final LogicalPlanGenerator.bin_expr_return bin_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.bin_expr_return retval = new LogicalPlanGenerator.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR224=null;
        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.cond_return cond225 =null;


        CommonTree BIN_EXPR224_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1076:2: ( ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1076:4: ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR224=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr3303); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR224_tree = (CommonTree)adaptor.dupNode(BIN_EXPR224);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR224_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr3305);
            cond225=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond225.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr3312);
            e1=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e1.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr3319);
            e2=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e2.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.expr = new BinCondExpression( plan, (cond225!=null?cond225.expr:null), (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bin_expr"


    public static class case_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1083:1: case_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( CASE_EXPR ( expr[$plan] )+ ) ;
    public final LogicalPlanGenerator.case_expr_return case_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.case_expr_return retval = new LogicalPlanGenerator.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR226=null;
        LogicalPlanGenerator.expr_return expr227 =null;


        CommonTree CASE_EXPR226_tree=null;


            List<LogicalExpression> exprs = new ArrayList<LogicalExpression>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1087:2: ( ^( CASE_EXPR ( expr[$plan] )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1087:4: ^( CASE_EXPR ( expr[$plan] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR226=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr3348); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR226_tree = (CommonTree)adaptor.dupNode(CASE_EXPR226);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR226_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1087:17: ( expr[$plan] )+
            int cnt71=0;
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==BIGDECIMALNUMBER||LA71_0==BIGINTEGERNUMBER||LA71_0==CUBE||LA71_0==DIV||LA71_0==DOLLARVAR||LA71_0==DOUBLENUMBER||LA71_0==FALSE||LA71_0==FLOATNUMBER||LA71_0==GROUP||LA71_0==IDENTIFIER||LA71_0==INTEGER||LA71_0==LONGINTEGER||LA71_0==MINUS||LA71_0==NULL||LA71_0==PERCENT||LA71_0==PLUS||LA71_0==QUOTEDSTRING||LA71_0==STAR||LA71_0==TRUE||(LA71_0 >= BAG_VAL && LA71_0 <= BIN_EXPR)||(LA71_0 >= CASE_COND && LA71_0 <= CAST_EXPR)||LA71_0==EXPR_IN_PAREN||LA71_0==FUNC_EVAL||LA71_0==INVOKER_FUNC_EVAL||(LA71_0 >= MAP_VAL && LA71_0 <= NEG)||LA71_0==TUPLE_VAL) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1087:19: expr[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr3352);
            	    expr227=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, expr227.getTree());


            	    if ( state.backtracking==0 ) { exprs.add((expr227!=null?expr227.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt71 >= 1 ) break loop71;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(71, input);
                        throw eee;
                }
                cnt71++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert CASE tree to nested bincond expressions. Please also see
                    // QueryParser.g for how CASE tree is constructed from case statement.
                    boolean hasElse = exprs.size() % 3 == 1;
                    LogicalExpression elseExpr = hasElse ? exprs.get(exprs.size()-1)
                                                         : new ConstantExpression(plan, null);

                    int numWhenBranches = exprs.size() / 3;
                    BinCondExpression prevBinCondExpr = null;
                    BinCondExpression currBinCondExpr = null;
                    for (int i = 0; i < numWhenBranches; i++) {
                        currBinCondExpr = new BinCondExpression( plan,
                            new EqualExpression( plan, exprs.get(3*i), exprs.get(3*i+1) ), exprs.get(3*i+2),
                            prevBinCondExpr == null ? elseExpr : prevBinCondExpr);
                        prevBinCondExpr = currBinCondExpr;
                    }
                    retval.expr = currBinCondExpr;
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "case_expr"


    public static class case_cond_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_cond"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1109:1: case_cond[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) ) ;
    public final LogicalPlanGenerator.case_cond_return case_cond(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.case_cond_return retval = new LogicalPlanGenerator.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND228=null;
        CommonTree WHEN229=null;
        CommonTree THEN231=null;
        LogicalPlanGenerator.cond_return cond230 =null;

        LogicalPlanGenerator.expr_return expr232 =null;


        CommonTree CASE_COND228_tree=null;
        CommonTree WHEN229_tree=null;
        CommonTree THEN231_tree=null;


            List<LogicalExpression> conds = new ArrayList<LogicalExpression>();
            List<LogicalExpression> exprs = new ArrayList<LogicalExpression>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1114:2: ( ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1114:4: ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND228=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond3387); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND228_tree = (CommonTree)adaptor.dupNode(CASE_COND228);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND228_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN229=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond3391); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN229_tree = (CommonTree)adaptor.dupNode(WHEN229);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN229_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1114:25: ( cond[$plan] )+
            int cnt72=0;
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==AND||LA72_0==IN||(LA72_0 >= NOT && LA72_0 <= NUM_OP_NE)||LA72_0==OR||(LA72_0 >= STR_OP_EQ && LA72_0 <= STR_OP_NE)||LA72_0==BOOL_COND||LA72_0==FUNC_EVAL||LA72_0==INVOKER_FUNC_EVAL) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1114:27: cond[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond3395);
            	    cond230=cond(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond230.getTree());


            	    if ( state.backtracking==0 ) { conds.add((cond230!=null?cond230.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt72 >= 1 ) break loop72;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(72, input);
                        throw eee;
                }
                cnt72++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            THEN231=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond3423); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN231_tree = (CommonTree)adaptor.dupNode(THEN231);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN231_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1115:25: ( expr[$plan] )+
            int cnt73=0;
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==BIGDECIMALNUMBER||LA73_0==BIGINTEGERNUMBER||LA73_0==CUBE||LA73_0==DIV||LA73_0==DOLLARVAR||LA73_0==DOUBLENUMBER||LA73_0==FALSE||LA73_0==FLOATNUMBER||LA73_0==GROUP||LA73_0==IDENTIFIER||LA73_0==INTEGER||LA73_0==LONGINTEGER||LA73_0==MINUS||LA73_0==NULL||LA73_0==PERCENT||LA73_0==PLUS||LA73_0==QUOTEDSTRING||LA73_0==STAR||LA73_0==TRUE||(LA73_0 >= BAG_VAL && LA73_0 <= BIN_EXPR)||(LA73_0 >= CASE_COND && LA73_0 <= CAST_EXPR)||LA73_0==EXPR_IN_PAREN||LA73_0==FUNC_EVAL||LA73_0==INVOKER_FUNC_EVAL||(LA73_0 >= MAP_VAL && LA73_0 <= NEG)||LA73_0==TUPLE_VAL) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1115:27: expr[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond3427);
            	    expr232=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr232.getTree());


            	    if ( state.backtracking==0 ) { exprs.add((expr232!=null?expr232.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt73 >= 1 ) break loop73;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(73, input);
                        throw eee;
                }
                cnt73++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert CASE tree to nested bincond expressions. Please also see
                    // QueryParser.g for how CASE tree is constructed from case statement.
                    boolean hasElse = exprs.size() != conds.size();
                    LogicalExpression elseExpr = hasElse ? exprs.get(exprs.size() - 1)
                                                         : new ConstantExpression(plan, null);
                    int numWhenBranches = conds.size();
                    BinCondExpression prevBinCondExpr = null;
                    BinCondExpression currBinCondExpr = null;
                    for (int i = 0; i < numWhenBranches; i++) {
                        currBinCondExpr = new BinCondExpression( plan,
                            conds.get(i), exprs.get(i),
                            prevBinCondExpr == null ? elseExpr : prevBinCondExpr);
                        prevBinCondExpr = currBinCondExpr;
                    }
                    retval.expr = currBinCondExpr;
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
                }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "case_cond"


    public static class limit_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1136:1: limit_clause returns [String alias] : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.limit_clause_return limit_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.limit_clause_return retval = new LogicalPlanGenerator.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT233=null;
        CommonTree INTEGER235=null;
        CommonTree LONGINTEGER236=null;
        LogicalPlanGenerator.rel_return rel234 =null;

        LogicalPlanGenerator.expr_return expr237 =null;


        CommonTree LIMIT233_tree=null;
        CommonTree INTEGER235_tree=null;
        CommonTree LONGINTEGER236_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createLimitOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1142:2: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1142:5: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT233=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause3469); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT233_tree = (CommonTree)adaptor.dupNode(LIMIT233);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT233_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause3471);
            rel234=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel234.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1142:18: ( INTEGER | LONGINTEGER | expr[exprPlan] )
            int alt74=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA74_1 = input.LA(2);

                if ( (synpred141_LogicalPlanGenerator()) ) {
                    alt74=1;
                }
                else if ( (true) ) {
                    alt74=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA74_2 = input.LA(2);

                if ( (synpred142_LogicalPlanGenerator()) ) {
                    alt74=2;
                }
                else if ( (true) ) {
                    alt74=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 2, input);

                    throw nvae;

                }
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case STAR:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt74=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;

            }

            switch (alt74) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1142:20: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER235=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause3475); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER235_tree = (CommonTree)adaptor.dupNode(INTEGER235);


                    adaptor.addChild(root_1, INTEGER235_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT233 ),
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, Long.valueOf( (INTEGER235!=null?INTEGER235.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1147:4: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER236=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause3485); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER236_tree = (CommonTree)adaptor.dupNode(LONGINTEGER236);


                    adaptor.addChild(root_1, LONGINTEGER236_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT233 ),
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, builder.parseLong( (LONGINTEGER236!=null?LONGINTEGER236.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1152:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause3495);
                    expr237=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr237.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT233 ),
                               (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1160:1: sample_clause returns [String alias] : ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.sample_clause_return sample_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.sample_clause_return retval = new LogicalPlanGenerator.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE238=null;
        CommonTree DOUBLENUMBER240=null;
        LogicalPlanGenerator.rel_return rel239 =null;

        LogicalPlanGenerator.expr_return expr241 =null;


        CommonTree SAMPLE238_tree=null;
        CommonTree DOUBLENUMBER240_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSampleOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1166:2: ( ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1166:4: ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE238=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause3531); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE238_tree = (CommonTree)adaptor.dupNode(SAMPLE238);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE238_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause3533);
            rel239=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel239.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1166:18: ( DOUBLENUMBER | expr[exprPlan] )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==DOUBLENUMBER) ) {
                int LA75_1 = input.LA(2);

                if ( (synpred143_LogicalPlanGenerator()) ) {
                    alt75=1;
                }
                else if ( (true) ) {
                    alt75=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA75_0==BIGDECIMALNUMBER||LA75_0==BIGINTEGERNUMBER||LA75_0==CUBE||LA75_0==DIV||LA75_0==DOLLARVAR||LA75_0==FALSE||LA75_0==FLOATNUMBER||LA75_0==GROUP||LA75_0==IDENTIFIER||LA75_0==INTEGER||LA75_0==LONGINTEGER||LA75_0==MINUS||LA75_0==NULL||LA75_0==PERCENT||LA75_0==PLUS||LA75_0==QUOTEDSTRING||LA75_0==STAR||LA75_0==TRUE||(LA75_0 >= BAG_VAL && LA75_0 <= BIN_EXPR)||(LA75_0 >= CASE_COND && LA75_0 <= CAST_EXPR)||LA75_0==EXPR_IN_PAREN||LA75_0==FUNC_EVAL||LA75_0==INVOKER_FUNC_EVAL||(LA75_0 >= MAP_VAL && LA75_0 <= NEG)||LA75_0==TUPLE_VAL) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }
            switch (alt75) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1166:20: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER240=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause3537); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER240_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER240);


                    adaptor.addChild(root_1, DOUBLENUMBER240_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE238 ), ((statement_scope)statement_stack.peek()).alias,
                               ((statement_scope)statement_stack.peek()).inputAlias, Double.valueOf( (DOUBLENUMBER240!=null?DOUBLENUMBER240.getText():null) ),
                               new SourceLocation( (PigParserNode)DOUBLENUMBER240 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1172:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause3547);
                    expr241=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr241.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE238 ),
                               (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan, (expr241!=null?expr241.expr:null));
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "sample_clause"


    protected static class rank_clause_scope {
        LORank rankOp;
    }
    protected Stack rank_clause_stack = new Stack();


    public static class rank_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1180:1: rank_clause returns [String alias] : ^( RANK rel ( rank_by_statement )? ) ;
    public final LogicalPlanGenerator.rank_clause_return rank_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        rank_clause_stack.push(new rank_clause_scope());
        LogicalPlanGenerator.rank_clause_return retval = new LogicalPlanGenerator.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK242=null;
        LogicalPlanGenerator.rel_return rel243 =null;

        LogicalPlanGenerator.rank_by_statement_return rank_by_statement244 =null;


        CommonTree RANK242_tree=null;


        	((GScope_scope)GScope_stack.peek()).currentOp = builder.createRankOp();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1190:2: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1190:4: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK242=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause3593); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK242_tree = (CommonTree)adaptor.dupNode(RANK242);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK242_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause3595);
            rel243=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel243.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1190:16: ( rank_by_statement )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==BY) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1190:16: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause3597);
                    rank_by_statement244=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement244.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	SourceLocation loc = new SourceLocation( (PigParserNode) ((CommonTree)retval.start) );

            	List<LogicalExpressionPlan> tempPlans = (rank_by_statement244!=null?rank_by_statement244.plans:null);
            	List<Boolean> tempAscFlags = (rank_by_statement244!=null?rank_by_statement244.ascFlags:null);

            	if(tempPlans == null && tempAscFlags == null) {
            		tempPlans = new ArrayList<LogicalExpressionPlan>();
            		tempAscFlags = new ArrayList<Boolean>();

            		((LORank)((GScope_scope)GScope_stack.peek()).currentOp).setIsRowNumber( true );
            	}

            	((LORank)((GScope_scope)GScope_stack.peek()).currentOp).setIsDenseRank( (rank_by_statement244!=null?rank_by_statement244.isDenseRank:null) != null?(rank_by_statement244!=null?rank_by_statement244.isDenseRank:null):false );

            	retval.alias = builder.buildRankOp( loc, (LORank)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, tempPlans, tempAscFlags );
             }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            rank_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "rank_clause"


    public static class rank_by_statement_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        public Boolean isDenseRank;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_statement"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1210:1: rank_by_statement returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags, Boolean isDenseRank] : ^( BY rank_by_clause ( DENSE )? ) ;
    public final LogicalPlanGenerator.rank_by_statement_return rank_by_statement() throws RecognitionException {
        LogicalPlanGenerator.rank_by_statement_return retval = new LogicalPlanGenerator.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY245=null;
        CommonTree DENSE247=null;
        LogicalPlanGenerator.rank_by_clause_return rank_by_clause246 =null;


        CommonTree BY245_tree=null;
        CommonTree DENSE247_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();
            retval.isDenseRank = false;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1216:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1216:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY245=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement3623); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY245_tree = (CommonTree)adaptor.dupNode(BY245);


            root_1 = (CommonTree)adaptor.becomeRoot(BY245_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement3625);
            rank_by_clause246=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause246.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1216:25: ( DENSE )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==DENSE) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1216:27: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE247=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement3629); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE247_tree = (CommonTree)adaptor.dupNode(DENSE247);


                    adaptor.addChild(root_1, DENSE247_tree);
                    }


                    if ( state.backtracking==0 ) { retval.isDenseRank =  true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	retval.plans = (rank_by_clause246!=null?rank_by_clause246.plans:null);
            	retval.ascFlags = (rank_by_clause246!=null?rank_by_clause246.ascFlags:null);
             }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_statement"


    public static class rank_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1223:1: rank_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final LogicalPlanGenerator.rank_by_clause_return rank_by_clause() throws RecognitionException {
        LogicalPlanGenerator.rank_by_clause_return retval = new LogicalPlanGenerator.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR248=null;
        CommonTree ASC249=null;
        CommonTree DESC250=null;
        LogicalPlanGenerator.rank_col_return rank_col251 =null;


        CommonTree STAR248_tree=null;
        CommonTree ASC249_tree=null;
        CommonTree DESC250_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1228:2: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==STAR) ) {
                alt80=1;
            }
            else if ( (LA80_0==CUBE||LA80_0==DOLLARVAR||LA80_0==GROUP||LA80_0==IDENTIFIER||LA80_0==COL_RANGE) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;

            }
            switch (alt80) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1228:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR248=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause3658); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR248_tree = (CommonTree)adaptor.dupNode(STAR248);


                    adaptor.addChild(root_0, STAR248_tree);
                    }


                    if ( state.backtracking==0 ) {
                    		LogicalExpressionPlan plan = new LogicalExpressionPlan();
                    		builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR248 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                    		retval.plans.add( plan );
                       }

                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1233:4: ( ASC | DESC )?
                    int alt78=3;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==ASC) ) {
                        alt78=1;
                    }
                    else if ( (LA78_0==DESC) ) {
                        alt78=2;
                    }
                    switch (alt78) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1233:6: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC249=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_by_clause3667); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC249_tree = (CommonTree)adaptor.dupNode(ASC249);


                            adaptor.addChild(root_0, ASC249_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1233:39: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC250=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_by_clause3673); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC250_tree = (CommonTree)adaptor.dupNode(DESC250);


                            adaptor.addChild(root_0, DESC250_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1234:4: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1234:4: ( rank_col )+
                    int cnt79=0;
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==CUBE||LA79_0==DOLLARVAR||LA79_0==GROUP||LA79_0==IDENTIFIER||LA79_0==COL_RANGE) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1234:6: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause3685);
                    	    rank_col251=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col251.getTree());


                    	    if ( state.backtracking==0 ) {
                    	           retval.plans.add( (rank_col251!=null?rank_col251.plan:null) );
                    	           retval.ascFlags.add( (rank_col251!=null?rank_col251.ascFlag:null) );
                    	       }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt79 >= 1 ) break loop79;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(79, input);
                                throw eee;
                        }
                        cnt79++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_clause"


    public static class rank_col_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public Boolean ascFlag;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_col"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1241:1: rank_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
    public final LogicalPlanGenerator.rank_col_return rank_col() throws RecognitionException {
        LogicalPlanGenerator.rank_col_return retval = new LogicalPlanGenerator.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC253=null;
        CommonTree DESC254=null;
        CommonTree ASC256=null;
        CommonTree DESC257=null;
        LogicalPlanGenerator.col_range_return col_range252 =null;

        LogicalPlanGenerator.col_ref_return col_ref255 =null;


        CommonTree ASC253_tree=null;
        CommonTree DESC254_tree=null;
        CommonTree ASC256_tree=null;
        CommonTree DESC257_tree=null;


            retval.plan = new LogicalExpressionPlan();
            retval.ascFlag = true;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1246:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==COL_RANGE) ) {
                alt83=1;
            }
            else if ( (LA83_0==CUBE||LA83_0==DOLLARVAR||LA83_0==GROUP||LA83_0==IDENTIFIER) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;

            }
            switch (alt83) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1246:4: col_range[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col3711);
                    col_range252=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range252.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1246:21: ( ASC | DESC )?
                    int alt81=3;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==ASC) ) {
                        alt81=1;
                    }
                    else if ( (LA81_0==DESC) ) {
                        alt81=2;
                    }
                    switch (alt81) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1246:22: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC253=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3715); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC253_tree = (CommonTree)adaptor.dupNode(ASC253);


                            adaptor.addChild(root_0, ASC253_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1246:28: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC254=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3719); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC254_tree = (CommonTree)adaptor.dupNode(DESC254);


                            adaptor.addChild(root_0, DESC254_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1247:4: col_ref[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col3729);
                    col_ref255=col_ref(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref255.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1247:19: ( ASC | DESC )?
                    int alt82=3;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==ASC) ) {
                        alt82=1;
                    }
                    else if ( (LA82_0==DESC) ) {
                        alt82=2;
                    }
                    switch (alt82) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1247:21: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC256=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3734); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC256_tree = (CommonTree)adaptor.dupNode(ASC256);


                            adaptor.addChild(root_0, ASC256_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1247:27: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC257=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3738); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC257_tree = (CommonTree)adaptor.dupNode(DESC257);


                            adaptor.addChild(root_0, DESC257_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_col"


    public static class order_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1250:1: order_clause returns [String alias] : ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.order_clause_return order_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.order_clause_return retval = new LogicalPlanGenerator.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER258=null;
        LogicalPlanGenerator.rel_return rel259 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause260 =null;

        LogicalPlanGenerator.func_clause_return func_clause261 =null;


        CommonTree ORDER258_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSortOp();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1255:2: ( ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1255:4: ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER258=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause3768); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER258_tree = (CommonTree)adaptor.dupNode(ORDER258);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER258_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause3770);
            rel259=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel259.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause3772);
            order_by_clause260=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause260.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1255:33: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==FUNC||LA84_0==FUNC_REF) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1255:33: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause3774);
                    func_clause261=func_clause(FunctionType.COMPARISONFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause261.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER258 );
                   retval.alias = builder.buildSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, (order_by_clause260!=null?order_by_clause260.plans:null),
                       (order_by_clause260!=null?order_by_clause260.ascFlags:null), (func_clause261!=null?func_clause261.funcSpec:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1264:1: order_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final LogicalPlanGenerator.order_by_clause_return order_by_clause() throws RecognitionException {
        LogicalPlanGenerator.order_by_clause_return retval = new LogicalPlanGenerator.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR262=null;
        CommonTree ASC263=null;
        CommonTree DESC264=null;
        LogicalPlanGenerator.order_col_return order_col265 =null;


        CommonTree STAR262_tree=null;
        CommonTree ASC263_tree=null;
        CommonTree DESC264_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1269:2: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==STAR) ) {
                alt87=1;
            }
            else if ( (LA87_0==CUBE||LA87_0==DOLLARVAR||LA87_0==GROUP||LA87_0==IDENTIFIER||LA87_0==COL_RANGE) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;

            }
            switch (alt87) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1269:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR262=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause3801); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR262_tree = (CommonTree)adaptor.dupNode(STAR262);


                    adaptor.addChild(root_0, STAR262_tree);
                    }


                    if ( state.backtracking==0 ) {
                           LogicalExpressionPlan plan = new LogicalExpressionPlan();
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR262 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                           retval.plans.add( plan );
                       }

                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1275:4: ( ASC | DESC )?
                    int alt85=3;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==ASC) ) {
                        alt85=1;
                    }
                    else if ( (LA85_0==DESC) ) {
                        alt85=2;
                    }
                    switch (alt85) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1275:6: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC263=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_by_clause3810); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC263_tree = (CommonTree)adaptor.dupNode(ASC263);


                            adaptor.addChild(root_0, ASC263_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1275:39: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC264=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_by_clause3816); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC264_tree = (CommonTree)adaptor.dupNode(DESC264);


                            adaptor.addChild(root_0, DESC264_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1276:4: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1276:4: ( order_col )+
                    int cnt86=0;
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==CUBE||LA86_0==DOLLARVAR||LA86_0==GROUP||LA86_0==IDENTIFIER||LA86_0==COL_RANGE) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1276:6: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause3828);
                    	    order_col265=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col265.getTree());


                    	    if ( state.backtracking==0 ) {
                    	           retval.plans.add( (order_col265!=null?order_col265.plan:null) );
                    	           retval.ascFlags.add( (order_col265!=null?order_col265.ascFlag:null) );
                    	       }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt86 >= 1 ) break loop86;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(86, input);
                                throw eee;
                        }
                        cnt86++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_by_clause"


    public static class order_col_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public Boolean ascFlag;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1283:1: order_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
    public final LogicalPlanGenerator.order_col_return order_col() throws RecognitionException {
        LogicalPlanGenerator.order_col_return retval = new LogicalPlanGenerator.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC267=null;
        CommonTree DESC268=null;
        CommonTree ASC270=null;
        CommonTree DESC271=null;
        LogicalPlanGenerator.col_range_return col_range266 =null;

        LogicalPlanGenerator.col_ref_return col_ref269 =null;


        CommonTree ASC267_tree=null;
        CommonTree DESC268_tree=null;
        CommonTree ASC270_tree=null;
        CommonTree DESC271_tree=null;


            retval.plan = new LogicalExpressionPlan();
            retval.ascFlag = true;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1288:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==COL_RANGE) ) {
                alt90=1;
            }
            else if ( (LA90_0==CUBE||LA90_0==DOLLARVAR||LA90_0==GROUP||LA90_0==IDENTIFIER) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;

            }
            switch (alt90) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1288:4: col_range[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col3854);
                    col_range266=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range266.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1288:21: ( ASC | DESC )?
                    int alt88=3;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==ASC) ) {
                        alt88=1;
                    }
                    else if ( (LA88_0==DESC) ) {
                        alt88=2;
                    }
                    switch (alt88) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1288:22: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC267=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col3858); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC267_tree = (CommonTree)adaptor.dupNode(ASC267);


                            adaptor.addChild(root_0, ASC267_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1288:28: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC268=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col3862); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC268_tree = (CommonTree)adaptor.dupNode(DESC268);


                            adaptor.addChild(root_0, DESC268_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1289:4: col_ref[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col3872);
                    col_ref269=col_ref(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref269.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1289:19: ( ASC | DESC )?
                    int alt89=3;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==ASC) ) {
                        alt89=1;
                    }
                    else if ( (LA89_0==DESC) ) {
                        alt89=2;
                    }
                    switch (alt89) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1289:21: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC270=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col3877); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC270_tree = (CommonTree)adaptor.dupNode(ASC270);


                            adaptor.addChild(root_0, ASC270_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1289:27: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC271=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col3881); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC271_tree = (CommonTree)adaptor.dupNode(DESC271);


                            adaptor.addChild(root_0, DESC271_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1292:1: distinct_clause returns [String alias] : ^( DISTINCT rel ( partition_clause )? ) ;
    public final LogicalPlanGenerator.distinct_clause_return distinct_clause() throws RecognitionException {
        LogicalPlanGenerator.distinct_clause_return retval = new LogicalPlanGenerator.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT272=null;
        LogicalPlanGenerator.rel_return rel273 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause274 =null;


        CommonTree DISTINCT272_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1293:2: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1293:4: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT272=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause3901); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT272_tree = (CommonTree)adaptor.dupNode(DISTINCT272);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT272_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause3903);
            rel273=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel273.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1293:20: ( partition_clause )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==PARTITION) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1293:20: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause3905);
                    partition_clause274=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause274.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildDistinctOp( new SourceLocation( (PigParserNode)DISTINCT272 ), ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (partition_clause274!=null?partition_clause274.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "distinct_clause"


    public static class partition_clause_return extends TreeRuleReturnScope {
        public String partitioner;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1300:1: partition_clause returns [String partitioner] : ^( PARTITION func_name ) ;
    public final LogicalPlanGenerator.partition_clause_return partition_clause() throws RecognitionException {
        LogicalPlanGenerator.partition_clause_return retval = new LogicalPlanGenerator.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION275=null;
        LogicalPlanGenerator.func_name_return func_name276 =null;


        CommonTree PARTITION275_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1301:2: ( ^( PARTITION func_name ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1301:4: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION275=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause3928); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION275_tree = (CommonTree)adaptor.dupNode(PARTITION275);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION275_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause3930);
            func_name276=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name276.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.partitioner = (func_name276!=null?func_name276.funcName:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partition_clause"


    public static class cross_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1307:1: cross_clause returns [String alias] : ^( CROSS rel_list ( partition_clause )? ) ;
    public final LogicalPlanGenerator.cross_clause_return cross_clause() throws RecognitionException {
        LogicalPlanGenerator.cross_clause_return retval = new LogicalPlanGenerator.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS277=null;
        LogicalPlanGenerator.rel_list_return rel_list278 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause279 =null;


        CommonTree CROSS277_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1308:2: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1308:4: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS277=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause3952); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS277_tree = (CommonTree)adaptor.dupNode(CROSS277);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS277_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause3954);
            rel_list278=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list278.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1308:22: ( partition_clause )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==PARTITION) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1308:22: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause3956);
                    partition_clause279=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause279.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildCrossOp( new SourceLocation( (PigParserNode)CROSS277 ), ((statement_scope)statement_stack.peek()).alias,
                      (rel_list278!=null?rel_list278.aliasList:null), (partition_clause279!=null?partition_clause279.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cross_clause"


    public static class rel_list_return extends TreeRuleReturnScope {
        public List<String> aliasList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1315:1: rel_list returns [List<String> aliasList] : ( rel )+ ;
    public final LogicalPlanGenerator.rel_list_return rel_list() throws RecognitionException {
        LogicalPlanGenerator.rel_list_return retval = new LogicalPlanGenerator.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_return rel280 =null;



         retval.aliasList = new ArrayList<String>(); 
        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1317:2: ( ( rel )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1317:4: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1317:4: ( rel )+
            int cnt93=0;
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==ARROBA||LA93_0==COGROUP||(LA93_0 >= CROSS && LA93_0 <= CUBE)||LA93_0==DEFINE||LA93_0==DISTINCT||LA93_0==FILTER||LA93_0==FOREACH||LA93_0==GROUP||LA93_0==IDENTIFIER||LA93_0==JOIN||(LA93_0 >= LIMIT && LA93_0 <= LOAD)||LA93_0==MAPREDUCE||LA93_0==ORDER||LA93_0==RANK||LA93_0==SAMPLE||(LA93_0 >= STORE && LA93_0 <= STREAM)||LA93_0==UNION) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1317:6: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list3984);
            	    rel280=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel280.getTree());


            	    if ( state.backtracking==0 ) { retval.aliasList.add( ((statement_scope)statement_stack.peek()).inputAlias ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt93 >= 1 ) break loop93;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(93, input);
                        throw eee;
                }
                cnt93++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_list"


    protected static class join_clause_scope {
        MultiMap<Integer, LogicalExpressionPlan> joinPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack join_clause_stack = new Stack();


    public static class join_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1320:1: join_clause returns [String alias] : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final LogicalPlanGenerator.join_clause_return join_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        join_clause_stack.push(new join_clause_scope());
        LogicalPlanGenerator.join_clause_return retval = new LogicalPlanGenerator.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN281=null;
        LogicalPlanGenerator.join_sub_clause_return join_sub_clause282 =null;

        LogicalPlanGenerator.join_type_return join_type283 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause284 =null;


        CommonTree JOIN281_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createJoinOp();
            ((join_clause_scope)join_clause_stack.peek()).joinPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((join_clause_scope)join_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((join_clause_scope)join_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1338:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1338:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN281=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause4023); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN281_tree = (CommonTree)adaptor.dupNode(JOIN281);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN281_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause4025);
            join_sub_clause282=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause282.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1338:28: ( join_type )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==QUOTEDSTRING) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1338:28: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause4027);
                    join_type283=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type283.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1338:39: ( partition_clause )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==PARTITION) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1338:39: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause4030);
                    partition_clause284=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause284.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)JOIN281 );
                   retval.alias = builder.buildJoinOp( loc, (LOJoin)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                      ((join_clause_scope)join_clause_stack.peek()).inputAliases, ((join_clause_scope)join_clause_stack.peek()).joinPlans,
                      (join_type283!=null?join_type283.type:null), ((join_clause_scope)join_clause_stack.peek()).innerFlags, (partition_clause284!=null?partition_clause284.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
               ((statement_scope)statement_stack.peek()).inputIndex =oldStatementIndex;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            join_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        public JOINTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1347:1: join_type returns [JOINTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.join_type_return join_type() throws RecognitionException {
        LogicalPlanGenerator.join_type_return retval = new LogicalPlanGenerator.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING285=null;

        CommonTree QUOTEDSTRING285_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1348:2: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1348:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING285=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type4051); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING285_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING285);


            adaptor.addChild(root_0, QUOTEDSTRING285_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type = builder.parseJoinType( (QUOTEDSTRING285!=null?QUOTEDSTRING285.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING285 ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_type"


    public static class join_sub_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_sub_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1354:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final LogicalPlanGenerator.join_sub_clause_return join_sub_clause() throws RecognitionException {
        LogicalPlanGenerator.join_sub_clause_return retval = new LogicalPlanGenerator.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LEFT287=null;
        CommonTree RIGHT288=null;
        CommonTree FULL289=null;
        CommonTree OUTER290=null;
        LogicalPlanGenerator.join_item_return join_item286 =null;

        LogicalPlanGenerator.join_item_return join_item291 =null;

        LogicalPlanGenerator.join_item_return join_item292 =null;


        CommonTree LEFT287_tree=null;
        CommonTree RIGHT288_tree=null;
        CommonTree FULL289_tree=null;
        CommonTree OUTER290_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1355:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==JOIN_ITEM) ) {
                int LA99_1 = input.LA(2);

                if ( (synpred173_LogicalPlanGenerator()) ) {
                    alt99=1;
                }
                else if ( (true) ) {
                    alt99=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 99, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;

            }
            switch (alt99) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1355:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause4066);
                    join_item286=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item286.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1355:14: ( LEFT | RIGHT | FULL )
                    int alt96=3;
                    switch ( input.LA(1) ) {
                    case LEFT:
                        {
                        alt96=1;
                        }
                        break;
                    case RIGHT:
                        {
                        alt96=2;
                        }
                        break;
                    case FULL:
                        {
                        alt96=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 96, 0, input);

                        throw nvae;

                    }

                    switch (alt96) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1355:16: LEFT
                            {
                            _last = (CommonTree)input.LT(1);
                            LEFT287=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_join_sub_clause4070); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LEFT287_tree = (CommonTree)adaptor.dupNode(LEFT287);


                            adaptor.addChild(root_0, LEFT287_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true );
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1357:16: RIGHT
                            {
                            _last = (CommonTree)input.LT(1);
                            RIGHT288=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_join_sub_clause4089); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RIGHT288_tree = (CommonTree)adaptor.dupNode(RIGHT288);


                            adaptor.addChild(root_0, RIGHT288_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false );
                                                   ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1359:16: FULL
                            {
                            _last = (CommonTree)input.LT(1);
                            FULL289=(CommonTree)match(input,FULL,FOLLOW_FULL_in_join_sub_clause4108); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FULL289_tree = (CommonTree)adaptor.dupNode(FULL289);


                            adaptor.addChild(root_0, FULL289_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false );
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1360:66: ( OUTER )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==OUTER) ) {
                        alt97=1;
                    }
                    switch (alt97) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1360:66: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER290=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause4114); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER290_tree = (CommonTree)adaptor.dupNode(OUTER290);


                            adaptor.addChild(root_0, OUTER290_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause4117);
                    join_item291=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item291.getTree());


                    if ( state.backtracking==0 ) {
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1363:4: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1363:4: ( join_item )+
                    int cnt98=0;
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==JOIN_ITEM) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1363:4: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause4127);
                    	    join_item292=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item292.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt98 >= 1 ) break loop98;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(98, input);
                                throw eee;
                        }
                        cnt98++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_sub_clause"


    public static class join_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_item"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1366:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final LogicalPlanGenerator.join_item_return join_item() throws RecognitionException {
        LogicalPlanGenerator.join_item_return retval = new LogicalPlanGenerator.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM293=null;
        LogicalPlanGenerator.rel_return rel294 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause295 =null;


        CommonTree JOIN_ITEM293_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1367:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1367:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM293=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item4140); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM293_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM293);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM293_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item4142);
            rel294=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel294.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item4144);
            join_group_by_clause295=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause295.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((join_clause_scope)join_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((join_clause_scope)join_clause_stack.peek()).joinPlans.put( ((join_clause_scope)join_clause_stack.peek()).inputIndex, (join_group_by_clause295!=null?join_group_by_clause295.plans:null) );
                   ((join_clause_scope)join_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1376:1: join_group_by_clause returns [List<LogicalExpressionPlan> plans] : ^( BY ( join_group_by_expr )+ ) ;
    public final LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_clause_return retval = new LogicalPlanGenerator.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY296=null;
        LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr297 =null;


        CommonTree BY296_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:2: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:4: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY296=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause4171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY296_tree = (CommonTree)adaptor.dupNode(BY296);


            root_1 = (CommonTree)adaptor.becomeRoot(BY296_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:10: ( join_group_by_expr )+
            int cnt100=0;
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==BIGDECIMALNUMBER||LA100_0==BIGINTEGERNUMBER||LA100_0==CUBE||LA100_0==DIV||LA100_0==DOLLARVAR||LA100_0==DOUBLENUMBER||LA100_0==FALSE||LA100_0==FLOATNUMBER||LA100_0==GROUP||LA100_0==IDENTIFIER||LA100_0==INTEGER||LA100_0==LONGINTEGER||LA100_0==MINUS||LA100_0==NULL||LA100_0==PERCENT||LA100_0==PLUS||LA100_0==QUOTEDSTRING||LA100_0==STAR||LA100_0==TRUE||(LA100_0 >= BAG_VAL && LA100_0 <= BIN_EXPR)||(LA100_0 >= CASE_COND && LA100_0 <= EXPR_IN_PAREN)||LA100_0==FUNC_EVAL||LA100_0==INVOKER_FUNC_EVAL||(LA100_0 >= MAP_VAL && LA100_0 <= NEG)||LA100_0==TUPLE_VAL) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:12: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause4175);
            	    join_group_by_expr297=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr297.getTree());


            	    if ( state.backtracking==0 ) { retval.plans.add( (join_group_by_expr297!=null?join_group_by_expr297.plan:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt100 >= 1 ) break loop100;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(100, input);
                        throw eee;
                }
                cnt100++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_clause"


    public static class join_group_by_expr_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1383:1: join_group_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
    public final LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_expr_return retval = new LogicalPlanGenerator.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR300=null;
        LogicalPlanGenerator.col_range_return col_range298 =null;

        LogicalPlanGenerator.expr_return expr299 =null;


        CommonTree STAR300_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1387:2: ( col_range[$plan] | expr[$plan] | STAR )
            int alt101=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt101=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt101=2;
                }
                break;
            case STAR:
                {
                int LA101_3 = input.LA(2);

                if ( (LA101_3==DOWN) ) {
                    alt101=2;
                }
                else if ( (LA101_3==EOF||LA101_3==UP||LA101_3==BIGDECIMALNUMBER||LA101_3==BIGINTEGERNUMBER||LA101_3==CUBE||LA101_3==DIV||LA101_3==DOLLARVAR||LA101_3==DOUBLENUMBER||LA101_3==FALSE||LA101_3==FLOATNUMBER||LA101_3==GROUP||LA101_3==IDENTIFIER||LA101_3==INTEGER||LA101_3==LONGINTEGER||LA101_3==MINUS||LA101_3==NULL||LA101_3==PERCENT||LA101_3==PLUS||LA101_3==QUOTEDSTRING||LA101_3==STAR||LA101_3==TRUE||(LA101_3 >= BAG_VAL && LA101_3 <= BIN_EXPR)||(LA101_3 >= CASE_COND && LA101_3 <= EXPR_IN_PAREN)||LA101_3==FUNC_EVAL||LA101_3==INVOKER_FUNC_EVAL||(LA101_3 >= MAP_VAL && LA101_3 <= NEG)||LA101_3==TUPLE_VAL) ) {
                    alt101=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }

            switch (alt101) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1387:4: col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr4200);
                    col_range298=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range298.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1388:4: expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr4206);
                    expr299=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr299.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1389:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR300=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr4212); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR300_tree = (CommonTree)adaptor.dupNode(STAR300);


                    adaptor.addChild(root_0, STAR300_tree);
                    }


                    if ( state.backtracking==0 ) {
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR300 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_expr"


    public static class union_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1396:1: union_clause returns [String alias] : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final LogicalPlanGenerator.union_clause_return union_clause() throws RecognitionException {
        LogicalPlanGenerator.union_clause_return retval = new LogicalPlanGenerator.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION301=null;
        CommonTree ONSCHEMA302=null;
        LogicalPlanGenerator.rel_list_return rel_list303 =null;


        CommonTree UNION301_tree=null;
        CommonTree ONSCHEMA302_tree=null;


            boolean onSchema = false;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1400:2: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1400:4: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION301=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause4237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION301_tree = (CommonTree)adaptor.dupNode(UNION301);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION301_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1400:13: ( ONSCHEMA )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==ONSCHEMA) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1400:15: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA302=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause4241); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA302_tree = (CommonTree)adaptor.dupNode(ONSCHEMA302);


                    adaptor.addChild(root_1, ONSCHEMA302_tree);
                    }


                    if ( state.backtracking==0 ) { onSchema = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause4248);
            rel_list303=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list303.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  retval.alias = builder.buildUnionOp( new SourceLocation( (PigParserNode)UNION301 ), ((statement_scope)statement_stack.peek()).alias,
                      (rel_list303!=null?rel_list303.aliasList:null), onSchema );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "union_clause"


    protected static class foreach_clause_scope {
        LOForEach foreachOp;
    }
    protected Stack foreach_clause_stack = new Stack();


    public static class foreach_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1407:1: foreach_clause returns [String alias] : ^( FOREACH rel foreach_plan ) ;
    public final LogicalPlanGenerator.foreach_clause_return foreach_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        foreach_clause_stack.push(new foreach_clause_scope());
        LogicalPlanGenerator.foreach_clause_return retval = new LogicalPlanGenerator.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH304=null;
        LogicalPlanGenerator.rel_return rel305 =null;

        LogicalPlanGenerator.foreach_plan_return foreach_plan306 =null;


        CommonTree FOREACH304_tree=null;


             ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp = builder.createForeachOp();
             ((GScope_scope)GScope_stack.peek()).currentOp = ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1416:2: ( ^( FOREACH rel foreach_plan ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1416:4: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH304=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause4284); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH304_tree = (CommonTree)adaptor.dupNode(FOREACH304);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH304_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause4286);
            rel305=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel305.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause4288);
            foreach_plan306=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan306.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH304 );
                   retval.alias = builder.buildForeachOp( loc, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (foreach_plan306!=null?foreach_plan306.plan:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            foreach_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_clause"


    protected static class foreach_plan_scope {
        LogicalPlan innerPlan;
        Map<String, LogicalExpressionPlan> exprPlans;
        Map<String, Operator> operators;
    }
    protected Stack foreach_plan_stack = new Stack();


    public static class foreach_plan_return extends TreeRuleReturnScope {
        public LogicalPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1424:1: foreach_plan returns [LogicalPlan plan] : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final LogicalPlanGenerator.foreach_plan_return foreach_plan() throws RecognitionException {
        foreach_plan_stack.push(new foreach_plan_scope());
        LogicalPlanGenerator.foreach_plan_return retval = new LogicalPlanGenerator.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE307=null;
        CommonTree FOREACH_PLAN_COMPLEX309=null;
        LogicalPlanGenerator.generate_clause_return generate_clause308 =null;

        LogicalPlanGenerator.nested_blk_return nested_blk310 =null;


        CommonTree FOREACH_PLAN_SIMPLE307_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX309_tree=null;


            inForeachPlan = true;
            ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan = new LogicalPlan();
            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans = new HashMap<String, LogicalExpressionPlan>();
            ((foreach_plan_scope)foreach_plan_stack.peek()).operators = new HashMap<String, Operator>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1440:2: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==FOREACH_PLAN_SIMPLE) ) {
                alt103=1;
            }
            else if ( (LA103_0==FOREACH_PLAN_COMPLEX) ) {
                alt103=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }
            switch (alt103) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1440:4: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE307=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4324); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE307_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE307);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE307_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan4326);
                    generate_clause308=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause308.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1441:4: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX309=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4335); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX309_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX309);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX309_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan4337);
                    nested_blk310=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk310.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                retval.plan = ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan;
                inForeachPlan = false;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            foreach_plan_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_plan"


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1444:1: nested_blk : ( nested_command )* generate_clause ;
    public final LogicalPlanGenerator.nested_blk_return nested_blk() throws RecognitionException {
        LogicalPlanGenerator.nested_blk_return retval = new LogicalPlanGenerator.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_command_return nested_command311 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause312 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1444:12: ( ( nested_command )* generate_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1444:14: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1444:14: ( nested_command )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( ((LA104_0 >= NESTED_CMD && LA104_0 <= NESTED_CMD_ASSI)) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1444:14: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk4348);
            	    nested_command311=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command311.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop104;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk4351);
            generate_clause312=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause312.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_blk"


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1447:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) );
    public final LogicalPlanGenerator.nested_command_return nested_command() throws RecognitionException {
        LogicalPlanGenerator.nested_command_return retval = new LogicalPlanGenerator.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD313=null;
        CommonTree IDENTIFIER314=null;
        CommonTree NESTED_CMD_ASSI316=null;
        CommonTree IDENTIFIER317=null;
        LogicalPlanGenerator.nested_op_return nested_op315 =null;

        LogicalPlanGenerator.expr_return expr318 =null;


        CommonTree NESTED_CMD313_tree=null;
        CommonTree IDENTIFIER314_tree=null;
        CommonTree NESTED_CMD_ASSI316_tree=null;
        CommonTree IDENTIFIER317_tree=null;


            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            inNestedCommand = true;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1455:2: ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==NESTED_CMD) ) {
                alt105=1;
            }
            else if ( (LA105_0==NESTED_CMD_ASSI) ) {
                alt105=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;

            }
            switch (alt105) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1455:4: ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD313=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command4373); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD313_tree = (CommonTree)adaptor.dupNode(NESTED_CMD313);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD313_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER314=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4375); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER314_tree = (CommonTree)adaptor.dupNode(IDENTIFIER314);


                    adaptor.addChild(root_1, IDENTIFIER314_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command4377);
                    nested_op315=nested_op((IDENTIFIER314!=null?IDENTIFIER314.getText():null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op315.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((foreach_plan_scope)foreach_plan_stack.peek()).operators.put( (IDENTIFIER314!=null?IDENTIFIER314.getText():null), (nested_op315!=null?nested_op315.op:null) );
                           ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.remove( (IDENTIFIER314!=null?IDENTIFIER314.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1461:4: ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI316=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command4395); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI316_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI316);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI316_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER317=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4397); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER317_tree = (CommonTree)adaptor.dupNode(IDENTIFIER317);


                    adaptor.addChild(root_1, IDENTIFIER317_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command4399);
                    expr318=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr318.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.put( (IDENTIFIER317!=null?IDENTIFIER317.getText():null), exprPlan );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            	inNestedCommand = false;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_command"


    public static class nested_op_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1467:1: nested_op[String alias] returns [Operator op] : ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] );
    public final LogicalPlanGenerator.nested_op_return nested_op(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_op_return retval = new LogicalPlanGenerator.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_proj_return nested_proj319 =null;

        LogicalPlanGenerator.nested_filter_return nested_filter320 =null;

        LogicalPlanGenerator.nested_sort_return nested_sort321 =null;

        LogicalPlanGenerator.nested_distinct_return nested_distinct322 =null;

        LogicalPlanGenerator.nested_limit_return nested_limit323 =null;

        LogicalPlanGenerator.nested_cross_return nested_cross324 =null;

        LogicalPlanGenerator.nested_foreach_return nested_foreach325 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1468:2: ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] )
            int alt106=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt106=1;
                }
                break;
            case FILTER:
                {
                alt106=2;
                }
                break;
            case ORDER:
                {
                alt106=3;
                }
                break;
            case DISTINCT:
                {
                alt106=4;
                }
                break;
            case LIMIT:
                {
                alt106=5;
                }
                break;
            case CROSS:
                {
                alt106=6;
                }
                break;
            case FOREACH:
                {
                alt106=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;

            }

            switch (alt106) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1468:4: nested_proj[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op4421);
                    nested_proj319=nested_proj(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj319.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_proj319!=null?nested_proj319.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1469:4: nested_filter[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op4429);
                    nested_filter320=nested_filter(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter320.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_filter320!=null?nested_filter320.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1470:4: nested_sort[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op4437);
                    nested_sort321=nested_sort(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort321.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_sort321!=null?nested_sort321.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1471:4: nested_distinct[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op4446);
                    nested_distinct322=nested_distinct(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct322.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_distinct322!=null?nested_distinct322.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1472:4: nested_limit[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op4454);
                    nested_limit323=nested_limit(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit323.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_limit323!=null?nested_limit323.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1473:4: nested_cross[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op4462);
                    nested_cross324=nested_cross(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross324.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_cross324!=null?nested_cross324.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1474:4: nested_foreach[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op4470);
                    nested_foreach325=nested_foreach(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach325.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_foreach325!=null?nested_foreach325.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op"


    public static class nested_proj_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1477:1: nested_proj[String alias] returns [Operator op] : ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) ;
    public final LogicalPlanGenerator.nested_proj_return nested_proj(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_proj_return retval = new LogicalPlanGenerator.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ326=null;
        LogicalPlanGenerator.col_ref_return cr0 =null;

        LogicalPlanGenerator.col_ref_return cr =null;


        CommonTree NESTED_PROJ326_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1482:2: ( ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1482:4: ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ326=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj4494); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ326_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ326);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ326_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj4506);
            cr0=col_ref(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cr0.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1484:7: (cr= col_ref[new LogicalExpressionPlan()] )+
            int cnt107=0;
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==CUBE||LA107_0==DOLLARVAR||LA107_0==GROUP||LA107_0==IDENTIFIER) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1484:9: cr= col_ref[new LogicalExpressionPlan()]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj4521);
            	    cr=col_ref(new LogicalExpressionPlan());

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, cr.getTree());


            	    if ( state.backtracking==0 ) {
            	                plans.add( (LogicalExpressionPlan)( (cr!=null?cr.expr:null).getPlan() ) );
            	            }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt107 >= 1 ) break loop107;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(107, input);
                        throw eee;
                }
                cnt107++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(cr0!=null?((CommonTree)cr0.start):null) );
                   retval.op = builder.buildNestedProjectOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp,
                       ((foreach_plan_scope)foreach_plan_stack.peek()).operators, alias, (ProjectExpression)(cr0!=null?cr0.expr:null), plans );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1496:1: nested_filter[String alias] returns [Operator op] : ^( FILTER nested_op_input cond[plan] ) ;
    public final LogicalPlanGenerator.nested_filter_return nested_filter(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_filter_return retval = new LogicalPlanGenerator.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER327=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input328 =null;

        LogicalPlanGenerator.cond_return cond329 =null;


        CommonTree FILTER327_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedFilterOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1503:2: ( ^( FILTER nested_op_input cond[plan] ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1503:4: ^( FILTER nested_op_input cond[plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER327=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter4574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER327_tree = (CommonTree)adaptor.dupNode(FILTER327);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER327_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter4576);
            nested_op_input328=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input328.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter4578);
            cond329=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond329.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FILTER327 );
                   retval.op = builder.buildNestedFilterOp( loc, (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                       (nested_op_input328!=null?nested_op_input328.op:null), plan );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1511:1: nested_sort[String alias] returns [Operator op] : ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.nested_sort_return nested_sort(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_sort_return retval = new LogicalPlanGenerator.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER330=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input331 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause332 =null;

        LogicalPlanGenerator.func_clause_return func_clause333 =null;


        CommonTree ORDER330_tree=null;


            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedSortOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1517:2: ( ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1517:4: ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER330=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort4612); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER330_tree = (CommonTree)adaptor.dupNode(ORDER330);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER330_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort4614);
            nested_op_input331=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input331.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort4616);
            order_by_clause332=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause332.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1517:45: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==FUNC||LA108_0==FUNC_REF) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1517:45: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort4618);
                    func_clause333=func_clause(FunctionType.COMPARISONFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause333.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER330 );
                   retval.op = builder.buildNestedSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                       (nested_op_input331!=null?nested_op_input331.op:null),
                       (order_by_clause332!=null?order_by_clause332.plans:null), (order_by_clause332!=null?order_by_clause332.ascFlags:null), (func_clause333!=null?func_clause333.funcSpec:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1526:1: nested_distinct[String alias] returns [Operator op] : ^( DISTINCT nested_op_input ) ;
    public final LogicalPlanGenerator.nested_distinct_return nested_distinct(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_distinct_return retval = new LogicalPlanGenerator.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT334=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input335 =null;


        CommonTree DISTINCT334_tree=null;


            Operator inputOp = null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1530:2: ( ^( DISTINCT nested_op_input ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1530:4: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT334=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct4648); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT334_tree = (CommonTree)adaptor.dupNode(DISTINCT334);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT334_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct4650);
            nested_op_input335=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input335.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)DISTINCT334 );
                   retval.op = builder.buildNestedDistinctOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input335!=null?nested_op_input335.op:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_distinct"


    public static class nested_limit_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1537:1: nested_limit[String alias] returns [Operator op] : ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.nested_limit_return nested_limit(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_limit_return retval = new LogicalPlanGenerator.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT336=null;
        CommonTree INTEGER338=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input337 =null;

        LogicalPlanGenerator.expr_return expr339 =null;


        CommonTree LIMIT336_tree=null;
        CommonTree INTEGER338_tree=null;


            Operator inputOp = null;
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedLimitOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1544:2: ( ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1544:4: ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT336=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit4683); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT336_tree = (CommonTree)adaptor.dupNode(LIMIT336);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT336_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit4685);
            nested_op_input337=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input337.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1544:29: ( INTEGER | expr[exprPlan] )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==INTEGER) ) {
                int LA109_1 = input.LA(2);

                if ( (synpred190_LogicalPlanGenerator()) ) {
                    alt109=1;
                }
                else if ( (true) ) {
                    alt109=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 109, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA109_0==BIGDECIMALNUMBER||LA109_0==BIGINTEGERNUMBER||LA109_0==CUBE||LA109_0==DIV||LA109_0==DOLLARVAR||LA109_0==DOUBLENUMBER||LA109_0==FALSE||LA109_0==FLOATNUMBER||LA109_0==GROUP||LA109_0==IDENTIFIER||LA109_0==LONGINTEGER||LA109_0==MINUS||LA109_0==NULL||LA109_0==PERCENT||LA109_0==PLUS||LA109_0==QUOTEDSTRING||LA109_0==STAR||LA109_0==TRUE||(LA109_0 >= BAG_VAL && LA109_0 <= BIN_EXPR)||(LA109_0 >= CASE_COND && LA109_0 <= CAST_EXPR)||LA109_0==EXPR_IN_PAREN||LA109_0==FUNC_EVAL||LA109_0==INVOKER_FUNC_EVAL||(LA109_0 >= MAP_VAL && LA109_0 <= NEG)||LA109_0==TUPLE_VAL) ) {
                alt109=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }
            switch (alt109) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1544:31: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER338=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit4689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER338_tree = (CommonTree)adaptor.dupNode(INTEGER338);


                    adaptor.addChild(root_1, INTEGER338_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT336 );
                           retval.op = builder.buildNestedLimitOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input337!=null?nested_op_input337.op:null),
                               Integer.valueOf( (INTEGER338!=null?INTEGER338.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1550:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit4699);
                    expr339=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr339.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT336 );
                           retval.op = builder.buildNestedLimitOp( loc, (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                               (nested_op_input337!=null?nested_op_input337.op:null), exprPlan);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1559:1: nested_cross[String alias] returns [Operator op] : ^( CROSS nested_op_input_list ) ;
    public final LogicalPlanGenerator.nested_cross_return nested_cross(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_cross_return retval = new LogicalPlanGenerator.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS340=null;
        LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list341 =null;


        CommonTree CROSS340_tree=null;


            Operator inputOp = null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1563:2: ( ^( CROSS nested_op_input_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1563:4: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS340=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross4732); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS340_tree = (CommonTree)adaptor.dupNode(CROSS340);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS340_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross4734);
            nested_op_input_list341=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list341.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)CROSS340 );
                   retval.op = builder.buildNestedCrossOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input_list341!=null?nested_op_input_list341.opList:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_cross"


    protected static class nested_foreach_scope {
        LogicalPlan innerPlan;
        LOForEach foreachOp;
    }
    protected Stack nested_foreach_stack = new Stack();


    public static class nested_foreach_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1570:1: nested_foreach[String alias] returns [Operator op] : ^( FOREACH nested_op_input generate_clause ) ;
    public final LogicalPlanGenerator.nested_foreach_return nested_foreach(String alias) throws RecognitionException {
        nested_foreach_stack.push(new nested_foreach_scope());
        LogicalPlanGenerator.nested_foreach_return retval = new LogicalPlanGenerator.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH342=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input343 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause344 =null;


        CommonTree FOREACH342_tree=null;


        	Operator inputOp = null;
        	((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan = new LogicalPlan();
        	((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp = builder.createNestedForeachOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1580:2: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1580:4: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH342=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach4766); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH342_tree = (CommonTree)adaptor.dupNode(FOREACH342);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH342_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach4768);
            nested_op_input343=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input343.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach4770);
            generate_clause344=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause344.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
               		SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH342 );
               		retval.op = builder.buildNestedForeachOp( loc, (LOForEach)((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
               							alias, (nested_op_input343!=null?nested_op_input343.op:null), ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            nested_foreach_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "nested_foreach"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1588:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final LogicalPlanGenerator.generate_clause_return generate_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.generate_clause_return retval = new LogicalPlanGenerator.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE345=null;
        LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item346 =null;


        CommonTree GENERATE345_tree=null;


        	((GScope_scope)GScope_stack.peek()).currentOp = builder.createGenerateOp(inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan : ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();
            List<Boolean> flattenFlags = new ArrayList<Boolean>();
            List<LogicalSchema> schemas = new ArrayList<LogicalSchema>();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1596:2: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1596:4: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE345=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause4799); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE345_tree = (CommonTree)adaptor.dupNode(GENERATE345);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE345_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1596:16: ( flatten_generated_item )+
            int cnt110=0;
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==BIGDECIMALNUMBER||LA110_0==BIGINTEGERNUMBER||LA110_0==CUBE||LA110_0==DIV||LA110_0==DOLLARVAR||LA110_0==DOUBLENUMBER||LA110_0==FALSE||LA110_0==FLATTEN||LA110_0==FLOATNUMBER||LA110_0==GROUP||LA110_0==IDENTIFIER||LA110_0==INTEGER||LA110_0==LONGINTEGER||LA110_0==MINUS||LA110_0==NULL||LA110_0==PERCENT||LA110_0==PLUS||LA110_0==QUOTEDSTRING||LA110_0==STAR||LA110_0==TRUE||(LA110_0 >= BAG_VAL && LA110_0 <= BIN_EXPR)||(LA110_0 >= CASE_COND && LA110_0 <= EXPR_IN_PAREN)||LA110_0==FUNC_EVAL||LA110_0==INVOKER_FUNC_EVAL||(LA110_0 >= MAP_VAL && LA110_0 <= NEG)||LA110_0==TUPLE_VAL) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1596:18: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause4803);
            	    flatten_generated_item346=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item346.getTree());


            	    if ( state.backtracking==0 ) {
            	                         plans.add( (flatten_generated_item346!=null?flatten_generated_item346.plan:null) );
            	                         flattenFlags.add( (flatten_generated_item346!=null?flatten_generated_item346.flattenFlag:false) );
            	                         schemas.add( (flatten_generated_item346!=null?flatten_generated_item346.schema:null) );
            	                     }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt110 >= 1 ) break loop110;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(110, input);
                        throw eee;
                }
                cnt110++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   builder.buildGenerateOp( new SourceLocation( (PigParserNode)GENERATE345 ),
                   	   inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp : ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp,
                       (LOGenerate)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).operators,
                       plans, flattenFlags, schemas );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "generate_clause"


    public static class nested_op_input_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1612:1: nested_op_input returns [Operator op] : ( col_ref[plan] | nested_proj[null] );
    public final LogicalPlanGenerator.nested_op_input_return nested_op_input() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_return retval = new LogicalPlanGenerator.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_ref_return col_ref347 =null;

        LogicalPlanGenerator.nested_proj_return nested_proj348 =null;




            LogicalExpressionPlan plan = new LogicalExpressionPlan();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1616:2: ( col_ref[plan] | nested_proj[null] )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==CUBE||LA111_0==DOLLARVAR||LA111_0==GROUP||LA111_0==IDENTIFIER) ) {
                alt111=1;
            }
            else if ( (LA111_0==NESTED_PROJ) ) {
                alt111=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;

            }
            switch (alt111) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1616:4: col_ref[plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input4869);
                    col_ref347=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref347.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)(col_ref347!=null?((CommonTree)col_ref347.start):null) );
                           retval.op = builder.buildNestedOperatorInput( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
                               ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).operators, (col_ref347!=null?col_ref347.expr:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1622:4: nested_proj[null]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input4880);
                    nested_proj348=nested_proj(null);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj348.getTree());


                    if ( state.backtracking==0 ) {
                           retval.op = (nested_proj348!=null?nested_proj348.op:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input"


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        public List<Operator> opList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1628:1: nested_op_input_list returns [List<Operator> opList] : ( nested_op_input )+ ;
    public final LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_list_return retval = new LogicalPlanGenerator.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_op_input_return nested_op_input349 =null;



         retval.opList = new ArrayList<Operator>(); 
        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1630:2: ( ( nested_op_input )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1630:4: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1630:4: ( nested_op_input )+
            int cnt112=0;
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( (LA112_0==CUBE||LA112_0==DOLLARVAR||LA112_0==GROUP||LA112_0==IDENTIFIER||LA112_0==NESTED_PROJ) ) {
                    alt112=1;
                }


                switch (alt112) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1630:6: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list4906);
            	    nested_op_input349=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input349.getTree());


            	    if ( state.backtracking==0 ) { retval.opList.add( (nested_op_input349!=null?nested_op_input349.op:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt112 >= 1 ) break loop112;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(112, input);
                        throw eee;
                }
                cnt112++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input_list"


    public static class stream_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1633:1: stream_clause returns [String alias] : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final LogicalPlanGenerator.stream_clause_return stream_clause() throws RecognitionException {
        LogicalPlanGenerator.stream_clause_return retval = new LogicalPlanGenerator.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM350=null;
        CommonTree EXECCOMMAND352=null;
        CommonTree IDENTIFIER353=null;
        LogicalPlanGenerator.rel_return rel351 =null;

        LogicalPlanGenerator.as_clause_return as_clause354 =null;


        CommonTree STREAM350_tree=null;
        CommonTree EXECCOMMAND352_tree=null;
        CommonTree IDENTIFIER353_tree=null;


            StreamingCommand cmd = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1638:2: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1638:4: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM350=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause4931); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM350_tree = (CommonTree)adaptor.dupNode(STREAM350);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM350_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause4933);
            rel351=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel351.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1638:18: ( EXECCOMMAND | IDENTIFIER )
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==EXECCOMMAND) ) {
                alt113=1;
            }
            else if ( (LA113_0==IDENTIFIER) ) {
                alt113=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;

            }
            switch (alt113) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1638:20: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND352=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause4937); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND352_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND352);


                    adaptor.addChild(root_1, EXECCOMMAND352_tree);
                    }


                    if ( state.backtracking==0 ) { cmd = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND352!=null?EXECCOMMAND352.getText():null) ) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1639:20: IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER353=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stream_clause4960); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER353_tree = (CommonTree)adaptor.dupNode(IDENTIFIER353);


                    adaptor.addChild(root_1, IDENTIFIER353_tree);
                    }


                    if ( state.backtracking==0 ) {
                                           cmd = builder.lookupCommand( (IDENTIFIER353!=null?IDENTIFIER353.getText():null) );
                                           if( cmd == null ) {
                                               String msg = "Undefined command-alias [" + (IDENTIFIER353!=null?IDENTIFIER353.getText():null) + "]";
                                               throw new ParserValidationException( input,
                                                   new SourceLocation( (PigParserNode)IDENTIFIER353 ), msg );
                                           }
                                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1648:20: ( as_clause )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==AS) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1648:20: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause5002);
                    as_clause354=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause354.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildStreamOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, cmd, (as_clause354!=null?as_clause354.logicalSchema:null), input );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_clause"


    public static class mr_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1655:1: mr_clause returns [String alias] : ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final LogicalPlanGenerator.mr_clause_return mr_clause() throws RecognitionException {
        LogicalPlanGenerator.mr_clause_return retval = new LogicalPlanGenerator.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE355=null;
        CommonTree QUOTEDSTRING356=null;
        CommonTree EXECCOMMAND360=null;
        LogicalPlanGenerator.path_list_return path_list357 =null;

        LogicalPlanGenerator.store_clause_return store_clause358 =null;

        LogicalPlanGenerator.load_clause_return load_clause359 =null;


        CommonTree MAPREDUCE355_tree=null;
        CommonTree QUOTEDSTRING356_tree=null;
        CommonTree EXECCOMMAND360_tree=null;


            List<String> paths = new ArrayList<String>();
            String alias = ((statement_scope)statement_stack.peek()).alias;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1661:2: ( ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1661:4: ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE355=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause5030); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE355_tree = (CommonTree)adaptor.dupNode(MAPREDUCE355);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE355_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING356=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause5032); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING356_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING356);


            adaptor.addChild(root_1, QUOTEDSTRING356_tree);
            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1661:30: ( path_list[paths] )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==QUOTEDSTRING) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1661:30: path_list[paths]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause5034);
                    path_list357=path_list(paths);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list357.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = null; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause5045);
            store_clause358=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause358.getTree());


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = alias; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause5054);
            load_clause359=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause359.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1664:6: ( EXECCOMMAND )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==EXECCOMMAND) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1664:6: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND360=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause5061); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND360_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND360);


                    adaptor.addChild(root_1, EXECCOMMAND360_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildNativeOp( loc,
                       builder.unquote( (QUOTEDSTRING356!=null?QUOTEDSTRING356.getText():null) ), builder.unquote( (EXECCOMMAND360!=null?EXECCOMMAND360.getText():null) ),
                       paths, (store_clause358!=null?store_clause358.alias:null), (load_clause359!=null?load_clause359.alias:null), input );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "mr_clause"


    public static class split_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1672:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final LogicalPlanGenerator.split_clause_return split_clause() throws RecognitionException {
        LogicalPlanGenerator.split_clause_return retval = new LogicalPlanGenerator.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT361=null;
        LogicalPlanGenerator.rel_return rel362 =null;

        LogicalPlanGenerator.split_branch_return split_branch363 =null;

        LogicalPlanGenerator.split_otherwise_return split_otherwise364 =null;


        CommonTree SPLIT361_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1673:2: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1673:4: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT361=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause5081); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT361_tree = (CommonTree)adaptor.dupNode(SPLIT361);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT361_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause5089);
            rel362=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel362.getTree());


            if ( state.backtracking==0 ) {
                      SourceLocation loc = new SourceLocation( (PigParserNode)SPLIT361 );
                      ((statement_scope)statement_stack.peek()).inputAlias = builder.buildSplitOp( loc, ((statement_scope)statement_stack.peek()).inputAlias );
                  }

            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1679:7: ( split_branch )+
            int cnt117=0;
            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);

                if ( (LA117_0==SPLIT_BRANCH) ) {
                    alt117=1;
                }


                switch (alt117) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1679:7: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause5105);
            	    split_branch363=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch363.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt117 >= 1 ) break loop117;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(117, input);
                        throw eee;
                }
                cnt117++;
            } while (true);


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1679:21: ( split_otherwise )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==OTHERWISE) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1679:21: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause5108);
                    split_otherwise364=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise364.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_clause"


    public static class split_branch_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_branch"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1683:1: split_branch : ^( SPLIT_BRANCH alias cond[splitPlan] ) ;
    public final LogicalPlanGenerator.split_branch_return split_branch() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_branch_return retval = new LogicalPlanGenerator.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH365=null;
        LogicalPlanGenerator.alias_return alias366 =null;

        LogicalPlanGenerator.cond_return cond367 =null;


        CommonTree SPLIT_BRANCH365_tree=null;


            LogicalExpressionPlan splitPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1689:2: ( ^( SPLIT_BRANCH alias cond[splitPlan] ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1689:4: ^( SPLIT_BRANCH alias cond[splitPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH365=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch5137); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH365_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH365);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH365_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch5139);
            alias366=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias366.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch5141);
            cond367=cond(splitPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond367.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias366!=null?((CommonTree)alias366.start):null) );
                   builder.buildSplitOutputOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias366!=null?alias366.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias, splitPlan );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1697:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final LogicalPlanGenerator.split_otherwise_return split_otherwise() throws RecognitionException, PlanGenerationFailureException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_otherwise_return retval = new LogicalPlanGenerator.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE368=null;
        LogicalPlanGenerator.alias_return alias369 =null;


        CommonTree OTHERWISE368_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1702:2: ( ^( OTHERWISE alias ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1702:4: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE368=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise5175); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE368_tree = (CommonTree)adaptor.dupNode(OTHERWISE368);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE368_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise5177);
            alias369=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias369.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias369!=null?((CommonTree)alias369.start):null) );
                   builder.buildSplitOtherwiseOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias369!=null?alias369.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias);
              }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1710:1: col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( alias_col_ref[$plan] | dollar_col_ref[$plan] );
    public final LogicalPlanGenerator.col_ref_return col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_ref_return retval = new LogicalPlanGenerator.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_col_ref_return alias_col_ref370 =null;

        LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref371 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1711:2: ( alias_col_ref[$plan] | dollar_col_ref[$plan] )
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==CUBE||LA119_0==GROUP||LA119_0==IDENTIFIER) ) {
                alt119=1;
            }
            else if ( (LA119_0==DOLLARVAR) ) {
                alt119=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;

            }
            switch (alt119) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1711:4: alias_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref5197);
                    alias_col_ref370=alias_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref370.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (alias_col_ref370!=null?alias_col_ref370.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1712:4: dollar_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref5205);
                    dollar_col_ref371=dollar_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref371.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (dollar_col_ref371!=null?dollar_col_ref371.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_ref"


    public static class alias_col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1715:1: alias_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( GROUP | CUBE | IDENTIFIER );
    public final LogicalPlanGenerator.alias_col_ref_return alias_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.alias_col_ref_return retval = new LogicalPlanGenerator.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP372=null;
        CommonTree CUBE373=null;
        CommonTree IDENTIFIER374=null;

        CommonTree GROUP372_tree=null;
        CommonTree CUBE373_tree=null;
        CommonTree IDENTIFIER374_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1716:2: ( GROUP | CUBE | IDENTIFIER )
            int alt120=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt120=1;
                }
                break;
            case CUBE:
                {
                alt120=2;
                }
                break;
            case IDENTIFIER:
                {
                alt120=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;

            }

            switch (alt120) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1716:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP372=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref5222); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP372_tree = (CommonTree)adaptor.dupNode(GROUP372);


                    adaptor.addChild(root_0, GROUP372_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)GROUP372 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, (GROUP372!=null?GROUP372.getText():null), 0 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1721:4: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE373=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref5232); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE373_tree = (CommonTree)adaptor.dupNode(CUBE373);


                    adaptor.addChild(root_0, CUBE373_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)CUBE373 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, (CUBE373!=null?CUBE373.getText():null), 0 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1726:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER374=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref5242); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER374_tree = (CommonTree)adaptor.dupNode(IDENTIFIER374);


                    adaptor.addChild(root_0, IDENTIFIER374_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)IDENTIFIER374 );
                           String alias = (IDENTIFIER374!=null?IDENTIFIER374.getText():null);
                           Operator inOp = builder.lookupOperator( ((statement_scope)statement_stack.peek()).inputAlias );
                           if(null == inOp)
                           {
                               throw new UndefinedAliasException (input,loc,((statement_scope)statement_stack.peek()).inputAlias);
                           }
                           LogicalSchema schema;
                           try {
                               schema = ((LogicalRelationalOperator)inOp).getSchema();
                           } catch (FrontendException e) {
                               throw new PlanGenerationFailureException( input, loc, e );
                           }

                           Operator op = builder.lookupOperator( alias );
                           if( op != null && ( schema == null || schema.getFieldPosition( alias ) == -1 ) ) {
                               retval.expr = new ScalarExpression( plan, op,
                                   inForeachPlan ? ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp : ((GScope_scope)GScope_stack.peek()).currentOp );
                               retval.expr.setLocation( loc );
                           } else {
                               if( inForeachPlan ) {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                       ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans, alias, 0 );
                               } else {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                       ((statement_scope)statement_stack.peek()).inputIndex, alias, 0 );
                               }
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1759:1: dollar_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : DOLLARVAR ;
    public final LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.dollar_col_ref_return retval = new LogicalPlanGenerator.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR375=null;

        CommonTree DOLLARVAR375_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1760:2: ( DOLLARVAR )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1760:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR375=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref5261); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR375_tree = (CommonTree)adaptor.dupNode(DOLLARVAR375);


            adaptor.addChild(root_0, DOLLARVAR375_tree);
            }


            if ( state.backtracking==0 ) {
                   int col = builder.undollar( (DOLLARVAR375!=null?DOLLARVAR375.getText():null) );
                   retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)DOLLARVAR375 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                       ((statement_scope)statement_stack.peek()).inputIndex, null, col );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dollar_col_ref"


    public static class const_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1768:1: const_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : literal ;
    public final LogicalPlanGenerator.const_expr_return const_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.const_expr_return retval = new LogicalPlanGenerator.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.literal_return literal376 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1769:2: ( literal )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1769:4: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr5280);
            literal376=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal376.getTree());


            if ( state.backtracking==0 ) {
                   retval.expr = new ConstantExpression( plan, (literal376!=null?literal376.value:null));
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "const_expr"


    public static class literal_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1776:1: literal returns [Object value, byte type] : ( scalar | map | bag | tuple );
    public final LogicalPlanGenerator.literal_return literal() throws RecognitionException {
        LogicalPlanGenerator.literal_return retval = new LogicalPlanGenerator.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.scalar_return scalar377 =null;

        LogicalPlanGenerator.map_return map378 =null;

        LogicalPlanGenerator.bag_return bag379 =null;

        LogicalPlanGenerator.tuple_return tuple380 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1777:2: ( scalar | map | bag | tuple )
            int alt121=4;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case QUOTEDSTRING:
            case TRUE:
                {
                alt121=1;
                }
                break;
            case MAP_VAL:
                {
                alt121=2;
                }
                break;
            case BAG_VAL:
                {
                alt121=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt121=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;

            }

            switch (alt121) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1777:4: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal5298);
                    scalar377=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar377.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (scalar377!=null?scalar377.value:null);
                           retval.type = (scalar377!=null?scalar377.type:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1782:4: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal5308);
                    map378=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map378.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (map378!=null?map378.value:null);
                           retval.type = DataType.MAP;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1787:4: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal5318);
                    bag379=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag379.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (bag379!=null?bag379.value:null);
                           retval.type = DataType.BAG;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1792:4: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal5328);
                    tuple380=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple380.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (tuple380!=null?tuple380.value:null);
                           retval.type = DataType.TUPLE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"


    public static class scalar_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1799:1: scalar returns [Object value, byte type] : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final LogicalPlanGenerator.scalar_return scalar() throws RecognitionException {
        LogicalPlanGenerator.scalar_return retval = new LogicalPlanGenerator.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING382=null;
        CommonTree NULL383=null;
        CommonTree TRUE384=null;
        CommonTree FALSE385=null;
        LogicalPlanGenerator.num_scalar_return num_scalar381 =null;


        CommonTree QUOTEDSTRING382_tree=null;
        CommonTree NULL383_tree=null;
        CommonTree TRUE384_tree=null;
        CommonTree FALSE385_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1800:2: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt122=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt122=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt122=2;
                }
                break;
            case NULL:
                {
                alt122=3;
                }
                break;
            case TRUE:
                {
                alt122=4;
                }
                break;
            case FALSE:
                {
                alt122=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;

            }

            switch (alt122) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1800:4: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar5346);
                    num_scalar381=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar381.getTree());


                    if ( state.backtracking==0 ) {
                           retval.type = (num_scalar381!=null?num_scalar381.type:0);
                           retval.value = (num_scalar381!=null?num_scalar381.value:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1805:4: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING382=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar5356); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING382_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING382);


                    adaptor.addChild(root_0, QUOTEDSTRING382_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.CHARARRAY;
                           retval.value = builder.unquote( (QUOTEDSTRING382!=null?QUOTEDSTRING382.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1810:4: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL383=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar5366); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL383_tree = (CommonTree)adaptor.dupNode(NULL383);


                    adaptor.addChild(root_0, NULL383_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.NULL;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1814:4: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE384=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar5376); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE384_tree = (CommonTree)adaptor.dupNode(TRUE384);


                    adaptor.addChild(root_0, TRUE384_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.TRUE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1819:4: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE385=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar5386); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE385_tree = (CommonTree)adaptor.dupNode(FALSE385);


                    adaptor.addChild(root_0, FALSE385_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.FALSE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "scalar"


    public static class num_scalar_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1826:1: num_scalar returns [Object value, byte type] : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final LogicalPlanGenerator.num_scalar_return num_scalar() throws RecognitionException {
        LogicalPlanGenerator.num_scalar_return retval = new LogicalPlanGenerator.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS386=null;
        CommonTree INTEGER387=null;
        CommonTree LONGINTEGER388=null;
        CommonTree FLOATNUMBER389=null;
        CommonTree DOUBLENUMBER390=null;
        CommonTree BIGINTEGERNUMBER391=null;
        CommonTree BIGDECIMALNUMBER392=null;

        CommonTree MINUS386_tree=null;
        CommonTree INTEGER387_tree=null;
        CommonTree LONGINTEGER388_tree=null;
        CommonTree FLOATNUMBER389_tree=null;
        CommonTree DOUBLENUMBER390_tree=null;
        CommonTree BIGINTEGERNUMBER391_tree=null;
        CommonTree BIGDECIMALNUMBER392_tree=null;


            int sign = 1;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1830:2: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1830:4: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1830:4: ( MINUS )?
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==MINUS) ) {
                alt123=1;
            }
            switch (alt123) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1830:6: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS386=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar5411); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS386_tree = (CommonTree)adaptor.dupNode(MINUS386);


                    adaptor.addChild(root_0, MINUS386_tree);
                    }


                    if ( state.backtracking==0 ) { sign = -1; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1831:4: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            int alt124=6;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt124=1;
                }
                break;
            case LONGINTEGER:
                {
                alt124=2;
                }
                break;
            case FLOATNUMBER:
                {
                alt124=3;
                }
                break;
            case DOUBLENUMBER:
                {
                alt124=4;
                }
                break;
            case BIGINTEGERNUMBER:
                {
                alt124=5;
                }
                break;
            case BIGDECIMALNUMBER:
                {
                alt124=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;

            }

            switch (alt124) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1831:6: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER387=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_num_scalar5424); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER387_tree = (CommonTree)adaptor.dupNode(INTEGER387);


                    adaptor.addChild(root_0, INTEGER387_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.INTEGER;
                             retval.value = sign * Integer.valueOf( (INTEGER387!=null?INTEGER387.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1836:6: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER388=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_num_scalar5438); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER388_tree = (CommonTree)adaptor.dupNode(LONGINTEGER388);


                    adaptor.addChild(root_0, LONGINTEGER388_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.LONG;
                             retval.value = sign * builder.parseLong( (LONGINTEGER388!=null?LONGINTEGER388.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1841:6: FLOATNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    FLOATNUMBER389=(CommonTree)match(input,FLOATNUMBER,FOLLOW_FLOATNUMBER_in_num_scalar5452); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOATNUMBER389_tree = (CommonTree)adaptor.dupNode(FLOATNUMBER389);


                    adaptor.addChild(root_0, FLOATNUMBER389_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.FLOAT;
                             retval.value = sign * Float.valueOf( (FLOATNUMBER389!=null?FLOATNUMBER389.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1846:6: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER390=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_num_scalar5466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER390_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER390);


                    adaptor.addChild(root_0, DOUBLENUMBER390_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.DOUBLE;
                             retval.value = sign * Double.valueOf( (DOUBLENUMBER390!=null?DOUBLENUMBER390.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1851:6: BIGINTEGERNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGINTEGERNUMBER391=(CommonTree)match(input,BIGINTEGERNUMBER,FOLLOW_BIGINTEGERNUMBER_in_num_scalar5480); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGERNUMBER391_tree = (CommonTree)adaptor.dupNode(BIGINTEGERNUMBER391);


                    adaptor.addChild(root_0, BIGINTEGERNUMBER391_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.BIGINTEGER;
                             retval.value = builder.parseBigInteger( (BIGINTEGERNUMBER391!=null?BIGINTEGERNUMBER391.getText():null) );
                             if ( sign == -1 ) {
                                 retval.value = ((BigInteger)retval.value).negate();
                             }
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1859:6: BIGDECIMALNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGDECIMALNUMBER392=(CommonTree)match(input,BIGDECIMALNUMBER,FOLLOW_BIGDECIMALNUMBER_in_num_scalar5494); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMALNUMBER392_tree = (CommonTree)adaptor.dupNode(BIGDECIMALNUMBER392);


                    adaptor.addChild(root_0, BIGDECIMALNUMBER392_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.BIGDECIMAL;
                             retval.value = builder.parseBigDecimal( (BIGDECIMALNUMBER392!=null?BIGDECIMALNUMBER392.getText():null) );
                             if ( sign == -1 ) {
                                 retval.value = ((BigDecimal)retval.value).negate();
                             }
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "num_scalar"


    public static class map_return extends TreeRuleReturnScope {
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1870:1: map returns [Object value] : ^( MAP_VAL ( keyvalue )* ) ;
    public final LogicalPlanGenerator.map_return map() throws RecognitionException {
        LogicalPlanGenerator.map_return retval = new LogicalPlanGenerator.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL393=null;
        LogicalPlanGenerator.keyvalue_return keyvalue394 =null;


        CommonTree MAP_VAL393_tree=null;

         Map<String, Object> kvs = new HashMap<String, Object>(); 
        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1872:2: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1872:4: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL393=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map5526); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL393_tree = (CommonTree)adaptor.dupNode(MAP_VAL393);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL393_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1872:15: ( keyvalue )*
                loop125:
                do {
                    int alt125=2;
                    int LA125_0 = input.LA(1);

                    if ( (LA125_0==KEY_VAL_PAIR) ) {
                        alt125=1;
                    }


                    switch (alt125) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1872:17: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map5530);
                	    keyvalue394=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue394.getTree());


                	    if ( state.backtracking==0 ) { kvs.put( (keyvalue394!=null?keyvalue394.key:null), (keyvalue394!=null?keyvalue394.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop125;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = kvs;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        public String key;
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1878:1: keyvalue returns [String key, Object value] : ^( KEY_VAL_PAIR map_key literal ) ;
    public final LogicalPlanGenerator.keyvalue_return keyvalue() throws RecognitionException {
        LogicalPlanGenerator.keyvalue_return retval = new LogicalPlanGenerator.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR395=null;
        LogicalPlanGenerator.map_key_return map_key396 =null;

        LogicalPlanGenerator.literal_return literal397 =null;


        CommonTree KEY_VAL_PAIR395_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1879:2: ( ^( KEY_VAL_PAIR map_key literal ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1879:4: ^( KEY_VAL_PAIR map_key literal )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR395=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue5557); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR395_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR395);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR395_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue5559);
            map_key396=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key396.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_keyvalue5561);
            literal397=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, literal397.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.key = (map_key396!=null?map_key396.value:null);
                   retval.value = (literal397!=null?literal397.value:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "keyvalue"


    public static class map_key_return extends TreeRuleReturnScope {
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1886:1: map_key returns [String value] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.map_key_return map_key() throws RecognitionException {
        LogicalPlanGenerator.map_key_return retval = new LogicalPlanGenerator.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING398=null;

        CommonTree QUOTEDSTRING398_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1887:2: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1887:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING398=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key5581); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING398_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING398);


            adaptor.addChild(root_0, QUOTEDSTRING398_tree);
            }


            if ( state.backtracking==0 ) { retval.value = builder.unquote( (QUOTEDSTRING398!=null?QUOTEDSTRING398.getText():null) ); }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_key"


    public static class bag_return extends TreeRuleReturnScope {
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1890:1: bag returns [Object value] : ^( BAG_VAL ( tuple )* ) ;
    public final LogicalPlanGenerator.bag_return bag() throws RecognitionException {
        LogicalPlanGenerator.bag_return retval = new LogicalPlanGenerator.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL399=null;
        LogicalPlanGenerator.tuple_return tuple400 =null;


        CommonTree BAG_VAL399_tree=null;

         DataBag dataBag = builder.createDataBag(); 
        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1892:2: ( ^( BAG_VAL ( tuple )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1892:4: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL399=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag5603); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL399_tree = (CommonTree)adaptor.dupNode(BAG_VAL399);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL399_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1892:15: ( tuple )*
                loop126:
                do {
                    int alt126=2;
                    int LA126_0 = input.LA(1);

                    if ( (LA126_0==TUPLE_VAL) ) {
                        alt126=1;
                    }


                    switch (alt126) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1892:17: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag5607);
                	    tuple400=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple400.getTree());


                	    if ( state.backtracking==0 ) { dataBag.add( (tuple400!=null?tuple400.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop126;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = dataBag;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        public Tuple value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1898:1: tuple returns [Tuple value] : ^( TUPLE_VAL ( literal )* ) ;
    public final LogicalPlanGenerator.tuple_return tuple() throws RecognitionException {
        LogicalPlanGenerator.tuple_return retval = new LogicalPlanGenerator.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL401=null;
        LogicalPlanGenerator.literal_return literal402 =null;


        CommonTree TUPLE_VAL401_tree=null;

         List<Object> objList = new ArrayList<Object>(); 
        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1900:2: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1900:4: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL401=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple5639); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL401_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL401);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL401_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1900:17: ( literal )*
                loop127:
                do {
                    int alt127=2;
                    int LA127_0 = input.LA(1);

                    if ( (LA127_0==BIGDECIMALNUMBER||LA127_0==BIGINTEGERNUMBER||LA127_0==DOUBLENUMBER||LA127_0==FALSE||LA127_0==FLOATNUMBER||LA127_0==INTEGER||LA127_0==LONGINTEGER||LA127_0==MINUS||LA127_0==NULL||LA127_0==QUOTEDSTRING||LA127_0==TRUE||LA127_0==BAG_VAL||LA127_0==MAP_VAL||LA127_0==TUPLE_VAL) ) {
                        alt127=1;
                    }


                    switch (alt127) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1900:19: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple5643);
                	    literal402=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal402.getTree());


                	    if ( state.backtracking==0 ) { objList.add( (literal402!=null?literal402.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop127;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = builder.buildTuple( objList );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1907:1: eid returns [String id] : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE );
    public final LogicalPlanGenerator.eid_return eid() throws RecognitionException {
        LogicalPlanGenerator.eid_return retval = new LogicalPlanGenerator.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT404=null;
        CommonTree RETURNS405=null;
        CommonTree DEFINE406=null;
        CommonTree LOAD407=null;
        CommonTree FILTER408=null;
        CommonTree FOREACH409=null;
        CommonTree MATCHES410=null;
        CommonTree ORDER411=null;
        CommonTree DISTINCT412=null;
        CommonTree COGROUP413=null;
        CommonTree CUBE414=null;
        CommonTree ROLLUP415=null;
        CommonTree JOIN416=null;
        CommonTree CROSS417=null;
        CommonTree UNION418=null;
        CommonTree SPLIT419=null;
        CommonTree INTO420=null;
        CommonTree IF421=null;
        CommonTree ALL422=null;
        CommonTree AS423=null;
        CommonTree BY424=null;
        CommonTree USING425=null;
        CommonTree INNER426=null;
        CommonTree OUTER427=null;
        CommonTree PARALLEL428=null;
        CommonTree PARTITION429=null;
        CommonTree GROUP430=null;
        CommonTree AND431=null;
        CommonTree OR432=null;
        CommonTree NOT433=null;
        CommonTree GENERATE434=null;
        CommonTree FLATTEN435=null;
        CommonTree EVAL436=null;
        CommonTree ASC437=null;
        CommonTree DESC438=null;
        CommonTree BOOLEAN439=null;
        CommonTree INT440=null;
        CommonTree LONG441=null;
        CommonTree FLOAT442=null;
        CommonTree DOUBLE443=null;
        CommonTree BIGINTEGER444=null;
        CommonTree BIGDECIMAL445=null;
        CommonTree DATETIME446=null;
        CommonTree CHARARRAY447=null;
        CommonTree BYTEARRAY448=null;
        CommonTree BAG449=null;
        CommonTree TUPLE450=null;
        CommonTree MAP451=null;
        CommonTree IS452=null;
        CommonTree NULL453=null;
        CommonTree TRUE454=null;
        CommonTree FALSE455=null;
        CommonTree STREAM456=null;
        CommonTree THROUGH457=null;
        CommonTree STORE458=null;
        CommonTree MAPREDUCE459=null;
        CommonTree SHIP460=null;
        CommonTree CACHE461=null;
        CommonTree INPUT462=null;
        CommonTree OUTPUT463=null;
        CommonTree STDERROR464=null;
        CommonTree STDIN465=null;
        CommonTree STDOUT466=null;
        CommonTree LIMIT467=null;
        CommonTree SAMPLE468=null;
        CommonTree LEFT469=null;
        CommonTree RIGHT470=null;
        CommonTree FULL471=null;
        CommonTree IDENTIFIER472=null;
        CommonTree TOBAG473=null;
        CommonTree TOMAP474=null;
        CommonTree TOTUPLE475=null;
        LogicalPlanGenerator.rel_str_op_return rel_str_op403 =null;


        CommonTree IMPORT404_tree=null;
        CommonTree RETURNS405_tree=null;
        CommonTree DEFINE406_tree=null;
        CommonTree LOAD407_tree=null;
        CommonTree FILTER408_tree=null;
        CommonTree FOREACH409_tree=null;
        CommonTree MATCHES410_tree=null;
        CommonTree ORDER411_tree=null;
        CommonTree DISTINCT412_tree=null;
        CommonTree COGROUP413_tree=null;
        CommonTree CUBE414_tree=null;
        CommonTree ROLLUP415_tree=null;
        CommonTree JOIN416_tree=null;
        CommonTree CROSS417_tree=null;
        CommonTree UNION418_tree=null;
        CommonTree SPLIT419_tree=null;
        CommonTree INTO420_tree=null;
        CommonTree IF421_tree=null;
        CommonTree ALL422_tree=null;
        CommonTree AS423_tree=null;
        CommonTree BY424_tree=null;
        CommonTree USING425_tree=null;
        CommonTree INNER426_tree=null;
        CommonTree OUTER427_tree=null;
        CommonTree PARALLEL428_tree=null;
        CommonTree PARTITION429_tree=null;
        CommonTree GROUP430_tree=null;
        CommonTree AND431_tree=null;
        CommonTree OR432_tree=null;
        CommonTree NOT433_tree=null;
        CommonTree GENERATE434_tree=null;
        CommonTree FLATTEN435_tree=null;
        CommonTree EVAL436_tree=null;
        CommonTree ASC437_tree=null;
        CommonTree DESC438_tree=null;
        CommonTree BOOLEAN439_tree=null;
        CommonTree INT440_tree=null;
        CommonTree LONG441_tree=null;
        CommonTree FLOAT442_tree=null;
        CommonTree DOUBLE443_tree=null;
        CommonTree BIGINTEGER444_tree=null;
        CommonTree BIGDECIMAL445_tree=null;
        CommonTree DATETIME446_tree=null;
        CommonTree CHARARRAY447_tree=null;
        CommonTree BYTEARRAY448_tree=null;
        CommonTree BAG449_tree=null;
        CommonTree TUPLE450_tree=null;
        CommonTree MAP451_tree=null;
        CommonTree IS452_tree=null;
        CommonTree NULL453_tree=null;
        CommonTree TRUE454_tree=null;
        CommonTree FALSE455_tree=null;
        CommonTree STREAM456_tree=null;
        CommonTree THROUGH457_tree=null;
        CommonTree STORE458_tree=null;
        CommonTree MAPREDUCE459_tree=null;
        CommonTree SHIP460_tree=null;
        CommonTree CACHE461_tree=null;
        CommonTree INPUT462_tree=null;
        CommonTree OUTPUT463_tree=null;
        CommonTree STDERROR464_tree=null;
        CommonTree STDIN465_tree=null;
        CommonTree STDOUT466_tree=null;
        CommonTree LIMIT467_tree=null;
        CommonTree SAMPLE468_tree=null;
        CommonTree LEFT469_tree=null;
        CommonTree RIGHT470_tree=null;
        CommonTree FULL471_tree=null;
        CommonTree IDENTIFIER472_tree=null;
        CommonTree TOBAG473_tree=null;
        CommonTree TOMAP474_tree=null;
        CommonTree TOTUPLE475_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1907:24: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE )
            int alt128=73;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt128=1;
                }
                break;
            case IMPORT:
                {
                alt128=2;
                }
                break;
            case RETURNS:
                {
                alt128=3;
                }
                break;
            case DEFINE:
                {
                alt128=4;
                }
                break;
            case LOAD:
                {
                alt128=5;
                }
                break;
            case FILTER:
                {
                alt128=6;
                }
                break;
            case FOREACH:
                {
                alt128=7;
                }
                break;
            case MATCHES:
                {
                alt128=8;
                }
                break;
            case ORDER:
                {
                alt128=9;
                }
                break;
            case DISTINCT:
                {
                alt128=10;
                }
                break;
            case COGROUP:
                {
                alt128=11;
                }
                break;
            case CUBE:
                {
                alt128=12;
                }
                break;
            case ROLLUP:
                {
                alt128=13;
                }
                break;
            case JOIN:
                {
                alt128=14;
                }
                break;
            case CROSS:
                {
                alt128=15;
                }
                break;
            case UNION:
                {
                alt128=16;
                }
                break;
            case SPLIT:
                {
                alt128=17;
                }
                break;
            case INTO:
                {
                alt128=18;
                }
                break;
            case IF:
                {
                alt128=19;
                }
                break;
            case ALL:
                {
                alt128=20;
                }
                break;
            case AS:
                {
                alt128=21;
                }
                break;
            case BY:
                {
                alt128=22;
                }
                break;
            case USING:
                {
                alt128=23;
                }
                break;
            case INNER:
                {
                alt128=24;
                }
                break;
            case OUTER:
                {
                alt128=25;
                }
                break;
            case PARALLEL:
                {
                alt128=26;
                }
                break;
            case PARTITION:
                {
                alt128=27;
                }
                break;
            case GROUP:
                {
                alt128=28;
                }
                break;
            case AND:
                {
                alt128=29;
                }
                break;
            case OR:
                {
                alt128=30;
                }
                break;
            case NOT:
                {
                alt128=31;
                }
                break;
            case GENERATE:
                {
                alt128=32;
                }
                break;
            case FLATTEN:
                {
                alt128=33;
                }
                break;
            case EVAL:
                {
                alt128=34;
                }
                break;
            case ASC:
                {
                alt128=35;
                }
                break;
            case DESC:
                {
                alt128=36;
                }
                break;
            case BOOLEAN:
                {
                alt128=37;
                }
                break;
            case INT:
                {
                alt128=38;
                }
                break;
            case LONG:
                {
                alt128=39;
                }
                break;
            case FLOAT:
                {
                alt128=40;
                }
                break;
            case DOUBLE:
                {
                alt128=41;
                }
                break;
            case BIGINTEGER:
                {
                alt128=42;
                }
                break;
            case BIGDECIMAL:
                {
                alt128=43;
                }
                break;
            case DATETIME:
                {
                alt128=44;
                }
                break;
            case CHARARRAY:
                {
                alt128=45;
                }
                break;
            case BYTEARRAY:
                {
                alt128=46;
                }
                break;
            case BAG:
                {
                alt128=47;
                }
                break;
            case TUPLE:
                {
                alt128=48;
                }
                break;
            case MAP:
                {
                alt128=49;
                }
                break;
            case IS:
                {
                alt128=50;
                }
                break;
            case NULL:
                {
                alt128=51;
                }
                break;
            case TRUE:
                {
                alt128=52;
                }
                break;
            case FALSE:
                {
                alt128=53;
                }
                break;
            case STREAM:
                {
                alt128=54;
                }
                break;
            case THROUGH:
                {
                alt128=55;
                }
                break;
            case STORE:
                {
                alt128=56;
                }
                break;
            case MAPREDUCE:
                {
                alt128=57;
                }
                break;
            case SHIP:
                {
                alt128=58;
                }
                break;
            case CACHE:
                {
                alt128=59;
                }
                break;
            case INPUT:
                {
                alt128=60;
                }
                break;
            case OUTPUT:
                {
                alt128=61;
                }
                break;
            case STDERROR:
                {
                alt128=62;
                }
                break;
            case STDIN:
                {
                alt128=63;
                }
                break;
            case STDOUT:
                {
                alt128=64;
                }
                break;
            case LIMIT:
                {
                alt128=65;
                }
                break;
            case SAMPLE:
                {
                alt128=66;
                }
                break;
            case LEFT:
                {
                alt128=67;
                }
                break;
            case RIGHT:
                {
                alt128=68;
                }
                break;
            case FULL:
                {
                alt128=69;
                }
                break;
            case IDENTIFIER:
                {
                alt128=70;
                }
                break;
            case TOBAG:
                {
                alt128=71;
                }
                break;
            case TOMAP:
                {
                alt128=72;
                }
                break;
            case TOTUPLE:
                {
                alt128=73;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;

            }

            switch (alt128) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1907:26: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid5668);
                    rel_str_op403=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op403.getTree());


                    if ( state.backtracking==0 ) { retval.id = (rel_str_op403!=null?rel_str_op403.id:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1908:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT404=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid5678); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT404_tree = (CommonTree)adaptor.dupNode(IMPORT404);


                    adaptor.addChild(root_0, IMPORT404_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IMPORT404!=null?IMPORT404.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1909:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS405=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid5688); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS405_tree = (CommonTree)adaptor.dupNode(RETURNS405);


                    adaptor.addChild(root_0, RETURNS405_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RETURNS405!=null?RETURNS405.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1910:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE406=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid5698); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE406_tree = (CommonTree)adaptor.dupNode(DEFINE406);


                    adaptor.addChild(root_0, DEFINE406_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DEFINE406!=null?DEFINE406.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1911:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD407=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid5708); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD407_tree = (CommonTree)adaptor.dupNode(LOAD407);


                    adaptor.addChild(root_0, LOAD407_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LOAD407!=null?LOAD407.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1912:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER408=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid5718); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER408_tree = (CommonTree)adaptor.dupNode(FILTER408);


                    adaptor.addChild(root_0, FILTER408_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FILTER408!=null?FILTER408.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1913:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH409=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid5728); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH409_tree = (CommonTree)adaptor.dupNode(FOREACH409);


                    adaptor.addChild(root_0, FOREACH409_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FOREACH409!=null?FOREACH409.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1914:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES410=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid5738); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES410_tree = (CommonTree)adaptor.dupNode(MATCHES410);


                    adaptor.addChild(root_0, MATCHES410_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MATCHES410!=null?MATCHES410.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1915:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER411=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid5748); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER411_tree = (CommonTree)adaptor.dupNode(ORDER411);


                    adaptor.addChild(root_0, ORDER411_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ORDER411!=null?ORDER411.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1916:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT412=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid5758); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT412_tree = (CommonTree)adaptor.dupNode(DISTINCT412);


                    adaptor.addChild(root_0, DISTINCT412_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DISTINCT412!=null?DISTINCT412.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1917:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP413=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid5768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP413_tree = (CommonTree)adaptor.dupNode(COGROUP413);


                    adaptor.addChild(root_0, COGROUP413_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (COGROUP413!=null?COGROUP413.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1918:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE414=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid5778); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE414_tree = (CommonTree)adaptor.dupNode(CUBE414);


                    adaptor.addChild(root_0, CUBE414_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CUBE414!=null?CUBE414.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1919:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP415=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid5788); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP415_tree = (CommonTree)adaptor.dupNode(ROLLUP415);


                    adaptor.addChild(root_0, ROLLUP415_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ROLLUP415!=null?ROLLUP415.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1920:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN416=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid5798); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN416_tree = (CommonTree)adaptor.dupNode(JOIN416);


                    adaptor.addChild(root_0, JOIN416_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (JOIN416!=null?JOIN416.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1921:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS417=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid5808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS417_tree = (CommonTree)adaptor.dupNode(CROSS417);


                    adaptor.addChild(root_0, CROSS417_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CROSS417!=null?CROSS417.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1922:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION418=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid5818); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION418_tree = (CommonTree)adaptor.dupNode(UNION418);


                    adaptor.addChild(root_0, UNION418_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (UNION418!=null?UNION418.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1923:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT419=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid5828); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT419_tree = (CommonTree)adaptor.dupNode(SPLIT419);


                    adaptor.addChild(root_0, SPLIT419_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SPLIT419!=null?SPLIT419.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1924:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO420=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid5838); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO420_tree = (CommonTree)adaptor.dupNode(INTO420);


                    adaptor.addChild(root_0, INTO420_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INTO420!=null?INTO420.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1925:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF421=(CommonTree)match(input,IF,FOLLOW_IF_in_eid5848); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF421_tree = (CommonTree)adaptor.dupNode(IF421);


                    adaptor.addChild(root_0, IF421_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IF421!=null?IF421.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1926:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL422=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid5858); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL422_tree = (CommonTree)adaptor.dupNode(ALL422);


                    adaptor.addChild(root_0, ALL422_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ALL422!=null?ALL422.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1927:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS423=(CommonTree)match(input,AS,FOLLOW_AS_in_eid5868); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS423_tree = (CommonTree)adaptor.dupNode(AS423);


                    adaptor.addChild(root_0, AS423_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AS423!=null?AS423.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1928:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY424=(CommonTree)match(input,BY,FOLLOW_BY_in_eid5878); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY424_tree = (CommonTree)adaptor.dupNode(BY424);


                    adaptor.addChild(root_0, BY424_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BY424!=null?BY424.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1929:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING425=(CommonTree)match(input,USING,FOLLOW_USING_in_eid5888); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING425_tree = (CommonTree)adaptor.dupNode(USING425);


                    adaptor.addChild(root_0, USING425_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (USING425!=null?USING425.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1930:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER426=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid5898); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER426_tree = (CommonTree)adaptor.dupNode(INNER426);


                    adaptor.addChild(root_0, INNER426_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INNER426!=null?INNER426.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1931:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER427=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid5908); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER427_tree = (CommonTree)adaptor.dupNode(OUTER427);


                    adaptor.addChild(root_0, OUTER427_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTER427!=null?OUTER427.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1932:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL428=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid5918); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL428_tree = (CommonTree)adaptor.dupNode(PARALLEL428);


                    adaptor.addChild(root_0, PARALLEL428_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARALLEL428!=null?PARALLEL428.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1933:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION429=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid5928); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION429_tree = (CommonTree)adaptor.dupNode(PARTITION429);


                    adaptor.addChild(root_0, PARTITION429_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARTITION429!=null?PARTITION429.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1934:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP430=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid5938); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP430_tree = (CommonTree)adaptor.dupNode(GROUP430);


                    adaptor.addChild(root_0, GROUP430_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GROUP430!=null?GROUP430.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1935:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND431=(CommonTree)match(input,AND,FOLLOW_AND_in_eid5948); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND431_tree = (CommonTree)adaptor.dupNode(AND431);


                    adaptor.addChild(root_0, AND431_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AND431!=null?AND431.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1936:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR432=(CommonTree)match(input,OR,FOLLOW_OR_in_eid5958); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR432_tree = (CommonTree)adaptor.dupNode(OR432);


                    adaptor.addChild(root_0, OR432_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OR432!=null?OR432.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1937:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT433=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid5968); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT433_tree = (CommonTree)adaptor.dupNode(NOT433);


                    adaptor.addChild(root_0, NOT433_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NOT433!=null?NOT433.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1938:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE434=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid5978); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE434_tree = (CommonTree)adaptor.dupNode(GENERATE434);


                    adaptor.addChild(root_0, GENERATE434_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GENERATE434!=null?GENERATE434.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1939:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN435=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid5988); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN435_tree = (CommonTree)adaptor.dupNode(FLATTEN435);


                    adaptor.addChild(root_0, FLATTEN435_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLATTEN435!=null?FLATTEN435.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1940:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL436=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid5998); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL436_tree = (CommonTree)adaptor.dupNode(EVAL436);


                    adaptor.addChild(root_0, EVAL436_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (EVAL436!=null?EVAL436.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1941:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC437=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid6008); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC437_tree = (CommonTree)adaptor.dupNode(ASC437);


                    adaptor.addChild(root_0, ASC437_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ASC437!=null?ASC437.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1942:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC438=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid6018); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC438_tree = (CommonTree)adaptor.dupNode(DESC438);


                    adaptor.addChild(root_0, DESC438_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DESC438!=null?DESC438.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1943:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN439=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid6028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN439_tree = (CommonTree)adaptor.dupNode(BOOLEAN439);


                    adaptor.addChild(root_0, BOOLEAN439_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BOOLEAN439!=null?BOOLEAN439.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1944:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT440=(CommonTree)match(input,INT,FOLLOW_INT_in_eid6038); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT440_tree = (CommonTree)adaptor.dupNode(INT440);


                    adaptor.addChild(root_0, INT440_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INT440!=null?INT440.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1945:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG441=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid6048); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG441_tree = (CommonTree)adaptor.dupNode(LONG441);


                    adaptor.addChild(root_0, LONG441_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LONG441!=null?LONG441.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1946:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT442=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid6058); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT442_tree = (CommonTree)adaptor.dupNode(FLOAT442);


                    adaptor.addChild(root_0, FLOAT442_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLOAT442!=null?FLOAT442.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1947:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE443=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid6068); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE443_tree = (CommonTree)adaptor.dupNode(DOUBLE443);


                    adaptor.addChild(root_0, DOUBLE443_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DOUBLE443!=null?DOUBLE443.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1948:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER444=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid6078); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER444_tree = (CommonTree)adaptor.dupNode(BIGINTEGER444);


                    adaptor.addChild(root_0, BIGINTEGER444_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BIGINTEGER444!=null?BIGINTEGER444.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1949:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL445=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid6088); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL445_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL445);


                    adaptor.addChild(root_0, BIGDECIMAL445_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BIGDECIMAL445!=null?BIGDECIMAL445.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1950:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME446=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid6098); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME446_tree = (CommonTree)adaptor.dupNode(DATETIME446);


                    adaptor.addChild(root_0, DATETIME446_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DATETIME446!=null?DATETIME446.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1951:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY447=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid6108); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY447_tree = (CommonTree)adaptor.dupNode(CHARARRAY447);


                    adaptor.addChild(root_0, CHARARRAY447_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CHARARRAY447!=null?CHARARRAY447.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1952:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY448=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid6118); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY448_tree = (CommonTree)adaptor.dupNode(BYTEARRAY448);


                    adaptor.addChild(root_0, BYTEARRAY448_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BYTEARRAY448!=null?BYTEARRAY448.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1953:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG449=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid6128); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG449_tree = (CommonTree)adaptor.dupNode(BAG449);


                    adaptor.addChild(root_0, BAG449_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BAG449!=null?BAG449.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1954:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE450=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid6138); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE450_tree = (CommonTree)adaptor.dupNode(TUPLE450);


                    adaptor.addChild(root_0, TUPLE450_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TUPLE450!=null?TUPLE450.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1955:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP451=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid6148); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP451_tree = (CommonTree)adaptor.dupNode(MAP451);


                    adaptor.addChild(root_0, MAP451_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAP451!=null?MAP451.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1956:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS452=(CommonTree)match(input,IS,FOLLOW_IS_in_eid6158); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS452_tree = (CommonTree)adaptor.dupNode(IS452);


                    adaptor.addChild(root_0, IS452_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IS452!=null?IS452.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1957:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL453=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid6168); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL453_tree = (CommonTree)adaptor.dupNode(NULL453);


                    adaptor.addChild(root_0, NULL453_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NULL453!=null?NULL453.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1958:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE454=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid6178); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE454_tree = (CommonTree)adaptor.dupNode(TRUE454);


                    adaptor.addChild(root_0, TRUE454_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TRUE454!=null?TRUE454.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1959:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE455=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid6188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE455_tree = (CommonTree)adaptor.dupNode(FALSE455);


                    adaptor.addChild(root_0, FALSE455_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FALSE455!=null?FALSE455.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1960:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM456=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid6198); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM456_tree = (CommonTree)adaptor.dupNode(STREAM456);


                    adaptor.addChild(root_0, STREAM456_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STREAM456!=null?STREAM456.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1961:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH457=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid6208); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH457_tree = (CommonTree)adaptor.dupNode(THROUGH457);


                    adaptor.addChild(root_0, THROUGH457_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (THROUGH457!=null?THROUGH457.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1962:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE458=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid6218); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE458_tree = (CommonTree)adaptor.dupNode(STORE458);


                    adaptor.addChild(root_0, STORE458_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STORE458!=null?STORE458.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1963:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE459=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid6228); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE459_tree = (CommonTree)adaptor.dupNode(MAPREDUCE459);


                    adaptor.addChild(root_0, MAPREDUCE459_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAPREDUCE459!=null?MAPREDUCE459.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1964:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP460=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid6238); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP460_tree = (CommonTree)adaptor.dupNode(SHIP460);


                    adaptor.addChild(root_0, SHIP460_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SHIP460!=null?SHIP460.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1965:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE461=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid6248); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE461_tree = (CommonTree)adaptor.dupNode(CACHE461);


                    adaptor.addChild(root_0, CACHE461_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CACHE461!=null?CACHE461.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1966:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT462=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid6258); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT462_tree = (CommonTree)adaptor.dupNode(INPUT462);


                    adaptor.addChild(root_0, INPUT462_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INPUT462!=null?INPUT462.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1967:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT463=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid6268); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT463_tree = (CommonTree)adaptor.dupNode(OUTPUT463);


                    adaptor.addChild(root_0, OUTPUT463_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTPUT463!=null?OUTPUT463.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1968:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR464=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid6278); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR464_tree = (CommonTree)adaptor.dupNode(STDERROR464);


                    adaptor.addChild(root_0, STDERROR464_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDERROR464!=null?STDERROR464.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1969:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN465=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid6288); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN465_tree = (CommonTree)adaptor.dupNode(STDIN465);


                    adaptor.addChild(root_0, STDIN465_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDIN465!=null?STDIN465.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1970:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT466=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid6298); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT466_tree = (CommonTree)adaptor.dupNode(STDOUT466);


                    adaptor.addChild(root_0, STDOUT466_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDOUT466!=null?STDOUT466.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1971:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT467=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid6308); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT467_tree = (CommonTree)adaptor.dupNode(LIMIT467);


                    adaptor.addChild(root_0, LIMIT467_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LIMIT467!=null?LIMIT467.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1972:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE468=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid6318); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE468_tree = (CommonTree)adaptor.dupNode(SAMPLE468);


                    adaptor.addChild(root_0, SAMPLE468_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SAMPLE468!=null?SAMPLE468.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1973:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT469=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid6328); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT469_tree = (CommonTree)adaptor.dupNode(LEFT469);


                    adaptor.addChild(root_0, LEFT469_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LEFT469!=null?LEFT469.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1974:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT470=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid6338); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT470_tree = (CommonTree)adaptor.dupNode(RIGHT470);


                    adaptor.addChild(root_0, RIGHT470_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RIGHT470!=null?RIGHT470.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1975:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL471=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid6348); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL471_tree = (CommonTree)adaptor.dupNode(FULL471);


                    adaptor.addChild(root_0, FULL471_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FULL471!=null?FULL471.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1976:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER472=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid6358); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER472_tree = (CommonTree)adaptor.dupNode(IDENTIFIER472);


                    adaptor.addChild(root_0, IDENTIFIER472_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IDENTIFIER472!=null?IDENTIFIER472.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1977:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG473=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid6368); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG473_tree = (CommonTree)adaptor.dupNode(TOBAG473);


                    adaptor.addChild(root_0, TOBAG473_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOBAG"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1978:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP474=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid6378); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP474_tree = (CommonTree)adaptor.dupNode(TOMAP474);


                    adaptor.addChild(root_0, TOMAP474_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOMAP"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1979:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE475=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid6388); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE475_tree = (CommonTree)adaptor.dupNode(TOTUPLE475);


                    adaptor.addChild(root_0, TOTUPLE475_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOTUPLE"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "eid"


    public static class rel_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1983:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_op_return rel_op() throws RecognitionException {
        LogicalPlanGenerator.rel_op_return retval = new LogicalPlanGenerator.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES482=null;
        LogicalPlanGenerator.rel_op_eq_return rel_op_eq476 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne477 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt478 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte479 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt480 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte481 =null;


        CommonTree STR_OP_MATCHES482_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1983:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt129=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt129=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt129=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt129=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt129=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt129=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt129=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt129=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;

            }

            switch (alt129) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1983:10: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op6400);
                    rel_op_eq476=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq476.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1984:10: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op6411);
                    rel_op_ne477=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne477.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1985:10: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op6422);
                    rel_op_gt478=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt478.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1986:10: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op6433);
                    rel_op_gte479=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte479.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1987:10: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op6444);
                    rel_op_lt480=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt480.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1988:10: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op6455);
                    rel_op_lte481=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte481.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1989:10: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES482=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op6466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES482_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES482);


                    adaptor.addChild(root_0, STR_OP_MATCHES482_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op"


    public static class rel_op_eq_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_eq"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1992:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final LogicalPlanGenerator.rel_op_eq_return rel_op_eq() throws RecognitionException {
        LogicalPlanGenerator.rel_op_eq_return retval = new LogicalPlanGenerator.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set483=null;

        CommonTree set483_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1992:11: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set483=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set483_tree = (CommonTree)adaptor.dupNode(set483);


                adaptor.addChild(root_0, set483_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1995:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final LogicalPlanGenerator.rel_op_ne_return rel_op_ne() throws RecognitionException {
        LogicalPlanGenerator.rel_op_ne_return retval = new LogicalPlanGenerator.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set484=null;

        CommonTree set484_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1995:11: ( STR_OP_NE | NUM_OP_NE )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set484=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set484_tree = (CommonTree)adaptor.dupNode(set484);


                adaptor.addChild(root_0, set484_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1998:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final LogicalPlanGenerator.rel_op_gt_return rel_op_gt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gt_return retval = new LogicalPlanGenerator.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set485=null;

        CommonTree set485_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1998:11: ( STR_OP_GT | NUM_OP_GT )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set485=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set485_tree = (CommonTree)adaptor.dupNode(set485);


                adaptor.addChild(root_0, set485_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2001:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final LogicalPlanGenerator.rel_op_gte_return rel_op_gte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gte_return retval = new LogicalPlanGenerator.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set486=null;

        CommonTree set486_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2001:12: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set486=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set486_tree = (CommonTree)adaptor.dupNode(set486);


                adaptor.addChild(root_0, set486_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2004:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final LogicalPlanGenerator.rel_op_lt_return rel_op_lt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lt_return retval = new LogicalPlanGenerator.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set487=null;

        CommonTree set487_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2004:11: ( STR_OP_LT | NUM_OP_LT )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set487=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set487_tree = (CommonTree)adaptor.dupNode(set487);


                adaptor.addChild(root_0, set487_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2007:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final LogicalPlanGenerator.rel_op_lte_return rel_op_lte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lte_return retval = new LogicalPlanGenerator.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set488=null;

        CommonTree set488_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2007:12: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set488=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set488_tree = (CommonTree)adaptor.dupNode(set488);


                adaptor.addChild(root_0, set488_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2010:1: rel_str_op returns [String id] : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_str_op_return rel_str_op() throws RecognitionException {
        LogicalPlanGenerator.rel_str_op_return retval = new LogicalPlanGenerator.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ489=null;
        CommonTree STR_OP_NE490=null;
        CommonTree STR_OP_GT491=null;
        CommonTree STR_OP_LT492=null;
        CommonTree STR_OP_GTE493=null;
        CommonTree STR_OP_LTE494=null;
        CommonTree STR_OP_MATCHES495=null;

        CommonTree STR_OP_EQ489_tree=null;
        CommonTree STR_OP_NE490_tree=null;
        CommonTree STR_OP_GT491_tree=null;
        CommonTree STR_OP_LT492_tree=null;
        CommonTree STR_OP_GTE493_tree=null;
        CommonTree STR_OP_LTE494_tree=null;
        CommonTree STR_OP_MATCHES495_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2011:2: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            int alt130=7;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
                {
                alt130=1;
                }
                break;
            case STR_OP_NE:
                {
                alt130=2;
                }
                break;
            case STR_OP_GT:
                {
                alt130=3;
                }
                break;
            case STR_OP_LT:
                {
                alt130=4;
                }
                break;
            case STR_OP_GTE:
                {
                alt130=5;
                }
                break;
            case STR_OP_LTE:
                {
                alt130=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt130=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;

            }

            switch (alt130) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2011:4: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ489=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_str_op6557); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ489_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ489);


                    adaptor.addChild(root_0, STR_OP_EQ489_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_EQ489!=null?STR_OP_EQ489.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2012:4: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE490=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_str_op6564); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE490_tree = (CommonTree)adaptor.dupNode(STR_OP_NE490);


                    adaptor.addChild(root_0, STR_OP_NE490_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_NE490!=null?STR_OP_NE490.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2013:4: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT491=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_str_op6571); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT491_tree = (CommonTree)adaptor.dupNode(STR_OP_GT491);


                    adaptor.addChild(root_0, STR_OP_GT491_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GT491!=null?STR_OP_GT491.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2014:4: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT492=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_str_op6578); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT492_tree = (CommonTree)adaptor.dupNode(STR_OP_LT492);


                    adaptor.addChild(root_0, STR_OP_LT492_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LT492!=null?STR_OP_LT492.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2015:4: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE493=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_str_op6585); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE493_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE493);


                    adaptor.addChild(root_0, STR_OP_GTE493_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GTE493!=null?STR_OP_GTE493.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2016:4: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE494=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_str_op6592); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE494_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE494);


                    adaptor.addChild(root_0, STR_OP_LTE494_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LTE494!=null?STR_OP_LTE494.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:2017:4: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES495=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_str_op6599); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES495_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES495);


                    adaptor.addChild(root_0, STR_OP_MATCHES495_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_MATCHES495!=null?STR_OP_MATCHES495.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred141_LogicalPlanGenerator
    public final void synpred141_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1142:20: ( INTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1142:20: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred141_LogicalPlanGenerator3475); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred141_LogicalPlanGenerator

    // $ANTLR start synpred142_LogicalPlanGenerator
    public final void synpred142_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1147:4: ( LONGINTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1147:4: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred142_LogicalPlanGenerator3485); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred142_LogicalPlanGenerator

    // $ANTLR start synpred143_LogicalPlanGenerator
    public final void synpred143_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1166:20: ( DOUBLENUMBER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1166:20: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred143_LogicalPlanGenerator3537); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred143_LogicalPlanGenerator

    // $ANTLR start synpred173_LogicalPlanGenerator
    public final void synpred173_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1355:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1355:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred173_LogicalPlanGenerator4066);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
            input.consume();
            state.errorRecovery=false;
            state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1360:66: ( OUTER )?
        int alt144=2;
        int LA144_0 = input.LA(1);

        if ( (LA144_0==OUTER) ) {
            alt144=1;
        }
        switch (alt144) {
            case 1 :
                // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1360:66: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred173_LogicalPlanGenerator4114); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred173_LogicalPlanGenerator4117);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred173_LogicalPlanGenerator

    // $ANTLR start synpred190_LogicalPlanGenerator
    public final void synpred190_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1544:31: ( INTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/LogicalPlanGenerator.g:1544:31: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred190_LogicalPlanGenerator4689); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred190_LogicalPlanGenerator

    // Delegated rules

    public final boolean synpred190_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred190_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred143_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred143_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred142_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred142_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred173_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred173_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred141_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred141_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query87 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query89 = new BitSet(new long[]{0x0000000000040008L,0x0008000000000000L,0x0000480000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_cache_statement_in_statement126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_cache_clause_in_rel_cache_statement153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement165 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement169 = new BitSet(new long[]{0x0024200113200000L,0x0300408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_op_clause_in_general_statement180 = new BitSet(new long[]{0x0000000000000008L,0x0000000080000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement182 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause201 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause203 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CACHE_in_rel_cache_clause221 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rel_cache_clause223 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause243 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause245 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause557 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause559 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause561 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause576 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause578 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_define_clause580 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd609 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd613 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd618 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd623 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd627 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd631 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause654 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause656 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list673 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause691 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause693 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause716 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause720 = new BitSet(new long[]{0x0000000000000008L,0x00C0004000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd754 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd766 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd781 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd793 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd808 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd820 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause848 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause852 = new BitSet(new long[]{0x0000000000000008L,0x00C0004000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause880 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause890 = new BitSet(new long[]{0x4000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause912 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause965 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause967 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause969 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause973 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause1010 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause1012 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def1040 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def1042 = new BitSet(new long[]{0x200080100412A808L,0x0000000000000400L,0x0004000800000800L});
    public static final BitSet FOLLOW_type_in_field_def1046 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1065 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def1069 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1100 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_simple_type_in_type1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1258 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1298 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1300 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1303 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1326 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1328 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1357 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1359 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1373 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1375 = new BitSet(new long[]{0x0000000000000008L,0x0000004000010000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1377 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1407 = new BitSet(new long[]{0x0000000400000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_PERIOD_in_func_name1421 = new BitSet(new long[]{0xBBBCE8115737AF50L,0xFFE96301EC06370EL,0x006380000000007DL});
    public static final BitSet FOLLOW_DOLLAR_in_func_name1427 = new BitSet(new long[]{0xBBBCE8115737AF50L,0xFFE96301EC06370EL,0x006380000000007DL});
    public static final BitSet FOLLOW_eid_in_func_name1443 = new BitSet(new long[]{0x0000000400000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1472 = new BitSet(new long[]{0x0000000000000002L,0x0000004000010000L});
    public static final BitSet FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1482 = new BitSet(new long[]{0x0000000000000002L,0x0000004000010000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1524 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1526 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1543 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1574 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1576 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1599 = new BitSet(new long[]{0x0000000002000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1635 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1641 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1665 = new BitSet(new long[]{0x40A2082A02005002L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_group_clause1739 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1741 = new BitSet(new long[]{0x00A4200113200088L,0x030040C108002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_type_in_group_clause1746 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1753 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COGROUP_in_group_clause1768 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1770 = new BitSet(new long[]{0x00A4200113200088L,0x030040C108002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_type_in_group_clause1775 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1782 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1823 = new BitSet(new long[]{0x0000000000010010L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1827 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1851 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1875 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_INNER_in_group_item1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_group_item1906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_rel1924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_previous_rel_in_rel1934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inline_op_in_rel1944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROBA_in_previous_rel1956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_inline_op1978 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_parallel_clause_in_inline_op1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item2006 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item2016 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item2024 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item2032 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause2069 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause2071 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause2089 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause2091 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause2093 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause2095 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause2129 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause2131 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_cond_in_filter_clause2133 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond2157 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2163 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_cond_in_cond2170 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond2185 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2191 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_cond_in_cond2198 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond2213 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2219 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond2234 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2236 = new BitSet(new long[]{0x0000000000000008L,0x0000000000020000L});
    public static final BitSet FOLLOW_NOT_in_cond2239 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_eq_in_cond2254 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2260 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_cond2267 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_ne_in_cond2282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2288 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_cond2295 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lt_in_cond2310 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2316 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_cond2323 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lte_in_cond2338 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2344 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_cond2351 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gt_in_cond2366 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2372 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_cond2379 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gte_in_cond2394 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2400 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_cond2407 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_cond2422 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2428 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_cond2435 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond2448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond2459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond2472 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2478 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval2507 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2511 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval2546 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval2548 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2552 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_INVOKER_FUNC_EVAL_in_func_eval2572 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2576 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2580 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2584 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2588 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_expr_in_real_arg2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg2628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr2661 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2667 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr2674 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr2689 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2695 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr2702 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr2717 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2723 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr2730 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr2745 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2751 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr2758 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr2773 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2779 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr2786 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr2799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr2823 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2829 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2844 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr2846 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr2852 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr2868 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2874 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast2896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast2906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast2916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast2926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2951 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2955 = new BitSet(new long[]{0x200080100412A808L,0x0000000000000400L,0x0008000800001000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2982 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast2984 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr3011 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr3021 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr3035 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr3076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr3087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr3098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj3135 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj3139 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index3159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index3165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_col_alias3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_col_alias3187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_col_alias3194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index3209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range3228 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range3235 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range3240 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range3247 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj3273 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_pound_proj3277 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_pound_proj3283 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr3303 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr3305 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_bin_expr3312 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_bin_expr3319 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr3348 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr3352 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond3387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond3391 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond3395 = new BitSet(new long[]{0x0400000000000048L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_THEN_in_case_cond3423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond3427 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause3469 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause3471 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause3475 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause3485 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause3495 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause3531 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause3533 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause3537 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause3547 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause3593 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause3595 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause3597 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement3623 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement3625 = new BitSet(new long[]{0x0000000020000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement3629 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause3658 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ASC_in_rank_by_clause3667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_by_clause3673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause3685 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_col_range_in_rank_col3711 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ASC_in_rank_col3715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col3719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_rank_col3729 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ASC_in_rank_col3734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_order_clause3768 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause3770 = new BitSet(new long[]{0x00A0000802000000L,0x0010000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause3772 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause3774 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause3801 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ASC_in_order_by_clause3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_by_clause3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause3828 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_col_range_in_order_col3854 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ASC_in_order_col3858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col3862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_order_col3872 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ASC_in_order_col3877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col3881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause3901 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause3903 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause3905 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause3928 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause3930 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause3952 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause3954 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause3956 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list3984 = new BitSet(new long[]{0x00A4200113200082L,0x0300408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_JOIN_in_join_clause4023 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause4025 = new BitSet(new long[]{0x0000000000000008L,0x0000004100000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause4027 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause4030 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4066 = new BitSet(new long[]{0x0008000000000000L,0x0000020000000008L});
    public static final BitSet FOLLOW_LEFT_in_join_sub_clause4070 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_RIGHT_in_join_sub_clause4089 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_FULL_in_join_sub_clause4108 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause4114 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4127 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item4140 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item4142 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item4144 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause4171 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause4175 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr4200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr4206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr4212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause4237 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause4241 = new BitSet(new long[]{0x00A4200113200080L,0x0300408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_rel_list_in_union_clause4248 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause4284 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause4286 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000003000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause4288 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4324 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan4326 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4335 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan4337 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk4348 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x000000C000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command4373 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4375 = new BitSet(new long[]{0x0004200101000000L,0x0000000008000100L,0x0000010000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command4377 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command4395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4397 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_nested_command4399 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op4421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op4429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op4437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op4446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op4454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op4462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op4470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj4494 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4506 = new BitSet(new long[]{0x00A0000802000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4521 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter4574 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter4576 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_cond_in_nested_filter4578 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort4612 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort4614 = new BitSet(new long[]{0x00A0000802000000L,0x0010000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort4616 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort4618 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct4648 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct4650 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit4683 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit4685 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit4689 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit4699 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross4732 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross4734 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach4766 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach4768 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach4770 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause4799 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause4803 = new BitSet(new long[]{0x40A2482A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input4869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input4880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list4906 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause4931 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause4933 = new BitSet(new long[]{0x0080040000000000L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause4937 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stream_clause4960 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause5002 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause5030 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause5032 = new BitSet(new long[]{0x0000000000000000L,0x0100004000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause5034 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause5045 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause5054 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause5061 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause5081 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause5089 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause5105 = new BitSet(new long[]{0x0000000000000008L,0x0000000010000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause5108 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch5137 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch5139 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_cond_in_split_branch5141 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise5175 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise5177 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref5197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref5205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref5222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref5232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref5242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref5261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr5280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal5298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal5308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal5318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal5328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar5346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar5356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar5366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar5376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar5386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar5411 = new BitSet(new long[]{0x4002002000005000L,0x0000000000000800L});
    public static final BitSet FOLLOW_INTEGER_in_num_scalar5424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_num_scalar5438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATNUMBER_in_num_scalar5452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_num_scalar5466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGERNUMBER_in_num_scalar5480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMALNUMBER_in_num_scalar5494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map5526 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map5530 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue5557 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue5559 = new BitSet(new long[]{0x4002082000005000L,0x0000004000044800L,0x0010001000002008L});
    public static final BitSet FOLLOW_literal_in_keyvalue5561 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key5581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag5603 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag5607 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple5639 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple5643 = new BitSet(new long[]{0x4002082000005008L,0x0000004000044800L,0x0010001000002008L});
    public static final BitSet FOLLOW_rel_str_op_in_eid5668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid5678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid5688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid5698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid5708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid5718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid5728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid5738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid5748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid5758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid5768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid5778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid5788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid5798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid5808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid5818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid5828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid5838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid5848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid5858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid5868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid5878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid5888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid5898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid5908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid5918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid5928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid5938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid5948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid5958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid5968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid5978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid5988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid5998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid6008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid6018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid6028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid6038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid6048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid6058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid6068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid6078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid6088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid6098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid6108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid6118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid6128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid6138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid6148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid6158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid6168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid6178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid6188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid6198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid6208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid6218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid6228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid6238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid6248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid6258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid6268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid6278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid6288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid6298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid6308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid6318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid6328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid6338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid6348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid6358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid6368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid6378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid6388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op6400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op6411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op6422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op6433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op6444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op6455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op6466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_str_op6557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_str_op6564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_str_op6571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_str_op6578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_str_op6585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_str_op6592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_str_op6599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred141_LogicalPlanGenerator3475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred142_LogicalPlanGenerator3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred143_LogicalPlanGenerator3537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred173_LogicalPlanGenerator4066 = new BitSet(new long[]{0x0008000000000000L,0x0000020000000008L});
    public static final BitSet FOLLOW_set_in_synpred173_LogicalPlanGenerator4068 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred173_LogicalPlanGenerator4114 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_join_item_in_synpred173_LogicalPlanGenerator4117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred190_LogicalPlanGenerator4689 = new BitSet(new long[]{0x0000000000000002L});

}