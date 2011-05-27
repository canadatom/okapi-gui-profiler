package okapiprofiler.utilities;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import okapiprofiler.Okapi;
import okapiprofiler.OkapiProfilerView;

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
                String dbSG = okapiUtils.getDbSearchConfig(okapi.getDatabase(), dbName).getName();
                if (!dbSG.isEmpty()) {
                    dbNames[2] = dbSG;
                } else {
                    dbNames[2] = "missing";
                }

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
        dbListTable.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                OkapiProfilerView.jButton7.setEnabled(true);
            }
        });


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
        ArrayList<String[]> searchGroups = okapiUtils.getSearchGroup(searchGroupFile);

        // number of lines * strings in each line
        int sizeOfList = searchGroups.get(0).length * searchGroups.size();

        ArrayList<String[]> data = new ArrayList<String[]>();

        for (int j = 0; j < searchGroups.size(); j++) {
            String[] eachSeachGroup = searchGroups.get(j);

            for (int i = 0; i < eachSeachGroup.length; i++) {
                String[] searchGroup = new String[2];
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
                    default:
                        searchGroup[0] = OkapiConstants.SG_FIELD_LIST;
                        break;
                }

                searchGroup[1] = eachSeachGroup[i];
                //System.out.println(searchGroup[0] + " " + searchGroup[1]);
                data.add(searchGroup);
            }

        }
        // convert ArrayList into array
        String[][] searchGroupList = new String[data.size()][2];
        for (int i = 0; i < data.size(); i++) {
            searchGroupList[i] = data.get(i);
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

    public JTable getAddDbTable() {
        JTable addDbTable = new JTable();
        addDbTable.setName(OkapiConstants.OKAPIADDDBTABLE_TABLENAME);

        String[][] addDbTableData = {
            {OkapiConstants.ADDDBTABLE_DBNAME, ""},
            {OkapiConstants.ADDDBTABLE_NUMOFFILES, ""},
            {OkapiConstants.SAMPLEDB_BIB_SIZE, ""}
        };

        addDbTable.setModel(new DefaultTableModel(addDbTableData, OkapiConstants.OKAPIADDDBTABLE_HEADER) {

            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, true
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

        return addDbTable;
    }
}
