package com.xz.codegenerator.entity;

/**
 * @author wuhy on 2018/5/14.
 */
public class SqlEntity {
    private String templatesPath;
    private String enableCountByExample;
    private String enableUpdateByExample;
    private String enableDeleteByExample;
    private String enableSelectByExample;
    private String electByExampleQueryId;
    private String template;
    private String sqlPath;

    public String getEnableCountByExample() {
        return enableCountByExample;
    }

    public void setEnableCountByExample(String enableCountByExample) {
        this.enableCountByExample = enableCountByExample;
    }

    public String getEnableUpdateByExample() {
        return enableUpdateByExample;
    }

    public void setEnableUpdateByExample(String enableUpdateByExample) {
        this.enableUpdateByExample = enableUpdateByExample;
    }

    public String getEnableDeleteByExample() {
        return enableDeleteByExample;
    }

    public void setEnableDeleteByExample(String enableDeleteByExample) {
        this.enableDeleteByExample = enableDeleteByExample;
    }

    public String getEnableSelectByExample() {
        return enableSelectByExample;
    }

    public void setEnableSelectByExample(String enableSelectByExample) {
        this.enableSelectByExample = enableSelectByExample;
    }

    public String getElectByExampleQueryId() {
        return electByExampleQueryId;
    }

    public void setElectByExampleQueryId(String electByExampleQueryId) {
        this.electByExampleQueryId = electByExampleQueryId;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getSqlPath() {
        return sqlPath;
    }

    public void setSqlPath(String sqlPath) {
        this.sqlPath = sqlPath;
    }

    public String getTemplatesPath() {
        return templatesPath;
    }

    public void setTemplatesPath(String templatesPath) {
        this.templatesPath = templatesPath;
    }
}
