package com.freemarker;

import schemacrawler.schema.Catalog;
import schemacrawler.schemacrawler.*;
import schemacrawler.tools.utility.SchemaCrawlerUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppMeta {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/djooky_db";
    private static final String DB_USERNAME = "djooky";
    private static final String DB_PASSWORD = "djooky";

    private static Connection getConnection() {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection ok");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }


    public static void main(String[] args) throws Exception {


        final LoadOptionsBuilder loadOptionsBuilder =
                LoadOptionsBuilder.builder()
                        // Set what details are required in the schema - this affects the
                        // time taken to crawl the schema
                        .withSchemaInfoLevel(SchemaInfoLevelBuilder.standard());

        final SchemaCrawlerOptions options =
                SchemaCrawlerOptionsBuilder.newSchemaCrawlerOptions()
                        .withLoadOptions(loadOptionsBuilder.toOptions());

        final Catalog catalog = SchemaCrawlerUtility.getCatalog(getConnection(), options);



//        File outputDirectory = new File("/home/gleb/IdeaProjects/FreeMarker/src/main/java/com/freemarker/re");
//        GenerateInterfaseFinal javaDataWithLiba = new GenerateInterfaseFinal();
//        Catalog catalog = javaDataWithLiba.getCatalog();
//
//        javaDataWithLiba.generateInterfaseWithLiba(catalog, outputDirectory);


    }

}

