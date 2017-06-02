package ru.cinimex.task;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by efischenko on 02.06.2017.
 */
public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        onException(Exception.class).log(LoggingLevel.ERROR,"EXCEPTION. NOT RUSSIAN");
        from("file://C:/D?noop=false").to("file://{{result}}");

    }
}
