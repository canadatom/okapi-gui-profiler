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
import okapiprofiler.Okapi;
import org.apache.commons.io.FileUtils;
import org.jdesktop.application.Application;
import org.jdesktop.application.ResourceMap;

/**
 *
 * @author QiangWu
 */
public class OkapiUtils {

    public OkapiUtils() {
    }

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
            envirInfo[0] = st.nextToken();
            envirInfo[1] = st.nextToken();
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
                    config[0] = st.nextToken();
                    config[1] = st.nextToken();
                }
                dbConfigs.add(config);
            }
        } catch (Exception ex) {
            Logger.getLogger(OkapiUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dbConfigs;
    }

    public ArrayList<String[]> getSearchGroup(File dbSearchGroupFile) {
        ArrayList<String[]> dbSearchConfig = new ArrayList<String[]>();

        try {
            Scanner scanner = new Scanner(new FileInputStream(dbSearchGroupFile));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    StringTokenizer st = new StringTokenizer(line, " ");
                    String[] config = new String[st.countTokens()];
                    int i = 0;
                    int numOfTokens = st.countTokens();
                    while (st.hasMoreTokens() && i < numOfTokens) {
                        String token = st.nextToken();
                        config[i] = token;
                        // System.out.println(token + " " + i);
                        i++;
                    }
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
     * @param enviSetFrom
     * @return
     */
    public ArrayList<String[]> saveEnvirSettings(JTable envirSetTable, File enviSetFrom, File eviSetDest) {
        ArrayList<String[]> changes = new ArrayList<String[]>();

        ArrayList<String[]> envirSettings = convertTableToList(envirSetTable);

        // read from environmental setting
        try {
            Scanner scanner = new Scanner(new FileInputStream(enviSetFrom));
            String output = ""; // output string to new tmp file

            int index = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.startsWith(OkapiConstants.SETTINGENVIR_PREFIX)) {
                    StringTokenizer st = new StringTokenizer(line, " ");
                    st.nextToken(); // prefix
                    String name = st.nextToken();
                    String value = st.nextToken();

                    String newValue = getEnvirSetValueByName(envirSettings, name, index);
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

                // only property lines are being counted as index
                if (line.startsWith(OkapiConstants.SETTINGENVIR_PREFIX)) {
                    index++;
                }
            }
            scanner.close();

            if (!changes.isEmpty()) {
                // save output to tmp file
                // System.out.println(changes.size());
                File tmpEnviset = new File(FileUtils.getTempDirectoryPath() + File.separator + enviSetFrom.getName());
                //System.out.println(tmpEnviset.getAbsolutePath());

                try {
                    FileUtils.writeStringToFile(tmpEnviset, output);
                    FileUtils.copyFile(tmpEnviset, eviSetDest);
                    FileUtils.forceDelete(tmpEnviset);
                } catch (Exception ex) {
                }
            }
        } catch (Exception ex) {
        }

        return changes;
    }

    private String getEnvirSetValueByName(ArrayList<String[]> envirSettings, String name, int index) {

        for (int i = 0; i < envirSettings.size(); i++) {
            String[] envirSetting = envirSettings.get(i);

            // make sure old and new value are in same line and position
            if (envirSetting[0].equals(name) && index == i) {
                return envirSetting[1];
            }
        }

        return null;
    }

    public ArrayList<String[]> saveDbConfigSettings(JTable dbConfigTable, File dbConfig) {
        ArrayList<String[]> changes = new ArrayList<String[]>();

        // get updated data
        ArrayList<String[]> dbConfigTableData = convertTableToList(dbConfigTable);

        // finding updates
        try {
            Scanner scanner = new Scanner(new FileInputStream(dbConfig));
            String output = "";
            int index = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line, "=");
                while (st.hasMoreTokens()) {
                    String name = st.nextToken();
                    String value = st.nextToken();
                    String newValue = getDbConfigValueByName(dbConfigTableData, name, index);
                    if (!value.equals(newValue)) {
                        line = line.replace(value, newValue);

                        String[] newConfigData = {name, value};
                        changes.add(newConfigData);
                    }
                }
                output += line + "\n";
                index++;
            }
            scanner.close();

            if (!changes.isEmpty()) {
                // save output to tmp file
                File tmpDbConfig = new File(FileUtils.getTempDirectoryPath() + File.separator + dbConfig.getName());
                try {
                    FileUtils.writeStringToFile(tmpDbConfig, output);
                    FileUtils.copyFile(tmpDbConfig, dbConfig);
                    FileUtils.forceDelete(tmpDbConfig);
                } catch (Exception ex) {
                }
            }
        } catch (Exception ex) {
        }

        return changes;
    }

    private String getDbConfigValueByName(ArrayList<String[]> dbConfigTableData, String name, int index) {
        for (int i = 0; i < dbConfigTableData.size(); i++) {
            String[] config = dbConfigTableData.get(i);
            if (name.equals(config[0]) && index == i) {
                return config[1];
            }
        }
        return null;
    }

    public ArrayList<String[]> saveDbSearchGroupSettings(JTable dbSearchGroupTable, File dbSearchGroup) {
        ArrayList<String[]> changes = new ArrayList<String[]>();
        ArrayList<String[]> dbSearchGroupData = convertTableToList(dbSearchGroupTable);

        try {
            Scanner scanner = new Scanner(new FileInputStream(dbSearchGroup));
            String output = "";
            int index = 0; // keep index rolling
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringTokenizer st = new StringTokenizer(line, " ");

                while (st.hasMoreTokens()) {
                    String value = st.nextToken();
                    String newValue = dbSearchGroupData.get(index)[1];
                    if (!value.equals(newValue)) {
                        changes.add(dbSearchGroupData.get(index));
                        value = newValue;
                    }
                    output += value + " ";
                    index++;
                }
                output = output.trim();
                output += "\n";
            }
            scanner.close();


            File tmpDbConfig = new File(FileUtils.getTempDirectoryPath() + File.separator + dbSearchGroup.getName());
            try {
                FileUtils.writeStringToFile(tmpDbConfig, output);
                FileUtils.copyFile(tmpDbConfig, dbSearchGroup);
                FileUtils.forceDelete(tmpDbConfig);
            } catch (Exception ex) {
            }
        } catch (Exception ex) {
        }
        return changes;
    }

    /**
     * 
     * @param dataTable
     * @return
     */
    private ArrayList<String[]> convertTableToList(JTable dataTable) {
        ArrayList<String[]> dataList = new ArrayList<String[]>();

        for (int i = 0; i < dataTable.getRowCount(); i++) {
            String[] data = new String[2];
            data[0] = (String) dataTable.getValueAt(i, 0);
            data[1] = (String) dataTable.getValueAt(i, 1);
            dataList.add(data);
        }

        return dataList;
    }

    public ArrayList<String[]> saveAddDbSettings(JTable addDbTable, File database, File bibfiles) {
        ArrayList<String[]> changes = new ArrayList<String[]>();
        String dbName = (String) addDbTable.getValueAt(0, 1);
        String numOfFiles = (String) addDbTable.getValueAt(1, 1);
        String bibSize = (String) addDbTable.getValueAt(2, 1);

        //System.out.println(numOfFiles);

        if (!dbName.isEmpty() && !numOfFiles.isEmpty() && !bibSize.isEmpty()) {
            try {
                File sampleDbFile = new File(getClass().getResource(OkapiConstants.SAMPLEDB).getFile());
                FileInputStream sampleDbIS = new FileInputStream(sampleDbFile);

                Scanner scanner = new Scanner(sampleDbIS);
                String output = "";
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    StringTokenizer st = new StringTokenizer(line, "=");
                    while (st.hasMoreTokens()) {
                        String name = st.nextToken();
                        String value = st.nextToken();
                        if (name.equals(OkapiConstants.SAMPLEDB_NAME)) {
                            line = line.replace(value, dbName);
                        } else if (name.equals(OkapiConstants.SAMPLEDB_LASTBIBVOL)) {
                            // bibsize = bibsize - 1, starts from 0
                            Integer lastBibvol = Integer.parseInt(numOfFiles) - 1;
                            System.out.println(lastBibvol);
                            line = line.replace(value, lastBibvol.toString());
                        } else if (name.equals(OkapiConstants.SAMPLEDB_BIB_BASENAME)) {
                            line = line.replace(value, dbName + OkapiConstants.SAMPLEDB_BIB_BASENAME_EXT);
                        } else if (name.equals(OkapiConstants.SAMPLEDB_BIB_DIR)) {
                            line = line.replace(value, bibfiles.getAbsolutePath());
                        } else if (name.equals(OkapiConstants.SAMPLEDB_BIB_SIZE)) {
                            line = line.replace(value, bibSize);
                        } else if (name.equals(OkapiConstants.SAMPLEDB_DISPLAY_NAME)) {
                            line = line.replace(value, dbName);
                        } else if (name.equals(OkapiConstants.SAMPLEDB_EXPLANATION)) {
                            line = line.replace(value, dbName);
                        }
                        output += line;
                    }
                    output += "\n";
                }
                scanner.close();

                File tarDbConfig = new File(database.getAbsolutePath() + File.separator + dbName);
                try {
                    FileUtils.writeStringToFile(tarDbConfig, output);
                } catch (Exception ex) {
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OkapiUtils.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                File sampleDbSGFile = new File(getClass().getResource(OkapiConstants.SAMPLEDBSG).getFile());
                FileInputStream sampleDbSGIS = new FileInputStream(sampleDbSGFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OkapiUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        //FileUtils.copyFile(database, database);

        return changes;
    }
}
