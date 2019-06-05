package services;

import org.junit.Test;

public class ReadXMLFileTest {

    @Test
    public void testParser() {
        ReadXMLFile reader = new ReadXMLFile("http://www.java2s.com/Tutorials/Java/XML_HTML_How_to/DOM/Read_XML_Document_from_URL.htm");
        reader.StreamXMLFile();
    }
}
