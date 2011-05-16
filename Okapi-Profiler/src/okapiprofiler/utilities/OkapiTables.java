/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package okapiprofiler.utilities;

import java.util.ArrayList;
import javax.swing.JTable;
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

        okapi.setOkapiFilesTable(okapiFilesTable);
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

        okapi.setOkapiDbListTable(dbListTable);
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

        return envirSetTable;
    }
}
