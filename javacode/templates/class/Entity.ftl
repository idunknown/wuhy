package ${package_name}.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
* 描述：${table_annotation}模型
* @author ${author}
* @date ${date}
*/

public class ${table_name}Entity {

        private Map map = new HashMap();
<#if model_column?exists>
    <#list model_column as model>
        /**${model.columnComment!}**/
        <#if (model.columnType?lower_case = 'varchar' || model.columnType?lower_case = 'text'||model.columnType?lower_case = 'char')>
        private String ${model.changeColumnName?uncap_first};
        </#if>
        <#if model.columnType?lower_case = 'timestamp' >
        private Date ${model.changeColumnName?uncap_first};
      </#if>
        <#if model.columnType?lower_case = 'int' >
        private int ${model.changeColumnName?uncap_first};
        </#if>
    </#list>
</#if>

<#if model_column?exists>
    <#list model_column as model>
        <#if (model.columnType?lower_case = 'varchar' || model.columnType?lower_case = 'text'||model.columnType?lower_case = 'char')>
        public String get${model.changeColumnName}() {
            return this.${model.changeColumnName?uncap_first};
        }
        public void set${model.changeColumnName}(String ${model.changeColumnName?uncap_first}) {
           this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
        }
        </#if>
        <#if model.columnType?lower_case = 'timestamp'||model.columnType?lower_case = 'date' >
        public Date get${model.changeColumnName}() {
            return this.${model.changeColumnName?uncap_first};
        }
        public void set${model.changeColumnName}(Date ${model.changeColumnName?uncap_first}) {
           this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
        }

        </#if>
        <#if model.columnType?lower_case = 'int' >
        public int get${model.changeColumnName}() {
            return this.${model.changeColumnName?uncap_first};
        }
        public void set${model.changeColumnName}(int ${model.changeColumnName?uncap_first}) {
           this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
        }
        </#if>
    </#list>
</#if>

<#if model_column?exists>
        public Map toMap(){

    <#list model_column as model>
            this.map.put("${model.changeColumnName?uncap_first}",this.${model.changeColumnName?uncap_first});
    </#list>
            return this.map;
       }
</#if>
<#if model_column?exists>
        public ${table_name}Entity(Map map){
    <#list model_column as model>
        <#if (model.columnType?lower_case = 'varchar' || model.columnType?lower_case = 'text'||model.columnType?lower_case = 'char')>
            this.${model.changeColumnName?uncap_first} = (String)map.get("${model.changeColumnName?uncap_first}");
        </#if>
        <#if model.columnType?lower_case = 'timestamp' >
            this.${model.changeColumnName?uncap_first} = (Date)map.get("${model.changeColumnName?uncap_first}");
        </#if>
        <#if model.columnType?lower_case = 'int' >
             this.${model.changeColumnName?uncap_first} = (int)map.get("${model.changeColumnName?uncap_first}");
        </#if>
    </#list>
       }
</#if>
}