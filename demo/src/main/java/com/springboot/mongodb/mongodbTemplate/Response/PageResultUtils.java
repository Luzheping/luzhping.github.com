package com.springboot.mongodb.mongodbTemplate.Response;

/**
 * 页数工具类
 * 
 * @author WangWei
 */
public class PageResultUtils {

	/**
	 * 计算查询页数
	 * 
	 * @param startPage 开始页数（如0开始或1开始)
	 * @param page      当前页数
	 * @return 查询页数
	 */
	public static int page(int startPage, int page){
		int p = page - startPage;
		return p < 0 ? 0 : p;
	}
	
	/**
	 * 计算显示总页数
	 * 
	 * @param count 总记录数
	 * @param size  每页记录数
	 * @return 总页数
	 */
	public static int pageCount(int count, int size){
		if(size <=  0){
			return 0;
		}
		
		return (count + size -1) / size;
	}
}
