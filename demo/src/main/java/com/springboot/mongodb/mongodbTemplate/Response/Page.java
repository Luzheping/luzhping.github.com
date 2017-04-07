package com.springboot.mongodb.mongodbTemplate.Response;

import java.util.List;

/**
 * 查询页
 * 
 * @author WangWei
 * 
 * @param <T>
 */
public class Page<T> {
	private final int count;
	private final List<T> content;
	
	public Page(int count, List<T> content) {
		this.count = count;
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public List<T> getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Page [count=" + count + ", content=" + content + "]";
	}
}
