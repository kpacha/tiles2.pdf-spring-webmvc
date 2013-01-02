package org.springframework.web.servlet.view.tiles2;

import java.util.Locale;

import org.springframework.beans.BeanUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.pdf.IPdfRenderer;
import org.springframework.web.servlet.view.pdf.PdfRenderer;

public class TilesPDFViewResolver extends UrlBasedViewResolver {

    public TilesPDFViewResolver() {
	setViewClass(requiredViewClass());
    }

    /**
     * Requires {@link TilesView}.
     */
    @Override
    protected Class requiredViewClass() {
	return TilesPDFView.class;
    }

    protected IPdfRenderer createRenderer() {
	return BeanUtils.instantiate(PdfRenderer.class);
    }

    @Override
    protected View loadView(String viewName, Locale locale) throws Exception {
	TilesPDFView view = (TilesPDFView) super.loadView(viewName, locale);
	if (view != null) {
	    view.setRenderer(createRenderer());
	}
	return view;
    }
}
