/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package okapiprofiler.utilities;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import okapiprofiler.Okapi;

/**
 *
 * @author QiangWu
 */
public class OkapiTables {

    public JTable getDebugTable(Okapi okapi) {
        JTable debugTable = new JTable();
        debugTable.setName("debugTable");

        String[][] debugData = {
            {OkapiConstants.ROOTPATH, okapi.getOkapiRoot().getAbsolutePath()},
            {OkapiConstants.ENVISET, ""}
        };

        debugTable.setModel(new DefaultTableModel(debugData, OkapiConstants.DEBUGTABLEHEADER) {

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

        okapi.setDebugDataTable(debugTable);
        return debugTable;
    }
}
