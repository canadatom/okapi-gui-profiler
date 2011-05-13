/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package okapiprofiler.utilities;

import java.io.File;

/**
 *
 * @author QiangWu
 */
public class OkapiUtils {

    public File getEnviSet(File okapiRoot) {
        File[] files = okapiRoot.listFiles();
        File enviset = null;
        if (files.length != 0) {
            for (File file : files) {
                if (file.getName().equals(OkapiConstants.ENVISET)) {
                    enviset = file;
                    break;
                }
            }
        }
        return enviset;
    }
}
