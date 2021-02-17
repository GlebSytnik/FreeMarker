package com.freemarker.model;

import java.util.Collections;
import java.util.List;

public class MetaDataInfo {
    private String name;
    private List<MetaDataField> metaDataFieldList;

    public MetaDataInfo(String nameTable, List<MetaDataField> metaDataFieldList) {
        this.name = nameTable;
        this.metaDataFieldList = metaDataFieldList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MetaDataField> getMetaDataFieldList() {
        return Collections.unmodifiableList(metaDataFieldList);
    }

    public void setMetaDataFieldList(List<MetaDataField> metaDataFieldList) {
        this.metaDataFieldList = metaDataFieldList;
    }
}
