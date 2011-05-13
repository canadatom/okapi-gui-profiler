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
    public static final String[] DEBUGTABLEHEADER = {"Variable", "Value"};

    // debugTable
    public static final String ROOTPATH = "rootPath";

    // paths and urls
    public static final String ENVISET = File.separator + "environmentSettings.cshrc";
    public static final String DBAVAIL = File.separator + "databases" + File.separator + "db_avail";
    public static final String STOPWORD = File.separator + "databases" + File.separator + "stopword";

    // notes, special separator
    public static final String DBAVAILSEPARATOR = "##";
}
