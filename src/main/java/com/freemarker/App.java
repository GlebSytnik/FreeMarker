package com.freemarker;

import com.freemarker.generate.JavaDataClassGenerator;
import com.freemarker.model.MetaDataField;
import com.freemarker.model.MetaDataInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        MetaDataField metaDataField = new MetaDataField("id","Integer");
        MetaDataField metaDataField1 = new MetaDataField("name","String");
        List<MetaDataField> metaDataFieldList = new ArrayList<>();
        metaDataFieldList.add(metaDataField);
        metaDataFieldList.add(metaDataField1);

        MetaDataField metaDataField2 = new MetaDataField("firstName", "String");
        MetaDataField metaDataField3 = new MetaDataField("role","String");
        List<MetaDataField> metaDataFieldList1 = new ArrayList<>();
        metaDataFieldList1.add(metaDataField2);
        metaDataFieldList1.add(metaDataField3);


        MetaDataInfo metaDataInfo = new MetaDataInfo(new String("MetaDataInfo"),metaDataFieldList);
        MetaDataInfo metaDataInfo1 = new MetaDataInfo(new String("MetaDataField"),metaDataFieldList1);
        List<MetaDataInfo> metaDataInfoList = new ArrayList<>();
        metaDataInfoList.add(metaDataInfo);
        metaDataInfoList.add(metaDataInfo1);

        File outputDirectory = new File("/home/gleb/IdeaProjects/FreeMarker/src/main/java/com/freemarker");

        JavaDataClassGenerator javaDataClassGenerator = new JavaDataClassGenerator();
        javaDataClassGenerator.generateJavaSourceFiles(metaDataInfoList,outputDirectory);

    }
}
