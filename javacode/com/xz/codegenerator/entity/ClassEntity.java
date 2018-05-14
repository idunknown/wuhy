package com.xz.codegenerator.entity;

/**
 * @author wuhy on 2018/5/14.
 */
public class ClassEntity {
    private String includeClass;
    private String noIncludeClass;
    private String templatesPath;

    public String getIncludeClass() {
        return includeClass;
    }

    public void setIncludeClass(String includeClass) {
        this.includeClass = includeClass;
    }

    public String getNoIncludeClass() {
        return noIncludeClass;
    }

    public void setNoIncludeClass(String noIncludeClass) {
        this.noIncludeClass = noIncludeClass;
    }

    public String getTemplatesPath() {
        return templatesPath;
    }

    public void setTemplatesPath(String templatesPath) {
        this.templatesPath = templatesPath;
    }
}
