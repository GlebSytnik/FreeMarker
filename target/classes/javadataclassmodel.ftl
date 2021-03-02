package com.freemarker.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ${metaDataInfo.name} {
<#list metaDataInfo.metaDataFieldList as field>
	private ${field.type} ${field.name};
</#list>


}


