package custom;

import org.apache.camel.Exchange;
import org.apache.camel.AggregationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CollectBodyAggregator implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        List<Map<String, Object>> studentRecords  = new ArrayList<>();
        if (oldExchange != null) {
			newExchange.setProperty("header", oldExchange.getProperty("header"));
		    Object studentRecord = newExchange.getProperty("studentRecord", Map.class);
			if(studentRecord != null){
			    studentRecords = oldExchange.getIn().getBody(List.class);
				studentRecords.add((Map)studentRecord);
			}
        }
        newExchange.getIn().setBody(studentRecords);
        return newExchange;
    }
}
