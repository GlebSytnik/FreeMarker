package com.freemarker;

import com.freemarker.generatemy.JavaDataInterfaseGeneratorWithTable;
import com.freemarker.model.Index;
import com.freemarker.model.MetaDataField;
import com.freemarker.model.MetaDataInfoTable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppForMetaDataInfoIndex {

    public static void main(String[] args) throws Exception {

        MetaDataField metaDataField1 = new MetaDataField("email","String");
        MetaDataField metaDataField2 = new MetaDataField("year","Integer");
        List<MetaDataField> metaDataFieldList = new ArrayList<>();
        metaDataFieldList.add(metaDataField1);
        metaDataFieldList.add(metaDataField2);
        String nameIndex = "NameMyIndex";
        String nameMyIndex2 = "NameMyIndex2";
        Index index = new Index(nameIndex,metaDataFieldList);
        Index index1 = new Index(nameMyIndex2,metaDataFieldList);
        List<Index> indexList = new ArrayList<>();
        indexList.add(index);
        indexList.add(index1);
        File outputDirectory = new File("/home/gleb/IdeaProjects/FreeMarker/src/main/java/com/freemarker/result");
        String nameTable = "MyTable";
        MetaDataInfoTable metaDataInfoIndex = new MetaDataInfoTable(nameTable,indexList);

        JavaDataInterfaseGeneratorWithTable javaDataInterfaseGeneratorWithTable = new JavaDataInterfaseGeneratorWithTable();
      //  javaDataInterfaseGeneratorWithTable.generateJavaInterfaseFilesWithTable(metaDataInfoIndex,outputDirectory);

    }
}
