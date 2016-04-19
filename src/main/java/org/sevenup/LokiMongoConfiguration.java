package org.sevenup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoDbUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
class LokiMongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "loki";
	}

	@Override
	public Mongo mongo() throws Exception {
		MongoClient mongoClient = new MongoClient("127.0.0.1");
		mongoClient.setWriteConcern(WriteConcern.SAFE);
		return mongoClient;
	}

	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
		 
		return new GridFsTemplate(new LokiMongoDbFactory((MongoClient) mongo(),"lokiGridFS"), mappingMongoConverter());
	}
	@Override
	public MongoDbFactory mongoDbFactory() throws Exception {
		return super.mongoDbFactory();
	}


	@Override
	public MappingMongoConverter mappingMongoConverter() throws Exception {
		return super.mappingMongoConverter();
	}

	@Override
	public @Bean MongoTemplate mongoTemplate() throws Exception {

		return new MongoTemplate(mongo(), "loki");
	}

}
