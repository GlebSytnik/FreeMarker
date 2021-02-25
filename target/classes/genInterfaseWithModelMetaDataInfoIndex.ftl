package com.freemarker.result;

import java.util.Optional;

public interface ${metaDataInfoIndex.name} extends GenericOperations {

<#--<#assign x = metaDataInfoIndex.getIndexList()?size>-->
<#--<#if x == 1>-->
<#list metaDataInfoIndex.indexList as indexListCurrent>
<#--        <#list indexList.metaDataFieldList as fieldList>-->
    <#assign y = indexListCurrent.getMetaDataFieldList()?size>
<#--            ${y}-->
    <#if y == 1>
     Optional<${metaDataInfoIndex.name}>  find${indexListCurrent.name?cap_first} (${indexListCurrent.metaDataFieldList[0].type} ${indexListCurrent.metaDataFieldList[0].name});
        <#elseif y == 2>
     Optional<${metaDataInfoIndex.name}>  find${indexListCurrent.name?cap_first} (${indexListCurrent.metaDataFieldList[0].type} ${indexListCurrent.metaDataFieldList[0].name},${indexListCurrent.metaDataFieldList[1].type} ${indexListCurrent.metaDataFieldList[1].name});
        <#elseif y==3>
     Optional<${metaDataInfoIndex.name}>  find${indexListCurrent.name?cap_first} (${indexListCurrent.metaDataFieldList[0].type} ${indexListCurrent.metaDataFieldList[0].name},${indexListCurrent.metaDataFieldList[1].type} ${indexListCurrent.metaDataFieldList[1].name},${indexListCurrent.metaDataFieldList[2].type} ${indexListCurrent.metaDataFieldList[2].name});
        </#if>
<#--        </#list>-->
    </#list>
<#--<#else>-->
<#--     x is not 1-->
<#--</#if>-->
}



