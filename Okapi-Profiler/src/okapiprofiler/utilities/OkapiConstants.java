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
    public static final String OKAPIENVIRSETTING_TABLENAME = "EnvironmentSettings";
    public static final String OKAPIDBCONFIG_TABLENAME = "dbConfigs";
    public static final String OKAPISEARCHGROUP_TABLENAME = "searchGroupConfig";
    public static final String OKAPIADDDBTABLE_TABLENAME = "addTable";
    // table headers
    public static final String[] OKAPIFILES_HEADER = {"Variable", "Value"};
    public static final String[] DBLIST_HEADER = {"Database Name", "DB Configure Name", "Search Group Configure Name"};
    public static final String[] ENVIRSETTING_HEADER = {"Property Name", "Value"};
    public static final String[] DBCONFIG_HEADER = {"Property Name", "Value"};
    public static final String[] DBSEARCHGROUP_HEADER = {"Property Name", "Value"};
    public static final String[] OKAPIADDDBTABLE_HEADER = {"Name", "Value"};
    // table addDbTable names
    public static final String ADDDBTABLE_DBNAME = "DB Name";
    public static final String ADDDBTABLE_NUMOFFILES = "Number of bib files";
    // okapi files table
    public static final String ROOTPATH = "rootPath";
    // paths and urls
    public static final String ENVISET = File.separator + "environmentSettings.cshrc";
    public static final String DATABASE = File.separator + "databases";
    public static final String BIBFILES = File.separator + "bibfiles";
    public static final String DBAVAIL = DATABASE + File.separator + "db_avail";
    public static final String STOPWORD = DATABASE + File.separator + "stopword";
    public static final String SAMPLEDB = "/okapiprofiler/resources/sampleDb";
    public static final String SAMPLEDBSG = "/okapiprofiler/resources/sampleDb.search_groups";
    // notes, special separator, extension
    public static final String DBAVAIL_SEPARATOR = "##";
    public static final char DBAVAIL_POSTFIX = '*';
    public static final String DBSEARCH_EXT = ".search_groups";
    public static final String SETTINGENVIR_PREFIX = "setenv";
    // sampleDb
    public static final String SAMPLEDB_NAME = "name";
    public static final String SAMPLEDB_LASTBIBVOL = "lastbibvol";
    public static final String SAMPLEDB_BIB_BASENAME = "bib_basename";
    public static final String SAMPLEDB_BIB_BASENAME_EXT = ".bib";
    public static final String SAMPLEDB_BIB_DIR = "bib_dir";
    public static final String SAMPLEDB_BIB_SIZE = "bibsize";
    public static final String SAMPLEDB_DISPLAY_NAME = "display_name";
    public static final String SAMPLEDB_EXPLANATION = "explanation";
    // environmentSettings.cshrc
    public static final String ES_TMPDIR = "TMPDIR";
    public static final String ES_OKAPI_ROOT = "OKAPI_ROOT";
    public static final String ES_OKAPI_LIBDIR = "OKAPI_LIBDIR";
    public static final String ES_OKAPI_BINDIR = "OKAPI_BINDIR";
    public static final String ES_BSS_TEMPPATH = "BSS_TEMPPATH";
    public static final String ES_BSS_PARMPATH = "BSS_PARMPATH";
    public static final String ES_GUI_CONFIG_FILES = "GUI_CONFIG_FILES";
    public static final String ES_INDEXER_LOGS = "INDEXER_LOGS";
    public static final String ES_OKAPI_LOGS_DIR = "OKAPI_LOGS_DIR";
    public static final String ES_BSS_PASSAGE_AVEDOCLEN = "BSS_PASSAGE_AVEDOCLEN";
    public static final String ES_OKAPI_SOURCE = "OKAPI_SOURCE";
    public static final String ES_OKAPI_PARSE = "OKAPI_PARSE";
    public static final String ES_MAIN_DEBUG = "MAIN_DEBUG";
    public static final String ES_MAKE_RS_SETS_DEBUG = "MAKE_RS_SETS_DEBUG";
    public static final String ES_READ_PARAMETER_FILES_DEBUG = "READ_PARAMETER_FILES_DEBUG";
    public static final String ES_CHECK_FOR_PARAGRAPH_FILE_DEBUG = "CHECK_FOR_PARAGRAPH_FILE_DEBUG";
    public static final String ES_SET_ENV_DEBUG = "SET_ENV_DEBUG";
    public static final String ES_READ_ENV_DEBUG = "READ_ENV_DEBUG";
    public static final String ES_ADD_TO_SEEN_SET_DEBUG = "ADD_TO_SEEN_SET_DEBUG";
    public static final String ES_ADD_TO_BIGR_SET_DEBUG = "ADD_TO_BIGR_SET_DEBUG";
    public static final String ES_ADJUST_RSV_FACTOR_DEBUG = "ADJUST_RSV_FACTOR_DEBUG";
    public static final String ES_ES_BIGRLOAD = "BIGRLOAD";
    public static final String ES_ES_BM_TARGET = "BM_TARGET";
    public static final String ES_BOTH_PHRASE_OPS = "BOTH_PHRASE_OPS";
    public static final String ES_BSS_SEARCH_DEBUG = "BSS_SEARCH_DEBUG";
    public static final String ES_BUILD_HITLIST_DEBUG = "BUILD_HITLIST_DEBUG";
    public static final String ES_CALC_RSV_DEBUG = "CALC_RSV_DEBUG";
    public static final String ES_CALC_WGT_DEBUG = "CALC_WGT_DEBUG";
    public static final String ES_CHARS_PER_PAGE = "CHARS_PER_PAGE";
    public static final String ES_CHECK_USER_RELS_DEBUG = "CHECK_USER_RELS_DEBUG";
    public static final String ES_CLEAR_RF_DEBUG = "CLEAR_RF_DEBUG";
    public static final String ES_CONSTRUCT_DOCLENGTH_FIELD_DEBUG = "CONSTRUCT_DOCLENGTH_FIELD_DEBUG";
    public static final String ES_CONSTRUCT_TITLE_DEBUG = "CONSTRUCT_TITLE_DEBUG";
    public static final String ES_DB_SEARCH_DEBUG = "DB_SEARCH_DEBUG";
    public static final String ES_DETERMINE_DOC_LENGTH_DEBUG = "DETERMINE_DOC_LENGTH_DEBUG";
    public static final String ES_DIRECTORY_REC_LEN = "DIRECTORY_REC_LEN";
    public static final String ES_DISPLAY_DEBUG = "DISPLAY_DEBUG";
    public static final String ES_DOC_THRESHOLD = "DOC_THRESHOLD";
    public static final String ES_EXTRACT_TERMS_DEBUG = "EXTRACT_TERMS_DEBUG";
    public static final String ES_FIND_DOCSET_DEBUG = "FIND_DOCSET_DEBUG";
    public static final String ES_HEADER_SHOW_FORMAT = "HEADER_SHOW_FORMAT";
    public static final String ES_HIGHLIGHT_REC_LEN = "HIGHLIGHT_REC_LEN";
    public static final String ES_HYPHEN_POS = "HYPHEN_POS";
    public static final String ES_MAKERJ_DEBUG = "MAKERJ_DEBUG";
    public static final String ES_MAKE_REL_DEBUG = "MAKE_REL_DEBUG";
    public static final String ES_MAX_RECS_TO_SHOW = "MAX_RECS_TO_SHOW";
    public static final String ES_MAX_RELS = "MAX_RELS";
    public static final String ES_MAX_TERMSET_SIZE = "MAX_TERMSET_SIZE";
    public static final String ES_MAX_TERMS_PER_DOC = "MAX_TERMS_PER_DOC";
    public static final String ES_MAX_TITLE_CHARS = "MAX_TITLE_CHARS";
    public static final String ES_OFFSET_X = "OFFSET_X";
    public static final String ES_OFFSET_Y = "OFFSET_Y";
    public static final String ES_PARSE_HEADER_DEBUG = "PARSE_HEADER_DEBUG";
    public static final String ES_PARSE_SHOW_FILE_DEBUG = "PARSE_SHOW_FILE_DEBUG";
    public static final String ES_PASSAGE_REC_LEN = "PASSAGE_REC_LEN";
    public static final String ES_PASSAGE_SHOW_FORMAT = "PASSAGE_SHOW_FORMAT";
    public static final String ES_P_STEP = "P_STEP";
    public static final String ES_P_UNIT = "P_UNIT";
    public static final String ES_QUERY_WINDOW_WIDTH = "QUERY_WINDOW_WIDTH";
    public static final String ES_REMOVE_FROM_BIGR_SET_DEBUG = "REMOVE_FROM_BIGR_SET_DEBUG";
    public static final String ES_RLOAD = "RLOAD";
    public static final String ES_SET_LR_THRESHOLD_DEBUG = "SET_LR_THRESHOLD_DEBUG";
    public static final String ES_SET_RSV_FACTOR_DEBUG = "SET_RSV_FACTOR_DEBUG";
    public static final String ES_SHOW_DEBUG = "SHOW_DEBUG";
    public static final String ES_SPLIT_UP_DEBUG = "SPLIT_UP_DEBUG";
    public static final String ES_TERM_INPUT_DEBUG = "TERM_INPUT_DEBUG";
    public static final String ES_TERM_OCCURRENCE_DEBUG = "TERM_OCCURRENCE_DEBUG";
    public static final String ES_UPDATE_USER_RELS_DEBUG = "UPDATE_USER_RELS_DEBUG";
    public static final String ES_WEIGHT_FUNCTION = "WEIGHT_FUNCTION";
    public static final String ES_WRITE_NEW_FILE_DEBUG = "WRITE_NEW_FILE_DEBUG";
    public static final String ES_WRITE_USER_TERMS_DEBUG = "WRITE_USER_TERMS_DEBUG";
    public static final String ES_TERM_ENTRY_DEBUG = "TERM_ENTRY_DEBUG";
    // search group
    public static final String SG_INDEX_NAME = "<index_name>";
    public static final String SG_DUMMY = "<dummy>";
    public static final String SG_INDEX_NO = "<index_no>";
    public static final String SG_TERM_EX_REG = "<term extraction regime>";
    public static final String SG_STEM_FUNC_NAME = "<stem function name>";
    public static final String SG_GSL_FILENAME = "<GSL filename>";
    public static final String SG_FIELD_LIST = "<field_list>";
}
