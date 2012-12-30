package org.springframework.web.servlet.view.tiles2;

import org.springframework.web.servlet.view.UrlBasedViewResolver;

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

}
