package ru.cinimex.task;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * Created by efischenko on 02.06.2017.
 */
public class MyRouteBuilder extends RouteBuilder {
    private String RESULT_URL ="{{result}}";

    public void setResultUrl(String newReultURL){
        this.RESULT_URL = newReultURL;
    }

    @Override
    public void configure() throws Exception {


        log.info("please");
        //Exception Handler
        onException(FileNotFoundException.class).log(LoggingLevel.ERROR, "File not found exception."
                + " Directory or File is't exist. Create a directory and try again.");
        onException(IOException.class).log(LoggingLevel.ERROR, "IO exception");
        onException(Exception.class).log(LoggingLevel.ERROR, "EXCEPTION");

        // Camel Route
        from("file://C:/D?noop=false").log(LoggingLevel.INFO, "ToLogFile", "${file:name}")
                .to("file://" + RESULT_URL);

    }
}