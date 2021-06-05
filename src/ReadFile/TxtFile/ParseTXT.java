package ReadFile.TxtFile;


import Data.RecordFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ParseTXT {
    List<RecordTXT> RecordTXTS = new ArrayList<>();
    List<RecordFile> sortList = new ArrayList<>();
    List<String> category = new ArrayList<>();
    File file;


    public ParseTXT(File file) {
        this.file = file;
    }

    public List<RecordFile> getSortList() throws FileNotFoundException {


        BufferedReader okunan = new BufferedReader(new FileReader(file));
        List<Integer> groups = new ArrayList<>();
        List<Integer> address = new ArrayList<>();
        List<Integer> sortValues = new ArrayList<>();
        Scanner scanner = new Scanner(okunan);
        String[] line;
        String str;
        int grup = 0, y = 0, t = 0;

        while (scanner.hasNext()) {
            str = scanner.nextLine();
            if (str.matches("[\\d]{2,3}")) {
                grup++;
                groups.add(Integer.valueOf(str));
            } else if (str.matches("[\\d]{4}.*,.*")) {
                line = str.split(",");
                RecordTXT bilgi = new RecordTXT(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4]);
                RecordTXTS.add(bilgi);
                if (!category.contains(line[4])) {
                    category.add(line[4]);
                }
            }
        }
        for (int i = 0; i < grup; i++) {
            t = groups.get(i);
            sortValues.clear();
            address.clear();

            for (int j = y; j < (groups.get(i) + y); j++) {
                sortValues.add(RecordTXTS.get(j).getValue());
            }

            Collections.sort(sortValues);
            Collections.reverse(sortValues);

            for (int k = 0; k < 10; k++) {
                for (int l = y; l < (groups.get(i) + y); l++) {
                    if ((sortValues.get(k).equals(RecordTXTS.get(l).getValue())) && !address.contains(l)) {
                        address.add(l);
                    }
                }

            }
            for (int m = 0; m < 10; m++) {
                RecordFile sortTXT = new RecordFile(RecordTXTS.get(address.get(m)).getYear()
                        , RecordTXTS.get(address.get(m)).getName()
                        , RecordTXTS.get(address.get(m)).getCountry()
                        , RecordTXTS.get(address.get(m)).getValue(), RecordTXTS.get(address.get(m)).getCategory());
                sortList.add(sortTXT);
            }
            y = y + t;

        }

        return sortList;
    }

    public List<String> getCategory() {
        return category;
    }
}

