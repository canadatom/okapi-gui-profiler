/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package okapiprofiler;

import java.io.File;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author QiangWu
 */
public class Okapi {

    File okapiRoot;
    DefaultTableModel debugDataTable;

    public Okapi() {
        this.okapiRoot = null;
        debugDataTable = new DefaultTableModel() {
        };
    }

    public File getOkapiRoot() {
        return this.okapiRoot;
    }

    public void setOkapiRoot(File okapiRoot) {
        this.okapiRoot = okapiRoot;
    }

    public DefaultTableModel getDebugDataTable() {
        return this.debugDataTable;
    }

    public void setDebugDataTable(DefaultTableModel debugDataTable) {
        this.debugDataTable = debugDataTable;
    }
}
