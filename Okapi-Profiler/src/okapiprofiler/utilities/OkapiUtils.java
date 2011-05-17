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
import javax.swing.JTable;
import org.apache.commons.io.FileUtils;

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
            Logger.getLogger(OkapiUtils.class.getName()).log(Level.SEVERE, null, e);
        }
        return envirSettingInfo;
    }

    private String[] getEnvirSettingInfo(String envirSetting) {
        String[] envirInfo = new String[2];
        StringTokenizer st = new StringTokenizer(envirSetting, " ");
        while (st.hasMoreTokens()) {
            st.nextToken();
            envirInfo[0] = st.nextToken().trim();
            envirInfo[1] = st.nextToken().trim();
        }

        return envirInfo;
    }

    public ArrayList<String[]> getDBConfigs(File dbConfigFile) {
        ArrayList<String[]> dbConfigs = new ArrayList<String[]>();
        try {
            Scanner scanner = new Scanner(dbConfigFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line, "=");
                String[] config = new String[2];
                while (st.hasMoreTokens()) {
                    config[0] = st.nextToken().trim();
                    config[1] = st.nextToken().trim();
                }
                dbConfigs.add(config);
            }
        } catch (Exception ex) {
            Logger.getLogger(OkapiUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dbConfigs;
    }

    public ArrayList<String> getSearchGroup(File dbSearchGroupFile) {
        ArrayList<String> dbSearchConfig = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(new FileInputStream(dbSearchGroupFile));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line, " ");
                while (st.hasMoreTokens()) {
                    String config = st.nextToken();
                    dbSearchConfig.add(config);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OkapiUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dbSearchConfig;
    }

    /**
     * save table settings back to file
     * @param envirSetTable
     * @param enviset
     * @return
     */
    public ArrayList<String[]> saveEnvirSettings(JTable envirSetTable, File enviset) {
        ArrayList<String[]> changes = new ArrayList<String[]>();

        ArrayList<String[]> envirSettings = new ArrayList<String[]>();
        // traverse table and find udpates
        for (int i = 0; i < envirSetTable.getRowCount(); i++) {
            String[] envirSetting = new String[2];
            envirSetting[0] = (String) envirSetTable.getValueAt(i, 0);
            envirSetting[1] = (String) envirSetTable.getValueAt(i, 1);
            envirSettings.add(envirSetting);
        }

        // read from environmental setting
        try {
            Scanner scanner = new Scanner(new FileInputStream(enviset));
            String output = ""; // output string to new tmp file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith(OkapiConstants.SETTINGENVIR_PREFIX)) {
                    StringTokenizer st = new StringTokenizer(line, " ");
                    st.nextToken(); // prefix
                    String name = st.nextToken();
                    String value = st.nextToken();
                    String newValue = getEnvirSetValueByName(envirSettings, name);
                    if (!value.equals(newValue)) {

                        // replace old value to new value
                        line = line.replace(value, newValue);

                        // modified value list
                        String[] newSetting = {name, newValue};
                        changes.add(newSetting);
                        //System.out.println("changes add " + name + " " + newValue);
                    }
                }
                output += line + "\n";
            }
            scanner.close();

            if (!changes.isEmpty()) {
                // save output to tmp file
                // System.out.println(changes.size());
                File tmpEnviset = new File(FileUtils.getTempDirectoryPath() + File.separator + enviset.getName());
                //System.out.println(tmpEnviset.getAbsolutePath());

                try {
                    FileUtils.writeStringToFile(tmpEnviset, output);
                    FileUtils.copyFile(tmpEnviset, enviset);
                    FileUtils.deleteDirectory(tmpEnviset);
                } catch (Exception ex) {
                }

            }
        } catch (Exception ex) {
        }




        return changes;
    }

    private String getEnvirSetValueByName(ArrayList<String[]> envirSettings, String name) {

        for (String[] envirSetting : envirSettings) {
            if (envirSetting[0].equals(name)) {
                return envirSetting[1];
            }
        }

        return null;
    }
}
