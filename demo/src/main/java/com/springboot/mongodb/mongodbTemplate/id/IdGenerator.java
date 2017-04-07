package com.springboot.mongodb.mongodbTemplate.id;

/**
 * 自动生成ID
 * 
 * @author WangWei
 */
public interface IdGenerator<T> {

	T generate();
	
}
