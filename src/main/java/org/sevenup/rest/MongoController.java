//package org.sevenup.rest;
//
//import org.sevenup.domain.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/mongo")
//public class MongoController {
//	@Autowired
////	@Qualifier("mongoTemplate")
//	MongoTemplate mongoTemplate;
//
//	@RequestMapping(method = RequestMethod.GET)
//	public User findArtworkById() {
//
//		Query query = new Query(Criteria.where("artworkId").is("111"));
//		User artwork = mongoTemplate.findOne(query, User.class);
//
//		return artwork;
//
//	}
//}
