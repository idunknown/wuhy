package com.xz.codegenerator.entity;

/**
 * @author wuhy on 2018/5/14.
 */
public class TableEntity {
    private String name;
    private String packageName;
    private String tableAnnotation;

    public String getTableAnnotation() {
        return tableAnnotation;
    }

    public void setTableAnnotation(String tableAnnotation) {
        this.tableAnnotation = tableAnnotation;
    }

    private ClassEntity classEntity;
    private SqlEntity sqlEntity;
    private JspEntity jspEntity;

    public JspEntity getJspEntity() {
        return jspEntity;
    }

    public void setJspEntity(JspEntity jspEntity) {
        this.jspEntity = jspEntity;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public SqlEntity getSqlEntity() {
        return sqlEntity;
    }

    public void setSqlEntity(SqlEntity sqlEntity) {
        this.sqlEntity = sqlEntity;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
