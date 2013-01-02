package org.springframework.web.servlet.view.pdf;

import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletOutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;

public class PdfRenderer implements IPdfRenderer {

    @Override
    public void encode(ServletOutputStream outputStream, String contentAsString)
	    throws SAXException, IOException, ParserConfigurationException,
	    DocumentException {
	try {
	    // parse the markup into an xml Document
	    final Document doc = DocumentBuilderFactory.newInstance()
		    .newDocumentBuilder()
		    .parse(new InputSource(new StringReader(contentAsString)));

	    final ITextRenderer renderer = new ITextRenderer();
	    renderer.setDocument(doc, null);
	    renderer.layout();
	    renderer.createPDF(outputStream);
	} finally {
	    outputStream.flush();
	}
    }

}
