/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package okapiprofiler;

import java.io.File;
import javax.swing.JTable;

/**
 *
 * @author QiangWu
 */
public class Okapi {

    File okapiRoot;
    File enviset;
    JTable debugDataTable;

    public Okapi() {
        this.okapiRoot = null;
        this.enviset = null;
        this.debugDataTable = new JTable() {
        };
    }

    public File getOkapiRoot() {
        return this.okapiRoot;
    }

    public void setOkapiRoot(File okapiRoot) {
        this.okapiRoot = okapiRoot;
    }

    public JTable getDebugDataTable() {
        return this.debugDataTable;
    }

    public void setDebugDataTable(JTable debugDataTable) {
        this.debugDataTable = debugDataTable;
    }
}
