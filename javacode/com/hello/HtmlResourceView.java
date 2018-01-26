package com.hello;

import org.springframework.web.servlet.view.JstlView;

import java.io.File;
import java.util.Locale;

/**
 * Created by 51707 on 2017/7/24.
 */
public class HtmlResourceView extends JstlView{

    /**
     * Check whether the underlying resource that the configured URL points to
     * actually exists.
     *
     * @param locale the desired Locale that we're looking for
     * @return {@code true} if the resource exists (or is assumed to exist);
     * {@code false} if we know that it does not exist
     * @throws Exception if the resource exists but is invalid (e.g. could not be parsed)
     */
    @Override
    public boolean checkResource(Locale locale) throws Exception {
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        return file.exists();
    }
}
