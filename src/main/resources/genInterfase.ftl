package com.freemarker.result;

public interface ${index.name} {

<#assign x = index.getMetaDataFieldList()?size>
<#--${x}-->
<#list index.metaDataFieldList as field>
<#--    <#if x == 1>-->
       public ${field.type} find${field.name?cap_first} ();

<#--        public get ${field[0].type}  ${field[1].name}{-->

<#--        }-->
<#--    <#else>-->
<#--        x is not 1-->
<#--    </#if>-->
</#list>

}
<#--${index.metaDataFieldList[0].name} рабочий кусок-->
