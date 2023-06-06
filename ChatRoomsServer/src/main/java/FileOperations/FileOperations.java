package FileOperations;

import java.io.*;
import java.util.logging.*;
import javax.swing.JFileChooser;

//File Operations management class
public class FileOperations {

    //this functions creates a jfile chooser to select a 
    //file from system and returns its path.
    public static String chooseFileAndGetPath() { //When you choose a file from jFileChooser
        String filePath = "";
        JFileChooser jf = new JFileChooser();
        jf.setVisible(true);
        jf.showOpenDialog(null);

        try {
            File f = new File(jf.getSelectedFile().getPath()); //in File choose you can not choose directory
            filePath = f.getPath();
        } catch (Exception e) {

        }
        return filePath;
    }
    
    //this functions give the name of the file on given path.
    public static String getFileName(String filePath) {
        File f = new File(filePath);
        return f.getName();
    }
    
    //this functions read the content of a file on given path and returns it.
    public static byte[] getContent(String path) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;

        File f = new File(path);
        byte[] content = new byte[(int) f.length()];
        try {
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            bis.read(content, 0, content.length);
            fis.close();
            bis.close();
        } catch (FileNotFoundException ex) {

            return null;
        } catch (IOException ex) {
            return null;
        }
        return content;
    }

    //return path of the created File
    public static String createFile(String fileName) {
        File f = new File(fileName);
        String pathOfFile = null;
        try {
            f.createNewFile();
            pathOfFile = f.getPath();
        } catch (IOException ex) {
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pathOfFile;
    }
    // this functions writes given content to the file on given path.
    public static boolean writeContent(String filePath, byte[] content) {
        File f = new File(filePath);
        OutputStream output = null;

        try {
            output = new FileOutputStream(f);
            output.write(content);
            output.close();
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
