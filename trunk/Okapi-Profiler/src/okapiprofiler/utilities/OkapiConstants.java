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
    // table headers
    public static final String[] OKAPIFILES_HEADER = {"Variable", "Value"};
    public static final String[] DBLIST_HEADER = {"Database Name", "DB Configure Name", "Search Group Configure Name"};
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
    // db config is the same name as db name
}
