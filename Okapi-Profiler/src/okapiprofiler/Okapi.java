package okapiprofiler;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author QiangWu
 */
public class Okapi {

    File okapiRoot;
    File database;
    File bibfiles;
    File enviset;
    File dbavail;
    File stopword;
    ArrayList<String> dbList;
    JTable okapiFilesTable;
    JTable okapiDbListTable;
    JTable okapiEnvirSettingTable;
    JTable okapiDbConfigTable;
    JTable okapiSearchGroupTable;
    JTable okapiAddDbTable;

    public Okapi() {
        this.okapiRoot = null;
        this.database = null;
        this.bibfiles = null;
        this.enviset = null;
        this.dbavail = null;
        this.stopword = null;
        this.dbList = null;
        this.okapiFilesTable = null;
        this.okapiEnvirSettingTable = null;
        this.okapiDbListTable = null;
        this.okapiDbConfigTable = null;
        this.okapiSearchGroupTable = null;
        this.okapiAddDbTable = null;
    }

    public File getOkapiRoot() {
        return this.okapiRoot;
    }

    public void setOkapiRoot(File okapiRoot) {
        this.okapiRoot = okapiRoot;
    }

    public File getDatabase() {
        return this.database;
    }

    public void setDatabase(File database) {
        this.database = database;
    }

    public File getBibfiles() {
        return this.bibfiles;
    }

    public void setBibfiles(File bibfiles) {
        this.bibfiles = bibfiles;
    }

    public JTable getOkapiFilesTable() {
        return this.okapiFilesTable;
    }

    public void setOkapiFilesTable(JTable okapiFilesTable) {
        this.okapiFilesTable = okapiFilesTable;
    }

    public JTable getOkapiDbListTable() {
        return this.okapiDbListTable;
    }

    public void setOkapiDbListTable(JTable okapiDbListTable) {
        this.okapiDbListTable = okapiDbListTable;
    }

    public JTable getOkapiEnvirSettingTable() {
        return this.okapiEnvirSettingTable;
    }

    public void setOkapiEnvirSettingTable(JTable okapiEnvirSettingTable) {
        this.okapiEnvirSettingTable = okapiEnvirSettingTable;
    }

    public JTable getOkapiDbConfigTable() {
        return this.okapiDbConfigTable;
    }

    public void setOkapiDbConfigTable(JTable okapiDbConfigTable) {
        this.okapiDbConfigTable = okapiDbConfigTable;
    }

    public JTable getOkapiSearchGroupTable() {
        return this.okapiSearchGroupTable;
    }

    public void setOkapiSearchGroupTable(JTable okapiSearchGroupTable) {
        this.okapiSearchGroupTable = okapiSearchGroupTable;
    }

    public JTable getOkapiAddDbTable() {
        return this.okapiAddDbTable;
    }

    public void setOkapiAddDbTable(JTable okapiAddDbTable) {
        this.okapiAddDbTable = okapiAddDbTable;
    }

    public File getEnviset() {
        return this.enviset;
    }

    public void setEnviset(File enviset) {
        this.enviset = enviset;
    }

    public File getDbavail() {
        return this.dbavail;
    }

    public void setDbavail(File dbavail) {
        this.dbavail = dbavail;
    }

    public File getStopword() {
        return this.stopword;
    }

    public void setStopword(File stopword) {
        this.stopword = stopword;
    }

    public ArrayList<String> getDbList() {
        return this.dbList;
    }

    public void setDbList(ArrayList<String> dbList) {
        this.dbList = dbList;
    }
}
