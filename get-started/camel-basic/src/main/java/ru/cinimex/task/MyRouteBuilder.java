package ru.cinimex.task;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import java.io.FileNotFoundException;

/**
 * Created by efischenko on 02.06.2017.
 */
public class MyRouteBuilder extends RouteBuilder {

    String resultURL ="{{result}}";

    public void setResultUrl(String resultURL){
        this.resultURL = resultURL;
    }

    @Override
    public void configure() throws Exception {
        //Exception Handler
        onException(FileNotFoundException.class).log(LoggingLevel.ERROR,"File not found exception."
                + " Directory is't exist. Create a directory and try again.");
        onException(Exception.class).log(LoggingLevel.ERROR,"EXCEPTION");

        // Camel Route
        from("file://C:/D?noop=false").log(LoggingLevel.INFO, "TProcessing file ${file:name}").to("file://" + resultURL );

    }
   /* .to("log:ru")
                .wireTap("direct:tap")*/
}
