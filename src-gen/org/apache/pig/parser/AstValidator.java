// $ANTLR 3.4 /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g 2014-11-19 11:26:41

package org.apache.pig.parser;

import org.apache.pig.data.DataType;
import org.apache.pig.impl.util.NumValCarrier;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


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
public class AstValidator extends TreeParser {
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


    public AstValidator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AstValidator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AstValidator.tokenNames; }
    public String getGrammarFileName() { return "/home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g"; }



    private static Log log = LogFactory.getLog( AstValidator.class );

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

    private void validateSchemaAliasName(Set<String> fieldNames, CommonTree node, String name)
    throws DuplicatedSchemaAliasException {
        if( fieldNames.contains( name ) ) {
            throw new DuplicatedSchemaAliasException( input,
                new SourceLocation( (PigParserNode)node ), name );
        } else {
            fieldNames.add( name );
        }
    }

    private void validateAliasRef(Set<String> aliases, CommonTree node, String alias)
    throws UndefinedAliasException {
        if( !aliases.contains( alias ) ) {
            throw new UndefinedAliasException( input, new SourceLocation( (PigParserNode)node ), alias );
        }
    }

    private void checkDuplication(int count, CommonTree node) throws ParserValidationException {
        if( count > 1 ) {
            throw new ParserValidationException( input, new SourceLocation( (PigParserNode)node ),
                "Duplicated command option" );
        }
    }

    private String lastRel = null;

    private String getLastRel(CommonTree node) throws UndefinedAliasException {
        if (lastRel != null) {
            return lastRel;
        }
        throw new UndefinedAliasException( input, new SourceLocation((PigParserNode)node), "@");
    }

    private Set<String> aliases = new HashSet<String>() {
        @Override
        public boolean add(String e) {
            lastRel = e;
            return super.add(e);
        }
    };



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:113:1: query : ^( QUERY ( statement )* ) ;
    public final AstValidator.query_return query() throws RecognitionException {
        AstValidator.query_return retval = new AstValidator.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AstValidator.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:113:7: ( ^( QUERY ( statement )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:113:9: ^( QUERY ( statement )* )
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
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:113:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==CACHE||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:113:18: statement
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:116:1: statement : ( general_statement | split_statement | realias_statement | rel_cache_statement );
    public final AstValidator.statement_return statement() throws RecognitionException {
        AstValidator.statement_return retval = new AstValidator.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.general_statement_return general_statement3 =null;

        AstValidator.split_statement_return split_statement4 =null;

        AstValidator.realias_statement_return realias_statement5 =null;

        AstValidator.rel_cache_statement_return rel_cache_statement6 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:116:11: ( general_statement | split_statement | realias_statement | rel_cache_statement )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:116:13: general_statement
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:117:13: split_statement
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:118:13: realias_statement
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
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:119:13: rel_cache_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_cache_statement_in_statement136);
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
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:122:1: split_statement : split_clause ;
    public final AstValidator.split_statement_return split_statement() throws RecognitionException {
        AstValidator.split_statement_return retval = new AstValidator.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.split_clause_return split_clause7 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:122:17: ( split_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:122:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement145);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:125:1: realias_statement : realias_clause ;
    public final AstValidator.realias_statement_return realias_statement() throws RecognitionException {
        AstValidator.realias_statement_return retval = new AstValidator.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.realias_clause_return realias_clause8 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:125:19: ( realias_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:125:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement154);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:128:1: rel_cache_statement : rel_cache_clause ;
    public final AstValidator.rel_cache_statement_return rel_cache_statement() throws RecognitionException {
        AstValidator.rel_cache_statement_return retval = new AstValidator.rel_cache_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.rel_cache_clause_return rel_cache_clause9 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:128:20: ( rel_cache_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:128:22: rel_cache_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_cache_clause_in_rel_cache_statement162);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:131:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AstValidator.general_statement_return general_statement() throws RecognitionException {
        AstValidator.general_statement_return retval = new AstValidator.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT10=null;
        AstValidator.alias_return alias11 =null;

        AstValidator.op_clause_return op_clause12 =null;

        AstValidator.parallel_clause_return parallel_clause13 =null;


        CommonTree STATEMENT10_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:131:19: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:131:21: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT10=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement173); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT10_tree = (CommonTree)adaptor.dupNode(STATEMENT10);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT10_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:131:34: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:131:36: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement177);
                    alias11=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias11.getTree());


                    if ( state.backtracking==0 ) { aliases.add( (alias11!=null?alias11.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement184);
            op_clause12=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause12.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:131:87: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:131:87: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement186);
                    parallel_clause13=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause13.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:134:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AstValidator.realias_clause_return realias_clause() throws RecognitionException {
        AstValidator.realias_clause_return retval = new AstValidator.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS14=null;
        CommonTree IDENTIFIER16=null;
        AstValidator.alias_return alias15 =null;


        CommonTree REALIAS14_tree=null;
        CommonTree IDENTIFIER16_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:134:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:134:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS14=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause199); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS14_tree = (CommonTree)adaptor.dupNode(REALIAS14);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS14_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause201);
            alias15=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias15.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER16=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause203); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER16_tree = (CommonTree)adaptor.dupNode(IDENTIFIER16);


            adaptor.addChild(root_1, IDENTIFIER16_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias15!=null?alias15.name:null) );
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:140:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AstValidator.parallel_clause_return parallel_clause() throws RecognitionException {
        AstValidator.parallel_clause_return retval = new AstValidator.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL17=null;
        CommonTree INTEGER18=null;

        CommonTree PARALLEL17_tree=null;
        CommonTree INTEGER18_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:140:17: ( ^( PARALLEL INTEGER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:140:19: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL17=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause220); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL17_tree = (CommonTree)adaptor.dupNode(PARALLEL17);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL17_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER18=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause222); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER18_tree = (CommonTree)adaptor.dupNode(INTEGER18);


            adaptor.addChild(root_1, INTEGER18_tree);
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
        public String name;
        public CommonTree node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:143:1: alias returns [String name, CommonTree node] : IDENTIFIER ;
    public final AstValidator.alias_return alias() throws RecognitionException {
        AstValidator.alias_return retval = new AstValidator.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER19=null;

        CommonTree IDENTIFIER19_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:144:2: ( IDENTIFIER )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:144:4: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER19=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER19_tree = (CommonTree)adaptor.dupNode(IDENTIFIER19);


            adaptor.addChild(root_0, IDENTIFIER19_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.name = (IDENTIFIER19!=null?IDENTIFIER19.getText():null);
                   retval.node = IDENTIFIER19;
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


    public static class previous_rel_return extends TreeRuleReturnScope {
        public String name;
        public CommonTree node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "previous_rel"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:151:1: previous_rel returns [String name, CommonTree node] : ARROBA ;
    public final AstValidator.previous_rel_return previous_rel() throws RecognitionException {
        AstValidator.previous_rel_return retval = new AstValidator.previous_rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARROBA20=null;

        CommonTree ARROBA20_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:152:2: ( ARROBA )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:152:4: ARROBA
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            ARROBA20=(CommonTree)match(input,ARROBA,FOLLOW_ARROBA_in_previous_rel255); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARROBA20_tree = (CommonTree)adaptor.dupNode(ARROBA20);


            adaptor.addChild(root_0, ARROBA20_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.name = getLastRel(ARROBA20);
                   retval.node = ARROBA20;
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
    // $ANTLR end "previous_rel"


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:159:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause );
    public final AstValidator.op_clause_return op_clause() throws RecognitionException {
        AstValidator.op_clause_return retval = new AstValidator.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.define_clause_return define_clause21 =null;

        AstValidator.load_clause_return load_clause22 =null;

        AstValidator.group_clause_return group_clause23 =null;

        AstValidator.store_clause_return store_clause24 =null;

        AstValidator.filter_clause_return filter_clause25 =null;

        AstValidator.distinct_clause_return distinct_clause26 =null;

        AstValidator.limit_clause_return limit_clause27 =null;

        AstValidator.sample_clause_return sample_clause28 =null;

        AstValidator.order_clause_return order_clause29 =null;

        AstValidator.rank_clause_return rank_clause30 =null;

        AstValidator.cross_clause_return cross_clause31 =null;

        AstValidator.join_clause_return join_clause32 =null;

        AstValidator.union_clause_return union_clause33 =null;

        AstValidator.stream_clause_return stream_clause34 =null;

        AstValidator.mr_clause_return mr_clause35 =null;

        AstValidator.split_clause_return split_clause36 =null;

        AstValidator.foreach_clause_return foreach_clause37 =null;

        AstValidator.cube_clause_return cube_clause38 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:159:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:159:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause269);
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:160:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause283);
                    load_clause22=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause22.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:161:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause297);
                    group_clause23=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause23.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:162:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause311);
                    store_clause24=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause24.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:163:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause325);
                    filter_clause25=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause25.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:164:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause339);
                    distinct_clause26=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:165:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause353);
                    limit_clause27=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause27.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:166:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause367);
                    sample_clause28=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause28.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:167:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause381);
                    order_clause29=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause29.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:168:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause395);
                    rank_clause30=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause30.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:169:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause409);
                    cross_clause31=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause31.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:170:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause423);
                    join_clause32=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause32.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:171:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause437);
                    union_clause33=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause33.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:172:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause451);
                    stream_clause34=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause34.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:173:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause465);
                    mr_clause35=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause35.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:174:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause479);
                    split_clause36=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause36.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:175:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause493);
                    foreach_clause37=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause37.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:176:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause507);
                    cube_clause38=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause38.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:179:1: define_clause : ^( DEFINE alias ( cmd | func_clause ) ) ;
    public final AstValidator.define_clause_return define_clause() throws RecognitionException {
        AstValidator.define_clause_return retval = new AstValidator.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE39=null;
        AstValidator.alias_return alias40 =null;

        AstValidator.cmd_return cmd41 =null;

        AstValidator.func_clause_return func_clause42 =null;


        CommonTree DEFINE39_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:179:15: ( ^( DEFINE alias ( cmd | func_clause ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:179:17: ^( DEFINE alias ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE39=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause518); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE39_tree = (CommonTree)adaptor.dupNode(DEFINE39);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE39_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_define_clause520);
            alias40=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias40.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:179:33: ( cmd | func_clause )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:179:35: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause524);
                    cmd41=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd41.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:179:41: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause528);
                    func_clause42=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause42.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:182:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AstValidator.cmd_return cmd() throws RecognitionException {
        AstValidator.cmd_return retval = new AstValidator.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND43=null;
        AstValidator.ship_clause_return ship_clause44 =null;

        AstValidator.cache_clause_return cache_clause45 =null;

        AstValidator.input_clause_return input_clause46 =null;

        AstValidator.output_clause_return output_clause47 =null;

        AstValidator.error_clause_return error_clause48 =null;


        CommonTree EXECCOMMAND43_tree=null;


            int ship = 0;
            int cache = 0;
            int in = 0;
            int out = 0;
            int error = 0;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:190:2: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:190:4: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND43=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd549); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND43_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND43);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND43_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:190:19: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
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
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:190:21: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd553);
                	    ship_clause44=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause44.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++ship, (ship_clause44!=null?((CommonTree)ship_clause44.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:191:21: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd577);
                	    cache_clause45=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause45.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++cache, (cache_clause45!=null?((CommonTree)cache_clause45.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:192:21: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd601);
                	    input_clause46=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause46.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++in, (input_clause46!=null?((CommonTree)input_clause46.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:193:21: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd625);
                	    output_clause47=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause47.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++out, (output_clause47!=null?((CommonTree)output_clause47.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:194:21: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd649);
                	    error_clause48=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause48.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++error, (error_clause48!=null?((CommonTree)error_clause48.start):null) ); }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:199:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AstValidator.ship_clause_return ship_clause() throws RecognitionException {
        AstValidator.ship_clause_return retval = new AstValidator.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP49=null;
        AstValidator.path_list_return path_list50 =null;


        CommonTree SHIP49_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:199:13: ( ^( SHIP ( path_list )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:199:15: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP49=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause688); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP49_tree = (CommonTree)adaptor.dupNode(SHIP49);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP49_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:199:23: ( path_list )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:199:23: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause690);
                        path_list50=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list50.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:202:1: path_list : ( QUOTEDSTRING )+ ;
    public final AstValidator.path_list_return path_list() throws RecognitionException {
        AstValidator.path_list_return retval = new AstValidator.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING51=null;

        CommonTree QUOTEDSTRING51_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:202:11: ( ( QUOTEDSTRING )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:202:13: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:202:13: ( QUOTEDSTRING )+
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
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:202:13: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING51=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list702); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING51_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING51);


            	    adaptor.addChild(root_0, QUOTEDSTRING51_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:205:1: cache_clause : ^( CACHE path_list ) ;
    public final AstValidator.cache_clause_return cache_clause() throws RecognitionException {
        AstValidator.cache_clause_return retval = new AstValidator.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE52=null;
        AstValidator.path_list_return path_list53 =null;


        CommonTree CACHE52_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:205:14: ( ^( CACHE path_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:205:16: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE52=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause714); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE52_tree = (CommonTree)adaptor.dupNode(CACHE52);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE52_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause716);
            path_list53=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list53.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:208:1: input_clause : ^( INPUT ( stream_cmd )+ ) ;
    public final AstValidator.input_clause_return input_clause() throws RecognitionException {
        AstValidator.input_clause_return retval = new AstValidator.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT54=null;
        AstValidator.stream_cmd_return stream_cmd55 =null;


        CommonTree INPUT54_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:208:14: ( ^( INPUT ( stream_cmd )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:208:16: ^( INPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT54=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause729); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT54_tree = (CommonTree)adaptor.dupNode(INPUT54);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT54_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:208:25: ( stream_cmd )+
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
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:208:25: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause731);
            	    stream_cmd55=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd55.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:211:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AstValidator.stream_cmd_return stream_cmd() throws RecognitionException {
        AstValidator.stream_cmd_return retval = new AstValidator.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN56=null;
        CommonTree STDOUT58=null;
        CommonTree QUOTEDSTRING60=null;
        AstValidator.func_clause_return func_clause57 =null;

        AstValidator.func_clause_return func_clause59 =null;

        AstValidator.func_clause_return func_clause61 =null;


        CommonTree STDIN56_tree=null;
        CommonTree STDOUT58_tree=null;
        CommonTree QUOTEDSTRING60_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:211:12: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:211:14: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN56=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd745); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN56_tree = (CommonTree)adaptor.dupNode(STDIN56);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN56_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:211:23: ( func_clause )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:211:23: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd747);
                                func_clause57=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause57.getTree());


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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:212:14: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT58=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd767); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT58_tree = (CommonTree)adaptor.dupNode(STDOUT58);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT58_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:212:24: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:212:24: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd769);
                                func_clause59=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause59.getTree());


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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:213:14: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING60=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd789); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING60_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING60);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING60_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:213:30: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:213:30: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd791);
                                func_clause61=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause61.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:216:1: output_clause : ^( OUTPUT ( stream_cmd )+ ) ;
    public final AstValidator.output_clause_return output_clause() throws RecognitionException {
        AstValidator.output_clause_return retval = new AstValidator.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT62=null;
        AstValidator.stream_cmd_return stream_cmd63 =null;


        CommonTree OUTPUT62_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:216:15: ( ^( OUTPUT ( stream_cmd )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:216:17: ^( OUTPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT62=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause805); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT62_tree = (CommonTree)adaptor.dupNode(OUTPUT62);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT62_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:216:27: ( stream_cmd )+
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
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:216:27: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause807);
            	    stream_cmd63=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd63.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:219:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AstValidator.error_clause_return error_clause() throws RecognitionException {
        AstValidator.error_clause_return retval = new AstValidator.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR64=null;
        CommonTree QUOTEDSTRING65=null;
        CommonTree INTEGER66=null;

        CommonTree STDERROR64_tree=null;
        CommonTree QUOTEDSTRING65_tree=null;
        CommonTree INTEGER66_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:219:14: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:219:16: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR64=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause821); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR64_tree = (CommonTree)adaptor.dupNode(STDERROR64);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR64_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:219:29: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:219:31: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING65=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause826); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING65_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING65);


                        adaptor.addChild(root_1, QUOTEDSTRING65_tree);
                        }


                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:219:44: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:219:44: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER66=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause828); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER66_tree = (CommonTree)adaptor.dupNode(INTEGER66);


                                adaptor.addChild(root_1, INTEGER66_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:222:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AstValidator.load_clause_return load_clause() throws RecognitionException {
        AstValidator.load_clause_return retval = new AstValidator.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD67=null;
        AstValidator.filename_return filename68 =null;

        AstValidator.func_clause_return func_clause69 =null;

        AstValidator.as_clause_return as_clause70 =null;


        CommonTree LOAD67_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:222:13: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:222:15: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD67=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause845); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD67_tree = (CommonTree)adaptor.dupNode(LOAD67);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD67_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause847);
            filename68=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename68.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:222:32: ( func_clause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:222:32: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause849);
                    func_clause69=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause69.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:222:45: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:222:45: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause852);
                    as_clause70=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause70.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:225:1: filename : QUOTEDSTRING ;
    public final AstValidator.filename_return filename() throws RecognitionException {
        AstValidator.filename_return retval = new AstValidator.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING71=null;

        CommonTree QUOTEDSTRING71_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:225:10: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:225:12: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING71=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename864); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING71_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING71);


            adaptor.addChild(root_0, QUOTEDSTRING71_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:228:1: as_clause : ^( AS field_def_list ) ;
    public final AstValidator.as_clause_return as_clause() throws RecognitionException {
        AstValidator.as_clause_return retval = new AstValidator.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS72=null;
        AstValidator.field_def_list_return field_def_list73 =null;


        CommonTree AS72_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:228:10: ( ^( AS field_def_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:228:12: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS72=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause874); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS72_tree = (CommonTree)adaptor.dupNode(AS72);


            root_1 = (CommonTree)adaptor.becomeRoot(AS72_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause876);
            field_def_list73=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list73.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:231:1: field_def[Set<String> fieldNames, NumValCarrier nvc] : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) );
    public final AstValidator.field_def_return field_def(Set<String> fieldNames, NumValCarrier nvc) throws RecognitionException, DuplicatedSchemaAliasException {
        AstValidator.field_def_return retval = new AstValidator.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF74=null;
        CommonTree IDENTIFIER75=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER77=null;
        AstValidator.type_return type76 =null;

        AstValidator.type_return type78 =null;


        CommonTree FIELD_DEF74_tree=null;
        CommonTree IDENTIFIER75_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER77_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:232:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:232:4: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF74=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def895); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF74_tree = (CommonTree)adaptor.dupNode(FIELD_DEF74);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER75=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def897); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER75_tree = (CommonTree)adaptor.dupNode(IDENTIFIER75);


                    adaptor.addChild(root_1, IDENTIFIER75_tree);
                    }


                    if ( state.backtracking==0 ) { validateSchemaAliasName( fieldNames, IDENTIFIER75, (IDENTIFIER75!=null?IDENTIFIER75.getText():null) ); }

                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:232:102: ( type )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==BIGDECIMAL||LA20_0==BIGINTEGER||LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DATETIME||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:232:102: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def901);
                            type76=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type76.getTree());


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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:233:4: ^( FIELD_DEF_WITHOUT_IDENTIFIER type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER77=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def911); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER77_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER77);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER77_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def913);
                    type78=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type78.getTree());


                    if ( state.backtracking==0 ) { validateSchemaAliasName ( fieldNames, FIELD_DEF_WITHOUT_IDENTIFIER77, nvc.makeNameFromDataType ( (type78!=null?type78.typev:0) ) ); }

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


    protected static class field_def_list_scope {
        Set<String> fieldNames;
        NumValCarrier nvc;
    }
    protected Stack field_def_list_stack = new Stack();


    public static class field_def_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:236:1: field_def_list : ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+ ;
    public final AstValidator.field_def_list_return field_def_list() throws RecognitionException, DuplicatedSchemaAliasException {
        field_def_list_stack.push(new field_def_list_scope());
        AstValidator.field_def_list_return retval = new AstValidator.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.field_def_return field_def79 =null;




            ((field_def_list_scope)field_def_list_stack.peek()).fieldNames = new HashSet<String>();
            ((field_def_list_scope)field_def_list_stack.peek()).nvc = new NumValCarrier();

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:245:2: ( ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:245:4: ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:245:4: ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+
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
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:245:6: field_def[$field_def_list::fieldNames, $field_def_list::nvc]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list941);
            	    field_def79=field_def(((field_def_list_scope)field_def_list_stack.peek()).fieldNames, ((field_def_list_scope)field_def_list_stack.peek()).nvc);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def79.getTree());


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
            field_def_list_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        public byte typev;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:248:1: type returns [byte typev] : ( simple_type | tuple_type | bag_type | map_type );
    public final AstValidator.type_return type() throws RecognitionException {
        AstValidator.type_return retval = new AstValidator.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.simple_type_return simple_type80 =null;

        AstValidator.tuple_type_return tuple_type81 =null;

        AstValidator.bag_type_return bag_type82 =null;

        AstValidator.map_type_return map_type83 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:249:3: ( simple_type | tuple_type | bag_type | map_type )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:249:5: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type960);
                    simple_type80=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type80.getTree());


                    if ( state.backtracking==0 ) { retval.typev = (simple_type80!=null?simple_type80.typev:0); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:250:5: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type968);
                    tuple_type81=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type81.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.TUPLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:251:5: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type976);
                    bag_type82=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type82.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.BAG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:252:5: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type984);
                    map_type83=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type83.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.MAP; }

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
        public byte typev;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:255:1: simple_type returns [byte typev] : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
    public final AstValidator.simple_type_return simple_type() throws RecognitionException {
        AstValidator.simple_type_return retval = new AstValidator.simple_type_return();
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
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:256:3: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:256:5: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN84=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1001); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN84_tree = (CommonTree)adaptor.dupNode(BOOLEAN84);


                    adaptor.addChild(root_0, BOOLEAN84_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BOOLEAN; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:257:5: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT85=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1009); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT85_tree = (CommonTree)adaptor.dupNode(INT85);


                    adaptor.addChild(root_0, INT85_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.INTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:258:5: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG86=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1017); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG86_tree = (CommonTree)adaptor.dupNode(LONG86);


                    adaptor.addChild(root_0, LONG86_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.LONG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:259:5: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT87=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1025); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT87_tree = (CommonTree)adaptor.dupNode(FLOAT87);


                    adaptor.addChild(root_0, FLOAT87_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.FLOAT; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:260:5: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE88=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1033); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE88_tree = (CommonTree)adaptor.dupNode(DOUBLE88);


                    adaptor.addChild(root_0, DOUBLE88_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.DOUBLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:261:5: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER89=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1041); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER89_tree = (CommonTree)adaptor.dupNode(BIGINTEGER89);


                    adaptor.addChild(root_0, BIGINTEGER89_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BIGINTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:262:5: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL90=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1049); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL90_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL90);


                    adaptor.addChild(root_0, BIGDECIMAL90_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BIGDECIMAL; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:263:5: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME91=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1057); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME91_tree = (CommonTree)adaptor.dupNode(DATETIME91);


                    adaptor.addChild(root_0, DATETIME91_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.DATETIME; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:264:5: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY92=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1065); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY92_tree = (CommonTree)adaptor.dupNode(CHARARRAY92);


                    adaptor.addChild(root_0, CHARARRAY92_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.CHARARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:265:5: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY93=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1073); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY93_tree = (CommonTree)adaptor.dupNode(BYTEARRAY93);


                    adaptor.addChild(root_0, BYTEARRAY93_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BYTEARRAY; }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:268:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AstValidator.tuple_type_return tuple_type() throws RecognitionException {
        AstValidator.tuple_type_return retval = new AstValidator.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE94=null;
        AstValidator.field_def_list_return field_def_list95 =null;


        CommonTree TUPLE_TYPE94_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:268:12: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:268:14: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE94=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1086); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE94_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE94);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE94_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:268:28: ( field_def_list )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0 >= FIELD_DEF && LA25_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:268:28: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1088);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:271:1: bag_type : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final AstValidator.bag_type_return bag_type() throws RecognitionException {
        AstValidator.bag_type_return retval = new AstValidator.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE96=null;
        CommonTree IDENTIFIER97=null;
        AstValidator.tuple_type_return tuple_type98 =null;


        CommonTree BAG_TYPE96_tree=null;
        CommonTree IDENTIFIER97_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:271:10: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:271:12: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE96=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1102); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE96_tree = (CommonTree)adaptor.dupNode(BAG_TYPE96);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE96_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:271:24: ( IDENTIFIER )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==IDENTIFIER) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:271:24: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER97=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1104); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER97_tree = (CommonTree)adaptor.dupNode(IDENTIFIER97);


                        adaptor.addChild(root_1, IDENTIFIER97_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:271:36: ( tuple_type )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==TUPLE_TYPE) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:271:36: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1107);
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


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:274:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AstValidator.map_type_return map_type() throws RecognitionException {
        AstValidator.map_type_return retval = new AstValidator.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE99=null;
        AstValidator.type_return type100 =null;


        CommonTree MAP_TYPE99_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:274:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:274:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE99=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1121); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE99_tree = (CommonTree)adaptor.dupNode(MAP_TYPE99);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE99_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:274:24: ( type )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==BIGDECIMAL||LA28_0==BIGINTEGER||LA28_0==BOOLEAN||LA28_0==BYTEARRAY||LA28_0==CHARARRAY||LA28_0==DATETIME||LA28_0==DOUBLE||LA28_0==FLOAT||LA28_0==INT||LA28_0==LONG||LA28_0==BAG_TYPE||LA28_0==MAP_TYPE||LA28_0==TUPLE_TYPE) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:274:24: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1123);
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


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:277:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AstValidator.func_clause_return func_clause() throws RecognitionException {
        AstValidator.func_clause_return retval = new AstValidator.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF101=null;
        CommonTree FUNC103=null;
        AstValidator.func_name_return func_name102 =null;

        AstValidator.func_name_return func_name104 =null;

        AstValidator.func_args_return func_args105 =null;


        CommonTree FUNC_REF101_tree=null;
        CommonTree FUNC103_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:277:13: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:277:15: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF101=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1137); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF101_tree = (CommonTree)adaptor.dupNode(FUNC_REF101);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF101_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1139);
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:278:15: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC103=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC103_tree = (CommonTree)adaptor.dupNode(FUNC103);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC103_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1161);
                    func_name104=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name104.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:278:33: ( func_args )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==MULTILINE_QUOTEDSTRING||LA29_0==QUOTEDSTRING) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:278:33: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1163);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:281:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AstValidator.func_name_return func_name() throws RecognitionException {
        AstValidator.func_name_return retval = new AstValidator.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set107=null;
        AstValidator.eid_return eid106 =null;

        AstValidator.eid_return eid108 =null;


        CommonTree set107_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:281:11: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:281:13: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1175);
            eid106=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid106.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:281:17: ( ( PERIOD | DOLLAR ) eid )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==DOLLAR||LA31_0==PERIOD) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:281:19: ( PERIOD | DOLLAR ) eid
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    set107=(CommonTree)input.LT(1);

            	    if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) {
            	        set107_tree = (CommonTree)adaptor.dupNode(set107);


            	        adaptor.addChild(root_0, set107_tree);
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
            	    pushFollow(FOLLOW_eid_in_func_name1189);
            	    eid108=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid108.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop31;
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


    public static class func_args_string_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args_string"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:284:1: func_args_string : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING );
    public final AstValidator.func_args_string_return func_args_string() throws RecognitionException {
        AstValidator.func_args_string_return retval = new AstValidator.func_args_string_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set109=null;

        CommonTree set109_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:284:18: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set109=(CommonTree)input.LT(1);

            if ( input.LA(1)==MULTILINE_QUOTEDSTRING||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set109_tree = (CommonTree)adaptor.dupNode(set109);


                adaptor.addChild(root_0, set109_tree);
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
    // $ANTLR end "func_args_string"


    public static class func_args_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:287:1: func_args : ( func_args_string )+ ;
    public final AstValidator.func_args_return func_args() throws RecognitionException {
        AstValidator.func_args_return retval = new AstValidator.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.func_args_string_return func_args_string110 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:287:11: ( ( func_args_string )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:287:13: ( func_args_string )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:287:13: ( func_args_string )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==MULTILINE_QUOTEDSTRING||LA32_0==QUOTEDSTRING) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:287:13: func_args_string
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_func_args_string_in_func_args1214);
            	    func_args_string110=func_args_string();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, func_args_string110.getTree());


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
    // $ANTLR end "func_args"


    public static class cube_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:290:1: cube_clause : ^( CUBE cube_item ) ;
    public final AstValidator.cube_clause_return cube_clause() throws RecognitionException {
        AstValidator.cube_clause_return retval = new AstValidator.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE111=null;
        AstValidator.cube_item_return cube_item112 =null;


        CommonTree CUBE111_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:291:2: ( ^( CUBE cube_item ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:291:4: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE111=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1227); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE111_tree = (CommonTree)adaptor.dupNode(CUBE111);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE111_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1229);
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
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:294:1: cube_item : rel ( cube_by_clause ) ;
    public final AstValidator.cube_item_return cube_item() throws RecognitionException {
        AstValidator.cube_item_return retval = new AstValidator.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.rel_return rel113 =null;

        AstValidator.cube_by_clause_return cube_by_clause114 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:295:2: ( rel ( cube_by_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:295:4: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1241);
            rel113=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel113.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:295:8: ( cube_by_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:295:10: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1245);
            cube_by_clause114=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause114.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:298:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AstValidator.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AstValidator.cube_by_clause_return retval = new AstValidator.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY115=null;
        AstValidator.cube_or_rollup_return cube_or_rollup116 =null;


        CommonTree BY115_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:299:2: ( ^( BY cube_or_rollup ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:299:4: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY115=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1259); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY115_tree = (CommonTree)adaptor.dupNode(BY115);


            root_1 = (CommonTree)adaptor.becomeRoot(BY115_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1261);
            cube_or_rollup116=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup116.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:302:1: cube_or_rollup : ( cube_rollup_list )+ ;
    public final AstValidator.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AstValidator.cube_or_rollup_return retval = new AstValidator.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.cube_rollup_list_return cube_rollup_list117 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:303:2: ( ( cube_rollup_list )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:303:4: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:303:4: ( cube_rollup_list )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==CUBE||LA33_0==ROLLUP) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:303:4: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1273);
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
    // $ANTLR end "cube_or_rollup"


    public static class cube_rollup_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:306:1: cube_rollup_list : ^( ( CUBE | ROLLUP ) cube_by_expr_list ) ;
    public final AstValidator.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AstValidator.cube_rollup_list_return retval = new AstValidator.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set118=null;
        AstValidator.cube_by_expr_list_return cube_by_expr_list119 =null;


        CommonTree set118_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:307:2: ( ^( ( CUBE | ROLLUP ) cube_by_expr_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:307:4: ^( ( CUBE | ROLLUP ) cube_by_expr_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set118=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==ROLLUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set118_tree = (CommonTree)adaptor.dupNode(set118);


                root_1 = (CommonTree)adaptor.becomeRoot(set118_tree, root_1);
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
            pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1296);
            cube_by_expr_list119=cube_by_expr_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_by_expr_list119.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:310:1: cube_by_expr_list : ( cube_by_expr )+ ;
    public final AstValidator.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AstValidator.cube_by_expr_list_return retval = new AstValidator.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.cube_by_expr_return cube_by_expr120 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:311:2: ( ( cube_by_expr )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:311:4: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:311:4: ( cube_by_expr )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==BIGDECIMALNUMBER||LA34_0==BIGINTEGERNUMBER||LA34_0==CUBE||LA34_0==DIV||LA34_0==DOLLARVAR||LA34_0==DOUBLENUMBER||LA34_0==FALSE||LA34_0==FLOATNUMBER||LA34_0==GROUP||LA34_0==IDENTIFIER||LA34_0==INTEGER||LA34_0==LONGINTEGER||LA34_0==MINUS||LA34_0==NULL||LA34_0==PERCENT||LA34_0==PLUS||LA34_0==QUOTEDSTRING||LA34_0==STAR||LA34_0==TRUE||(LA34_0 >= BAG_VAL && LA34_0 <= BIN_EXPR)||(LA34_0 >= CASE_COND && LA34_0 <= EXPR_IN_PAREN)||LA34_0==FUNC_EVAL||LA34_0==INVOKER_FUNC_EVAL||(LA34_0 >= MAP_VAL && LA34_0 <= NEG)||LA34_0==TUPLE_VAL) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:311:4: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1308);
            	    cube_by_expr120=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr120.getTree());


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
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:314:1: cube_by_expr : ( col_range | expr | STAR );
    public final AstValidator.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AstValidator.cube_by_expr_return retval = new AstValidator.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR123=null;
        AstValidator.col_range_return col_range121 =null;

        AstValidator.expr_return expr122 =null;


        CommonTree STAR123_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:315:2: ( col_range | expr | STAR )
            int alt35=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt35=1;
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
                alt35=2;
                }
                break;
            case STAR:
                {
                int LA35_3 = input.LA(2);

                if ( (LA35_3==DOWN) ) {
                    alt35=2;
                }
                else if ( (LA35_3==EOF||LA35_3==UP||LA35_3==BIGDECIMALNUMBER||LA35_3==BIGINTEGERNUMBER||LA35_3==CUBE||LA35_3==DIV||LA35_3==DOLLARVAR||LA35_3==DOUBLENUMBER||LA35_3==FALSE||LA35_3==FLOATNUMBER||LA35_3==GROUP||LA35_3==IDENTIFIER||LA35_3==INTEGER||LA35_3==LONGINTEGER||LA35_3==MINUS||LA35_3==NULL||LA35_3==PERCENT||LA35_3==PLUS||LA35_3==QUOTEDSTRING||LA35_3==STAR||LA35_3==TRUE||(LA35_3 >= BAG_VAL && LA35_3 <= BIN_EXPR)||(LA35_3 >= CASE_COND && LA35_3 <= EXPR_IN_PAREN)||LA35_3==FUNC_EVAL||LA35_3==INVOKER_FUNC_EVAL||(LA35_3 >= MAP_VAL && LA35_3 <= NEG)||LA35_3==TUPLE_VAL) ) {
                    alt35=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }

            switch (alt35) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:315:4: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1319);
                    col_range121=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range121.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:315:16: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1323);
                    expr122=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr122.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:315:23: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR123=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1327); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR123_tree = (CommonTree)adaptor.dupNode(STAR123);


                    adaptor.addChild(root_0, STAR123_tree);
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
        int arity;
    }
    protected Stack group_clause_stack = new Stack();


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:318:1: group_clause : ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) ;
    public final AstValidator.group_clause_return group_clause() throws RecognitionException {
        group_clause_stack.push(new group_clause_scope());
        AstValidator.group_clause_return retval = new AstValidator.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set124=null;
        AstValidator.group_item_return group_item125 =null;

        AstValidator.group_type_return group_type126 =null;

        AstValidator.partition_clause_return partition_clause127 =null;


        CommonTree set124_tree=null;


            ((group_clause_scope)group_clause_stack.peek()).arity = 0;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:325:2: ( ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:325:4: ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set124=(CommonTree)input.LT(1);

            if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set124_tree = (CommonTree)adaptor.dupNode(set124);


                root_1 = (CommonTree)adaptor.becomeRoot(set124_tree, root_1);
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
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:325:27: ( group_item )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==ARROBA||LA36_0==COGROUP||(LA36_0 >= CROSS && LA36_0 <= CUBE)||LA36_0==DEFINE||LA36_0==DISTINCT||LA36_0==FILTER||LA36_0==FOREACH||LA36_0==GROUP||LA36_0==IDENTIFIER||LA36_0==JOIN||(LA36_0 >= LIMIT && LA36_0 <= LOAD)||LA36_0==MAPREDUCE||LA36_0==ORDER||LA36_0==RANK||LA36_0==SAMPLE||LA36_0==SPLIT||(LA36_0 >= STORE && LA36_0 <= STREAM)||LA36_0==UNION) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:325:27: group_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1358);
            	    group_item125=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item125.getTree());


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


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:325:39: ( group_type )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==QUOTEDSTRING) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:325:39: group_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1361);
                    group_type126=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type126.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:325:51: ( partition_clause )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==PARTITION) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:325:51: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1364);
                    partition_clause127=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause127.getTree());


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
            group_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:328:1: group_type : QUOTEDSTRING ;
    public final AstValidator.group_type_return group_type() throws RecognitionException {
        AstValidator.group_type_return retval = new AstValidator.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING128=null;

        CommonTree QUOTEDSTRING128_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:328:12: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:328:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING128=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1376); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING128_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING128);


            adaptor.addChild(root_0, QUOTEDSTRING128_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:331:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AstValidator.group_item_return group_item() throws RecognitionException {
        AstValidator.group_item_return retval = new AstValidator.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL131=null;
        CommonTree ANY132=null;
        CommonTree set133=null;
        AstValidator.rel_return rel129 =null;

        AstValidator.join_group_by_clause_return join_group_by_clause130 =null;


        CommonTree ALL131_tree=null;
        CommonTree ANY132_tree=null;
        CommonTree set133_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:332:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:332:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1386);
            rel129=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel129.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:332:8: ( join_group_by_clause | ALL | ANY )
            int alt39=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt39=1;
                }
                break;
            case ALL:
                {
                alt39=2;
                }
                break;
            case ANY:
                {
                alt39=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }

            switch (alt39) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:332:10: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1390);
                    join_group_by_clause130=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause130.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:332:33: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL131=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1394); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL131_tree = (CommonTree)adaptor.dupNode(ALL131);


                    adaptor.addChild(root_0, ALL131_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:332:39: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY132=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1398); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY132_tree = (CommonTree)adaptor.dupNode(ANY132);


                    adaptor.addChild(root_0, ANY132_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:332:45: ( INNER | OUTER )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==INNER||LA40_0==OUTER) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set133=(CommonTree)input.LT(1);

                    if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set133_tree = (CommonTree)adaptor.dupNode(set133);


                        adaptor.addChild(root_0, set133_tree);
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
                   if( ((group_clause_scope)group_clause_stack.peek()).arity == 0 ) {
                       // For the first input
                       ((group_clause_scope)group_clause_stack.peek()).arity = (join_group_by_clause130!=null?join_group_by_clause130.exprCount:0);
                   } else if( (join_group_by_clause130!=null?join_group_by_clause130.exprCount:0) != ((group_clause_scope)group_clause_stack.peek()).arity ) {
                       throw new ParserValidationException( input, new SourceLocation( (PigParserNode)((CommonTree)retval.start) ),
                           "The arity of the group by columns do not match." );
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
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:344:1: rel : ( alias | previous_rel | op_clause ( parallel_clause )? );
    public final AstValidator.rel_return rel() throws RecognitionException {
        AstValidator.rel_return retval = new AstValidator.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.alias_return alias134 =null;

        AstValidator.previous_rel_return previous_rel135 =null;

        AstValidator.op_clause_return op_clause136 =null;

        AstValidator.parallel_clause_return parallel_clause137 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:344:5: ( alias | previous_rel | op_clause ( parallel_clause )? )
            int alt42=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt42=1;
                }
                break;
            case ARROBA:
                {
                alt42=2;
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
            case SPLIT:
            case STORE:
            case STREAM:
            case UNION:
                {
                alt42=3;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:344:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1425);
                    alias134=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias134.getTree());


                    if ( state.backtracking==0 ) {  validateAliasRef( aliases, (alias134!=null?alias134.node:null), (alias134!=null?alias134.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:345:7: previous_rel
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_previous_rel_in_rel1435);
                    previous_rel135=previous_rel();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, previous_rel135.getTree());


                    if ( state.backtracking==0 ) { validateAliasRef( aliases, (previous_rel135!=null?previous_rel135.node:null), (previous_rel135!=null?previous_rel135.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:346:7: op_clause ( parallel_clause )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1445);
                    op_clause136=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause136.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:346:17: ( parallel_clause )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==PARALLEL) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:346:17: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1447);
                            parallel_clause137=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause137.getTree());


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
    // $ANTLR end "rel"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:349:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AstValidator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AstValidator.flatten_generated_item_return retval = new AstValidator.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR141=null;
        AstValidator.flatten_clause_return flatten_clause138 =null;

        AstValidator.col_range_return col_range139 =null;

        AstValidator.expr_return expr140 =null;

        AstValidator.field_def_list_return field_def_list142 =null;


        CommonTree STAR141_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:349:24: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:349:26: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:349:26: ( flatten_clause | col_range | expr | STAR )
            int alt43=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt43=1;
                }
                break;
            case COL_RANGE:
                {
                alt43=2;
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
                alt43=3;
                }
                break;
            case STAR:
                {
                int LA43_4 = input.LA(2);

                if ( (LA43_4==DOWN) ) {
                    alt43=3;
                }
                else if ( (LA43_4==EOF||LA43_4==UP||LA43_4==BIGDECIMALNUMBER||LA43_4==BIGINTEGERNUMBER||LA43_4==CUBE||LA43_4==DIV||LA43_4==DOLLARVAR||LA43_4==DOUBLENUMBER||LA43_4==FALSE||LA43_4==FLATTEN||LA43_4==FLOATNUMBER||LA43_4==GROUP||LA43_4==IDENTIFIER||LA43_4==INTEGER||LA43_4==LONGINTEGER||LA43_4==MINUS||LA43_4==NULL||LA43_4==PERCENT||LA43_4==PLUS||LA43_4==QUOTEDSTRING||LA43_4==STAR||LA43_4==TRUE||(LA43_4 >= BAG_VAL && LA43_4 <= BIN_EXPR)||(LA43_4 >= CASE_COND && LA43_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA43_4==FUNC_EVAL||LA43_4==INVOKER_FUNC_EVAL||(LA43_4 >= MAP_VAL && LA43_4 <= NEG)||LA43_4==TUPLE_VAL) ) {
                    alt43=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 4, input);

                    throw nvae;

                }
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:349:28: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1459);
                    flatten_clause138=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause138.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:349:45: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1463);
                    col_range139=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range139.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:349:57: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1467);
                    expr140=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr140.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:349:64: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR141=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1471); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR141_tree = (CommonTree)adaptor.dupNode(STAR141);


                    adaptor.addChild(root_0, STAR141_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:349:71: ( field_def_list )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0 >= FIELD_DEF && LA44_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:349:71: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1475);
                    field_def_list142=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list142.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:352:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AstValidator.flatten_clause_return flatten_clause() throws RecognitionException {
        AstValidator.flatten_clause_return retval = new AstValidator.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN143=null;
        AstValidator.expr_return expr144 =null;


        CommonTree FLATTEN143_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:352:16: ( ^( FLATTEN expr ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:352:18: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN143=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1487); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN143_tree = (CommonTree)adaptor.dupNode(FLATTEN143);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN143_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1489);
            expr144=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr144.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:355:1: store_clause : ^( STORE rel filename ( func_clause )? ) ;
    public final AstValidator.store_clause_return store_clause() throws RecognitionException {
        AstValidator.store_clause_return retval = new AstValidator.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE145=null;
        AstValidator.rel_return rel146 =null;

        AstValidator.filename_return filename147 =null;

        AstValidator.func_clause_return func_clause148 =null;


        CommonTree STORE145_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:355:14: ( ^( STORE rel filename ( func_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:355:16: ^( STORE rel filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE145=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1502); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE145_tree = (CommonTree)adaptor.dupNode(STORE145);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE145_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause1504);
            rel146=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel146.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1506);
            filename147=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename147.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:355:38: ( func_clause )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==FUNC||LA45_0==FUNC_REF) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:355:38: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1508);
                    func_clause148=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause148.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:358:1: filter_clause : ^( FILTER rel cond ) ;
    public final AstValidator.filter_clause_return filter_clause() throws RecognitionException {
        AstValidator.filter_clause_return retval = new AstValidator.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER149=null;
        AstValidator.rel_return rel150 =null;

        AstValidator.cond_return cond151 =null;


        CommonTree FILTER149_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:358:15: ( ^( FILTER rel cond ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:358:17: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER149=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1522); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER149_tree = (CommonTree)adaptor.dupNode(FILTER149);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER149_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1524);
            rel150=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel150.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1526);
            cond151=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond151.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:361:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) );
    public final AstValidator.cond_return cond() throws RecognitionException {
        AstValidator.cond_return retval = new AstValidator.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR152=null;
        CommonTree AND155=null;
        CommonTree NOT158=null;
        CommonTree NULL160=null;
        CommonTree NOT162=null;
        CommonTree BOOL_COND168=null;
        AstValidator.cond_return cond153 =null;

        AstValidator.cond_return cond154 =null;

        AstValidator.cond_return cond156 =null;

        AstValidator.cond_return cond157 =null;

        AstValidator.cond_return cond159 =null;

        AstValidator.expr_return expr161 =null;

        AstValidator.rel_op_return rel_op163 =null;

        AstValidator.expr_return expr164 =null;

        AstValidator.expr_return expr165 =null;

        AstValidator.in_eval_return in_eval166 =null;

        AstValidator.func_eval_return func_eval167 =null;

        AstValidator.expr_return expr169 =null;


        CommonTree OR152_tree=null;
        CommonTree AND155_tree=null;
        CommonTree NOT158_tree=null;
        CommonTree NULL160_tree=null;
        CommonTree NOT162_tree=null;
        CommonTree BOOL_COND168_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:361:6: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) )
            int alt47=8;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt47=1;
                }
                break;
            case AND:
                {
                alt47=2;
                }
                break;
            case NOT:
                {
                alt47=3;
                }
                break;
            case NULL:
                {
                alt47=4;
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
                alt47=5;
                }
                break;
            case IN:
                {
                alt47=6;
                }
                break;
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt47=7;
                }
                break;
            case BOOL_COND:
                {
                alt47=8;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:361:8: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR152=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1539); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR152_tree = (CommonTree)adaptor.dupNode(OR152);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR152_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1541);
                    cond153=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond153.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1543);
                    cond154=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond154.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:362:8: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND155=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1556); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND155_tree = (CommonTree)adaptor.dupNode(AND155);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND155_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1558);
                    cond156=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond156.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1560);
                    cond157=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond157.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:363:8: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT158=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1573); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT158_tree = (CommonTree)adaptor.dupNode(NOT158);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT158_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1575);
                    cond159=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond159.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:364:8: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL160=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1588); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL160_tree = (CommonTree)adaptor.dupNode(NULL160);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL160_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1590);
                    expr161=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr161.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:364:21: ( NOT )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==NOT) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:364:21: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT162=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1592); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT162_tree = (CommonTree)adaptor.dupNode(NOT162);


                            adaptor.addChild(root_1, NOT162_tree);
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:365:8: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1606);
                    rel_op163=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op163.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1608);
                    expr164=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr164.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1610);
                    expr165=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr165.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:366:8: in_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond1621);
                    in_eval166=in_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval166.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:367:8: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1630);
                    func_eval167=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval167.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:368:8: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND168=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond1641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND168_tree = (CommonTree)adaptor.dupNode(BOOL_COND168);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND168_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1643);
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

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:371:1: in_eval : ^( IN expr ( expr )+ ) ;
    public final AstValidator.in_eval_return in_eval() throws RecognitionException {
        AstValidator.in_eval_return retval = new AstValidator.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN170=null;
        AstValidator.expr_return expr171 =null;

        AstValidator.expr_return expr172 =null;


        CommonTree IN170_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:371:8: ( ^( IN expr ( expr )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:371:10: ^( IN expr ( expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN170=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval1655); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN170_tree = (CommonTree)adaptor.dupNode(IN170);


            root_1 = (CommonTree)adaptor.becomeRoot(IN170_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_in_eval1657);
            expr171=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr171.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:371:21: ( expr )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==BIGDECIMALNUMBER||LA48_0==BIGINTEGERNUMBER||LA48_0==CUBE||LA48_0==DIV||LA48_0==DOLLARVAR||LA48_0==DOUBLENUMBER||LA48_0==FALSE||LA48_0==FLOATNUMBER||LA48_0==GROUP||LA48_0==IDENTIFIER||LA48_0==INTEGER||LA48_0==LONGINTEGER||LA48_0==MINUS||LA48_0==NULL||LA48_0==PERCENT||LA48_0==PLUS||LA48_0==QUOTEDSTRING||LA48_0==STAR||LA48_0==TRUE||(LA48_0 >= BAG_VAL && LA48_0 <= BIN_EXPR)||(LA48_0 >= CASE_COND && LA48_0 <= CAST_EXPR)||LA48_0==EXPR_IN_PAREN||LA48_0==FUNC_EVAL||LA48_0==INVOKER_FUNC_EVAL||(LA48_0 >= MAP_VAL && LA48_0 <= NEG)||LA48_0==TUPLE_VAL) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:371:21: expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1659);
            	    expr172=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, expr172.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:374:1: func_eval : ( ^( FUNC_EVAL func_name ( real_arg )* ) | ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* ) );
    public final AstValidator.func_eval_return func_eval() throws RecognitionException {
        AstValidator.func_eval_return retval = new AstValidator.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL173=null;
        CommonTree INVOKER_FUNC_EVAL176=null;
        CommonTree IDENTIFIER178=null;
        AstValidator.func_name_return func_name174 =null;

        AstValidator.real_arg_return real_arg175 =null;

        AstValidator.func_name_return func_name177 =null;

        AstValidator.real_arg_return real_arg179 =null;


        CommonTree FUNC_EVAL173_tree=null;
        CommonTree INVOKER_FUNC_EVAL176_tree=null;
        CommonTree IDENTIFIER178_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:374:10: ( ^( FUNC_EVAL func_name ( real_arg )* ) | ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==FUNC_EVAL) ) {
                alt51=1;
            }
            else if ( (LA51_0==INVOKER_FUNC_EVAL) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }
            switch (alt51) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:374:12: ^( FUNC_EVAL func_name ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL173=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1672); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL173_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL173);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL173_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1674);
                    func_name174=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name174.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:374:35: ( real_arg )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==BIGDECIMALNUMBER||LA49_0==BIGINTEGERNUMBER||LA49_0==CUBE||LA49_0==DIV||LA49_0==DOLLARVAR||LA49_0==DOUBLENUMBER||LA49_0==FALSE||LA49_0==FLOATNUMBER||LA49_0==GROUP||LA49_0==IDENTIFIER||LA49_0==INTEGER||LA49_0==LONGINTEGER||LA49_0==MINUS||LA49_0==NULL||LA49_0==PERCENT||LA49_0==PLUS||LA49_0==QUOTEDSTRING||LA49_0==STAR||LA49_0==TRUE||(LA49_0 >= BAG_VAL && LA49_0 <= BIN_EXPR)||(LA49_0 >= CASE_COND && LA49_0 <= EXPR_IN_PAREN)||LA49_0==FUNC_EVAL||LA49_0==INVOKER_FUNC_EVAL||(LA49_0 >= MAP_VAL && LA49_0 <= NEG)||LA49_0==TUPLE_VAL) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:374:35: real_arg
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval1676);
                    	    real_arg175=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg175.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:374:49: ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    INVOKER_FUNC_EVAL176=(CommonTree)match(input,INVOKER_FUNC_EVAL,FOLLOW_INVOKER_FUNC_EVAL_in_func_eval1685); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INVOKER_FUNC_EVAL176_tree = (CommonTree)adaptor.dupNode(INVOKER_FUNC_EVAL176);


                    root_1 = (CommonTree)adaptor.becomeRoot(INVOKER_FUNC_EVAL176_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1687);
                    func_name177=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name177.getTree());


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER178=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval1689); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER178_tree = (CommonTree)adaptor.dupNode(IDENTIFIER178);


                    adaptor.addChild(root_1, IDENTIFIER178_tree);
                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:374:91: ( real_arg )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==BIGDECIMALNUMBER||LA50_0==BIGINTEGERNUMBER||LA50_0==CUBE||LA50_0==DIV||LA50_0==DOLLARVAR||LA50_0==DOUBLENUMBER||LA50_0==FALSE||LA50_0==FLOATNUMBER||LA50_0==GROUP||LA50_0==IDENTIFIER||LA50_0==INTEGER||LA50_0==LONGINTEGER||LA50_0==MINUS||LA50_0==NULL||LA50_0==PERCENT||LA50_0==PLUS||LA50_0==QUOTEDSTRING||LA50_0==STAR||LA50_0==TRUE||(LA50_0 >= BAG_VAL && LA50_0 <= BIN_EXPR)||(LA50_0 >= CASE_COND && LA50_0 <= EXPR_IN_PAREN)||LA50_0==FUNC_EVAL||LA50_0==INVOKER_FUNC_EVAL||(LA50_0 >= MAP_VAL && LA50_0 <= NEG)||LA50_0==TUPLE_VAL) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:374:91: real_arg
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval1691);
                    	    real_arg179=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg179.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:377:1: real_arg : ( expr | STAR | col_range );
    public final AstValidator.real_arg_return real_arg() throws RecognitionException {
        AstValidator.real_arg_return retval = new AstValidator.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR181=null;
        AstValidator.expr_return expr180 =null;

        AstValidator.col_range_return col_range182 =null;


        CommonTree STAR181_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:377:10: ( expr | STAR | col_range )
            int alt52=3;
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
                alt52=1;
                }
                break;
            case STAR:
                {
                int LA52_2 = input.LA(2);

                if ( (LA52_2==DOWN) ) {
                    alt52=1;
                }
                else if ( (LA52_2==EOF||LA52_2==UP||LA52_2==BIGDECIMALNUMBER||LA52_2==BIGINTEGERNUMBER||LA52_2==CUBE||LA52_2==DIV||LA52_2==DOLLARVAR||LA52_2==DOUBLENUMBER||LA52_2==FALSE||LA52_2==FLOATNUMBER||LA52_2==GROUP||LA52_2==IDENTIFIER||LA52_2==INTEGER||LA52_2==LONGINTEGER||LA52_2==MINUS||LA52_2==NULL||LA52_2==PERCENT||LA52_2==PLUS||LA52_2==QUOTEDSTRING||LA52_2==STAR||LA52_2==TRUE||(LA52_2 >= BAG_VAL && LA52_2 <= BIN_EXPR)||(LA52_2 >= CASE_COND && LA52_2 <= EXPR_IN_PAREN)||LA52_2==FUNC_EVAL||LA52_2==INVOKER_FUNC_EVAL||(LA52_2 >= MAP_VAL && LA52_2 <= NEG)||LA52_2==TUPLE_VAL) ) {
                    alt52=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt52=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }

            switch (alt52) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:377:12: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1703);
                    expr180=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr180.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:377:19: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR181=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1707); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR181_tree = (CommonTree)adaptor.dupNode(STAR181);


                    adaptor.addChild(root_0, STAR181_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:377:26: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg1711);
                    col_range182=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range182.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:380:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AstValidator.expr_return expr() throws RecognitionException {
        AstValidator.expr_return retval = new AstValidator.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS183=null;
        CommonTree MINUS186=null;
        CommonTree STAR189=null;
        CommonTree DIV192=null;
        CommonTree PERCENT195=null;
        CommonTree CAST_EXPR198=null;
        CommonTree NEG203=null;
        CommonTree CAST_EXPR205=null;
        CommonTree EXPR_IN_PAREN208=null;
        AstValidator.expr_return expr184 =null;

        AstValidator.expr_return expr185 =null;

        AstValidator.expr_return expr187 =null;

        AstValidator.expr_return expr188 =null;

        AstValidator.expr_return expr190 =null;

        AstValidator.expr_return expr191 =null;

        AstValidator.expr_return expr193 =null;

        AstValidator.expr_return expr194 =null;

        AstValidator.expr_return expr196 =null;

        AstValidator.expr_return expr197 =null;

        AstValidator.type_return type199 =null;

        AstValidator.expr_return expr200 =null;

        AstValidator.const_expr_return const_expr201 =null;

        AstValidator.var_expr_return var_expr202 =null;

        AstValidator.expr_return expr204 =null;

        AstValidator.type_cast_return type_cast206 =null;

        AstValidator.expr_return expr207 =null;

        AstValidator.expr_return expr209 =null;


        CommonTree PLUS183_tree=null;
        CommonTree MINUS186_tree=null;
        CommonTree STAR189_tree=null;
        CommonTree DIV192_tree=null;
        CommonTree PERCENT195_tree=null;
        CommonTree CAST_EXPR198_tree=null;
        CommonTree NEG203_tree=null;
        CommonTree CAST_EXPR205_tree=null;
        CommonTree EXPR_IN_PAREN208_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:380:6: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt53=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt53=1;
                }
                break;
            case MINUS:
                {
                int LA53_2 = input.LA(2);

                if ( (synpred104_AstValidator()) ) {
                    alt53=2;
                }
                else if ( (synpred109_AstValidator()) ) {
                    alt53=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt53=3;
                }
                break;
            case DIV:
                {
                alt53=4;
                }
                break;
            case PERCENT:
                {
                alt53=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA53_6 = input.LA(2);

                if ( (synpred108_AstValidator()) ) {
                    alt53=6;
                }
                else if ( (synpred112_AstValidator()) ) {
                    alt53=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 6, input);

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
                alt53=7;
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
                alt53=8;
                }
                break;
            case NEG:
                {
                alt53=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt53=11;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:380:8: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS183=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1722); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS183_tree = (CommonTree)adaptor.dupNode(PLUS183);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS183_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1724);
                    expr184=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr184.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1726);
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
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:381:8: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS186=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS186_tree = (CommonTree)adaptor.dupNode(MINUS186);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS186_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1741);
                    expr187=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr187.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1743);
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
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:382:8: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR189=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1756); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR189_tree = (CommonTree)adaptor.dupNode(STAR189);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR189_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1758);
                    expr190=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr190.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1760);
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
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:383:8: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV192=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1773); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV192_tree = (CommonTree)adaptor.dupNode(DIV192);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV192_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1775);
                    expr193=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr193.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1777);
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
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:384:8: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT195=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr1790); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT195_tree = (CommonTree)adaptor.dupNode(PERCENT195);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT195_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1792);
                    expr196=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr196.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1794);
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
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:385:8: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR198=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1807); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR198_tree = (CommonTree)adaptor.dupNode(CAST_EXPR198);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR198_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr1809);
                    type199=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type199.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1811);
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
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:386:8: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr1822);
                    const_expr201=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr201.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:387:8: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr1831);
                    var_expr202=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr202.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:388:8: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG203=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr1842); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG203_tree = (CommonTree)adaptor.dupNode(NEG203);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG203_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1844);
                    expr204=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr204.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:389:8: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR205=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1857); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR205_tree = (CommonTree)adaptor.dupNode(CAST_EXPR205);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR205_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr1859);
                    type_cast206=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast206.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1861);
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
                case 11 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:390:8: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN208=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr1874); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN208_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN208);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN208_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1876);
                    expr209=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr209.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:393:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AstValidator.type_cast_return type_cast() throws RecognitionException {
        AstValidator.type_cast_return retval = new AstValidator.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.simple_type_return simple_type210 =null;

        AstValidator.map_type_return map_type211 =null;

        AstValidator.tuple_type_cast_return tuple_type_cast212 =null;

        AstValidator.bag_type_cast_return bag_type_cast213 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:393:11: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt54=4;
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
                alt54=1;
                }
                break;
            case MAP_TYPE:
                {
                alt54=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt54=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt54=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }

            switch (alt54) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:393:13: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast1887);
                    simple_type210=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type210.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:393:27: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast1891);
                    map_type211=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type211.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:393:38: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast1895);
                    tuple_type_cast212=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast212.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:393:56: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast1899);
                    bag_type_cast213=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast213.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:396:1: tuple_type_cast : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final AstValidator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AstValidator.tuple_type_cast_return retval = new AstValidator.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST214=null;
        AstValidator.type_cast_return type_cast215 =null;


        CommonTree TUPLE_TYPE_CAST214_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:396:17: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:396:19: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST214=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1910); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST214_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST214);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST214_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:396:38: ( type_cast )*
                loop55:
                do {
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==BIGDECIMAL||LA55_0==BIGINTEGER||LA55_0==BOOLEAN||LA55_0==BYTEARRAY||LA55_0==CHARARRAY||LA55_0==DATETIME||LA55_0==DOUBLE||LA55_0==FLOAT||LA55_0==INT||LA55_0==LONG||LA55_0==BAG_TYPE_CAST||LA55_0==MAP_TYPE||LA55_0==TUPLE_TYPE_CAST) ) {
                        alt55=1;
                    }


                    switch (alt55) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:396:38: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast1912);
                	    type_cast215=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast215.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop55;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:399:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AstValidator.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AstValidator.bag_type_cast_return retval = new AstValidator.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST216=null;
        AstValidator.tuple_type_cast_return tuple_type_cast217 =null;


        CommonTree BAG_TYPE_CAST216_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:399:15: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:399:17: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST216=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1926); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST216_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST216);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST216_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:399:34: ( tuple_type_cast )?
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==TUPLE_TYPE_CAST) ) {
                    alt56=1;
                }
                switch (alt56) {
                    case 1 :
                        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:399:34: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast1928);
                        tuple_type_cast217=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast217.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:402:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AstValidator.var_expr_return var_expr() throws RecognitionException {
        AstValidator.var_expr_return retval = new AstValidator.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.projectable_expr_return projectable_expr218 =null;

        AstValidator.dot_proj_return dot_proj219 =null;

        AstValidator.pound_proj_return pound_proj220 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:402:10: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:402:12: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr1940);
            projectable_expr218=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr218.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:402:29: ( dot_proj | pound_proj )*
            loop57:
            do {
                int alt57=3;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==PERIOD) ) {
                    alt57=1;
                }
                else if ( (LA57_0==POUND) ) {
                    alt57=2;
                }


                switch (alt57) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:402:31: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr1944);
            	    dot_proj219=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj219.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:402:42: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr1948);
            	    pound_proj220=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj220.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop57;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:405:1: projectable_expr : ( func_eval | col_ref | bin_expr | case_expr | case_cond );
    public final AstValidator.projectable_expr_return projectable_expr() throws RecognitionException {
        AstValidator.projectable_expr_return retval = new AstValidator.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.func_eval_return func_eval221 =null;

        AstValidator.col_ref_return col_ref222 =null;

        AstValidator.bin_expr_return bin_expr223 =null;

        AstValidator.case_expr_return case_expr224 =null;

        AstValidator.case_cond_return case_cond225 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:405:17: ( func_eval | col_ref | bin_expr | case_expr | case_cond )
            int alt58=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt58=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt58=2;
                }
                break;
            case BIN_EXPR:
                {
                alt58=3;
                }
                break;
            case CASE_EXPR:
                {
                alt58=4;
                }
                break;
            case CASE_COND:
                {
                alt58=5;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:405:19: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr1959);
                    func_eval221=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval221.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:405:31: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr1963);
                    col_ref222=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref222.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:405:41: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr1967);
                    bin_expr223=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr223.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:405:52: case_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr1971);
                    case_expr224=case_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr224.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:405:64: case_cond
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr1975);
                    case_cond225=case_cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond225.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:408:1: dot_proj : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final AstValidator.dot_proj_return dot_proj() throws RecognitionException {
        AstValidator.dot_proj_return retval = new AstValidator.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD226=null;
        AstValidator.col_alias_or_index_return col_alias_or_index227 =null;


        CommonTree PERIOD226_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:408:10: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:408:12: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD226=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj1986); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD226_tree = (CommonTree)adaptor.dupNode(PERIOD226);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD226_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:408:22: ( col_alias_or_index )+
            int cnt59=0;
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==CUBE||LA59_0==DOLLARVAR||LA59_0==GROUP||LA59_0==IDENTIFIER) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:408:22: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj1988);
            	    col_alias_or_index227=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index227.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt59 >= 1 ) break loop59;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(59, input);
                        throw eee;
                }
                cnt59++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:411:1: col_alias_or_index : ( col_alias | col_index );
    public final AstValidator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AstValidator.col_alias_or_index_return retval = new AstValidator.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.col_alias_return col_alias228 =null;

        AstValidator.col_index_return col_index229 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:411:20: ( col_alias | col_index )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==CUBE||LA60_0==GROUP||LA60_0==IDENTIFIER) ) {
                alt60=1;
            }
            else if ( (LA60_0==DOLLARVAR) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }
            switch (alt60) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:411:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index2000);
                    col_alias228=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias228.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:411:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index2004);
                    col_index229=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index229.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:414:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AstValidator.col_alias_return col_alias() throws RecognitionException {
        AstValidator.col_alias_return retval = new AstValidator.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set230=null;

        CommonTree set230_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:414:11: ( GROUP | CUBE | IDENTIFIER )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set230=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set230_tree = (CommonTree)adaptor.dupNode(set230);


                adaptor.addChild(root_0, set230_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:417:1: col_index : DOLLARVAR ;
    public final AstValidator.col_index_return col_index() throws RecognitionException {
        AstValidator.col_index_return retval = new AstValidator.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR231=null;

        CommonTree DOLLARVAR231_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:417:11: ( DOLLARVAR )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:417:13: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR231=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2030); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR231_tree = (CommonTree)adaptor.dupNode(DOLLARVAR231);


            adaptor.addChild(root_0, DOLLARVAR231_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:420:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AstValidator.col_range_return col_range() throws RecognitionException {
        AstValidator.col_range_return retval = new AstValidator.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE232=null;
        CommonTree DOUBLE_PERIOD234=null;
        AstValidator.col_ref_return col_ref233 =null;

        AstValidator.col_ref_return col_ref235 =null;


        CommonTree COL_RANGE232_tree=null;
        CommonTree DOUBLE_PERIOD234_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:420:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:420:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE232=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2041); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE232_tree = (CommonTree)adaptor.dupNode(COL_RANGE232);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE232_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:420:26: ( col_ref )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==CUBE||LA61_0==DOLLARVAR||LA61_0==GROUP||LA61_0==IDENTIFIER) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:420:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2043);
                    col_ref233=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref233.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD234=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2046); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD234_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD234);


            adaptor.addChild(root_1, DOUBLE_PERIOD234_tree);
            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:420:49: ( col_ref )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==CUBE||LA62_0==DOLLARVAR||LA62_0==GROUP||LA62_0==IDENTIFIER) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:420:49: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2048);
                    col_ref235=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref235.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:424:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AstValidator.pound_proj_return pound_proj() throws RecognitionException {
        AstValidator.pound_proj_return retval = new AstValidator.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND236=null;
        CommonTree set237=null;

        CommonTree POUND236_tree=null;
        CommonTree set237_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:424:12: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:424:14: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND236=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2062); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND236_tree = (CommonTree)adaptor.dupNode(POUND236);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND236_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            set237=(CommonTree)input.LT(1);

            if ( input.LA(1)==NULL||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set237_tree = (CommonTree)adaptor.dupNode(set237);


                adaptor.addChild(root_1, set237_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:427:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AstValidator.bin_expr_return bin_expr() throws RecognitionException {
        AstValidator.bin_expr_return retval = new AstValidator.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR238=null;
        AstValidator.cond_return cond239 =null;

        AstValidator.expr_return expr240 =null;

        AstValidator.expr_return expr241 =null;


        CommonTree BIN_EXPR238_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:427:10: ( ^( BIN_EXPR cond expr expr ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:427:12: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR238=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2085); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR238_tree = (CommonTree)adaptor.dupNode(BIN_EXPR238);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR238_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2087);
            cond239=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond239.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2089);
            expr240=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr240.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2091);
            expr241=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr241.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:430:1: case_expr : ^( CASE_EXPR ( expr )+ ) ;
    public final AstValidator.case_expr_return case_expr() throws RecognitionException {
        AstValidator.case_expr_return retval = new AstValidator.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR242=null;
        AstValidator.expr_return expr243 =null;


        CommonTree CASE_EXPR242_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:430:10: ( ^( CASE_EXPR ( expr )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:430:12: ^( CASE_EXPR ( expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR242=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr2103); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR242_tree = (CommonTree)adaptor.dupNode(CASE_EXPR242);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR242_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:430:25: ( expr )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==BIGDECIMALNUMBER||LA63_0==BIGINTEGERNUMBER||LA63_0==CUBE||LA63_0==DIV||LA63_0==DOLLARVAR||LA63_0==DOUBLENUMBER||LA63_0==FALSE||LA63_0==FLOATNUMBER||LA63_0==GROUP||LA63_0==IDENTIFIER||LA63_0==INTEGER||LA63_0==LONGINTEGER||LA63_0==MINUS||LA63_0==NULL||LA63_0==PERCENT||LA63_0==PLUS||LA63_0==QUOTEDSTRING||LA63_0==STAR||LA63_0==TRUE||(LA63_0 >= BAG_VAL && LA63_0 <= BIN_EXPR)||(LA63_0 >= CASE_COND && LA63_0 <= CAST_EXPR)||LA63_0==EXPR_IN_PAREN||LA63_0==FUNC_EVAL||LA63_0==INVOKER_FUNC_EVAL||(LA63_0 >= MAP_VAL && LA63_0 <= NEG)||LA63_0==TUPLE_VAL) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:430:25: expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2105);
            	    expr243=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, expr243.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt63 >= 1 ) break loop63;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
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


    public static class case_cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_cond"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:433:1: case_cond : ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ;
    public final AstValidator.case_cond_return case_cond() throws RecognitionException {
        AstValidator.case_cond_return retval = new AstValidator.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND244=null;
        CommonTree WHEN245=null;
        CommonTree THEN247=null;
        AstValidator.cond_return cond246 =null;

        AstValidator.expr_return expr248 =null;


        CommonTree CASE_COND244_tree=null;
        CommonTree WHEN245_tree=null;
        CommonTree THEN247_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:433:10: ( ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:433:12: ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND244=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond2118); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND244_tree = (CommonTree)adaptor.dupNode(CASE_COND244);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND244_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN245=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond2122); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN245_tree = (CommonTree)adaptor.dupNode(WHEN245);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN245_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:433:33: ( cond )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==AND||LA64_0==IN||(LA64_0 >= NOT && LA64_0 <= NUM_OP_NE)||LA64_0==OR||(LA64_0 >= STR_OP_EQ && LA64_0 <= STR_OP_NE)||LA64_0==BOOL_COND||LA64_0==FUNC_EVAL||LA64_0==INVOKER_FUNC_EVAL) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:433:33: cond
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond2124);
            	    cond246=cond();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond246.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
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
            THEN247=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond2131); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN247_tree = (CommonTree)adaptor.dupNode(THEN247);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN247_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:433:49: ( expr )+
            int cnt65=0;
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==BIGDECIMALNUMBER||LA65_0==BIGINTEGERNUMBER||LA65_0==CUBE||LA65_0==DIV||LA65_0==DOLLARVAR||LA65_0==DOUBLENUMBER||LA65_0==FALSE||LA65_0==FLOATNUMBER||LA65_0==GROUP||LA65_0==IDENTIFIER||LA65_0==INTEGER||LA65_0==LONGINTEGER||LA65_0==MINUS||LA65_0==NULL||LA65_0==PERCENT||LA65_0==PLUS||LA65_0==QUOTEDSTRING||LA65_0==STAR||LA65_0==TRUE||(LA65_0 >= BAG_VAL && LA65_0 <= BIN_EXPR)||(LA65_0 >= CASE_COND && LA65_0 <= CAST_EXPR)||LA65_0==EXPR_IN_PAREN||LA65_0==FUNC_EVAL||LA65_0==INVOKER_FUNC_EVAL||(LA65_0 >= MAP_VAL && LA65_0 <= NEG)||LA65_0==TUPLE_VAL) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:433:49: expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond2133);
            	    expr248=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr248.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:436:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AstValidator.limit_clause_return limit_clause() throws RecognitionException {
        AstValidator.limit_clause_return retval = new AstValidator.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT249=null;
        CommonTree INTEGER251=null;
        CommonTree LONGINTEGER252=null;
        AstValidator.rel_return rel250 =null;

        AstValidator.expr_return expr253 =null;


        CommonTree LIMIT249_tree=null;
        CommonTree INTEGER251_tree=null;
        CommonTree LONGINTEGER252_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:436:14: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:436:16: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT249=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2149); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT249_tree = (CommonTree)adaptor.dupNode(LIMIT249);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT249_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2151);
            rel250=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel250.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:436:29: ( INTEGER | LONGINTEGER | expr )
            int alt66=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA66_1 = input.LA(2);

                if ( (synpred134_AstValidator()) ) {
                    alt66=1;
                }
                else if ( (true) ) {
                    alt66=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 66, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA66_2 = input.LA(2);

                if ( (synpred135_AstValidator()) ) {
                    alt66=2;
                }
                else if ( (true) ) {
                    alt66=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 66, 2, input);

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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:436:31: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER251=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2155); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER251_tree = (CommonTree)adaptor.dupNode(INTEGER251);


                    adaptor.addChild(root_1, INTEGER251_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:436:41: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER252=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER252_tree = (CommonTree)adaptor.dupNode(LONGINTEGER252);


                    adaptor.addChild(root_1, LONGINTEGER252_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:436:55: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2163);
                    expr253=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr253.getTree());


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


    public static class rel_cache_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_cache_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:439:1: rel_cache_clause : ^( CACHE IDENTIFIER ) ;
    public final AstValidator.rel_cache_clause_return rel_cache_clause() throws RecognitionException {
        AstValidator.rel_cache_clause_return retval = new AstValidator.rel_cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE254=null;
        CommonTree IDENTIFIER255=null;

        CommonTree CACHE254_tree=null;
        CommonTree IDENTIFIER255_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:439:18: ( ^( CACHE IDENTIFIER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:439:20: ^( CACHE IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE254=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_rel_cache_clause2178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE254_tree = (CommonTree)adaptor.dupNode(CACHE254);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE254_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER255=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_rel_cache_clause2180); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER255_tree = (CommonTree)adaptor.dupNode(IDENTIFIER255);


            adaptor.addChild(root_1, IDENTIFIER255_tree);
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
    // $ANTLR end "rel_cache_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:442:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AstValidator.sample_clause_return sample_clause() throws RecognitionException {
        AstValidator.sample_clause_return retval = new AstValidator.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE256=null;
        CommonTree DOUBLENUMBER258=null;
        AstValidator.rel_return rel257 =null;

        AstValidator.expr_return expr259 =null;


        CommonTree SAMPLE256_tree=null;
        CommonTree DOUBLENUMBER258_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:442:15: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:442:17: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE256=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2192); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE256_tree = (CommonTree)adaptor.dupNode(SAMPLE256);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE256_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2194);
            rel257=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel257.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:442:31: ( DOUBLENUMBER | expr )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==DOUBLENUMBER) ) {
                int LA67_1 = input.LA(2);

                if ( (synpred136_AstValidator()) ) {
                    alt67=1;
                }
                else if ( (true) ) {
                    alt67=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 67, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA67_0==BIGDECIMALNUMBER||LA67_0==BIGINTEGERNUMBER||LA67_0==CUBE||LA67_0==DIV||LA67_0==DOLLARVAR||LA67_0==FALSE||LA67_0==FLOATNUMBER||LA67_0==GROUP||LA67_0==IDENTIFIER||LA67_0==INTEGER||LA67_0==LONGINTEGER||LA67_0==MINUS||LA67_0==NULL||LA67_0==PERCENT||LA67_0==PLUS||LA67_0==QUOTEDSTRING||LA67_0==STAR||LA67_0==TRUE||(LA67_0 >= BAG_VAL && LA67_0 <= BIN_EXPR)||(LA67_0 >= CASE_COND && LA67_0 <= CAST_EXPR)||LA67_0==EXPR_IN_PAREN||LA67_0==FUNC_EVAL||LA67_0==INVOKER_FUNC_EVAL||(LA67_0 >= MAP_VAL && LA67_0 <= NEG)||LA67_0==TUPLE_VAL) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:442:33: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER258=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2198); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER258_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER258);


                    adaptor.addChild(root_1, DOUBLENUMBER258_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:442:48: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2202);
                    expr259=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr259.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:445:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AstValidator.rank_clause_return rank_clause() throws RecognitionException {
        AstValidator.rank_clause_return retval = new AstValidator.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK260=null;
        AstValidator.rel_return rel261 =null;

        AstValidator.rank_by_statement_return rank_by_statement262 =null;


        CommonTree RANK260_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:445:13: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:445:15: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK260=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause2217); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK260_tree = (CommonTree)adaptor.dupNode(RANK260);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK260_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause2219);
            rel261=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel261.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:445:27: ( rank_by_statement )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==BY) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:445:29: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause2223);
                    rank_by_statement262=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement262.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:448:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AstValidator.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AstValidator.rank_by_statement_return retval = new AstValidator.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY263=null;
        CommonTree DENSE265=null;
        AstValidator.rank_by_clause_return rank_by_clause264 =null;


        CommonTree BY263_tree=null;
        CommonTree DENSE265_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:448:19: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:448:21: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY263=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement2239); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY263_tree = (CommonTree)adaptor.dupNode(BY263);


            root_1 = (CommonTree)adaptor.becomeRoot(BY263_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement2241);
            rank_by_clause264=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause264.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:448:42: ( DENSE )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==DENSE) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:448:44: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE265=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement2245); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE265_tree = (CommonTree)adaptor.dupNode(DENSE265);


                    adaptor.addChild(root_1, DENSE265_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:451:1: rank_by_clause : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final AstValidator.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AstValidator.rank_by_clause_return retval = new AstValidator.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR266=null;
        CommonTree set267=null;
        AstValidator.rank_col_return rank_col268 =null;


        CommonTree STAR266_tree=null;
        CommonTree set267_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:451:16: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==STAR) ) {
                alt72=1;
            }
            else if ( (LA72_0==CUBE||LA72_0==DOLLARVAR||LA72_0==GROUP||LA72_0==IDENTIFIER||LA72_0==COL_RANGE) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }
            switch (alt72) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:451:18: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR266=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause2259); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR266_tree = (CommonTree)adaptor.dupNode(STAR266);


                    adaptor.addChild(root_0, STAR266_tree);
                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:451:23: ( ASC | DESC )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==ASC||LA70_0==DESC) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set267=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set267_tree = (CommonTree)adaptor.dupNode(set267);


                                adaptor.addChild(root_0, set267_tree);
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:452:18: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:452:18: ( rank_col )+
                    int cnt71=0;
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==CUBE||LA71_0==DOLLARVAR||LA71_0==GROUP||LA71_0==IDENTIFIER||LA71_0==COL_RANGE) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:452:18: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause2289);
                    	    rank_col268=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col268.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:455:1: rank_col : ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? );
    public final AstValidator.rank_col_return rank_col() throws RecognitionException {
        AstValidator.rank_col_return retval = new AstValidator.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set270=null;
        CommonTree set272=null;
        AstValidator.col_range_return col_range269 =null;

        AstValidator.col_ref_return col_ref271 =null;


        CommonTree set270_tree=null;
        CommonTree set272_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:455:10: ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==COL_RANGE) ) {
                alt75=1;
            }
            else if ( (LA75_0==CUBE||LA75_0==DOLLARVAR||LA75_0==GROUP||LA75_0==IDENTIFIER) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:455:12: col_range ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col2299);
                    col_range269=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range269.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:455:22: ( ASC | DESC )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==ASC||LA73_0==DESC) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set270=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
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


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:456:12: col_ref ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col2321);
                    col_ref271=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref271.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:456:20: ( ASC | DESC )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==ASC||LA74_0==DESC) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set272=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set272_tree = (CommonTree)adaptor.dupNode(set272);


                                adaptor.addChild(root_0, set272_tree);
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

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:459:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AstValidator.order_clause_return order_clause() throws RecognitionException {
        AstValidator.order_clause_return retval = new AstValidator.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER273=null;
        AstValidator.rel_return rel274 =null;

        AstValidator.order_by_clause_return order_by_clause275 =null;

        AstValidator.func_clause_return func_clause276 =null;


        CommonTree ORDER273_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:459:14: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:459:16: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER273=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause2343); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER273_tree = (CommonTree)adaptor.dupNode(ORDER273);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER273_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause2345);
            rel274=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel274.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause2347);
            order_by_clause275=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause275.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:459:45: ( func_clause )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==FUNC||LA76_0==FUNC_REF) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:459:45: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause2349);
                    func_clause276=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause276.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:462:1: order_by_clause : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final AstValidator.order_by_clause_return order_by_clause() throws RecognitionException {
        AstValidator.order_by_clause_return retval = new AstValidator.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR277=null;
        CommonTree set278=null;
        AstValidator.order_col_return order_col279 =null;


        CommonTree STAR277_tree=null;
        CommonTree set278_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:462:17: ( STAR ( ASC | DESC )? | ( order_col )+ )
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:462:19: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR277=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause2361); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR277_tree = (CommonTree)adaptor.dupNode(STAR277);


                    adaptor.addChild(root_0, STAR277_tree);
                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:462:24: ( ASC | DESC )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==ASC||LA77_0==DESC) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set278=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set278_tree = (CommonTree)adaptor.dupNode(set278);


                                adaptor.addChild(root_0, set278_tree);
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:463:19: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:463:19: ( order_col )+
                    int cnt78=0;
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==CUBE||LA78_0==DOLLARVAR||LA78_0==GROUP||LA78_0==IDENTIFIER||LA78_0==COL_RANGE) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:463:19: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause2392);
                    	    order_col279=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col279.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:466:1: order_col : ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? );
    public final AstValidator.order_col_return order_col() throws RecognitionException {
        AstValidator.order_col_return retval = new AstValidator.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set281=null;
        CommonTree set283=null;
        AstValidator.col_range_return col_range280 =null;

        AstValidator.col_ref_return col_ref282 =null;


        CommonTree set281_tree=null;
        CommonTree set283_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:466:11: ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==COL_RANGE) ) {
                alt82=1;
            }
            else if ( (LA82_0==CUBE||LA82_0==DOLLARVAR||LA82_0==GROUP||LA82_0==IDENTIFIER) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;

            }
            switch (alt82) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:466:13: col_range ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col2402);
                    col_range280=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range280.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:466:23: ( ASC | DESC )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==ASC||LA80_0==DESC) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set281=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set281_tree = (CommonTree)adaptor.dupNode(set281);


                                adaptor.addChild(root_0, set281_tree);
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:467:13: col_ref ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col2425);
                    col_ref282=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref282.getTree());


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:467:21: ( ASC | DESC )?
                    int alt81=2;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==ASC||LA81_0==DESC) ) {
                        alt81=1;
                    }
                    switch (alt81) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set283=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set283_tree = (CommonTree)adaptor.dupNode(set283);


                                adaptor.addChild(root_0, set283_tree);
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

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:470:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AstValidator.distinct_clause_return distinct_clause() throws RecognitionException {
        AstValidator.distinct_clause_return retval = new AstValidator.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT284=null;
        AstValidator.rel_return rel285 =null;

        AstValidator.partition_clause_return partition_clause286 =null;


        CommonTree DISTINCT284_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:470:17: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:470:19: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT284=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause2447); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT284_tree = (CommonTree)adaptor.dupNode(DISTINCT284);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT284_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause2449);
            rel285=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel285.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:470:35: ( partition_clause )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==PARTITION) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:470:35: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause2451);
                    partition_clause286=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause286.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:473:1: partition_clause : ^( PARTITION func_name ) ;
    public final AstValidator.partition_clause_return partition_clause() throws RecognitionException {
        AstValidator.partition_clause_return retval = new AstValidator.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION287=null;
        AstValidator.func_name_return func_name288 =null;


        CommonTree PARTITION287_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:473:18: ( ^( PARTITION func_name ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:473:20: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION287=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause2465); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION287_tree = (CommonTree)adaptor.dupNode(PARTITION287);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION287_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause2467);
            func_name288=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name288.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:476:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AstValidator.cross_clause_return cross_clause() throws RecognitionException {
        AstValidator.cross_clause_return retval = new AstValidator.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS289=null;
        AstValidator.rel_list_return rel_list290 =null;

        AstValidator.partition_clause_return partition_clause291 =null;


        CommonTree CROSS289_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:476:14: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:476:16: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS289=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause2480); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS289_tree = (CommonTree)adaptor.dupNode(CROSS289);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS289_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause2482);
            rel_list290=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list290.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:476:34: ( partition_clause )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==PARTITION) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:476:34: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause2484);
                    partition_clause291=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause291.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:479:1: rel_list : ( rel )+ ;
    public final AstValidator.rel_list_return rel_list() throws RecognitionException {
        AstValidator.rel_list_return retval = new AstValidator.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.rel_return rel292 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:479:10: ( ( rel )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:479:12: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:479:12: ( rel )+
            int cnt85=0;
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==ARROBA||LA85_0==COGROUP||(LA85_0 >= CROSS && LA85_0 <= CUBE)||LA85_0==DEFINE||LA85_0==DISTINCT||LA85_0==FILTER||LA85_0==FOREACH||LA85_0==GROUP||LA85_0==IDENTIFIER||LA85_0==JOIN||(LA85_0 >= LIMIT && LA85_0 <= LOAD)||LA85_0==MAPREDUCE||LA85_0==ORDER||LA85_0==RANK||LA85_0==SAMPLE||LA85_0==SPLIT||(LA85_0 >= STORE && LA85_0 <= STREAM)||LA85_0==UNION) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:479:12: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list2496);
            	    rel292=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel292.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt85 >= 1 ) break loop85;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(85, input);
                        throw eee;
                }
                cnt85++;
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
        int arity;
    }
    protected Stack join_clause_stack = new Stack();


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:482:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AstValidator.join_clause_return join_clause() throws RecognitionException {
        join_clause_stack.push(new join_clause_scope());
        AstValidator.join_clause_return retval = new AstValidator.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN293=null;
        AstValidator.join_sub_clause_return join_sub_clause294 =null;

        AstValidator.join_type_return join_type295 =null;

        AstValidator.partition_clause_return partition_clause296 =null;


        CommonTree JOIN293_tree=null;


            ((join_clause_scope)join_clause_stack.peek()).arity = 0;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:489:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:489:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN293=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause2518); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN293_tree = (CommonTree)adaptor.dupNode(JOIN293);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN293_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause2520);
            join_sub_clause294=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause294.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:489:28: ( join_type )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==QUOTEDSTRING) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:489:28: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause2522);
                    join_type295=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type295.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:489:39: ( partition_clause )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==PARTITION) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:489:39: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause2525);
                    partition_clause296=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause296.getTree());


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
            join_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:492:1: join_type : QUOTEDSTRING ;
    public final AstValidator.join_type_return join_type() throws RecognitionException {
        AstValidator.join_type_return retval = new AstValidator.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING297=null;

        CommonTree QUOTEDSTRING297_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:492:11: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:492:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING297=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2537); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING297_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING297);


            adaptor.addChild(root_0, QUOTEDSTRING297_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:495:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final AstValidator.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AstValidator.join_sub_clause_return retval = new AstValidator.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set299=null;
        CommonTree OUTER300=null;
        AstValidator.join_item_return join_item298 =null;

        AstValidator.join_item_return join_item301 =null;

        AstValidator.join_item_return join_item302 =null;


        CommonTree set299_tree=null;
        CommonTree OUTER300_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:496:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==JOIN_ITEM) ) {
                int LA90_1 = input.LA(2);

                if ( (synpred166_AstValidator()) ) {
                    alt90=1;
                }
                else if ( (true) ) {
                    alt90=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;

            }
            switch (alt90) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:496:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2547);
                    join_item298=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item298.getTree());


                    _last = (CommonTree)input.LT(1);
                    set299=(CommonTree)input.LT(1);

                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set299_tree = (CommonTree)adaptor.dupNode(set299);


                        adaptor.addChild(root_0, set299_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:496:38: ( OUTER )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==OUTER) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:496:38: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER300=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2563); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER300_tree = (CommonTree)adaptor.dupNode(OUTER300);


                            adaptor.addChild(root_0, OUTER300_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2566);
                    join_item301=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item301.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:497:4: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:497:4: ( join_item )+
                    int cnt89=0;
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==JOIN_ITEM) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:497:4: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2571);
                    	    join_item302=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item302.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:500:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AstValidator.join_item_return join_item() throws RecognitionException {
        AstValidator.join_item_return retval = new AstValidator.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM303=null;
        AstValidator.rel_return rel304 =null;

        AstValidator.join_group_by_clause_return join_group_by_clause305 =null;


        CommonTree JOIN_ITEM303_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:501:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:501:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM303=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2584); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM303_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM303);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM303_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2586);
            rel304=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel304.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2588);
            join_group_by_clause305=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause305.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   if( ((join_clause_scope)join_clause_stack.peek()).arity == 0 ) {
                       // For the first input
                       ((join_clause_scope)join_clause_stack.peek()).arity = (join_group_by_clause305!=null?join_group_by_clause305.exprCount:0);
                   } else if( (join_group_by_clause305!=null?join_group_by_clause305.exprCount:0) != ((join_clause_scope)join_clause_stack.peek()).arity ) {
                       throw new ParserValidationException( input, new SourceLocation( (PigParserNode)((CommonTree)retval.start) ),
                           "The arity of the join columns do not match." );
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
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        public int exprCount;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:513:1: join_group_by_clause returns [int exprCount] : ^( BY ( join_group_by_expr )+ ) ;
    public final AstValidator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AstValidator.join_group_by_clause_return retval = new AstValidator.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY306=null;
        AstValidator.join_group_by_expr_return join_group_by_expr307 =null;


        CommonTree BY306_tree=null;


            retval.exprCount = 0;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:517:2: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:517:4: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY306=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2615); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY306_tree = (CommonTree)adaptor.dupNode(BY306);


            root_1 = (CommonTree)adaptor.becomeRoot(BY306_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:517:10: ( join_group_by_expr )+
            int cnt91=0;
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==BIGDECIMALNUMBER||LA91_0==BIGINTEGERNUMBER||LA91_0==CUBE||LA91_0==DIV||LA91_0==DOLLARVAR||LA91_0==DOUBLENUMBER||LA91_0==FALSE||LA91_0==FLOATNUMBER||LA91_0==GROUP||LA91_0==IDENTIFIER||LA91_0==INTEGER||LA91_0==LONGINTEGER||LA91_0==MINUS||LA91_0==NULL||LA91_0==PERCENT||LA91_0==PLUS||LA91_0==QUOTEDSTRING||LA91_0==STAR||LA91_0==TRUE||(LA91_0 >= BAG_VAL && LA91_0 <= BIN_EXPR)||(LA91_0 >= CASE_COND && LA91_0 <= EXPR_IN_PAREN)||LA91_0==FUNC_EVAL||LA91_0==INVOKER_FUNC_EVAL||(LA91_0 >= MAP_VAL && LA91_0 <= NEG)||LA91_0==TUPLE_VAL) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:517:12: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2619);
            	    join_group_by_expr307=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr307.getTree());


            	    if ( state.backtracking==0 ) { retval.exprCount++; }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt91 >= 1 ) break loop91;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(91, input);
                        throw eee;
                }
                cnt91++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:520:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AstValidator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AstValidator.join_group_by_expr_return retval = new AstValidator.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR310=null;
        AstValidator.col_range_return col_range308 =null;

        AstValidator.expr_return expr309 =null;


        CommonTree STAR310_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:520:20: ( col_range | expr | STAR )
            int alt92=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt92=1;
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
                alt92=2;
                }
                break;
            case STAR:
                {
                int LA92_3 = input.LA(2);

                if ( (LA92_3==DOWN) ) {
                    alt92=2;
                }
                else if ( (LA92_3==EOF||LA92_3==UP||LA92_3==BIGDECIMALNUMBER||LA92_3==BIGINTEGERNUMBER||LA92_3==CUBE||LA92_3==DIV||LA92_3==DOLLARVAR||LA92_3==DOUBLENUMBER||LA92_3==FALSE||LA92_3==FLOATNUMBER||LA92_3==GROUP||LA92_3==IDENTIFIER||LA92_3==INTEGER||LA92_3==LONGINTEGER||LA92_3==MINUS||LA92_3==NULL||LA92_3==PERCENT||LA92_3==PLUS||LA92_3==QUOTEDSTRING||LA92_3==STAR||LA92_3==TRUE||(LA92_3 >= BAG_VAL && LA92_3 <= BIN_EXPR)||(LA92_3 >= CASE_COND && LA92_3 <= EXPR_IN_PAREN)||LA92_3==FUNC_EVAL||LA92_3==INVOKER_FUNC_EVAL||(LA92_3 >= MAP_VAL && LA92_3 <= NEG)||LA92_3==TUPLE_VAL) ) {
                    alt92=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 92, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;

            }

            switch (alt92) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:520:22: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2635);
                    col_range308=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range308.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:520:35: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2640);
                    expr309=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr309.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:520:42: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR310=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2644); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR310_tree = (CommonTree)adaptor.dupNode(STAR310);


                    adaptor.addChild(root_0, STAR310_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:523:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AstValidator.union_clause_return union_clause() throws RecognitionException {
        AstValidator.union_clause_return retval = new AstValidator.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION311=null;
        CommonTree ONSCHEMA312=null;
        AstValidator.rel_list_return rel_list313 =null;


        CommonTree UNION311_tree=null;
        CommonTree ONSCHEMA312_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:523:14: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:523:16: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION311=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2655); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION311_tree = (CommonTree)adaptor.dupNode(UNION311);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION311_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:523:25: ( ONSCHEMA )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==ONSCHEMA) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:523:25: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA312=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2657); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA312_tree = (CommonTree)adaptor.dupNode(ONSCHEMA312);


                    adaptor.addChild(root_1, ONSCHEMA312_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2660);
            rel_list313=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list313.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:526:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AstValidator.foreach_clause_return foreach_clause() throws RecognitionException {
        AstValidator.foreach_clause_return retval = new AstValidator.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH314=null;
        AstValidator.rel_return rel315 =null;

        AstValidator.foreach_plan_return foreach_plan316 =null;


        CommonTree FOREACH314_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:526:16: ( ^( FOREACH rel foreach_plan ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:526:18: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH314=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2673); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH314_tree = (CommonTree)adaptor.dupNode(FOREACH314);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH314_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2675);
            rel315=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel315.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2677);
            foreach_plan316=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan316.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:529:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AstValidator.foreach_plan_return foreach_plan() throws RecognitionException {
        AstValidator.foreach_plan_return retval = new AstValidator.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE317=null;
        CommonTree FOREACH_PLAN_COMPLEX319=null;
        AstValidator.generate_clause_return generate_clause318 =null;

        AstValidator.nested_blk_return nested_blk320 =null;


        CommonTree FOREACH_PLAN_SIMPLE317_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX319_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:529:14: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==FOREACH_PLAN_SIMPLE) ) {
                alt94=1;
            }
            else if ( (LA94_0==FOREACH_PLAN_COMPLEX) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:529:16: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE317=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2690); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE317_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE317);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE317_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2692);
                    generate_clause318=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause318.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:530:16: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX319=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2713); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX319_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX319);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX319_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2715);
                    nested_blk320=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk320.getTree());


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


    protected static class nested_blk_scope {
        Set<String> ids;
    }
    protected Stack nested_blk_stack = new Stack();


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:533:1: nested_blk : ( nested_command )* generate_clause ;
    public final AstValidator.nested_blk_return nested_blk() throws RecognitionException {
        nested_blk_stack.push(new nested_blk_scope());
        AstValidator.nested_blk_return retval = new AstValidator.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_command_return nested_command321 =null;

        AstValidator.generate_clause_return generate_clause322 =null;



         ((nested_blk_scope)nested_blk_stack.peek()).ids = new HashSet<String>(); 
        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:536:2: ( ( nested_command )* generate_clause )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:536:4: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:536:4: ( nested_command )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( ((LA95_0 >= NESTED_CMD && LA95_0 <= NESTED_CMD_ASSI)) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:536:4: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2735);
            	    nested_command321=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command321.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop95;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2738);
            generate_clause322=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause322.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            nested_blk_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "nested_blk"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:539:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final AstValidator.generate_clause_return generate_clause() throws RecognitionException {
        AstValidator.generate_clause_return retval = new AstValidator.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE323=null;
        AstValidator.flatten_generated_item_return flatten_generated_item324 =null;


        CommonTree GENERATE323_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:539:17: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:539:19: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE323=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2749); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE323_tree = (CommonTree)adaptor.dupNode(GENERATE323);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE323_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:539:31: ( flatten_generated_item )+
            int cnt96=0;
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==BIGDECIMALNUMBER||LA96_0==BIGINTEGERNUMBER||LA96_0==CUBE||LA96_0==DIV||LA96_0==DOLLARVAR||LA96_0==DOUBLENUMBER||LA96_0==FALSE||LA96_0==FLATTEN||LA96_0==FLOATNUMBER||LA96_0==GROUP||LA96_0==IDENTIFIER||LA96_0==INTEGER||LA96_0==LONGINTEGER||LA96_0==MINUS||LA96_0==NULL||LA96_0==PERCENT||LA96_0==PLUS||LA96_0==QUOTEDSTRING||LA96_0==STAR||LA96_0==TRUE||(LA96_0 >= BAG_VAL && LA96_0 <= BIN_EXPR)||(LA96_0 >= CASE_COND && LA96_0 <= EXPR_IN_PAREN)||LA96_0==FUNC_EVAL||LA96_0==INVOKER_FUNC_EVAL||(LA96_0 >= MAP_VAL && LA96_0 <= NEG)||LA96_0==TUPLE_VAL) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:539:31: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause2751);
            	    flatten_generated_item324=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item324.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt96 >= 1 ) break loop96;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(96, input);
                        throw eee;
                }
                cnt96++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:542:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AstValidator.nested_command_return nested_command() throws RecognitionException {
        AstValidator.nested_command_return retval = new AstValidator.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD325=null;
        CommonTree IDENTIFIER326=null;
        CommonTree NESTED_CMD_ASSI328=null;
        CommonTree IDENTIFIER329=null;
        AstValidator.nested_op_return nested_op327 =null;

        AstValidator.expr_return expr330 =null;


        CommonTree NESTED_CMD325_tree=null;
        CommonTree IDENTIFIER326_tree=null;
        CommonTree NESTED_CMD_ASSI328_tree=null;
        CommonTree IDENTIFIER329_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:543:2: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==NESTED_CMD) ) {
                alt97=1;
            }
            else if ( (LA97_0==NESTED_CMD_ASSI) ) {
                alt97=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;

            }
            switch (alt97) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:543:4: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD325=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command2766); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD325_tree = (CommonTree)adaptor.dupNode(NESTED_CMD325);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD325_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER326=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER326_tree = (CommonTree)adaptor.dupNode(IDENTIFIER326);


                    adaptor.addChild(root_1, IDENTIFIER326_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command2770);
                    nested_op327=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op327.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((nested_blk_scope)nested_blk_stack.peek()).ids.add( (IDENTIFIER326!=null?IDENTIFIER326.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:547:4: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI328=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command2784); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI328_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI328);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI328_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER329=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2786); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER329_tree = (CommonTree)adaptor.dupNode(IDENTIFIER329);


                    adaptor.addChild(root_1, IDENTIFIER329_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command2788);
                    expr330=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr330.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((nested_blk_scope)nested_blk_stack.peek()).ids.add( (IDENTIFIER329!=null?IDENTIFIER329.getText():null) );
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:553:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AstValidator.nested_op_return nested_op() throws RecognitionException {
        AstValidator.nested_op_return retval = new AstValidator.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_proj_return nested_proj331 =null;

        AstValidator.nested_filter_return nested_filter332 =null;

        AstValidator.nested_sort_return nested_sort333 =null;

        AstValidator.nested_distinct_return nested_distinct334 =null;

        AstValidator.nested_limit_return nested_limit335 =null;

        AstValidator.nested_cross_return nested_cross336 =null;

        AstValidator.nested_foreach_return nested_foreach337 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:553:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt98=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt98=1;
                }
                break;
            case FILTER:
                {
                alt98=2;
                }
                break;
            case ORDER:
                {
                alt98=3;
                }
                break;
            case DISTINCT:
                {
                alt98=4;
                }
                break;
            case LIMIT:
                {
                alt98=5;
                }
                break;
            case CROSS:
                {
                alt98=6;
                }
                break;
            case FOREACH:
                {
                alt98=7;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:553:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op2804);
                    nested_proj331=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj331.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:554:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op2818);
                    nested_filter332=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter332.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:555:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op2832);
                    nested_sort333=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort333.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:556:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op2846);
                    nested_distinct334=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct334.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:557:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op2860);
                    nested_limit335=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit335.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:558:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op2874);
                    nested_cross336=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross336.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:559:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op2888);
                    nested_foreach337=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach337.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:562:1: nested_proj : ^( NESTED_PROJ col_ref ( col_ref )+ ) ;
    public final AstValidator.nested_proj_return nested_proj() throws RecognitionException {
        AstValidator.nested_proj_return retval = new AstValidator.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ338=null;
        AstValidator.col_ref_return col_ref339 =null;

        AstValidator.col_ref_return col_ref340 =null;


        CommonTree NESTED_PROJ338_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:562:13: ( ^( NESTED_PROJ col_ref ( col_ref )+ ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:562:15: ^( NESTED_PROJ col_ref ( col_ref )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ338=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj2899); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ338_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ338);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ338_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj2901);
            col_ref339=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref339.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:562:38: ( col_ref )+
            int cnt99=0;
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==CUBE||LA99_0==DOLLARVAR||LA99_0==GROUP||LA99_0==IDENTIFIER) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:562:38: col_ref
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj2903);
            	    col_ref340=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref340.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt99 >= 1 ) break loop99;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(99, input);
                        throw eee;
                }
                cnt99++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:565:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AstValidator.nested_filter_return nested_filter() throws RecognitionException {
        AstValidator.nested_filter_return retval = new AstValidator.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER341=null;
        AstValidator.nested_op_input_return nested_op_input342 =null;

        AstValidator.cond_return cond343 =null;


        CommonTree FILTER341_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:566:2: ( ^( FILTER nested_op_input cond ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:566:4: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER341=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter2918); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER341_tree = (CommonTree)adaptor.dupNode(FILTER341);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER341_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter2920);
            nested_op_input342=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input342.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter2922);
            cond343=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond343.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:569:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AstValidator.nested_sort_return nested_sort() throws RecognitionException {
        AstValidator.nested_sort_return retval = new AstValidator.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER344=null;
        AstValidator.nested_op_input_return nested_op_input345 =null;

        AstValidator.order_by_clause_return order_by_clause346 =null;

        AstValidator.func_clause_return func_clause347 =null;


        CommonTree ORDER344_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:569:13: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:569:15: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER344=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort2935); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER344_tree = (CommonTree)adaptor.dupNode(ORDER344);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER344_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort2937);
            nested_op_input345=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input345.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort2940);
            order_by_clause346=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause346.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:569:57: ( func_clause )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==FUNC||LA100_0==FUNC_REF) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:569:57: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort2942);
                    func_clause347=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause347.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:572:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AstValidator.nested_distinct_return nested_distinct() throws RecognitionException {
        AstValidator.nested_distinct_return retval = new AstValidator.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT348=null;
        AstValidator.nested_op_input_return nested_op_input349 =null;


        CommonTree DISTINCT348_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:572:17: ( ^( DISTINCT nested_op_input ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:572:19: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT348=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct2956); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT348_tree = (CommonTree)adaptor.dupNode(DISTINCT348);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT348_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct2958);
            nested_op_input349=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input349.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:575:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AstValidator.nested_limit_return nested_limit() throws RecognitionException {
        AstValidator.nested_limit_return retval = new AstValidator.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT350=null;
        CommonTree INTEGER352=null;
        AstValidator.nested_op_input_return nested_op_input351 =null;

        AstValidator.expr_return expr353 =null;


        CommonTree LIMIT350_tree=null;
        CommonTree INTEGER352_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:575:14: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:575:16: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT350=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit2971); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT350_tree = (CommonTree)adaptor.dupNode(LIMIT350);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT350_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit2973);
            nested_op_input351=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input351.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:575:41: ( INTEGER | expr )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==INTEGER) ) {
                int LA101_1 = input.LA(2);

                if ( (synpred184_AstValidator()) ) {
                    alt101=1;
                }
                else if ( (true) ) {
                    alt101=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA101_0==BIGDECIMALNUMBER||LA101_0==BIGINTEGERNUMBER||LA101_0==CUBE||LA101_0==DIV||LA101_0==DOLLARVAR||LA101_0==DOUBLENUMBER||LA101_0==FALSE||LA101_0==FLOATNUMBER||LA101_0==GROUP||LA101_0==IDENTIFIER||LA101_0==LONGINTEGER||LA101_0==MINUS||LA101_0==NULL||LA101_0==PERCENT||LA101_0==PLUS||LA101_0==QUOTEDSTRING||LA101_0==STAR||LA101_0==TRUE||(LA101_0 >= BAG_VAL && LA101_0 <= BIN_EXPR)||(LA101_0 >= CASE_COND && LA101_0 <= CAST_EXPR)||LA101_0==EXPR_IN_PAREN||LA101_0==FUNC_EVAL||LA101_0==INVOKER_FUNC_EVAL||(LA101_0 >= MAP_VAL && LA101_0 <= NEG)||LA101_0==TUPLE_VAL) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }
            switch (alt101) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:575:43: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER352=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit2977); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER352_tree = (CommonTree)adaptor.dupNode(INTEGER352);


                    adaptor.addChild(root_1, INTEGER352_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:575:53: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit2981);
                    expr353=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr353.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:578:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AstValidator.nested_cross_return nested_cross() throws RecognitionException {
        AstValidator.nested_cross_return retval = new AstValidator.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS354=null;
        AstValidator.nested_op_input_list_return nested_op_input_list355 =null;


        CommonTree CROSS354_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:578:14: ( ^( CROSS nested_op_input_list ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:578:16: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS354=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross2996); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS354_tree = (CommonTree)adaptor.dupNode(CROSS354);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS354_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross2998);
            nested_op_input_list355=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list355.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:581:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AstValidator.nested_foreach_return nested_foreach() throws RecognitionException {
        AstValidator.nested_foreach_return retval = new AstValidator.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH356=null;
        AstValidator.nested_op_input_return nested_op_input357 =null;

        AstValidator.generate_clause_return generate_clause358 =null;


        CommonTree FOREACH356_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:581:16: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:581:18: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH356=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach3011); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH356_tree = (CommonTree)adaptor.dupNode(FOREACH356);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH356_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach3013);
            nested_op_input357=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input357.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach3015);
            generate_clause358=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause358.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:584:1: nested_op_input : ( col_ref | nested_proj );
    public final AstValidator.nested_op_input_return nested_op_input() throws RecognitionException {
        AstValidator.nested_op_input_return retval = new AstValidator.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.col_ref_return col_ref359 =null;

        AstValidator.nested_proj_return nested_proj360 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:584:17: ( col_ref | nested_proj )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==CUBE||LA102_0==DOLLARVAR||LA102_0==GROUP||LA102_0==IDENTIFIER) ) {
                alt102=1;
            }
            else if ( (LA102_0==NESTED_PROJ) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:584:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input3026);
                    col_ref359=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref359.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:584:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input3030);
                    nested_proj360=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj360.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:587:1: nested_op_input_list : ( nested_op_input )+ ;
    public final AstValidator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AstValidator.nested_op_input_list_return retval = new AstValidator.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_op_input_return nested_op_input361 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:587:22: ( ( nested_op_input )+ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:587:24: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:587:24: ( nested_op_input )+
            int cnt103=0;
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==CUBE||LA103_0==DOLLARVAR||LA103_0==GROUP||LA103_0==IDENTIFIER||LA103_0==NESTED_PROJ) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:587:24: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list3039);
            	    nested_op_input361=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input361.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt103 >= 1 ) break loop103;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(103, input);
                        throw eee;
                }
                cnt103++;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:590:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AstValidator.stream_clause_return stream_clause() throws RecognitionException {
        AstValidator.stream_clause_return retval = new AstValidator.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM362=null;
        CommonTree set364=null;
        AstValidator.rel_return rel363 =null;

        AstValidator.as_clause_return as_clause365 =null;


        CommonTree STREAM362_tree=null;
        CommonTree set364_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:590:15: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:590:17: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM362=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause3051); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM362_tree = (CommonTree)adaptor.dupNode(STREAM362);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM362_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause3053);
            rel363=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel363.getTree());


            _last = (CommonTree)input.LT(1);
            set364=(CommonTree)input.LT(1);

            if ( input.LA(1)==EXECCOMMAND||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set364_tree = (CommonTree)adaptor.dupNode(set364);


                adaptor.addChild(root_1, set364_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:590:60: ( as_clause )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==AS) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:590:60: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause3065);
                    as_clause365=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause365.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:593:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AstValidator.mr_clause_return mr_clause() throws RecognitionException {
        AstValidator.mr_clause_return retval = new AstValidator.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE366=null;
        CommonTree QUOTEDSTRING367=null;
        CommonTree EXECCOMMAND371=null;
        AstValidator.path_list_return path_list368 =null;

        AstValidator.store_clause_return store_clause369 =null;

        AstValidator.load_clause_return load_clause370 =null;


        CommonTree MAPREDUCE366_tree=null;
        CommonTree QUOTEDSTRING367_tree=null;
        CommonTree EXECCOMMAND371_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:593:11: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:593:13: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE366=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause3079); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE366_tree = (CommonTree)adaptor.dupNode(MAPREDUCE366);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE366_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING367=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause3081); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING367_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING367);


            adaptor.addChild(root_1, QUOTEDSTRING367_tree);
            }


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:593:39: ( path_list )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==QUOTEDSTRING) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:593:39: path_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause3083);
                    path_list368=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list368.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause3086);
            store_clause369=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause369.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause3088);
            load_clause370=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause370.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:593:75: ( EXECCOMMAND )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==EXECCOMMAND) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:593:75: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND371=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause3090); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND371_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND371);


                    adaptor.addChild(root_1, EXECCOMMAND371_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:596:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final AstValidator.split_clause_return split_clause() throws RecognitionException {
        AstValidator.split_clause_return retval = new AstValidator.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT372=null;
        AstValidator.rel_return rel373 =null;

        AstValidator.split_branch_return split_branch374 =null;

        AstValidator.split_otherwise_return split_otherwise375 =null;


        CommonTree SPLIT372_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:596:14: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:596:16: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT372=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause3104); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT372_tree = (CommonTree)adaptor.dupNode(SPLIT372);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT372_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause3106);
            rel373=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel373.getTree());


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:596:29: ( split_branch )+
            int cnt107=0;
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==SPLIT_BRANCH) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:596:29: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause3108);
            	    split_branch374=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch374.getTree());


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


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:596:43: ( split_otherwise )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==OTHERWISE) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:596:43: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause3111);
                    split_otherwise375=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise375.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:599:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AstValidator.split_branch_return split_branch() throws RecognitionException {
        AstValidator.split_branch_return retval = new AstValidator.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH376=null;
        AstValidator.alias_return alias377 =null;

        AstValidator.cond_return cond378 =null;


        CommonTree SPLIT_BRANCH376_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:600:2: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:600:4: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH376=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch3126); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH376_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH376);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH376_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch3128);
            alias377=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias377.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch3130);
            cond378=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond378.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias377!=null?alias377.name:null) );
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:606:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AstValidator.split_otherwise_return split_otherwise() throws RecognitionException {
        AstValidator.split_otherwise_return retval = new AstValidator.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE379=null;
        AstValidator.alias_return alias380 =null;


        CommonTree OTHERWISE379_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:606:17: ( ^( OTHERWISE alias ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:606:19: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE379=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise3148); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE379_tree = (CommonTree)adaptor.dupNode(OTHERWISE379);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE379_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise3150);
            alias380=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias380.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias380!=null?alias380.name:null) );
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:612:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AstValidator.col_ref_return col_ref() throws RecognitionException {
        AstValidator.col_ref_return retval = new AstValidator.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.alias_col_ref_return alias_col_ref381 =null;

        AstValidator.dollar_col_ref_return dollar_col_ref382 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:612:9: ( alias_col_ref | dollar_col_ref )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==CUBE||LA109_0==GROUP||LA109_0==IDENTIFIER) ) {
                alt109=1;
            }
            else if ( (LA109_0==DOLLARVAR) ) {
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:612:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref3166);
                    alias_col_ref381=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref381.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:612:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref3170);
                    dollar_col_ref382=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref382.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:615:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AstValidator.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AstValidator.alias_col_ref_return retval = new AstValidator.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set383=null;

        CommonTree set383_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:615:15: ( GROUP | CUBE | IDENTIFIER )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set383=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set383_tree = (CommonTree)adaptor.dupNode(set383);


                adaptor.addChild(root_0, set383_tree);
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
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:618:1: dollar_col_ref : DOLLARVAR ;
    public final AstValidator.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AstValidator.dollar_col_ref_return retval = new AstValidator.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR384=null;

        CommonTree DOLLARVAR384_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:618:16: ( DOLLARVAR )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:618:18: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR384=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref3196); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR384_tree = (CommonTree)adaptor.dupNode(DOLLARVAR384);


            adaptor.addChild(root_0, DOLLARVAR384_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:621:1: const_expr : literal ;
    public final AstValidator.const_expr_return const_expr() throws RecognitionException {
        AstValidator.const_expr_return retval = new AstValidator.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.literal_return literal385 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:621:12: ( literal )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:621:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr3205);
            literal385=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal385.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:624:1: literal : ( scalar | map | bag | tuple );
    public final AstValidator.literal_return literal() throws RecognitionException {
        AstValidator.literal_return retval = new AstValidator.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.scalar_return scalar386 =null;

        AstValidator.map_return map387 =null;

        AstValidator.bag_return bag388 =null;

        AstValidator.tuple_return tuple389 =null;



        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:624:9: ( scalar | map | bag | tuple )
            int alt110=4;
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
                alt110=1;
                }
                break;
            case MAP_VAL:
                {
                alt110=2;
                }
                break;
            case BAG_VAL:
                {
                alt110=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt110=4;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:624:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal3214);
                    scalar386=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar386.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:624:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal3218);
                    map387=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map387.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:624:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal3222);
                    bag388=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag388.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:624:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal3226);
                    tuple389=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple389.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:627:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AstValidator.scalar_return scalar() throws RecognitionException {
        AstValidator.scalar_return retval = new AstValidator.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING391=null;
        CommonTree NULL392=null;
        CommonTree TRUE393=null;
        CommonTree FALSE394=null;
        AstValidator.num_scalar_return num_scalar390 =null;


        CommonTree QUOTEDSTRING391_tree=null;
        CommonTree NULL392_tree=null;
        CommonTree TRUE393_tree=null;
        CommonTree FALSE394_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:627:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt111=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt111=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt111=2;
                }
                break;
            case NULL:
                {
                alt111=3;
                }
                break;
            case TRUE:
                {
                alt111=4;
                }
                break;
            case FALSE:
                {
                alt111=5;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:627:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar3235);
                    num_scalar390=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar390.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:627:23: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING391=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar3239); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING391_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING391);


                    adaptor.addChild(root_0, QUOTEDSTRING391_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:627:38: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL392=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar3243); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL392_tree = (CommonTree)adaptor.dupNode(NULL392);


                    adaptor.addChild(root_0, NULL392_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:627:45: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE393=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar3247); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE393_tree = (CommonTree)adaptor.dupNode(TRUE393);


                    adaptor.addChild(root_0, TRUE393_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:627:52: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE394=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar3251); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE394_tree = (CommonTree)adaptor.dupNode(FALSE394);


                    adaptor.addChild(root_0, FALSE394_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:630:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final AstValidator.num_scalar_return num_scalar() throws RecognitionException {
        AstValidator.num_scalar_return retval = new AstValidator.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS395=null;
        CommonTree set396=null;

        CommonTree MINUS395_tree=null;
        CommonTree set396_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:630:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:630:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:630:14: ( MINUS )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==MINUS) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:630:14: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS395=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar3260); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS395_tree = (CommonTree)adaptor.dupNode(MINUS395);


                    adaptor.addChild(root_0, MINUS395_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            set396=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMALNUMBER||input.LA(1)==BIGINTEGERNUMBER||input.LA(1)==DOUBLENUMBER||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set396_tree = (CommonTree)adaptor.dupNode(set396);


                adaptor.addChild(root_0, set396_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:633:1: map : ^( MAP_VAL ( keyvalue )* ) ;
    public final AstValidator.map_return map() throws RecognitionException {
        AstValidator.map_return retval = new AstValidator.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL397=null;
        AstValidator.keyvalue_return keyvalue398 =null;


        CommonTree MAP_VAL397_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:633:5: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:633:7: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL397=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map3298); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL397_tree = (CommonTree)adaptor.dupNode(MAP_VAL397);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL397_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:633:18: ( keyvalue )*
                loop113:
                do {
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( (LA113_0==KEY_VAL_PAIR) ) {
                        alt113=1;
                    }


                    switch (alt113) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:633:18: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map3300);
                	    keyvalue398=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue398.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop113;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:636:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AstValidator.keyvalue_return keyvalue() throws RecognitionException {
        AstValidator.keyvalue_return retval = new AstValidator.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR399=null;
        AstValidator.map_key_return map_key400 =null;

        AstValidator.const_expr_return const_expr401 =null;


        CommonTree KEY_VAL_PAIR399_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:636:10: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:636:12: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR399=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue3314); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR399_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR399);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR399_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue3316);
            map_key400=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key400.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue3318);
            const_expr401=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr401.getTree());


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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:639:1: map_key : QUOTEDSTRING ;
    public final AstValidator.map_key_return map_key() throws RecognitionException {
        AstValidator.map_key_return retval = new AstValidator.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING402=null;

        CommonTree QUOTEDSTRING402_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:639:9: ( QUOTEDSTRING )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:639:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING402=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key3329); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING402_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING402);


            adaptor.addChild(root_0, QUOTEDSTRING402_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:642:1: bag : ^( BAG_VAL ( tuple )* ) ;
    public final AstValidator.bag_return bag() throws RecognitionException {
        AstValidator.bag_return retval = new AstValidator.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL403=null;
        AstValidator.tuple_return tuple404 =null;


        CommonTree BAG_VAL403_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:642:5: ( ^( BAG_VAL ( tuple )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:642:7: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL403=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag3340); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL403_tree = (CommonTree)adaptor.dupNode(BAG_VAL403);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL403_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:642:18: ( tuple )*
                loop114:
                do {
                    int alt114=2;
                    int LA114_0 = input.LA(1);

                    if ( (LA114_0==TUPLE_VAL) ) {
                        alt114=1;
                    }


                    switch (alt114) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:642:18: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag3342);
                	    tuple404=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple404.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop114;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:645:1: tuple : ^( TUPLE_VAL ( literal )* ) ;
    public final AstValidator.tuple_return tuple() throws RecognitionException {
        AstValidator.tuple_return retval = new AstValidator.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL405=null;
        AstValidator.literal_return literal406 =null;


        CommonTree TUPLE_VAL405_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:645:7: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:645:9: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL405=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple3356); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL405_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL405);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL405_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:645:22: ( literal )*
                loop115:
                do {
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==BIGDECIMALNUMBER||LA115_0==BIGINTEGERNUMBER||LA115_0==DOUBLENUMBER||LA115_0==FALSE||LA115_0==FLOATNUMBER||LA115_0==INTEGER||LA115_0==LONGINTEGER||LA115_0==MINUS||LA115_0==NULL||LA115_0==QUOTEDSTRING||LA115_0==TRUE||LA115_0==BAG_VAL||LA115_0==MAP_VAL||LA115_0==TUPLE_VAL) ) {
                        alt115=1;
                    }


                    switch (alt115) {
                	case 1 :
                	    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:645:22: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple3358);
                	    literal406=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal406.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop115;
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:649:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE );
    public final AstValidator.eid_return eid() throws RecognitionException {
        AstValidator.eid_return retval = new AstValidator.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT408=null;
        CommonTree RETURNS409=null;
        CommonTree DEFINE410=null;
        CommonTree LOAD411=null;
        CommonTree FILTER412=null;
        CommonTree FOREACH413=null;
        CommonTree CUBE414=null;
        CommonTree ROLLUP415=null;
        CommonTree MATCHES416=null;
        CommonTree ORDER417=null;
        CommonTree RANK418=null;
        CommonTree DISTINCT419=null;
        CommonTree COGROUP420=null;
        CommonTree JOIN421=null;
        CommonTree CROSS422=null;
        CommonTree UNION423=null;
        CommonTree SPLIT424=null;
        CommonTree INTO425=null;
        CommonTree IF426=null;
        CommonTree ALL427=null;
        CommonTree AS428=null;
        CommonTree BY429=null;
        CommonTree USING430=null;
        CommonTree INNER431=null;
        CommonTree OUTER432=null;
        CommonTree PARALLEL433=null;
        CommonTree PARTITION434=null;
        CommonTree GROUP435=null;
        CommonTree AND436=null;
        CommonTree OR437=null;
        CommonTree NOT438=null;
        CommonTree GENERATE439=null;
        CommonTree FLATTEN440=null;
        CommonTree EVAL441=null;
        CommonTree ASC442=null;
        CommonTree DESC443=null;
        CommonTree BOOLEAN444=null;
        CommonTree INT445=null;
        CommonTree LONG446=null;
        CommonTree FLOAT447=null;
        CommonTree DOUBLE448=null;
        CommonTree BIGINTEGER449=null;
        CommonTree BIGDECIMAL450=null;
        CommonTree DATETIME451=null;
        CommonTree CHARARRAY452=null;
        CommonTree BYTEARRAY453=null;
        CommonTree BAG454=null;
        CommonTree TUPLE455=null;
        CommonTree MAP456=null;
        CommonTree IS457=null;
        CommonTree NULL458=null;
        CommonTree TRUE459=null;
        CommonTree FALSE460=null;
        CommonTree STREAM461=null;
        CommonTree THROUGH462=null;
        CommonTree STORE463=null;
        CommonTree MAPREDUCE464=null;
        CommonTree SHIP465=null;
        CommonTree CACHE466=null;
        CommonTree INPUT467=null;
        CommonTree OUTPUT468=null;
        CommonTree STDERROR469=null;
        CommonTree STDIN470=null;
        CommonTree STDOUT471=null;
        CommonTree LIMIT472=null;
        CommonTree SAMPLE473=null;
        CommonTree LEFT474=null;
        CommonTree RIGHT475=null;
        CommonTree FULL476=null;
        CommonTree IDENTIFIER477=null;
        CommonTree TOBAG478=null;
        CommonTree TOMAP479=null;
        CommonTree TOTUPLE480=null;
        AstValidator.rel_str_op_return rel_str_op407 =null;


        CommonTree IMPORT408_tree=null;
        CommonTree RETURNS409_tree=null;
        CommonTree DEFINE410_tree=null;
        CommonTree LOAD411_tree=null;
        CommonTree FILTER412_tree=null;
        CommonTree FOREACH413_tree=null;
        CommonTree CUBE414_tree=null;
        CommonTree ROLLUP415_tree=null;
        CommonTree MATCHES416_tree=null;
        CommonTree ORDER417_tree=null;
        CommonTree RANK418_tree=null;
        CommonTree DISTINCT419_tree=null;
        CommonTree COGROUP420_tree=null;
        CommonTree JOIN421_tree=null;
        CommonTree CROSS422_tree=null;
        CommonTree UNION423_tree=null;
        CommonTree SPLIT424_tree=null;
        CommonTree INTO425_tree=null;
        CommonTree IF426_tree=null;
        CommonTree ALL427_tree=null;
        CommonTree AS428_tree=null;
        CommonTree BY429_tree=null;
        CommonTree USING430_tree=null;
        CommonTree INNER431_tree=null;
        CommonTree OUTER432_tree=null;
        CommonTree PARALLEL433_tree=null;
        CommonTree PARTITION434_tree=null;
        CommonTree GROUP435_tree=null;
        CommonTree AND436_tree=null;
        CommonTree OR437_tree=null;
        CommonTree NOT438_tree=null;
        CommonTree GENERATE439_tree=null;
        CommonTree FLATTEN440_tree=null;
        CommonTree EVAL441_tree=null;
        CommonTree ASC442_tree=null;
        CommonTree DESC443_tree=null;
        CommonTree BOOLEAN444_tree=null;
        CommonTree INT445_tree=null;
        CommonTree LONG446_tree=null;
        CommonTree FLOAT447_tree=null;
        CommonTree DOUBLE448_tree=null;
        CommonTree BIGINTEGER449_tree=null;
        CommonTree BIGDECIMAL450_tree=null;
        CommonTree DATETIME451_tree=null;
        CommonTree CHARARRAY452_tree=null;
        CommonTree BYTEARRAY453_tree=null;
        CommonTree BAG454_tree=null;
        CommonTree TUPLE455_tree=null;
        CommonTree MAP456_tree=null;
        CommonTree IS457_tree=null;
        CommonTree NULL458_tree=null;
        CommonTree TRUE459_tree=null;
        CommonTree FALSE460_tree=null;
        CommonTree STREAM461_tree=null;
        CommonTree THROUGH462_tree=null;
        CommonTree STORE463_tree=null;
        CommonTree MAPREDUCE464_tree=null;
        CommonTree SHIP465_tree=null;
        CommonTree CACHE466_tree=null;
        CommonTree INPUT467_tree=null;
        CommonTree OUTPUT468_tree=null;
        CommonTree STDERROR469_tree=null;
        CommonTree STDIN470_tree=null;
        CommonTree STDOUT471_tree=null;
        CommonTree LIMIT472_tree=null;
        CommonTree SAMPLE473_tree=null;
        CommonTree LEFT474_tree=null;
        CommonTree RIGHT475_tree=null;
        CommonTree FULL476_tree=null;
        CommonTree IDENTIFIER477_tree=null;
        CommonTree TOBAG478_tree=null;
        CommonTree TOMAP479_tree=null;
        CommonTree TOTUPLE480_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:649:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE )
            int alt116=74;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt116=1;
                }
                break;
            case IMPORT:
                {
                alt116=2;
                }
                break;
            case RETURNS:
                {
                alt116=3;
                }
                break;
            case DEFINE:
                {
                alt116=4;
                }
                break;
            case LOAD:
                {
                alt116=5;
                }
                break;
            case FILTER:
                {
                alt116=6;
                }
                break;
            case FOREACH:
                {
                alt116=7;
                }
                break;
            case CUBE:
                {
                alt116=8;
                }
                break;
            case ROLLUP:
                {
                alt116=9;
                }
                break;
            case MATCHES:
                {
                alt116=10;
                }
                break;
            case ORDER:
                {
                alt116=11;
                }
                break;
            case RANK:
                {
                alt116=12;
                }
                break;
            case DISTINCT:
                {
                alt116=13;
                }
                break;
            case COGROUP:
                {
                alt116=14;
                }
                break;
            case JOIN:
                {
                alt116=15;
                }
                break;
            case CROSS:
                {
                alt116=16;
                }
                break;
            case UNION:
                {
                alt116=17;
                }
                break;
            case SPLIT:
                {
                alt116=18;
                }
                break;
            case INTO:
                {
                alt116=19;
                }
                break;
            case IF:
                {
                alt116=20;
                }
                break;
            case ALL:
                {
                alt116=21;
                }
                break;
            case AS:
                {
                alt116=22;
                }
                break;
            case BY:
                {
                alt116=23;
                }
                break;
            case USING:
                {
                alt116=24;
                }
                break;
            case INNER:
                {
                alt116=25;
                }
                break;
            case OUTER:
                {
                alt116=26;
                }
                break;
            case PARALLEL:
                {
                alt116=27;
                }
                break;
            case PARTITION:
                {
                alt116=28;
                }
                break;
            case GROUP:
                {
                alt116=29;
                }
                break;
            case AND:
                {
                alt116=30;
                }
                break;
            case OR:
                {
                alt116=31;
                }
                break;
            case NOT:
                {
                alt116=32;
                }
                break;
            case GENERATE:
                {
                alt116=33;
                }
                break;
            case FLATTEN:
                {
                alt116=34;
                }
                break;
            case EVAL:
                {
                alt116=35;
                }
                break;
            case ASC:
                {
                alt116=36;
                }
                break;
            case DESC:
                {
                alt116=37;
                }
                break;
            case BOOLEAN:
                {
                alt116=38;
                }
                break;
            case INT:
                {
                alt116=39;
                }
                break;
            case LONG:
                {
                alt116=40;
                }
                break;
            case FLOAT:
                {
                alt116=41;
                }
                break;
            case DOUBLE:
                {
                alt116=42;
                }
                break;
            case BIGINTEGER:
                {
                alt116=43;
                }
                break;
            case BIGDECIMAL:
                {
                alt116=44;
                }
                break;
            case DATETIME:
                {
                alt116=45;
                }
                break;
            case CHARARRAY:
                {
                alt116=46;
                }
                break;
            case BYTEARRAY:
                {
                alt116=47;
                }
                break;
            case BAG:
                {
                alt116=48;
                }
                break;
            case TUPLE:
                {
                alt116=49;
                }
                break;
            case MAP:
                {
                alt116=50;
                }
                break;
            case IS:
                {
                alt116=51;
                }
                break;
            case NULL:
                {
                alt116=52;
                }
                break;
            case TRUE:
                {
                alt116=53;
                }
                break;
            case FALSE:
                {
                alt116=54;
                }
                break;
            case STREAM:
                {
                alt116=55;
                }
                break;
            case THROUGH:
                {
                alt116=56;
                }
                break;
            case STORE:
                {
                alt116=57;
                }
                break;
            case MAPREDUCE:
                {
                alt116=58;
                }
                break;
            case SHIP:
                {
                alt116=59;
                }
                break;
            case CACHE:
                {
                alt116=60;
                }
                break;
            case INPUT:
                {
                alt116=61;
                }
                break;
            case OUTPUT:
                {
                alt116=62;
                }
                break;
            case STDERROR:
                {
                alt116=63;
                }
                break;
            case STDIN:
                {
                alt116=64;
                }
                break;
            case STDOUT:
                {
                alt116=65;
                }
                break;
            case LIMIT:
                {
                alt116=66;
                }
                break;
            case SAMPLE:
                {
                alt116=67;
                }
                break;
            case LEFT:
                {
                alt116=68;
                }
                break;
            case RIGHT:
                {
                alt116=69;
                }
                break;
            case FULL:
                {
                alt116=70;
                }
                break;
            case IDENTIFIER:
                {
                alt116=71;
                }
                break;
            case TOBAG:
                {
                alt116=72;
                }
                break;
            case TOMAP:
                {
                alt116=73;
                }
                break;
            case TOTUPLE:
                {
                alt116=74;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;

            }

            switch (alt116) {
                case 1 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:649:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid3371);
                    rel_str_op407=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op407.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:650:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT408=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid3379); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT408_tree = (CommonTree)adaptor.dupNode(IMPORT408);


                    adaptor.addChild(root_0, IMPORT408_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:651:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS409=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid3387); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS409_tree = (CommonTree)adaptor.dupNode(RETURNS409);


                    adaptor.addChild(root_0, RETURNS409_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:652:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE410=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid3395); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE410_tree = (CommonTree)adaptor.dupNode(DEFINE410);


                    adaptor.addChild(root_0, DEFINE410_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:653:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD411=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid3403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD411_tree = (CommonTree)adaptor.dupNode(LOAD411);


                    adaptor.addChild(root_0, LOAD411_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:654:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER412=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid3411); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER412_tree = (CommonTree)adaptor.dupNode(FILTER412);


                    adaptor.addChild(root_0, FILTER412_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:655:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH413=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid3419); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH413_tree = (CommonTree)adaptor.dupNode(FOREACH413);


                    adaptor.addChild(root_0, FOREACH413_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:656:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE414=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid3427); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE414_tree = (CommonTree)adaptor.dupNode(CUBE414);


                    adaptor.addChild(root_0, CUBE414_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:657:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP415=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid3435); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP415_tree = (CommonTree)adaptor.dupNode(ROLLUP415);


                    adaptor.addChild(root_0, ROLLUP415_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:658:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES416=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid3443); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES416_tree = (CommonTree)adaptor.dupNode(MATCHES416);


                    adaptor.addChild(root_0, MATCHES416_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:659:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER417=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid3451); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER417_tree = (CommonTree)adaptor.dupNode(ORDER417);


                    adaptor.addChild(root_0, ORDER417_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:660:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK418=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid3459); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK418_tree = (CommonTree)adaptor.dupNode(RANK418);


                    adaptor.addChild(root_0, RANK418_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:661:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT419=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid3467); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT419_tree = (CommonTree)adaptor.dupNode(DISTINCT419);


                    adaptor.addChild(root_0, DISTINCT419_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:662:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP420=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid3475); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP420_tree = (CommonTree)adaptor.dupNode(COGROUP420);


                    adaptor.addChild(root_0, COGROUP420_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:663:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN421=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid3483); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN421_tree = (CommonTree)adaptor.dupNode(JOIN421);


                    adaptor.addChild(root_0, JOIN421_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:664:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS422=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid3491); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS422_tree = (CommonTree)adaptor.dupNode(CROSS422);


                    adaptor.addChild(root_0, CROSS422_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:665:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION423=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid3499); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION423_tree = (CommonTree)adaptor.dupNode(UNION423);


                    adaptor.addChild(root_0, UNION423_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:666:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT424=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid3507); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT424_tree = (CommonTree)adaptor.dupNode(SPLIT424);


                    adaptor.addChild(root_0, SPLIT424_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:667:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO425=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid3515); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO425_tree = (CommonTree)adaptor.dupNode(INTO425);


                    adaptor.addChild(root_0, INTO425_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:668:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF426=(CommonTree)match(input,IF,FOLLOW_IF_in_eid3523); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF426_tree = (CommonTree)adaptor.dupNode(IF426);


                    adaptor.addChild(root_0, IF426_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:669:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL427=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid3531); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL427_tree = (CommonTree)adaptor.dupNode(ALL427);


                    adaptor.addChild(root_0, ALL427_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:670:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS428=(CommonTree)match(input,AS,FOLLOW_AS_in_eid3539); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS428_tree = (CommonTree)adaptor.dupNode(AS428);


                    adaptor.addChild(root_0, AS428_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:671:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY429=(CommonTree)match(input,BY,FOLLOW_BY_in_eid3547); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY429_tree = (CommonTree)adaptor.dupNode(BY429);


                    adaptor.addChild(root_0, BY429_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:672:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING430=(CommonTree)match(input,USING,FOLLOW_USING_in_eid3555); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING430_tree = (CommonTree)adaptor.dupNode(USING430);


                    adaptor.addChild(root_0, USING430_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:673:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER431=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid3563); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER431_tree = (CommonTree)adaptor.dupNode(INNER431);


                    adaptor.addChild(root_0, INNER431_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:674:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER432=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid3571); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER432_tree = (CommonTree)adaptor.dupNode(OUTER432);


                    adaptor.addChild(root_0, OUTER432_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:675:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL433=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid3579); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL433_tree = (CommonTree)adaptor.dupNode(PARALLEL433);


                    adaptor.addChild(root_0, PARALLEL433_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:676:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION434=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid3587); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION434_tree = (CommonTree)adaptor.dupNode(PARTITION434);


                    adaptor.addChild(root_0, PARTITION434_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:677:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP435=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid3595); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP435_tree = (CommonTree)adaptor.dupNode(GROUP435);


                    adaptor.addChild(root_0, GROUP435_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:678:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND436=(CommonTree)match(input,AND,FOLLOW_AND_in_eid3603); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND436_tree = (CommonTree)adaptor.dupNode(AND436);


                    adaptor.addChild(root_0, AND436_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:679:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR437=(CommonTree)match(input,OR,FOLLOW_OR_in_eid3611); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR437_tree = (CommonTree)adaptor.dupNode(OR437);


                    adaptor.addChild(root_0, OR437_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:680:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT438=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid3619); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT438_tree = (CommonTree)adaptor.dupNode(NOT438);


                    adaptor.addChild(root_0, NOT438_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:681:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE439=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid3627); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE439_tree = (CommonTree)adaptor.dupNode(GENERATE439);


                    adaptor.addChild(root_0, GENERATE439_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:682:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN440=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid3635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN440_tree = (CommonTree)adaptor.dupNode(FLATTEN440);


                    adaptor.addChild(root_0, FLATTEN440_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:683:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL441=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid3643); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL441_tree = (CommonTree)adaptor.dupNode(EVAL441);


                    adaptor.addChild(root_0, EVAL441_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:684:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC442=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid3651); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC442_tree = (CommonTree)adaptor.dupNode(ASC442);


                    adaptor.addChild(root_0, ASC442_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:685:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC443=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid3659); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC443_tree = (CommonTree)adaptor.dupNode(DESC443);


                    adaptor.addChild(root_0, DESC443_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:686:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN444=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid3667); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN444_tree = (CommonTree)adaptor.dupNode(BOOLEAN444);


                    adaptor.addChild(root_0, BOOLEAN444_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:687:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT445=(CommonTree)match(input,INT,FOLLOW_INT_in_eid3675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT445_tree = (CommonTree)adaptor.dupNode(INT445);


                    adaptor.addChild(root_0, INT445_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:688:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG446=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid3683); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG446_tree = (CommonTree)adaptor.dupNode(LONG446);


                    adaptor.addChild(root_0, LONG446_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:689:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT447=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid3691); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT447_tree = (CommonTree)adaptor.dupNode(FLOAT447);


                    adaptor.addChild(root_0, FLOAT447_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:690:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE448=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid3699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE448_tree = (CommonTree)adaptor.dupNode(DOUBLE448);


                    adaptor.addChild(root_0, DOUBLE448_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:691:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER449=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid3707); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER449_tree = (CommonTree)adaptor.dupNode(BIGINTEGER449);


                    adaptor.addChild(root_0, BIGINTEGER449_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:692:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL450=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid3715); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL450_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL450);


                    adaptor.addChild(root_0, BIGDECIMAL450_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:693:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME451=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid3723); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME451_tree = (CommonTree)adaptor.dupNode(DATETIME451);


                    adaptor.addChild(root_0, DATETIME451_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:694:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY452=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid3731); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY452_tree = (CommonTree)adaptor.dupNode(CHARARRAY452);


                    adaptor.addChild(root_0, CHARARRAY452_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:695:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY453=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid3739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY453_tree = (CommonTree)adaptor.dupNode(BYTEARRAY453);


                    adaptor.addChild(root_0, BYTEARRAY453_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:696:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG454=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid3747); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG454_tree = (CommonTree)adaptor.dupNode(BAG454);


                    adaptor.addChild(root_0, BAG454_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:697:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE455=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid3755); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE455_tree = (CommonTree)adaptor.dupNode(TUPLE455);


                    adaptor.addChild(root_0, TUPLE455_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:698:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP456=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid3763); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP456_tree = (CommonTree)adaptor.dupNode(MAP456);


                    adaptor.addChild(root_0, MAP456_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:699:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS457=(CommonTree)match(input,IS,FOLLOW_IS_in_eid3771); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS457_tree = (CommonTree)adaptor.dupNode(IS457);


                    adaptor.addChild(root_0, IS457_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:700:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL458=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid3779); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL458_tree = (CommonTree)adaptor.dupNode(NULL458);


                    adaptor.addChild(root_0, NULL458_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:701:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE459=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid3787); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE459_tree = (CommonTree)adaptor.dupNode(TRUE459);


                    adaptor.addChild(root_0, TRUE459_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:702:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE460=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid3795); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE460_tree = (CommonTree)adaptor.dupNode(FALSE460);


                    adaptor.addChild(root_0, FALSE460_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:703:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM461=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid3803); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM461_tree = (CommonTree)adaptor.dupNode(STREAM461);


                    adaptor.addChild(root_0, STREAM461_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:704:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH462=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid3811); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH462_tree = (CommonTree)adaptor.dupNode(THROUGH462);


                    adaptor.addChild(root_0, THROUGH462_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:705:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE463=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid3819); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE463_tree = (CommonTree)adaptor.dupNode(STORE463);


                    adaptor.addChild(root_0, STORE463_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:706:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE464=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid3827); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE464_tree = (CommonTree)adaptor.dupNode(MAPREDUCE464);


                    adaptor.addChild(root_0, MAPREDUCE464_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:707:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP465=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid3835); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP465_tree = (CommonTree)adaptor.dupNode(SHIP465);


                    adaptor.addChild(root_0, SHIP465_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:708:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE466=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid3843); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE466_tree = (CommonTree)adaptor.dupNode(CACHE466);


                    adaptor.addChild(root_0, CACHE466_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:709:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT467=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid3851); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT467_tree = (CommonTree)adaptor.dupNode(INPUT467);


                    adaptor.addChild(root_0, INPUT467_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:710:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT468=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid3859); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT468_tree = (CommonTree)adaptor.dupNode(OUTPUT468);


                    adaptor.addChild(root_0, OUTPUT468_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:711:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR469=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid3867); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR469_tree = (CommonTree)adaptor.dupNode(STDERROR469);


                    adaptor.addChild(root_0, STDERROR469_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:712:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN470=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid3875); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN470_tree = (CommonTree)adaptor.dupNode(STDIN470);


                    adaptor.addChild(root_0, STDIN470_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:713:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT471=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid3883); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT471_tree = (CommonTree)adaptor.dupNode(STDOUT471);


                    adaptor.addChild(root_0, STDOUT471_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:714:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT472=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid3891); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT472_tree = (CommonTree)adaptor.dupNode(LIMIT472);


                    adaptor.addChild(root_0, LIMIT472_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:715:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE473=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid3899); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE473_tree = (CommonTree)adaptor.dupNode(SAMPLE473);


                    adaptor.addChild(root_0, SAMPLE473_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:716:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT474=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid3907); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT474_tree = (CommonTree)adaptor.dupNode(LEFT474);


                    adaptor.addChild(root_0, LEFT474_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:717:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT475=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid3915); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT475_tree = (CommonTree)adaptor.dupNode(RIGHT475);


                    adaptor.addChild(root_0, RIGHT475_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:718:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL476=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid3923); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL476_tree = (CommonTree)adaptor.dupNode(FULL476);


                    adaptor.addChild(root_0, FULL476_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:719:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER477=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid3931); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER477_tree = (CommonTree)adaptor.dupNode(IDENTIFIER477);


                    adaptor.addChild(root_0, IDENTIFIER477_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:720:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG478=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid3939); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG478_tree = (CommonTree)adaptor.dupNode(TOBAG478);


                    adaptor.addChild(root_0, TOBAG478_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:721:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP479=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid3947); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP479_tree = (CommonTree)adaptor.dupNode(TOMAP479);


                    adaptor.addChild(root_0, TOMAP479_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:722:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE480=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid3955); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE480_tree = (CommonTree)adaptor.dupNode(TOTUPLE480);


                    adaptor.addChild(root_0, TOTUPLE480_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:726:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AstValidator.rel_op_return rel_op() throws RecognitionException {
        AstValidator.rel_op_return retval = new AstValidator.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES487=null;
        AstValidator.rel_op_eq_return rel_op_eq481 =null;

        AstValidator.rel_op_ne_return rel_op_ne482 =null;

        AstValidator.rel_op_gt_return rel_op_gt483 =null;

        AstValidator.rel_op_gte_return rel_op_gte484 =null;

        AstValidator.rel_op_lt_return rel_op_lt485 =null;

        AstValidator.rel_op_lte_return rel_op_lte486 =null;


        CommonTree STR_OP_MATCHES487_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:726:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt117=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt117=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt117=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt117=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt117=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt117=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt117=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt117=7;
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
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:726:10: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op3965);
                    rel_op_eq481=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq481.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:727:10: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op3976);
                    rel_op_ne482=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne482.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:728:10: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op3987);
                    rel_op_gt483=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt483.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:729:10: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op3998);
                    rel_op_gte484=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte484.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:730:10: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op4009);
                    rel_op_lt485=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt485.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:731:10: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op4020);
                    rel_op_lte486=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte486.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:732:10: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES487=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op4031); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES487_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES487);


                    adaptor.addChild(root_0, STR_OP_MATCHES487_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:735:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final AstValidator.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AstValidator.rel_op_eq_return retval = new AstValidator.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set488=null;

        CommonTree set488_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:735:11: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set488=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
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
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:738:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final AstValidator.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AstValidator.rel_op_ne_return retval = new AstValidator.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set489=null;

        CommonTree set489_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:738:11: ( STR_OP_NE | NUM_OP_NE )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set489=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set489_tree = (CommonTree)adaptor.dupNode(set489);


                adaptor.addChild(root_0, set489_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:741:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final AstValidator.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AstValidator.rel_op_gt_return retval = new AstValidator.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set490=null;

        CommonTree set490_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:741:11: ( STR_OP_GT | NUM_OP_GT )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set490=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set490_tree = (CommonTree)adaptor.dupNode(set490);


                adaptor.addChild(root_0, set490_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:744:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final AstValidator.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AstValidator.rel_op_gte_return retval = new AstValidator.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set491=null;

        CommonTree set491_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:744:12: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set491=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set491_tree = (CommonTree)adaptor.dupNode(set491);


                adaptor.addChild(root_0, set491_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:747:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final AstValidator.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AstValidator.rel_op_lt_return retval = new AstValidator.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set492=null;

        CommonTree set492_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:747:11: ( STR_OP_LT | NUM_OP_LT )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set492=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set492_tree = (CommonTree)adaptor.dupNode(set492);


                adaptor.addChild(root_0, set492_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:750:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final AstValidator.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AstValidator.rel_op_lte_return retval = new AstValidator.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set493=null;

        CommonTree set493_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:750:12: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set493=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set493_tree = (CommonTree)adaptor.dupNode(set493);


                adaptor.addChild(root_0, set493_tree);
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
    // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:753:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AstValidator.rel_str_op_return rel_str_op() throws RecognitionException {
        AstValidator.rel_str_op_return retval = new AstValidator.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set494=null;

        CommonTree set494_tree=null;

        try {
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:753:12: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set494=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set494_tree = (CommonTree)adaptor.dupNode(set494);


                adaptor.addChild(root_0, set494_tree);
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

    // $ANTLR start synpred104_AstValidator
    public final void synpred104_AstValidator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:381:8: ( ^( MINUS expr expr ) )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:381:8: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred104_AstValidator1739); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred104_AstValidator1741);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred104_AstValidator1743);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred104_AstValidator

    // $ANTLR start synpred108_AstValidator
    public final void synpred108_AstValidator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:385:8: ( ^( CAST_EXPR type expr ) )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:385:8: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred108_AstValidator1807); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred108_AstValidator1809);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred108_AstValidator1811);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred108_AstValidator

    // $ANTLR start synpred109_AstValidator
    public final void synpred109_AstValidator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:386:8: ( const_expr )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:386:8: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred109_AstValidator1822);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred109_AstValidator

    // $ANTLR start synpred112_AstValidator
    public final void synpred112_AstValidator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:389:8: ( ^( CAST_EXPR type_cast expr ) )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:389:8: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred112_AstValidator1857); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred112_AstValidator1859);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred112_AstValidator1861);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred112_AstValidator

    // $ANTLR start synpred134_AstValidator
    public final void synpred134_AstValidator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:436:31: ( INTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:436:31: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred134_AstValidator2155); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred134_AstValidator

    // $ANTLR start synpred135_AstValidator
    public final void synpred135_AstValidator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:436:41: ( LONGINTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:436:41: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred135_AstValidator2159); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred135_AstValidator

    // $ANTLR start synpred136_AstValidator
    public final void synpred136_AstValidator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:442:33: ( DOUBLENUMBER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:442:33: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred136_AstValidator2198); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred136_AstValidator

    // $ANTLR start synpred166_AstValidator
    public final void synpred166_AstValidator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:496:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:496:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred166_AstValidator2547);
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


        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:496:38: ( OUTER )?
        int alt128=2;
        int LA128_0 = input.LA(1);

        if ( (LA128_0==OUTER) ) {
            alt128=1;
        }
        switch (alt128) {
            case 1 :
                // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:496:38: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred166_AstValidator2563); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred166_AstValidator2566);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred166_AstValidator

    // $ANTLR start synpred184_AstValidator
    public final void synpred184_AstValidator_fragment() throws RecognitionException {
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:575:43: ( INTEGER )
        // /home/ubuntu/spork/src/org/apache/pig/parser/AstValidator.g:575:43: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred184_AstValidator2977); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred184_AstValidator

    // Delegated rules

    public final boolean synpred136_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred136_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred104_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred184_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred184_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred166_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred166_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred135_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred135_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred134_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred134_AstValidator_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_statement_in_query82 = new BitSet(new long[]{0x0000000000040008L,0x0008000000000000L,0x0000480000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_cache_statement_in_statement136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_cache_clause_in_rel_cache_statement162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement173 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement177 = new BitSet(new long[]{0x0024200113200000L,0x0308408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_op_clause_in_general_statement184 = new BitSet(new long[]{0x0000000000000008L,0x0000000080000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement186 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause201 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause203 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause220 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause222 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROBA_in_previous_rel255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause518 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause520 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause524 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause528 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd549 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd553 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd577 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd601 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd625 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd649 = new BitSet(new long[]{0x1000000000040008L,0x0021000040000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause688 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause690 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list702 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause714 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause729 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause731 = new BitSet(new long[]{0x0000000000000008L,0x00C0004000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd745 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd747 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd767 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd769 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd789 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd791 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause805 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause807 = new BitSet(new long[]{0x0000000000000008L,0x00C0004000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause821 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause826 = new BitSet(new long[]{0x4000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause828 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause845 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause847 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause849 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause852 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause874 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause876 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def895 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def897 = new BitSet(new long[]{0x200080100412A808L,0x0000000000000400L,0x0004000800000800L});
    public static final BitSet FOLLOW_type_in_field_def901 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def911 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def913 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list941 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_simple_type_in_type960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1086 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1088 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1102 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1104 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0004000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1107 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1121 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1123 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1137 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1139 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1159 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1161 = new BitSet(new long[]{0x0000000000000008L,0x0000004000010000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1163 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1175 = new BitSet(new long[]{0x0000000400000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_set_in_func_name1179 = new BitSet(new long[]{0xBBBCE8115737AF50L,0xFFE96381EC06370EL,0x006380000000007DL});
    public static final BitSet FOLLOW_eid_in_func_name1189 = new BitSet(new long[]{0x0000000400000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_func_args_string_in_func_args1214 = new BitSet(new long[]{0x0000000000000002L,0x0000004000010000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1227 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1229 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1241 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1259 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1261 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1273 = new BitSet(new long[]{0x0000000002000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_set_in_cube_rollup_list1286 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1296 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1308 = new BitSet(new long[]{0x40A2082A02005002L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_group_clause1348 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1358 = new BitSet(new long[]{0x00A4200113200088L,0x030840C108002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_group_type_in_group_clause1361 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1364 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1386 = new BitSet(new long[]{0x0000000000010010L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1390 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1394 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1398 = new BitSet(new long[]{0x0800000000000002L,0x0000000020000000L});
    public static final BitSet FOLLOW_alias_in_rel1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_previous_rel_in_rel1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1445 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1459 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1463 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1467 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1471 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000C00000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1487 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1489 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1502 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause1504 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause1506 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1508 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1522 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1524 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_cond_in_filter_clause1526 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1539 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1541 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_cond_in_cond1543 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1556 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1558 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_cond_in_cond1560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1575 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1588 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1590 = new BitSet(new long[]{0x0000000000000008L,0x0000000000020000L});
    public static final BitSet FOLLOW_NOT_in_cond1592 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1606 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1608 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_cond1610 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond1621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond1641 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1643 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval1655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1657 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_in_eval1659 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1672 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1674 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1676 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_INVOKER_FUNC_EVAL_in_func_eval1685 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1687 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval1689 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1691 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_expr_in_real_arg1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1722 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1724 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr1726 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1739 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1741 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr1743 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1756 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1758 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr1760 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1773 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1775 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr1777 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr1790 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1792 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr1794 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1807 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr1809 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr1811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr1831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr1842 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1844 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1857 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr1859 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_expr1861 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr1874 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1876 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast1887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast1899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1910 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast1912 = new BitSet(new long[]{0x200080100412A808L,0x0000000000000400L,0x0008000800001000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1926 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast1928 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr1940 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr1944 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr1948 = new BitSet(new long[]{0x0000000000000002L,0x0000001400000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr1959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr1967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr1971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj1986 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj1988 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index2004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2041 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2043 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2046 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range2048 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2062 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_pound_proj2064 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2085 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2087 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_bin_expr2089 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_bin_expr2091 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr2103 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2105 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond2118 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond2122 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond2124 = new BitSet(new long[]{0x0400000000000048L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_THEN_in_case_cond2131 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond2133 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2149 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2151 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2155 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2159 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2163 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CACHE_in_rel_cache_clause2178 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_rel_cache_clause2180 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2192 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2194 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2198 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2202 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause2217 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause2219 = new BitSet(new long[]{0x0000000000010008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause2223 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement2239 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement2241 = new BitSet(new long[]{0x0000000020000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement2245 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause2259 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause2289 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_col_range_in_rank_col2299 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_col_ref_in_rank_col2321 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_ORDER_in_order_clause2343 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause2345 = new BitSet(new long[]{0x00A0000802000000L,0x0010000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause2347 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause2349 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause2361 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2392 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_col_range_in_order_col2402 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_col_ref_in_order_col2425 = new BitSet(new long[]{0x0000000040000202L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause2447 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause2449 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause2451 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause2465 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause2467 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause2480 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause2482 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause2484 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list2496 = new BitSet(new long[]{0x00A4200113200082L,0x0308408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_JOIN_in_join_clause2518 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause2520 = new BitSet(new long[]{0x0000000000000008L,0x0000004100000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause2522 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause2525 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2547 = new BitSet(new long[]{0x0008000000000000L,0x0000020000000008L});
    public static final BitSet FOLLOW_set_in_join_sub_clause2549 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2563 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2571 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2584 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2586 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2588 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2615 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2619 = new BitSet(new long[]{0x40A2082A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2657 = new BitSet(new long[]{0x00A4200113200080L,0x0308408008002304L,0x0000000000000020L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2660 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2673 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000003000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2677 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2690 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2692 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2713 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2715 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2735 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x000000C000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2749 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause2751 = new BitSet(new long[]{0x40A2482A02005008L,0x0010004A00044800L,0x00100030283E6008L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command2766 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2768 = new BitSet(new long[]{0x0004200101000000L,0x0000000008000100L,0x0000010000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command2770 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command2784 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2786 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_nested_command2788 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op2804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op2818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op2846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op2860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op2888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj2899 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2901 = new BitSet(new long[]{0x00A0000802000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2903 = new BitSet(new long[]{0x00A0000802000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter2918 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter2920 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_cond_in_nested_filter2922 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort2935 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort2937 = new BitSet(new long[]{0x00A0000802000000L,0x0010000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort2940 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000014000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort2942 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct2956 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct2958 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit2971 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit2973 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit2977 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit2981 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross2996 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross2998 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach3011 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach3013 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach3015 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list3039 = new BitSet(new long[]{0x00A0000802000002L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause3051 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause3053 = new BitSet(new long[]{0x0080040000000000L});
    public static final BitSet FOLLOW_set_in_stream_clause3055 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause3065 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause3079 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause3081 = new BitSet(new long[]{0x0000000000000000L,0x0100004000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause3083 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause3086 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause3088 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause3090 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause3104 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause3106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3108 = new BitSet(new long[]{0x0000000000000008L,0x0000000010000000L,0x0000200000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause3111 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch3126 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch3128 = new BitSet(new long[]{0x0400000000000040L,0xFC00000005FE0000L,0x0000000028010001L});
    public static final BitSet FOLLOW_cond_in_split_branch3130 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise3148 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise3150 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref3170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref3196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr3205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal3222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal3226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar3235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar3239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar3243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar3247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar3251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar3260 = new BitSet(new long[]{0x4002002000005000L,0x0000000000000800L});
    public static final BitSet FOLLOW_set_in_num_scalar3263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map3298 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map3300 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue3314 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue3316 = new BitSet(new long[]{0x4002082000005000L,0x0000004000044800L,0x0010001000002008L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue3318 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key3329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag3340 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag3342 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple3356 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple3358 = new BitSet(new long[]{0x4002082000005008L,0x0000004000044800L,0x0010001000002008L});
    public static final BitSet FOLLOW_rel_str_op_in_eid3371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid3395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid3403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid3411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid3419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid3427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid3435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid3443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid3459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid3467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid3475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid3483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid3491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid3507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid3515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid3523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid3531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid3539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid3547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid3555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid3563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid3571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid3579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid3587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid3603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid3611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid3619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid3627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid3659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid3667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid3675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid3683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid3691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid3699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid3707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid3715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid3723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid3731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid3739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid3747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid3755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid3763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid3771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid3779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid3787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid3795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid3803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid3811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid3819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid3827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid3835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid3843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid3851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid3859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid3867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid3875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid3883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid3891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid3899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid3907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid3915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid3923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid3931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid3939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid3947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op3965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op3976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op3987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op3998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op4009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op4020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op4031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred104_AstValidator1739 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred104_AstValidator1741 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_synpred104_AstValidator1743 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred108_AstValidator1807 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred108_AstValidator1809 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_synpred108_AstValidator1811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred109_AstValidator1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred112_AstValidator1857 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred112_AstValidator1859 = new BitSet(new long[]{0x40A2082A02005000L,0x0010004A00044800L,0x00100030282E6008L});
    public static final BitSet FOLLOW_expr_in_synpred112_AstValidator1861 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_synpred134_AstValidator2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred135_AstValidator2159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred136_AstValidator2198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred166_AstValidator2547 = new BitSet(new long[]{0x0008000000000000L,0x0000020000000008L});
    public static final BitSet FOLLOW_set_in_synpred166_AstValidator2549 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred166_AstValidator2563 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_join_item_in_synpred166_AstValidator2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred184_AstValidator2977 = new BitSet(new long[]{0x0000000000000002L});

}