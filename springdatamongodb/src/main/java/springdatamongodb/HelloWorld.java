package springdatamongodb;

import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;

public class HelloWorld
{
    public static void main(String[] args)
    {
        MongoOperations mongoOps = MongoDBUtils.getMongoTemplate();
        
        Query query = new Query(Criteria.where("_id").is("90210"));
        System.out.println("Found = " + mongoOps.count(query, "zips"));
        
        City city = mongoOps.findOne(query, City.class, "zips");
        double[] loc = city.getLoc();
        System.out.println("City = " + city.getCity());
        System.out.println("Location = [" + loc[0] + ", " + loc[1] + "]");
    }
}
