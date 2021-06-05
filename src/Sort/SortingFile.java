package Sort;

import Data.RecordFile;
import ReadFile.TxtFile.ParseTXT;
import ReadFile.XmlFile.ParseXML;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SortingFile {

    List<RecordFile> sortList = new ArrayList<RecordFile>();
    List<String> category = new ArrayList<>();
    File file;
    ParseXML parseXML;
    ParseTXT parseTXT;

    public SortingFile(File file) {
        this.file = file;
    }

    public SortingFile() {

    }

    public List<String> getCategory() {

        if (file.getAbsolutePath().contains(".txt")) {
            setCategory(parseTXT.getCategory());
            return category;
        } else if (file.getAbsolutePath().contains(".xml")) {
            setCategory(parseXML.getCategory());
            return category;
        } else {
            throw new IllegalArgumentException("File's path is not available");
        }
    }

    public List<RecordFile> getSortList() throws FileNotFoundException {
        if (file.getAbsolutePath().contains(".txt")) {
            parseTXT = new ParseTXT(file);
            setSortList(parseTXT.getSortList());
            return sortList;
        } else if (file.getAbsolutePath().contains(".xml")) {
            parseXML = new ParseXML(file);
            setSortList(parseXML.getSortList());
            return sortList;
        } else {
            throw new IllegalArgumentException("File's path is not available");
        }
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public void setSortList(List<RecordFile> sortList) {
        this.sortList = sortList;
    }
}
