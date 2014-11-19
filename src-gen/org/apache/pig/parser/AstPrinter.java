// $ANTLR 3.4 /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g 2014-11-19 11:26:39

package org.apache.pig.parser;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (visitor for printing Pig script from Ast).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AstPrinter extends TreeParser {
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


    public AstPrinter(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AstPrinter(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AstPrinter.tokenNames; }
    public String getGrammarFileName() { return "/home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g"; }



    public String getResult() { return sb.toString(); }

    private StringBuilder sb = new StringBuilder();



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:53:1: query : ^( QUERY ( statement )* ) ;
    public final AstPrinter.query_return query() throws RecognitionException {
        AstPrinter.query_return retval = new AstPrinter.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AstPrinter.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:53:7: ( ^( QUERY ( statement )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:53:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query80); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:53:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:53:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query82);
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


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:56:1: statement : ( general_statement | split_statement | realias_statement );
    public final AstPrinter.statement_return statement() throws RecognitionException {
        AstPrinter.statement_return retval = new AstPrinter.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.general_statement_return general_statement3 =null;

        AstPrinter.split_statement_return split_statement4 =null;

        AstPrinter.realias_statement_return realias_statement5 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:56:11: ( general_statement | split_statement | realias_statement )
            int alt2=3;
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
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:56:13: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement94);
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:57:13: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement108);
                    split_statement4=split_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_statement4.getTree());


                    if ( state.backtracking==0 ) { sb.append(";\n"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:58:13: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement124);
                    realias_statement5=realias_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, realias_statement5.getTree());


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
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:61:1: split_statement : split_clause ;
    public final AstPrinter.split_statement_return split_statement() throws RecognitionException {
        AstPrinter.split_statement_return retval = new AstPrinter.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.split_clause_return split_clause6 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:61:17: ( split_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:61:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement133);
            split_clause6=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause6.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:64:1: realias_statement : realias_clause ;
    public final AstPrinter.realias_statement_return realias_statement() throws RecognitionException {
        AstPrinter.realias_statement_return retval = new AstPrinter.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.realias_clause_return realias_clause7 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:64:19: ( realias_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:64:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement142);
            realias_clause7=realias_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, realias_clause7.getTree());


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


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:68:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AstPrinter.general_statement_return general_statement() throws RecognitionException {
        AstPrinter.general_statement_return retval = new AstPrinter.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT8=null;
        AstPrinter.alias_return alias9 =null;

        AstPrinter.op_clause_return op_clause10 =null;

        AstPrinter.parallel_clause_return parallel_clause11 =null;


        CommonTree STATEMENT8_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:69:5: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:69:7: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT8=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement158); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT8_tree = (CommonTree)adaptor.dupNode(STATEMENT8);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT8_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:69:20: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:69:22: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement162);
                    alias9=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias9.getTree());


                    if ( state.backtracking==0 ) { sb.append(" = "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement177);
            op_clause10=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause10.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:70:19: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:70:19: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement179);
                    parallel_clause11=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause11.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(";\n"); }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:73:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AstPrinter.realias_clause_return realias_clause() throws RecognitionException {
        AstPrinter.realias_clause_return retval = new AstPrinter.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS12=null;
        CommonTree IDENTIFIER14=null;
        AstPrinter.alias_return alias13 =null;


        CommonTree REALIAS12_tree=null;
        CommonTree IDENTIFIER14_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:73:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:73:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS12=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause194); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS12_tree = (CommonTree)adaptor.dupNode(REALIAS12);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS12_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause196);
            alias13=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias13.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER14=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause198); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER14_tree = (CommonTree)adaptor.dupNode(IDENTIFIER14);


            adaptor.addChild(root_1, IDENTIFIER14_tree);
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
    // $ANTLR end "realias_clause"


    public static class parallel_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parallel_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:76:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AstPrinter.parallel_clause_return parallel_clause() throws RecognitionException {
        AstPrinter.parallel_clause_return retval = new AstPrinter.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL15=null;
        CommonTree INTEGER16=null;

        CommonTree PARALLEL15_tree=null;
        CommonTree INTEGER16_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:77:5: ( ^( PARALLEL INTEGER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:77:7: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL15=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause214); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL15_tree = (CommonTree)adaptor.dupNode(PARALLEL15);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL15_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER16=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause216); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER16_tree = (CommonTree)adaptor.dupNode(INTEGER16);


            adaptor.addChild(root_1, INTEGER16_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((PARALLEL15!=null?PARALLEL15.getText():null)).append(" ").append((INTEGER16!=null?INTEGER16.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:80:1: alias : IDENTIFIER ;
    public final AstPrinter.alias_return alias() throws RecognitionException {
        AstPrinter.alias_return retval = new AstPrinter.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER17=null;

        CommonTree IDENTIFIER17_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:81:5: ( IDENTIFIER )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:81:7: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER17=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias233); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER17_tree = (CommonTree)adaptor.dupNode(IDENTIFIER17);


            adaptor.addChild(root_0, IDENTIFIER17_tree);
            }


            if ( state.backtracking==0 ) { sb.append((IDENTIFIER17!=null?IDENTIFIER17.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:84:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause );
    public final AstPrinter.op_clause_return op_clause() throws RecognitionException {
        AstPrinter.op_clause_return retval = new AstPrinter.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.define_clause_return define_clause18 =null;

        AstPrinter.load_clause_return load_clause19 =null;

        AstPrinter.group_clause_return group_clause20 =null;

        AstPrinter.store_clause_return store_clause21 =null;

        AstPrinter.filter_clause_return filter_clause22 =null;

        AstPrinter.distinct_clause_return distinct_clause23 =null;

        AstPrinter.limit_clause_return limit_clause24 =null;

        AstPrinter.sample_clause_return sample_clause25 =null;

        AstPrinter.order_clause_return order_clause26 =null;

        AstPrinter.rank_clause_return rank_clause27 =null;

        AstPrinter.cross_clause_return cross_clause28 =null;

        AstPrinter.join_clause_return join_clause29 =null;

        AstPrinter.union_clause_return union_clause30 =null;

        AstPrinter.stream_clause_return stream_clause31 =null;

        AstPrinter.mr_clause_return mr_clause32 =null;

        AstPrinter.split_clause_return split_clause33 =null;

        AstPrinter.foreach_clause_return foreach_clause34 =null;

        AstPrinter.cube_clause_return cube_clause35 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:84:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause )
            int alt5=18;
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
            case SPLIT:
                {
                alt5=16;
                }
                break;
            case FOREACH:
                {
                alt5=17;
                }
                break;
            case CUBE:
                {
                alt5=18;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:84:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause244);
                    define_clause18=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause18.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:85:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause258);
                    load_clause19=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause19.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:86:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause272);
                    group_clause20=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause20.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:87:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause286);
                    store_clause21=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause21.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:88:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause300);
                    filter_clause22=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause22.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:89:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause314);
                    distinct_clause23=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause23.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:90:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause328);
                    limit_clause24=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause24.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:91:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause342);
                    sample_clause25=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause25.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:92:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause356);
                    order_clause26=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:93:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause370);
                    rank_clause27=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause27.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:94:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause384);
                    cross_clause28=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause28.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:95:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause398);
                    join_clause29=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause29.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:96:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause412);
                    union_clause30=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause30.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:97:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause426);
                    stream_clause31=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause31.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:98:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause440);
                    mr_clause32=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause32.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:99:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause454);
                    split_clause33=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause33.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:100:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause468);
                    foreach_clause34=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause34.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:101:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause482);
                    cube_clause35=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause35.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:104:1: define_clause : ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) ;
    public final AstPrinter.define_clause_return define_clause() throws RecognitionException {
        AstPrinter.define_clause_return retval = new AstPrinter.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE36=null;
        CommonTree IDENTIFIER37=null;
        AstPrinter.cmd_return cmd38 =null;

        AstPrinter.func_clause_return func_clause39 =null;


        CommonTree DEFINE36_tree=null;
        CommonTree IDENTIFIER37_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:105:5: ( ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:105:7: ^( DEFINE IDENTIFIER ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE36=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause497); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE36_tree = (CommonTree)adaptor.dupNode(DEFINE36);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE36_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER37=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_define_clause499); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER37_tree = (CommonTree)adaptor.dupNode(IDENTIFIER37);


            adaptor.addChild(root_1, IDENTIFIER37_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DEFINE36!=null?DEFINE36.getText():null)).append(" ").append((IDENTIFIER37!=null?IDENTIFIER37.getText():null)).append(" "); }

            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:106:9: ( cmd | func_clause )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==EXECCOMMAND) ) {
                alt6=1;
            }
            else if ( (LA6_0==FUNC||LA6_0==FUNC_REF) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:106:11: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause513);
                    cmd38=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd38.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:106:17: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause517);
                    func_clause39=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause39.getTree());


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
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:109:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AstPrinter.cmd_return cmd() throws RecognitionException {
        AstPrinter.cmd_return retval = new AstPrinter.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND40=null;
        AstPrinter.ship_clause_return ship_clause41 =null;

        AstPrinter.cache_clause_return cache_clause42 =null;

        AstPrinter.input_clause_return input_clause43 =null;

        AstPrinter.output_clause_return output_clause44 =null;

        AstPrinter.error_clause_return error_clause45 =null;


        CommonTree EXECCOMMAND40_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:110:5: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:110:7: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND40=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd536); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND40_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND40);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND40_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((EXECCOMMAND40!=null?EXECCOMMAND40.getText():null)); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:111:9: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
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
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:111:11: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd550);
                	    ship_clause41=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause41.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:111:25: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd554);
                	    cache_clause42=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause42.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:111:40: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd558);
                	    input_clause43=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause43.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:111:55: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd562);
                	    output_clause44=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause44.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:111:71: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd566);
                	    error_clause45=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause45.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:114:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AstPrinter.ship_clause_return ship_clause() throws RecognitionException {
        AstPrinter.ship_clause_return retval = new AstPrinter.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP46=null;
        AstPrinter.path_list_return path_list47 =null;


        CommonTree SHIP46_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:115:5: ( ^( SHIP ( path_list )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:115:7: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP46=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause586); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP46_tree = (CommonTree)adaptor.dupNode(SHIP46);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP46_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((SHIP46!=null?SHIP46.getText():null)).append(" ("); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:115:67: ( path_list )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:115:67: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause590);
                        path_list47=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list47.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                if ( state.backtracking==0 ) { sb.append(")"); }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:118:1: path_list : a= QUOTEDSTRING (b= QUOTEDSTRING )* ;
    public final AstPrinter.path_list_return path_list() throws RecognitionException {
        AstPrinter.path_list_return retval = new AstPrinter.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree a=null;
        CommonTree b=null;

        CommonTree a_tree=null;
        CommonTree b_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:119:5: (a= QUOTEDSTRING (b= QUOTEDSTRING )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:119:7: a= QUOTEDSTRING (b= QUOTEDSTRING )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            a=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list610); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (CommonTree)adaptor.dupNode(a);


            adaptor.addChild(root_0, a_tree);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((a!=null?a.getText():null)); }

            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:120:9: (b= QUOTEDSTRING )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:120:10: b= QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    b=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list625); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    b_tree = (CommonTree)adaptor.dupNode(b);


            	    adaptor.addChild(root_0, b_tree);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", ").append((b!=null?b.getText():null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop9;
                }
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:123:1: cache_clause : ^( CACHE path_list ) ;
    public final AstPrinter.cache_clause_return cache_clause() throws RecognitionException {
        AstPrinter.cache_clause_return retval = new AstPrinter.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE48=null;
        AstPrinter.path_list_return path_list49 =null;


        CommonTree CACHE48_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:124:5: ( ^( CACHE path_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:124:7: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE48=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause645); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE48_tree = (CommonTree)adaptor.dupNode(CACHE48);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE48_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((CACHE48!=null?CACHE48.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause649);
            path_list49=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list49.getTree());


            if ( state.backtracking==0 ) { sb.append(")"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:127:1: input_clause : ^( INPUT stream_cmd ( stream_cmd )* ) ;
    public final AstPrinter.input_clause_return input_clause() throws RecognitionException {
        AstPrinter.input_clause_return retval = new AstPrinter.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT50=null;
        AstPrinter.stream_cmd_return stream_cmd51 =null;

        AstPrinter.stream_cmd_return stream_cmd52 =null;


        CommonTree INPUT50_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:128:5: ( ^( INPUT stream_cmd ( stream_cmd )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:128:7: ^( INPUT stream_cmd ( stream_cmd )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT50=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause668); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT50_tree = (CommonTree)adaptor.dupNode(INPUT50);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT50_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((INPUT50!=null?INPUT50.getText():null)).append("("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_stream_cmd_in_input_clause680);
            stream_cmd51=stream_cmd();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, stream_cmd51.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:129:20: ( stream_cmd )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING||(LA10_0 >= STDIN && LA10_0 <= STDOUT)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:129:22: stream_cmd
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause686);
            	    stream_cmd52=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd52.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:132:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AstPrinter.stream_cmd_return stream_cmd() throws RecognitionException {
        AstPrinter.stream_cmd_return retval = new AstPrinter.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN53=null;
        CommonTree STDOUT55=null;
        CommonTree QUOTEDSTRING57=null;
        AstPrinter.func_clause_return func_clause54 =null;

        AstPrinter.func_clause_return func_clause56 =null;

        AstPrinter.func_clause_return func_clause58 =null;


        CommonTree STDIN53_tree=null;
        CommonTree STDOUT55_tree=null;
        CommonTree QUOTEDSTRING57_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:133:5: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:133:7: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN53=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd707); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN53_tree = (CommonTree)adaptor.dupNode(STDIN53);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN53_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDIN53!=null?STDIN53.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:133:62: ( func_clause )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:133:62: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd711);
                                func_clause54=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause54.getTree());


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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:134:7: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT55=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd724); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT55_tree = (CommonTree)adaptor.dupNode(STDOUT55);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT55_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDOUT55!=null?STDOUT55.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:134:64: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:134:64: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd728);
                                func_clause56=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause56.getTree());


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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:135:7: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING57=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd741); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING57_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING57);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING57_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING57!=null?QUOTEDSTRING57.getText():null)).append(" USING "); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:135:76: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:135:76: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd745);
                                func_clause58=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause58.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:138:1: output_clause : ^( OUTPUT stream_cmd ( stream_cmd )* ) ;
    public final AstPrinter.output_clause_return output_clause() throws RecognitionException {
        AstPrinter.output_clause_return retval = new AstPrinter.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT59=null;
        AstPrinter.stream_cmd_return stream_cmd60 =null;

        AstPrinter.stream_cmd_return stream_cmd61 =null;


        CommonTree OUTPUT59_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:139:5: ( ^( OUTPUT stream_cmd ( stream_cmd )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:139:7: ^( OUTPUT stream_cmd ( stream_cmd )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT59=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause763); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT59_tree = (CommonTree)adaptor.dupNode(OUTPUT59);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT59_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((OUTPUT59!=null?OUTPUT59.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_stream_cmd_in_output_clause776);
            stream_cmd60=stream_cmd();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, stream_cmd60.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:140:20: ( stream_cmd )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QUOTEDSTRING||(LA15_0 >= STDIN && LA15_0 <= STDOUT)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:140:22: stream_cmd
            	    {
            	    if ( state.backtracking==0 ) { sb.append(","); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause782);
            	    stream_cmd61=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd61.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:143:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AstPrinter.error_clause_return error_clause() throws RecognitionException {
        AstPrinter.error_clause_return retval = new AstPrinter.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR62=null;
        CommonTree QUOTEDSTRING63=null;
        CommonTree INTEGER64=null;

        CommonTree STDERROR62_tree=null;
        CommonTree QUOTEDSTRING63_tree=null;
        CommonTree INTEGER64_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:144:5: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:144:7: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR62=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause803); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR62_tree = (CommonTree)adaptor.dupNode(STDERROR62);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR62_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((STDERROR62!=null?STDERROR62.getText():null)).append(" ("); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:145:9: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:145:11: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING63=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause817); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING63_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING63);


                        adaptor.addChild(root_1, QUOTEDSTRING63_tree);
                        }


                        if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING63!=null?QUOTEDSTRING63.getText():null)); }

                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:145:59: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:145:60: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER64=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause822); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER64_tree = (CommonTree)adaptor.dupNode(INTEGER64);


                                adaptor.addChild(root_1, INTEGER64_tree);
                                }


                                if ( state.backtracking==0 ) { sb.append(" LIMIT ").append(INTEGER64); }

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


                if ( state.backtracking==0 ) { sb.append(")"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:148:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AstPrinter.load_clause_return load_clause() throws RecognitionException {
        AstPrinter.load_clause_return retval = new AstPrinter.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD65=null;
        AstPrinter.filename_return filename66 =null;

        AstPrinter.func_clause_return func_clause67 =null;

        AstPrinter.as_clause_return as_clause68 =null;


        CommonTree LOAD65_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:149:5: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:149:7: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD65=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause849); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD65_tree = (CommonTree)adaptor.dupNode(LOAD65);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD65_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LOAD65!=null?LOAD65.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause853);
            filename66=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename66.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:150:9: ( func_clause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:150:11: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause867);
                    func_clause67=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause67.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:150:51: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:150:51: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause871);
                    as_clause68=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause68.getTree());


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
    // $ANTLR end "load_clause"


    public static class filename_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:153:1: filename : QUOTEDSTRING ;
    public final AstPrinter.filename_return filename() throws RecognitionException {
        AstPrinter.filename_return retval = new AstPrinter.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING69=null;

        CommonTree QUOTEDSTRING69_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:154:5: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:154:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING69=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename887); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING69_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING69);


            adaptor.addChild(root_0, QUOTEDSTRING69_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING69!=null?QUOTEDSTRING69.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:157:1: as_clause : ^( AS field_def_list ) ;
    public final AstPrinter.as_clause_return as_clause() throws RecognitionException {
        AstPrinter.as_clause_return retval = new AstPrinter.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS70=null;
        AstPrinter.field_def_list_return field_def_list71 =null;


        CommonTree AS70_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:158:5: ( ^( AS field_def_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:158:7: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS70=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause904); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS70_tree = (CommonTree)adaptor.dupNode(AS70);


            root_1 = (CommonTree)adaptor.becomeRoot(AS70_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((AS70!=null?AS70.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause908);
            field_def_list71=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list71.getTree());


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
    // $ANTLR end "as_clause"


    public static class field_def_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:161:1: field_def : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF type ) );
    public final AstPrinter.field_def_return field_def() throws RecognitionException {
        AstPrinter.field_def_return retval = new AstPrinter.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF72=null;
        CommonTree IDENTIFIER73=null;
        CommonTree FIELD_DEF75=null;
        AstPrinter.type_return type74 =null;

        AstPrinter.type_return type76 =null;


        CommonTree FIELD_DEF72_tree=null;
        CommonTree IDENTIFIER73_tree=null;
        CommonTree FIELD_DEF75_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:162:5: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF type ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==FIELD_DEF) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==DOWN) ) {
                    int LA21_2 = input.LA(3);

                    if ( (LA21_2==IDENTIFIER) ) {
                        alt21=1;
                    }
                    else if ( (LA21_2==BIGDECIMAL||LA21_2==BIGINTEGER||LA21_2==BOOLEAN||LA21_2==BYTEARRAY||LA21_2==CHARARRAY||LA21_2==DATETIME||LA21_2==DOUBLE||LA21_2==FLOAT||LA21_2==INT||LA21_2==LONG||LA21_2==BAG_TYPE||LA21_2==MAP_TYPE||LA21_2==TUPLE_TYPE) ) {
                        alt21=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:162:7: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF72=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def925); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF72_tree = (CommonTree)adaptor.dupNode(FIELD_DEF72);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF72_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER73=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def927); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER73_tree = (CommonTree)adaptor.dupNode(IDENTIFIER73);


                    adaptor.addChild(root_1, IDENTIFIER73_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER73!=null?IDENTIFIER73.getText():null)); }

                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:162:65: ( type )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==BIGDECIMAL||LA20_0==BIGINTEGER||LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DATETIME||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:162:67: type
                            {
                            if ( state.backtracking==0 ) {sb.append(":"); }

                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def937);
                            type74=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type74.getTree());


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
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:163:7: ^( FIELD_DEF type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF75=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def951); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF75_tree = (CommonTree)adaptor.dupNode(FIELD_DEF75);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF75_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def953);
                    type76=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type76.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:166:1: field_def_list : ( field_def ( field_def )+ | field_def );
    public final AstPrinter.field_def_list_return field_def_list() throws RecognitionException {
        AstPrinter.field_def_list_return retval = new AstPrinter.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.field_def_return field_def77 =null;

        AstPrinter.field_def_return field_def78 =null;

        AstPrinter.field_def_return field_def79 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:167:5: ( field_def ( field_def )+ | field_def )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==FIELD_DEF) ) {
                int LA23_1 = input.LA(2);

                if ( (synpred45_AstPrinter()) ) {
                    alt23=1;
                }
                else if ( (true) ) {
                    alt23=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:167:7: field_def ( field_def )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    if ( state.backtracking==0 ) { sb.append("("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_in_field_def_list970);
                    field_def77=field_def();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def77.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:167:37: ( field_def )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==FIELD_DEF) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:167:39: field_def
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_field_def_in_field_def_list976);
                    	    field_def78=field_def();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, field_def78.getTree());


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


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:168:7: field_def
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_in_field_def_list989);
                    field_def79=field_def();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def79.getTree());


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
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:171:1: type : ( simple_type | tuple_type | bag_type | map_type );
    public final AstPrinter.type_return type() throws RecognitionException {
        AstPrinter.type_return retval = new AstPrinter.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.simple_type_return simple_type80 =null;

        AstPrinter.tuple_type_return tuple_type81 =null;

        AstPrinter.bag_type_return bag_type82 =null;

        AstPrinter.map_type_return map_type83 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:171:6: ( simple_type | tuple_type | bag_type | map_type )
            int alt24=4;
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
                alt24=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt24=2;
                }
                break;
            case BAG_TYPE:
                {
                alt24=3;
                }
                break;
            case MAP_TYPE:
                {
                alt24=4;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:171:8: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type998);
                    simple_type80=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type80.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:171:22: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1002);
                    tuple_type81=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type81.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:171:35: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1006);
                    bag_type82=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type82.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:171:46: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1010);
                    map_type83=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type83.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:174:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
    public final AstPrinter.simple_type_return simple_type() throws RecognitionException {
        AstPrinter.simple_type_return retval = new AstPrinter.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN84=null;
        CommonTree INT85=null;
        CommonTree LONG86=null;
        CommonTree FLOAT87=null;
        CommonTree DOUBLE88=null;
        CommonTree BIGINTEGER89=null;
        CommonTree BIGDECIMAL90=null;
        CommonTree DATETIME91=null;
        CommonTree CHARARRAY92=null;
        CommonTree BYTEARRAY93=null;

        CommonTree BOOLEAN84_tree=null;
        CommonTree INT85_tree=null;
        CommonTree LONG86_tree=null;
        CommonTree FLOAT87_tree=null;
        CommonTree DOUBLE88_tree=null;
        CommonTree BIGINTEGER89_tree=null;
        CommonTree BIGDECIMAL90_tree=null;
        CommonTree DATETIME91_tree=null;
        CommonTree CHARARRAY92_tree=null;
        CommonTree BYTEARRAY93_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:175:5: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
            int alt25=10;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt25=1;
                }
                break;
            case INT:
                {
                alt25=2;
                }
                break;
            case LONG:
                {
                alt25=3;
                }
                break;
            case FLOAT:
                {
                alt25=4;
                }
                break;
            case DOUBLE:
                {
                alt25=5;
                }
                break;
            case BIGINTEGER:
                {
                alt25=6;
                }
                break;
            case BIGDECIMAL:
                {
                alt25=7;
                }
                break;
            case DATETIME:
                {
                alt25=8;
                }
                break;
            case CHARARRAY:
                {
                alt25=9;
                }
                break;
            case BYTEARRAY:
                {
                alt25=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:175:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN84=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1023); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN84_tree = (CommonTree)adaptor.dupNode(BOOLEAN84);


                    adaptor.addChild(root_0, BOOLEAN84_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BOOLEAN84!=null?BOOLEAN84.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:176:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT85=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1033); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT85_tree = (CommonTree)adaptor.dupNode(INT85);


                    adaptor.addChild(root_0, INT85_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INT85!=null?INT85.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:177:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG86=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1043); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG86_tree = (CommonTree)adaptor.dupNode(LONG86);


                    adaptor.addChild(root_0, LONG86_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONG86!=null?LONG86.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:178:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT87=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1053); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT87_tree = (CommonTree)adaptor.dupNode(FLOAT87);


                    adaptor.addChild(root_0, FLOAT87_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOAT87!=null?FLOAT87.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:179:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE88=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1063); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE88_tree = (CommonTree)adaptor.dupNode(DOUBLE88);


                    adaptor.addChild(root_0, DOUBLE88_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLE88!=null?DOUBLE88.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:180:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER89=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1073); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER89_tree = (CommonTree)adaptor.dupNode(BIGINTEGER89);


                    adaptor.addChild(root_0, BIGINTEGER89_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGINTEGER89!=null?BIGINTEGER89.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:181:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL90=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1083); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL90_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL90);


                    adaptor.addChild(root_0, BIGDECIMAL90_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGDECIMAL90!=null?BIGDECIMAL90.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:182:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME91=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1093); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME91_tree = (CommonTree)adaptor.dupNode(DATETIME91);


                    adaptor.addChild(root_0, DATETIME91_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DATETIME91!=null?DATETIME91.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:183:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY92=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1103); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY92_tree = (CommonTree)adaptor.dupNode(CHARARRAY92);


                    adaptor.addChild(root_0, CHARARRAY92_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CHARARRAY92!=null?CHARARRAY92.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:184:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY93=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1113); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY93_tree = (CommonTree)adaptor.dupNode(BYTEARRAY93);


                    adaptor.addChild(root_0, BYTEARRAY93_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BYTEARRAY93!=null?BYTEARRAY93.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:187:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AstPrinter.tuple_type_return tuple_type() throws RecognitionException {
        AstPrinter.tuple_type_return retval = new AstPrinter.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE94=null;
        AstPrinter.field_def_list_return field_def_list95 =null;


        CommonTree TUPLE_TYPE94_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:188:5: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:188:7: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE94=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1130); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE94_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE94);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE94_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:188:21: ( field_def_list )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==FIELD_DEF) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:188:21: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1132);
                        field_def_list95=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list95.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:191:1: bag_type : ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? ) ;
    public final AstPrinter.bag_type_return bag_type() throws RecognitionException {
        AstPrinter.bag_type_return retval = new AstPrinter.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE96=null;
        CommonTree IDENTIFIER97=null;
        AstPrinter.tuple_type_return tuple_type98 =null;


        CommonTree BAG_TYPE96_tree=null;
        CommonTree IDENTIFIER97_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:192:5: ( ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:192:7: ^( BAG_TYPE ( ( IDENTIFIER )? tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE96=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1150); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE96_tree = (CommonTree)adaptor.dupNode(BAG_TYPE96);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE96_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("bag{"); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:192:42: ( ( IDENTIFIER )? tuple_type )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==IDENTIFIER||LA28_0==TUPLE_TYPE) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:192:44: ( IDENTIFIER )? tuple_type
                        {
                        if ( state.backtracking==0 ) { sb.append("T:"); }

                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:192:65: ( IDENTIFIER )?
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==IDENTIFIER) ) {
                            alt27=1;
                        }
                        switch (alt27) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:192:65: IDENTIFIER
                                {
                                _last = (CommonTree)input.LT(1);
                                IDENTIFIER97=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1158); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                IDENTIFIER97_tree = (CommonTree)adaptor.dupNode(IDENTIFIER97);


                                adaptor.addChild(root_1, IDENTIFIER97_tree);
                                }


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1161);
                        tuple_type98=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type98.getTree());


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


            if ( state.backtracking==0 ) { sb.append("}"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:195:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AstPrinter.map_type_return map_type() throws RecognitionException {
        AstPrinter.map_type_return retval = new AstPrinter.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE99=null;
        AstPrinter.type_return type100 =null;


        CommonTree MAP_TYPE99_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:195:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:195:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE99=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1179); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE99_tree = (CommonTree)adaptor.dupNode(MAP_TYPE99);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE99_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("map["); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:195:47: ( type )?
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==BIGDECIMAL||LA29_0==BIGINTEGER||LA29_0==BOOLEAN||LA29_0==BYTEARRAY||LA29_0==CHARARRAY||LA29_0==DATETIME||LA29_0==DOUBLE||LA29_0==FLOAT||LA29_0==INT||LA29_0==LONG||LA29_0==BAG_TYPE||LA29_0==MAP_TYPE||LA29_0==TUPLE_TYPE) ) {
                    alt29=1;
                }
                switch (alt29) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:195:47: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1183);
                        type100=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type100.getTree());


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


            if ( state.backtracking==0 ) { sb.append("]"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:198:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AstPrinter.func_clause_return func_clause() throws RecognitionException {
        AstPrinter.func_clause_return retval = new AstPrinter.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF101=null;
        CommonTree FUNC103=null;
        AstPrinter.func_name_return func_name102 =null;

        AstPrinter.func_name_return func_name104 =null;

        AstPrinter.func_args_return func_args105 =null;


        CommonTree FUNC_REF101_tree=null;
        CommonTree FUNC103_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:199:5: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FUNC_REF) ) {
                alt31=1;
            }
            else if ( (LA31_0==FUNC) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:199:7: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF101=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1203); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF101_tree = (CommonTree)adaptor.dupNode(FUNC_REF101);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF101_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1205);
                    func_name102=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name102.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:200:7: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC103=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1217); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC103_tree = (CommonTree)adaptor.dupNode(FUNC103);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC103_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1219);
                    func_name104=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name104.getTree());


                    if ( state.backtracking==0 ) { sb.append("("); }

                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:200:45: ( func_args )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==QUOTEDSTRING) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:200:45: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1223);
                            func_args105=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args105.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(")"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:203:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AstPrinter.func_name_return func_name() throws RecognitionException {
        AstPrinter.func_name_return retval = new AstPrinter.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD107=null;
        CommonTree DOLLAR108=null;
        AstPrinter.eid_return eid106 =null;

        AstPrinter.eid_return eid109 =null;


        CommonTree PERIOD107_tree=null;
        CommonTree DOLLAR108_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:204:5: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:204:7: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1241);
            eid106=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid106.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:204:11: ( ( PERIOD | DOLLAR ) eid )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==DOLLAR||LA33_0==PERIOD) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:204:13: ( PERIOD | DOLLAR ) eid
            	    {
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:204:13: ( PERIOD | DOLLAR )
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==PERIOD) ) {
            	        alt32=1;
            	    }
            	    else if ( (LA32_0==DOLLAR) ) {
            	        alt32=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 32, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:204:15: PERIOD
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            PERIOD107=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_func_name1247); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PERIOD107_tree = (CommonTree)adaptor.dupNode(PERIOD107);


            	            adaptor.addChild(root_0, PERIOD107_tree);
            	            }


            	            if ( state.backtracking==0 ) { sb.append((PERIOD107!=null?PERIOD107.getText():null)); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;
            	        case 2 :
            	            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:204:53: DOLLAR
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            DOLLAR108=(CommonTree)match(input,DOLLAR,FOLLOW_DOLLAR_in_func_name1253); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DOLLAR108_tree = (CommonTree)adaptor.dupNode(DOLLAR108);


            	            adaptor.addChild(root_0, DOLLAR108_tree);
            	            }


            	            if ( state.backtracking==0 ) { sb.append((DOLLAR108!=null?DOLLAR108.getText():null)); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;

            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1259);
            	    eid109=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid109.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop33;
                }
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
    // $ANTLR end "func_name"


    public static class func_args_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:207:1: func_args : a= QUOTEDSTRING (b= QUOTEDSTRING )* ;
    public final AstPrinter.func_args_return func_args() throws RecognitionException {
        AstPrinter.func_args_return retval = new AstPrinter.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree a=null;
        CommonTree b=null;

        CommonTree a_tree=null;
        CommonTree b_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:208:5: (a= QUOTEDSTRING (b= QUOTEDSTRING )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:208:7: a= QUOTEDSTRING (b= QUOTEDSTRING )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            a=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1277); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            a_tree = (CommonTree)adaptor.dupNode(a);


            adaptor.addChild(root_0, a_tree);
            }


            if ( state.backtracking==0 ) { sb.append((a!=null?a.getText():null)); }

            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:209:9: (b= QUOTEDSTRING )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==QUOTEDSTRING) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:209:10: b= QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    b=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1292); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    b_tree = (CommonTree)adaptor.dupNode(b);


            	    adaptor.addChild(root_0, b_tree);
            	    }


            	    if ( state.backtracking==0 ) { sb.append(", ").append((b!=null?b.getText():null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop34;
                }
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


    public static class cube_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:212:1: cube_clause : ^( CUBE cube_item ) ;
    public final AstPrinter.cube_clause_return cube_clause() throws RecognitionException {
        AstPrinter.cube_clause_return retval = new AstPrinter.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE110=null;
        AstPrinter.cube_item_return cube_item111 =null;


        CommonTree CUBE110_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:213:5: ( ^( CUBE cube_item ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:213:7: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE110=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1312); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE110_tree = (CommonTree)adaptor.dupNode(CUBE110);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE110_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((CUBE110!=null?CUBE110.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1316);
            cube_item111=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item111.getTree());


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
    // $ANTLR end "cube_clause"


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:216:1: cube_item : rel ( cube_by_clause ) ;
    public final AstPrinter.cube_item_return cube_item() throws RecognitionException {
        AstPrinter.cube_item_return retval = new AstPrinter.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.rel_return rel112 =null;

        AstPrinter.cube_by_clause_return cube_by_clause113 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:217:5: ( rel ( cube_by_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:217:7: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1331);
            rel112=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel112.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:217:11: ( cube_by_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:217:13: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1335);
            cube_by_clause113=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause113.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:220:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AstPrinter.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AstPrinter.cube_by_clause_return retval = new AstPrinter.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY114=null;
        AstPrinter.cube_or_rollup_return cube_or_rollup115 =null;


        CommonTree BY114_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:221:5: ( ^( BY cube_or_rollup ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:221:7: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY114=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1352); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY114_tree = (CommonTree)adaptor.dupNode(BY114);


            root_1 = (CommonTree)adaptor.becomeRoot(BY114_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((BY114!=null?BY114.getText():null)); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1356);
            cube_or_rollup115=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup115.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_or_rollup"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:224:1: cube_or_rollup : cube_rollup_list ( cube_rollup_list )* ;
    public final AstPrinter.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AstPrinter.cube_or_rollup_return retval = new AstPrinter.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.cube_rollup_list_return cube_rollup_list116 =null;

        AstPrinter.cube_rollup_list_return cube_rollup_list117 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:225:5: ( cube_rollup_list ( cube_rollup_list )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:225:7: cube_rollup_list ( cube_rollup_list )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1371);
            cube_rollup_list116=cube_rollup_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_rollup_list116.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:225:24: ( cube_rollup_list )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==CUBE||LA35_0==ROLLUP) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:225:26: cube_rollup_list
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1377);
            	    cube_rollup_list117=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list117.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop35;
                }
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:228:1: cube_rollup_list : ^( ( CUBE | ROLLUP ) cube_by_expr_list ) ;
    public final AstPrinter.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AstPrinter.cube_rollup_list_return retval = new AstPrinter.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE118=null;
        CommonTree ROLLUP119=null;
        AstPrinter.cube_by_expr_list_return cube_by_expr_list120 =null;


        CommonTree CUBE118_tree=null;
        CommonTree ROLLUP119_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:229:5: ( ^( ( CUBE | ROLLUP ) cube_by_expr_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:229:7: ^( ( CUBE | ROLLUP ) cube_by_expr_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:229:10: ( CUBE | ROLLUP )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==CUBE) ) {
                alt36=1;
            }
            else if ( (LA36_0==ROLLUP) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:229:12: CUBE
                    {
                    _last = (CommonTree)input.LT(1);
                    CUBE118=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1397); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE118_tree = (CommonTree)adaptor.dupNode(CUBE118);


                    adaptor.addChild(root_1, CUBE118_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE118!=null?CUBE118.getText():null)).append("("); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:229:58: ROLLUP
                    {
                    _last = (CommonTree)input.LT(1);
                    ROLLUP119=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP119_tree = (CommonTree)adaptor.dupNode(ROLLUP119);


                    adaptor.addChild(root_1, ROLLUP119_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ROLLUP119!=null?ROLLUP119.getText():null)).append("("); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1409);
            cube_by_expr_list120=cube_by_expr_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_by_expr_list120.getTree());


            if ( state.backtracking==0 ) { sb.append(")"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:232:1: cube_by_expr_list : ( cube_by_expr ( cube_by_expr )* ) ;
    public final AstPrinter.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AstPrinter.cube_by_expr_list_return retval = new AstPrinter.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.cube_by_expr_return cube_by_expr121 =null;

        AstPrinter.cube_by_expr_return cube_by_expr122 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:233:5: ( ( cube_by_expr ( cube_by_expr )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:233:7: ( cube_by_expr ( cube_by_expr )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:233:7: ( cube_by_expr ( cube_by_expr )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:233:9: cube_by_expr ( cube_by_expr )*
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1427);
            cube_by_expr121=cube_by_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_expr121.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:233:22: ( cube_by_expr )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==BIGDECIMALNUMBER||LA37_0==BIGINTEGERNUMBER||LA37_0==CUBE||LA37_0==DIV||LA37_0==DOLLARVAR||LA37_0==DOUBLENUMBER||LA37_0==FALSE||LA37_0==FLOATNUMBER||LA37_0==GROUP||LA37_0==IDENTIFIER||LA37_0==INTEGER||LA37_0==LONGINTEGER||LA37_0==MINUS||LA37_0==NULL||LA37_0==PERCENT||LA37_0==PLUS||LA37_0==QUOTEDSTRING||LA37_0==STAR||LA37_0==TRUE||(LA37_0 >= BAG_VAL && LA37_0 <= BIN_EXPR)||(LA37_0 >= CASE_COND && LA37_0 <= EXPR_IN_PAREN)||LA37_0==FUNC_EVAL||(LA37_0 >= MAP_VAL && LA37_0 <= NEG)||LA37_0==TUPLE_VAL) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:233:24: cube_by_expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1433);
            	    cube_by_expr122=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr122.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


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
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:236:1: cube_by_expr : ( col_range | expr | STAR );
    public final AstPrinter.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AstPrinter.cube_by_expr_return retval = new AstPrinter.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR125=null;
        AstPrinter.col_range_return col_range123 =null;

        AstPrinter.expr_return expr124 =null;


        CommonTree STAR125_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:237:5: ( col_range | expr | STAR )
            int alt38=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt38=1;
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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt38=2;
                }
                break;
            case STAR:
                {
                int LA38_3 = input.LA(2);

                if ( (LA38_3==DOWN) ) {
                    alt38=2;
                }
                else if ( (LA38_3==EOF||LA38_3==UP||LA38_3==BIGDECIMALNUMBER||LA38_3==BIGINTEGERNUMBER||LA38_3==CUBE||LA38_3==DIV||LA38_3==DOLLARVAR||LA38_3==DOUBLENUMBER||LA38_3==FALSE||LA38_3==FLOATNUMBER||LA38_3==GROUP||LA38_3==IDENTIFIER||LA38_3==INTEGER||LA38_3==LONGINTEGER||LA38_3==MINUS||LA38_3==NULL||LA38_3==PERCENT||LA38_3==PLUS||LA38_3==QUOTEDSTRING||LA38_3==STAR||LA38_3==TRUE||(LA38_3 >= BAG_VAL && LA38_3 <= BIN_EXPR)||(LA38_3 >= CASE_COND && LA38_3 <= EXPR_IN_PAREN)||LA38_3==FUNC_EVAL||(LA38_3 >= MAP_VAL && LA38_3 <= NEG)||LA38_3==TUPLE_VAL) ) {
                    alt38=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:237:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1451);
                    col_range123=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range123.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:237:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1455);
                    expr124=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr124.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:237:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR125=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1459); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR125_tree = (CommonTree)adaptor.dupNode(STAR125);


                    adaptor.addChild(root_0, STAR125_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR125!=null?STAR125.getText():null)); }

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


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:240:1: group_clause : ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? ) ;
    public final AstPrinter.group_clause_return group_clause() throws RecognitionException {
        AstPrinter.group_clause_return retval = new AstPrinter.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP126=null;
        CommonTree COGROUP127=null;
        AstPrinter.group_item_return group_item128 =null;

        AstPrinter.group_item_return group_item129 =null;

        AstPrinter.group_type_return group_type130 =null;

        AstPrinter.partition_clause_return partition_clause131 =null;


        CommonTree GROUP126_tree=null;
        CommonTree COGROUP127_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:241:5: ( ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:241:7: ^( ( GROUP | COGROUP ) group_item ( group_item )* ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:241:10: ( GROUP | COGROUP )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==GROUP) ) {
                alt39=1;
            }
            else if ( (LA39_0==COGROUP) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:241:12: GROUP
                    {
                    _last = (CommonTree)input.LT(1);
                    GROUP126=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_group_clause1478); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP126_tree = (CommonTree)adaptor.dupNode(GROUP126);


                    adaptor.addChild(root_1, GROUP126_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP126!=null?GROUP126.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:241:60: COGROUP
                    {
                    _last = (CommonTree)input.LT(1);
                    COGROUP127=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_group_clause1484); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP127_tree = (CommonTree)adaptor.dupNode(COGROUP127);


                    adaptor.addChild(root_1, COGROUP127_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((COGROUP127!=null?COGROUP127.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_group_item_in_group_clause1498);
            group_item128=group_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, group_item128.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:242:20: ( group_item )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==COGROUP||(LA40_0 >= CROSS && LA40_0 <= CUBE)||LA40_0==DEFINE||LA40_0==DISTINCT||LA40_0==FILTER||LA40_0==FOREACH||LA40_0==GROUP||LA40_0==IDENTIFIER||LA40_0==JOIN||(LA40_0 >= LIMIT && LA40_0 <= LOAD)||LA40_0==MAPREDUCE||LA40_0==ORDER||LA40_0==RANK||LA40_0==SAMPLE||LA40_0==SPLIT||(LA40_0 >= STORE && LA40_0 <= STREAM)||LA40_0==UNION) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:242:22: group_item
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1504);
            	    group_item129=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item129.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:243:7: ( group_type )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==QUOTEDSTRING) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:243:9: group_type
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1519);
                    group_type130=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type130.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:244:7: ( partition_clause )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==PARTITION) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:244:7: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1530);
                    partition_clause131=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause131.getTree());


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
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:248:1: group_type : QUOTEDSTRING ;
    public final AstPrinter.group_type_return group_type() throws RecognitionException {
        AstPrinter.group_type_return retval = new AstPrinter.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING132=null;

        CommonTree QUOTEDSTRING132_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:248:12: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:248:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING132=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1546); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING132_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING132);


            adaptor.addChild(root_0, QUOTEDSTRING132_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING132!=null?QUOTEDSTRING132.getText():null)); }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:251:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AstPrinter.group_item_return group_item() throws RecognitionException {
        AstPrinter.group_item_return retval = new AstPrinter.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL135=null;
        CommonTree ANY136=null;
        CommonTree INNER137=null;
        CommonTree OUTER138=null;
        AstPrinter.rel_return rel133 =null;

        AstPrinter.join_group_by_clause_return join_group_by_clause134 =null;


        CommonTree ALL135_tree=null;
        CommonTree ANY136_tree=null;
        CommonTree INNER137_tree=null;
        CommonTree OUTER138_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:252:5: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:252:7: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1561);
            rel133=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel133.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:252:11: ( join_group_by_clause | ALL | ANY )
            int alt43=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt43=1;
                }
                break;
            case ALL:
                {
                alt43=2;
                }
                break;
            case ANY:
                {
                alt43=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }

            switch (alt43) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:252:13: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1565);
                    join_group_by_clause134=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause134.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:253:15: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL135=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1581); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL135_tree = (CommonTree)adaptor.dupNode(ALL135);


                    adaptor.addChild(root_0, ALL135_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ALL135!=null?ALL135.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:253:59: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY136=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1587); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY136_tree = (CommonTree)adaptor.dupNode(ANY136);


                    adaptor.addChild(root_0, ANY136_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ANY136!=null?ANY136.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:254:13: ( INNER | OUTER )?
            int alt44=3;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==INNER) ) {
                alt44=1;
            }
            else if ( (LA44_0==OUTER) ) {
                alt44=2;
            }
            switch (alt44) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:254:15: INNER
                    {
                    _last = (CommonTree)input.LT(1);
                    INNER137=(CommonTree)match(input,INNER,FOLLOW_INNER_in_group_item1607); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER137_tree = (CommonTree)adaptor.dupNode(INNER137);


                    adaptor.addChild(root_0, INNER137_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INNER137!=null?INNER137.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:254:63: OUTER
                    {
                    _last = (CommonTree)input.LT(1);
                    OUTER138=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_group_item1613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER138_tree = (CommonTree)adaptor.dupNode(OUTER138);


                    adaptor.addChild(root_0, OUTER138_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((OUTER138!=null?OUTER138.getText():null)); }

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
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:257:1: rel : ( alias | ( op_clause ( parallel_clause )? ) );
    public final AstPrinter.rel_return rel() throws RecognitionException {
        AstPrinter.rel_return retval = new AstPrinter.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.alias_return alias139 =null;

        AstPrinter.op_clause_return op_clause140 =null;

        AstPrinter.parallel_clause_return parallel_clause141 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:258:5: ( alias | ( op_clause ( parallel_clause )? ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==IDENTIFIER) ) {
                alt46=1;
            }
            else if ( (LA46_0==COGROUP||(LA46_0 >= CROSS && LA46_0 <= CUBE)||LA46_0==DEFINE||LA46_0==DISTINCT||LA46_0==FILTER||LA46_0==FOREACH||LA46_0==GROUP||LA46_0==JOIN||(LA46_0 >= LIMIT && LA46_0 <= LOAD)||LA46_0==MAPREDUCE||LA46_0==ORDER||LA46_0==RANK||LA46_0==SAMPLE||LA46_0==SPLIT||(LA46_0 >= STORE && LA46_0 <= STREAM)||LA46_0==UNION) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:258:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1631);
                    alias139=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias139.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:259:7: ( op_clause ( parallel_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:259:7: ( op_clause ( parallel_clause )? )
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:259:9: op_clause ( parallel_clause )?
                    {
                    if ( state.backtracking==0 ) { sb.append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1643);
                    op_clause140=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause140.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:259:40: ( parallel_clause )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==PARALLEL) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:259:40: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1645);
                            parallel_clause141=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause141.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(") "); }

                    if ( state.backtracking==0 ) {
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
    // $ANTLR end "rel"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:262:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AstPrinter.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AstPrinter.flatten_generated_item_return retval = new AstPrinter.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR145=null;
        AstPrinter.flatten_clause_return flatten_clause142 =null;

        AstPrinter.col_range_return col_range143 =null;

        AstPrinter.expr_return expr144 =null;

        AstPrinter.field_def_list_return field_def_list146 =null;


        CommonTree STAR145_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:263:5: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:263:7: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:263:7: ( flatten_clause | col_range | expr | STAR )
            int alt47=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt47=1;
                }
                break;
            case COL_RANGE:
                {
                alt47=2;
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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt47=3;
                }
                break;
            case STAR:
                {
                int LA47_4 = input.LA(2);

                if ( (LA47_4==DOWN) ) {
                    alt47=3;
                }
                else if ( (LA47_4==EOF||LA47_4==UP||LA47_4==BIGDECIMALNUMBER||LA47_4==BIGINTEGERNUMBER||LA47_4==CUBE||LA47_4==DIV||LA47_4==DOLLARVAR||LA47_4==DOUBLENUMBER||LA47_4==FALSE||LA47_4==FLATTEN||LA47_4==FLOATNUMBER||LA47_4==GROUP||LA47_4==IDENTIFIER||LA47_4==INTEGER||LA47_4==LONGINTEGER||LA47_4==MINUS||LA47_4==NULL||LA47_4==PERCENT||LA47_4==PLUS||LA47_4==QUOTEDSTRING||LA47_4==STAR||LA47_4==TRUE||(LA47_4 >= BAG_VAL && LA47_4 <= BIN_EXPR)||(LA47_4 >= CASE_COND && LA47_4 <= FIELD_DEF)||LA47_4==FUNC_EVAL||(LA47_4 >= MAP_VAL && LA47_4 <= NEG)||LA47_4==TUPLE_VAL) ) {
                    alt47=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 4, input);

                    throw nvae;

                }
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:263:9: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1665);
                    flatten_clause142=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause142.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:263:26: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1669);
                    col_range143=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range143.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:263:38: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1673);
                    expr144=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr144.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:263:45: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR145=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1677); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR145_tree = (CommonTree)adaptor.dupNode(STAR145);


                    adaptor.addChild(root_0, STAR145_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((STAR145!=null?STAR145.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:263:91: ( field_def_list )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==FIELD_DEF) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:263:93: field_def_list
                    {
                    if ( state.backtracking==0 ) { sb.append(" AS "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1687);
                    field_def_list146=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list146.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:266:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AstPrinter.flatten_clause_return flatten_clause() throws RecognitionException {
        AstPrinter.flatten_clause_return retval = new AstPrinter.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN147=null;
        AstPrinter.expr_return expr148 =null;


        CommonTree FLATTEN147_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:267:5: ( ^( FLATTEN expr ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:267:7: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN147=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1704); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN147_tree = (CommonTree)adaptor.dupNode(FLATTEN147);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN147_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FLATTEN147!=null?FLATTEN147.getText():null)).append("("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1708);
            expr148=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr148.getTree());


            if ( state.backtracking==0 ) { sb.append(") "); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:270:1: store_clause : ^( STORE rel filename ( func_clause )? ) ;
    public final AstPrinter.store_clause_return store_clause() throws RecognitionException {
        AstPrinter.store_clause_return retval = new AstPrinter.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE149=null;
        AstPrinter.rel_return rel150 =null;

        AstPrinter.filename_return filename151 =null;

        AstPrinter.func_clause_return func_clause152 =null;


        CommonTree STORE149_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:271:5: ( ^( STORE rel filename ( func_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:271:7: ^( STORE rel filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE149=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1727); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE149_tree = (CommonTree)adaptor.dupNode(STORE149);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE149_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((STORE149!=null?STORE149.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause1731);
            rel150=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel150.getTree());


            if ( state.backtracking==0 ) { sb.append(" INTO "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1735);
            filename151=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename151.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:271:94: ( func_clause )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==FUNC||LA49_0==FUNC_REF) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:271:96: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1741);
                    func_clause152=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause152.getTree());


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
    // $ANTLR end "store_clause"


    public static class filter_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:274:1: filter_clause : ^( FILTER rel cond ) ;
    public final AstPrinter.filter_clause_return filter_clause() throws RecognitionException {
        AstPrinter.filter_clause_return retval = new AstPrinter.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER153=null;
        AstPrinter.rel_return rel154 =null;

        AstPrinter.cond_return cond155 =null;


        CommonTree FILTER153_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:275:5: ( ^( FILTER rel cond ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:275:7: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER153=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1760); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER153_tree = (CommonTree)adaptor.dupNode(FILTER153);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER153_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FILTER153!=null?FILTER153.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1764);
            rel154=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel154.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY ("); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1768);
            cond155=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond155.getTree());


            if ( state.backtracking==0 ) { sb.append(")"); }

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
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:278:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) );
    public final AstPrinter.cond_return cond() throws RecognitionException {
        AstPrinter.cond_return retval = new AstPrinter.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR156=null;
        CommonTree AND159=null;
        CommonTree NOT162=null;
        CommonTree NULL164=null;
        CommonTree NOT166=null;
        CommonTree BOOL_COND172=null;
        AstPrinter.cond_return cond157 =null;

        AstPrinter.cond_return cond158 =null;

        AstPrinter.cond_return cond160 =null;

        AstPrinter.cond_return cond161 =null;

        AstPrinter.cond_return cond163 =null;

        AstPrinter.expr_return expr165 =null;

        AstPrinter.rel_op_return rel_op167 =null;

        AstPrinter.expr_return expr168 =null;

        AstPrinter.expr_return expr169 =null;

        AstPrinter.in_eval_return in_eval170 =null;

        AstPrinter.func_eval_return func_eval171 =null;

        AstPrinter.expr_return expr173 =null;


        CommonTree OR156_tree=null;
        CommonTree AND159_tree=null;
        CommonTree NOT162_tree=null;
        CommonTree NULL164_tree=null;
        CommonTree NOT166_tree=null;
        CommonTree BOOL_COND172_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:279:5: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) )
            int alt51=8;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt51=1;
                }
                break;
            case AND:
                {
                alt51=2;
                }
                break;
            case NOT:
                {
                alt51=3;
                }
                break;
            case NULL:
                {
                alt51=4;
                }
                break;
            case NUM_OP_EQ:
            case NUM_OP_GT:
            case NUM_OP_GTE:
            case NUM_OP_LT:
            case NUM_OP_LTE:
            case NUM_OP_NE:
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt51=5;
                }
                break;
            case IN:
                {
                alt51=6;
                }
                break;
            case FUNC_EVAL:
                {
                alt51=7;
                }
                break;
            case BOOL_COND:
                {
                alt51=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }

            switch (alt51) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:279:7: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR156=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1787); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR156_tree = (CommonTree)adaptor.dupNode(OR156);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR156_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1791);
                    cond157=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond157.getTree());


                    if ( state.backtracking==0 ) { sb.append(") ").append((OR156!=null?OR156.getText():null)).append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1795);
                    cond158=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond158.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:280:7: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND159=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1809); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND159_tree = (CommonTree)adaptor.dupNode(AND159);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND159_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1813);
                    cond160=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond160.getTree());


                    if ( state.backtracking==0 ) { sb.append(") ").append((AND159!=null?AND159.getText():null)).append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1817);
                    cond161=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond161.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:281:7: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT162=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1831); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT162_tree = (CommonTree)adaptor.dupNode(NOT162);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT162_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((NOT162!=null?NOT162.getText():null)).append(" ("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1835);
                    cond163=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond163.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:282:7: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL164=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1849); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL164_tree = (CommonTree)adaptor.dupNode(NULL164);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL164_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1851);
                    expr165=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr165.getTree());


                    if ( state.backtracking==0 ) { sb.append(" IS "); }

                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:282:43: ( NOT )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==NOT) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:282:44: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT166=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1856); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT166_tree = (CommonTree)adaptor.dupNode(NOT166);


                            adaptor.addChild(root_1, NOT166_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append((NOT166!=null?NOT166.getText():null)).append(" "); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append((NULL164!=null?NULL164.getText():null)); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:283:7: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1876);
                    rel_op167=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op167.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1878);
                    expr168=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr168.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((rel_op167!=null?rel_op167.result:null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1882);
                    expr169=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr169.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:284:7: in_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond1892);
                    in_eval170=in_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval170.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:285:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1900);
                    func_eval171=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval171.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:286:7: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND172=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond1910); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND172_tree = (CommonTree)adaptor.dupNode(BOOL_COND172);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND172_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1912);
                    expr173=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr173.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "in_eval"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:289:1: in_eval : ^( IN expr ( expr )+ ) ;
    public final AstPrinter.in_eval_return in_eval() throws RecognitionException {
        AstPrinter.in_eval_return retval = new AstPrinter.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN174=null;
        AstPrinter.expr_return expr175 =null;

        AstPrinter.expr_return expr176 =null;


        CommonTree IN174_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:290:5: ( ^( IN expr ( expr )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:290:7: ^( IN expr ( expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN174=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval1929); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN174_tree = (CommonTree)adaptor.dupNode(IN174);


            root_1 = (CommonTree)adaptor.becomeRoot(IN174_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" " + (IN174!=null?IN174.getText():null) + "("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_in_eval1933);
            expr175=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr175.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:290:55: ( expr )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==BIGDECIMALNUMBER||LA52_0==BIGINTEGERNUMBER||LA52_0==CUBE||LA52_0==DIV||LA52_0==DOLLARVAR||LA52_0==DOUBLENUMBER||LA52_0==FALSE||LA52_0==FLOATNUMBER||LA52_0==GROUP||LA52_0==IDENTIFIER||LA52_0==INTEGER||LA52_0==LONGINTEGER||LA52_0==MINUS||LA52_0==NULL||LA52_0==PERCENT||LA52_0==PLUS||LA52_0==QUOTEDSTRING||LA52_0==STAR||LA52_0==TRUE||(LA52_0 >= BAG_VAL && LA52_0 <= BIN_EXPR)||(LA52_0 >= CASE_COND && LA52_0 <= CAST_EXPR)||LA52_0==EXPR_IN_PAREN||LA52_0==FUNC_EVAL||(LA52_0 >= MAP_VAL && LA52_0 <= NEG)||LA52_0==TUPLE_VAL) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:290:57: expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1939);
            	    expr176=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, expr176.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt52 >= 1 ) break loop52;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
            } while (true);


            if ( state.backtracking==0 ) { sb.append(") "); }

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
    // $ANTLR end "in_eval"


    public static class func_eval_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:293:1: func_eval : ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) );
    public final AstPrinter.func_eval_return func_eval() throws RecognitionException {
        AstPrinter.func_eval_return retval = new AstPrinter.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL177=null;
        CommonTree FUNC_EVAL181=null;
        AstPrinter.func_name_return func_name178 =null;

        AstPrinter.real_arg_return real_arg179 =null;

        AstPrinter.real_arg_return real_arg180 =null;

        AstPrinter.func_name_return func_name182 =null;


        CommonTree FUNC_EVAL177_tree=null;
        CommonTree FUNC_EVAL181_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:294:5: ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) )
            int alt54=2;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:294:7: ^( FUNC_EVAL func_name real_arg ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL177=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1961); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL177_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL177);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL177_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1963);
                    func_name178=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name178.getTree());


                    if ( state.backtracking==0 ) { sb.append("("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_real_arg_in_func_eval1967);
                    real_arg179=real_arg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, real_arg179.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:294:59: ( real_arg )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==BIGDECIMALNUMBER||LA53_0==BIGINTEGERNUMBER||LA53_0==CUBE||LA53_0==DIV||LA53_0==DOLLARVAR||LA53_0==DOUBLENUMBER||LA53_0==FALSE||LA53_0==FLOATNUMBER||LA53_0==GROUP||LA53_0==IDENTIFIER||LA53_0==INTEGER||LA53_0==LONGINTEGER||LA53_0==MINUS||LA53_0==NULL||LA53_0==PERCENT||LA53_0==PLUS||LA53_0==QUOTEDSTRING||LA53_0==STAR||LA53_0==TRUE||(LA53_0 >= BAG_VAL && LA53_0 <= BIN_EXPR)||(LA53_0 >= CASE_COND && LA53_0 <= EXPR_IN_PAREN)||LA53_0==FUNC_EVAL||(LA53_0 >= MAP_VAL && LA53_0 <= NEG)||LA53_0==TUPLE_VAL) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:294:61: real_arg
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval1973);
                    	    real_arg180=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg180.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:295:7: ^( FUNC_EVAL func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL181=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1989); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL181_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL181);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL181_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1991);
                    func_name182=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name182.getTree());


                    if ( state.backtracking==0 ) { sb.append("()"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:298:1: real_arg : ( expr | STAR | col_range );
    public final AstPrinter.real_arg_return real_arg() throws RecognitionException {
        AstPrinter.real_arg_return retval = new AstPrinter.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR184=null;
        AstPrinter.expr_return expr183 =null;

        AstPrinter.col_range_return col_range185 =null;


        CommonTree STAR184_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:299:5: ( expr | STAR | col_range )
            int alt55=3;
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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt55=1;
                }
                break;
            case STAR:
                {
                int LA55_2 = input.LA(2);

                if ( (LA55_2==DOWN) ) {
                    alt55=1;
                }
                else if ( (LA55_2==EOF||LA55_2==UP||LA55_2==BIGDECIMALNUMBER||LA55_2==BIGINTEGERNUMBER||LA55_2==CUBE||LA55_2==DIV||LA55_2==DOLLARVAR||LA55_2==DOUBLENUMBER||LA55_2==FALSE||LA55_2==FLOATNUMBER||LA55_2==GROUP||LA55_2==IDENTIFIER||LA55_2==INTEGER||LA55_2==LONGINTEGER||LA55_2==MINUS||LA55_2==NULL||LA55_2==PERCENT||LA55_2==PLUS||LA55_2==QUOTEDSTRING||LA55_2==STAR||LA55_2==TRUE||(LA55_2 >= BAG_VAL && LA55_2 <= BIN_EXPR)||(LA55_2 >= CASE_COND && LA55_2 <= EXPR_IN_PAREN)||LA55_2==FUNC_EVAL||(LA55_2 >= MAP_VAL && LA55_2 <= NEG)||LA55_2==TUPLE_VAL) ) {
                    alt55=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt55=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }

            switch (alt55) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:299:7: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg2009);
                    expr183=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr183.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:299:14: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR184=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg2013); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR184_tree = (CommonTree)adaptor.dupNode(STAR184);


                    adaptor.addChild(root_0, STAR184_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR184!=null?STAR184.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:299:48: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg2019);
                    col_range185=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range185.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:302:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AstPrinter.expr_return expr() throws RecognitionException {
        AstPrinter.expr_return retval = new AstPrinter.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS186=null;
        CommonTree MINUS189=null;
        CommonTree STAR192=null;
        CommonTree DIV195=null;
        CommonTree PERCENT198=null;
        CommonTree CAST_EXPR201=null;
        CommonTree NEG206=null;
        CommonTree CAST_EXPR208=null;
        CommonTree EXPR_IN_PAREN211=null;
        AstPrinter.expr_return expr187 =null;

        AstPrinter.expr_return expr188 =null;

        AstPrinter.expr_return expr190 =null;

        AstPrinter.expr_return expr191 =null;

        AstPrinter.expr_return expr193 =null;

        AstPrinter.expr_return expr194 =null;

        AstPrinter.expr_return expr196 =null;

        AstPrinter.expr_return expr197 =null;

        AstPrinter.expr_return expr199 =null;

        AstPrinter.expr_return expr200 =null;

        AstPrinter.type_return type202 =null;

        AstPrinter.expr_return expr203 =null;

        AstPrinter.const_expr_return const_expr204 =null;

        AstPrinter.var_expr_return var_expr205 =null;

        AstPrinter.expr_return expr207 =null;

        AstPrinter.type_cast_return type_cast209 =null;

        AstPrinter.expr_return expr210 =null;

        AstPrinter.expr_return expr212 =null;


        CommonTree PLUS186_tree=null;
        CommonTree MINUS189_tree=null;
        CommonTree STAR192_tree=null;
        CommonTree DIV195_tree=null;
        CommonTree PERCENT198_tree=null;
        CommonTree CAST_EXPR201_tree=null;
        CommonTree NEG206_tree=null;
        CommonTree CAST_EXPR208_tree=null;
        CommonTree EXPR_IN_PAREN211_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:303:5: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt56=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt56=1;
                }
                break;
            case MINUS:
                {
                int LA56_2 = input.LA(2);

                if ( (synpred101_AstPrinter()) ) {
                    alt56=2;
                }
                else if ( (synpred106_AstPrinter()) ) {
                    alt56=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt56=3;
                }
                break;
            case DIV:
                {
                alt56=4;
                }
                break;
            case PERCENT:
                {
                alt56=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA56_6 = input.LA(2);

                if ( (synpred105_AstPrinter()) ) {
                    alt56=6;
                }
                else if ( (synpred109_AstPrinter()) ) {
                    alt56=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 6, input);

                    throw nvae;

                }
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
                alt56=7;
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
                {
                alt56=8;
                }
                break;
            case NEG:
                {
                alt56=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt56=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }

            switch (alt56) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:303:7: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS186=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr2034); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS186_tree = (CommonTree)adaptor.dupNode(PLUS186);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS186_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2036);
                    expr187=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr187.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((PLUS186!=null?PLUS186.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2040);
                    expr188=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr188.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:304:7: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS189=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr2052); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS189_tree = (CommonTree)adaptor.dupNode(MINUS189);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS189_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2054);
                    expr190=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr190.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((MINUS189!=null?MINUS189.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2058);
                    expr191=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr191.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:305:7: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR192=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr2070); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR192_tree = (CommonTree)adaptor.dupNode(STAR192);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR192_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2072);
                    expr193=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr193.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((STAR192!=null?STAR192.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2076);
                    expr194=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr194.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:306:7: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV195=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2088); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV195_tree = (CommonTree)adaptor.dupNode(DIV195);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV195_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2090);
                    expr196=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr196.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((DIV195!=null?DIV195.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2094);
                    expr197=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr197.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:307:7: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT198=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr2106); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT198_tree = (CommonTree)adaptor.dupNode(PERCENT198);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT198_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2108);
                    expr199=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr199.getTree());


                    if ( state.backtracking==0 ) { sb.append(" ").append((PERCENT198!=null?PERCENT198.getText():null)).append(" "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2112);
                    expr200=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr200.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:308:7: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR201=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2124); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR201_tree = (CommonTree)adaptor.dupNode(CAST_EXPR201);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR201_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr2128);
                    type202=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type202.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2132);
                    expr203=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr203.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:309:7: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr2142);
                    const_expr204=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr204.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:310:7: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr2150);
                    var_expr205=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr205.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:311:7: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG206=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr2160); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG206_tree = (CommonTree)adaptor.dupNode(NEG206);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG206_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append((NEG206!=null?NEG206.getText():null)); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2164);
                    expr207=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr207.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:312:7: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR208=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2176); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR208_tree = (CommonTree)adaptor.dupNode(CAST_EXPR208);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR208_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr2180);
                    type_cast209=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast209.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2184);
                    expr210=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr210.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:313:7: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN211=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr2196); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN211_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN211);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN211_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2200);
                    expr212=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr212.getTree());


                    if ( state.backtracking==0 ) { sb.append(")"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:316:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AstPrinter.type_cast_return type_cast() throws RecognitionException {
        AstPrinter.type_cast_return retval = new AstPrinter.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.simple_type_return simple_type213 =null;

        AstPrinter.map_type_return map_type214 =null;

        AstPrinter.tuple_type_cast_return tuple_type_cast215 =null;

        AstPrinter.bag_type_cast_return bag_type_cast216 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:317:5: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt57=4;
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
                alt57=1;
                }
                break;
            case MAP_TYPE:
                {
                alt57=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt57=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt57=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }

            switch (alt57) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:317:7: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast2217);
                    simple_type213=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type213.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:317:21: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast2221);
                    map_type214=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type214.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:317:32: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast2225);
                    tuple_type_cast215=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast215.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:317:50: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast2229);
                    bag_type_cast216=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast216.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:320:1: tuple_type_cast : ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) | ^( TUPLE_TYPE_CAST ( type_cast )? ) );
    public final AstPrinter.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AstPrinter.tuple_type_cast_return retval = new AstPrinter.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST217=null;
        CommonTree TUPLE_TYPE_CAST220=null;
        AstPrinter.type_cast_return type_cast218 =null;

        AstPrinter.type_cast_return type_cast219 =null;

        AstPrinter.type_cast_return type_cast221 =null;


        CommonTree TUPLE_TYPE_CAST217_tree=null;
        CommonTree TUPLE_TYPE_CAST220_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:321:5: ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) | ^( TUPLE_TYPE_CAST ( type_cast )? ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==TUPLE_TYPE_CAST) ) {
                int LA60_1 = input.LA(2);

                if ( (synpred114_AstPrinter()) ) {
                    alt60=1;
                }
                else if ( (true) ) {
                    alt60=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:321:7: ^( TUPLE_TYPE_CAST type_cast ( type_cast )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_TYPE_CAST217=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2244); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_TYPE_CAST217_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST217);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST217_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("tuple("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2248);
                    type_cast218=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast218.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:321:61: ( type_cast )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==BIGDECIMAL||LA58_0==BIGINTEGER||LA58_0==BOOLEAN||LA58_0==BYTEARRAY||LA58_0==CHARARRAY||LA58_0==DATETIME||LA58_0==DOUBLE||LA58_0==FLOAT||LA58_0==INT||LA58_0==LONG||LA58_0==BAG_TYPE_CAST||LA58_0==MAP_TYPE||LA58_0==TUPLE_TYPE_CAST) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:321:63: type_cast
                    	    {
                    	    if ( state.backtracking==0 ) {sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2254);
                    	    type_cast219=type_cast();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, type_cast219.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) {sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:322:7: ^( TUPLE_TYPE_CAST ( type_cast )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_TYPE_CAST220=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2270); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_TYPE_CAST220_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST220);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST220_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("tuple("); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:322:51: ( type_cast )?
                        int alt59=2;
                        int LA59_0 = input.LA(1);

                        if ( (LA59_0==BIGDECIMAL||LA59_0==BIGINTEGER||LA59_0==BOOLEAN||LA59_0==BYTEARRAY||LA59_0==CHARARRAY||LA59_0==DATETIME||LA59_0==DOUBLE||LA59_0==FLOAT||LA59_0==INT||LA59_0==LONG||LA59_0==BAG_TYPE_CAST||LA59_0==MAP_TYPE||LA59_0==TUPLE_TYPE_CAST) ) {
                            alt59=1;
                        }
                        switch (alt59) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:322:51: type_cast
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_type_cast_in_tuple_type_cast2274);
                                type_cast221=type_cast();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, type_cast221.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        if ( state.backtracking==0 ) {sb.append(")"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:325:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AstPrinter.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AstPrinter.bag_type_cast_return retval = new AstPrinter.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST222=null;
        AstPrinter.tuple_type_cast_return tuple_type_cast223 =null;


        CommonTree BAG_TYPE_CAST222_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:326:5: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:326:7: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST222=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2294); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST222_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST222);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST222_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append("bag{"); }

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:326:47: ( tuple_type_cast )?
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==TUPLE_TYPE_CAST) ) {
                    alt61=1;
                }
                switch (alt61) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:326:47: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast2298);
                        tuple_type_cast223=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast223.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                if ( state.backtracking==0 ) {sb.append("}"); }

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
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:329:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AstPrinter.var_expr_return var_expr() throws RecognitionException {
        AstPrinter.var_expr_return retval = new AstPrinter.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.projectable_expr_return projectable_expr224 =null;

        AstPrinter.dot_proj_return dot_proj225 =null;

        AstPrinter.pound_proj_return pound_proj226 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:330:5: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:330:7: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr2316);
            projectable_expr224=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr224.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:330:24: ( dot_proj | pound_proj )*
            loop62:
            do {
                int alt62=3;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==PERIOD) ) {
                    alt62=1;
                }
                else if ( (LA62_0==POUND) ) {
                    alt62=2;
                }


                switch (alt62) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:330:26: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr2320);
            	    dot_proj225=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj225.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:330:37: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr2324);
            	    pound_proj226=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj226.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop62;
                }
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
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:333:1: projectable_expr : ( func_eval | col_ref | bin_expr | case_expr | case_cond );
    public final AstPrinter.projectable_expr_return projectable_expr() throws RecognitionException {
        AstPrinter.projectable_expr_return retval = new AstPrinter.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.func_eval_return func_eval227 =null;

        AstPrinter.col_ref_return col_ref228 =null;

        AstPrinter.bin_expr_return bin_expr229 =null;

        AstPrinter.case_expr_return case_expr230 =null;

        AstPrinter.case_cond_return case_cond231 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:334:5: ( func_eval | col_ref | bin_expr | case_expr | case_cond )
            int alt63=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
                {
                alt63=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt63=2;
                }
                break;
            case BIN_EXPR:
                {
                alt63=3;
                }
                break;
            case CASE_EXPR:
                {
                alt63=4;
                }
                break;
            case CASE_COND:
                {
                alt63=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }

            switch (alt63) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:334:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr2340);
                    func_eval227=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval227.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:334:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr2344);
                    col_ref228=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref228.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:334:29: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr2348);
                    bin_expr229=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr229.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:334:40: case_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr2352);
                    case_expr230=case_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr230.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:334:52: case_cond
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr2356);
                    case_cond231=case_cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond231.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:337:1: dot_proj : ^( PERIOD col_alias_or_index ( col_alias_or_index )* ) ;
    public final AstPrinter.dot_proj_return dot_proj() throws RecognitionException {
        AstPrinter.dot_proj_return retval = new AstPrinter.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD232=null;
        AstPrinter.col_alias_or_index_return col_alias_or_index233 =null;

        AstPrinter.col_alias_or_index_return col_alias_or_index234 =null;


        CommonTree PERIOD232_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:338:5: ( ^( PERIOD col_alias_or_index ( col_alias_or_index )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:338:7: ^( PERIOD col_alias_or_index ( col_alias_or_index )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD232=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj2371); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD232_tree = (CommonTree)adaptor.dupNode(PERIOD232);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD232_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(".("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2375);
            col_alias_or_index233=col_alias_or_index();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_alias_or_index233.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:338:57: ( col_alias_or_index )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==CUBE||LA64_0==DOLLARVAR||LA64_0==GROUP||LA64_0==IDENTIFIER) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:338:59: col_alias_or_index
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2381);
            	    col_alias_or_index234=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index234.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:341:1: col_alias_or_index : ( col_alias | col_index );
    public final AstPrinter.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AstPrinter.col_alias_or_index_return retval = new AstPrinter.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.col_alias_return col_alias235 =null;

        AstPrinter.col_index_return col_index236 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:341:20: ( col_alias | col_index )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==CUBE||LA65_0==GROUP||LA65_0==IDENTIFIER) ) {
                alt65=1;
            }
            else if ( (LA65_0==DOLLARVAR) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;

            }
            switch (alt65) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:341:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index2397);
                    col_alias235=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias235.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:341:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index2401);
                    col_index236=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index236.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:344:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AstPrinter.col_alias_return col_alias() throws RecognitionException {
        AstPrinter.col_alias_return retval = new AstPrinter.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP237=null;
        CommonTree CUBE238=null;
        CommonTree IDENTIFIER239=null;

        CommonTree GROUP237_tree=null;
        CommonTree CUBE238_tree=null;
        CommonTree IDENTIFIER239_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:345:5: ( GROUP | CUBE | IDENTIFIER )
            int alt66=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt66=1;
                }
                break;
            case CUBE:
                {
                alt66=2;
                }
                break;
            case IDENTIFIER:
                {
                alt66=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }

            switch (alt66) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:345:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP237=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_col_alias2414); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP237_tree = (CommonTree)adaptor.dupNode(GROUP237);


                    adaptor.addChild(root_0, GROUP237_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP237!=null?GROUP237.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:346:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE238=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_col_alias2424); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE238_tree = (CommonTree)adaptor.dupNode(CUBE238);


                    adaptor.addChild(root_0, CUBE238_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE238!=null?CUBE238.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:347:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER239=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_col_alias2434); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER239_tree = (CommonTree)adaptor.dupNode(IDENTIFIER239);


                    adaptor.addChild(root_0, IDENTIFIER239_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER239!=null?IDENTIFIER239.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:350:1: col_index : DOLLARVAR ;
    public final AstPrinter.col_index_return col_index() throws RecognitionException {
        AstPrinter.col_index_return retval = new AstPrinter.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR240=null;

        CommonTree DOLLARVAR240_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:351:5: ( DOLLARVAR )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:351:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR240=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2449); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR240_tree = (CommonTree)adaptor.dupNode(DOLLARVAR240);


            adaptor.addChild(root_0, DOLLARVAR240_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DOLLARVAR240!=null?DOLLARVAR240.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:354:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AstPrinter.col_range_return col_range() throws RecognitionException {
        AstPrinter.col_range_return retval = new AstPrinter.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE241=null;
        CommonTree DOUBLE_PERIOD243=null;
        AstPrinter.col_ref_return col_ref242 =null;

        AstPrinter.col_ref_return col_ref244 =null;


        CommonTree COL_RANGE241_tree=null;
        CommonTree DOUBLE_PERIOD243_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:354:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:354:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE241=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2462); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE241_tree = (CommonTree)adaptor.dupNode(COL_RANGE241);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE241_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:354:26: ( col_ref )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==CUBE||LA67_0==DOLLARVAR||LA67_0==GROUP||LA67_0==IDENTIFIER) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:354:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2464);
                    col_ref242=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref242.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) { sb.append(".."); }

            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD243=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2469); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD243_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD243);


            adaptor.addChild(root_1, DOUBLE_PERIOD243_tree);
            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:354:70: ( col_ref )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==CUBE||LA68_0==DOLLARVAR||LA68_0==GROUP||LA68_0==IDENTIFIER) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:354:70: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2471);
                    col_ref244=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref244.getTree());


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
    // $ANTLR end "col_range"


    public static class pound_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:357:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AstPrinter.pound_proj_return pound_proj() throws RecognitionException {
        AstPrinter.pound_proj_return retval = new AstPrinter.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND245=null;
        CommonTree QUOTEDSTRING246=null;
        CommonTree NULL247=null;

        CommonTree POUND245_tree=null;
        CommonTree QUOTEDSTRING246_tree=null;
        CommonTree NULL247_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:358:5: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:358:7: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND245=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2488); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND245_tree = (CommonTree)adaptor.dupNode(POUND245);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND245_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((POUND245!=null?POUND245.getText():null)); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:359:9: ( QUOTEDSTRING | NULL )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==QUOTEDSTRING) ) {
                alt69=1;
            }
            else if ( (LA69_0==NULL) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }
            switch (alt69) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:359:11: QUOTEDSTRING
                    {
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING246=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_pound_proj2502); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING246_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING246);


                    adaptor.addChild(root_1, QUOTEDSTRING246_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING246!=null?QUOTEDSTRING246.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:359:61: NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    NULL247=(CommonTree)match(input,NULL,FOLLOW_NULL_in_pound_proj2508); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL247_tree = (CommonTree)adaptor.dupNode(NULL247);


                    adaptor.addChild(root_1, NULL247_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL247!=null?NULL247.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:362:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AstPrinter.bin_expr_return bin_expr() throws RecognitionException {
        AstPrinter.bin_expr_return retval = new AstPrinter.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR248=null;
        AstPrinter.cond_return cond249 =null;

        AstPrinter.expr_return expr250 =null;

        AstPrinter.expr_return expr251 =null;


        CommonTree BIN_EXPR248_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:363:5: ( ^( BIN_EXPR cond expr expr ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:363:7: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR248=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2529); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR248_tree = (CommonTree)adaptor.dupNode(BIN_EXPR248);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR248_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2533);
            cond249=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond249.getTree());


            if ( state.backtracking==0 ) { sb.append(" ? "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2537);
            expr250=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr250.getTree());


            if ( state.backtracking==0 ) { sb.append(" : "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2541);
            expr251=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr251.getTree());


            if ( state.backtracking==0 ) { sb.append(") "); }

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
    // $ANTLR end "bin_expr"


    public static class case_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:366:1: case_expr : ^( CASE_EXPR expr ( expr )+ ) ;
    public final AstPrinter.case_expr_return case_expr() throws RecognitionException {
        AstPrinter.case_expr_return retval = new AstPrinter.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR252=null;
        AstPrinter.expr_return expr253 =null;

        AstPrinter.expr_return expr254 =null;


        CommonTree CASE_EXPR252_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:367:5: ( ^( CASE_EXPR expr ( expr )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:367:7: ^( CASE_EXPR expr ( expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR252=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr2560); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR252_tree = (CommonTree)adaptor.dupNode(CASE_EXPR252);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR252_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" CASE ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_case_expr2564);
            expr253=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr253.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:367:51: ( expr )+
            int cnt70=0;
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==BIGDECIMALNUMBER||LA70_0==BIGINTEGERNUMBER||LA70_0==CUBE||LA70_0==DIV||LA70_0==DOLLARVAR||LA70_0==DOUBLENUMBER||LA70_0==FALSE||LA70_0==FLOATNUMBER||LA70_0==GROUP||LA70_0==IDENTIFIER||LA70_0==INTEGER||LA70_0==LONGINTEGER||LA70_0==MINUS||LA70_0==NULL||LA70_0==PERCENT||LA70_0==PLUS||LA70_0==QUOTEDSTRING||LA70_0==STAR||LA70_0==TRUE||(LA70_0 >= BAG_VAL && LA70_0 <= BIN_EXPR)||(LA70_0 >= CASE_COND && LA70_0 <= CAST_EXPR)||LA70_0==EXPR_IN_PAREN||LA70_0==FUNC_EVAL||(LA70_0 >= MAP_VAL && LA70_0 <= NEG)||LA70_0==TUPLE_VAL) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:367:53: expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2570);
            	    expr254=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, expr254.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt70 >= 1 ) break loop70;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(70, input);
                        throw eee;
                }
                cnt70++;
            } while (true);


            if ( state.backtracking==0 ) { sb.append(") "); }

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
    // $ANTLR end "case_expr"


    public static class case_cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_cond"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:370:1: case_cond : ^( CASE_COND ^( WHEN cond ( cond )* ) ^( THEN expr ( expr )* ) ) ;
    public final AstPrinter.case_cond_return case_cond() throws RecognitionException {
        AstPrinter.case_cond_return retval = new AstPrinter.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND255=null;
        CommonTree WHEN256=null;
        CommonTree THEN259=null;
        AstPrinter.cond_return cond257 =null;

        AstPrinter.cond_return cond258 =null;

        AstPrinter.expr_return expr260 =null;

        AstPrinter.expr_return expr261 =null;


        CommonTree CASE_COND255_tree=null;
        CommonTree WHEN256_tree=null;
        CommonTree THEN259_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:371:5: ( ^( CASE_COND ^( WHEN cond ( cond )* ) ^( THEN expr ( expr )* ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:371:7: ^( CASE_COND ^( WHEN cond ( cond )* ) ^( THEN expr ( expr )* ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND255=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond2592); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND255_tree = (CommonTree)adaptor.dupNode(CASE_COND255);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND255_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" CASE ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN256=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond2606); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN256_tree = (CommonTree)adaptor.dupNode(WHEN256);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN256_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_case_cond2608);
            cond257=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, cond257.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:372:22: ( cond )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==AND||LA71_0==IN||(LA71_0 >= NOT && LA71_0 <= NUM_OP_NE)||LA71_0==OR||(LA71_0 >= STR_OP_EQ && LA71_0 <= STR_OP_NE)||LA71_0==BOOL_COND||LA71_0==FUNC_EVAL) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:372:24: cond
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond2614);
            	    cond258=cond();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond258.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(", "); }

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
            THEN259=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond2633); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN259_tree = (CommonTree)adaptor.dupNode(THEN259);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN259_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_case_cond2635);
            expr260=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_2, expr260.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:373:22: ( expr )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==BIGDECIMALNUMBER||LA72_0==BIGINTEGERNUMBER||LA72_0==CUBE||LA72_0==DIV||LA72_0==DOLLARVAR||LA72_0==DOUBLENUMBER||LA72_0==FALSE||LA72_0==FLOATNUMBER||LA72_0==GROUP||LA72_0==IDENTIFIER||LA72_0==INTEGER||LA72_0==LONGINTEGER||LA72_0==MINUS||LA72_0==NULL||LA72_0==PERCENT||LA72_0==PLUS||LA72_0==QUOTEDSTRING||LA72_0==STAR||LA72_0==TRUE||(LA72_0 >= BAG_VAL && LA72_0 <= BIN_EXPR)||(LA72_0 >= CASE_COND && LA72_0 <= CAST_EXPR)||LA72_0==EXPR_IN_PAREN||LA72_0==FUNC_EVAL||(LA72_0 >= MAP_VAL && LA72_0 <= NEG)||LA72_0==TUPLE_VAL) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:373:24: expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond2641);
            	    expr261=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr261.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(") "); }

            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
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
    // $ANTLR end "case_cond"


    public static class limit_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:376:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AstPrinter.limit_clause_return limit_clause() throws RecognitionException {
        AstPrinter.limit_clause_return retval = new AstPrinter.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT262=null;
        CommonTree INTEGER264=null;
        CommonTree LONGINTEGER265=null;
        AstPrinter.rel_return rel263 =null;

        AstPrinter.expr_return expr266 =null;


        CommonTree LIMIT262_tree=null;
        CommonTree INTEGER264_tree=null;
        CommonTree LONGINTEGER265_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:377:5: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:377:7: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT262=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2665); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT262_tree = (CommonTree)adaptor.dupNode(LIMIT262);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT262_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LIMIT262!=null?LIMIT262.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2669);
            rel263=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel263.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:378:9: ( INTEGER | LONGINTEGER | expr )
            int alt73=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA73_1 = input.LA(2);

                if ( (synpred133_AstPrinter()) ) {
                    alt73=1;
                }
                else if ( (true) ) {
                    alt73=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA73_2 = input.LA(2);

                if ( (synpred134_AstPrinter()) ) {
                    alt73=2;
                }
                else if ( (true) ) {
                    alt73=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 2, input);

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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt73=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;

            }

            switch (alt73) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:378:11: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER264=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2681); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER264_tree = (CommonTree)adaptor.dupNode(INTEGER264);


                    adaptor.addChild(root_1, INTEGER264_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INTEGER264!=null?INTEGER264.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:378:63: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER265=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2687); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER265_tree = (CommonTree)adaptor.dupNode(LONGINTEGER265);


                    adaptor.addChild(root_1, LONGINTEGER265_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((LONGINTEGER265!=null?LONGINTEGER265.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:378:123: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2693);
                    expr266=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr266.getTree());


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
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:381:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AstPrinter.sample_clause_return sample_clause() throws RecognitionException {
        AstPrinter.sample_clause_return retval = new AstPrinter.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE267=null;
        CommonTree DOUBLENUMBER269=null;
        AstPrinter.rel_return rel268 =null;

        AstPrinter.expr_return expr270 =null;


        CommonTree SAMPLE267_tree=null;
        CommonTree DOUBLENUMBER269_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:382:5: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:382:7: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE267=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2712); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE267_tree = (CommonTree)adaptor.dupNode(SAMPLE267);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE267_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((SAMPLE267!=null?SAMPLE267.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2716);
            rel268=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel268.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:382:62: ( DOUBLENUMBER | expr )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==DOUBLENUMBER) ) {
                int LA74_1 = input.LA(2);

                if ( (synpred135_AstPrinter()) ) {
                    alt74=1;
                }
                else if ( (true) ) {
                    alt74=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA74_0==BIGDECIMALNUMBER||LA74_0==BIGINTEGERNUMBER||LA74_0==CUBE||LA74_0==DIV||LA74_0==DOLLARVAR||LA74_0==FALSE||LA74_0==FLOATNUMBER||LA74_0==GROUP||LA74_0==IDENTIFIER||LA74_0==INTEGER||LA74_0==LONGINTEGER||LA74_0==MINUS||LA74_0==NULL||LA74_0==PERCENT||LA74_0==PLUS||LA74_0==QUOTEDSTRING||LA74_0==STAR||LA74_0==TRUE||(LA74_0 >= BAG_VAL && LA74_0 <= BIN_EXPR)||(LA74_0 >= CASE_COND && LA74_0 <= CAST_EXPR)||LA74_0==EXPR_IN_PAREN||LA74_0==FUNC_EVAL||(LA74_0 >= MAP_VAL && LA74_0 <= NEG)||LA74_0==TUPLE_VAL) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;

            }
            switch (alt74) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:382:64: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER269=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2720); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER269_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER269);


                    adaptor.addChild(root_1, DOUBLENUMBER269_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DOUBLENUMBER269!=null?DOUBLENUMBER269.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:382:126: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2726);
                    expr270=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr270.getTree());


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
    // $ANTLR end "sample_clause"


    public static class rank_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:385:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AstPrinter.rank_clause_return rank_clause() throws RecognitionException {
        AstPrinter.rank_clause_return retval = new AstPrinter.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK271=null;
        AstPrinter.rel_return rel272 =null;

        AstPrinter.rank_by_statement_return rank_by_statement273 =null;


        CommonTree RANK271_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:386:5: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:386:7: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK271=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause2745); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK271_tree = (CommonTree)adaptor.dupNode(RANK271);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK271_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((RANK271!=null?RANK271.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause2749);
            rel272=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel272.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:386:58: ( rank_by_statement )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==BY) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:386:60: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause2753);
                    rank_by_statement273=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement273.getTree());


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
    // $ANTLR end "rank_clause"


    public static class rank_by_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_statement"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:389:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AstPrinter.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AstPrinter.rank_by_statement_return retval = new AstPrinter.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY274=null;
        CommonTree DENSE276=null;
        AstPrinter.rank_by_clause_return rank_by_clause275 =null;


        CommonTree BY274_tree=null;
        CommonTree DENSE276_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:390:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:390:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY274=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement2770); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY274_tree = (CommonTree)adaptor.dupNode(BY274);


            root_1 = (CommonTree)adaptor.becomeRoot(BY274_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((BY274!=null?BY274.getText():null)); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement2774);
            rank_by_clause275=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause275.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:390:62: ( DENSE )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==DENSE) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:390:64: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE276=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement2778); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE276_tree = (CommonTree)adaptor.dupNode(DENSE276);


                    adaptor.addChild(root_1, DENSE276_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DENSE276!=null?DENSE276.getText():null)); }

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
    // $ANTLR end "rank_by_statement"


    public static class rank_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:393:1: rank_by_clause : ( STAR ( ASC | DESC )? | rank_col ( rank_col )* );
    public final AstPrinter.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AstPrinter.rank_by_clause_return retval = new AstPrinter.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR277=null;
        CommonTree ASC278=null;
        CommonTree DESC279=null;
        AstPrinter.rank_col_return rank_col280 =null;

        AstPrinter.rank_col_return rank_col281 =null;


        CommonTree STAR277_tree=null;
        CommonTree ASC278_tree=null;
        CommonTree DESC279_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:394:2: ( STAR ( ASC | DESC )? | rank_col ( rank_col )* )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==STAR) ) {
                alt79=1;
            }
            else if ( (LA79_0==CUBE||LA79_0==DOLLARVAR||LA79_0==GROUP||LA79_0==IDENTIFIER||LA79_0==COL_RANGE) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;

            }
            switch (alt79) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:394:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR277=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause2795); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR277_tree = (CommonTree)adaptor.dupNode(STAR277);


                    adaptor.addChild(root_0, STAR277_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR277!=null?STAR277.getText():null)); }

                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:394:36: ( ASC | DESC )?
                    int alt77=3;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==ASC) ) {
                        alt77=1;
                    }
                    else if ( (LA77_0==DESC) ) {
                        alt77=2;
                    }
                    switch (alt77) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:394:38: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC278=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_by_clause2801); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC278_tree = (CommonTree)adaptor.dupNode(ASC278);


                            adaptor.addChild(root_0, ASC278_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((ASC278!=null?ASC278.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:394:82: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC279=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_by_clause2807); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC279_tree = (CommonTree)adaptor.dupNode(DESC279);


                            adaptor.addChild(root_0, DESC279_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((DESC279!=null?DESC279.getText():null)); }

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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:395:7: rank_col ( rank_col )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_col_in_rank_by_clause2820);
                    rank_col280=rank_col();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_col280.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:395:16: ( rank_col )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==CUBE||LA78_0==DOLLARVAR||LA78_0==GROUP||LA78_0==IDENTIFIER||LA78_0==COL_RANGE) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:395:18: rank_col
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause2826);
                    	    rank_col281=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col281.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_col"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:398:1: rank_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AstPrinter.rank_col_return rank_col() throws RecognitionException {
        AstPrinter.rank_col_return retval = new AstPrinter.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC284=null;
        CommonTree DESC285=null;
        AstPrinter.col_range_return col_range282 =null;

        AstPrinter.col_ref_return col_ref283 =null;


        CommonTree ASC284_tree=null;
        CommonTree DESC285_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:399:2: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:399:4: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:399:4: ( col_range | col_ref )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==COL_RANGE) ) {
                alt80=1;
            }
            else if ( (LA80_0==CUBE||LA80_0==DOLLARVAR||LA80_0==GROUP||LA80_0==IDENTIFIER) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:399:6: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col2841);
                    col_range282=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range282.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:399:18: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col2845);
                    col_ref283=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref283.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:399:28: ( ASC | DESC )?
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:399:30: ASC
                    {
                    _last = (CommonTree)input.LT(1);
                    ASC284=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col2851); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC284_tree = (CommonTree)adaptor.dupNode(ASC284);


                    adaptor.addChild(root_0, ASC284_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ASC284!=null?ASC284.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:399:74: DESC
                    {
                    _last = (CommonTree)input.LT(1);
                    DESC285=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col2857); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC285_tree = (CommonTree)adaptor.dupNode(DESC285);


                    adaptor.addChild(root_0, DESC285_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DESC285!=null?DESC285.getText():null)); }

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
    // $ANTLR end "rank_col"


    public static class order_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:402:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AstPrinter.order_clause_return order_clause() throws RecognitionException {
        AstPrinter.order_clause_return retval = new AstPrinter.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER286=null;
        AstPrinter.rel_return rel287 =null;

        AstPrinter.order_by_clause_return order_by_clause288 =null;

        AstPrinter.func_clause_return func_clause289 =null;


        CommonTree ORDER286_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:403:5: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:403:7: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER286=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause2877); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER286_tree = (CommonTree)adaptor.dupNode(ORDER286);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER286_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((ORDER286!=null?ORDER286.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause2881);
            rel287=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel287.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause2893);
            order_by_clause288=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause288.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:405:9: ( func_clause )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==FUNC||LA82_0==FUNC_REF) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:405:11: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause2907);
                    func_clause289=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause289.getTree());


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
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:408:1: order_by_clause : ( STAR ( ASC | DESC )? | order_col ( order_col )* );
    public final AstPrinter.order_by_clause_return order_by_clause() throws RecognitionException {
        AstPrinter.order_by_clause_return retval = new AstPrinter.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR290=null;
        CommonTree ASC291=null;
        CommonTree DESC292=null;
        AstPrinter.order_col_return order_col293 =null;

        AstPrinter.order_col_return order_col294 =null;


        CommonTree STAR290_tree=null;
        CommonTree ASC291_tree=null;
        CommonTree DESC292_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:409:5: ( STAR ( ASC | DESC )? | order_col ( order_col )* )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==STAR) ) {
                alt85=1;
            }
            else if ( (LA85_0==CUBE||LA85_0==DOLLARVAR||LA85_0==GROUP||LA85_0==IDENTIFIER||LA85_0==COL_RANGE) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;

            }
            switch (alt85) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:409:7: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR290=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause2925); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR290_tree = (CommonTree)adaptor.dupNode(STAR290);


                    adaptor.addChild(root_0, STAR290_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR290!=null?STAR290.getText():null)); }

                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:409:39: ( ASC | DESC )?
                    int alt83=3;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==ASC) ) {
                        alt83=1;
                    }
                    else if ( (LA83_0==DESC) ) {
                        alt83=2;
                    }
                    switch (alt83) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:409:41: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC291=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_by_clause2931); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC291_tree = (CommonTree)adaptor.dupNode(ASC291);


                            adaptor.addChild(root_0, ASC291_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((ASC291!=null?ASC291.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:409:85: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC292=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_by_clause2937); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC292_tree = (CommonTree)adaptor.dupNode(DESC292);


                            adaptor.addChild(root_0, DESC292_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((DESC292!=null?DESC292.getText():null)); }

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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:410:7: order_col ( order_col )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_col_in_order_by_clause2950);
                    order_col293=order_col();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_col293.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:410:17: ( order_col )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==CUBE||LA84_0==DOLLARVAR||LA84_0==GROUP||LA84_0==IDENTIFIER||LA84_0==COL_RANGE) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:410:19: order_col
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause2956);
                    	    order_col294=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col294.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop84;
                        }
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:413:1: order_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AstPrinter.order_col_return order_col() throws RecognitionException {
        AstPrinter.order_col_return retval = new AstPrinter.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC297=null;
        CommonTree DESC298=null;
        AstPrinter.col_range_return col_range295 =null;

        AstPrinter.col_ref_return col_ref296 =null;


        CommonTree ASC297_tree=null;
        CommonTree DESC298_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:414:5: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:414:7: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:414:7: ( col_range | col_ref )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==COL_RANGE) ) {
                alt86=1;
            }
            else if ( (LA86_0==CUBE||LA86_0==DOLLARVAR||LA86_0==GROUP||LA86_0==IDENTIFIER) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;

            }
            switch (alt86) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:414:8: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col2972);
                    col_range295=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range295.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:414:20: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col2976);
                    col_ref296=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref296.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:414:29: ( ASC | DESC )?
            int alt87=3;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==ASC) ) {
                alt87=1;
            }
            else if ( (LA87_0==DESC) ) {
                alt87=2;
            }
            switch (alt87) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:414:31: ASC
                    {
                    _last = (CommonTree)input.LT(1);
                    ASC297=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col2981); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC297_tree = (CommonTree)adaptor.dupNode(ASC297);


                    adaptor.addChild(root_0, ASC297_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((ASC297!=null?ASC297.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:414:75: DESC
                    {
                    _last = (CommonTree)input.LT(1);
                    DESC298=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col2987); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC298_tree = (CommonTree)adaptor.dupNode(DESC298);


                    adaptor.addChild(root_0, DESC298_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((DESC298!=null?DESC298.getText():null)); }

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
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:417:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AstPrinter.distinct_clause_return distinct_clause() throws RecognitionException {
        AstPrinter.distinct_clause_return retval = new AstPrinter.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT299=null;
        AstPrinter.rel_return rel300 =null;

        AstPrinter.partition_clause_return partition_clause301 =null;


        CommonTree DISTINCT299_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:418:5: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:418:7: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT299=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause3007); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT299_tree = (CommonTree)adaptor.dupNode(DISTINCT299);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT299_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((DISTINCT299!=null?DISTINCT299.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause3011);
            rel300=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel300.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:418:66: ( partition_clause )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==PARTITION) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:418:66: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause3013);
                    partition_clause301=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause301.getTree());


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
    // $ANTLR end "distinct_clause"


    public static class partition_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:421:1: partition_clause : ^( PARTITION func_name ) ;
    public final AstPrinter.partition_clause_return partition_clause() throws RecognitionException {
        AstPrinter.partition_clause_return retval = new AstPrinter.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION302=null;
        AstPrinter.func_name_return func_name303 =null;


        CommonTree PARTITION302_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:422:5: ( ^( PARTITION func_name ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:422:7: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION302=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause3031); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION302_tree = (CommonTree)adaptor.dupNode(PARTITION302);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION302_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((PARTITION302!=null?PARTITION302.getText():null)).append(" BY "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause3035);
            func_name303=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name303.getTree());


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
    // $ANTLR end "partition_clause"


    public static class cross_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:425:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AstPrinter.cross_clause_return cross_clause() throws RecognitionException {
        AstPrinter.cross_clause_return retval = new AstPrinter.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS304=null;
        AstPrinter.rel_list_return rel_list305 =null;

        AstPrinter.partition_clause_return partition_clause306 =null;


        CommonTree CROSS304_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:426:5: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:426:7: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS304=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause3052); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS304_tree = (CommonTree)adaptor.dupNode(CROSS304);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS304_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((CROSS304!=null?CROSS304.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause3056);
            rel_list305=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list305.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:426:65: ( partition_clause )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==PARTITION) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:426:65: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause3058);
                    partition_clause306=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause306.getTree());


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
    // $ANTLR end "cross_clause"


    public static class rel_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:429:1: rel_list : rel ( rel )* ;
    public final AstPrinter.rel_list_return rel_list() throws RecognitionException {
        AstPrinter.rel_list_return retval = new AstPrinter.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.rel_return rel307 =null;

        AstPrinter.rel_return rel308 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:430:5: ( rel ( rel )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:430:7: rel ( rel )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rel_list3074);
            rel307=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel307.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:430:11: ( rel )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==COGROUP||(LA90_0 >= CROSS && LA90_0 <= CUBE)||LA90_0==DEFINE||LA90_0==DISTINCT||LA90_0==FILTER||LA90_0==FOREACH||LA90_0==GROUP||LA90_0==IDENTIFIER||LA90_0==JOIN||(LA90_0 >= LIMIT && LA90_0 <= LOAD)||LA90_0==MAPREDUCE||LA90_0==ORDER||LA90_0==RANK||LA90_0==SAMPLE||LA90_0==SPLIT||(LA90_0 >= STORE && LA90_0 <= STREAM)||LA90_0==UNION) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:430:13: rel
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list3080);
            	    rel308=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel308.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop90;
                }
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


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:433:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AstPrinter.join_clause_return join_clause() throws RecognitionException {
        AstPrinter.join_clause_return retval = new AstPrinter.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN309=null;
        AstPrinter.join_sub_clause_return join_sub_clause310 =null;

        AstPrinter.join_type_return join_type311 =null;

        AstPrinter.partition_clause_return partition_clause312 =null;


        CommonTree JOIN309_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:434:5: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:434:7: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN309=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause3097); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN309_tree = (CommonTree)adaptor.dupNode(JOIN309);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN309_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((JOIN309!=null?JOIN309.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause3101);
            join_sub_clause310=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause310.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:434:70: ( join_type )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==QUOTEDSTRING) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:434:72: join_type
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause3107);
                    join_type311=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type311.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:435:5: ( partition_clause )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==PARTITION) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:435:7: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause3118);
                    partition_clause312=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause312.getTree());


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
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:438:1: join_type : QUOTEDSTRING ;
    public final AstPrinter.join_type_return join_type() throws RecognitionException {
        AstPrinter.join_type_return retval = new AstPrinter.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING313=null;

        CommonTree QUOTEDSTRING313_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:438:11: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:438:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING313=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type3132); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING313_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING313);


            adaptor.addChild(root_0, QUOTEDSTRING313_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING313!=null?QUOTEDSTRING313.getText():null)); }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:441:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | join_item ( join_item )* );
    public final AstPrinter.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AstPrinter.join_sub_clause_return retval = new AstPrinter.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LEFT315=null;
        CommonTree RIGHT316=null;
        CommonTree FULL317=null;
        CommonTree OUTER318=null;
        AstPrinter.join_item_return join_item314 =null;

        AstPrinter.join_item_return join_item319 =null;

        AstPrinter.join_item_return join_item320 =null;

        AstPrinter.join_item_return join_item321 =null;


        CommonTree LEFT315_tree=null;
        CommonTree RIGHT316_tree=null;
        CommonTree FULL317_tree=null;
        CommonTree OUTER318_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:442:5: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | join_item ( join_item )* )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==JOIN_ITEM) ) {
                int LA96_1 = input.LA(2);

                if ( (synpred161_AstPrinter()) ) {
                    alt96=1;
                }
                else if ( (true) ) {
                    alt96=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 96, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;

            }
            switch (alt96) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:442:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3147);
                    join_item314=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item314.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:442:17: ( LEFT | RIGHT | FULL )
                    int alt93=3;
                    switch ( input.LA(1) ) {
                    case LEFT:
                        {
                        alt93=1;
                        }
                        break;
                    case RIGHT:
                        {
                        alt93=2;
                        }
                        break;
                    case FULL:
                        {
                        alt93=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 93, 0, input);

                        throw nvae;

                    }

                    switch (alt93) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:442:19: LEFT
                            {
                            _last = (CommonTree)input.LT(1);
                            LEFT315=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_join_sub_clause3151); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LEFT315_tree = (CommonTree)adaptor.dupNode(LEFT315);


                            adaptor.addChild(root_0, LEFT315_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((LEFT315!=null?LEFT315.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:443:16: RIGHT
                            {
                            _last = (CommonTree)input.LT(1);
                            RIGHT316=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_join_sub_clause3170); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RIGHT316_tree = (CommonTree)adaptor.dupNode(RIGHT316);


                            adaptor.addChild(root_0, RIGHT316_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((RIGHT316!=null?RIGHT316.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:444:16: FULL
                            {
                            _last = (CommonTree)input.LT(1);
                            FULL317=(CommonTree)match(input,FULL,FOLLOW_FULL_in_join_sub_clause3189); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FULL317_tree = (CommonTree)adaptor.dupNode(FULL317);


                            adaptor.addChild(root_0, FULL317_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((FULL317!=null?FULL317.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:445:16: ( OUTER )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==OUTER) ) {
                        alt94=1;
                    }
                    switch (alt94) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:445:17: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER318=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause3209); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER318_tree = (CommonTree)adaptor.dupNode(OUTER318);


                            adaptor.addChild(root_0, OUTER318_tree);
                            }


                            if ( state.backtracking==0 ) { sb.append(" ").append((OUTER318!=null?OUTER318.getText():null)); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) { sb.append(", "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3218);
                    join_item319=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item319.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:446:7: join_item ( join_item )*
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause3226);
                    join_item320=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item320.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:446:17: ( join_item )*
                    loop95:
                    do {
                        int alt95=2;
                        int LA95_0 = input.LA(1);

                        if ( (LA95_0==JOIN_ITEM) ) {
                            alt95=1;
                        }


                        switch (alt95) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:446:19: join_item
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause3232);
                    	    join_item321=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item321.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop95;
                        }
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:449:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AstPrinter.join_item_return join_item() throws RecognitionException {
        AstPrinter.join_item_return retval = new AstPrinter.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM322=null;
        AstPrinter.rel_return rel323 =null;

        AstPrinter.join_group_by_clause_return join_group_by_clause324 =null;


        CommonTree JOIN_ITEM322_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:450:5: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:450:7: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM322=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item3250); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM322_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM322);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM322_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item3252);
            rel323=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel323.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item3254);
            join_group_by_clause324=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause324.getTree());


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
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:453:1: join_group_by_clause : ^( BY join_group_by_expr ( join_group_by_expr )* ) ;
    public final AstPrinter.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AstPrinter.join_group_by_clause_return retval = new AstPrinter.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY325=null;
        AstPrinter.join_group_by_expr_return join_group_by_expr326 =null;

        AstPrinter.join_group_by_expr_return join_group_by_expr327 =null;


        CommonTree BY325_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:454:5: ( ^( BY join_group_by_expr ( join_group_by_expr )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:454:7: ^( BY join_group_by_expr ( join_group_by_expr )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY325=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause3271); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY325_tree = (CommonTree)adaptor.dupNode(BY325);


            root_1 = (CommonTree)adaptor.becomeRoot(BY325_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((BY325!=null?BY325.getText():null)).append(" ("); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause3279);
            join_group_by_expr326=join_group_by_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_expr326.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:455:24: ( join_group_by_expr )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==BIGDECIMALNUMBER||LA97_0==BIGINTEGERNUMBER||LA97_0==CUBE||LA97_0==DIV||LA97_0==DOLLARVAR||LA97_0==DOUBLENUMBER||LA97_0==FALSE||LA97_0==FLOATNUMBER||LA97_0==GROUP||LA97_0==IDENTIFIER||LA97_0==INTEGER||LA97_0==LONGINTEGER||LA97_0==MINUS||LA97_0==NULL||LA97_0==PERCENT||LA97_0==PLUS||LA97_0==QUOTEDSTRING||LA97_0==STAR||LA97_0==TRUE||(LA97_0 >= BAG_VAL && LA97_0 <= BIN_EXPR)||(LA97_0 >= CASE_COND && LA97_0 <= EXPR_IN_PAREN)||LA97_0==FUNC_EVAL||(LA97_0 >= MAP_VAL && LA97_0 <= NEG)||LA97_0==TUPLE_VAL) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:455:26: join_group_by_expr
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause3285);
            	    join_group_by_expr327=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr327.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop97;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:458:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AstPrinter.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AstPrinter.join_group_by_expr_return retval = new AstPrinter.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR330=null;
        AstPrinter.col_range_return col_range328 =null;

        AstPrinter.expr_return expr329 =null;


        CommonTree STAR330_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:459:5: ( col_range | expr | STAR )
            int alt98=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt98=1;
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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt98=2;
                }
                break;
            case STAR:
                {
                int LA98_3 = input.LA(2);

                if ( (LA98_3==DOWN) ) {
                    alt98=2;
                }
                else if ( (LA98_3==EOF||LA98_3==UP||LA98_3==BIGDECIMALNUMBER||LA98_3==BIGINTEGERNUMBER||LA98_3==CUBE||LA98_3==DIV||LA98_3==DOLLARVAR||LA98_3==DOUBLENUMBER||LA98_3==FALSE||LA98_3==FLOATNUMBER||LA98_3==GROUP||LA98_3==IDENTIFIER||LA98_3==INTEGER||LA98_3==LONGINTEGER||LA98_3==MINUS||LA98_3==NULL||LA98_3==PERCENT||LA98_3==PLUS||LA98_3==QUOTEDSTRING||LA98_3==STAR||LA98_3==TRUE||(LA98_3 >= BAG_VAL && LA98_3 <= BIN_EXPR)||(LA98_3 >= CASE_COND && LA98_3 <= EXPR_IN_PAREN)||LA98_3==FUNC_EVAL||(LA98_3 >= MAP_VAL && LA98_3 <= NEG)||LA98_3==TUPLE_VAL) ) {
                    alt98=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 98, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;

            }

            switch (alt98) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:459:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr3305);
                    col_range328=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range328.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:459:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr3309);
                    expr329=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr329.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:459:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR330=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr3313); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR330_tree = (CommonTree)adaptor.dupNode(STAR330);


                    adaptor.addChild(root_0, STAR330_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STAR330!=null?STAR330.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:462:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AstPrinter.union_clause_return union_clause() throws RecognitionException {
        AstPrinter.union_clause_return retval = new AstPrinter.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION331=null;
        CommonTree ONSCHEMA332=null;
        AstPrinter.rel_list_return rel_list333 =null;


        CommonTree UNION331_tree=null;
        CommonTree ONSCHEMA332_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:463:5: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:463:7: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION331=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause3330); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION331_tree = (CommonTree)adaptor.dupNode(UNION331);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION331_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((UNION331!=null?UNION331.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:463:56: ( ONSCHEMA )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==ONSCHEMA) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:463:57: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA332=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause3335); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA332_tree = (CommonTree)adaptor.dupNode(ONSCHEMA332);


                    adaptor.addChild(root_1, ONSCHEMA332_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ONSCHEMA332!=null?ONSCHEMA332.getText():null)).append(" "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause3342);
            rel_list333=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list333.getTree());


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
    // $ANTLR end "union_clause"


    public static class foreach_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:466:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AstPrinter.foreach_clause_return foreach_clause() throws RecognitionException {
        AstPrinter.foreach_clause_return retval = new AstPrinter.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH334=null;
        AstPrinter.rel_return rel335 =null;

        AstPrinter.foreach_plan_return foreach_plan336 =null;


        CommonTree FOREACH334_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:467:5: ( ^( FOREACH rel foreach_plan ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:467:7: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH334=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause3359); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH334_tree = (CommonTree)adaptor.dupNode(FOREACH334);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH334_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FOREACH334!=null?FOREACH334.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause3363);
            rel335=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel335.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause3365);
            foreach_plan336=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan336.getTree());


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
    // $ANTLR end "foreach_clause"


    public static class foreach_plan_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:470:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AstPrinter.foreach_plan_return foreach_plan() throws RecognitionException {
        AstPrinter.foreach_plan_return retval = new AstPrinter.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE337=null;
        CommonTree FOREACH_PLAN_COMPLEX339=null;
        AstPrinter.generate_clause_return generate_clause338 =null;

        AstPrinter.nested_blk_return nested_blk340 =null;


        CommonTree FOREACH_PLAN_SIMPLE337_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX339_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:471:5: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==FOREACH_PLAN_SIMPLE) ) {
                alt100=1;
            }
            else if ( (LA100_0==FOREACH_PLAN_COMPLEX) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;

            }
            switch (alt100) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:471:7: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE337=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan3382); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE337_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE337);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE337_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan3384);
                    generate_clause338=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause338.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:472:7: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX339=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan3396); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX339_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX339);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX339_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan3398);
                    nested_blk340=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk340.getTree());


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

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "foreach_plan"


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:475:1: nested_blk : ( nested_command )* generate_clause ;
    public final AstPrinter.nested_blk_return nested_blk() throws RecognitionException {
        AstPrinter.nested_blk_return retval = new AstPrinter.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_command_return nested_command341 =null;

        AstPrinter.generate_clause_return generate_clause342 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:476:5: ( ( nested_command )* generate_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:476:7: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            if ( state.backtracking==0 ) { sb.append(" { "); }

            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:476:29: ( nested_command )*
            loop101:
            do {
                int alt101=2;
                int LA101_0 = input.LA(1);

                if ( ((LA101_0 >= NESTED_CMD && LA101_0 <= NESTED_CMD_ASSI)) ) {
                    alt101=1;
                }


                switch (alt101) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:476:30: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk3416);
            	    nested_command341=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command341.getTree());


            	    if ( state.backtracking==0 ) { sb.append("; "); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop101;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk3423);
            generate_clause342=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause342.getTree());


            if ( state.backtracking==0 ) { sb.append("; } "); }

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


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:479:1: generate_clause : ^( GENERATE flatten_generated_item ( flatten_generated_item )* ) ;
    public final AstPrinter.generate_clause_return generate_clause() throws RecognitionException {
        AstPrinter.generate_clause_return retval = new AstPrinter.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE343=null;
        AstPrinter.flatten_generated_item_return flatten_generated_item344 =null;

        AstPrinter.flatten_generated_item_return flatten_generated_item345 =null;


        CommonTree GENERATE343_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:480:5: ( ^( GENERATE flatten_generated_item ( flatten_generated_item )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:480:7: ^( GENERATE flatten_generated_item ( flatten_generated_item )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE343=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause3440); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE343_tree = (CommonTree)adaptor.dupNode(GENERATE343);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE343_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append(" ").append((GENERATE343!=null?GENERATE343.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_flatten_generated_item_in_generate_clause3452);
            flatten_generated_item344=flatten_generated_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, flatten_generated_item344.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:481:32: ( flatten_generated_item )*
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==BIGDECIMALNUMBER||LA102_0==BIGINTEGERNUMBER||LA102_0==CUBE||LA102_0==DIV||LA102_0==DOLLARVAR||LA102_0==DOUBLENUMBER||LA102_0==FALSE||LA102_0==FLATTEN||LA102_0==FLOATNUMBER||LA102_0==GROUP||LA102_0==IDENTIFIER||LA102_0==INTEGER||LA102_0==LONGINTEGER||LA102_0==MINUS||LA102_0==NULL||LA102_0==PERCENT||LA102_0==PLUS||LA102_0==QUOTEDSTRING||LA102_0==STAR||LA102_0==TRUE||(LA102_0 >= BAG_VAL && LA102_0 <= BIN_EXPR)||(LA102_0 >= CASE_COND && LA102_0 <= EXPR_IN_PAREN)||LA102_0==FUNC_EVAL||(LA102_0 >= MAP_VAL && LA102_0 <= NEG)||LA102_0==TUPLE_VAL) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:481:34: flatten_generated_item
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause3458);
            	    flatten_generated_item345=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item345.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop102;
                }
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
    // $ANTLR end "generate_clause"


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:484:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AstPrinter.nested_command_return nested_command() throws RecognitionException {
        AstPrinter.nested_command_return retval = new AstPrinter.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD346=null;
        CommonTree IDENTIFIER347=null;
        CommonTree NESTED_CMD_ASSI349=null;
        CommonTree IDENTIFIER350=null;
        AstPrinter.nested_op_return nested_op348 =null;

        AstPrinter.expr_return expr351 =null;


        CommonTree NESTED_CMD346_tree=null;
        CommonTree IDENTIFIER347_tree=null;
        CommonTree NESTED_CMD_ASSI349_tree=null;
        CommonTree IDENTIFIER350_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:485:5: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==NESTED_CMD) ) {
                alt103=1;
            }
            else if ( (LA103_0==NESTED_CMD_ASSI) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:485:7: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD346=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command3477); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD346_tree = (CommonTree)adaptor.dupNode(NESTED_CMD346);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD346_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER347=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command3479); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER347_tree = (CommonTree)adaptor.dupNode(IDENTIFIER347);


                    adaptor.addChild(root_1, IDENTIFIER347_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER347!=null?IDENTIFIER347.getText():null)).append(" = "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command3483);
                    nested_op348=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op348.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:486:7: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI349=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command3495); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI349_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI349);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI349_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER350=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command3497); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER350_tree = (CommonTree)adaptor.dupNode(IDENTIFIER350);


                    adaptor.addChild(root_1, IDENTIFIER350_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER350!=null?IDENTIFIER350.getText():null)).append(" = "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command3501);
                    expr351=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr351.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:489:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AstPrinter.nested_op_return nested_op() throws RecognitionException {
        AstPrinter.nested_op_return retval = new AstPrinter.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_proj_return nested_proj352 =null;

        AstPrinter.nested_filter_return nested_filter353 =null;

        AstPrinter.nested_sort_return nested_sort354 =null;

        AstPrinter.nested_distinct_return nested_distinct355 =null;

        AstPrinter.nested_limit_return nested_limit356 =null;

        AstPrinter.nested_cross_return nested_cross357 =null;

        AstPrinter.nested_foreach_return nested_foreach358 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:489:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt104=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt104=1;
                }
                break;
            case FILTER:
                {
                alt104=2;
                }
                break;
            case ORDER:
                {
                alt104=3;
                }
                break;
            case DISTINCT:
                {
                alt104=4;
                }
                break;
            case LIMIT:
                {
                alt104=5;
                }
                break;
            case CROSS:
                {
                alt104=6;
                }
                break;
            case FOREACH:
                {
                alt104=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;

            }

            switch (alt104) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:489:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op3512);
                    nested_proj352=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj352.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:490:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op3526);
                    nested_filter353=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter353.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:491:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op3540);
                    nested_sort354=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort354.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:492:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op3554);
                    nested_distinct355=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct355.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:493:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op3568);
                    nested_limit356=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit356.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:494:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op3582);
                    nested_cross357=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross357.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:495:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op3596);
                    nested_foreach358=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach358.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:498:1: nested_proj : ^( NESTED_PROJ col_ref col_ref ( col_ref )* ) ;
    public final AstPrinter.nested_proj_return nested_proj() throws RecognitionException {
        AstPrinter.nested_proj_return retval = new AstPrinter.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ359=null;
        AstPrinter.col_ref_return col_ref360 =null;

        AstPrinter.col_ref_return col_ref361 =null;

        AstPrinter.col_ref_return col_ref362 =null;


        CommonTree NESTED_PROJ359_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:499:5: ( ^( NESTED_PROJ col_ref col_ref ( col_ref )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:499:7: ^( NESTED_PROJ col_ref col_ref ( col_ref )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ359=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj3611); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ359_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ359);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ359_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj3613);
            col_ref360=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref360.getTree());


            if ( state.backtracking==0 ) { sb.append(".("); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj3617);
            col_ref361=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref361.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:499:59: ( col_ref )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==CUBE||LA105_0==DOLLARVAR||LA105_0==GROUP||LA105_0==IDENTIFIER) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:499:61: col_ref
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj3623);
            	    col_ref362=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref362.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop105;
                }
            } while (true);


            if ( state.backtracking==0 ) { sb.append(")"); }

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
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:502:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AstPrinter.nested_filter_return nested_filter() throws RecognitionException {
        AstPrinter.nested_filter_return retval = new AstPrinter.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER363=null;
        AstPrinter.nested_op_input_return nested_op_input364 =null;

        AstPrinter.cond_return cond365 =null;


        CommonTree FILTER363_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:503:5: ( ^( FILTER nested_op_input cond ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:503:7: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER363=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter3644); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER363_tree = (CommonTree)adaptor.dupNode(FILTER363);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER363_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FILTER363!=null?FILTER363.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter3648);
            nested_op_input364=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input364.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter3652);
            cond365=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond365.getTree());


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
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:506:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AstPrinter.nested_sort_return nested_sort() throws RecognitionException {
        AstPrinter.nested_sort_return retval = new AstPrinter.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER366=null;
        AstPrinter.nested_op_input_return nested_op_input367 =null;

        AstPrinter.order_by_clause_return order_by_clause368 =null;

        AstPrinter.func_clause_return func_clause369 =null;


        CommonTree ORDER366_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:507:5: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:507:7: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER366=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort3669); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER366_tree = (CommonTree)adaptor.dupNode(ORDER366);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER366_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((ORDER366!=null?ORDER366.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort3673);
            nested_op_input367=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input367.getTree());


            if ( state.backtracking==0 ) { sb.append(" BY "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort3685);
            order_by_clause368=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause368.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:508:48: ( func_clause )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==FUNC||LA106_0==FUNC_REF) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:508:50: func_clause
                    {
                    if ( state.backtracking==0 ) { sb.append(" USING "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort3691);
                    func_clause369=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause369.getTree());


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
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:511:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AstPrinter.nested_distinct_return nested_distinct() throws RecognitionException {
        AstPrinter.nested_distinct_return retval = new AstPrinter.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT370=null;
        AstPrinter.nested_op_input_return nested_op_input371 =null;


        CommonTree DISTINCT370_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:512:5: ( ^( DISTINCT nested_op_input ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:512:7: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT370=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct3710); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT370_tree = (CommonTree)adaptor.dupNode(DISTINCT370);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT370_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((DISTINCT370!=null?DISTINCT370.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct3715);
            nested_op_input371=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input371.getTree());


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
    // $ANTLR end "nested_distinct"


    public static class nested_limit_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:515:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AstPrinter.nested_limit_return nested_limit() throws RecognitionException {
        AstPrinter.nested_limit_return retval = new AstPrinter.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT372=null;
        CommonTree INTEGER374=null;
        AstPrinter.nested_op_input_return nested_op_input373 =null;

        AstPrinter.expr_return expr375 =null;


        CommonTree LIMIT372_tree=null;
        CommonTree INTEGER374_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:516:5: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:516:7: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT372=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit3732); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT372_tree = (CommonTree)adaptor.dupNode(LIMIT372);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT372_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((LIMIT372!=null?LIMIT372.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit3737);
            nested_op_input373=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input373.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:516:73: ( INTEGER | expr )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==INTEGER) ) {
                int LA107_1 = input.LA(2);

                if ( (synpred179_AstPrinter()) ) {
                    alt107=1;
                }
                else if ( (true) ) {
                    alt107=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 107, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA107_0==BIGDECIMALNUMBER||LA107_0==BIGINTEGERNUMBER||LA107_0==CUBE||LA107_0==DIV||LA107_0==DOLLARVAR||LA107_0==DOUBLENUMBER||LA107_0==FALSE||LA107_0==FLOATNUMBER||LA107_0==GROUP||LA107_0==IDENTIFIER||LA107_0==LONGINTEGER||LA107_0==MINUS||LA107_0==NULL||LA107_0==PERCENT||LA107_0==PLUS||LA107_0==QUOTEDSTRING||LA107_0==STAR||LA107_0==TRUE||(LA107_0 >= BAG_VAL && LA107_0 <= BIN_EXPR)||(LA107_0 >= CASE_COND && LA107_0 <= CAST_EXPR)||LA107_0==EXPR_IN_PAREN||LA107_0==FUNC_EVAL||(LA107_0 >= MAP_VAL && LA107_0 <= NEG)||LA107_0==TUPLE_VAL) ) {
                alt107=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;

            }
            switch (alt107) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:516:75: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER374=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit3741); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER374_tree = (CommonTree)adaptor.dupNode(INTEGER374);


                    adaptor.addChild(root_1, INTEGER374_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((INTEGER374!=null?INTEGER374.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:516:127: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit3747);
                    expr375=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr375.getTree());


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
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:519:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AstPrinter.nested_cross_return nested_cross() throws RecognitionException {
        AstPrinter.nested_cross_return retval = new AstPrinter.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS376=null;
        AstPrinter.nested_op_input_list_return nested_op_input_list377 =null;


        CommonTree CROSS376_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:520:5: ( ^( CROSS nested_op_input_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:520:7: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS376=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross3766); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS376_tree = (CommonTree)adaptor.dupNode(CROSS376);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS376_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((CROSS376!=null?CROSS376.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross3771);
            nested_op_input_list377=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list377.getTree());


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
    // $ANTLR end "nested_cross"


    public static class nested_foreach_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:523:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AstPrinter.nested_foreach_return nested_foreach() throws RecognitionException {
        AstPrinter.nested_foreach_return retval = new AstPrinter.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH378=null;
        AstPrinter.nested_op_input_return nested_op_input379 =null;

        AstPrinter.generate_clause_return generate_clause380 =null;


        CommonTree FOREACH378_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:524:2: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:524:4: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH378=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach3785); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH378_tree = (CommonTree)adaptor.dupNode(FOREACH378);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH378_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((FOREACH378!=null?FOREACH378.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach3790);
            nested_op_input379=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input379.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach3792);
            generate_clause380=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause380.getTree());


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
    // $ANTLR end "nested_foreach"


    public static class nested_op_input_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:527:1: nested_op_input : ( col_ref | nested_proj );
    public final AstPrinter.nested_op_input_return nested_op_input() throws RecognitionException {
        AstPrinter.nested_op_input_return retval = new AstPrinter.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.col_ref_return col_ref381 =null;

        AstPrinter.nested_proj_return nested_proj382 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:527:17: ( col_ref | nested_proj )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==CUBE||LA108_0==DOLLARVAR||LA108_0==GROUP||LA108_0==IDENTIFIER) ) {
                alt108=1;
            }
            else if ( (LA108_0==NESTED_PROJ) ) {
                alt108=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;

            }
            switch (alt108) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:527:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input3803);
                    col_ref381=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref381.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:527:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input3807);
                    nested_proj382=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj382.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:530:1: nested_op_input_list : nested_op_input ( nested_op_input )* ;
    public final AstPrinter.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AstPrinter.nested_op_input_list_return retval = new AstPrinter.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.nested_op_input_return nested_op_input383 =null;

        AstPrinter.nested_op_input_return nested_op_input384 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:531:5: ( nested_op_input ( nested_op_input )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:531:7: nested_op_input ( nested_op_input )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list3820);
            nested_op_input383=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, nested_op_input383.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:531:23: ( nested_op_input )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==CUBE||LA109_0==DOLLARVAR||LA109_0==GROUP||LA109_0==IDENTIFIER||LA109_0==NESTED_PROJ) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:531:25: nested_op_input
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list3826);
            	    nested_op_input384=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input384.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop109;
                }
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:534:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AstPrinter.stream_clause_return stream_clause() throws RecognitionException {
        AstPrinter.stream_clause_return retval = new AstPrinter.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM385=null;
        CommonTree EXECCOMMAND387=null;
        CommonTree IDENTIFIER388=null;
        AstPrinter.rel_return rel386 =null;

        AstPrinter.as_clause_return as_clause389 =null;


        CommonTree STREAM385_tree=null;
        CommonTree EXECCOMMAND387_tree=null;
        CommonTree IDENTIFIER388_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:535:5: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:535:7: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM385=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause3843); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM385_tree = (CommonTree)adaptor.dupNode(STREAM385);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM385_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((STREAM385!=null?STREAM385.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause3847);
            rel386=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel386.getTree());


            if ( state.backtracking==0 ) { sb.append(" THROUGH "); }

            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:536:9: ( EXECCOMMAND | IDENTIFIER )
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==EXECCOMMAND) ) {
                alt110=1;
            }
            else if ( (LA110_0==IDENTIFIER) ) {
                alt110=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;

            }
            switch (alt110) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:536:11: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND387=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause3861); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND387_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND387);


                    adaptor.addChild(root_1, EXECCOMMAND387_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((EXECCOMMAND387!=null?EXECCOMMAND387.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:537:11: IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER388=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stream_clause3875); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER388_tree = (CommonTree)adaptor.dupNode(IDENTIFIER388);


                    adaptor.addChild(root_1, IDENTIFIER388_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER388!=null?IDENTIFIER388.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:537:57: ( as_clause )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==AS) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:537:57: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause3881);
                    as_clause389=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause389.getTree());


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
    // $ANTLR end "stream_clause"


    public static class mr_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:540:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AstPrinter.mr_clause_return mr_clause() throws RecognitionException {
        AstPrinter.mr_clause_return retval = new AstPrinter.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE390=null;
        CommonTree QUOTEDSTRING391=null;
        CommonTree EXECCOMMAND395=null;
        AstPrinter.path_list_return path_list392 =null;

        AstPrinter.store_clause_return store_clause393 =null;

        AstPrinter.load_clause_return load_clause394 =null;


        CommonTree MAPREDUCE390_tree=null;
        CommonTree QUOTEDSTRING391_tree=null;
        CommonTree EXECCOMMAND395_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:541:5: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:541:7: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE390=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause3899); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE390_tree = (CommonTree)adaptor.dupNode(MAPREDUCE390);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE390_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING391=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause3901); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING391_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING391);


            adaptor.addChild(root_1, QUOTEDSTRING391_tree);
            }


            if ( state.backtracking==0 ) { sb.append((MAPREDUCE390!=null?MAPREDUCE390.getText():null)).append(" ").append((QUOTEDSTRING391!=null?QUOTEDSTRING391.getText():null)).append(" "); }

            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:542:9: ( path_list )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==QUOTEDSTRING) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:542:10: path_list
                    {
                    if ( state.backtracking==0 ) { sb.append(" ("); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause3916);
                    path_list392=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list392.getTree());


                    if ( state.backtracking==0 ) { sb.append(") "); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause3923);
            store_clause393=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause393.getTree());


            if ( state.backtracking==0 ) { sb.append(" "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause3927);
            load_clause394=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause394.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:543:9: ( EXECCOMMAND )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==EXECCOMMAND) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:543:10: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND395=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause3938); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND395_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND395);


                    adaptor.addChild(root_1, EXECCOMMAND395_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append(" ").append((EXECCOMMAND395!=null?EXECCOMMAND395.getText():null)); }

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
    // $ANTLR end "mr_clause"


    public static class split_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:546:1: split_clause : ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? ) ;
    public final AstPrinter.split_clause_return split_clause() throws RecognitionException {
        AstPrinter.split_clause_return retval = new AstPrinter.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT396=null;
        AstPrinter.rel_return rel397 =null;

        AstPrinter.split_branch_return split_branch398 =null;

        AstPrinter.split_branch_return split_branch399 =null;

        AstPrinter.split_otherwise_return split_otherwise400 =null;


        CommonTree SPLIT396_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:547:5: ( ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:547:7: ^( SPLIT rel split_branch ( split_branch )* ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT396=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause3960); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT396_tree = (CommonTree)adaptor.dupNode(SPLIT396);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT396_tree, root_1);
            }


            if ( state.backtracking==0 ) { sb.append((SPLIT396!=null?SPLIT396.getText():null)).append(" "); }

            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause3973);
            rel397=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel397.getTree());


            if ( state.backtracking==0 ) { sb.append(" INTO "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_branch_in_split_clause3977);
            split_branch398=split_branch();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, split_branch398.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:548:51: ( split_branch )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==SPLIT_BRANCH) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:548:53: split_branch
            	    {
            	    if ( state.backtracking==0 ) { sb.append(", "); }

            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause3983);
            	    split_branch399=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch399.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop114;
                }
            } while (true);


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:548:90: ( split_otherwise )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==OTHERWISE) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:548:92: split_otherwise
                    {
                    if ( state.backtracking==0 ) { sb.append(", "); }

                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause3992);
                    split_otherwise400=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise400.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:551:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AstPrinter.split_branch_return split_branch() throws RecognitionException {
        AstPrinter.split_branch_return retval = new AstPrinter.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH401=null;
        AstPrinter.alias_return alias402 =null;

        AstPrinter.cond_return cond403 =null;


        CommonTree SPLIT_BRANCH401_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:552:5: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:552:7: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH401=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch4012); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH401_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH401);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH401_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch4014);
            alias402=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias402.getTree());


            if ( state.backtracking==0 ) { sb.append(" IF "); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch4018);
            cond403=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond403.getTree());


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
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:555:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AstPrinter.split_otherwise_return split_otherwise() throws RecognitionException {
        AstPrinter.split_otherwise_return retval = new AstPrinter.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE404=null;
        AstPrinter.alias_return alias405 =null;


        CommonTree OTHERWISE404_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:556:5: ( ^( OTHERWISE alias ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:556:7: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE404=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise4035); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE404_tree = (CommonTree)adaptor.dupNode(OTHERWISE404);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE404_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise4037);
            alias405=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias405.getTree());


            if ( state.backtracking==0 ) { sb.append(" " + (OTHERWISE404!=null?OTHERWISE404.getText():null)); }

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
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:559:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AstPrinter.col_ref_return col_ref() throws RecognitionException {
        AstPrinter.col_ref_return retval = new AstPrinter.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.alias_col_ref_return alias_col_ref406 =null;

        AstPrinter.dollar_col_ref_return dollar_col_ref407 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:559:9: ( alias_col_ref | dollar_col_ref )
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==CUBE||LA116_0==GROUP||LA116_0==IDENTIFIER) ) {
                alt116=1;
            }
            else if ( (LA116_0==DOLLARVAR) ) {
                alt116=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;

            }
            switch (alt116) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:559:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref4050);
                    alias_col_ref406=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref406.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:559:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref4054);
                    dollar_col_ref407=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref407.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:562:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AstPrinter.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AstPrinter.alias_col_ref_return retval = new AstPrinter.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP408=null;
        CommonTree CUBE409=null;
        CommonTree IDENTIFIER410=null;

        CommonTree GROUP408_tree=null;
        CommonTree CUBE409_tree=null;
        CommonTree IDENTIFIER410_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:563:5: ( GROUP | CUBE | IDENTIFIER )
            int alt117=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt117=1;
                }
                break;
            case CUBE:
                {
                alt117=2;
                }
                break;
            case IDENTIFIER:
                {
                alt117=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;

            }

            switch (alt117) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:563:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP408=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref4067); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP408_tree = (CommonTree)adaptor.dupNode(GROUP408);


                    adaptor.addChild(root_0, GROUP408_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP408!=null?GROUP408.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:564:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE409=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref4077); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE409_tree = (CommonTree)adaptor.dupNode(CUBE409);


                    adaptor.addChild(root_0, CUBE409_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE409!=null?CUBE409.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:565:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER410=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref4087); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER410_tree = (CommonTree)adaptor.dupNode(IDENTIFIER410);


                    adaptor.addChild(root_0, IDENTIFIER410_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER410!=null?IDENTIFIER410.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:568:1: dollar_col_ref : DOLLARVAR ;
    public final AstPrinter.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AstPrinter.dollar_col_ref_return retval = new AstPrinter.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR411=null;

        CommonTree DOLLARVAR411_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:569:5: ( DOLLARVAR )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:569:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR411=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref4102); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR411_tree = (CommonTree)adaptor.dupNode(DOLLARVAR411);


            adaptor.addChild(root_0, DOLLARVAR411_tree);
            }


            if ( state.backtracking==0 ) { sb.append((DOLLARVAR411!=null?DOLLARVAR411.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:572:1: const_expr : literal ;
    public final AstPrinter.const_expr_return const_expr() throws RecognitionException {
        AstPrinter.const_expr_return retval = new AstPrinter.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.literal_return literal412 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:572:12: ( literal )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:572:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr4113);
            literal412=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal412.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:575:1: literal : ( scalar | map | bag | tuple );
    public final AstPrinter.literal_return literal() throws RecognitionException {
        AstPrinter.literal_return retval = new AstPrinter.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstPrinter.scalar_return scalar413 =null;

        AstPrinter.map_return map414 =null;

        AstPrinter.bag_return bag415 =null;

        AstPrinter.tuple_return tuple416 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:575:9: ( scalar | map | bag | tuple )
            int alt118=4;
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
                alt118=1;
                }
                break;
            case MAP_VAL:
                {
                alt118=2;
                }
                break;
            case BAG_VAL:
                {
                alt118=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt118=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;

            }

            switch (alt118) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:575:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal4122);
                    scalar413=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar413.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:575:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal4126);
                    map414=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map414.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:575:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal4130);
                    bag415=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag415.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:575:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal4134);
                    tuple416=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple416.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:578:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AstPrinter.scalar_return scalar() throws RecognitionException {
        AstPrinter.scalar_return retval = new AstPrinter.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING418=null;
        CommonTree NULL419=null;
        CommonTree TRUE420=null;
        CommonTree FALSE421=null;
        AstPrinter.num_scalar_return num_scalar417 =null;


        CommonTree QUOTEDSTRING418_tree=null;
        CommonTree NULL419_tree=null;
        CommonTree TRUE420_tree=null;
        CommonTree FALSE421_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:578:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt119=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt119=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt119=2;
                }
                break;
            case NULL:
                {
                alt119=3;
                }
                break;
            case TRUE:
                {
                alt119=4;
                }
                break;
            case FALSE:
                {
                alt119=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;

            }

            switch (alt119) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:578:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar4143);
                    num_scalar417=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar417.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:579:10: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING418=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar4154); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING418_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING418);


                    adaptor.addChild(root_0, QUOTEDSTRING418_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING418!=null?QUOTEDSTRING418.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:580:10: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL419=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar4167); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL419_tree = (CommonTree)adaptor.dupNode(NULL419);


                    adaptor.addChild(root_0, NULL419_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL419!=null?NULL419.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:581:10: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE420=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar4180); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE420_tree = (CommonTree)adaptor.dupNode(TRUE420);


                    adaptor.addChild(root_0, TRUE420_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TRUE420!=null?TRUE420.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:582:10: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE421=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar4193); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE421_tree = (CommonTree)adaptor.dupNode(FALSE421);


                    adaptor.addChild(root_0, FALSE421_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FALSE421!=null?FALSE421.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:585:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final AstPrinter.num_scalar_return num_scalar() throws RecognitionException {
        AstPrinter.num_scalar_return retval = new AstPrinter.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS422=null;
        CommonTree INTEGER423=null;
        CommonTree LONGINTEGER424=null;
        CommonTree FLOATNUMBER425=null;
        CommonTree DOUBLENUMBER426=null;
        CommonTree BIGINTEGERNUMBER427=null;
        CommonTree BIGDECIMALNUMBER428=null;

        CommonTree MINUS422_tree=null;
        CommonTree INTEGER423_tree=null;
        CommonTree LONGINTEGER424_tree=null;
        CommonTree FLOATNUMBER425_tree=null;
        CommonTree DOUBLENUMBER426_tree=null;
        CommonTree BIGINTEGERNUMBER427_tree=null;
        CommonTree BIGDECIMALNUMBER428_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:585:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:585:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:585:14: ( MINUS )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==MINUS) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:585:16: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS422=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar4206); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS422_tree = (CommonTree)adaptor.dupNode(MINUS422);


                    adaptor.addChild(root_0, MINUS422_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append( "-" ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:586:14: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            int alt121=6;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt121=1;
                }
                break;
            case LONGINTEGER:
                {
                alt121=2;
                }
                break;
            case FLOATNUMBER:
                {
                alt121=3;
                }
                break;
            case DOUBLENUMBER:
                {
                alt121=4;
                }
                break;
            case BIGINTEGERNUMBER:
                {
                alt121=5;
                }
                break;
            case BIGDECIMALNUMBER:
                {
                alt121=6;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:586:16: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER423=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_num_scalar4228); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER423_tree = (CommonTree)adaptor.dupNode(INTEGER423);


                    adaptor.addChild(root_0, INTEGER423_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INTEGER423!=null?INTEGER423.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:587:16: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER424=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_num_scalar4247); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER424_tree = (CommonTree)adaptor.dupNode(LONGINTEGER424);


                    adaptor.addChild(root_0, LONGINTEGER424_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONGINTEGER424!=null?LONGINTEGER424.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:588:16: FLOATNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    FLOATNUMBER425=(CommonTree)match(input,FLOATNUMBER,FOLLOW_FLOATNUMBER_in_num_scalar4266); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOATNUMBER425_tree = (CommonTree)adaptor.dupNode(FLOATNUMBER425);


                    adaptor.addChild(root_0, FLOATNUMBER425_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOATNUMBER425!=null?FLOATNUMBER425.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:589:16: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER426=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_num_scalar4285); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER426_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER426);


                    adaptor.addChild(root_0, DOUBLENUMBER426_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLENUMBER426!=null?DOUBLENUMBER426.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:590:16: BIGINTEGERNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGINTEGERNUMBER427=(CommonTree)match(input,BIGINTEGERNUMBER,FOLLOW_BIGINTEGERNUMBER_in_num_scalar4304); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGERNUMBER427_tree = (CommonTree)adaptor.dupNode(BIGINTEGERNUMBER427);


                    adaptor.addChild(root_0, BIGINTEGERNUMBER427_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGINTEGERNUMBER427!=null?BIGINTEGERNUMBER427.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:591:16: BIGDECIMALNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGDECIMALNUMBER428=(CommonTree)match(input,BIGDECIMALNUMBER,FOLLOW_BIGDECIMALNUMBER_in_num_scalar4323); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMALNUMBER428_tree = (CommonTree)adaptor.dupNode(BIGDECIMALNUMBER428);


                    adaptor.addChild(root_0, BIGDECIMALNUMBER428_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGDECIMALNUMBER428!=null?BIGDECIMALNUMBER428.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:595:1: map : ( ^( MAP_VAL keyvalue ( keyvalue )* ) | ^( MAP_VAL ) );
    public final AstPrinter.map_return map() throws RecognitionException {
        AstPrinter.map_return retval = new AstPrinter.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL429=null;
        CommonTree MAP_VAL432=null;
        AstPrinter.keyvalue_return keyvalue430 =null;

        AstPrinter.keyvalue_return keyvalue431 =null;


        CommonTree MAP_VAL429_tree=null;
        CommonTree MAP_VAL432_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:596:5: ( ^( MAP_VAL keyvalue ( keyvalue )* ) | ^( MAP_VAL ) )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==MAP_VAL) ) {
                int LA123_1 = input.LA(2);

                if ( (LA123_1==DOWN) ) {
                    int LA123_2 = input.LA(3);

                    if ( (LA123_2==KEY_VAL_PAIR) ) {
                        alt123=1;
                    }
                    else if ( (LA123_2==UP) ) {
                        alt123=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 123, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 123, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;

            }
            switch (alt123) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:596:7: ^( MAP_VAL keyvalue ( keyvalue )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MAP_VAL429=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map4355); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP_VAL429_tree = (CommonTree)adaptor.dupNode(MAP_VAL429);


                    root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL429_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("["); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_keyvalue_in_map4359);
                    keyvalue430=keyvalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, keyvalue430.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:596:47: ( keyvalue )*
                    loop122:
                    do {
                        int alt122=2;
                        int LA122_0 = input.LA(1);

                        if ( (LA122_0==KEY_VAL_PAIR) ) {
                            alt122=1;
                        }


                        switch (alt122) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:596:49: keyvalue
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_keyvalue_in_map4365);
                    	    keyvalue431=keyvalue();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, keyvalue431.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop122;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append("]"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:597:7: ^( MAP_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MAP_VAL432=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map4381); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP_VAL432_tree = (CommonTree)adaptor.dupNode(MAP_VAL432);


                    root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL432_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("[]"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:600:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AstPrinter.keyvalue_return keyvalue() throws RecognitionException {
        AstPrinter.keyvalue_return retval = new AstPrinter.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR433=null;
        AstPrinter.map_key_return map_key434 =null;

        AstPrinter.const_expr_return const_expr435 =null;


        CommonTree KEY_VAL_PAIR433_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:601:5: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:601:7: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR433=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue4400); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR433_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR433);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR433_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue4402);
            map_key434=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key434.getTree());


            if ( state.backtracking==0 ) { sb.append("#"); }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue4406);
            const_expr435=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr435.getTree());


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
    // $ANTLR end "keyvalue"


    public static class map_key_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:604:1: map_key : QUOTEDSTRING ;
    public final AstPrinter.map_key_return map_key() throws RecognitionException {
        AstPrinter.map_key_return retval = new AstPrinter.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING436=null;

        CommonTree QUOTEDSTRING436_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:604:9: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:604:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING436=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key4417); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING436_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING436);


            adaptor.addChild(root_0, QUOTEDSTRING436_tree);
            }


            if ( state.backtracking==0 ) { sb.append((QUOTEDSTRING436!=null?QUOTEDSTRING436.getText():null)); }

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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:607:1: bag : ( ^( BAG_VAL tuple ( tuple )* ) | ^( BAG_VAL ) );
    public final AstPrinter.bag_return bag() throws RecognitionException {
        AstPrinter.bag_return retval = new AstPrinter.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL437=null;
        CommonTree BAG_VAL440=null;
        AstPrinter.tuple_return tuple438 =null;

        AstPrinter.tuple_return tuple439 =null;


        CommonTree BAG_VAL437_tree=null;
        CommonTree BAG_VAL440_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:608:5: ( ^( BAG_VAL tuple ( tuple )* ) | ^( BAG_VAL ) )
            int alt125=2;
            int LA125_0 = input.LA(1);

            if ( (LA125_0==BAG_VAL) ) {
                int LA125_1 = input.LA(2);

                if ( (LA125_1==DOWN) ) {
                    int LA125_2 = input.LA(3);

                    if ( (LA125_2==TUPLE_VAL) ) {
                        alt125=1;
                    }
                    else if ( (LA125_2==UP) ) {
                        alt125=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 125, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 125, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;

            }
            switch (alt125) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:608:7: ^( BAG_VAL tuple ( tuple )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BAG_VAL437=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag4434); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG_VAL437_tree = (CommonTree)adaptor.dupNode(BAG_VAL437);


                    root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL437_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("{"); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_bag4438);
                    tuple438=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, tuple438.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:608:44: ( tuple )*
                    loop124:
                    do {
                        int alt124=2;
                        int LA124_0 = input.LA(1);

                        if ( (LA124_0==TUPLE_VAL) ) {
                            alt124=1;
                        }


                        switch (alt124) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:608:46: tuple
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_tuple_in_bag4444);
                    	    tuple439=tuple();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, tuple439.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop124;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append("}"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:609:7: ^( BAG_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BAG_VAL440=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag4460); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG_VAL440_tree = (CommonTree)adaptor.dupNode(BAG_VAL440);


                    root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL440_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("{}"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:612:1: tuple : ( ^( TUPLE_VAL literal ( literal )* ) | ^( TUPLE_VAL ) );
    public final AstPrinter.tuple_return tuple() throws RecognitionException {
        AstPrinter.tuple_return retval = new AstPrinter.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL441=null;
        CommonTree TUPLE_VAL444=null;
        AstPrinter.literal_return literal442 =null;

        AstPrinter.literal_return literal443 =null;


        CommonTree TUPLE_VAL441_tree=null;
        CommonTree TUPLE_VAL444_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:613:5: ( ^( TUPLE_VAL literal ( literal )* ) | ^( TUPLE_VAL ) )
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==TUPLE_VAL) ) {
                int LA127_1 = input.LA(2);

                if ( (LA127_1==DOWN) ) {
                    int LA127_2 = input.LA(3);

                    if ( (LA127_2==BIGDECIMALNUMBER||LA127_2==BIGINTEGERNUMBER||LA127_2==DOUBLENUMBER||LA127_2==FALSE||LA127_2==FLOATNUMBER||LA127_2==INTEGER||LA127_2==LONGINTEGER||LA127_2==MINUS||LA127_2==NULL||LA127_2==QUOTEDSTRING||LA127_2==TRUE||LA127_2==BAG_VAL||LA127_2==MAP_VAL||LA127_2==TUPLE_VAL) ) {
                        alt127=1;
                    }
                    else if ( (LA127_2==UP) ) {
                        alt127=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 127, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 127, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;

            }
            switch (alt127) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:613:7: ^( TUPLE_VAL literal ( literal )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_VAL441=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple4479); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_VAL441_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL441);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL441_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("("); }

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_literal_in_tuple4483);
                    literal442=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, literal442.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:613:48: ( literal )*
                    loop126:
                    do {
                        int alt126=2;
                        int LA126_0 = input.LA(1);

                        if ( (LA126_0==BIGDECIMALNUMBER||LA126_0==BIGINTEGERNUMBER||LA126_0==DOUBLENUMBER||LA126_0==FALSE||LA126_0==FLOATNUMBER||LA126_0==INTEGER||LA126_0==LONGINTEGER||LA126_0==MINUS||LA126_0==NULL||LA126_0==QUOTEDSTRING||LA126_0==TRUE||LA126_0==BAG_VAL||LA126_0==MAP_VAL||LA126_0==TUPLE_VAL) ) {
                            alt126=1;
                        }


                        switch (alt126) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:613:50: literal
                    	    {
                    	    if ( state.backtracking==0 ) { sb.append(", "); }

                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_literal_in_tuple4490);
                    	    literal443=literal();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, literal443.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop126;
                        }
                    } while (true);


                    if ( state.backtracking==0 ) { sb.append(")"); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:614:7: ^( TUPLE_VAL )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    TUPLE_VAL444=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple4506); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE_VAL444_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL444);


                    root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL444_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { sb.append("()"); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:618:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | IN | CASE );
    public final AstPrinter.eid_return eid() throws RecognitionException {
        AstPrinter.eid_return retval = new AstPrinter.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT446=null;
        CommonTree RETURNS447=null;
        CommonTree DEFINE448=null;
        CommonTree LOAD449=null;
        CommonTree FILTER450=null;
        CommonTree FOREACH451=null;
        CommonTree CUBE452=null;
        CommonTree ROLLUP453=null;
        CommonTree MATCHES454=null;
        CommonTree ORDER455=null;
        CommonTree RANK456=null;
        CommonTree DISTINCT457=null;
        CommonTree COGROUP458=null;
        CommonTree JOIN459=null;
        CommonTree CROSS460=null;
        CommonTree UNION461=null;
        CommonTree SPLIT462=null;
        CommonTree INTO463=null;
        CommonTree IF464=null;
        CommonTree ALL465=null;
        CommonTree AS466=null;
        CommonTree BY467=null;
        CommonTree USING468=null;
        CommonTree INNER469=null;
        CommonTree OUTER470=null;
        CommonTree PARALLEL471=null;
        CommonTree PARTITION472=null;
        CommonTree GROUP473=null;
        CommonTree AND474=null;
        CommonTree OR475=null;
        CommonTree NOT476=null;
        CommonTree GENERATE477=null;
        CommonTree FLATTEN478=null;
        CommonTree EVAL479=null;
        CommonTree ASC480=null;
        CommonTree DESC481=null;
        CommonTree BOOLEAN482=null;
        CommonTree INT483=null;
        CommonTree LONG484=null;
        CommonTree FLOAT485=null;
        CommonTree DOUBLE486=null;
        CommonTree BIGINTEGER487=null;
        CommonTree BIGDECIMAL488=null;
        CommonTree DATETIME489=null;
        CommonTree CHARARRAY490=null;
        CommonTree BYTEARRAY491=null;
        CommonTree BAG492=null;
        CommonTree TUPLE493=null;
        CommonTree MAP494=null;
        CommonTree IS495=null;
        CommonTree NULL496=null;
        CommonTree TRUE497=null;
        CommonTree FALSE498=null;
        CommonTree STREAM499=null;
        CommonTree THROUGH500=null;
        CommonTree STORE501=null;
        CommonTree MAPREDUCE502=null;
        CommonTree SHIP503=null;
        CommonTree CACHE504=null;
        CommonTree INPUT505=null;
        CommonTree OUTPUT506=null;
        CommonTree STDERROR507=null;
        CommonTree STDIN508=null;
        CommonTree STDOUT509=null;
        CommonTree LIMIT510=null;
        CommonTree SAMPLE511=null;
        CommonTree LEFT512=null;
        CommonTree RIGHT513=null;
        CommonTree FULL514=null;
        CommonTree IDENTIFIER515=null;
        CommonTree TOBAG516=null;
        CommonTree TOMAP517=null;
        CommonTree TOTUPLE518=null;
        CommonTree IN519=null;
        CommonTree CASE520=null;
        AstPrinter.rel_str_op_return rel_str_op445 =null;


        CommonTree IMPORT446_tree=null;
        CommonTree RETURNS447_tree=null;
        CommonTree DEFINE448_tree=null;
        CommonTree LOAD449_tree=null;
        CommonTree FILTER450_tree=null;
        CommonTree FOREACH451_tree=null;
        CommonTree CUBE452_tree=null;
        CommonTree ROLLUP453_tree=null;
        CommonTree MATCHES454_tree=null;
        CommonTree ORDER455_tree=null;
        CommonTree RANK456_tree=null;
        CommonTree DISTINCT457_tree=null;
        CommonTree COGROUP458_tree=null;
        CommonTree JOIN459_tree=null;
        CommonTree CROSS460_tree=null;
        CommonTree UNION461_tree=null;
        CommonTree SPLIT462_tree=null;
        CommonTree INTO463_tree=null;
        CommonTree IF464_tree=null;
        CommonTree ALL465_tree=null;
        CommonTree AS466_tree=null;
        CommonTree BY467_tree=null;
        CommonTree USING468_tree=null;
        CommonTree INNER469_tree=null;
        CommonTree OUTER470_tree=null;
        CommonTree PARALLEL471_tree=null;
        CommonTree PARTITION472_tree=null;
        CommonTree GROUP473_tree=null;
        CommonTree AND474_tree=null;
        CommonTree OR475_tree=null;
        CommonTree NOT476_tree=null;
        CommonTree GENERATE477_tree=null;
        CommonTree FLATTEN478_tree=null;
        CommonTree EVAL479_tree=null;
        CommonTree ASC480_tree=null;
        CommonTree DESC481_tree=null;
        CommonTree BOOLEAN482_tree=null;
        CommonTree INT483_tree=null;
        CommonTree LONG484_tree=null;
        CommonTree FLOAT485_tree=null;
        CommonTree DOUBLE486_tree=null;
        CommonTree BIGINTEGER487_tree=null;
        CommonTree BIGDECIMAL488_tree=null;
        CommonTree DATETIME489_tree=null;
        CommonTree CHARARRAY490_tree=null;
        CommonTree BYTEARRAY491_tree=null;
        CommonTree BAG492_tree=null;
        CommonTree TUPLE493_tree=null;
        CommonTree MAP494_tree=null;
        CommonTree IS495_tree=null;
        CommonTree NULL496_tree=null;
        CommonTree TRUE497_tree=null;
        CommonTree FALSE498_tree=null;
        CommonTree STREAM499_tree=null;
        CommonTree THROUGH500_tree=null;
        CommonTree STORE501_tree=null;
        CommonTree MAPREDUCE502_tree=null;
        CommonTree SHIP503_tree=null;
        CommonTree CACHE504_tree=null;
        CommonTree INPUT505_tree=null;
        CommonTree OUTPUT506_tree=null;
        CommonTree STDERROR507_tree=null;
        CommonTree STDIN508_tree=null;
        CommonTree STDOUT509_tree=null;
        CommonTree LIMIT510_tree=null;
        CommonTree SAMPLE511_tree=null;
        CommonTree LEFT512_tree=null;
        CommonTree RIGHT513_tree=null;
        CommonTree FULL514_tree=null;
        CommonTree IDENTIFIER515_tree=null;
        CommonTree TOBAG516_tree=null;
        CommonTree TOMAP517_tree=null;
        CommonTree TOTUPLE518_tree=null;
        CommonTree IN519_tree=null;
        CommonTree CASE520_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:618:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | IN | CASE )
            int alt128=76;
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
            case CUBE:
                {
                alt128=8;
                }
                break;
            case ROLLUP:
                {
                alt128=9;
                }
                break;
            case MATCHES:
                {
                alt128=10;
                }
                break;
            case ORDER:
                {
                alt128=11;
                }
                break;
            case RANK:
                {
                alt128=12;
                }
                break;
            case DISTINCT:
                {
                alt128=13;
                }
                break;
            case COGROUP:
                {
                alt128=14;
                }
                break;
            case JOIN:
                {
                alt128=15;
                }
                break;
            case CROSS:
                {
                alt128=16;
                }
                break;
            case UNION:
                {
                alt128=17;
                }
                break;
            case SPLIT:
                {
                alt128=18;
                }
                break;
            case INTO:
                {
                alt128=19;
                }
                break;
            case IF:
                {
                alt128=20;
                }
                break;
            case ALL:
                {
                alt128=21;
                }
                break;
            case AS:
                {
                alt128=22;
                }
                break;
            case BY:
                {
                alt128=23;
                }
                break;
            case USING:
                {
                alt128=24;
                }
                break;
            case INNER:
                {
                alt128=25;
                }
                break;
            case OUTER:
                {
                alt128=26;
                }
                break;
            case PARALLEL:
                {
                alt128=27;
                }
                break;
            case PARTITION:
                {
                alt128=28;
                }
                break;
            case GROUP:
                {
                alt128=29;
                }
                break;
            case AND:
                {
                alt128=30;
                }
                break;
            case OR:
                {
                alt128=31;
                }
                break;
            case NOT:
                {
                alt128=32;
                }
                break;
            case GENERATE:
                {
                alt128=33;
                }
                break;
            case FLATTEN:
                {
                alt128=34;
                }
                break;
            case EVAL:
                {
                alt128=35;
                }
                break;
            case ASC:
                {
                alt128=36;
                }
                break;
            case DESC:
                {
                alt128=37;
                }
                break;
            case BOOLEAN:
                {
                alt128=38;
                }
                break;
            case INT:
                {
                alt128=39;
                }
                break;
            case LONG:
                {
                alt128=40;
                }
                break;
            case FLOAT:
                {
                alt128=41;
                }
                break;
            case DOUBLE:
                {
                alt128=42;
                }
                break;
            case BIGINTEGER:
                {
                alt128=43;
                }
                break;
            case BIGDECIMAL:
                {
                alt128=44;
                }
                break;
            case DATETIME:
                {
                alt128=45;
                }
                break;
            case CHARARRAY:
                {
                alt128=46;
                }
                break;
            case BYTEARRAY:
                {
                alt128=47;
                }
                break;
            case BAG:
                {
                alt128=48;
                }
                break;
            case TUPLE:
                {
                alt128=49;
                }
                break;
            case MAP:
                {
                alt128=50;
                }
                break;
            case IS:
                {
                alt128=51;
                }
                break;
            case NULL:
                {
                alt128=52;
                }
                break;
            case TRUE:
                {
                alt128=53;
                }
                break;
            case FALSE:
                {
                alt128=54;
                }
                break;
            case STREAM:
                {
                alt128=55;
                }
                break;
            case THROUGH:
                {
                alt128=56;
                }
                break;
            case STORE:
                {
                alt128=57;
                }
                break;
            case MAPREDUCE:
                {
                alt128=58;
                }
                break;
            case SHIP:
                {
                alt128=59;
                }
                break;
            case CACHE:
                {
                alt128=60;
                }
                break;
            case INPUT:
                {
                alt128=61;
                }
                break;
            case OUTPUT:
                {
                alt128=62;
                }
                break;
            case STDERROR:
                {
                alt128=63;
                }
                break;
            case STDIN:
                {
                alt128=64;
                }
                break;
            case STDOUT:
                {
                alt128=65;
                }
                break;
            case LIMIT:
                {
                alt128=66;
                }
                break;
            case SAMPLE:
                {
                alt128=67;
                }
                break;
            case LEFT:
                {
                alt128=68;
                }
                break;
            case RIGHT:
                {
                alt128=69;
                }
                break;
            case FULL:
                {
                alt128=70;
                }
                break;
            case IDENTIFIER:
                {
                alt128=71;
                }
                break;
            case TOBAG:
                {
                alt128=72;
                }
                break;
            case TOMAP:
                {
                alt128=73;
                }
                break;
            case TOTUPLE:
                {
                alt128=74;
                }
                break;
            case IN:
                {
                alt128=75;
                }
                break;
            case CASE:
                {
                alt128=76;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:618:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid4520);
                    rel_str_op445=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op445.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:619:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT446=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid4528); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT446_tree = (CommonTree)adaptor.dupNode(IMPORT446);


                    adaptor.addChild(root_0, IMPORT446_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IMPORT446!=null?IMPORT446.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:620:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS447=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid4541); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS447_tree = (CommonTree)adaptor.dupNode(RETURNS447);


                    adaptor.addChild(root_0, RETURNS447_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RETURNS447!=null?RETURNS447.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:621:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE448=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid4553); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE448_tree = (CommonTree)adaptor.dupNode(DEFINE448);


                    adaptor.addChild(root_0, DEFINE448_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DEFINE448!=null?DEFINE448.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:622:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD449=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid4566); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD449_tree = (CommonTree)adaptor.dupNode(LOAD449);


                    adaptor.addChild(root_0, LOAD449_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LOAD449!=null?LOAD449.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:623:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER450=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid4581); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER450_tree = (CommonTree)adaptor.dupNode(FILTER450);


                    adaptor.addChild(root_0, FILTER450_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FILTER450!=null?FILTER450.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:624:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH451=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid4594); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH451_tree = (CommonTree)adaptor.dupNode(FOREACH451);


                    adaptor.addChild(root_0, FOREACH451_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FOREACH451!=null?FOREACH451.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:625:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE452=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid4606); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE452_tree = (CommonTree)adaptor.dupNode(CUBE452);


                    adaptor.addChild(root_0, CUBE452_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CUBE452!=null?CUBE452.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:626:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP453=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid4621); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP453_tree = (CommonTree)adaptor.dupNode(ROLLUP453);


                    adaptor.addChild(root_0, ROLLUP453_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ROLLUP453!=null?ROLLUP453.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:627:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES454=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid4634); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES454_tree = (CommonTree)adaptor.dupNode(MATCHES454);


                    adaptor.addChild(root_0, MATCHES454_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MATCHES454!=null?MATCHES454.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:628:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER455=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid4646); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER455_tree = (CommonTree)adaptor.dupNode(ORDER455);


                    adaptor.addChild(root_0, ORDER455_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ORDER455!=null?ORDER455.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:629:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK456=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid4660); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK456_tree = (CommonTree)adaptor.dupNode(RANK456);


                    adaptor.addChild(root_0, RANK456_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RANK456!=null?RANK456.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:630:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT457=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid4675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT457_tree = (CommonTree)adaptor.dupNode(DISTINCT457);


                    adaptor.addChild(root_0, DISTINCT457_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DISTINCT457!=null?DISTINCT457.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:631:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP458=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid4686); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP458_tree = (CommonTree)adaptor.dupNode(COGROUP458);


                    adaptor.addChild(root_0, COGROUP458_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((COGROUP458!=null?COGROUP458.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:632:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN459=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid4698); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN459_tree = (CommonTree)adaptor.dupNode(JOIN459);


                    adaptor.addChild(root_0, JOIN459_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((JOIN459!=null?JOIN459.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:633:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS460=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid4713); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS460_tree = (CommonTree)adaptor.dupNode(CROSS460);


                    adaptor.addChild(root_0, CROSS460_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CROSS460!=null?CROSS460.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:634:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION461=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid4727); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION461_tree = (CommonTree)adaptor.dupNode(UNION461);


                    adaptor.addChild(root_0, UNION461_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((UNION461!=null?UNION461.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:635:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT462=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid4741); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT462_tree = (CommonTree)adaptor.dupNode(SPLIT462);


                    adaptor.addChild(root_0, SPLIT462_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SPLIT462!=null?SPLIT462.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:636:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO463=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid4755); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO463_tree = (CommonTree)adaptor.dupNode(INTO463);


                    adaptor.addChild(root_0, INTO463_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INTO463!=null?INTO463.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:637:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF464=(CommonTree)match(input,IF,FOLLOW_IF_in_eid4770); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF464_tree = (CommonTree)adaptor.dupNode(IF464);


                    adaptor.addChild(root_0, IF464_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IF464!=null?IF464.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:638:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL465=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid4787); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL465_tree = (CommonTree)adaptor.dupNode(ALL465);


                    adaptor.addChild(root_0, ALL465_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ALL465!=null?ALL465.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:639:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS466=(CommonTree)match(input,AS,FOLLOW_AS_in_eid4803); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS466_tree = (CommonTree)adaptor.dupNode(AS466);


                    adaptor.addChild(root_0, AS466_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((AS466!=null?AS466.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:640:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY467=(CommonTree)match(input,BY,FOLLOW_BY_in_eid4820); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY467_tree = (CommonTree)adaptor.dupNode(BY467);


                    adaptor.addChild(root_0, BY467_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BY467!=null?BY467.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:641:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING468=(CommonTree)match(input,USING,FOLLOW_USING_in_eid4837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING468_tree = (CommonTree)adaptor.dupNode(USING468);


                    adaptor.addChild(root_0, USING468_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((USING468!=null?USING468.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:642:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER469=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid4851); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER469_tree = (CommonTree)adaptor.dupNode(INNER469);


                    adaptor.addChild(root_0, INNER469_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INNER469!=null?INNER469.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:643:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER470=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid4865); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER470_tree = (CommonTree)adaptor.dupNode(OUTER470);


                    adaptor.addChild(root_0, OUTER470_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OUTER470!=null?OUTER470.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:644:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL471=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid4879); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL471_tree = (CommonTree)adaptor.dupNode(PARALLEL471);


                    adaptor.addChild(root_0, PARALLEL471_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((PARALLEL471!=null?PARALLEL471.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:645:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION472=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid4890); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION472_tree = (CommonTree)adaptor.dupNode(PARTITION472);


                    adaptor.addChild(root_0, PARTITION472_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((PARTITION472!=null?PARTITION472.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:646:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP473=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid4900); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP473_tree = (CommonTree)adaptor.dupNode(GROUP473);


                    adaptor.addChild(root_0, GROUP473_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GROUP473!=null?GROUP473.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:647:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND474=(CommonTree)match(input,AND,FOLLOW_AND_in_eid4914); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND474_tree = (CommonTree)adaptor.dupNode(AND474);


                    adaptor.addChild(root_0, AND474_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((AND474!=null?AND474.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:648:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR475=(CommonTree)match(input,OR,FOLLOW_OR_in_eid4930); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR475_tree = (CommonTree)adaptor.dupNode(OR475);


                    adaptor.addChild(root_0, OR475_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OR475!=null?OR475.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:649:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT476=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid4947); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT476_tree = (CommonTree)adaptor.dupNode(NOT476);


                    adaptor.addChild(root_0, NOT476_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NOT476!=null?NOT476.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:650:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE477=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid4963); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE477_tree = (CommonTree)adaptor.dupNode(GENERATE477);


                    adaptor.addChild(root_0, GENERATE477_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((GENERATE477!=null?GENERATE477.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:651:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN478=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid4974); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN478_tree = (CommonTree)adaptor.dupNode(FLATTEN478);


                    adaptor.addChild(root_0, FLATTEN478_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLATTEN478!=null?FLATTEN478.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:652:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL479=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid4986); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL479_tree = (CommonTree)adaptor.dupNode(EVAL479);


                    adaptor.addChild(root_0, EVAL479_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((EVAL479!=null?EVAL479.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:653:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC480=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid5001); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC480_tree = (CommonTree)adaptor.dupNode(ASC480);


                    adaptor.addChild(root_0, ASC480_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((ASC480!=null?ASC480.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:654:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC481=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid5017); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC481_tree = (CommonTree)adaptor.dupNode(DESC481);


                    adaptor.addChild(root_0, DESC481_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DESC481!=null?DESC481.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:655:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN482=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid5032); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN482_tree = (CommonTree)adaptor.dupNode(BOOLEAN482);


                    adaptor.addChild(root_0, BOOLEAN482_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BOOLEAN482!=null?BOOLEAN482.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:656:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT483=(CommonTree)match(input,INT,FOLLOW_INT_in_eid5044); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT483_tree = (CommonTree)adaptor.dupNode(INT483);


                    adaptor.addChild(root_0, INT483_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INT483!=null?INT483.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:657:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG484=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid5060); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG484_tree = (CommonTree)adaptor.dupNode(LONG484);


                    adaptor.addChild(root_0, LONG484_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LONG484!=null?LONG484.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:658:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT485=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid5075); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT485_tree = (CommonTree)adaptor.dupNode(FLOAT485);


                    adaptor.addChild(root_0, FLOAT485_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FLOAT485!=null?FLOAT485.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:659:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE486=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid5089); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE486_tree = (CommonTree)adaptor.dupNode(DOUBLE486);


                    adaptor.addChild(root_0, DOUBLE486_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DOUBLE486!=null?DOUBLE486.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:660:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER487=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid5102); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER487_tree = (CommonTree)adaptor.dupNode(BIGINTEGER487);


                    adaptor.addChild(root_0, BIGINTEGER487_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGINTEGER487!=null?BIGINTEGER487.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:661:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL488=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid5111); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL488_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL488);


                    adaptor.addChild(root_0, BIGDECIMAL488_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BIGDECIMAL488!=null?BIGDECIMAL488.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:662:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME489=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid5120); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME489_tree = (CommonTree)adaptor.dupNode(DATETIME489);


                    adaptor.addChild(root_0, DATETIME489_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((DATETIME489!=null?DATETIME489.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:663:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY490=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid5131); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY490_tree = (CommonTree)adaptor.dupNode(CHARARRAY490);


                    adaptor.addChild(root_0, CHARARRAY490_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CHARARRAY490!=null?CHARARRAY490.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:664:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY491=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid5141); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY491_tree = (CommonTree)adaptor.dupNode(BYTEARRAY491);


                    adaptor.addChild(root_0, BYTEARRAY491_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BYTEARRAY491!=null?BYTEARRAY491.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:665:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG492=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid5151); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG492_tree = (CommonTree)adaptor.dupNode(BAG492);


                    adaptor.addChild(root_0, BAG492_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((BAG492!=null?BAG492.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:666:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE493=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid5167); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE493_tree = (CommonTree)adaptor.dupNode(TUPLE493);


                    adaptor.addChild(root_0, TUPLE493_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TUPLE493!=null?TUPLE493.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:667:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP494=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid5181); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP494_tree = (CommonTree)adaptor.dupNode(MAP494);


                    adaptor.addChild(root_0, MAP494_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MAP494!=null?MAP494.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:668:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS495=(CommonTree)match(input,IS,FOLLOW_IS_in_eid5197); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS495_tree = (CommonTree)adaptor.dupNode(IS495);


                    adaptor.addChild(root_0, IS495_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IS495!=null?IS495.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:669:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL496=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid5214); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL496_tree = (CommonTree)adaptor.dupNode(NULL496);


                    adaptor.addChild(root_0, NULL496_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((NULL496!=null?NULL496.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:670:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE497=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid5229); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE497_tree = (CommonTree)adaptor.dupNode(TRUE497);


                    adaptor.addChild(root_0, TRUE497_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TRUE497!=null?TRUE497.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:671:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE498=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid5244); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE498_tree = (CommonTree)adaptor.dupNode(FALSE498);


                    adaptor.addChild(root_0, FALSE498_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FALSE498!=null?FALSE498.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:672:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM499=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid5258); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM499_tree = (CommonTree)adaptor.dupNode(STREAM499);


                    adaptor.addChild(root_0, STREAM499_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STREAM499!=null?STREAM499.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:673:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH500=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid5271); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH500_tree = (CommonTree)adaptor.dupNode(THROUGH500);


                    adaptor.addChild(root_0, THROUGH500_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((THROUGH500!=null?THROUGH500.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:674:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE501=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid5283); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE501_tree = (CommonTree)adaptor.dupNode(STORE501);


                    adaptor.addChild(root_0, STORE501_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STORE501!=null?STORE501.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:675:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE502=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid5297); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE502_tree = (CommonTree)adaptor.dupNode(MAPREDUCE502);


                    adaptor.addChild(root_0, MAPREDUCE502_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((MAPREDUCE502!=null?MAPREDUCE502.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:676:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP503=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid5307); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP503_tree = (CommonTree)adaptor.dupNode(SHIP503);


                    adaptor.addChild(root_0, SHIP503_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SHIP503!=null?SHIP503.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:677:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE504=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid5322); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE504_tree = (CommonTree)adaptor.dupNode(CACHE504);


                    adaptor.addChild(root_0, CACHE504_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CACHE504!=null?CACHE504.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:678:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT505=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid5336); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT505_tree = (CommonTree)adaptor.dupNode(INPUT505);


                    adaptor.addChild(root_0, INPUT505_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((INPUT505!=null?INPUT505.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:679:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT506=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid5350); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT506_tree = (CommonTree)adaptor.dupNode(OUTPUT506);


                    adaptor.addChild(root_0, OUTPUT506_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((OUTPUT506!=null?OUTPUT506.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:680:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR507=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid5363); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR507_tree = (CommonTree)adaptor.dupNode(STDERROR507);


                    adaptor.addChild(root_0, STDERROR507_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDERROR507!=null?STDERROR507.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:681:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN508=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid5374); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN508_tree = (CommonTree)adaptor.dupNode(STDIN508);


                    adaptor.addChild(root_0, STDIN508_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDIN508!=null?STDIN508.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:682:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT509=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid5388); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT509_tree = (CommonTree)adaptor.dupNode(STDOUT509);


                    adaptor.addChild(root_0, STDOUT509_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STDOUT509!=null?STDOUT509.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:683:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT510=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid5401); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT510_tree = (CommonTree)adaptor.dupNode(LIMIT510);


                    adaptor.addChild(root_0, LIMIT510_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LIMIT510!=null?LIMIT510.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:684:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE511=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid5415); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE511_tree = (CommonTree)adaptor.dupNode(SAMPLE511);


                    adaptor.addChild(root_0, SAMPLE511_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((SAMPLE511!=null?SAMPLE511.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:685:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT512=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid5428); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT512_tree = (CommonTree)adaptor.dupNode(LEFT512);


                    adaptor.addChild(root_0, LEFT512_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((LEFT512!=null?LEFT512.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:686:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT513=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid5443); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT513_tree = (CommonTree)adaptor.dupNode(RIGHT513);


                    adaptor.addChild(root_0, RIGHT513_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((RIGHT513!=null?RIGHT513.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:687:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL514=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid5457); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL514_tree = (CommonTree)adaptor.dupNode(FULL514);


                    adaptor.addChild(root_0, FULL514_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((FULL514!=null?FULL514.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:688:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER515=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid5472); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER515_tree = (CommonTree)adaptor.dupNode(IDENTIFIER515);


                    adaptor.addChild(root_0, IDENTIFIER515_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IDENTIFIER515!=null?IDENTIFIER515.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:689:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG516=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid5482); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG516_tree = (CommonTree)adaptor.dupNode(TOBAG516);


                    adaptor.addChild(root_0, TOBAG516_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TOBAG516!=null?TOBAG516.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:690:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP517=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid5497); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP517_tree = (CommonTree)adaptor.dupNode(TOMAP517);


                    adaptor.addChild(root_0, TOMAP517_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TOMAP517!=null?TOMAP517.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:691:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE518=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid5512); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE518_tree = (CommonTree)adaptor.dupNode(TOTUPLE518);


                    adaptor.addChild(root_0, TOTUPLE518_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((TOTUPLE518!=null?TOTUPLE518.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 75 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:692:7: IN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IN519=(CommonTree)match(input,IN,FOLLOW_IN_in_eid5525); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IN519_tree = (CommonTree)adaptor.dupNode(IN519);


                    adaptor.addChild(root_0, IN519_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((IN519!=null?IN519.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 76 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:693:7: CASE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CASE520=(CommonTree)match(input,CASE,FOLLOW_CASE_in_eid5543); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CASE520_tree = (CommonTree)adaptor.dupNode(CASE520);


                    adaptor.addChild(root_0, CASE520_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((CASE520!=null?CASE520.getText():null)); }

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
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:697:1: rel_op returns [String result] : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AstPrinter.rel_op_return rel_op() throws RecognitionException {
        AstPrinter.rel_op_return retval = new AstPrinter.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES527=null;
        AstPrinter.rel_op_eq_return rel_op_eq521 =null;

        AstPrinter.rel_op_ne_return rel_op_ne522 =null;

        AstPrinter.rel_op_gt_return rel_op_gt523 =null;

        AstPrinter.rel_op_gte_return rel_op_gte524 =null;

        AstPrinter.rel_op_lt_return rel_op_lt525 =null;

        AstPrinter.rel_op_lte_return rel_op_lte526 =null;


        CommonTree STR_OP_MATCHES527_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:698:5: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:698:7: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op5568);
                    rel_op_eq521=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq521.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_eq521!=null?rel_op_eq521.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:699:7: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op5582);
                    rel_op_ne522=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne522.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_ne522!=null?rel_op_ne522.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:700:7: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op5596);
                    rel_op_gt523=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt523.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_gt523!=null?rel_op_gt523.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:701:7: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op5610);
                    rel_op_gte524=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte524.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_gte524!=null?rel_op_gte524.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:702:7: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op5623);
                    rel_op_lt525=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt525.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_lt525!=null?rel_op_lt525.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:703:7: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op5637);
                    rel_op_lte526=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte526.getTree());


                    if ( state.backtracking==0 ) { retval.result = (rel_op_lte526!=null?rel_op_lte526.result:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:704:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES527=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op5650); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES527_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES527);


                    adaptor.addChild(root_0, STR_OP_MATCHES527_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_MATCHES527!=null?STR_OP_MATCHES527.getText():null); }

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
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_eq"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:707:1: rel_op_eq returns [String result] : ( STR_OP_EQ | NUM_OP_EQ );
    public final AstPrinter.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AstPrinter.rel_op_eq_return retval = new AstPrinter.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ528=null;
        CommonTree NUM_OP_EQ529=null;

        CommonTree STR_OP_EQ528_tree=null;
        CommonTree NUM_OP_EQ529_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:708:5: ( STR_OP_EQ | NUM_OP_EQ )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==STR_OP_EQ) ) {
                alt130=1;
            }
            else if ( (LA130_0==NUM_OP_EQ) ) {
                alt130=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;

            }
            switch (alt130) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:708:7: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ528=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_op_eq5669); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ528_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ528);


                    adaptor.addChild(root_0, STR_OP_EQ528_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_EQ528!=null?STR_OP_EQ528.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:709:7: NUM_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_EQ529=(CommonTree)match(input,NUM_OP_EQ,FOLLOW_NUM_OP_EQ_in_rel_op_eq5679); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_EQ529_tree = (CommonTree)adaptor.dupNode(NUM_OP_EQ529);


                    adaptor.addChild(root_0, NUM_OP_EQ529_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_EQ529!=null?NUM_OP_EQ529.getText():null); }

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
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:712:1: rel_op_ne returns [String result] : ( STR_OP_NE | NUM_OP_NE );
    public final AstPrinter.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AstPrinter.rel_op_ne_return retval = new AstPrinter.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_NE530=null;
        CommonTree NUM_OP_NE531=null;

        CommonTree STR_OP_NE530_tree=null;
        CommonTree NUM_OP_NE531_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:713:5: ( STR_OP_NE | NUM_OP_NE )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==STR_OP_NE) ) {
                alt131=1;
            }
            else if ( (LA131_0==NUM_OP_NE) ) {
                alt131=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;

            }
            switch (alt131) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:713:7: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE530=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_op_ne5697); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE530_tree = (CommonTree)adaptor.dupNode(STR_OP_NE530);


                    adaptor.addChild(root_0, STR_OP_NE530_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_NE530!=null?STR_OP_NE530.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:714:7: NUM_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_NE531=(CommonTree)match(input,NUM_OP_NE,FOLLOW_NUM_OP_NE_in_rel_op_ne5707); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_NE531_tree = (CommonTree)adaptor.dupNode(NUM_OP_NE531);


                    adaptor.addChild(root_0, NUM_OP_NE531_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_NE531!=null?NUM_OP_NE531.getText():null); }

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
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:717:1: rel_op_gt returns [String result] : ( STR_OP_GT | NUM_OP_GT );
    public final AstPrinter.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AstPrinter.rel_op_gt_return retval = new AstPrinter.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_GT532=null;
        CommonTree NUM_OP_GT533=null;

        CommonTree STR_OP_GT532_tree=null;
        CommonTree NUM_OP_GT533_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:718:5: ( STR_OP_GT | NUM_OP_GT )
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==STR_OP_GT) ) {
                alt132=1;
            }
            else if ( (LA132_0==NUM_OP_GT) ) {
                alt132=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;

            }
            switch (alt132) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:718:7: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT532=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_op_gt5725); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT532_tree = (CommonTree)adaptor.dupNode(STR_OP_GT532);


                    adaptor.addChild(root_0, STR_OP_GT532_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_GT532!=null?STR_OP_GT532.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:719:7: NUM_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_GT533=(CommonTree)match(input,NUM_OP_GT,FOLLOW_NUM_OP_GT_in_rel_op_gt5735); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_GT533_tree = (CommonTree)adaptor.dupNode(NUM_OP_GT533);


                    adaptor.addChild(root_0, NUM_OP_GT533_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_GT533!=null?NUM_OP_GT533.getText():null); }

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
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:722:1: rel_op_gte returns [String result] : ( STR_OP_GTE | NUM_OP_GTE );
    public final AstPrinter.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AstPrinter.rel_op_gte_return retval = new AstPrinter.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_GTE534=null;
        CommonTree NUM_OP_GTE535=null;

        CommonTree STR_OP_GTE534_tree=null;
        CommonTree NUM_OP_GTE535_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:723:5: ( STR_OP_GTE | NUM_OP_GTE )
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==STR_OP_GTE) ) {
                alt133=1;
            }
            else if ( (LA133_0==NUM_OP_GTE) ) {
                alt133=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;

            }
            switch (alt133) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:723:7: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE534=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_op_gte5753); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE534_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE534);


                    adaptor.addChild(root_0, STR_OP_GTE534_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_GTE534!=null?STR_OP_GTE534.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:724:7: NUM_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_GTE535=(CommonTree)match(input,NUM_OP_GTE,FOLLOW_NUM_OP_GTE_in_rel_op_gte5763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_GTE535_tree = (CommonTree)adaptor.dupNode(NUM_OP_GTE535);


                    adaptor.addChild(root_0, NUM_OP_GTE535_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_GTE535!=null?NUM_OP_GTE535.getText():null); }

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
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:727:1: rel_op_lt returns [String result] : ( STR_OP_LT | NUM_OP_LT );
    public final AstPrinter.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AstPrinter.rel_op_lt_return retval = new AstPrinter.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_LT536=null;
        CommonTree NUM_OP_LT537=null;

        CommonTree STR_OP_LT536_tree=null;
        CommonTree NUM_OP_LT537_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:728:5: ( STR_OP_LT | NUM_OP_LT )
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==STR_OP_LT) ) {
                alt134=1;
            }
            else if ( (LA134_0==NUM_OP_LT) ) {
                alt134=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;

            }
            switch (alt134) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:728:7: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT536=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_op_lt5781); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT536_tree = (CommonTree)adaptor.dupNode(STR_OP_LT536);


                    adaptor.addChild(root_0, STR_OP_LT536_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_LT536!=null?STR_OP_LT536.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:729:7: NUM_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_LT537=(CommonTree)match(input,NUM_OP_LT,FOLLOW_NUM_OP_LT_in_rel_op_lt5791); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_LT537_tree = (CommonTree)adaptor.dupNode(NUM_OP_LT537);


                    adaptor.addChild(root_0, NUM_OP_LT537_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_LT537!=null?NUM_OP_LT537.getText():null); }

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
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:732:1: rel_op_lte returns [String result] : ( STR_OP_LTE | NUM_OP_LTE );
    public final AstPrinter.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AstPrinter.rel_op_lte_return retval = new AstPrinter.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_LTE538=null;
        CommonTree NUM_OP_LTE539=null;

        CommonTree STR_OP_LTE538_tree=null;
        CommonTree NUM_OP_LTE539_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:733:5: ( STR_OP_LTE | NUM_OP_LTE )
            int alt135=2;
            int LA135_0 = input.LA(1);

            if ( (LA135_0==STR_OP_LTE) ) {
                alt135=1;
            }
            else if ( (LA135_0==NUM_OP_LTE) ) {
                alt135=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;

            }
            switch (alt135) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:733:7: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE538=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_op_lte5809); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE538_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE538);


                    adaptor.addChild(root_0, STR_OP_LTE538_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (STR_OP_LTE538!=null?STR_OP_LTE538.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:734:7: NUM_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NUM_OP_LTE539=(CommonTree)match(input,NUM_OP_LTE,FOLLOW_NUM_OP_LTE_in_rel_op_lte5819); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NUM_OP_LTE539_tree = (CommonTree)adaptor.dupNode(NUM_OP_LTE539);


                    adaptor.addChild(root_0, NUM_OP_LTE539_tree);
                    }


                    if ( state.backtracking==0 ) { retval.result = (NUM_OP_LTE539!=null?NUM_OP_LTE539.getText():null); }

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
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:737:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AstPrinter.rel_str_op_return rel_str_op() throws RecognitionException {
        AstPrinter.rel_str_op_return retval = new AstPrinter.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ540=null;
        CommonTree STR_OP_NE541=null;
        CommonTree STR_OP_GT542=null;
        CommonTree STR_OP_LT543=null;
        CommonTree STR_OP_GTE544=null;
        CommonTree STR_OP_LTE545=null;
        CommonTree STR_OP_MATCHES546=null;

        CommonTree STR_OP_EQ540_tree=null;
        CommonTree STR_OP_NE541_tree=null;
        CommonTree STR_OP_GT542_tree=null;
        CommonTree STR_OP_LT543_tree=null;
        CommonTree STR_OP_GTE544_tree=null;
        CommonTree STR_OP_LTE545_tree=null;
        CommonTree STR_OP_MATCHES546_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:738:5: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            int alt136=7;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
                {
                alt136=1;
                }
                break;
            case STR_OP_NE:
                {
                alt136=2;
                }
                break;
            case STR_OP_GT:
                {
                alt136=3;
                }
                break;
            case STR_OP_LT:
                {
                alt136=4;
                }
                break;
            case STR_OP_GTE:
                {
                alt136=5;
                }
                break;
            case STR_OP_LTE:
                {
                alt136=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt136=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;

            }

            switch (alt136) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:738:7: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ540=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_str_op5834); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ540_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ540);


                    adaptor.addChild(root_0, STR_OP_EQ540_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_EQ540!=null?STR_OP_EQ540.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:739:7: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE541=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_str_op5844); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE541_tree = (CommonTree)adaptor.dupNode(STR_OP_NE541);


                    adaptor.addChild(root_0, STR_OP_NE541_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_NE541!=null?STR_OP_NE541.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:740:7: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT542=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_str_op5854); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT542_tree = (CommonTree)adaptor.dupNode(STR_OP_GT542);


                    adaptor.addChild(root_0, STR_OP_GT542_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_GT542!=null?STR_OP_GT542.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:741:7: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT543=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_str_op5864); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT543_tree = (CommonTree)adaptor.dupNode(STR_OP_LT543);


                    adaptor.addChild(root_0, STR_OP_LT543_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_LT543!=null?STR_OP_LT543.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:742:7: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE544=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_str_op5874); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE544_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE544);


                    adaptor.addChild(root_0, STR_OP_GTE544_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_GTE544!=null?STR_OP_GTE544.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:743:7: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE545=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_str_op5884); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE545_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE545);


                    adaptor.addChild(root_0, STR_OP_LTE545_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_LTE545!=null?STR_OP_LTE545.getText():null)); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:744:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES546=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_str_op5894); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES546_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES546);


                    adaptor.addChild(root_0, STR_OP_MATCHES546_tree);
                    }


                    if ( state.backtracking==0 ) { sb.append((STR_OP_MATCHES546!=null?STR_OP_MATCHES546.getText():null)); }

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

    // $ANTLR start synpred45_AstPrinter
    public final void synpred45_AstPrinter_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:167:7: ( field_def ( field_def )+ )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:167:7: field_def ( field_def )+
        {
        pushFollow(FOLLOW_field_def_in_synpred45_AstPrinter970);
        field_def();

        state._fsp--;
        if (state.failed) return ;

        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:167:37: ( field_def )+
        int cnt141=0;
        loop141:
        do {
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==FIELD_DEF) ) {
                alt141=1;
            }


            switch (alt141) {
        	case 1 :
        	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:167:39: field_def
        	    {
        	    pushFollow(FOLLOW_field_def_in_synpred45_AstPrinter976);
        	    field_def();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt141 >= 1 ) break loop141;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(141, input);
                    throw eee;
            }
            cnt141++;
        } while (true);


        }

    }
    // $ANTLR end synpred45_AstPrinter

    // $ANTLR start synpred101_AstPrinter
    public final void synpred101_AstPrinter_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:304:7: ( ^( MINUS expr expr ) )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:304:7: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred101_AstPrinter2052); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred101_AstPrinter2054);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred101_AstPrinter2058);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred101_AstPrinter

    // $ANTLR start synpred105_AstPrinter
    public final void synpred105_AstPrinter_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:308:7: ( ^( CAST_EXPR type expr ) )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:308:7: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred105_AstPrinter2124); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred105_AstPrinter2128);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred105_AstPrinter2132);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred105_AstPrinter

    // $ANTLR start synpred106_AstPrinter
    public final void synpred106_AstPrinter_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:309:7: ( const_expr )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:309:7: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred106_AstPrinter2142);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred106_AstPrinter

    // $ANTLR start synpred109_AstPrinter
    public final void synpred109_AstPrinter_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:312:7: ( ^( CAST_EXPR type_cast expr ) )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:312:7: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred109_AstPrinter2176); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred109_AstPrinter2180);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred109_AstPrinter2184);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred109_AstPrinter

    // $ANTLR start synpred114_AstPrinter
    public final void synpred114_AstPrinter_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:321:7: ( ^( TUPLE_TYPE_CAST type_cast ( type_cast )* ) )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:321:7: ^( TUPLE_TYPE_CAST type_cast ( type_cast )* )
        {
        match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_synpred114_AstPrinter2244); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred114_AstPrinter2248);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:321:61: ( type_cast )*
        loop145:
        do {
            int alt145=2;
            int LA145_0 = input.LA(1);

            if ( (LA145_0==BIGDECIMAL||LA145_0==BIGINTEGER||LA145_0==BOOLEAN||LA145_0==BYTEARRAY||LA145_0==CHARARRAY||LA145_0==DATETIME||LA145_0==DOUBLE||LA145_0==FLOAT||LA145_0==INT||LA145_0==LONG||LA145_0==BAG_TYPE_CAST||LA145_0==MAP_TYPE||LA145_0==TUPLE_TYPE_CAST) ) {
                alt145=1;
            }


            switch (alt145) {
        	case 1 :
        	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:321:63: type_cast
        	    {
        	    pushFollow(FOLLOW_type_cast_in_synpred114_AstPrinter2254);
        	    type_cast();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop145;
            }
        } while (true);


        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred114_AstPrinter

    // $ANTLR start synpred133_AstPrinter
    public final void synpred133_AstPrinter_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:378:11: ( INTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:378:11: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred133_AstPrinter2681); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred133_AstPrinter

    // $ANTLR start synpred134_AstPrinter
    public final void synpred134_AstPrinter_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:378:63: ( LONGINTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:378:63: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred134_AstPrinter2687); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred134_AstPrinter

    // $ANTLR start synpred135_AstPrinter
    public final void synpred135_AstPrinter_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:382:64: ( DOUBLENUMBER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:382:64: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred135_AstPrinter2720); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred135_AstPrinter

    // $ANTLR start synpred161_AstPrinter
    public final void synpred161_AstPrinter_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:442:7: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:442:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred161_AstPrinter3147);
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


        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:445:16: ( OUTER )?
        int alt148=2;
        int LA148_0 = input.LA(1);

        if ( (LA148_0==OUTER) ) {
            alt148=1;
        }
        switch (alt148) {
            case 1 :
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:445:17: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred161_AstPrinter3209); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred161_AstPrinter3218);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred161_AstPrinter

    // $ANTLR start synpred179_AstPrinter
    public final void synpred179_AstPrinter_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:516:75: ( INTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstPrinter.g:516:75: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred179_AstPrinter3741); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred179_AstPrinter

    // Delegated rules

    public final boolean synpred105_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred161_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred161_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred179_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred179_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred133_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred133_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred134_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred134_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_AstPrinter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_AstPrinter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA54 dfa54 = new DFA54(this);
    static final String DFA54_eotS =
        "\u00ab\uffff";
    static final String DFA54_eofS =
        "\u00ab\uffff";
    static final String DFA54_minS =
        "\1\u009b\1\2\1\4\122\3\2\4\2\uffff\122\3";
    static final String DFA54_maxS =
        "\1\u009b\1\2\1\u00b6\122\u00b4\2\u00b6\2\uffff\122\u00b4";
    static final String DFA54_acceptS =
        "\127\uffff\1\1\1\2\122\uffff";
    static final String DFA54_specialS =
        "\u00ab\uffff}>";
    static final String[] DFA54_transitionS = {
            "\1\1",
            "\1\2",
            "\1\35\1\uffff\1\46\1\uffff\1\36\1\54\1\70\1\64\1\uffff\1\63"+
            "\1\uffff\1\56\1\37\1\67\1\104\1\124\1\66\1\26\2\uffff\1\30\1"+
            "\20\1\65\1\uffff\1\14\1\uffff\1\55\1\uffff\1\25\3\uffff\1\62"+
            "\6\uffff\1\76\1\uffff\1\16\1\52\1\61\2\uffff\1\17\1\116\1\51"+
            "\1\45\1\uffff\1\117\1\34\1\12\1\123\1\41\1\105\1\57\1\uffff"+
            "\1\33\1\uffff\1\73\1\27\1\114\4\uffff\1\112\1\15\1\60\1\uffff"+
            "\1\72\1\102\3\uffff\1\50\1\74\7\uffff\1\47\1\23\1\uffff\1\42"+
            "\1\106\1\43\1\44\6\uffff\1\24\1\13\1\115\3\uffff\1\21\1\113"+
            "\1\uffff\1\103\2\uffff\1\32\1\uffff\1\107\1\110\1\111\1\101"+
            "\1\77\1\3\1\5\1\7\1\6\1\10\1\11\1\4\1\uffff\1\100\1\75\1\71"+
            "\1\31\1\40\50\uffff\1\120\1\121\1\122\3\uffff\1\53\1\22",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\163\1\uffff\1\174\1\uffff\1\164\1\u0082\1\u008e\1\u008a"+
            "\1\uffff\1\u0089\1\uffff\1\u0084\1\165\1\u008d\1\u009a\1\u00aa"+
            "\1\u008c\1\154\2\uffff\1\156\1\146\1\u008b\1\uffff\1\142\1\uffff"+
            "\1\u0083\1\uffff\1\153\3\uffff\1\u0088\6\uffff\1\u0094\1\uffff"+
            "\1\144\1\u0080\1\u0087\2\uffff\1\145\1\u00a4\1\177\1\173\1\uffff"+
            "\1\u00a5\1\162\1\140\1\u00a9\1\167\1\u009b\1\u0085\1\uffff\1"+
            "\161\1\uffff\1\u0091\1\155\1\u00a2\4\uffff\1\u00a0\1\143\1\u0086"+
            "\1\uffff\1\u0090\1\u0098\3\uffff\1\176\1\u0092\7\uffff\1\175"+
            "\1\151\1\uffff\1\170\1\u009c\1\171\1\172\6\uffff\1\152\1\141"+
            "\1\u00a3\3\uffff\1\147\1\u00a1\1\uffff\1\u0099\2\uffff\1\160"+
            "\1\uffff\1\u009d\1\u009e\1\u009f\1\u0097\1\u0095\1\131\1\133"+
            "\1\135\1\134\1\136\1\137\1\132\1\uffff\1\u0096\1\u0093\1\u008f"+
            "\1\157\1\166\50\uffff\1\u00a6\1\u00a7\1\u00a8\3\uffff\1\u0081"+
            "\1\150",
            "\1\163\1\uffff\1\174\1\uffff\1\164\1\u0082\1\u008e\1\u008a"+
            "\1\uffff\1\u0089\1\uffff\1\u0084\1\165\1\u008d\1\u009a\1\u00aa"+
            "\1\u008c\1\154\2\uffff\1\156\1\146\1\u008b\1\uffff\1\142\1\uffff"+
            "\1\u0083\1\uffff\1\153\3\uffff\1\u0088\6\uffff\1\u0094\1\uffff"+
            "\1\144\1\u0080\1\u0087\2\uffff\1\145\1\u00a4\1\177\1\173\1\uffff"+
            "\1\u00a5\1\162\1\140\1\u00a9\1\167\1\u009b\1\u0085\1\uffff\1"+
            "\161\1\uffff\1\u0091\1\155\1\u00a2\4\uffff\1\u00a0\1\143\1\u0086"+
            "\1\uffff\1\u0090\1\u0098\3\uffff\1\176\1\u0092\7\uffff\1\175"+
            "\1\151\1\uffff\1\170\1\u009c\1\171\1\172\6\uffff\1\152\1\141"+
            "\1\u00a3\3\uffff\1\147\1\u00a1\1\uffff\1\u0099\2\uffff\1\160"+
            "\1\uffff\1\u009d\1\u009e\1\u009f\1\u0097\1\u0095\1\131\1\133"+
            "\1\135\1\134\1\136\1\137\1\132\1\uffff\1\u0096\1\u0093\1\u008f"+
            "\1\157\1\166\50\uffff\1\u00a6\1\u00a7\1\u00a8\3\uffff\1\u0081"+
            "\1\150",
            "",
            "",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127",
            "\1\130\10\uffff\1\127\1\uffff\1\127\12\uffff\1\127\7\uffff"+
            "\1\127\1\126\1\127\1\uffff\1\127\5\uffff\1\127\5\uffff\1\127"+
            "\3\uffff\1\127\1\uffff\1\127\6\uffff\1\127\14\uffff\1\127\2"+
            "\uffff\1\127\3\uffff\1\127\16\uffff\1\127\1\125\1\127\2\uffff"+
            "\1\127\15\uffff\1\127\16\uffff\1\127\11\uffff\2\127\2\uffff"+
            "\5\127\5\uffff\1\127\10\uffff\2\127\16\uffff\1\127"
    };

    static final short[] DFA54_eot = DFA.unpackEncodedString(DFA54_eotS);
    static final short[] DFA54_eof = DFA.unpackEncodedString(DFA54_eofS);
    static final char[] DFA54_min = DFA.unpackEncodedStringToUnsignedChars(DFA54_minS);
    static final char[] DFA54_max = DFA.unpackEncodedStringToUnsignedChars(DFA54_maxS);
    static final short[] DFA54_accept = DFA.unpackEncodedString(DFA54_acceptS);
    static final short[] DFA54_special = DFA.unpackEncodedString(DFA54_specialS);
    static final short[][] DFA54_transition;

    static {
        int numStates = DFA54_transitionS.length;
        DFA54_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA54_transition[i] = DFA.unpackEncodedString(DFA54_transitionS[i]);
        }
    }

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = DFA54_eot;
            this.eof = DFA54_eof;
            this.min = DFA54_min;
            this.max = DFA54_max;
            this.accept = DFA54_accept;
            this.special = DFA54_special;
            this.transition = DFA54_transition;
        }
        public String getDescription() {
            return "293:1: func_eval : ( ^( FUNC_EVAL func_name real_arg ( real_arg )* ) | ^( FUNC_EVAL func_name ) );";
        }
    }
 

    public static final BitSet FOLLOW_QUERY_in_query80 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query82 = new BitSet(new long[]{0x0000000000000008L,0x0008000000000000L,0x0000480000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement162 = new BitSet(new long[]{0x0024200113200000L,0x0308408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_op_clause_in_general_statement177 = new BitSet(new long[]{0x0000000000000008L,0x0000000080000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement179 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause194 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause196 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause198 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause216 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause497 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_define_clause499 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause513 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause517 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd536 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd550 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd554 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd558 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd562 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd566 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause590 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list610 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list625 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause649 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause668 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause680 = new BitSet(new long[]{0x0000000000000008L,0x00C0004000000000L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause686 = new BitSet(new long[]{0x0000000000000008L,0x00C0004000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd711 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd724 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd728 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd741 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd745 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause763 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause776 = new BitSet(new long[]{0x0000000000000008L,0x00C0004000000000L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause782 = new BitSet(new long[]{0x0000000000000008L,0x00C0004000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause803 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause817 = new BitSet(new long[]{0x4000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause822 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause849 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause853 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause867 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause871 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause904 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause908 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def925 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def927 = new BitSet(new long[]{0x200080100412A808L,0x0000000000000400L,0x0004000800000800L});
    public static final BitSet FOLLOW_type_in_field_def937 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def951 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def953 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list970 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_field_def_in_field_def_list976 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_field_def_in_field_def_list989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_type_in_type998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1130 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1132 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1150 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1161 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1179 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1183 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1203 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1205 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1217 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1219 = new BitSet(new long[]{0x0000000000000008L,0x0000004000000000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1223 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1241 = new BitSet(new long[]{0x0000000400000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_PERIOD_in_func_name1247 = new BitSet(new long[]{0xBFBCE811573FAF50L,0xFFE96381EC06370EL,0x006380000000007DL});
    public static final BitSet FOLLOW_DOLLAR_in_func_name1253 = new BitSet(new long[]{0xBFBCE811573FAF50L,0xFFE96381EC06370EL,0x006380000000007DL});
    public static final BitSet FOLLOW_eid_in_func_name1259 = new BitSet(new long[]{0x0000000400000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1277 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1292 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1312 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1316 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1331 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1352 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1356 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1371 = new BitSet(new long[]{0x0000000002000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1377 = new BitSet(new long[]{0x0000000002000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1397 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1403 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1409 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1427 = new BitSet(new long[]{0x40A2082A02005002L,0x0010004A00044800L,0x00100030083E6008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1433 = new BitSet(new long[]{0x40A2082A02005002L,0x0010004A00044800L,0x00100030083E6008L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_group_clause1478 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_COGROUP_in_group_clause1484 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1498 = new BitSet(new long[]{0x00A4200113200008L,0x030840C108002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_item_in_group_clause1504 = new BitSet(new long[]{0x00A4200113200008L,0x030840C108002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_type_in_group_clause1519 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1530 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1561 = new BitSet(new long[]{0x0000000000010010L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1565 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1581 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1587 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_INNER_in_group_item1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_group_item1613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_rel1631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1643 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1665 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1669 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1673 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1677 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1704 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1708 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1727 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause1731 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause1735 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1741 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1760 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1764 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_cond_in_filter_clause1768 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1787 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1791 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_cond_in_cond1795 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1809 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1813 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_cond_in_cond1817 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1831 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1835 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1849 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1851 = new BitSet(new long[]{0x0000000000000008L,0x0000000000020000L});
    public static final BitSet FOLLOW_NOT_in_cond1856 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1876 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1878 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_cond1882 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond1892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond1910 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1912 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval1929 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1933 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_in_eval1939 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1961 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1963 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030083E6008L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1967 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030083E6008L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1973 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030083E6008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1989 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1991 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_real_arg2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg2019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr2034 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2036 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_expr2040 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr2052 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2054 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_expr2058 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr2070 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2072 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_expr2076 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr2088 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2090 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_expr2094 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr2106 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2108 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_expr2112 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2124 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr2128 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_expr2132 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr2160 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2164 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr2180 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_expr2184 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr2196 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2200 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast2225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2248 = new BitSet(new long[]{0x200080100412A808L,0x0000000000000400L,0x0008000800001000L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2254 = new BitSet(new long[]{0x200080100412A808L,0x0000000000000400L,0x0008000800001000L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2270 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2274 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2294 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast2298 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr2316 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr2320 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr2324 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr2348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj2371 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2375 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2381 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index2397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index2401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_col_alias2414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_col_alias2424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_col_alias2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2462 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2464 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2469 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range2471 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2488 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_pound_proj2502 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_pound_proj2508 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2529 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2533 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_bin_expr2537 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_bin_expr2541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr2560 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2564 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_case_expr2570 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond2592 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond2606 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond2608 = new BitSet(new long[]{0x0400000000000048L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_cond_in_case_cond2614 = new BitSet(new long[]{0x0400000000000048L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_THEN_in_case_cond2633 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond2635 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_case_cond2641 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2665 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2669 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2681 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2687 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2693 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2712 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2716 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2720 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2726 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause2745 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause2749 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause2753 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement2770 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement2774 = new BitSet(new long[]{0x0000000020000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement2778 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause2795 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ASC_in_rank_by_clause2801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_by_clause2807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause2820 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause2826 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_col_range_in_rank_col2841 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_col_ref_in_rank_col2845 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ASC_in_rank_col2851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_order_clause2877 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause2881 = new BitSet(new long[]{0x00A0000802000000L,0x0010000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause2893 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause2907 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause2925 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ASC_in_order_by_clause2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_by_clause2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2950 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2956 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_col_range_in_order_col2972 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_col_ref_in_order_col2976 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ASC_in_order_col2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col2987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause3007 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause3011 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause3013 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause3031 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause3035 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause3052 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause3056 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause3058 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list3074 = new BitSet(new long[]{0x00A4200113200002L,0x0308408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_rel_in_rel_list3080 = new BitSet(new long[]{0x00A4200113200002L,0x0308408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_JOIN_in_join_clause3097 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause3101 = new BitSet(new long[]{0x0000000000000008L,0x0000004100000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause3107 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause3118 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type3132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3147 = new BitSet(new long[]{0x0008000000000000L,0x0000020000000008L});
    public static final BitSet FOLLOW_LEFT_in_join_sub_clause3151 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_RIGHT_in_join_sub_clause3170 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_FULL_in_join_sub_clause3189 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause3209 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3226 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause3232 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item3250 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item3252 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item3254 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause3271 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause3279 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030083E6008L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause3285 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030083E6008L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr3309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr3313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause3330 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause3335 = new BitSet(new long[]{0x00A4200113200000L,0x0308408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_rel_list_in_union_clause3342 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause3359 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause3363 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000003000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause3365 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan3382 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan3384 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan3396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan3398 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk3416 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x000000C000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk3423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause3440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause3452 = new BitSet(new long[]{0x40A2482A02005008L,0x0010004A00044800L,0x00100030083E6008L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause3458 = new BitSet(new long[]{0x40A2482A02005008L,0x0010004A00044800L,0x00100030083E6008L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command3477 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command3479 = new BitSet(new long[]{0x0004200101000000L,0x0000000008000100L,0x0000010000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command3483 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command3495 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command3497 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_nested_command3501 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op3526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op3540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op3554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op3582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op3596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj3611 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3613 = new BitSet(new long[]{0x00A0000802000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3617 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3623 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter3644 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter3648 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_cond_in_nested_filter3652 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort3669 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort3673 = new BitSet(new long[]{0x00A0000802000000L,0x0010000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort3685 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort3691 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct3710 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct3715 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit3732 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit3737 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit3741 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit3747 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross3766 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross3771 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach3785 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach3790 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach3792 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input3803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input3807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list3820 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list3826 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause3843 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause3847 = new BitSet(new long[]{0x0080040000000000L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause3861 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stream_clause3875 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause3881 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause3899 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause3901 = new BitSet(new long[]{0x0000000000000000L,0x0100004000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause3916 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause3923 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause3927 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause3938 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause3960 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause3973 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3977 = new BitSet(new long[]{0x0000000000000008L,0x0000000010000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3983 = new BitSet(new long[]{0x0000000000000008L,0x0000000010000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause3992 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch4012 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch4014 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_cond_in_split_branch4018 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise4035 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise4037 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref4050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref4054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref4067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref4077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref4087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref4102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr4113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal4122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal4126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal4130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal4134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar4154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar4167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar4180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar4193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar4206 = new BitSet(new long[]{0x4002002000005000L,0x0000000000000800L});
    public static final BitSet FOLLOW_INTEGER_in_num_scalar4228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_num_scalar4247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATNUMBER_in_num_scalar4266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_num_scalar4285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGERNUMBER_in_num_scalar4304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMALNUMBER_in_num_scalar4323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map4355 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map4359 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_keyvalue_in_map4365 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_MAP_VAL_in_map4381 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue4400 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue4402 = new BitSet(new long[]{0x4002082000005000L,0x0000004000044800L,0x0010001000002008L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue4406 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key4417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag4434 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag4438 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_tuple_in_bag4444 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag4460 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple4479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple4483 = new BitSet(new long[]{0x4002082000005008L,0x0000004000044800L,0x0010001000002008L});
    public static final BitSet FOLLOW_literal_in_tuple4490 = new BitSet(new long[]{0x4002082000005008L,0x0000004000044800L,0x0010001000002008L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple4506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_str_op_in_eid4520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid4528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid4541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid4553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid4566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid4581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid4594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid4606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid4621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid4634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid4646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid4660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid4675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid4686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid4698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid4713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid4727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid4741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid4755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid4770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid4787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid4803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid4820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid4837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid4851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid4865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid4879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid4890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid4900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid4914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid4930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid4947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid4963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid4974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid4986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid5001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid5017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid5032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid5044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid5060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid5075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid5089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid5102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid5111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid5120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid5131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid5141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid5151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid5167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid5181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid5197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid5214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid5229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid5244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid5258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid5271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid5283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid5297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid5307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid5322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid5336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid5350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid5363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid5374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid5388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid5401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid5415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid5428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid5443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid5457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid5472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid5482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid5497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid5512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_in_eid5525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_eid5543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op5568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op5582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op5596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op5610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op5623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op5650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_op_eq5669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_EQ_in_rel_op_eq5679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_op_ne5697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_NE_in_rel_op_ne5707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_op_gt5725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_GT_in_rel_op_gt5735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_op_gte5753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_GTE_in_rel_op_gte5763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_op_lt5781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_LT_in_rel_op_lt5791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_op_lte5809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_OP_LTE_in_rel_op_lte5819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_str_op5834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_str_op5844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_str_op5854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_str_op5864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_str_op5874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_str_op5884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_str_op5894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_def_in_synpred45_AstPrinter970 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_field_def_in_synpred45_AstPrinter976 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_MINUS_in_synpred101_AstPrinter2052 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred101_AstPrinter2054 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_synpred101_AstPrinter2058 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred105_AstPrinter2124 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred105_AstPrinter2128 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_synpred105_AstPrinter2132 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred106_AstPrinter2142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred109_AstPrinter2176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred109_AstPrinter2180 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030082E6008L});
    public static final BitSet FOLLOW_expr_in_synpred109_AstPrinter2184 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_synpred114_AstPrinter2244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred114_AstPrinter2248 = new BitSet(new long[]{0x200080100412A808L,0x0000000000000400L,0x0008000800001000L});
    public static final BitSet FOLLOW_type_cast_in_synpred114_AstPrinter2254 = new BitSet(new long[]{0x200080100412A808L,0x0000000000000400L,0x0008000800001000L});
    public static final BitSet FOLLOW_INTEGER_in_synpred133_AstPrinter2681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred134_AstPrinter2687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred135_AstPrinter2720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred161_AstPrinter3147 = new BitSet(new long[]{0x0008000000000000L,0x0000020000000008L});
    public static final BitSet FOLLOW_set_in_synpred161_AstPrinter3149 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred161_AstPrinter3209 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_join_item_in_synpred161_AstPrinter3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred179_AstPrinter3741 = new BitSet(new long[]{0x0000000000000002L});

}