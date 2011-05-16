/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package okapiprofiler.utilities;

import java.io.File;

/**
 *
 * @author QiangWu
 */
public class OkapiConstants {

    // table names
    public static final String OKAPIFILES_TABLENAME = "okapiFiles";
    public static final String OKAPIDBLIST_TABLENAME = "dbList";
    public static final String OKAPIENVIRSETTING_TABLENAME = "Environment Settings";


    // table headers
    public static final String[] OKAPIFILES_HEADER = {"Variable", "Value"};
    public static final String[] DBLIST_HEADER = {"Database Name", "DB Configure Name", "Search Group Configure Name"};
    public static final String[] ENVIRSETTING_HEADER = {"Property Name", "Value"};
    // okapi files table
    public static final String ROOTPATH = "rootPath";
    // paths and urls
    public static final String ENVISET = File.separator + "environmentSettings.cshrc";
    public static final String DATABASE = File.separator + "databases";
    public static final String DBAVAIL = DATABASE + File.separator + "db_avail";
    public static final String STOPWORD = DATABASE + File.separator + "stopword";
    // notes, special separator, extension
    public static final String DBAVAIL_SEPARATOR = "##";
    public static final char DBAVAIL_POSTFIX = '*';
    public static final String DBSEARCH_EXT = ".search_groups";
    public static final String SETTINGENVIR_PREFIX = "setenv";
    // environmentSettings.cshrc
    public static final String TMPDIR = "TMPDIR";
    public static final String OKAPI_ROOT = "OKAPI_ROOT";
    public static final String OKAPI_LIBDIR = "OKAPI_LIBDIR";
    public static final String OKAPI_BINDIR = "OKAPI_BINDIR";
    public static final String BSS_TEMPPATH = "BSS_TEMPPATH";
    public static final String BSS_PARMPATH = "BSS_PARMPATH";
    public static final String GUI_CONFIG_FILES = "GUI_CONFIG_FILES";
    public static final String INDEXER_LOGS = "INDEXER_LOGS";
    public static final String OKAPI_LOGS_DIR = "OKAPI_LOGS_DIR";
    public static final String BSS_PASSAGE_AVEDOCLEN = "BSS_PASSAGE_AVEDOCLEN";
    public static final String OKAPI_SOURCE = "OKAPI_SOURCE";
    public static final String OKAPI_PARSE = "OKAPI_PARSE";
    public static final String MAIN_DEBUG = "MAIN_DEBUG";
    public static final String MAKE_RS_SETS_DEBUG = "MAKE_RS_SETS_DEBUG";
    public static final String READ_PARAMETER_FILES_DEBUG = "READ_PARAMETER_FILES_DEBUG";
    public static final String CHECK_FOR_PARAGRAPH_FILE_DEBUG = "CHECK_FOR_PARAGRAPH_FILE_DEBUG";
    public static final String SET_ENV_DEBUG = "SET_ENV_DEBUG";
    public static final String READ_ENV_DEBUG = "READ_ENV_DEBUG";
    public static final String ADD_TO_SEEN_SET_DEBUG = "ADD_TO_SEEN_SET_DEBUG";
    public static final String ADD_TO_BIGR_SET_DEBUG = "ADD_TO_BIGR_SET_DEBUG";
    public static final String ADJUST_RSV_FACTOR_DEBUG = "ADJUST_RSV_FACTOR_DEBUG";
    public static final String BIGRLOAD = "BIGRLOAD";
    public static final String BM_TARGET = "BM_TARGET";
    public static final String BOTH_PHRASE_OPS = "BOTH_PHRASE_OPS";
    public static final String BSS_SEARCH_DEBUG = "BSS_SEARCH_DEBUG";
    public static final String BUILD_HITLIST_DEBUG = "BUILD_HITLIST_DEBUG";
    public static final String CALC_RSV_DEBUG = "CALC_RSV_DEBUG";
    public static final String CALC_WGT_DEBUG = "CALC_WGT_DEBUG";
    public static final String CHARS_PER_PAGE = "CHARS_PER_PAGE";
    public static final String CHECK_USER_RELS_DEBUG = "CHECK_USER_RELS_DEBUG";
    public static final String CLEAR_RF_DEBUG = "CLEAR_RF_DEBUG";
    public static final String CONSTRUCT_DOCLENGTH_FIELD_DEBUG = "CONSTRUCT_DOCLENGTH_FIELD_DEBUG";
    public static final String CONSTRUCT_TITLE_DEBUG = "CONSTRUCT_TITLE_DEBUG";
    public static final String DB_SEARCH_DEBUG = "DB_SEARCH_DEBUG";
    public static final String DETERMINE_DOC_LENGTH_DEBUG = "DETERMINE_DOC_LENGTH_DEBUG";
    public static final String DIRECTORY_REC_LEN = "DIRECTORY_REC_LEN";
    public static final String DISPLAY_DEBUG = "DISPLAY_DEBUG";
    public static final String DOC_THRESHOLD = "DOC_THRESHOLD";
    public static final String EXTRACT_TERMS_DEBUG = "EXTRACT_TERMS_DEBUG";
    public static final String FIND_DOCSET_DEBUG = "FIND_DOCSET_DEBUG";
    public static final String HEADER_SHOW_FORMAT = "HEADER_SHOW_FORMAT";
    public static final String HIGHLIGHT_REC_LEN = "HIGHLIGHT_REC_LEN";
    public static final String HYPHEN_POS = "HYPHEN_POS";
    public static final String MAKERJ_DEBUG = "MAKERJ_DEBUG";
    public static final String MAKE_REL_DEBUG = "MAKE_REL_DEBUG";
    public static final String MAX_RECS_TO_SHOW = "MAX_RECS_TO_SHOW";
    public static final String MAX_RELS = "MAX_RELS";
    public static final String MAX_TERMSET_SIZE = "MAX_TERMSET_SIZE";
    public static final String MAX_TERMS_PER_DOC = "MAX_TERMS_PER_DOC";
    public static final String MAX_TITLE_CHARS = "MAX_TITLE_CHARS";
    public static final String OFFSET_X = "OFFSET_X";
    public static final String OFFSET_Y = "OFFSET_Y";
    public static final String PARSE_HEADER_DEBUG = "PARSE_HEADER_DEBUG";
    public static final String PARSE_SHOW_FILE_DEBUG = "PARSE_SHOW_FILE_DEBUG";
    public static final String PASSAGE_REC_LEN = "PASSAGE_REC_LEN";
    public static final String PASSAGE_SHOW_FORMAT = "PASSAGE_SHOW_FORMAT";
    public static final String P_STEP = "P_STEP";
    public static final String P_UNIT = "P_UNIT";
    public static final String QUERY_WINDOW_WIDTH = "QUERY_WINDOW_WIDTH";
    public static final String REMOVE_FROM_BIGR_SET_DEBUG = "REMOVE_FROM_BIGR_SET_DEBUG";
    public static final String RLOAD = "RLOAD";
    public static final String SET_LR_THRESHOLD_DEBUG = "SET_LR_THRESHOLD_DEBUG";
    public static final String SET_RSV_FACTOR_DEBUG = "SET_RSV_FACTOR_DEBUG";
    public static final String SHOW_DEBUG = "SHOW_DEBUG";
    public static final String SPLIT_UP_DEBUG = "SPLIT_UP_DEBUG";
    public static final String TERM_INPUT_DEBUG = "TERM_INPUT_DEBUG";
    public static final String TERM_OCCURRENCE_DEBUG = "TERM_OCCURRENCE_DEBUG";
    public static final String UPDATE_USER_RELS_DEBUG = "UPDATE_USER_RELS_DEBUG";
    public static final String WEIGHT_FUNCTION = "WEIGHT_FUNCTION";
    public static final String WRITE_NEW_FILE_DEBUG = "WRITE_NEW_FILE_DEBUG";
    public static final String WRITE_USER_TERMS_DEBUG = "WRITE_USER_TERMS_DEBUG";
    public static final String TERM_ENTRY_DEBUG = "TERM_ENTRY_DEBUG";
}
