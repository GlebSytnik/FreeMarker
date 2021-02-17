
package com.freemarker;
import lombok.*;


@Data
public class ${metaDataInfo.name}{
<#list metaDataInfo.metaDataFieldList as field>
	private ${field.type} ${field.name};
</#list>

	public ${metaDataInfo.name}(){
	}
	
<#list metaDataInfo.metaDataFieldList as field>
<#--	public ${field.type} get${field.name?cap_first}(){-->
<#--		return ${field.name};-->
<#--	}-->
<#--	public void set${field.name?cap_first}(${field.type} ${field.name}){-->
<#--		this.${field.name} = ${field.name};-->
<#--	}-->
</#list>	
}