package ru.cinimex.task;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by efischenko on 02.06.2017.
 */
public class MyRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file://C:/A?noop=false").to("file://C:/B");

    }
}
