/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package okapiprofiler.utilities;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import okapiprofiler.Okapi;

/**
 *
 * @author QiangWu
 */
public class OkapiTables {

    public JTable getOkapiFilesTable(Okapi okapi) {
        JTable okapiFilesTable = new JTable();
        okapiFilesTable.setName(OkapiConstants.OKAPIFILES_TABLENAME);

        String[][] debugData = {
            {OkapiConstants.ROOTPATH, okapi.getOkapiRoot().getAbsolutePath()},
            {OkapiConstants.ENVISET, okapi.getEnviset().getAbsolutePath()},
            {OkapiConstants.DBAVAIL, okapi.getDbavail().getAbsolutePath()},
            {OkapiConstants.STOPWORD, okapi.getStopword().getAbsolutePath()}
        };

        okapiFilesTable.setModel(new DefaultTableModel(debugData, OkapiConstants.OKAPIFILES_HEADER) {

            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        okapiFilesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        return okapiFilesTable;
    }

    public JTable getDbListTable(Okapi okapi) {
        JTable dbListTable = new JTable();
        dbListTable.setName(OkapiConstants.OKAPIDBLIST_TABLENAME);

        // 3 fields in header
        String[][] dbList = new String[okapi.getDbList().size()][3];
        OkapiUtils okapiUtils = new OkapiUtils();

        if (!okapi.getDbList().isEmpty()) {
            for (int i = 0; i < okapi.getDbList().size(); i++) {

                String[] dbNames = new String[3];
                String dbName = okapi.getDbList().get(i);
                dbNames[0] = dbName;
                dbNames[1] = okapiUtils.getDbConfig(okapi.getDatabase(), dbName).getName();
                dbNames[2] = okapiUtils.getDbSearchConfig(okapi.getDatabase(), dbName).getName();
                dbList[i] = dbNames;
            }
        } else {
            System.out.println("There is no database in db_avail");
        }


        dbListTable.setModel(new DefaultTableModel(dbList, OkapiConstants.DBLIST_HEADER) {

            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        dbListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return dbListTable;
    }

    public JTable getEnvirSetTable(Okapi okapi) {
        JTable envirSetTable = new JTable();
        OkapiUtils okapiUtils = new OkapiUtils();
        ArrayList<String[]> envirSettings = new ArrayList<String[]>();
        envirSettings = okapiUtils.getEnvirSettings(okapi.getEnviset());

        // 2 fields "Property Name", "Value"
        String[][] envirSettingModel = new String[envirSettings.size()][2];
        for (int i = 0; i < envirSettings.size(); i++) {
            envirSettingModel[i] = envirSettings.get(i);
        }

        envirSetTable.setModel(new javax.swing.table.DefaultTableModel(
                envirSettingModel,
                OkapiConstants.ENVIRSETTING_HEADER) {

            boolean[] canEdit = new boolean[]{
                false, true
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        envirSetTable.setName(OkapiConstants.OKAPIENVIRSETTING_TABLENAME);
        envirSetTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        return envirSetTable;
    }

    public JTable getDBConfigFileTable(File dbConfigFile) {
        JTable dbConfigFileTable = new JTable();
        OkapiUtils okapiUtils = new OkapiUtils();
        ArrayList<String[]> dbConfigs = okapiUtils.getDBConfigs(dbConfigFile);

        String[][] dbConfigList = new String[dbConfigs.size()][2];
        for (int i = 0; i < dbConfigs.size(); i++) {
            String[] dbConfig = new String[2];
            dbConfig[0] = dbConfigs.get(i)[0];
            dbConfig[1] = dbConfigs.get(i)[1];
            dbConfigList[i] = dbConfig;
        }

        dbConfigFileTable.setModel(new javax.swing.table.DefaultTableModel(
                dbConfigList,
                OkapiConstants.DBCONFIG_HEADER) {

            boolean[] canEdit = new boolean[]{
                false, true
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        dbConfigFileTable.setName(OkapiConstants.OKAPIDBCONFIG_TABLENAME);
        dbConfigFileTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return dbConfigFileTable;
    }

    public JTable getSearchGroupTable(File searchGroupFile) {
        JTable searchGroupTable = new JTable();

        OkapiUtils okapiUtils = new OkapiUtils();
        ArrayList<String> searchGroups = okapiUtils.getSearchGroup(searchGroupFile);
        String[][] searchGroupList = new String[searchGroups.size()][2];
        for (int i = 0; i < searchGroups.size(); i++) {
            String searchGroup[] = new String[2];

            switch (i) {
                case 0:
                    searchGroup[0] = OkapiConstants.SG_INDEX_NAME;
                    break;
                case 1:
                    searchGroup[0] = OkapiConstants.SG_DUMMY;
                    break;
                case 2:
                    searchGroup[0] = OkapiConstants.SG_INDEX_NO;
                    break;
                case 3:
                    searchGroup[0] = OkapiConstants.SG_TERM_EX_REG;
                    break;
                case 4:
                    searchGroup[0] = OkapiConstants.SG_STEM_FUNC_NAME;
                    break;
                case 5:
                    searchGroup[0] = OkapiConstants.SG_GSL_FILENAME;
                    break;
                case 6:
                    searchGroup[0] = OkapiConstants.SG_FIELD_LIST;
                    break;
                case 7:
                    searchGroup[0] = OkapiConstants.SG_FIELD_LIST;
                    break;
                case 8:
                    searchGroup[0] = OkapiConstants.SG_FIELD_LIST;
                    break;
                case 9:
                    searchGroup[0] = OkapiConstants.SG_FIELD_LIST;
                    break;
                case 10:
                    searchGroup[0] = OkapiConstants.SG_FIELD_LIST;
                    break;
            }

            searchGroup[1] = searchGroups.get(i);
            searchGroupList[i] = searchGroup;
        }

        searchGroupTable.setModel(new javax.swing.table.DefaultTableModel(
                searchGroupList,
                OkapiConstants.DBSEARCHGROUP_HEADER) {

            boolean[] canEdit = new boolean[]{
                false, true
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        searchGroupTable.setName(OkapiConstants.OKAPISEARCHGROUP_TABLENAME);
        searchGroupTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return searchGroupTable;
    }
}
