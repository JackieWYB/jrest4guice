package org.jrest.rest.writer;

import org.jrest.rest.annotation.MimeType;
import org.jrest.rest.context.HttpResult;

public class HtmlResponseWriter extends TextResponseWriter {
	@Override
	protected String generateTextContent(Object result) {
		return HttpResult.createHttpResult(result).toTextPlain();
	}

	@Override
	public String getMimeType() {
		return MimeType.MIME_OF_TEXT_HTML;
	}
}