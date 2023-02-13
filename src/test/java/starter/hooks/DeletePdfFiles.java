package starter.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.File;

public class DeletePdfFiles {

    private static final String DOWNLOADED_PDF_FILES_PATH = "C:\\Users\\ccxcc\\Downloads";
    private static final String STATEMENT_FILE_NAME = "file-sample";

    @Before("@pdf")
    @After("@pdf")
    public static void statementsDownloaded(){
        File downloadsDirectory = new File(DOWNLOADED_PDF_FILES_PATH);
        for (File file : downloadsDirectory.listFiles()){
            if (isAStatement(file.getName())){
                file.delete();
            }
        }
    }

    private static boolean isAStatement(String fileName){
        if (fileName.contains(STATEMENT_FILE_NAME)){
            return true;
        }
        return false;
    }
}
