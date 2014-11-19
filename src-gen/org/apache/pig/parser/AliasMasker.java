// $ANTLR 3.4 /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g 2014-11-19 11:26:35

package org.apache.pig.parser;

import java.util.HashSet;
import java.util.Set;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (visitor for default data type insertion).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AliasMasker extends TreeParser {
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


    public AliasMasker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AliasMasker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AliasMasker.tokenNames; }
    public String getGrammarFileName() { return "/home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g"; }



    @Override
    public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    	if (e instanceof ParserValidationException) {
    		return e.toString();
    	}
    	return super.getErrorMessage(e, tokenNames);
    }

    public void setParams(Set ps, String macro, long idx) {
        params = ps;
        macroName = macro;
        index = idx;
    }

    private String getMask(String alias) {
        return params.contains( alias )
            ? alias
            : "macro_" + macroName + "_" + alias + "_" + index;
    }

    private Set<String> params = new HashSet<String>();

    private Set<String> aliasSeen = new HashSet<String>();

    private String macroName = "";

    private long index = 0;

    private boolean inAsOrGenClause = false;



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:82:1: query : ^( QUERY ( statement )* ) ;
    public final AliasMasker.query_return query() throws RecognitionException {
        AliasMasker.query_return retval = new AliasMasker.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AliasMasker.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:82:7: ( ^( QUERY ( statement )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:82:9: ^( QUERY ( statement )* )
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
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:82:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:82:18: statement
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:85:1: statement : ( general_statement | split_statement | realias_statement );
    public final AliasMasker.statement_return statement() throws RecognitionException {
        AliasMasker.statement_return retval = new AliasMasker.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.general_statement_return general_statement3 =null;

        AliasMasker.split_statement_return split_statement4 =null;

        AliasMasker.realias_statement_return realias_statement5 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:85:11: ( general_statement | split_statement | realias_statement )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:85:13: general_statement
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:86:13: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement108);
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:87:13: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement122);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:90:1: split_statement : split_clause ;
    public final AliasMasker.split_statement_return split_statement() throws RecognitionException {
        AliasMasker.split_statement_return retval = new AliasMasker.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.split_clause_return split_clause6 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:90:17: ( split_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:90:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement131);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:93:1: realias_statement : realias_clause ;
    public final AliasMasker.realias_statement_return realias_statement() throws RecognitionException {
        AliasMasker.realias_statement_return retval = new AliasMasker.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.realias_clause_return realias_clause7 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:93:19: ( realias_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:93:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement140);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:97:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AliasMasker.general_statement_return general_statement() throws RecognitionException {
        AliasMasker.general_statement_return retval = new AliasMasker.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT8=null;
        AliasMasker.alias_return alias9 =null;

        AliasMasker.op_clause_return op_clause10 =null;

        AliasMasker.parallel_clause_return parallel_clause11 =null;


        CommonTree STATEMENT8_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:98:5: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:98:7: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT8=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement156); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT8_tree = (CommonTree)adaptor.dupNode(STATEMENT8);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT8_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:98:20: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:98:22: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement160);
                    alias9=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias9.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement173);
            op_clause10=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause10.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:99:19: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:99:19: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement175);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:102:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AliasMasker.realias_clause_return realias_clause() throws RecognitionException {
        AliasMasker.realias_clause_return retval = new AliasMasker.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS12=null;
        CommonTree IDENTIFIER14=null;
        AliasMasker.alias_return alias13 =null;


        CommonTree REALIAS12_tree=null;
        CommonTree IDENTIFIER14_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:102:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:102:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS12=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause188); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS12_tree = (CommonTree)adaptor.dupNode(REALIAS12);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS12_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause190);
            alias13=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias13.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER14=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause192); if (state.failed) return retval;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:105:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AliasMasker.parallel_clause_return parallel_clause() throws RecognitionException {
        AliasMasker.parallel_clause_return retval = new AliasMasker.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL15=null;
        CommonTree INTEGER16=null;

        CommonTree PARALLEL15_tree=null;
        CommonTree INTEGER16_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:106:5: ( ^( PARALLEL INTEGER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:106:7: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL15=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause208); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL15_tree = (CommonTree)adaptor.dupNode(PARALLEL15);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL15_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER16=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause210); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER16_tree = (CommonTree)adaptor.dupNode(INTEGER16);


            adaptor.addChild(root_1, INTEGER16_tree);
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
    // $ANTLR end "parallel_clause"


    public static class alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:109:1: alias : IDENTIFIER ;
    public final AliasMasker.alias_return alias() throws RecognitionException {
        AliasMasker.alias_return retval = new AliasMasker.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER17=null;

        CommonTree IDENTIFIER17_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:110:5: ( IDENTIFIER )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:110:7: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER17=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias225); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER17_tree = (CommonTree)adaptor.dupNode(IDENTIFIER17);


            adaptor.addChild(root_0, IDENTIFIER17_tree);
            }


            if ( state.backtracking==0 ) {
                        aliasSeen.add((IDENTIFIER17!=null?IDENTIFIER17.getText():null));
                        IDENTIFIER17.getToken().setText(getMask((IDENTIFIER17!=null?IDENTIFIER17.getText():null)));
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
    // $ANTLR end "alias"


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:117:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause );
    public final AliasMasker.op_clause_return op_clause() throws RecognitionException {
        AliasMasker.op_clause_return retval = new AliasMasker.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.define_clause_return define_clause18 =null;

        AliasMasker.load_clause_return load_clause19 =null;

        AliasMasker.group_clause_return group_clause20 =null;

        AliasMasker.store_clause_return store_clause21 =null;

        AliasMasker.filter_clause_return filter_clause22 =null;

        AliasMasker.distinct_clause_return distinct_clause23 =null;

        AliasMasker.limit_clause_return limit_clause24 =null;

        AliasMasker.sample_clause_return sample_clause25 =null;

        AliasMasker.order_clause_return order_clause26 =null;

        AliasMasker.rank_clause_return rank_clause27 =null;

        AliasMasker.cross_clause_return cross_clause28 =null;

        AliasMasker.join_clause_return join_clause29 =null;

        AliasMasker.union_clause_return union_clause30 =null;

        AliasMasker.stream_clause_return stream_clause31 =null;

        AliasMasker.mr_clause_return mr_clause32 =null;

        AliasMasker.split_clause_return split_clause33 =null;

        AliasMasker.foreach_clause_return foreach_clause34 =null;

        AliasMasker.cube_clause_return cube_clause35 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:117:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:117:13: define_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:118:13: load_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:119:13: group_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:120:13: store_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:121:13: filter_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:122:13: distinct_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:123:13: limit_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:124:13: sample_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:125:13: order_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:126:13: rank_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:127:13: cross_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:128:13: join_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:129:13: union_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:130:13: stream_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:131:13: mr_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:132:13: split_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:133:13: foreach_clause
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:134:13: cube_clause
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:137:1: define_clause : ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) ;
    public final AliasMasker.define_clause_return define_clause() throws RecognitionException {
        AliasMasker.define_clause_return retval = new AliasMasker.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE36=null;
        CommonTree IDENTIFIER37=null;
        AliasMasker.cmd_return cmd38 =null;

        AliasMasker.func_clause_return func_clause39 =null;


        CommonTree DEFINE36_tree=null;
        CommonTree IDENTIFIER37_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:138:5: ( ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:138:7: ^( DEFINE IDENTIFIER ( cmd | func_clause ) )
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


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:138:29: ( cmd | func_clause )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:138:31: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause504);
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:138:37: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause508);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:141:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AliasMasker.cmd_return cmd() throws RecognitionException {
        AliasMasker.cmd_return retval = new AliasMasker.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND40=null;
        AliasMasker.ship_clause_return ship_clause41 =null;

        AliasMasker.cache_clause_return cache_clause42 =null;

        AliasMasker.input_clause_return input_clause43 =null;

        AliasMasker.output_clause_return output_clause44 =null;

        AliasMasker.error_clause_return error_clause45 =null;


        CommonTree EXECCOMMAND40_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:142:5: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:142:7: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND40=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd527); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND40_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND40);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND40_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:143:9: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
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
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:143:11: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd539);
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
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:143:25: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd543);
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
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:143:40: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd547);
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
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:143:55: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd551);
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
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:143:71: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd555);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:146:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AliasMasker.ship_clause_return ship_clause() throws RecognitionException {
        AliasMasker.ship_clause_return retval = new AliasMasker.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP46=null;
        AliasMasker.path_list_return path_list47 =null;


        CommonTree SHIP46_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:147:5: ( ^( SHIP ( path_list )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:147:7: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP46=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause575); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP46_tree = (CommonTree)adaptor.dupNode(SHIP46);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP46_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:147:15: ( path_list )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:147:15: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause577);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:150:1: path_list : ( QUOTEDSTRING )+ ;
    public final AliasMasker.path_list_return path_list() throws RecognitionException {
        AliasMasker.path_list_return retval = new AliasMasker.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING48=null;

        CommonTree QUOTEDSTRING48_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:151:5: ( ( QUOTEDSTRING )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:151:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:151:7: ( QUOTEDSTRING )+
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
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:151:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING48=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list593); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING48_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING48);


            	    adaptor.addChild(root_0, QUOTEDSTRING48_tree);
            	    }


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:154:1: cache_clause : ^( CACHE path_list ) ;
    public final AliasMasker.cache_clause_return cache_clause() throws RecognitionException {
        AliasMasker.cache_clause_return retval = new AliasMasker.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE49=null;
        AliasMasker.path_list_return path_list50 =null;


        CommonTree CACHE49_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:155:5: ( ^( CACHE path_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:155:7: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE49=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause609); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE49_tree = (CommonTree)adaptor.dupNode(CACHE49);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE49_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause611);
            path_list50=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list50.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:158:1: input_clause : ^( INPUT ( stream_cmd )+ ) ;
    public final AliasMasker.input_clause_return input_clause() throws RecognitionException {
        AliasMasker.input_clause_return retval = new AliasMasker.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT51=null;
        AliasMasker.stream_cmd_return stream_cmd52 =null;


        CommonTree INPUT51_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:159:5: ( ^( INPUT ( stream_cmd )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:159:7: ^( INPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT51=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause628); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT51_tree = (CommonTree)adaptor.dupNode(INPUT51);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT51_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:159:16: ( stream_cmd )+
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
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:159:16: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause630);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:162:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AliasMasker.stream_cmd_return stream_cmd() throws RecognitionException {
        AliasMasker.stream_cmd_return retval = new AliasMasker.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN53=null;
        CommonTree STDOUT55=null;
        CommonTree QUOTEDSTRING57=null;
        AliasMasker.func_clause_return func_clause54 =null;

        AliasMasker.func_clause_return func_clause56 =null;

        AliasMasker.func_clause_return func_clause58 =null;


        CommonTree STDIN53_tree=null;
        CommonTree STDOUT55_tree=null;
        CommonTree QUOTEDSTRING57_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:163:5: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:163:7: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN53=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN53_tree = (CommonTree)adaptor.dupNode(STDIN53);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN53_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:163:16: ( func_clause )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:163:16: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd650);
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:164:7: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT55=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd663); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT55_tree = (CommonTree)adaptor.dupNode(STDOUT55);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT55_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:164:17: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:164:17: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd665);
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:165:7: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING57=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd678); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING57_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING57);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING57_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:165:23: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:165:23: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd680);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:168:1: output_clause : ^( OUTPUT ( stream_cmd )+ ) ;
    public final AliasMasker.output_clause_return output_clause() throws RecognitionException {
        AliasMasker.output_clause_return retval = new AliasMasker.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT59=null;
        AliasMasker.stream_cmd_return stream_cmd60 =null;


        CommonTree OUTPUT59_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:169:5: ( ^( OUTPUT ( stream_cmd )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:169:7: ^( OUTPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT59=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause698); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT59_tree = (CommonTree)adaptor.dupNode(OUTPUT59);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT59_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:169:17: ( stream_cmd )+
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
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:169:17: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause700);
            	    stream_cmd60=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd60.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:172:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AliasMasker.error_clause_return error_clause() throws RecognitionException {
        AliasMasker.error_clause_return retval = new AliasMasker.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR61=null;
        CommonTree QUOTEDSTRING62=null;
        CommonTree INTEGER63=null;

        CommonTree STDERROR61_tree=null;
        CommonTree QUOTEDSTRING62_tree=null;
        CommonTree INTEGER63_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:173:5: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:173:7: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR61=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause718); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR61_tree = (CommonTree)adaptor.dupNode(STDERROR61);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR61_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:173:19: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:173:21: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING62=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause722); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING62_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING62);


                        adaptor.addChild(root_1, QUOTEDSTRING62_tree);
                        }


                        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:173:34: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:173:34: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER63=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause724); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER63_tree = (CommonTree)adaptor.dupNode(INTEGER63);


                                adaptor.addChild(root_1, INTEGER63_tree);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:176:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AliasMasker.load_clause_return load_clause() throws RecognitionException {
        AliasMasker.load_clause_return retval = new AliasMasker.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD64=null;
        AliasMasker.filename_return filename65 =null;

        AliasMasker.func_clause_return func_clause66 =null;

        AliasMasker.as_clause_return as_clause67 =null;


        CommonTree LOAD64_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:177:5: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:177:7: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD64=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause745); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD64_tree = (CommonTree)adaptor.dupNode(LOAD64);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD64_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause747);
            filename65=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename65.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:177:24: ( func_clause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:177:24: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause749);
                    func_clause66=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause66.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:177:37: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:177:37: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause752);
                    as_clause67=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause67.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:180:1: filename : QUOTEDSTRING ;
    public final AliasMasker.filename_return filename() throws RecognitionException {
        AliasMasker.filename_return retval = new AliasMasker.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING68=null;

        CommonTree QUOTEDSTRING68_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:181:5: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:181:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING68=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename768); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING68_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING68);


            adaptor.addChild(root_0, QUOTEDSTRING68_tree);
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
    // $ANTLR end "filename"


    public static class as_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:184:1: as_clause : ^( AS field_def_list ) ;
    public final AliasMasker.as_clause_return as_clause() throws RecognitionException {
        AliasMasker.as_clause_return retval = new AliasMasker.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS69=null;
        AliasMasker.field_def_list_return field_def_list70 =null;


        CommonTree AS69_tree=null;


        	inAsOrGenClause = true;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:191:5: ( ^( AS field_def_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:191:7: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS69=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause793); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS69_tree = (CommonTree)adaptor.dupNode(AS69);


            root_1 = (CommonTree)adaptor.becomeRoot(AS69_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause795);
            field_def_list70=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list70.getTree());


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

            if ( state.backtracking==0 ) {
            	inAsOrGenClause = false;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:194:1: field_def : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) );
    public final AliasMasker.field_def_return field_def() throws RecognitionException {
        AliasMasker.field_def_return retval = new AliasMasker.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF71=null;
        CommonTree IDENTIFIER72=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER74=null;
        AliasMasker.type_return type73 =null;

        AliasMasker.type_return type75 =null;


        CommonTree FIELD_DEF71_tree=null;
        CommonTree IDENTIFIER72_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER74_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:195:5: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:195:7: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF71=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def812); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF71_tree = (CommonTree)adaptor.dupNode(FIELD_DEF71);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF71_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER72=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def814); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER72_tree = (CommonTree)adaptor.dupNode(IDENTIFIER72);


                    adaptor.addChild(root_1, IDENTIFIER72_tree);
                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:195:31: ( type )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==BIGDECIMAL||LA20_0==BIGINTEGER||LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DATETIME||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:195:31: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def816);
                            type73=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type73.getTree());


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
                    	if (inAsOrGenClause) {
                    		if (aliasSeen.contains((IDENTIFIER72!=null?IDENTIFIER72.getText():null))) {
                    			throw new ParserValidationException(input, new SourceLocation((PigParserNode)((CommonTree)retval.start)),
                    				"Macro doesn't support user defined schema that contains name that conflicts with alias name: " + (IDENTIFIER72!=null?IDENTIFIER72.getText():null));
                    		}
                    	}
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:203:7: ^( FIELD_DEF_WITHOUT_IDENTIFIER type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER74=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def831); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER74_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER74);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def833);
                    type75=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type75.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:206:1: field_def_list : ( field_def )+ ;
    public final AliasMasker.field_def_list_return field_def_list() throws RecognitionException {
        AliasMasker.field_def_list_return retval = new AliasMasker.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.field_def_return field_def76 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:207:5: ( ( field_def )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:207:7: ( field_def )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:207:7: ( field_def )+
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
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:207:7: field_def
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list848);
            	    field_def76=field_def();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def76.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:210:1: type : ( simple_type | tuple_type | bag_type | map_type );
    public final AliasMasker.type_return type() throws RecognitionException {
        AliasMasker.type_return retval = new AliasMasker.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type77 =null;

        AliasMasker.tuple_type_return tuple_type78 =null;

        AliasMasker.bag_type_return bag_type79 =null;

        AliasMasker.map_type_return map_type80 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:210:6: ( simple_type | tuple_type | bag_type | map_type )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:210:8: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type858);
                    simple_type77=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type77.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:210:22: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type862);
                    tuple_type78=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type78.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:210:35: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type866);
                    bag_type79=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type79.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:210:46: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type870);
                    map_type80=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type80.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:213:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER | BIGDECIMAL | CHARARRAY | BYTEARRAY );
    public final AliasMasker.simple_type_return simple_type() throws RecognitionException {
        AliasMasker.simple_type_return retval = new AliasMasker.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set81=null;

        CommonTree set81_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:214:5: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER | BIGDECIMAL | CHARARRAY | BYTEARRAY )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set81=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMAL||input.LA(1)==BIGINTEGER||input.LA(1)==BOOLEAN||input.LA(1)==BYTEARRAY||input.LA(1)==CHARARRAY||input.LA(1)==DATETIME||input.LA(1)==DOUBLE||input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==LONG ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set81_tree = (CommonTree)adaptor.dupNode(set81);


                adaptor.addChild(root_0, set81_tree);
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
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:217:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AliasMasker.tuple_type_return tuple_type() throws RecognitionException {
        AliasMasker.tuple_type_return retval = new AliasMasker.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE82=null;
        AliasMasker.field_def_list_return field_def_list83 =null;


        CommonTree TUPLE_TYPE82_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:218:5: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:218:7: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE82=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type934); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE82_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE82);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE82_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:218:21: ( field_def_list )?
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0 >= FIELD_DEF && LA24_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt24=1;
                }
                switch (alt24) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:218:21: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type936);
                        field_def_list83=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list83.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:221:1: bag_type : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final AliasMasker.bag_type_return bag_type() throws RecognitionException {
        AliasMasker.bag_type_return retval = new AliasMasker.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE84=null;
        CommonTree IDENTIFIER85=null;
        AliasMasker.tuple_type_return tuple_type86 =null;


        CommonTree BAG_TYPE84_tree=null;
        CommonTree IDENTIFIER85_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:222:5: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:222:7: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE84=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type954); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE84_tree = (CommonTree)adaptor.dupNode(BAG_TYPE84);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE84_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:222:19: ( IDENTIFIER )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IDENTIFIER) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:222:19: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER85=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type956); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER85_tree = (CommonTree)adaptor.dupNode(IDENTIFIER85);


                        adaptor.addChild(root_1, IDENTIFIER85_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:222:31: ( tuple_type )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==TUPLE_TYPE) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:222:31: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type959);
                        tuple_type86=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type86.getTree());


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
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:225:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AliasMasker.map_type_return map_type() throws RecognitionException {
        AliasMasker.map_type_return retval = new AliasMasker.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE87=null;
        AliasMasker.type_return type88 =null;


        CommonTree MAP_TYPE87_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:225:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:225:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE87=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type973); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE87_tree = (CommonTree)adaptor.dupNode(MAP_TYPE87);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE87_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:225:24: ( type )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==BIGDECIMAL||LA27_0==BIGINTEGER||LA27_0==BOOLEAN||LA27_0==BYTEARRAY||LA27_0==CHARARRAY||LA27_0==DATETIME||LA27_0==DOUBLE||LA27_0==FLOAT||LA27_0==INT||LA27_0==LONG||LA27_0==BAG_TYPE||LA27_0==MAP_TYPE||LA27_0==TUPLE_TYPE) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:225:24: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type975);
                        type88=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type88.getTree());


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
    // $ANTLR end "map_type"


    public static class func_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:228:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AliasMasker.func_clause_return func_clause() throws RecognitionException {
        AliasMasker.func_clause_return retval = new AliasMasker.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF89=null;
        CommonTree FUNC91=null;
        AliasMasker.func_name_return func_name90 =null;

        AliasMasker.func_name_return func_name92 =null;

        AliasMasker.func_args_return func_args93 =null;


        CommonTree FUNC_REF89_tree=null;
        CommonTree FUNC91_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:229:5: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==FUNC_REF) ) {
                alt29=1;
            }
            else if ( (LA29_0==FUNC) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:229:7: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF89=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause993); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF89_tree = (CommonTree)adaptor.dupNode(FUNC_REF89);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF89_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause995);
                    func_name90=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name90.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:230:7: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC91=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1007); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC91_tree = (CommonTree)adaptor.dupNode(FUNC91);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC91_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1009);
                    func_name92=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name92.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:230:25: ( func_args )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==QUOTEDSTRING) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:230:25: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1011);
                            func_args93=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args93.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:233:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AliasMasker.func_name_return func_name() throws RecognitionException {
        AliasMasker.func_name_return retval = new AliasMasker.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set95=null;
        AliasMasker.eid_return eid94 =null;

        AliasMasker.eid_return eid96 =null;


        CommonTree set95_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:234:5: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:234:7: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1027);
            eid94=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid94.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:234:11: ( ( PERIOD | DOLLAR ) eid )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==DOLLAR||LA30_0==PERIOD) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:234:13: ( PERIOD | DOLLAR ) eid
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    set95=(CommonTree)input.LT(1);

            	    if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) {
            	        set95_tree = (CommonTree)adaptor.dupNode(set95);


            	        adaptor.addChild(root_0, set95_tree);
            	        }

            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1041);
            	    eid96=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid96.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop30;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:237:1: func_args : ( QUOTEDSTRING )+ ;
    public final AliasMasker.func_args_return func_args() throws RecognitionException {
        AliasMasker.func_args_return retval = new AliasMasker.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING97=null;

        CommonTree QUOTEDSTRING97_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:238:5: ( ( QUOTEDSTRING )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:238:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:238:7: ( QUOTEDSTRING )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==QUOTEDSTRING) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:238:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING97=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1057); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING97_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING97);


            	    adaptor.addChild(root_0, QUOTEDSTRING97_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:241:1: cube_clause : ^( CUBE cube_item ) ;
    public final AliasMasker.cube_clause_return cube_clause() throws RecognitionException {
        AliasMasker.cube_clause_return retval = new AliasMasker.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE98=null;
        AliasMasker.cube_item_return cube_item99 =null;


        CommonTree CUBE98_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:242:5: ( ^( CUBE cube_item ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:242:7: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE98=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1073); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE98_tree = (CommonTree)adaptor.dupNode(CUBE98);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE98_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1075);
            cube_item99=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item99.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:245:1: cube_item : rel ( cube_by_clause ) ;
    public final AliasMasker.cube_item_return cube_item() throws RecognitionException {
        AliasMasker.cube_item_return retval = new AliasMasker.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.rel_return rel100 =null;

        AliasMasker.cube_by_clause_return cube_by_clause101 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:246:5: ( rel ( cube_by_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:246:7: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1090);
            rel100=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel100.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:246:11: ( cube_by_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:246:13: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1094);
            cube_by_clause101=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause101.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:249:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AliasMasker.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AliasMasker.cube_by_clause_return retval = new AliasMasker.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY102=null;
        AliasMasker.cube_or_rollup_return cube_or_rollup103 =null;


        CommonTree BY102_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:250:5: ( ^( BY cube_or_rollup ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:250:7: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY102=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1111); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY102_tree = (CommonTree)adaptor.dupNode(BY102);


            root_1 = (CommonTree)adaptor.becomeRoot(BY102_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1113);
            cube_or_rollup103=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup103.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:253:1: cube_or_rollup : ( cube_rollup_list )+ ;
    public final AliasMasker.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AliasMasker.cube_or_rollup_return retval = new AliasMasker.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.cube_rollup_list_return cube_rollup_list104 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:254:5: ( ( cube_rollup_list )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:254:7: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:254:7: ( cube_rollup_list )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==CUBE||LA32_0==ROLLUP) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:254:7: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1128);
            	    cube_rollup_list104=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list104.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:257:1: cube_rollup_list : ^( ( CUBE | ROLLUP ) cube_by_expr_list ) ;
    public final AliasMasker.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AliasMasker.cube_rollup_list_return retval = new AliasMasker.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set105=null;
        AliasMasker.cube_by_expr_list_return cube_by_expr_list106 =null;


        CommonTree set105_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:258:5: ( ^( ( CUBE | ROLLUP ) cube_by_expr_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:258:7: ^( ( CUBE | ROLLUP ) cube_by_expr_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set105=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==ROLLUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set105_tree = (CommonTree)adaptor.dupNode(set105);


                root_1 = (CommonTree)adaptor.becomeRoot(set105_tree, root_1);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1154);
            cube_by_expr_list106=cube_by_expr_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_by_expr_list106.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:261:1: cube_by_expr_list : ( cube_by_expr )+ ;
    public final AliasMasker.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AliasMasker.cube_by_expr_list_return retval = new AliasMasker.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.cube_by_expr_return cube_by_expr107 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:262:5: ( ( cube_by_expr )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:262:7: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:262:7: ( cube_by_expr )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==BIGDECIMALNUMBER||LA33_0==BIGINTEGERNUMBER||LA33_0==CASE||LA33_0==CUBE||LA33_0==DIV||LA33_0==DOLLARVAR||LA33_0==DOUBLENUMBER||LA33_0==FALSE||LA33_0==FLOATNUMBER||LA33_0==GROUP||LA33_0==IDENTIFIER||LA33_0==INTEGER||LA33_0==LONGINTEGER||LA33_0==MINUS||LA33_0==NULL||LA33_0==PERCENT||LA33_0==PLUS||LA33_0==QUOTEDSTRING||LA33_0==STAR||LA33_0==TRUE||(LA33_0 >= BAG_VAL && LA33_0 <= BIN_EXPR)||(LA33_0 >= CAST_EXPR && LA33_0 <= EXPR_IN_PAREN)||LA33_0==FUNC_EVAL||(LA33_0 >= MAP_VAL && LA33_0 <= NEG)||LA33_0==TUPLE_VAL) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:262:7: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1169);
            	    cube_by_expr107=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr107.getTree());


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
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:265:1: cube_by_expr : ( col_range | expr | STAR );
    public final AliasMasker.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AliasMasker.cube_by_expr_return retval = new AliasMasker.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR110=null;
        AliasMasker.col_range_return col_range108 =null;

        AliasMasker.expr_return expr109 =null;


        CommonTree STAR110_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:266:5: ( col_range | expr | STAR )
            int alt34=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt34=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CASE:
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
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt34=2;
                }
                break;
            case STAR:
                {
                int LA34_3 = input.LA(2);

                if ( (LA34_3==DOWN) ) {
                    alt34=2;
                }
                else if ( (LA34_3==EOF||LA34_3==UP||LA34_3==BIGDECIMALNUMBER||LA34_3==BIGINTEGERNUMBER||LA34_3==CASE||LA34_3==CUBE||LA34_3==DIV||LA34_3==DOLLARVAR||LA34_3==DOUBLENUMBER||LA34_3==FALSE||LA34_3==FLOATNUMBER||LA34_3==GROUP||LA34_3==IDENTIFIER||LA34_3==INTEGER||LA34_3==LONGINTEGER||LA34_3==MINUS||LA34_3==NULL||LA34_3==PERCENT||LA34_3==PLUS||LA34_3==QUOTEDSTRING||LA34_3==STAR||LA34_3==TRUE||(LA34_3 >= BAG_VAL && LA34_3 <= BIN_EXPR)||(LA34_3 >= CAST_EXPR && LA34_3 <= EXPR_IN_PAREN)||LA34_3==FUNC_EVAL||(LA34_3 >= MAP_VAL && LA34_3 <= NEG)||LA34_3==TUPLE_VAL) ) {
                    alt34=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }

            switch (alt34) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:266:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1183);
                    col_range108=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range108.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:266:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1187);
                    expr109=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr109.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:266:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR110=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1191); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR110_tree = (CommonTree)adaptor.dupNode(STAR110);


                    adaptor.addChild(root_0, STAR110_tree);
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


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:269:1: group_clause : ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) ;
    public final AliasMasker.group_clause_return group_clause() throws RecognitionException {
        AliasMasker.group_clause_return retval = new AliasMasker.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set111=null;
        AliasMasker.group_item_return group_item112 =null;

        AliasMasker.group_type_return group_type113 =null;

        AliasMasker.partition_clause_return partition_clause114 =null;


        CommonTree set111_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:270:5: ( ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:270:7: ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set111=(CommonTree)input.LT(1);

            if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set111_tree = (CommonTree)adaptor.dupNode(set111);


                root_1 = (CommonTree)adaptor.becomeRoot(set111_tree, root_1);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:270:30: ( group_item )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==COGROUP||(LA35_0 >= CROSS && LA35_0 <= CUBE)||LA35_0==DEFINE||LA35_0==DISTINCT||LA35_0==FILTER||LA35_0==FOREACH||LA35_0==GROUP||LA35_0==IDENTIFIER||LA35_0==JOIN||(LA35_0 >= LIMIT && LA35_0 <= LOAD)||LA35_0==MAPREDUCE||LA35_0==ORDER||LA35_0==RANK||LA35_0==SAMPLE||LA35_0==SPLIT||(LA35_0 >= STORE && LA35_0 <= STREAM)||LA35_0==UNION) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:270:30: group_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1216);
            	    group_item112=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item112.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:270:42: ( group_type )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==QUOTEDSTRING) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:270:42: group_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1219);
                    group_type113=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type113.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:270:54: ( partition_clause )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==PARTITION) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:270:54: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1222);
                    partition_clause114=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause114.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:273:1: group_type : QUOTEDSTRING ;
    public final AliasMasker.group_type_return group_type() throws RecognitionException {
        AliasMasker.group_type_return retval = new AliasMasker.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING115=null;

        CommonTree QUOTEDSTRING115_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:273:12: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:273:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING115=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1234); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING115_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING115);


            adaptor.addChild(root_0, QUOTEDSTRING115_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:276:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AliasMasker.group_item_return group_item() throws RecognitionException {
        AliasMasker.group_item_return retval = new AliasMasker.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL118=null;
        CommonTree ANY119=null;
        CommonTree set120=null;
        AliasMasker.rel_return rel116 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause117 =null;


        CommonTree ALL118_tree=null;
        CommonTree ANY119_tree=null;
        CommonTree set120_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:277:5: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:277:7: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1247);
            rel116=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel116.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:277:11: ( join_group_by_clause | ALL | ANY )
            int alt38=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt38=1;
                }
                break;
            case ALL:
                {
                alt38=2;
                }
                break;
            case ANY:
                {
                alt38=3;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:277:13: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1251);
                    join_group_by_clause117=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause117.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:277:36: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL118=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1255); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL118_tree = (CommonTree)adaptor.dupNode(ALL118);


                    adaptor.addChild(root_0, ALL118_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:277:42: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY119=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1259); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY119_tree = (CommonTree)adaptor.dupNode(ANY119);


                    adaptor.addChild(root_0, ANY119_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:277:48: ( INNER | OUTER )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==INNER||LA39_0==OUTER) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set120=(CommonTree)input.LT(1);

                    if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set120_tree = (CommonTree)adaptor.dupNode(set120);


                        adaptor.addChild(root_0, set120_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:280:1: rel : ( alias | ( op_clause ( parallel_clause )? ) );
    public final AliasMasker.rel_return rel() throws RecognitionException {
        AliasMasker.rel_return retval = new AliasMasker.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_return alias121 =null;

        AliasMasker.op_clause_return op_clause122 =null;

        AliasMasker.parallel_clause_return parallel_clause123 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:281:5: ( alias | ( op_clause ( parallel_clause )? ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDENTIFIER) ) {
                alt41=1;
            }
            else if ( (LA41_0==COGROUP||(LA41_0 >= CROSS && LA41_0 <= CUBE)||LA41_0==DEFINE||LA41_0==DISTINCT||LA41_0==FILTER||LA41_0==FOREACH||LA41_0==GROUP||LA41_0==JOIN||(LA41_0 >= LIMIT && LA41_0 <= LOAD)||LA41_0==MAPREDUCE||LA41_0==ORDER||LA41_0==RANK||LA41_0==SAMPLE||LA41_0==SPLIT||(LA41_0 >= STORE && LA41_0 <= STREAM)||LA41_0==UNION) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:281:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1285);
                    alias121=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias121.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:281:15: ( op_clause ( parallel_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:281:15: ( op_clause ( parallel_clause )? )
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:281:17: op_clause ( parallel_clause )?
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1291);
                    op_clause122=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause122.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:281:27: ( parallel_clause )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==PARALLEL) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:281:27: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1293);
                            parallel_clause123=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause123.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:284:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AliasMasker.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AliasMasker.flatten_generated_item_return retval = new AliasMasker.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR127=null;
        AliasMasker.flatten_clause_return flatten_clause124 =null;

        AliasMasker.col_range_return col_range125 =null;

        AliasMasker.expr_return expr126 =null;

        AliasMasker.field_def_list_return field_def_list128 =null;


        CommonTree STAR127_tree=null;


        	inAsOrGenClause = true;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:291:5: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:291:7: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:291:7: ( flatten_clause | col_range | expr | STAR )
            int alt42=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt42=1;
                }
                break;
            case COL_RANGE:
                {
                alt42=2;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CASE:
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
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt42=3;
                }
                break;
            case STAR:
                {
                int LA42_4 = input.LA(2);

                if ( (LA42_4==DOWN) ) {
                    alt42=3;
                }
                else if ( (LA42_4==EOF||LA42_4==UP||LA42_4==BIGDECIMALNUMBER||LA42_4==BIGINTEGERNUMBER||LA42_4==CASE||LA42_4==CUBE||LA42_4==DIV||LA42_4==DOLLARVAR||LA42_4==DOUBLENUMBER||LA42_4==FALSE||LA42_4==FLATTEN||LA42_4==FLOATNUMBER||LA42_4==GROUP||LA42_4==IDENTIFIER||LA42_4==INTEGER||LA42_4==LONGINTEGER||LA42_4==MINUS||LA42_4==NULL||LA42_4==PERCENT||LA42_4==PLUS||LA42_4==QUOTEDSTRING||LA42_4==STAR||LA42_4==TRUE||(LA42_4 >= BAG_VAL && LA42_4 <= BIN_EXPR)||(LA42_4 >= CAST_EXPR && LA42_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA42_4==FUNC_EVAL||(LA42_4 >= MAP_VAL && LA42_4 <= NEG)||LA42_4==TUPLE_VAL) ) {
                    alt42=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }

            switch (alt42) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:291:9: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1321);
                    flatten_clause124=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause124.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:291:26: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1325);
                    col_range125=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range125.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:291:38: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1329);
                    expr126=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr126.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:291:45: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR127=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1333); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR127_tree = (CommonTree)adaptor.dupNode(STAR127);


                    adaptor.addChild(root_0, STAR127_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:291:52: ( field_def_list )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0 >= FIELD_DEF && LA43_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:291:52: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1337);
                    field_def_list128=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list128.getTree());


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

            if ( state.backtracking==0 ) {
            	inAsOrGenClause = false;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:294:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AliasMasker.flatten_clause_return flatten_clause() throws RecognitionException {
        AliasMasker.flatten_clause_return retval = new AliasMasker.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN129=null;
        AliasMasker.expr_return expr130 =null;


        CommonTree FLATTEN129_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:295:5: ( ^( FLATTEN expr ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:295:7: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN129=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1353); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN129_tree = (CommonTree)adaptor.dupNode(FLATTEN129);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN129_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1355);
            expr130=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr130.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:298:1: store_clause : ^( STORE alias filename ( func_clause )? ) ;
    public final AliasMasker.store_clause_return store_clause() throws RecognitionException {
        AliasMasker.store_clause_return retval = new AliasMasker.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE131=null;
        AliasMasker.alias_return alias132 =null;

        AliasMasker.filename_return filename133 =null;

        AliasMasker.func_clause_return func_clause134 =null;


        CommonTree STORE131_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:299:5: ( ^( STORE alias filename ( func_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:299:7: ^( STORE alias filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE131=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1372); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE131_tree = (CommonTree)adaptor.dupNode(STORE131);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE131_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_store_clause1374);
            alias132=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias132.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1376);
            filename133=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename133.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:299:31: ( func_clause )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==FUNC||LA44_0==FUNC_REF) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:299:31: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1378);
                    func_clause134=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause134.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:302:1: filter_clause : ^( FILTER rel cond ) ;
    public final AliasMasker.filter_clause_return filter_clause() throws RecognitionException {
        AliasMasker.filter_clause_return retval = new AliasMasker.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER135=null;
        AliasMasker.rel_return rel136 =null;

        AliasMasker.cond_return cond137 =null;


        CommonTree FILTER135_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:303:5: ( ^( FILTER rel cond ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:303:7: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER135=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1396); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER135_tree = (CommonTree)adaptor.dupNode(FILTER135);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER135_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1398);
            rel136=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel136.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1400);
            cond137=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond137.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:306:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) );
    public final AliasMasker.cond_return cond() throws RecognitionException {
        AliasMasker.cond_return retval = new AliasMasker.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR138=null;
        CommonTree AND141=null;
        CommonTree NOT144=null;
        CommonTree NULL146=null;
        CommonTree NOT148=null;
        CommonTree BOOL_COND154=null;
        AliasMasker.cond_return cond139 =null;

        AliasMasker.cond_return cond140 =null;

        AliasMasker.cond_return cond142 =null;

        AliasMasker.cond_return cond143 =null;

        AliasMasker.cond_return cond145 =null;

        AliasMasker.expr_return expr147 =null;

        AliasMasker.rel_op_return rel_op149 =null;

        AliasMasker.expr_return expr150 =null;

        AliasMasker.expr_return expr151 =null;

        AliasMasker.in_eval_return in_eval152 =null;

        AliasMasker.func_eval_return func_eval153 =null;

        AliasMasker.expr_return expr155 =null;


        CommonTree OR138_tree=null;
        CommonTree AND141_tree=null;
        CommonTree NOT144_tree=null;
        CommonTree NULL146_tree=null;
        CommonTree NOT148_tree=null;
        CommonTree BOOL_COND154_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:307:5: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) )
            int alt46=8;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt46=1;
                }
                break;
            case AND:
                {
                alt46=2;
                }
                break;
            case NOT:
                {
                alt46=3;
                }
                break;
            case NULL:
                {
                alt46=4;
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
                alt46=5;
                }
                break;
            case IN:
                {
                alt46=6;
                }
                break;
            case FUNC_EVAL:
                {
                alt46=7;
                }
                break;
            case BOOL_COND:
                {
                alt46=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:307:7: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR138=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1417); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR138_tree = (CommonTree)adaptor.dupNode(OR138);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR138_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1419);
                    cond139=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond139.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1421);
                    cond140=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond140.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:308:7: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND141=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1433); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND141_tree = (CommonTree)adaptor.dupNode(AND141);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND141_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1435);
                    cond142=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond142.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1437);
                    cond143=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond143.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:309:7: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT144=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1449); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT144_tree = (CommonTree)adaptor.dupNode(NOT144);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT144_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1451);
                    cond145=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond145.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:310:7: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL146=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1463); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL146_tree = (CommonTree)adaptor.dupNode(NULL146);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL146_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1465);
                    expr147=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr147.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:310:20: ( NOT )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==NOT) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:310:20: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT148=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1467); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT148_tree = (CommonTree)adaptor.dupNode(NOT148);


                            adaptor.addChild(root_1, NOT148_tree);
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
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:311:7: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1480);
                    rel_op149=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op149.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1482);
                    expr150=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr150.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1484);
                    expr151=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr151.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:312:7: in_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond1494);
                    in_eval152=in_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval152.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:313:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1502);
                    func_eval153=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval153.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:314:7: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND154=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond1512); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND154_tree = (CommonTree)adaptor.dupNode(BOOL_COND154);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND154_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1514);
                    expr155=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr155.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:317:1: in_eval : ^( IN expr ( expr )+ ) ;
    public final AliasMasker.in_eval_return in_eval() throws RecognitionException {
        AliasMasker.in_eval_return retval = new AliasMasker.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN156=null;
        AliasMasker.expr_return expr157 =null;

        AliasMasker.expr_return expr158 =null;


        CommonTree IN156_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:318:5: ( ^( IN expr ( expr )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:318:7: ^( IN expr ( expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN156=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval1531); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN156_tree = (CommonTree)adaptor.dupNode(IN156);


            root_1 = (CommonTree)adaptor.becomeRoot(IN156_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_in_eval1533);
            expr157=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr157.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:318:18: ( expr )+
            int cnt47=0;
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==BIGDECIMALNUMBER||LA47_0==BIGINTEGERNUMBER||LA47_0==CASE||LA47_0==CUBE||LA47_0==DIV||LA47_0==DOLLARVAR||LA47_0==DOUBLENUMBER||LA47_0==FALSE||LA47_0==FLOATNUMBER||LA47_0==GROUP||LA47_0==IDENTIFIER||LA47_0==INTEGER||LA47_0==LONGINTEGER||LA47_0==MINUS||LA47_0==NULL||LA47_0==PERCENT||LA47_0==PLUS||LA47_0==QUOTEDSTRING||LA47_0==STAR||LA47_0==TRUE||(LA47_0 >= BAG_VAL && LA47_0 <= BIN_EXPR)||LA47_0==CAST_EXPR||LA47_0==EXPR_IN_PAREN||LA47_0==FUNC_EVAL||(LA47_0 >= MAP_VAL && LA47_0 <= NEG)||LA47_0==TUPLE_VAL) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:318:18: expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1535);
            	    expr158=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, expr158.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt47 >= 1 ) break loop47;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(47, input);
                        throw eee;
                }
                cnt47++;
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
    // $ANTLR end "in_eval"


    public static class func_eval_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:321:1: func_eval : ^( FUNC_EVAL func_name ( real_arg )* ) ;
    public final AliasMasker.func_eval_return func_eval() throws RecognitionException {
        AliasMasker.func_eval_return retval = new AliasMasker.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL159=null;
        AliasMasker.func_name_return func_name160 =null;

        AliasMasker.real_arg_return real_arg161 =null;


        CommonTree FUNC_EVAL159_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:322:5: ( ^( FUNC_EVAL func_name ( real_arg )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:322:7: ^( FUNC_EVAL func_name ( real_arg )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FUNC_EVAL159=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1553); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNC_EVAL159_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL159);


            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL159_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_func_eval1555);
            func_name160=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name160.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:322:30: ( real_arg )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==BIGDECIMALNUMBER||LA48_0==BIGINTEGERNUMBER||LA48_0==CASE||LA48_0==CUBE||LA48_0==DIV||LA48_0==DOLLARVAR||LA48_0==DOUBLENUMBER||LA48_0==FALSE||LA48_0==FLOATNUMBER||LA48_0==GROUP||LA48_0==IDENTIFIER||LA48_0==INTEGER||LA48_0==LONGINTEGER||LA48_0==MINUS||LA48_0==NULL||LA48_0==PERCENT||LA48_0==PLUS||LA48_0==QUOTEDSTRING||LA48_0==STAR||LA48_0==TRUE||(LA48_0 >= BAG_VAL && LA48_0 <= BIN_EXPR)||LA48_0==CAST_EXPR||LA48_0==EXPR_IN_PAREN||LA48_0==FUNC_EVAL||(LA48_0 >= MAP_VAL && LA48_0 <= NEG)||LA48_0==TUPLE_VAL) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:322:30: real_arg
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_real_arg_in_func_eval1557);
            	    real_arg161=real_arg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, real_arg161.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop48;
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
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:325:1: real_arg : ( expr | STAR );
    public final AliasMasker.real_arg_return real_arg() throws RecognitionException {
        AliasMasker.real_arg_return retval = new AliasMasker.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR163=null;
        AliasMasker.expr_return expr162 =null;


        CommonTree STAR163_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:326:5: ( expr | STAR )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==BIGDECIMALNUMBER||LA49_0==BIGINTEGERNUMBER||LA49_0==CASE||LA49_0==CUBE||LA49_0==DIV||LA49_0==DOLLARVAR||LA49_0==DOUBLENUMBER||LA49_0==FALSE||LA49_0==FLOATNUMBER||LA49_0==GROUP||LA49_0==IDENTIFIER||LA49_0==INTEGER||LA49_0==LONGINTEGER||LA49_0==MINUS||LA49_0==NULL||LA49_0==PERCENT||LA49_0==PLUS||LA49_0==QUOTEDSTRING||LA49_0==TRUE||(LA49_0 >= BAG_VAL && LA49_0 <= BIN_EXPR)||LA49_0==CAST_EXPR||LA49_0==EXPR_IN_PAREN||LA49_0==FUNC_EVAL||(LA49_0 >= MAP_VAL && LA49_0 <= NEG)||LA49_0==TUPLE_VAL) ) {
                alt49=1;
            }
            else if ( (LA49_0==STAR) ) {
                int LA49_2 = input.LA(2);

                if ( (LA49_2==DOWN) ) {
                    alt49=1;
                }
                else if ( (LA49_2==EOF||LA49_2==UP||LA49_2==BIGDECIMALNUMBER||LA49_2==BIGINTEGERNUMBER||LA49_2==CASE||LA49_2==CUBE||LA49_2==DIV||LA49_2==DOLLARVAR||LA49_2==DOUBLENUMBER||LA49_2==FALSE||LA49_2==FLOATNUMBER||LA49_2==GROUP||LA49_2==IDENTIFIER||LA49_2==INTEGER||LA49_2==LONGINTEGER||LA49_2==MINUS||LA49_2==NULL||LA49_2==PERCENT||LA49_2==PLUS||LA49_2==QUOTEDSTRING||LA49_2==STAR||LA49_2==TRUE||(LA49_2 >= BAG_VAL && LA49_2 <= BIN_EXPR)||LA49_2==CAST_EXPR||LA49_2==EXPR_IN_PAREN||LA49_2==FUNC_EVAL||(LA49_2 >= MAP_VAL && LA49_2 <= NEG)||LA49_2==TUPLE_VAL) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }
            switch (alt49) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:326:7: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1573);
                    expr162=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr162.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:326:14: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR163=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1577); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR163_tree = (CommonTree)adaptor.dupNode(STAR163);


                    adaptor.addChild(root_0, STAR163_tree);
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
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:329:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AliasMasker.expr_return expr() throws RecognitionException {
        AliasMasker.expr_return retval = new AliasMasker.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS164=null;
        CommonTree MINUS167=null;
        CommonTree STAR170=null;
        CommonTree DIV173=null;
        CommonTree PERCENT176=null;
        CommonTree CAST_EXPR179=null;
        CommonTree NEG184=null;
        CommonTree CAST_EXPR186=null;
        CommonTree EXPR_IN_PAREN189=null;
        AliasMasker.expr_return expr165 =null;

        AliasMasker.expr_return expr166 =null;

        AliasMasker.expr_return expr168 =null;

        AliasMasker.expr_return expr169 =null;

        AliasMasker.expr_return expr171 =null;

        AliasMasker.expr_return expr172 =null;

        AliasMasker.expr_return expr174 =null;

        AliasMasker.expr_return expr175 =null;

        AliasMasker.expr_return expr177 =null;

        AliasMasker.expr_return expr178 =null;

        AliasMasker.type_return type180 =null;

        AliasMasker.expr_return expr181 =null;

        AliasMasker.const_expr_return const_expr182 =null;

        AliasMasker.var_expr_return var_expr183 =null;

        AliasMasker.expr_return expr185 =null;

        AliasMasker.type_cast_return type_cast187 =null;

        AliasMasker.expr_return expr188 =null;

        AliasMasker.expr_return expr190 =null;


        CommonTree PLUS164_tree=null;
        CommonTree MINUS167_tree=null;
        CommonTree STAR170_tree=null;
        CommonTree DIV173_tree=null;
        CommonTree PERCENT176_tree=null;
        CommonTree CAST_EXPR179_tree=null;
        CommonTree NEG184_tree=null;
        CommonTree CAST_EXPR186_tree=null;
        CommonTree EXPR_IN_PAREN189_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:330:5: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt50=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt50=1;
                }
                break;
            case MINUS:
                {
                int LA50_2 = input.LA(2);

                if ( (synpred98_AliasMasker()) ) {
                    alt50=2;
                }
                else if ( (synpred103_AliasMasker()) ) {
                    alt50=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt50=3;
                }
                break;
            case DIV:
                {
                alt50=4;
                }
                break;
            case PERCENT:
                {
                alt50=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA50_6 = input.LA(2);

                if ( (synpred102_AliasMasker()) ) {
                    alt50=6;
                }
                else if ( (synpred106_AliasMasker()) ) {
                    alt50=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 6, input);

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
                alt50=7;
                }
                break;
            case CASE:
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
            case BIN_EXPR:
            case FUNC_EVAL:
                {
                alt50=8;
                }
                break;
            case NEG:
                {
                alt50=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt50=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }

            switch (alt50) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:330:7: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS164=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1592); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS164_tree = (CommonTree)adaptor.dupNode(PLUS164);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS164_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1594);
                    expr165=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr165.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1596);
                    expr166=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr166.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:331:7: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS167=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1608); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS167_tree = (CommonTree)adaptor.dupNode(MINUS167);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS167_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1610);
                    expr168=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr168.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1612);
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
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:332:7: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR170=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1624); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR170_tree = (CommonTree)adaptor.dupNode(STAR170);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR170_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1626);
                    expr171=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr171.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1628);
                    expr172=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr172.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:333:7: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV173=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV173_tree = (CommonTree)adaptor.dupNode(DIV173);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV173_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1642);
                    expr174=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr174.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1644);
                    expr175=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr175.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:334:7: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT176=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr1656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT176_tree = (CommonTree)adaptor.dupNode(PERCENT176);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT176_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1658);
                    expr177=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr177.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1660);
                    expr178=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr178.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:335:7: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR179=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1672); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR179_tree = (CommonTree)adaptor.dupNode(CAST_EXPR179);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR179_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr1674);
                    type180=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type180.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1676);
                    expr181=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr181.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:336:7: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr1686);
                    const_expr182=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr182.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:337:7: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr1694);
                    var_expr183=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr183.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:338:7: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG184=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr1704); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG184_tree = (CommonTree)adaptor.dupNode(NEG184);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG184_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1706);
                    expr185=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr185.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:339:7: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR186=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1718); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR186_tree = (CommonTree)adaptor.dupNode(CAST_EXPR186);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR186_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr1720);
                    type_cast187=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast187.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1722);
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
                case 11 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:340:7: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN189=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr1734); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN189_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN189);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN189_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1736);
                    expr190=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr190.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:343:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AliasMasker.type_cast_return type_cast() throws RecognitionException {
        AliasMasker.type_cast_return retval = new AliasMasker.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type191 =null;

        AliasMasker.map_type_return map_type192 =null;

        AliasMasker.tuple_type_cast_return tuple_type_cast193 =null;

        AliasMasker.bag_type_cast_return bag_type_cast194 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:344:5: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt51=4;
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
                alt51=1;
                }
                break;
            case MAP_TYPE:
                {
                alt51=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt51=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt51=4;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:344:7: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast1751);
                    simple_type191=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type191.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:344:21: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast1755);
                    map_type192=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type192.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:344:32: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast1759);
                    tuple_type_cast193=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast193.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:344:50: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast1763);
                    bag_type_cast194=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast194.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:347:1: tuple_type_cast : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final AliasMasker.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AliasMasker.tuple_type_cast_return retval = new AliasMasker.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST195=null;
        AliasMasker.type_cast_return type_cast196 =null;


        CommonTree TUPLE_TYPE_CAST195_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:348:5: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:348:7: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST195=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1778); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST195_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST195);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST195_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:348:26: ( type_cast )*
                loop52:
                do {
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==BIGDECIMAL||LA52_0==BIGINTEGER||LA52_0==BOOLEAN||LA52_0==BYTEARRAY||LA52_0==CHARARRAY||LA52_0==DATETIME||LA52_0==DOUBLE||LA52_0==FLOAT||LA52_0==INT||LA52_0==LONG||LA52_0==BAG_TYPE_CAST||LA52_0==MAP_TYPE||LA52_0==TUPLE_TYPE_CAST) ) {
                        alt52=1;
                    }


                    switch (alt52) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:348:26: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast1780);
                	    type_cast196=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast196.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop52;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:351:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AliasMasker.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AliasMasker.bag_type_cast_return retval = new AliasMasker.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST197=null;
        AliasMasker.tuple_type_cast_return tuple_type_cast198 =null;


        CommonTree BAG_TYPE_CAST197_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:352:5: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:352:7: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST197=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1798); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST197_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST197);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST197_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:352:24: ( tuple_type_cast )?
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==TUPLE_TYPE_CAST) ) {
                    alt53=1;
                }
                switch (alt53) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:352:24: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast1800);
                        tuple_type_cast198=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast198.getTree());


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
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:355:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AliasMasker.var_expr_return var_expr() throws RecognitionException {
        AliasMasker.var_expr_return retval = new AliasMasker.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.projectable_expr_return projectable_expr199 =null;

        AliasMasker.dot_proj_return dot_proj200 =null;

        AliasMasker.pound_proj_return pound_proj201 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:356:5: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:356:7: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr1816);
            projectable_expr199=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr199.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:356:24: ( dot_proj | pound_proj )*
            loop54:
            do {
                int alt54=3;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==PERIOD) ) {
                    alt54=1;
                }
                else if ( (LA54_0==POUND) ) {
                    alt54=2;
                }


                switch (alt54) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:356:26: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr1820);
            	    dot_proj200=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj200.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:356:37: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr1824);
            	    pound_proj201=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj201.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop54;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:359:1: projectable_expr : ( func_eval | col_ref | bin_expr | case_expr );
    public final AliasMasker.projectable_expr_return projectable_expr() throws RecognitionException {
        AliasMasker.projectable_expr_return retval = new AliasMasker.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.func_eval_return func_eval202 =null;

        AliasMasker.col_ref_return col_ref203 =null;

        AliasMasker.bin_expr_return bin_expr204 =null;

        AliasMasker.case_expr_return case_expr205 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:360:5: ( func_eval | col_ref | bin_expr | case_expr )
            int alt55=4;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
                {
                alt55=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt55=2;
                }
                break;
            case BIN_EXPR:
                {
                alt55=3;
                }
                break;
            case CASE:
                {
                alt55=4;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:360:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr1840);
                    func_eval202=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval202.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:360:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr1844);
                    col_ref203=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref203.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:360:29: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr1848);
                    bin_expr204=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr204.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:360:40: case_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr1852);
                    case_expr205=case_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr205.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:363:1: dot_proj : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final AliasMasker.dot_proj_return dot_proj() throws RecognitionException {
        AliasMasker.dot_proj_return retval = new AliasMasker.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD206=null;
        AliasMasker.col_alias_or_index_return col_alias_or_index207 =null;


        CommonTree PERIOD206_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:364:5: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:364:7: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD206=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj1867); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD206_tree = (CommonTree)adaptor.dupNode(PERIOD206);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD206_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:364:17: ( col_alias_or_index )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==CUBE||LA56_0==DOLLARVAR||LA56_0==GROUP||LA56_0==IDENTIFIER) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:364:17: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj1869);
            	    col_alias_or_index207=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index207.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:367:1: col_alias_or_index : ( col_alias | col_index );
    public final AliasMasker.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AliasMasker.col_alias_or_index_return retval = new AliasMasker.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_alias_return col_alias208 =null;

        AliasMasker.col_index_return col_index209 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:367:20: ( col_alias | col_index )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==CUBE||LA57_0==GROUP||LA57_0==IDENTIFIER) ) {
                alt57=1;
            }
            else if ( (LA57_0==DOLLARVAR) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:367:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index1881);
                    col_alias208=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias208.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:367:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index1885);
                    col_index209=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index209.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:370:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AliasMasker.col_alias_return col_alias() throws RecognitionException {
        AliasMasker.col_alias_return retval = new AliasMasker.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set210=null;

        CommonTree set210_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:371:5: ( GROUP | CUBE | IDENTIFIER )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set210=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set210_tree = (CommonTree)adaptor.dupNode(set210);


                adaptor.addChild(root_0, set210_tree);
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
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:376:1: col_index : DOLLARVAR ;
    public final AliasMasker.col_index_return col_index() throws RecognitionException {
        AliasMasker.col_index_return retval = new AliasMasker.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR211=null;

        CommonTree DOLLARVAR211_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:377:5: ( DOLLARVAR )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:377:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR211=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index1927); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR211_tree = (CommonTree)adaptor.dupNode(DOLLARVAR211);


            adaptor.addChild(root_0, DOLLARVAR211_tree);
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
    // $ANTLR end "col_index"


    public static class col_range_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:380:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AliasMasker.col_range_return col_range() throws RecognitionException {
        AliasMasker.col_range_return retval = new AliasMasker.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE212=null;
        CommonTree DOUBLE_PERIOD214=null;
        AliasMasker.col_ref_return col_ref213 =null;

        AliasMasker.col_ref_return col_ref215 =null;


        CommonTree COL_RANGE212_tree=null;
        CommonTree DOUBLE_PERIOD214_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:380:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:380:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE212=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range1938); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE212_tree = (CommonTree)adaptor.dupNode(COL_RANGE212);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE212_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:380:26: ( col_ref )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==CUBE||LA58_0==DOLLARVAR||LA58_0==GROUP||LA58_0==IDENTIFIER) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:380:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range1940);
                    col_ref213=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref213.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD214=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range1943); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD214_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD214);


            adaptor.addChild(root_1, DOUBLE_PERIOD214_tree);
            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:380:49: ( col_ref )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==CUBE||LA59_0==DOLLARVAR||LA59_0==GROUP||LA59_0==IDENTIFIER) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:380:49: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range1945);
                    col_ref215=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref215.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:383:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AliasMasker.pound_proj_return pound_proj() throws RecognitionException {
        AliasMasker.pound_proj_return retval = new AliasMasker.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND216=null;
        CommonTree set217=null;

        CommonTree POUND216_tree=null;
        CommonTree set217_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:384:5: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:384:7: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND216=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj1962); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND216_tree = (CommonTree)adaptor.dupNode(POUND216);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND216_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            set217=(CommonTree)input.LT(1);

            if ( input.LA(1)==NULL||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set217_tree = (CommonTree)adaptor.dupNode(set217);


                adaptor.addChild(root_1, set217_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:387:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AliasMasker.bin_expr_return bin_expr() throws RecognitionException {
        AliasMasker.bin_expr_return retval = new AliasMasker.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR218=null;
        AliasMasker.cond_return cond219 =null;

        AliasMasker.expr_return expr220 =null;

        AliasMasker.expr_return expr221 =null;


        CommonTree BIN_EXPR218_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:388:5: ( ^( BIN_EXPR cond expr expr ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:388:7: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR218=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr1989); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR218_tree = (CommonTree)adaptor.dupNode(BIN_EXPR218);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR218_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr1991);
            cond219=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond219.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr1993);
            expr220=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr220.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr1995);
            expr221=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr221.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:391:1: case_expr : ^( CASE ( expr )+ ) ;
    public final AliasMasker.case_expr_return case_expr() throws RecognitionException {
        AliasMasker.case_expr_return retval = new AliasMasker.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE222=null;
        AliasMasker.expr_return expr223 =null;


        CommonTree CASE222_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:392:5: ( ^( CASE ( expr )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:392:7: ^( CASE ( expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE222=(CommonTree)match(input,CASE,FOLLOW_CASE_in_case_expr2012); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE222_tree = (CommonTree)adaptor.dupNode(CASE222);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE222_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:392:15: ( expr )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==BIGDECIMALNUMBER||LA60_0==BIGINTEGERNUMBER||LA60_0==CASE||LA60_0==CUBE||LA60_0==DIV||LA60_0==DOLLARVAR||LA60_0==DOUBLENUMBER||LA60_0==FALSE||LA60_0==FLOATNUMBER||LA60_0==GROUP||LA60_0==IDENTIFIER||LA60_0==INTEGER||LA60_0==LONGINTEGER||LA60_0==MINUS||LA60_0==NULL||LA60_0==PERCENT||LA60_0==PLUS||LA60_0==QUOTEDSTRING||LA60_0==STAR||LA60_0==TRUE||(LA60_0 >= BAG_VAL && LA60_0 <= BIN_EXPR)||LA60_0==CAST_EXPR||LA60_0==EXPR_IN_PAREN||LA60_0==FUNC_EVAL||(LA60_0 >= MAP_VAL && LA60_0 <= NEG)||LA60_0==TUPLE_VAL) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:392:15: expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2014);
            	    expr223=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, expr223.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
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
    // $ANTLR end "case_expr"


    public static class limit_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:395:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AliasMasker.limit_clause_return limit_clause() throws RecognitionException {
        AliasMasker.limit_clause_return retval = new AliasMasker.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT224=null;
        CommonTree INTEGER226=null;
        CommonTree LONGINTEGER227=null;
        AliasMasker.rel_return rel225 =null;

        AliasMasker.expr_return expr228 =null;


        CommonTree LIMIT224_tree=null;
        CommonTree INTEGER226_tree=null;
        CommonTree LONGINTEGER227_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:396:5: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:396:7: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT224=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2032); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT224_tree = (CommonTree)adaptor.dupNode(LIMIT224);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT224_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2034);
            rel225=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel225.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:396:20: ( INTEGER | LONGINTEGER | expr )
            int alt61=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA61_1 = input.LA(2);

                if ( (synpred125_AliasMasker()) ) {
                    alt61=1;
                }
                else if ( (true) ) {
                    alt61=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA61_2 = input.LA(2);

                if ( (synpred126_AliasMasker()) ) {
                    alt61=2;
                }
                else if ( (true) ) {
                    alt61=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 2, input);

                    throw nvae;

                }
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CASE:
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
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }

            switch (alt61) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:396:22: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER226=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2038); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER226_tree = (CommonTree)adaptor.dupNode(INTEGER226);


                    adaptor.addChild(root_1, INTEGER226_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:396:32: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER227=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2042); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER227_tree = (CommonTree)adaptor.dupNode(LONGINTEGER227);


                    adaptor.addChild(root_1, LONGINTEGER227_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:396:46: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2046);
                    expr228=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr228.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:399:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AliasMasker.sample_clause_return sample_clause() throws RecognitionException {
        AliasMasker.sample_clause_return retval = new AliasMasker.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE229=null;
        CommonTree DOUBLENUMBER231=null;
        AliasMasker.rel_return rel230 =null;

        AliasMasker.expr_return expr232 =null;


        CommonTree SAMPLE229_tree=null;
        CommonTree DOUBLENUMBER231_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:400:5: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:400:8: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE229=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2066); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE229_tree = (CommonTree)adaptor.dupNode(SAMPLE229);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE229_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2068);
            rel230=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel230.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:400:22: ( DOUBLENUMBER | expr )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==DOUBLENUMBER) ) {
                int LA62_1 = input.LA(2);

                if ( (synpred127_AliasMasker()) ) {
                    alt62=1;
                }
                else if ( (true) ) {
                    alt62=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA62_0==BIGDECIMALNUMBER||LA62_0==BIGINTEGERNUMBER||LA62_0==CASE||LA62_0==CUBE||LA62_0==DIV||LA62_0==DOLLARVAR||LA62_0==FALSE||LA62_0==FLOATNUMBER||LA62_0==GROUP||LA62_0==IDENTIFIER||LA62_0==INTEGER||LA62_0==LONGINTEGER||LA62_0==MINUS||LA62_0==NULL||LA62_0==PERCENT||LA62_0==PLUS||LA62_0==QUOTEDSTRING||LA62_0==STAR||LA62_0==TRUE||(LA62_0 >= BAG_VAL && LA62_0 <= BIN_EXPR)||LA62_0==CAST_EXPR||LA62_0==EXPR_IN_PAREN||LA62_0==FUNC_EVAL||(LA62_0 >= MAP_VAL && LA62_0 <= NEG)||LA62_0==TUPLE_VAL) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }
            switch (alt62) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:400:24: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER231=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2072); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER231_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER231);


                    adaptor.addChild(root_1, DOUBLENUMBER231_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:400:39: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2076);
                    expr232=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr232.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:403:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AliasMasker.rank_clause_return rank_clause() throws RecognitionException {
        AliasMasker.rank_clause_return retval = new AliasMasker.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK233=null;
        AliasMasker.rel_return rel234 =null;

        AliasMasker.rank_by_statement_return rank_by_statement235 =null;


        CommonTree RANK233_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:404:2: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:404:4: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK233=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause2092); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK233_tree = (CommonTree)adaptor.dupNode(RANK233);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK233_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause2094);
            rel234=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel234.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:404:16: ( rank_by_statement )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==BY) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:404:18: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause2098);
                    rank_by_statement235=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement235.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:407:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AliasMasker.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AliasMasker.rank_by_statement_return retval = new AliasMasker.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY236=null;
        CommonTree DENSE238=null;
        AliasMasker.rank_by_clause_return rank_by_clause237 =null;


        CommonTree BY236_tree=null;
        CommonTree DENSE238_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:408:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:408:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY236=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement2115); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY236_tree = (CommonTree)adaptor.dupNode(BY236);


            root_1 = (CommonTree)adaptor.becomeRoot(BY236_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement2117);
            rank_by_clause237=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause237.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:408:25: ( DENSE )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==DENSE) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:408:27: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE238=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement2121); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE238_tree = (CommonTree)adaptor.dupNode(DENSE238);


                    adaptor.addChild(root_1, DENSE238_tree);
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
    // $ANTLR end "rank_by_statement"


    public static class rank_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:411:1: rank_by_clause : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final AliasMasker.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AliasMasker.rank_by_clause_return retval = new AliasMasker.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR239=null;
        CommonTree set240=null;
        AliasMasker.rank_col_return rank_col241 =null;


        CommonTree STAR239_tree=null;
        CommonTree set240_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:412:2: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==STAR) ) {
                alt67=1;
            }
            else if ( (LA67_0==CUBE||LA67_0==DOLLARVAR||LA67_0==GROUP||LA67_0==IDENTIFIER||LA67_0==COL_RANGE) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }
            switch (alt67) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:412:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR239=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause2136); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR239_tree = (CommonTree)adaptor.dupNode(STAR239);


                    adaptor.addChild(root_0, STAR239_tree);
                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:412:9: ( ASC | DESC )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==ASC||LA65_0==DESC) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set240=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set240_tree = (CommonTree)adaptor.dupNode(set240);


                                adaptor.addChild(root_0, set240_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:413:7: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:413:7: ( rank_col )+
                    int cnt66=0;
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==CUBE||LA66_0==DOLLARVAR||LA66_0==GROUP||LA66_0==IDENTIFIER||LA66_0==COL_RANGE) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:413:7: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause2155);
                    	    rank_col241=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col241.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt66 >= 1 ) break loop66;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(66, input);
                                throw eee;
                        }
                        cnt66++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:416:1: rank_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AliasMasker.rank_col_return rank_col() throws RecognitionException {
        AliasMasker.rank_col_return retval = new AliasMasker.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set244=null;
        AliasMasker.col_range_return col_range242 =null;

        AliasMasker.col_ref_return col_ref243 =null;


        CommonTree set244_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:417:2: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:417:4: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:417:4: ( col_range | col_ref )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==COL_RANGE) ) {
                alt68=1;
            }
            else if ( (LA68_0==CUBE||LA68_0==DOLLARVAR||LA68_0==GROUP||LA68_0==IDENTIFIER) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;

            }
            switch (alt68) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:417:6: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col2168);
                    col_range242=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range242.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:417:18: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col2172);
                    col_ref243=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref243.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:417:28: ( ASC | DESC )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==ASC||LA69_0==DESC) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set244=(CommonTree)input.LT(1);

                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set244_tree = (CommonTree)adaptor.dupNode(set244);


                        adaptor.addChild(root_0, set244_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:420:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AliasMasker.order_clause_return order_clause() throws RecognitionException {
        AliasMasker.order_clause_return retval = new AliasMasker.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER245=null;
        AliasMasker.rel_return rel246 =null;

        AliasMasker.order_by_clause_return order_by_clause247 =null;

        AliasMasker.func_clause_return func_clause248 =null;


        CommonTree ORDER245_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:421:5: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:421:7: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER245=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause2200); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER245_tree = (CommonTree)adaptor.dupNode(ORDER245);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER245_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause2202);
            rel246=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel246.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause2204);
            order_by_clause247=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause247.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:421:36: ( func_clause )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==FUNC||LA70_0==FUNC_REF) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:421:36: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause2206);
                    func_clause248=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause248.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:424:1: order_by_clause : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final AliasMasker.order_by_clause_return order_by_clause() throws RecognitionException {
        AliasMasker.order_by_clause_return retval = new AliasMasker.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR249=null;
        CommonTree set250=null;
        AliasMasker.order_col_return order_col251 =null;


        CommonTree STAR249_tree=null;
        CommonTree set250_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:425:5: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==STAR) ) {
                alt73=1;
            }
            else if ( (LA73_0==CUBE||LA73_0==DOLLARVAR||LA73_0==GROUP||LA73_0==IDENTIFIER||LA73_0==COL_RANGE) ) {
                alt73=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;

            }
            switch (alt73) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:425:7: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR249=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause2222); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR249_tree = (CommonTree)adaptor.dupNode(STAR249);


                    adaptor.addChild(root_0, STAR249_tree);
                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:425:12: ( ASC | DESC )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==ASC||LA71_0==DESC) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set250=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set250_tree = (CommonTree)adaptor.dupNode(set250);


                                adaptor.addChild(root_0, set250_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:426:7: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:426:7: ( order_col )+
                    int cnt72=0;
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==CUBE||LA72_0==DOLLARVAR||LA72_0==GROUP||LA72_0==IDENTIFIER||LA72_0==COL_RANGE) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:426:7: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause2241);
                    	    order_col251=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col251.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:429:1: order_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AliasMasker.order_col_return order_col() throws RecognitionException {
        AliasMasker.order_col_return retval = new AliasMasker.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set254=null;
        AliasMasker.col_range_return col_range252 =null;

        AliasMasker.col_ref_return col_ref253 =null;


        CommonTree set254_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:430:5: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:430:7: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:430:7: ( col_range | col_ref )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==COL_RANGE) ) {
                alt74=1;
            }
            else if ( (LA74_0==CUBE||LA74_0==DOLLARVAR||LA74_0==GROUP||LA74_0==IDENTIFIER) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:430:8: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col2256);
                    col_range252=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range252.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:430:20: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col2260);
                    col_ref253=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref253.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:430:29: ( ASC | DESC )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==ASC||LA75_0==DESC) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set254=(CommonTree)input.LT(1);

                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set254_tree = (CommonTree)adaptor.dupNode(set254);


                        adaptor.addChild(root_0, set254_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:433:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AliasMasker.distinct_clause_return distinct_clause() throws RecognitionException {
        AliasMasker.distinct_clause_return retval = new AliasMasker.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT255=null;
        AliasMasker.rel_return rel256 =null;

        AliasMasker.partition_clause_return partition_clause257 =null;


        CommonTree DISTINCT255_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:434:5: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:434:7: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT255=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause2287); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT255_tree = (CommonTree)adaptor.dupNode(DISTINCT255);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT255_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause2289);
            rel256=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel256.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:434:23: ( partition_clause )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==PARTITION) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:434:23: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause2291);
                    partition_clause257=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause257.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:437:1: partition_clause : ^( PARTITION func_name ) ;
    public final AliasMasker.partition_clause_return partition_clause() throws RecognitionException {
        AliasMasker.partition_clause_return retval = new AliasMasker.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION258=null;
        AliasMasker.func_name_return func_name259 =null;


        CommonTree PARTITION258_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:438:5: ( ^( PARTITION func_name ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:438:7: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION258=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause2309); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION258_tree = (CommonTree)adaptor.dupNode(PARTITION258);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION258_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause2311);
            func_name259=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name259.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:441:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AliasMasker.cross_clause_return cross_clause() throws RecognitionException {
        AliasMasker.cross_clause_return retval = new AliasMasker.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS260=null;
        AliasMasker.rel_list_return rel_list261 =null;

        AliasMasker.partition_clause_return partition_clause262 =null;


        CommonTree CROSS260_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:442:5: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:442:7: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS260=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause2328); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS260_tree = (CommonTree)adaptor.dupNode(CROSS260);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS260_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause2330);
            rel_list261=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list261.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:442:25: ( partition_clause )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==PARTITION) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:442:25: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause2332);
                    partition_clause262=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause262.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:445:1: rel_list : ( rel )+ ;
    public final AliasMasker.rel_list_return rel_list() throws RecognitionException {
        AliasMasker.rel_list_return retval = new AliasMasker.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.rel_return rel263 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:446:5: ( ( rel )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:446:7: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:446:7: ( rel )+
            int cnt78=0;
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==COGROUP||(LA78_0 >= CROSS && LA78_0 <= CUBE)||LA78_0==DEFINE||LA78_0==DISTINCT||LA78_0==FILTER||LA78_0==FOREACH||LA78_0==GROUP||LA78_0==IDENTIFIER||LA78_0==JOIN||(LA78_0 >= LIMIT && LA78_0 <= LOAD)||LA78_0==MAPREDUCE||LA78_0==ORDER||LA78_0==RANK||LA78_0==SAMPLE||LA78_0==SPLIT||(LA78_0 >= STORE && LA78_0 <= STREAM)||LA78_0==UNION) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:446:7: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list2348);
            	    rel263=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel263.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt78 >= 1 ) break loop78;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(78, input);
                        throw eee;
                }
                cnt78++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:449:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AliasMasker.join_clause_return join_clause() throws RecognitionException {
        AliasMasker.join_clause_return retval = new AliasMasker.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN264=null;
        AliasMasker.join_sub_clause_return join_sub_clause265 =null;

        AliasMasker.join_type_return join_type266 =null;

        AliasMasker.partition_clause_return partition_clause267 =null;


        CommonTree JOIN264_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:450:5: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:450:7: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN264=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause2364); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN264_tree = (CommonTree)adaptor.dupNode(JOIN264);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN264_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause2366);
            join_sub_clause265=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause265.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:450:31: ( join_type )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==QUOTEDSTRING) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:450:31: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause2368);
                    join_type266=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type266.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:450:42: ( partition_clause )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==PARTITION) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:450:42: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause2371);
                    partition_clause267=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause267.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:453:1: join_type : QUOTEDSTRING ;
    public final AliasMasker.join_type_return join_type() throws RecognitionException {
        AliasMasker.join_type_return retval = new AliasMasker.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING268=null;

        CommonTree QUOTEDSTRING268_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:453:11: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:453:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING268=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2383); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING268_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING268);


            adaptor.addChild(root_0, QUOTEDSTRING268_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:456:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final AliasMasker.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AliasMasker.join_sub_clause_return retval = new AliasMasker.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set270=null;
        CommonTree OUTER271=null;
        AliasMasker.join_item_return join_item269 =null;

        AliasMasker.join_item_return join_item272 =null;

        AliasMasker.join_item_return join_item273 =null;


        CommonTree set270_tree=null;
        CommonTree OUTER271_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:457:5: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==JOIN_ITEM) ) {
                int LA83_1 = input.LA(2);

                if ( (synpred153_AliasMasker()) ) {
                    alt83=1;
                }
                else if ( (true) ) {
                    alt83=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;

            }
            switch (alt83) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:457:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2396);
                    join_item269=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item269.getTree());


                    _last = (CommonTree)input.LT(1);
                    set270=(CommonTree)input.LT(1);

                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set270_tree = (CommonTree)adaptor.dupNode(set270);


                        adaptor.addChild(root_0, set270_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:460:16: ( OUTER )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==OUTER) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:460:16: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER271=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2451); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER271_tree = (CommonTree)adaptor.dupNode(OUTER271);


                            adaptor.addChild(root_0, OUTER271_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2454);
                    join_item272=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item272.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:461:7: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:461:7: ( join_item )+
                    int cnt82=0;
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==JOIN_ITEM) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:461:7: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2462);
                    	    join_item273=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item273.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt82 >= 1 ) break loop82;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(82, input);
                                throw eee;
                        }
                        cnt82++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:464:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AliasMasker.join_item_return join_item() throws RecognitionException {
        AliasMasker.join_item_return retval = new AliasMasker.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM274=null;
        AliasMasker.rel_return rel275 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause276 =null;


        CommonTree JOIN_ITEM274_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:465:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:465:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM274=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2475); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM274_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM274);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM274_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2477);
            rel275=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel275.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2479);
            join_group_by_clause276=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause276.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:468:1: join_group_by_clause : ^( BY ( join_group_by_expr )+ ) ;
    public final AliasMasker.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AliasMasker.join_group_by_clause_return retval = new AliasMasker.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY277=null;
        AliasMasker.join_group_by_expr_return join_group_by_expr278 =null;


        CommonTree BY277_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:469:5: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:469:7: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY277=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2496); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY277_tree = (CommonTree)adaptor.dupNode(BY277);


            root_1 = (CommonTree)adaptor.becomeRoot(BY277_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:469:13: ( join_group_by_expr )+
            int cnt84=0;
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==BIGDECIMALNUMBER||LA84_0==BIGINTEGERNUMBER||LA84_0==CASE||LA84_0==CUBE||LA84_0==DIV||LA84_0==DOLLARVAR||LA84_0==DOUBLENUMBER||LA84_0==FALSE||LA84_0==FLOATNUMBER||LA84_0==GROUP||LA84_0==IDENTIFIER||LA84_0==INTEGER||LA84_0==LONGINTEGER||LA84_0==MINUS||LA84_0==NULL||LA84_0==PERCENT||LA84_0==PLUS||LA84_0==QUOTEDSTRING||LA84_0==STAR||LA84_0==TRUE||(LA84_0 >= BAG_VAL && LA84_0 <= BIN_EXPR)||(LA84_0 >= CAST_EXPR && LA84_0 <= EXPR_IN_PAREN)||LA84_0==FUNC_EVAL||(LA84_0 >= MAP_VAL && LA84_0 <= NEG)||LA84_0==TUPLE_VAL) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:469:13: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2498);
            	    join_group_by_expr278=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr278.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt84 >= 1 ) break loop84;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(84, input);
                        throw eee;
                }
                cnt84++;
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:472:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AliasMasker.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AliasMasker.join_group_by_expr_return retval = new AliasMasker.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR281=null;
        AliasMasker.col_range_return col_range279 =null;

        AliasMasker.expr_return expr280 =null;


        CommonTree STAR281_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:473:5: ( col_range | expr | STAR )
            int alt85=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt85=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CASE:
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
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt85=2;
                }
                break;
            case STAR:
                {
                int LA85_3 = input.LA(2);

                if ( (LA85_3==DOWN) ) {
                    alt85=2;
                }
                else if ( (LA85_3==EOF||LA85_3==UP||LA85_3==BIGDECIMALNUMBER||LA85_3==BIGINTEGERNUMBER||LA85_3==CASE||LA85_3==CUBE||LA85_3==DIV||LA85_3==DOLLARVAR||LA85_3==DOUBLENUMBER||LA85_3==FALSE||LA85_3==FLOATNUMBER||LA85_3==GROUP||LA85_3==IDENTIFIER||LA85_3==INTEGER||LA85_3==LONGINTEGER||LA85_3==MINUS||LA85_3==NULL||LA85_3==PERCENT||LA85_3==PLUS||LA85_3==QUOTEDSTRING||LA85_3==STAR||LA85_3==TRUE||(LA85_3 >= BAG_VAL && LA85_3 <= BIN_EXPR)||(LA85_3 >= CAST_EXPR && LA85_3 <= EXPR_IN_PAREN)||LA85_3==FUNC_EVAL||(LA85_3 >= MAP_VAL && LA85_3 <= NEG)||LA85_3==TUPLE_VAL) ) {
                    alt85=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 85, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;

            }

            switch (alt85) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:473:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2514);
                    col_range279=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range279.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:473:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2518);
                    expr280=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr280.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:473:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR281=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2522); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR281_tree = (CommonTree)adaptor.dupNode(STAR281);


                    adaptor.addChild(root_0, STAR281_tree);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:476:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AliasMasker.union_clause_return union_clause() throws RecognitionException {
        AliasMasker.union_clause_return retval = new AliasMasker.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION282=null;
        CommonTree ONSCHEMA283=null;
        AliasMasker.rel_list_return rel_list284 =null;


        CommonTree UNION282_tree=null;
        CommonTree ONSCHEMA283_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:477:5: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:477:7: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION282=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2537); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION282_tree = (CommonTree)adaptor.dupNode(UNION282);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION282_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:477:16: ( ONSCHEMA )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==ONSCHEMA) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:477:16: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA283=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2539); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA283_tree = (CommonTree)adaptor.dupNode(ONSCHEMA283);


                    adaptor.addChild(root_1, ONSCHEMA283_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2542);
            rel_list284=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list284.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:480:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AliasMasker.foreach_clause_return foreach_clause() throws RecognitionException {
        AliasMasker.foreach_clause_return retval = new AliasMasker.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH285=null;
        AliasMasker.rel_return rel286 =null;

        AliasMasker.foreach_plan_return foreach_plan287 =null;


        CommonTree FOREACH285_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:481:5: ( ^( FOREACH rel foreach_plan ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:481:7: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH285=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2559); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH285_tree = (CommonTree)adaptor.dupNode(FOREACH285);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH285_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2561);
            rel286=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel286.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2563);
            foreach_plan287=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan287.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:484:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AliasMasker.foreach_plan_return foreach_plan() throws RecognitionException {
        AliasMasker.foreach_plan_return retval = new AliasMasker.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE288=null;
        CommonTree FOREACH_PLAN_COMPLEX290=null;
        AliasMasker.generate_clause_return generate_clause289 =null;

        AliasMasker.nested_blk_return nested_blk291 =null;


        CommonTree FOREACH_PLAN_SIMPLE288_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX290_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:485:5: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==FOREACH_PLAN_SIMPLE) ) {
                alt87=1;
            }
            else if ( (LA87_0==FOREACH_PLAN_COMPLEX) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:485:7: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE288=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2580); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE288_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE288);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE288_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2582);
                    generate_clause289=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause289.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:486:7: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX290=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2594); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX290_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX290);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX290_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2596);
                    nested_blk291=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk291.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:489:1: nested_blk : ( nested_command )* generate_clause ;
    public final AliasMasker.nested_blk_return nested_blk() throws RecognitionException {
        AliasMasker.nested_blk_return retval = new AliasMasker.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_command_return nested_command292 =null;

        AliasMasker.generate_clause_return generate_clause293 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:490:5: ( ( nested_command )* generate_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:490:7: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:490:7: ( nested_command )*
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( ((LA88_0 >= NESTED_CMD && LA88_0 <= NESTED_CMD_ASSI)) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:490:7: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2611);
            	    nested_command292=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command292.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop88;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2614);
            generate_clause293=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause293.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:493:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final AliasMasker.generate_clause_return generate_clause() throws RecognitionException {
        AliasMasker.generate_clause_return retval = new AliasMasker.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE294=null;
        AliasMasker.flatten_generated_item_return flatten_generated_item295 =null;


        CommonTree GENERATE294_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:494:5: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:494:7: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE294=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2629); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE294_tree = (CommonTree)adaptor.dupNode(GENERATE294);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE294_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:494:19: ( flatten_generated_item )+
            int cnt89=0;
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==BIGDECIMALNUMBER||LA89_0==BIGINTEGERNUMBER||LA89_0==CASE||LA89_0==CUBE||LA89_0==DIV||LA89_0==DOLLARVAR||LA89_0==DOUBLENUMBER||LA89_0==FALSE||LA89_0==FLATTEN||LA89_0==FLOATNUMBER||LA89_0==GROUP||LA89_0==IDENTIFIER||LA89_0==INTEGER||LA89_0==LONGINTEGER||LA89_0==MINUS||LA89_0==NULL||LA89_0==PERCENT||LA89_0==PLUS||LA89_0==QUOTEDSTRING||LA89_0==STAR||LA89_0==TRUE||(LA89_0 >= BAG_VAL && LA89_0 <= BIN_EXPR)||(LA89_0 >= CAST_EXPR && LA89_0 <= EXPR_IN_PAREN)||LA89_0==FUNC_EVAL||(LA89_0 >= MAP_VAL && LA89_0 <= NEG)||LA89_0==TUPLE_VAL) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:494:19: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause2631);
            	    flatten_generated_item295=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item295.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt89 >= 1 ) break loop89;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(89, input);
                        throw eee;
                }
                cnt89++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:497:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AliasMasker.nested_command_return nested_command() throws RecognitionException {
        AliasMasker.nested_command_return retval = new AliasMasker.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD296=null;
        CommonTree IDENTIFIER297=null;
        CommonTree NESTED_CMD_ASSI299=null;
        CommonTree IDENTIFIER300=null;
        AliasMasker.nested_op_return nested_op298 =null;

        AliasMasker.expr_return expr301 =null;


        CommonTree NESTED_CMD296_tree=null;
        CommonTree IDENTIFIER297_tree=null;
        CommonTree NESTED_CMD_ASSI299_tree=null;
        CommonTree IDENTIFIER300_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:498:5: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==NESTED_CMD) ) {
                alt90=1;
            }
            else if ( (LA90_0==NESTED_CMD_ASSI) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:498:7: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD296=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command2649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD296_tree = (CommonTree)adaptor.dupNode(NESTED_CMD296);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD296_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER297=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER297_tree = (CommonTree)adaptor.dupNode(IDENTIFIER297);


                    adaptor.addChild(root_1, IDENTIFIER297_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command2653);
                    nested_op298=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op298.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:499:7: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI299=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command2665); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI299_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI299);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI299_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER300=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER300_tree = (CommonTree)adaptor.dupNode(IDENTIFIER300);


                    adaptor.addChild(root_1, IDENTIFIER300_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command2669);
                    expr301=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr301.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:502:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AliasMasker.nested_op_return nested_op() throws RecognitionException {
        AliasMasker.nested_op_return retval = new AliasMasker.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_proj_return nested_proj302 =null;

        AliasMasker.nested_filter_return nested_filter303 =null;

        AliasMasker.nested_sort_return nested_sort304 =null;

        AliasMasker.nested_distinct_return nested_distinct305 =null;

        AliasMasker.nested_limit_return nested_limit306 =null;

        AliasMasker.nested_cross_return nested_cross307 =null;

        AliasMasker.nested_foreach_return nested_foreach308 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:502:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt91=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt91=1;
                }
                break;
            case FILTER:
                {
                alt91=2;
                }
                break;
            case ORDER:
                {
                alt91=3;
                }
                break;
            case DISTINCT:
                {
                alt91=4;
                }
                break;
            case LIMIT:
                {
                alt91=5;
                }
                break;
            case CROSS:
                {
                alt91=6;
                }
                break;
            case FOREACH:
                {
                alt91=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;

            }

            switch (alt91) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:502:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op2680);
                    nested_proj302=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj302.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:503:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op2694);
                    nested_filter303=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter303.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:504:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op2708);
                    nested_sort304=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort304.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:505:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op2722);
                    nested_distinct305=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct305.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:506:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op2736);
                    nested_limit306=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit306.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:507:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op2750);
                    nested_cross307=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross307.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:508:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op2764);
                    nested_foreach308=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach308.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:511:1: nested_proj : ^( NESTED_PROJ col_ref ( col_ref )+ ) ;
    public final AliasMasker.nested_proj_return nested_proj() throws RecognitionException {
        AliasMasker.nested_proj_return retval = new AliasMasker.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ309=null;
        AliasMasker.col_ref_return col_ref310 =null;

        AliasMasker.col_ref_return col_ref311 =null;


        CommonTree NESTED_PROJ309_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:512:5: ( ^( NESTED_PROJ col_ref ( col_ref )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:512:7: ^( NESTED_PROJ col_ref ( col_ref )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ309=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj2779); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ309_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ309);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ309_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj2781);
            col_ref310=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref310.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:512:30: ( col_ref )+
            int cnt92=0;
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==CUBE||LA92_0==DOLLARVAR||LA92_0==GROUP||LA92_0==IDENTIFIER) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:512:30: col_ref
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj2783);
            	    col_ref311=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref311.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt92 >= 1 ) break loop92;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(92, input);
                        throw eee;
                }
                cnt92++;
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
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:515:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AliasMasker.nested_filter_return nested_filter() throws RecognitionException {
        AliasMasker.nested_filter_return retval = new AliasMasker.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER312=null;
        AliasMasker.nested_op_input_return nested_op_input313 =null;

        AliasMasker.cond_return cond314 =null;


        CommonTree FILTER312_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:516:5: ( ^( FILTER nested_op_input cond ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:516:7: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER312=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter2801); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER312_tree = (CommonTree)adaptor.dupNode(FILTER312);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER312_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter2803);
            nested_op_input313=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input313.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter2805);
            cond314=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond314.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:519:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AliasMasker.nested_sort_return nested_sort() throws RecognitionException {
        AliasMasker.nested_sort_return retval = new AliasMasker.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER315=null;
        AliasMasker.nested_op_input_return nested_op_input316 =null;

        AliasMasker.order_by_clause_return order_by_clause317 =null;

        AliasMasker.func_clause_return func_clause318 =null;


        CommonTree ORDER315_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:520:5: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:520:7: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER315=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort2822); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER315_tree = (CommonTree)adaptor.dupNode(ORDER315);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER315_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort2824);
            nested_op_input316=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input316.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort2826);
            order_by_clause317=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause317.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:520:48: ( func_clause )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==FUNC||LA93_0==FUNC_REF) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:520:48: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort2828);
                    func_clause318=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause318.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:523:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AliasMasker.nested_distinct_return nested_distinct() throws RecognitionException {
        AliasMasker.nested_distinct_return retval = new AliasMasker.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT319=null;
        AliasMasker.nested_op_input_return nested_op_input320 =null;


        CommonTree DISTINCT319_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:524:5: ( ^( DISTINCT nested_op_input ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:524:7: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT319=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct2846); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT319_tree = (CommonTree)adaptor.dupNode(DISTINCT319);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT319_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct2848);
            nested_op_input320=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input320.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:527:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AliasMasker.nested_limit_return nested_limit() throws RecognitionException {
        AliasMasker.nested_limit_return retval = new AliasMasker.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT321=null;
        CommonTree INTEGER323=null;
        AliasMasker.nested_op_input_return nested_op_input322 =null;

        AliasMasker.expr_return expr324 =null;


        CommonTree LIMIT321_tree=null;
        CommonTree INTEGER323_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:528:5: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:528:7: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT321=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit2865); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT321_tree = (CommonTree)adaptor.dupNode(LIMIT321);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT321_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit2867);
            nested_op_input322=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input322.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:528:32: ( INTEGER | expr )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==INTEGER) ) {
                int LA94_1 = input.LA(2);

                if ( (synpred171_AliasMasker()) ) {
                    alt94=1;
                }
                else if ( (true) ) {
                    alt94=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 94, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA94_0==BIGDECIMALNUMBER||LA94_0==BIGINTEGERNUMBER||LA94_0==CASE||LA94_0==CUBE||LA94_0==DIV||LA94_0==DOLLARVAR||LA94_0==DOUBLENUMBER||LA94_0==FALSE||LA94_0==FLOATNUMBER||LA94_0==GROUP||LA94_0==IDENTIFIER||LA94_0==LONGINTEGER||LA94_0==MINUS||LA94_0==NULL||LA94_0==PERCENT||LA94_0==PLUS||LA94_0==QUOTEDSTRING||LA94_0==STAR||LA94_0==TRUE||(LA94_0 >= BAG_VAL && LA94_0 <= BIN_EXPR)||LA94_0==CAST_EXPR||LA94_0==EXPR_IN_PAREN||LA94_0==FUNC_EVAL||(LA94_0 >= MAP_VAL && LA94_0 <= NEG)||LA94_0==TUPLE_VAL) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;

            }
            switch (alt94) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:528:34: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER323=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit2871); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER323_tree = (CommonTree)adaptor.dupNode(INTEGER323);


                    adaptor.addChild(root_1, INTEGER323_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:528:44: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit2875);
                    expr324=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr324.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:531:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AliasMasker.nested_cross_return nested_cross() throws RecognitionException {
        AliasMasker.nested_cross_return retval = new AliasMasker.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS325=null;
        AliasMasker.nested_op_input_list_return nested_op_input_list326 =null;


        CommonTree CROSS325_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:531:14: ( ^( CROSS nested_op_input_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:531:16: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS325=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross2890); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS325_tree = (CommonTree)adaptor.dupNode(CROSS325);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS325_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross2892);
            nested_op_input_list326=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list326.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:534:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AliasMasker.nested_foreach_return nested_foreach() throws RecognitionException {
        AliasMasker.nested_foreach_return retval = new AliasMasker.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH327=null;
        AliasMasker.nested_op_input_return nested_op_input328 =null;

        AliasMasker.generate_clause_return generate_clause329 =null;


        CommonTree FOREACH327_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:534:16: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:534:18: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH327=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach2905); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH327_tree = (CommonTree)adaptor.dupNode(FOREACH327);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH327_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach2907);
            nested_op_input328=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input328.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach2909);
            generate_clause329=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause329.getTree());


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


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:537:1: nested_op_input_list : ( nested_op_input )+ ;
    public final AliasMasker.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AliasMasker.nested_op_input_list_return retval = new AliasMasker.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_op_input_return nested_op_input330 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:537:22: ( ( nested_op_input )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:537:24: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:537:24: ( nested_op_input )+
            int cnt95=0;
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==CUBE||LA95_0==DOLLARVAR||LA95_0==GROUP||LA95_0==IDENTIFIER||LA95_0==NESTED_PROJ) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:537:24: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list2920);
            	    nested_op_input330=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input330.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt95 >= 1 ) break loop95;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(95, input);
                        throw eee;
                }
                cnt95++;
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


    public static class nested_op_input_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:540:1: nested_op_input : ( col_ref | nested_proj );
    public final AliasMasker.nested_op_input_return nested_op_input() throws RecognitionException {
        AliasMasker.nested_op_input_return retval = new AliasMasker.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_ref_return col_ref331 =null;

        AliasMasker.nested_proj_return nested_proj332 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:540:17: ( col_ref | nested_proj )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==CUBE||LA96_0==DOLLARVAR||LA96_0==GROUP||LA96_0==IDENTIFIER) ) {
                alt96=1;
            }
            else if ( (LA96_0==NESTED_PROJ) ) {
                alt96=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;

            }
            switch (alt96) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:540:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input2930);
                    col_ref331=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref331.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:540:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input2934);
                    nested_proj332=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj332.getTree());


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


    public static class stream_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:543:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AliasMasker.stream_clause_return stream_clause() throws RecognitionException {
        AliasMasker.stream_clause_return retval = new AliasMasker.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM333=null;
        CommonTree set335=null;
        AliasMasker.rel_return rel334 =null;

        AliasMasker.as_clause_return as_clause336 =null;


        CommonTree STREAM333_tree=null;
        CommonTree set335_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:544:5: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:544:7: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM333=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause2949); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM333_tree = (CommonTree)adaptor.dupNode(STREAM333);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM333_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause2951);
            rel334=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel334.getTree());


            _last = (CommonTree)input.LT(1);
            set335=(CommonTree)input.LT(1);

            if ( input.LA(1)==EXECCOMMAND||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set335_tree = (CommonTree)adaptor.dupNode(set335);


                adaptor.addChild(root_1, set335_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:544:50: ( as_clause )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==AS) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:544:50: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause2963);
                    as_clause336=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause336.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:547:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AliasMasker.mr_clause_return mr_clause() throws RecognitionException {
        AliasMasker.mr_clause_return retval = new AliasMasker.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE337=null;
        CommonTree QUOTEDSTRING338=null;
        CommonTree EXECCOMMAND342=null;
        AliasMasker.path_list_return path_list339 =null;

        AliasMasker.store_clause_return store_clause340 =null;

        AliasMasker.load_clause_return load_clause341 =null;


        CommonTree MAPREDUCE337_tree=null;
        CommonTree QUOTEDSTRING338_tree=null;
        CommonTree EXECCOMMAND342_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:548:5: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:548:7: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE337=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause2981); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE337_tree = (CommonTree)adaptor.dupNode(MAPREDUCE337);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE337_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING338=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause2983); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING338_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING338);


            adaptor.addChild(root_1, QUOTEDSTRING338_tree);
            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:548:33: ( path_list )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==QUOTEDSTRING) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:548:33: path_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause2985);
                    path_list339=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list339.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause2988);
            store_clause340=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause340.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause2990);
            load_clause341=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause341.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:548:69: ( EXECCOMMAND )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==EXECCOMMAND) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:548:69: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND342=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause2992); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND342_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND342);


                    adaptor.addChild(root_1, EXECCOMMAND342_tree);
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
    // $ANTLR end "mr_clause"


    public static class split_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:551:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final AliasMasker.split_clause_return split_clause() throws RecognitionException {
        AliasMasker.split_clause_return retval = new AliasMasker.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT343=null;
        AliasMasker.rel_return rel344 =null;

        AliasMasker.split_branch_return split_branch345 =null;

        AliasMasker.split_otherwise_return split_otherwise346 =null;


        CommonTree SPLIT343_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:552:5: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:552:7: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT343=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause3010); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT343_tree = (CommonTree)adaptor.dupNode(SPLIT343);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT343_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause3012);
            rel344=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel344.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:552:20: ( split_branch )+
            int cnt100=0;
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==SPLIT_BRANCH) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:552:20: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause3014);
            	    split_branch345=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch345.getTree());


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


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:552:34: ( split_otherwise )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==OTHERWISE) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:552:34: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause3017);
                    split_otherwise346=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise346.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:555:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AliasMasker.split_branch_return split_branch() throws RecognitionException {
        AliasMasker.split_branch_return retval = new AliasMasker.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH347=null;
        AliasMasker.alias_return alias348 =null;

        AliasMasker.cond_return cond349 =null;


        CommonTree SPLIT_BRANCH347_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:556:5: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:556:7: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH347=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch3035); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH347_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH347);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH347_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch3037);
            alias348=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias348.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch3039);
            cond349=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond349.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:559:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AliasMasker.split_otherwise_return split_otherwise() throws RecognitionException {
        AliasMasker.split_otherwise_return retval = new AliasMasker.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE350=null;
        AliasMasker.alias_return alias351 =null;


        CommonTree OTHERWISE350_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:560:5: ( ^( OTHERWISE alias ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:560:7: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE350=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise3056); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE350_tree = (CommonTree)adaptor.dupNode(OTHERWISE350);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE350_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise3058);
            alias351=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias351.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:563:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AliasMasker.col_ref_return col_ref() throws RecognitionException {
        AliasMasker.col_ref_return retval = new AliasMasker.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_col_ref_return alias_col_ref352 =null;

        AliasMasker.dollar_col_ref_return dollar_col_ref353 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:563:9: ( alias_col_ref | dollar_col_ref )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==CUBE||LA102_0==GROUP||LA102_0==IDENTIFIER) ) {
                alt102=1;
            }
            else if ( (LA102_0==DOLLARVAR) ) {
                alt102=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;

            }
            switch (alt102) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:563:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref3069);
                    alias_col_ref352=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref352.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:563:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref3073);
                    dollar_col_ref353=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref353.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:566:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AliasMasker.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AliasMasker.alias_col_ref_return retval = new AliasMasker.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP354=null;
        CommonTree CUBE355=null;
        CommonTree IDENTIFIER356=null;

        CommonTree GROUP354_tree=null;
        CommonTree CUBE355_tree=null;
        CommonTree IDENTIFIER356_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:567:5: ( GROUP | CUBE | IDENTIFIER )
            int alt103=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt103=1;
                }
                break;
            case CUBE:
                {
                alt103=2;
                }
                break;
            case IDENTIFIER:
                {
                alt103=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;

            }

            switch (alt103) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:567:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP354=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref3086); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP354_tree = (CommonTree)adaptor.dupNode(GROUP354);


                    adaptor.addChild(root_0, GROUP354_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:568:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE355=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref3094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE355_tree = (CommonTree)adaptor.dupNode(CUBE355);


                    adaptor.addChild(root_0, CUBE355_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:569:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER356=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref3102); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER356_tree = (CommonTree)adaptor.dupNode(IDENTIFIER356);


                    adaptor.addChild(root_0, IDENTIFIER356_tree);
                    }


                    if ( state.backtracking==0 ) {
                              String alias = (IDENTIFIER356!=null?IDENTIFIER356.getText():null);
                              String[] names = alias.split( "::" );
                              StringBuilder sb = new StringBuilder();
                              for( int i = 0; i < names.length; i++ ) {
                                  String name = names[i];
                                  sb.append( aliasSeen.contains( name ) ? getMask( name ) : name );
                                  if( i < names.length - 1 )
                                      sb.append( "::" );
                              }
                              IDENTIFIER356.token.setText( sb.toString() );
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:584:1: dollar_col_ref : DOLLARVAR ;
    public final AliasMasker.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AliasMasker.dollar_col_ref_return retval = new AliasMasker.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR357=null;

        CommonTree DOLLARVAR357_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:585:5: ( DOLLARVAR )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:585:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR357=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref3123); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR357_tree = (CommonTree)adaptor.dupNode(DOLLARVAR357);


            adaptor.addChild(root_0, DOLLARVAR357_tree);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:588:1: const_expr : literal ;
    public final AliasMasker.const_expr_return const_expr() throws RecognitionException {
        AliasMasker.const_expr_return retval = new AliasMasker.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.literal_return literal358 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:588:12: ( literal )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:588:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr3132);
            literal358=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal358.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:591:1: literal : ( scalar | map | bag | tuple );
    public final AliasMasker.literal_return literal() throws RecognitionException {
        AliasMasker.literal_return retval = new AliasMasker.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.scalar_return scalar359 =null;

        AliasMasker.map_return map360 =null;

        AliasMasker.bag_return bag361 =null;

        AliasMasker.tuple_return tuple362 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:591:9: ( scalar | map | bag | tuple )
            int alt104=4;
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
                alt104=1;
                }
                break;
            case MAP_VAL:
                {
                alt104=2;
                }
                break;
            case BAG_VAL:
                {
                alt104=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt104=4;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:591:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal3141);
                    scalar359=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar359.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:591:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal3145);
                    map360=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map360.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:591:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal3149);
                    bag361=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag361.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:591:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal3153);
                    tuple362=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple362.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:594:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AliasMasker.scalar_return scalar() throws RecognitionException {
        AliasMasker.scalar_return retval = new AliasMasker.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING364=null;
        CommonTree NULL365=null;
        CommonTree TRUE366=null;
        CommonTree FALSE367=null;
        AliasMasker.num_scalar_return num_scalar363 =null;


        CommonTree QUOTEDSTRING364_tree=null;
        CommonTree NULL365_tree=null;
        CommonTree TRUE366_tree=null;
        CommonTree FALSE367_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:594:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt105=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt105=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt105=2;
                }
                break;
            case NULL:
                {
                alt105=3;
                }
                break;
            case TRUE:
                {
                alt105=4;
                }
                break;
            case FALSE:
                {
                alt105=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;

            }

            switch (alt105) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:594:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar3162);
                    num_scalar363=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar363.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:594:23: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING364=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar3166); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING364_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING364);


                    adaptor.addChild(root_0, QUOTEDSTRING364_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:594:38: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL365=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar3170); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL365_tree = (CommonTree)adaptor.dupNode(NULL365);


                    adaptor.addChild(root_0, NULL365_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:594:45: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE366=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar3174); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE366_tree = (CommonTree)adaptor.dupNode(TRUE366);


                    adaptor.addChild(root_0, TRUE366_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:594:52: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE367=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar3178); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE367_tree = (CommonTree)adaptor.dupNode(FALSE367);


                    adaptor.addChild(root_0, FALSE367_tree);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:597:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final AliasMasker.num_scalar_return num_scalar() throws RecognitionException {
        AliasMasker.num_scalar_return retval = new AliasMasker.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS368=null;
        CommonTree set369=null;

        CommonTree MINUS368_tree=null;
        CommonTree set369_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:597:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:597:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:597:14: ( MINUS )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==MINUS) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:597:14: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS368=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar3187); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS368_tree = (CommonTree)adaptor.dupNode(MINUS368);


                    adaptor.addChild(root_0, MINUS368_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            set369=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMALNUMBER||input.LA(1)==BIGINTEGERNUMBER||input.LA(1)==DOUBLENUMBER||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set369_tree = (CommonTree)adaptor.dupNode(set369);


                adaptor.addChild(root_0, set369_tree);
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
    // $ANTLR end "num_scalar"


    public static class map_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:600:1: map : ^( MAP_VAL ( keyvalue )* ) ;
    public final AliasMasker.map_return map() throws RecognitionException {
        AliasMasker.map_return retval = new AliasMasker.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL370=null;
        AliasMasker.keyvalue_return keyvalue371 =null;


        CommonTree MAP_VAL370_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:601:5: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:601:7: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL370=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map3229); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL370_tree = (CommonTree)adaptor.dupNode(MAP_VAL370);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL370_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:601:18: ( keyvalue )*
                loop107:
                do {
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==KEY_VAL_PAIR) ) {
                        alt107=1;
                    }


                    switch (alt107) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:601:18: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map3231);
                	    keyvalue371=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue371.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop107;
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
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:604:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AliasMasker.keyvalue_return keyvalue() throws RecognitionException {
        AliasMasker.keyvalue_return retval = new AliasMasker.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR372=null;
        AliasMasker.map_key_return map_key373 =null;

        AliasMasker.const_expr_return const_expr374 =null;


        CommonTree KEY_VAL_PAIR372_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:605:5: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:605:7: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR372=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue3249); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR372_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR372);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR372_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue3251);
            map_key373=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key373.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue3253);
            const_expr374=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr374.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:608:1: map_key : QUOTEDSTRING ;
    public final AliasMasker.map_key_return map_key() throws RecognitionException {
        AliasMasker.map_key_return retval = new AliasMasker.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING375=null;

        CommonTree QUOTEDSTRING375_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:608:9: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:608:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING375=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key3264); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING375_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING375);


            adaptor.addChild(root_0, QUOTEDSTRING375_tree);
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
    // $ANTLR end "map_key"


    public static class bag_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:611:1: bag : ^( BAG_VAL ( tuple )* ) ;
    public final AliasMasker.bag_return bag() throws RecognitionException {
        AliasMasker.bag_return retval = new AliasMasker.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL376=null;
        AliasMasker.tuple_return tuple377 =null;


        CommonTree BAG_VAL376_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:612:5: ( ^( BAG_VAL ( tuple )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:612:7: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL376=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag3279); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL376_tree = (CommonTree)adaptor.dupNode(BAG_VAL376);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL376_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:612:18: ( tuple )*
                loop108:
                do {
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( (LA108_0==TUPLE_VAL) ) {
                        alt108=1;
                    }


                    switch (alt108) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:612:18: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag3281);
                	    tuple377=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple377.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop108;
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
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:615:1: tuple : ^( TUPLE_VAL ( literal )* ) ;
    public final AliasMasker.tuple_return tuple() throws RecognitionException {
        AliasMasker.tuple_return retval = new AliasMasker.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL378=null;
        AliasMasker.literal_return literal379 =null;


        CommonTree TUPLE_VAL378_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:616:5: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:616:7: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL378=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple3299); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL378_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL378);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL378_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:616:20: ( literal )*
                loop109:
                do {
                    int alt109=2;
                    int LA109_0 = input.LA(1);

                    if ( (LA109_0==BIGDECIMALNUMBER||LA109_0==BIGINTEGERNUMBER||LA109_0==DOUBLENUMBER||LA109_0==FALSE||LA109_0==FLOATNUMBER||LA109_0==INTEGER||LA109_0==LONGINTEGER||LA109_0==MINUS||LA109_0==NULL||LA109_0==QUOTEDSTRING||LA109_0==TRUE||LA109_0==BAG_VAL||LA109_0==MAP_VAL||LA109_0==TUPLE_VAL) ) {
                        alt109=1;
                    }


                    switch (alt109) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:616:20: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple3301);
                	    literal379=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal379.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop109;
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
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:620:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BIGINTEGER | BIGDECIMAL | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE );
    public final AliasMasker.eid_return eid() throws RecognitionException {
        AliasMasker.eid_return retval = new AliasMasker.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT381=null;
        CommonTree RETURNS382=null;
        CommonTree DEFINE383=null;
        CommonTree LOAD384=null;
        CommonTree FILTER385=null;
        CommonTree FOREACH386=null;
        CommonTree CUBE387=null;
        CommonTree ROLLUP388=null;
        CommonTree MATCHES389=null;
        CommonTree ORDER390=null;
        CommonTree RANK391=null;
        CommonTree DISTINCT392=null;
        CommonTree COGROUP393=null;
        CommonTree JOIN394=null;
        CommonTree CROSS395=null;
        CommonTree UNION396=null;
        CommonTree SPLIT397=null;
        CommonTree INTO398=null;
        CommonTree IF399=null;
        CommonTree ALL400=null;
        CommonTree AS401=null;
        CommonTree BY402=null;
        CommonTree USING403=null;
        CommonTree INNER404=null;
        CommonTree OUTER405=null;
        CommonTree PARALLEL406=null;
        CommonTree PARTITION407=null;
        CommonTree GROUP408=null;
        CommonTree AND409=null;
        CommonTree OR410=null;
        CommonTree NOT411=null;
        CommonTree GENERATE412=null;
        CommonTree FLATTEN413=null;
        CommonTree EVAL414=null;
        CommonTree ASC415=null;
        CommonTree DESC416=null;
        CommonTree BOOLEAN417=null;
        CommonTree INT418=null;
        CommonTree LONG419=null;
        CommonTree FLOAT420=null;
        CommonTree DOUBLE421=null;
        CommonTree DATETIME422=null;
        CommonTree CHARARRAY423=null;
        CommonTree BIGINTEGER424=null;
        CommonTree BIGDECIMAL425=null;
        CommonTree BYTEARRAY426=null;
        CommonTree BAG427=null;
        CommonTree TUPLE428=null;
        CommonTree MAP429=null;
        CommonTree IS430=null;
        CommonTree NULL431=null;
        CommonTree TRUE432=null;
        CommonTree FALSE433=null;
        CommonTree STREAM434=null;
        CommonTree THROUGH435=null;
        CommonTree STORE436=null;
        CommonTree MAPREDUCE437=null;
        CommonTree SHIP438=null;
        CommonTree CACHE439=null;
        CommonTree INPUT440=null;
        CommonTree OUTPUT441=null;
        CommonTree STDERROR442=null;
        CommonTree STDIN443=null;
        CommonTree STDOUT444=null;
        CommonTree LIMIT445=null;
        CommonTree SAMPLE446=null;
        CommonTree LEFT447=null;
        CommonTree RIGHT448=null;
        CommonTree FULL449=null;
        CommonTree IDENTIFIER450=null;
        CommonTree TOBAG451=null;
        CommonTree TOMAP452=null;
        CommonTree TOTUPLE453=null;
        AliasMasker.rel_str_op_return rel_str_op380 =null;


        CommonTree IMPORT381_tree=null;
        CommonTree RETURNS382_tree=null;
        CommonTree DEFINE383_tree=null;
        CommonTree LOAD384_tree=null;
        CommonTree FILTER385_tree=null;
        CommonTree FOREACH386_tree=null;
        CommonTree CUBE387_tree=null;
        CommonTree ROLLUP388_tree=null;
        CommonTree MATCHES389_tree=null;
        CommonTree ORDER390_tree=null;
        CommonTree RANK391_tree=null;
        CommonTree DISTINCT392_tree=null;
        CommonTree COGROUP393_tree=null;
        CommonTree JOIN394_tree=null;
        CommonTree CROSS395_tree=null;
        CommonTree UNION396_tree=null;
        CommonTree SPLIT397_tree=null;
        CommonTree INTO398_tree=null;
        CommonTree IF399_tree=null;
        CommonTree ALL400_tree=null;
        CommonTree AS401_tree=null;
        CommonTree BY402_tree=null;
        CommonTree USING403_tree=null;
        CommonTree INNER404_tree=null;
        CommonTree OUTER405_tree=null;
        CommonTree PARALLEL406_tree=null;
        CommonTree PARTITION407_tree=null;
        CommonTree GROUP408_tree=null;
        CommonTree AND409_tree=null;
        CommonTree OR410_tree=null;
        CommonTree NOT411_tree=null;
        CommonTree GENERATE412_tree=null;
        CommonTree FLATTEN413_tree=null;
        CommonTree EVAL414_tree=null;
        CommonTree ASC415_tree=null;
        CommonTree DESC416_tree=null;
        CommonTree BOOLEAN417_tree=null;
        CommonTree INT418_tree=null;
        CommonTree LONG419_tree=null;
        CommonTree FLOAT420_tree=null;
        CommonTree DOUBLE421_tree=null;
        CommonTree DATETIME422_tree=null;
        CommonTree CHARARRAY423_tree=null;
        CommonTree BIGINTEGER424_tree=null;
        CommonTree BIGDECIMAL425_tree=null;
        CommonTree BYTEARRAY426_tree=null;
        CommonTree BAG427_tree=null;
        CommonTree TUPLE428_tree=null;
        CommonTree MAP429_tree=null;
        CommonTree IS430_tree=null;
        CommonTree NULL431_tree=null;
        CommonTree TRUE432_tree=null;
        CommonTree FALSE433_tree=null;
        CommonTree STREAM434_tree=null;
        CommonTree THROUGH435_tree=null;
        CommonTree STORE436_tree=null;
        CommonTree MAPREDUCE437_tree=null;
        CommonTree SHIP438_tree=null;
        CommonTree CACHE439_tree=null;
        CommonTree INPUT440_tree=null;
        CommonTree OUTPUT441_tree=null;
        CommonTree STDERROR442_tree=null;
        CommonTree STDIN443_tree=null;
        CommonTree STDOUT444_tree=null;
        CommonTree LIMIT445_tree=null;
        CommonTree SAMPLE446_tree=null;
        CommonTree LEFT447_tree=null;
        CommonTree RIGHT448_tree=null;
        CommonTree FULL449_tree=null;
        CommonTree IDENTIFIER450_tree=null;
        CommonTree TOBAG451_tree=null;
        CommonTree TOMAP452_tree=null;
        CommonTree TOTUPLE453_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:620:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BIGINTEGER | BIGDECIMAL | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE )
            int alt110=74;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt110=1;
                }
                break;
            case IMPORT:
                {
                alt110=2;
                }
                break;
            case RETURNS:
                {
                alt110=3;
                }
                break;
            case DEFINE:
                {
                alt110=4;
                }
                break;
            case LOAD:
                {
                alt110=5;
                }
                break;
            case FILTER:
                {
                alt110=6;
                }
                break;
            case FOREACH:
                {
                alt110=7;
                }
                break;
            case CUBE:
                {
                alt110=8;
                }
                break;
            case ROLLUP:
                {
                alt110=9;
                }
                break;
            case MATCHES:
                {
                alt110=10;
                }
                break;
            case ORDER:
                {
                alt110=11;
                }
                break;
            case RANK:
                {
                alt110=12;
                }
                break;
            case DISTINCT:
                {
                alt110=13;
                }
                break;
            case COGROUP:
                {
                alt110=14;
                }
                break;
            case JOIN:
                {
                alt110=15;
                }
                break;
            case CROSS:
                {
                alt110=16;
                }
                break;
            case UNION:
                {
                alt110=17;
                }
                break;
            case SPLIT:
                {
                alt110=18;
                }
                break;
            case INTO:
                {
                alt110=19;
                }
                break;
            case IF:
                {
                alt110=20;
                }
                break;
            case ALL:
                {
                alt110=21;
                }
                break;
            case AS:
                {
                alt110=22;
                }
                break;
            case BY:
                {
                alt110=23;
                }
                break;
            case USING:
                {
                alt110=24;
                }
                break;
            case INNER:
                {
                alt110=25;
                }
                break;
            case OUTER:
                {
                alt110=26;
                }
                break;
            case PARALLEL:
                {
                alt110=27;
                }
                break;
            case PARTITION:
                {
                alt110=28;
                }
                break;
            case GROUP:
                {
                alt110=29;
                }
                break;
            case AND:
                {
                alt110=30;
                }
                break;
            case OR:
                {
                alt110=31;
                }
                break;
            case NOT:
                {
                alt110=32;
                }
                break;
            case GENERATE:
                {
                alt110=33;
                }
                break;
            case FLATTEN:
                {
                alt110=34;
                }
                break;
            case EVAL:
                {
                alt110=35;
                }
                break;
            case ASC:
                {
                alt110=36;
                }
                break;
            case DESC:
                {
                alt110=37;
                }
                break;
            case BOOLEAN:
                {
                alt110=38;
                }
                break;
            case INT:
                {
                alt110=39;
                }
                break;
            case LONG:
                {
                alt110=40;
                }
                break;
            case FLOAT:
                {
                alt110=41;
                }
                break;
            case DOUBLE:
                {
                alt110=42;
                }
                break;
            case DATETIME:
                {
                alt110=43;
                }
                break;
            case CHARARRAY:
                {
                alt110=44;
                }
                break;
            case BIGINTEGER:
                {
                alt110=45;
                }
                break;
            case BIGDECIMAL:
                {
                alt110=46;
                }
                break;
            case BYTEARRAY:
                {
                alt110=47;
                }
                break;
            case BAG:
                {
                alt110=48;
                }
                break;
            case TUPLE:
                {
                alt110=49;
                }
                break;
            case MAP:
                {
                alt110=50;
                }
                break;
            case IS:
                {
                alt110=51;
                }
                break;
            case NULL:
                {
                alt110=52;
                }
                break;
            case TRUE:
                {
                alt110=53;
                }
                break;
            case FALSE:
                {
                alt110=54;
                }
                break;
            case STREAM:
                {
                alt110=55;
                }
                break;
            case THROUGH:
                {
                alt110=56;
                }
                break;
            case STORE:
                {
                alt110=57;
                }
                break;
            case MAPREDUCE:
                {
                alt110=58;
                }
                break;
            case SHIP:
                {
                alt110=59;
                }
                break;
            case CACHE:
                {
                alt110=60;
                }
                break;
            case INPUT:
                {
                alt110=61;
                }
                break;
            case OUTPUT:
                {
                alt110=62;
                }
                break;
            case STDERROR:
                {
                alt110=63;
                }
                break;
            case STDIN:
                {
                alt110=64;
                }
                break;
            case STDOUT:
                {
                alt110=65;
                }
                break;
            case LIMIT:
                {
                alt110=66;
                }
                break;
            case SAMPLE:
                {
                alt110=67;
                }
                break;
            case LEFT:
                {
                alt110=68;
                }
                break;
            case RIGHT:
                {
                alt110=69;
                }
                break;
            case FULL:
                {
                alt110=70;
                }
                break;
            case IDENTIFIER:
                {
                alt110=71;
                }
                break;
            case TOBAG:
                {
                alt110=72;
                }
                break;
            case TOMAP:
                {
                alt110=73;
                }
                break;
            case TOTUPLE:
                {
                alt110=74;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;

            }

            switch (alt110) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:620:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid3314);
                    rel_str_op380=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op380.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:621:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT381=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid3322); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT381_tree = (CommonTree)adaptor.dupNode(IMPORT381);


                    adaptor.addChild(root_0, IMPORT381_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:622:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS382=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid3330); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS382_tree = (CommonTree)adaptor.dupNode(RETURNS382);


                    adaptor.addChild(root_0, RETURNS382_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:623:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE383=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid3338); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE383_tree = (CommonTree)adaptor.dupNode(DEFINE383);


                    adaptor.addChild(root_0, DEFINE383_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:624:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD384=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid3346); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD384_tree = (CommonTree)adaptor.dupNode(LOAD384);


                    adaptor.addChild(root_0, LOAD384_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:625:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER385=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid3354); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER385_tree = (CommonTree)adaptor.dupNode(FILTER385);


                    adaptor.addChild(root_0, FILTER385_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:626:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH386=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid3362); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH386_tree = (CommonTree)adaptor.dupNode(FOREACH386);


                    adaptor.addChild(root_0, FOREACH386_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:627:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE387=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid3370); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE387_tree = (CommonTree)adaptor.dupNode(CUBE387);


                    adaptor.addChild(root_0, CUBE387_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:628:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP388=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid3378); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP388_tree = (CommonTree)adaptor.dupNode(ROLLUP388);


                    adaptor.addChild(root_0, ROLLUP388_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:629:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES389=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid3386); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES389_tree = (CommonTree)adaptor.dupNode(MATCHES389);


                    adaptor.addChild(root_0, MATCHES389_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:630:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER390=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid3394); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER390_tree = (CommonTree)adaptor.dupNode(ORDER390);


                    adaptor.addChild(root_0, ORDER390_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:631:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK391=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid3402); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK391_tree = (CommonTree)adaptor.dupNode(RANK391);


                    adaptor.addChild(root_0, RANK391_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:632:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT392=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid3410); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT392_tree = (CommonTree)adaptor.dupNode(DISTINCT392);


                    adaptor.addChild(root_0, DISTINCT392_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:633:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP393=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid3418); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP393_tree = (CommonTree)adaptor.dupNode(COGROUP393);


                    adaptor.addChild(root_0, COGROUP393_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:634:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN394=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid3426); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN394_tree = (CommonTree)adaptor.dupNode(JOIN394);


                    adaptor.addChild(root_0, JOIN394_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:635:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS395=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid3434); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS395_tree = (CommonTree)adaptor.dupNode(CROSS395);


                    adaptor.addChild(root_0, CROSS395_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:636:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION396=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid3442); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION396_tree = (CommonTree)adaptor.dupNode(UNION396);


                    adaptor.addChild(root_0, UNION396_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:637:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT397=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid3450); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT397_tree = (CommonTree)adaptor.dupNode(SPLIT397);


                    adaptor.addChild(root_0, SPLIT397_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:638:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO398=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid3458); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO398_tree = (CommonTree)adaptor.dupNode(INTO398);


                    adaptor.addChild(root_0, INTO398_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:639:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF399=(CommonTree)match(input,IF,FOLLOW_IF_in_eid3466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF399_tree = (CommonTree)adaptor.dupNode(IF399);


                    adaptor.addChild(root_0, IF399_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:640:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL400=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid3474); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL400_tree = (CommonTree)adaptor.dupNode(ALL400);


                    adaptor.addChild(root_0, ALL400_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:641:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS401=(CommonTree)match(input,AS,FOLLOW_AS_in_eid3482); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS401_tree = (CommonTree)adaptor.dupNode(AS401);


                    adaptor.addChild(root_0, AS401_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:642:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY402=(CommonTree)match(input,BY,FOLLOW_BY_in_eid3490); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY402_tree = (CommonTree)adaptor.dupNode(BY402);


                    adaptor.addChild(root_0, BY402_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:643:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING403=(CommonTree)match(input,USING,FOLLOW_USING_in_eid3498); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING403_tree = (CommonTree)adaptor.dupNode(USING403);


                    adaptor.addChild(root_0, USING403_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:644:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER404=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid3506); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER404_tree = (CommonTree)adaptor.dupNode(INNER404);


                    adaptor.addChild(root_0, INNER404_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:645:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER405=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid3514); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER405_tree = (CommonTree)adaptor.dupNode(OUTER405);


                    adaptor.addChild(root_0, OUTER405_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:646:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL406=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid3522); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL406_tree = (CommonTree)adaptor.dupNode(PARALLEL406);


                    adaptor.addChild(root_0, PARALLEL406_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:647:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION407=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid3530); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION407_tree = (CommonTree)adaptor.dupNode(PARTITION407);


                    adaptor.addChild(root_0, PARTITION407_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:648:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP408=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid3538); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP408_tree = (CommonTree)adaptor.dupNode(GROUP408);


                    adaptor.addChild(root_0, GROUP408_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:649:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND409=(CommonTree)match(input,AND,FOLLOW_AND_in_eid3546); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND409_tree = (CommonTree)adaptor.dupNode(AND409);


                    adaptor.addChild(root_0, AND409_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:650:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR410=(CommonTree)match(input,OR,FOLLOW_OR_in_eid3554); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR410_tree = (CommonTree)adaptor.dupNode(OR410);


                    adaptor.addChild(root_0, OR410_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:651:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT411=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid3562); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT411_tree = (CommonTree)adaptor.dupNode(NOT411);


                    adaptor.addChild(root_0, NOT411_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:652:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE412=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid3570); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE412_tree = (CommonTree)adaptor.dupNode(GENERATE412);


                    adaptor.addChild(root_0, GENERATE412_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:653:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN413=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid3578); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN413_tree = (CommonTree)adaptor.dupNode(FLATTEN413);


                    adaptor.addChild(root_0, FLATTEN413_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:654:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL414=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid3586); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL414_tree = (CommonTree)adaptor.dupNode(EVAL414);


                    adaptor.addChild(root_0, EVAL414_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:655:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC415=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid3594); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC415_tree = (CommonTree)adaptor.dupNode(ASC415);


                    adaptor.addChild(root_0, ASC415_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:656:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC416=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid3602); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC416_tree = (CommonTree)adaptor.dupNode(DESC416);


                    adaptor.addChild(root_0, DESC416_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:657:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN417=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid3610); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN417_tree = (CommonTree)adaptor.dupNode(BOOLEAN417);


                    adaptor.addChild(root_0, BOOLEAN417_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:658:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT418=(CommonTree)match(input,INT,FOLLOW_INT_in_eid3618); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT418_tree = (CommonTree)adaptor.dupNode(INT418);


                    adaptor.addChild(root_0, INT418_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:659:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG419=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid3626); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG419_tree = (CommonTree)adaptor.dupNode(LONG419);


                    adaptor.addChild(root_0, LONG419_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:660:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT420=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid3634); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT420_tree = (CommonTree)adaptor.dupNode(FLOAT420);


                    adaptor.addChild(root_0, FLOAT420_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:661:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE421=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid3642); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE421_tree = (CommonTree)adaptor.dupNode(DOUBLE421);


                    adaptor.addChild(root_0, DOUBLE421_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:662:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME422=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid3650); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME422_tree = (CommonTree)adaptor.dupNode(DATETIME422);


                    adaptor.addChild(root_0, DATETIME422_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:663:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY423=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid3658); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY423_tree = (CommonTree)adaptor.dupNode(CHARARRAY423);


                    adaptor.addChild(root_0, CHARARRAY423_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:664:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER424=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid3666); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER424_tree = (CommonTree)adaptor.dupNode(BIGINTEGER424);


                    adaptor.addChild(root_0, BIGINTEGER424_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:665:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL425=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid3674); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL425_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL425);


                    adaptor.addChild(root_0, BIGDECIMAL425_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:666:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY426=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid3682); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY426_tree = (CommonTree)adaptor.dupNode(BYTEARRAY426);


                    adaptor.addChild(root_0, BYTEARRAY426_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:667:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG427=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid3690); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG427_tree = (CommonTree)adaptor.dupNode(BAG427);


                    adaptor.addChild(root_0, BAG427_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:668:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE428=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid3698); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE428_tree = (CommonTree)adaptor.dupNode(TUPLE428);


                    adaptor.addChild(root_0, TUPLE428_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:669:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP429=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid3706); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP429_tree = (CommonTree)adaptor.dupNode(MAP429);


                    adaptor.addChild(root_0, MAP429_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:670:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS430=(CommonTree)match(input,IS,FOLLOW_IS_in_eid3714); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS430_tree = (CommonTree)adaptor.dupNode(IS430);


                    adaptor.addChild(root_0, IS430_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:671:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL431=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid3722); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL431_tree = (CommonTree)adaptor.dupNode(NULL431);


                    adaptor.addChild(root_0, NULL431_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:672:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE432=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid3730); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE432_tree = (CommonTree)adaptor.dupNode(TRUE432);


                    adaptor.addChild(root_0, TRUE432_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:673:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE433=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid3738); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE433_tree = (CommonTree)adaptor.dupNode(FALSE433);


                    adaptor.addChild(root_0, FALSE433_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:674:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM434=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid3746); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM434_tree = (CommonTree)adaptor.dupNode(STREAM434);


                    adaptor.addChild(root_0, STREAM434_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:675:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH435=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid3754); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH435_tree = (CommonTree)adaptor.dupNode(THROUGH435);


                    adaptor.addChild(root_0, THROUGH435_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:676:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE436=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid3762); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE436_tree = (CommonTree)adaptor.dupNode(STORE436);


                    adaptor.addChild(root_0, STORE436_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:677:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE437=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid3770); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE437_tree = (CommonTree)adaptor.dupNode(MAPREDUCE437);


                    adaptor.addChild(root_0, MAPREDUCE437_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:678:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP438=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid3778); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP438_tree = (CommonTree)adaptor.dupNode(SHIP438);


                    adaptor.addChild(root_0, SHIP438_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:679:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE439=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid3786); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE439_tree = (CommonTree)adaptor.dupNode(CACHE439);


                    adaptor.addChild(root_0, CACHE439_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:680:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT440=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid3794); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT440_tree = (CommonTree)adaptor.dupNode(INPUT440);


                    adaptor.addChild(root_0, INPUT440_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:681:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT441=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid3802); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT441_tree = (CommonTree)adaptor.dupNode(OUTPUT441);


                    adaptor.addChild(root_0, OUTPUT441_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:682:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR442=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid3810); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR442_tree = (CommonTree)adaptor.dupNode(STDERROR442);


                    adaptor.addChild(root_0, STDERROR442_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:683:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN443=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid3818); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN443_tree = (CommonTree)adaptor.dupNode(STDIN443);


                    adaptor.addChild(root_0, STDIN443_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:684:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT444=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid3826); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT444_tree = (CommonTree)adaptor.dupNode(STDOUT444);


                    adaptor.addChild(root_0, STDOUT444_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:685:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT445=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid3834); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT445_tree = (CommonTree)adaptor.dupNode(LIMIT445);


                    adaptor.addChild(root_0, LIMIT445_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:686:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE446=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid3842); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE446_tree = (CommonTree)adaptor.dupNode(SAMPLE446);


                    adaptor.addChild(root_0, SAMPLE446_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:687:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT447=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid3850); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT447_tree = (CommonTree)adaptor.dupNode(LEFT447);


                    adaptor.addChild(root_0, LEFT447_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:688:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT448=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid3858); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT448_tree = (CommonTree)adaptor.dupNode(RIGHT448);


                    adaptor.addChild(root_0, RIGHT448_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:689:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL449=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid3866); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL449_tree = (CommonTree)adaptor.dupNode(FULL449);


                    adaptor.addChild(root_0, FULL449_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:690:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER450=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid3874); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER450_tree = (CommonTree)adaptor.dupNode(IDENTIFIER450);


                    adaptor.addChild(root_0, IDENTIFIER450_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:691:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG451=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid3882); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG451_tree = (CommonTree)adaptor.dupNode(TOBAG451);


                    adaptor.addChild(root_0, TOBAG451_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:692:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP452=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid3890); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP452_tree = (CommonTree)adaptor.dupNode(TOMAP452);


                    adaptor.addChild(root_0, TOMAP452_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:693:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE453=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid3898); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE453_tree = (CommonTree)adaptor.dupNode(TOTUPLE453);


                    adaptor.addChild(root_0, TOTUPLE453_tree);
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
    // $ANTLR end "eid"


    public static class rel_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:697:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AliasMasker.rel_op_return rel_op() throws RecognitionException {
        AliasMasker.rel_op_return retval = new AliasMasker.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES460=null;
        AliasMasker.rel_op_eq_return rel_op_eq454 =null;

        AliasMasker.rel_op_ne_return rel_op_ne455 =null;

        AliasMasker.rel_op_gt_return rel_op_gt456 =null;

        AliasMasker.rel_op_gte_return rel_op_gte457 =null;

        AliasMasker.rel_op_lt_return rel_op_lt458 =null;

        AliasMasker.rel_op_lte_return rel_op_lte459 =null;


        CommonTree STR_OP_MATCHES460_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:698:5: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt111=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt111=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt111=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt111=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt111=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt111=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt111=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt111=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;

            }

            switch (alt111) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:698:7: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op3912);
                    rel_op_eq454=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq454.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:699:7: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op3920);
                    rel_op_ne455=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne455.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:700:7: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op3928);
                    rel_op_gt456=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt456.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:701:7: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op3936);
                    rel_op_gte457=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte457.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:702:7: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op3944);
                    rel_op_lt458=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt458.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:703:7: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op3952);
                    rel_op_lte459=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte459.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:704:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES460=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op3960); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES460_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES460);


                    adaptor.addChild(root_0, STR_OP_MATCHES460_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:707:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final AliasMasker.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AliasMasker.rel_op_eq_return retval = new AliasMasker.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set461=null;

        CommonTree set461_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:708:5: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set461=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set461_tree = (CommonTree)adaptor.dupNode(set461);


                adaptor.addChild(root_0, set461_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:712:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final AliasMasker.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AliasMasker.rel_op_ne_return retval = new AliasMasker.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set462=null;

        CommonTree set462_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:713:5: ( STR_OP_NE | NUM_OP_NE )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set462=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set462_tree = (CommonTree)adaptor.dupNode(set462);


                adaptor.addChild(root_0, set462_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:717:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final AliasMasker.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AliasMasker.rel_op_gt_return retval = new AliasMasker.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set463=null;

        CommonTree set463_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:718:5: ( STR_OP_GT | NUM_OP_GT )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set463=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set463_tree = (CommonTree)adaptor.dupNode(set463);


                adaptor.addChild(root_0, set463_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:722:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final AliasMasker.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AliasMasker.rel_op_gte_return retval = new AliasMasker.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set464=null;

        CommonTree set464_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:723:5: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set464=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set464_tree = (CommonTree)adaptor.dupNode(set464);


                adaptor.addChild(root_0, set464_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:727:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final AliasMasker.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AliasMasker.rel_op_lt_return retval = new AliasMasker.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set465=null;

        CommonTree set465_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:728:5: ( STR_OP_LT | NUM_OP_LT )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set465=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set465_tree = (CommonTree)adaptor.dupNode(set465);


                adaptor.addChild(root_0, set465_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:732:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final AliasMasker.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AliasMasker.rel_op_lte_return retval = new AliasMasker.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set466=null;

        CommonTree set466_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:733:5: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set466=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set466_tree = (CommonTree)adaptor.dupNode(set466);


                adaptor.addChild(root_0, set466_tree);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:737:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AliasMasker.rel_str_op_return rel_str_op() throws RecognitionException {
        AliasMasker.rel_str_op_return retval = new AliasMasker.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set467=null;

        CommonTree set467_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:738:5: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set467=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set467_tree = (CommonTree)adaptor.dupNode(set467);


                adaptor.addChild(root_0, set467_tree);
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
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred98_AliasMasker
    public final void synpred98_AliasMasker_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:331:7: ( ^( MINUS expr expr ) )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:331:7: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred98_AliasMasker1608); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred98_AliasMasker1610);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred98_AliasMasker1612);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred98_AliasMasker

    // $ANTLR start synpred102_AliasMasker
    public final void synpred102_AliasMasker_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:335:7: ( ^( CAST_EXPR type expr ) )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:335:7: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred102_AliasMasker1672); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred102_AliasMasker1674);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred102_AliasMasker1676);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred102_AliasMasker

    // $ANTLR start synpred103_AliasMasker
    public final void synpred103_AliasMasker_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:336:7: ( const_expr )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:336:7: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred103_AliasMasker1686);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred103_AliasMasker

    // $ANTLR start synpred106_AliasMasker
    public final void synpred106_AliasMasker_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:339:7: ( ^( CAST_EXPR type_cast expr ) )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:339:7: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred106_AliasMasker1718); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred106_AliasMasker1720);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred106_AliasMasker1722);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred106_AliasMasker

    // $ANTLR start synpred125_AliasMasker
    public final void synpred125_AliasMasker_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:396:22: ( INTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:396:22: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred125_AliasMasker2038); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred125_AliasMasker

    // $ANTLR start synpred126_AliasMasker
    public final void synpred126_AliasMasker_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:396:32: ( LONGINTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:396:32: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred126_AliasMasker2042); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred126_AliasMasker

    // $ANTLR start synpred127_AliasMasker
    public final void synpred127_AliasMasker_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:400:24: ( DOUBLENUMBER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:400:24: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred127_AliasMasker2072); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred127_AliasMasker

    // $ANTLR start synpred153_AliasMasker
    public final void synpred153_AliasMasker_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:457:7: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:457:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred153_AliasMasker2396);
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


        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:460:16: ( OUTER )?
        int alt119=2;
        int LA119_0 = input.LA(1);

        if ( (LA119_0==OUTER) ) {
            alt119=1;
        }
        switch (alt119) {
            case 1 :
                // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:460:16: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred153_AliasMasker2451); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred153_AliasMasker2454);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred153_AliasMasker

    // $ANTLR start synpred171_AliasMasker
    public final void synpred171_AliasMasker_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:528:34: ( INTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AliasMasker.g:528:34: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred171_AliasMasker2871); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred171_AliasMasker

    // Delegated rules

    public final boolean synpred106_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred126_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred125_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred125_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred98_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred98_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred171_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred171_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred153_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred153_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query80 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query82 = new BitSet(new long[]{0x0000000000000008L,0x0008000000000000L,0x0000480000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement156 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement160 = new BitSet(new long[]{0x0024200113200000L,0x0308408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_op_clause_in_general_statement173 = new BitSet(new long[]{0x0000000000000008L,0x0000000080000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement175 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause190 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause192 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause208 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause210 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias225 = new BitSet(new long[]{0x0000000000000002L});
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
    public static final BitSet FOLLOW_cmd_in_define_clause504 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause508 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd527 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd539 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd543 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd547 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd551 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd555 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause575 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause577 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list593 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause609 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause611 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause628 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause630 = new BitSet(new long[]{0x0000000000000008L,0x00C0004000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd648 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd650 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd663 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd678 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd680 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause700 = new BitSet(new long[]{0x0000000000000008L,0x00C0004000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause718 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause722 = new BitSet(new long[]{0x4000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause724 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause745 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause747 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause749 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause752 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause793 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause795 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def812 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def814 = new BitSet(new long[]{0x200080100412A808L,0x0000000000000400L,0x0004000800000800L});
    public static final BitSet FOLLOW_type_in_field_def816 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def831 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def833 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list848 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_simple_type_in_type858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type934 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type936 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type954 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type956 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type959 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type973 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type975 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause993 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause995 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1007 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1009 = new BitSet(new long[]{0x0000000000000008L,0x0000004000000000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1011 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1027 = new BitSet(new long[]{0x0000000400000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_set_in_func_name1031 = new BitSet(new long[]{0xBBBCE8115737AF50L,0xFFE96381EC06370EL,0x006380000000007DL});
    public static final BitSet FOLLOW_eid_in_func_name1041 = new BitSet(new long[]{0x0000000400000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1057 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1073 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1075 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1090 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1111 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1113 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1128 = new BitSet(new long[]{0x0000000002000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_set_in_cube_rollup_list1144 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1154 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1169 = new BitSet(new long[]{0x40A2082A02085002L,0x0010004A00044800L,0x0010003008386008L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_group_clause1206 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1216 = new BitSet(new long[]{0x00A4200113200008L,0x030840C108002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_type_in_group_clause1219 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1222 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1247 = new BitSet(new long[]{0x0000000000010010L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1251 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1255 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1259 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_alias_in_rel1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1291 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1321 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1325 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1329 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1333 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1353 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1355 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1372 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_store_clause1374 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause1376 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1378 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1396 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1398 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_cond_in_filter_clause1400 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1417 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1419 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_cond_in_cond1421 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1433 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1435 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_cond_in_cond1437 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1449 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1451 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1463 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1465 = new BitSet(new long[]{0x0000000000000008L,0x0000000000020000L});
    public static final BitSet FOLLOW_NOT_in_cond1467 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1480 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1482 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_cond1484 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond1494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond1512 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1514 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval1531 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1533 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_in_eval1535 = new BitSet(new long[]{0x40A2082A02085008L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1555 = new BitSet(new long[]{0x40A2082A02085008L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1557 = new BitSet(new long[]{0x40A2082A02085008L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_real_arg1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1592 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1594 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_expr1596 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1608 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1610 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_expr1612 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1624 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1626 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_expr1628 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1640 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1642 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_expr1644 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr1656 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1658 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_expr1660 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1672 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr1674 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_expr1676 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr1704 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1706 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1718 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr1720 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_expr1722 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr1734 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1736 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1778 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast1780 = new BitSet(new long[]{0x200080100412A808L,0x0000000000000400L,0x0008000800001000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1798 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast1800 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr1816 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr1820 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr1824 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr1848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr1852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj1867 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj1869 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index1881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range1938 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range1940 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range1943 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range1945 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj1962 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_pound_proj1964 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr1989 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr1991 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_bin_expr1993 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_bin_expr1995 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_in_case_expr2012 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2014 = new BitSet(new long[]{0x40A2082A02085008L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2032 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2034 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2038 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2042 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2046 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2066 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2068 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2072 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2076 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause2092 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause2094 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause2098 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement2115 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement2117 = new BitSet(new long[]{0x0000000020000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement2121 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause2136 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause2155 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_col_range_in_rank_col2168 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_col_ref_in_rank_col2172 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ORDER_in_order_clause2200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause2202 = new BitSet(new long[]{0x00A0000802000000L,0x0010000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause2204 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause2206 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause2222 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2241 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_col_range_in_order_col2256 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_col_ref_in_order_col2260 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause2287 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause2289 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause2291 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause2309 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause2311 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause2328 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause2330 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause2332 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list2348 = new BitSet(new long[]{0x00A4200113200002L,0x0308408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_JOIN_in_join_clause2364 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause2366 = new BitSet(new long[]{0x0000000000000008L,0x0000004100000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause2368 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause2371 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2396 = new BitSet(new long[]{0x0008000000000000L,0x0000020000000008L});
    public static final BitSet FOLLOW_set_in_join_sub_clause2398 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2462 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2475 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2477 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2479 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2496 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2498 = new BitSet(new long[]{0x40A2082A02085008L,0x0010004A00044800L,0x0010003008386008L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2539 = new BitSet(new long[]{0x00A4200113200000L,0x0308408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2542 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2561 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000003000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2563 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2580 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2582 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2594 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2596 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2611 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x000000C000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2629 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause2631 = new BitSet(new long[]{0x40A2482A02085008L,0x0010004A00044800L,0x0010003008386008L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command2649 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2651 = new BitSet(new long[]{0x0004200101000000L,0x0000000008000100L,0x0000010000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command2653 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command2665 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2667 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_nested_command2669 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op2680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op2694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op2708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op2722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op2736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op2764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj2779 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2781 = new BitSet(new long[]{0x00A0000802000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2783 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter2801 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter2803 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_cond_in_nested_filter2805 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort2822 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort2824 = new BitSet(new long[]{0x00A0000802000000L,0x0010000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort2826 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort2828 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct2846 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct2848 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit2865 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit2867 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit2871 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit2875 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross2890 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross2892 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach2905 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach2907 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach2909 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list2920 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input2934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause2949 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause2951 = new BitSet(new long[]{0x0080040000000000L});
    public static final BitSet FOLLOW_set_in_stream_clause2953 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause2963 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause2981 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause2983 = new BitSet(new long[]{0x0000000000000000L,0x0100004000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause2985 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause2988 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause2990 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause2992 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause3010 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause3012 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3014 = new BitSet(new long[]{0x0000000000000008L,0x0000000010000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause3017 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch3035 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch3037 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000008010001L});
    public static final BitSet FOLLOW_cond_in_split_branch3039 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise3056 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise3058 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref3069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref3073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref3086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr3132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal3141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal3145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal3149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal3153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar3162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar3170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar3174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar3187 = new BitSet(new long[]{0x4002002000005000L,0x0000000000000800L});
    public static final BitSet FOLLOW_set_in_num_scalar3190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map3229 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map3231 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue3249 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue3251 = new BitSet(new long[]{0x4002082000005000L,0x0000004000044800L,0x0010001000002008L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue3253 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key3264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag3279 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag3281 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple3299 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple3301 = new BitSet(new long[]{0x4002082000005008L,0x0000004000044800L,0x0010001000002008L});
    public static final BitSet FOLLOW_rel_str_op_in_eid3314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid3322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid3330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid3338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid3346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid3354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid3362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid3378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid3386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid3402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid3418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid3426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid3442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid3450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid3458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid3466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid3482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid3490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid3498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid3514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid3522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid3530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid3546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid3554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid3562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid3570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid3578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid3586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid3594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid3602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid3610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid3618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid3626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid3634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid3642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid3650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid3682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid3698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid3706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid3714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid3730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid3754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid3762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid3770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid3778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid3802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid3818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid3826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid3834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid3850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid3858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid3866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid3874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid3882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid3890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid3898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op3912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op3920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op3936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op3944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op3952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op3960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred98_AliasMasker1608 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred98_AliasMasker1610 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_synpred98_AliasMasker1612 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred102_AliasMasker1672 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred102_AliasMasker1674 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_synpred102_AliasMasker1676 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred103_AliasMasker1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred106_AliasMasker1718 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred106_AliasMasker1720 = new BitSet(new long[]{0x40A2082A02085000L,0x0010004A00044800L,0x0010003008286008L});
    public static final BitSet FOLLOW_expr_in_synpred106_AliasMasker1722 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_synpred125_AliasMasker2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred126_AliasMasker2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred127_AliasMasker2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred153_AliasMasker2396 = new BitSet(new long[]{0x0008000000000000L,0x0000020000000008L});
    public static final BitSet FOLLOW_set_in_synpred153_AliasMasker2398 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred153_AliasMasker2451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_join_item_in_synpred153_AliasMasker2454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred171_AliasMasker2871 = new BitSet(new long[]{0x0000000000000002L});

}