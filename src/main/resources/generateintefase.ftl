

public interface ${index.name} {

<#assign colours = ["red", "green"]>

<#assign value = colours?size-1>

<#list colours as col>
<#if value == 2>
    22222
</#if>
</#list>

<#list colours as col>
   public get${col} {
    }
</#list>

<#list 1..10 as x>
    ${x}
    <#if x == 8>
        <#break>
    </#if>
</#list>

<#list index.metaDataFieldList as field>
    private ${field.type} ${field.name};
</#list>


<#--<#assign value = index.metaDataFieldList?length>-->
<#--<#list index.metaDataFieldList as field>-->
<#--    ${field}-->
<#--    <#if value == 2>-->
<#--        22222-->
<#--    </#if>-->
<#--</#list>-->




<#--<#assign value = 4>-->
<#--<#if value < 0>-->
<#--    The number is negative-->
<#--<#elseif value == 0>-->
<#--    The number is zero-->
<#--<#else>-->
<#--    The number is positive-->
<#--</#if>-->

<#assign x = index.getMetaDataFieldList()?size>
<#list colours as col>
    <#if x == 2>
        x is 2
    <#else>
        x is not 1
    </#if>
</#list>


<#--<#list index.metaDataFieldList as field>-->
<#--    ${field[0].name}-->
<#--</#list>-->

}
<#assign x = index.getMetaDataFieldList()?size>
${x}
<#list index.metaDataFieldList as field>
<#if x == 1>
    равно 1  и точка
<#else>
    Pythons are not cheaper than elephants today.
</#if>
</#list>
<#--    ${index.name}: ${field.metaDataFieldList}-->