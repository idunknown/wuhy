<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${package_name}.domain.${table_name}Mapper">
    <resultMap id="${table_name}EntityResultMap" type="${package_name}.dto.${table_name}Entity"></resultMap>
    <parameterMap id="${table_name}EntityParameterMap" type="${package_name}.dto.${table_name}Entity"></parameterMap>
    <sql id="findEntitySql">
        select * from  ${table_name_small} temp
    </sql>

    <select id="find${table_name}ById" parameterType="String" resultMap="${table_name}EntityResultMap">
        <include refid="findEntitySql"></include>
        <where>
            and t.id = #${"{"}id,jdbcType=int}
        </where>
    </select>
    <insert id="create${table_name!}" parameterMap="${table_name}EntityParameterMap">
        insert into ${table_name_small!}(
       <#list model_column as model>
           ${model.columnName} <#if model_column?size-1!=model_index>,</#if>
       </#list>
        ) values(
       <#list model_column as model>
           #${"{"}${model.columnName},jdbcType=${model.columnType}} <#if model_column?size-1!=model_index>,</#if>
       </#list>
        )
    </insert>
    <delete id="delete${table_name!}"  parameterType="String" >
        delete from ${table_name_small}
        <where>
            and t.id = #${"{"}id,jdbcType=int}
        </where>
    </delete>
    <update id="update${table_name!}" parameterMap="${table_name}EntityParameterMap">
        update   ${table_name_small!}  set
       <#list model_column as model>
           ${model.columnName} =#${"{"}${model.columnName},jdbcType=${model.columnType}} <#if model_column?size-1!=model_index>,</#if>
       </#list>

    </update>
</mapper>