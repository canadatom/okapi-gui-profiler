/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package okapiprofiler.utilities;

import javax.swing.table.DefaultTableModel;
import okapiprofiler.Okapi;

/**
 *
 * @author QiangWu
 */
public class OkapiUtils {

    public DefaultTableModel getDebugTable() {
        Okapi okapi = new Okapi();

        String[][] debugData = {
            {"test1", "url1"}, {"test2", "url2"}, {"test3", "url3"}
        };


        DefaultTableModel debugTable = new DefaultTableModel(debugData, OkapiConstants.DEBUGTABLEHEADER) {
        };
        okapi.setDebugDataTable(debugTable);

        return okapi.getDebugDataTable();
    }
}
