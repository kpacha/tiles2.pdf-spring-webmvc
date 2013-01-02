package org.springframework.web.servlet.view.pdf;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

public interface IPdfRenderer {

    void encode(ServletOutputStream outputStream, String contentAsString)
	    throws SAXException, IOException, ParserConfigurationException,
	    DocumentException;
}
