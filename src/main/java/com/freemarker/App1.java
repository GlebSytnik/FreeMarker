package com.freemarker;

import com.freemarker.generatemy.JavaDataInterfaseGenerator;
import com.freemarker.model.Index;
import com.freemarker.model.MetaDataField;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App1 {

    public static void main(String[] args) throws Exception {


        MetaDataField metaDataField1 = new MetaDataField("email","String");
        MetaDataField metaDataField2 = new MetaDataField("year","Integer");
        List<MetaDataField> metaDataFieldList = new ArrayList<>();
        metaDataFieldList.add(metaDataField1);
        metaDataFieldList.add(metaDataField2);
        String nameIndex = "NameMyIndex";
        Index index = new Index(nameIndex,metaDataFieldList);
        File outputDirectory = new File("/home/gleb/IdeaProjects/FreeMarker/src/main/java/com/freemarker/result");

        JavaDataInterfaseGenerator javaDataInterfaseGenerator = new JavaDataInterfaseGenerator();
        javaDataInterfaseGenerator.generateJavaInterfaseFiles(index,outputDirectory);

    }
}
