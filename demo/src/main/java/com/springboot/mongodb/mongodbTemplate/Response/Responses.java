package com.springboot.mongodb.mongodbTemplate.Response;

import java.util.List;

/**
 * 通用输出实体
 * 
 * @author WangWei
 */
public class Responses {
	
	/**
	 * OK输出对象
	 * 
	 * @param _ok 成功标示
	 * @return 输出对象
	 */
	public final static Object ok(boolean _ok){
		return new Object(){
			@SuppressWarnings("unused")
			public boolean ok = _ok;
		};
	}
	
	/**
	 * 编号输出对象
	 * 
	 * @param _id 编号
	 * @return 输出对象
	 */
	public final static Object id(String _id){
		return new Object(){
			@SuppressWarnings("unused")
			public String id = _id;
		};
	}
	
	/**
	 * 编号集合输出对象
	 * 
	 * @param _ids 编号集合
	 * @return 输出对象
	 */
	public final static Object ids(List<String> _ids){
		return new Object(){
			@SuppressWarnings("unused")
			public List<String> ids = _ids;
		};
	}
	
	/**
	 * 数据集合输入对象
	 * 
	 * @param _data 数据集合
	 * @return 输出对象
	 */
	public final static<T> Object data(List<T> _data){
		return new Object(){
			@SuppressWarnings("unused")
			public List<T> data = _data;
		};
	}
	
	/**
	 * 上传文件输出
	 * 
	 * @param _url         上传文件访问连接地址
	 * @param _contentType 上传文件类型
	 * @param _filename    上传文件名
	 * @return
	 */
	public final static Object upload(String _url, String _contentType, String _filename){
		return new Object(){
			@SuppressWarnings("unused")
			public String url = _url;
			@SuppressWarnings("unused")
			public String contentType = _contentType;
			@SuppressWarnings("unused")
			public String filename = _filename;
		};
	}
	
	/**
	 * KindEditor上传文件输出
	 * 
	 * @param _error   编码
	 * @param _url     上传文件访问连接地址
	 * @param _message 错误信息
	 * @return
	 */
	public final static Object keUpload(int _error, String _url, String _message){
		return new Object(){
			@SuppressWarnings("unused")
			public String url = _url;
			@SuppressWarnings("unused")
			public int error = _error;
			@SuppressWarnings("unused")
			public String message = _message;
		};
	}
}
