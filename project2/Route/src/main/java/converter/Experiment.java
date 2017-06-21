package converter;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.TypeConverter;
import ru.cinimex.learn.customerws.customer.CustomerType;
import ru.cinimex.learn.entity.Customer;

/**
 * Created by efischenko on 21.06.2017.
 */
public class Experiment  implements Processor{
    @Override
    public void process(Exchange exchange) throws Exception {
        CustomerType cust = new CustomerType();
        TypeConverter tc = exchange.getContext().getTypeConverter();
        Customer convertCust = tc.convertTo(Customer.class ,cust );
    }
}
