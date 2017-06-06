package ru.cinimex.task;



import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;


import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.FileNotFoundException;



/**
 * Created by efischenko on 02.06.2017.
 */
public class MyRouteBuilder extends RouteBuilder {

   Processor myProcessor = new Processor(){
       @Override
       public void process(Exchange exchange)
       {
           log.info("Called with exchange: " + exchange);
       }
   };

    @Override
        public void configure() throws Exception {
            Mainl ml = new Mainl();

        log.info("please");
        //Exception Handler
        onException(FileNotFoundException.class).log(LoggingLevel.ERROR,"File not found exception."
                + " Directory is't exist. Create a directory and try again.");
        onException(Exception.class).log(LoggingLevel.ERROR,"EXCEPTION");

        // Camel Route
        from("file://C:/D?noop=false").log(LoggingLevel.INFO, ml.getLogger() ,"Hi")
                .process(myProcessor).to("log:ru.cinimex?level=INFO").to("file://{{result}}");

    }


   /* .to("log:?level=info").to("log:ru.cinimex?level=INFO").*/

 /*   process(new Processor() {
        @Override
        public void process(Exchange exchange) throws Exception {
            log.info("HI!");
        }})
    */


/*.to("log:root?level=info")*/
}
