package springdatamongodb;

import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.data.mongodb.core.*;

public class MongoDBUtils
{
    private static ApplicationContext factory = null;
    private static MongoTemplate mongoTemplate = null;

    static
    {
        factory = new ClassPathXmlApplicationContext("spring-data-mongodb.xml");
        mongoTemplate = (MongoTemplate) factory.getBean("mongoTemplate");
    }

    public static MongoTemplate getMongoTemplate()
    {
        return mongoTemplate;
    }
}