package com.springboot.mongodb.mongodbTemplate.id;

/**
 * 自动生成ID工具类
 * 
 * @author WangWei
 */
public class IdGenerators {
	
	private static IdGenerator<String> uuIdGenerator = new UUIDGenerator();
	
	/**
	 * 通过UUID生成ID
	 * 
	 * @return 编号
	 */
	public static String uuid(){
		return uuIdGenerator.generate();
	}
}
