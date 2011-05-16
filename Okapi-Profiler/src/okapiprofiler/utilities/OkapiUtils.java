/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package okapiprofiler.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QiangWu
 */
public class OkapiUtils {

    public File getOkapiFile(File okapiRoot, String filePath) {
        File okapiFile = new File(okapiRoot.getAbsolutePath() + filePath);

        if (okapiFile.exists()) {
            return okapiFile;
        }
        return null;
    }

    public ArrayList<String> getDbList(File dbavail) {
        ArrayList<String> dbList = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new FileInputStream(dbavail));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.startsWith(OkapiConstants.DBAVAIL_SEPARATOR)) {
                    dbList.add(getDbName(line));
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OkapiUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dbList;
    }

    public File getDbConfig(File database, String dbName) {
        File dbConfig = new File(database.getAbsolutePath() + File.separator + dbName);
        if (dbConfig.exists()) {
            return dbConfig;
        }
        return null;
    }

    public File getDbSearchConfig(File database, String dbName) {
        File dbSearchConfig = new File(database.getAbsolutePath() + File.separator + dbName + OkapiConstants.DBSEARCH_EXT);
        if (dbSearchConfig.exists()) {
            return dbSearchConfig;
        }
        return null;
    }

    private String getDbName(String dbName) {
        // remove " *"
        dbName = dbName.substring(0, dbName.indexOf(OkapiConstants.DBAVAIL_POSTFIX) - 1);
        return dbName;
    }

    public ArrayList<String[]> getEnvirSettings(File enviset) {
        ArrayList<String[]> envirSettingInfo = new ArrayList<String[]>();
        try {
            Scanner scanner = new Scanner(new FileInputStream(enviset));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // settings line starts with "setenv"
                if (line.startsWith(OkapiConstants.SETTINGENVIR_PREFIX)) {
                    envirSettingInfo.add(getEnvirSettingInfo(line));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return envirSettingInfo;
    }

    private String[] getEnvirSettingInfo(String envirSetting) {
        String[] envirInfo = new String[2];
        StringTokenizer st = new StringTokenizer(envirSetting, " ");
        while (st.hasMoreTokens()) {
            st.nextToken();
            envirInfo[0] = st.nextToken();
            envirInfo[1] = st.nextToken();
        }

        return envirInfo;
    }
}
