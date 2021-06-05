package ReadFile.XmlFile;


import Data.RecordFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ParseXML {

    List<RecordXML> countryList;
    List<RecordFile> sortList = new ArrayList<>();
    List<String> category = new ArrayList<>();
    File file;

    public ParseXML(File file) {
        this.file = file;
    }


    public List<String> getCategory() {
        return category;
    }

    public List<RecordFile> getSortList() {
        Map<Integer, List<RecordXML>> yearCountryRecordList = new HashMap<>();
        List<Integer> sortValue = new ArrayList<>();
        List<Integer> address = new ArrayList<>();

        int y = 0;

        for (RecordXML c : getCountryList()) {
            if (yearCountryRecordList.containsKey(c.getYear())) {
                yearCountryRecordList.get(c.getYear()).add(c);
            } else {
                List<RecordXML> recordXMLList = new ArrayList<>();
                recordXMLList.add(c);
                yearCountryRecordList.put(c.getYear(), recordXMLList);
            }
        }

        for (Map.Entry<Integer, List<RecordXML>> entry : yearCountryRecordList.entrySet()) {
            sortValue.clear();
            address.clear();

            for (int j = 0; j < entry.getValue().size(); j++) {
                sortValue.add(entry.getValue().get(j).getValue());
            }
            Collections.sort(sortValue);
            Collections.reverse(sortValue);
            for (int i = 0; i < 10; i++) {
                for (int l = 0; l < entry.getValue().size(); l++) {
                    if (sortValue.get(i).equals(entry.getValue().get(l).getValue())) {
                        address.add(l);
                    }
                }

            }
            for (int m = 0; m < 10; m++) {
                RecordFile sortTXT = new RecordFile(String.valueOf(entry.getValue().get(address.get(m)).getYear())
                        , entry.getValue().get(address.get(m)).getName()
                        , entry.getValue().get(address.get(m)).getCountry()
                        , entry.getValue().get(address.get(m)).getValue(), entry.getValue().get(address.get(m)).getCategory());
                sortList.add(sortTXT);
            }

        }
        return sortList;
    }

    public List<RecordXML> getCountryList() {
        countryList = new ArrayList<RecordXML>();

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        /*
            URL url=new URL("");
            Document docUrl=builder.parse(url.openStream());

         */

            Document doc = builder.parse(file);

            NodeList nodeList = doc.getElementsByTagName("record");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                RecordXML recordXML = new RecordXML();

                recordXML.setName(String.valueOf(element.getElementsByTagName("field").item(0).getTextContent()));
                recordXML.setCountry(String.valueOf(element.getElementsByTagName("field").item(1).getTextContent()));
                recordXML.setYear(Integer.parseInt(element.getElementsByTagName("field").item(2).getTextContent()));
                recordXML.setValue(Integer.parseInt(element.getElementsByTagName("field").item(3).getTextContent()));
                recordXML.setCategory(String.valueOf(element.getElementsByTagName("field").item(4).getTextContent()));


                Node key = element.getElementsByTagName("field").item(0).getAttributes().getNamedItem("key");
                recordXML.setKey(key.getTextContent());

                if (!category.contains(recordXML.getCategory())) {
                    category.add(recordXML.getCategory());
                }
                countryList.add(recordXML);

            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return countryList;
    }

    public void setCountryList(List<RecordXML> countryList) {
        this.countryList = countryList;
    }


}
