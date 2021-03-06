package com.freemarker.generatemy;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import schemacrawler.schema.Catalog;
import schemacrawler.schema.Table;
import schemacrawler.schemacrawler.*;
import schemacrawler.tools.utility.SchemaCrawlerUtility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateInterfaseFinal {

    private Configuration configuration;

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/djooky_db";
    private static final String DB_USERNAME = "djooky";
    private static final String DB_PASSWORD = "djooky";

    public Catalog getCatalog() throws SchemaCrawlerException {
        final LoadOptionsBuilder loadOptionsBuilder =
                LoadOptionsBuilder.builder()
                        // Set what details are required in the schema - this affects the
                        // time taken to crawl the schema
                        .withSchemaInfoLevel(SchemaInfoLevelBuilder.standard());

        final SchemaCrawlerOptions options =
                SchemaCrawlerOptionsBuilder.newSchemaCrawlerOptions()
                        .withLoadOptions(loadOptionsBuilder.toOptions());

        final Catalog catalog = SchemaCrawlerUtility.getCatalog(getConnection(), options);


        return  catalog;
    }

    private static Connection getConnection() {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection ok");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public GenerateInterfaseFinal() throws IOException {
        configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "");
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);
    }

    public void generateInterfase(Catalog catalog, File fileDirectory) throws Exception {
        Map<String, Object> freemarkerDataModel = new HashMap<>();
        Template template = configuration.getTemplate("generateInterfaseFinal.ftl");
        List<Table> tableList = (List<Table>) catalog.getTables();
        for (Table table : tableList) {
            freemarkerDataModel.put("table", table);
            File javaSourceFile = new File(fileDirectory, table.getName() + ".java");
            Writer javaSourceFileWriter = new FileWriter(javaSourceFile);
            template.process(freemarkerDataModel, javaSourceFileWriter);
        }
    }
}
