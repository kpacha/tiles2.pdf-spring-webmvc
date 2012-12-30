package org.springframework.web.servlet.view.tiles2;

import java.io.StringReader;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.mock.web.MockHttpServletResponse;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.InputSource;

public class TilesPDFView extends TilesView {

    public TilesPDFView() {
	setContentType("application/pdf");
    }

    @Override
    protected boolean generatesDownloadContent() {
	return true;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
	    HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	MockHttpServletResponse mockedResponse = new MockHttpServletResponse();
	super.renderMergedOutputModel(model, request, mockedResponse);
	encode(response.getOutputStream(), mockedResponse.getContentAsString());
    }

    private boolean encode(ServletOutputStream servletOutputStream,
	    String content) throws Exception {
	try {
	    // parse the markup into an xml Document
	    final Document doc = DocumentBuilderFactory.newInstance()
		    .newDocumentBuilder()
		    .parse(new InputSource(new StringReader(content)));

	    final ITextRenderer renderer = new ITextRenderer();
	    renderer.setDocument(doc, null);
	    renderer.layout();
	    renderer.createPDF(servletOutputStream);
	} finally {
	    servletOutputStream.flush();
	}
	return true;
    }
}
