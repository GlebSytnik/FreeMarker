package com.freemarker.model;

import java.util.List;

public class MetaDataInfoIndex {

    private String name;
    private List<Index> indexList;

    public MetaDataInfoIndex(String name, List<Index> indexList) {
        this.name = name;
        this.indexList = indexList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Index> getIndexList() {
        return indexList;
    }

    public void setIndexList(List<Index> indexList) {
        this.indexList = indexList;
    }
}
