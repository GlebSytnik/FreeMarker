package com.freemarker.generate;

import com.freemarker.model.MetaDataInfoIndex;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class JavaDataInterfaseGeneratorWithTable {

    private Configuration configuration;

    public JavaDataInterfaseGeneratorWithTable() throws IOException {
        configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);
    }
    public void generateJavaInterfaseFilesWithTable(MetaDataInfoIndex metaDataInfoIndex, File fileDirectory) throws Exception {
        Map<String, Object> freemarkerDataModel = new HashMap<>();
        Template template = configuration.getTemplate("genInterfaseWithModelMetaDataInfoIndex.ftl");

        freemarkerDataModel.put("metaDataInfoIndex", metaDataInfoIndex);
        File javaSourceFile = new File(fileDirectory, metaDataInfoIndex.getName() + ".java");
        Writer javaSourceFileWriter = new FileWriter(javaSourceFile);
        template.process(freemarkerDataModel, javaSourceFileWriter);

    }
}
