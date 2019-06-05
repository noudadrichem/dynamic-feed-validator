package services;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ReadXMLFileTest {

    @Test
    public void testParser() {
        ReadXMLFile reader = new ReadXMLFile("https://www.wirliebenhunter.de/backend/export/index/export.txt?feedID=1&hash=4ebfa063359a73c356913df45b3fbe7f");
        Document doc = reader.StreamXMLFile();

        Element root = doc.getDocumentElement();
        System.out.println(root.getTagName());
    }
}
