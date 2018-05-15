package ${package_name}.entity;

import java.util.Date;

/**
* 描述：${table_annotation}模型
* @author ${author}
* @date ${date}
*/

public class ${table_name}Entity {

<#if model_column?exists>
    <#list model_column as model>
    /**
    *${model.columnComment!}
    */
        <#if (model.columnType?lower_case = 'varchar' || model.columnType?lower_case = 'text'||model.columnType?lower_case = 'char')>
    @Column(name = "${model.columnName}",columnDefinition = "VARCHAR")
    private String ${model.changeColumnName?uncap_first};

        </#if>
        <#if model.columnType?lower_case = 'timestamp' >
    @Column(name = "${model.columnName}",columnDefinition = "TIMESTAMP")
    private Date ${model.changeColumnName?uncap_first};

    </#if>
        <#if model.columnType?lower_case = 'int' >
        @Column(name = "${model.columnName}",columnDefinition = "INT")
        private int ${model.changeColumnName?uncap_first};

        </#if>
    </#list>
</#if>

<#if model_column?exists>
    <#list model_column as model>
        <#if (model.columnType?lower_case = 'varchar' || model.columnType?lower_case = 'text')>
    public String get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(String ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }

        </#if>
        <#if model.columnType = 'timestamp' >
    public Date get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Date ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }

        </#if>
    </#list>
</#if>

}