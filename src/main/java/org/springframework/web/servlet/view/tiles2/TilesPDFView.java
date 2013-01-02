package org.springframework.web.servlet.view.tiles2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.view.pdf.IPdfRenderer;

public class TilesPDFView extends TilesView {

    private IPdfRenderer renderer;

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
	renderer.encode(response.getOutputStream(),
		mockedResponse.getContentAsString());
    }

    /**
     * @param renderer
     *            the renderer to set
     */
    public void setRenderer(IPdfRenderer renderer) {
	this.renderer = renderer;
    }
}
