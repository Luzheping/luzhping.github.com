package com.springboot.mongodb.mongodbTemplate.Response;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 返回分页查询结果对象
 *
 * @author WangWei
 */
public class PageResult<T> {
	private final int code;
	private final String message;
	private final int count;
	private final List<T> data;
	private int page;
	private int size;

	public static <T> PageResult<T> success(Page<T> page){
		return success(page.getCount(), page.getContent());
	}
	
	public static <I, T> PageResult<T> success(Page<I> page, ConvertResult<I, T> convert){
		return success(page.getCount(), page.getContent(), convert);
	}
	
	public static <T> PageResult<T> success(int count, List<T> data) {
		return new PageResult<T>(0, "", count, data);
	}
	
	public static <I, T> PageResult<T> success(int count, List<I> data, ConvertResult<I, T> convert) {
		return new PageResult<T>(0, "", count, 
				data.stream().map(e -> convert.convert(e)).collect(Collectors.toList()));
	}

	public static <T> PageResult<T> error(String message) {
		return error(1007, message);
	}

	public static <T> PageResult<T> error(int code, String message) {
		return new PageResult<T>(code, message, -1, null);
	}

	private PageResult(int code, String message, int count, List<T> data) {
		this.code = code;
		this.message = message;
		this.count = count;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public int getCount() {
		return count;
	}

	public List<T> getData() {
		return data;
	}

	public int getPageCount() {
		return PageResultUtils.pageCount(count, size);
	}

	public int getPage() {
		return page;
	}

	public PageResult<T> setPage(int page) {
		this.page = page;
		return this;
	}

	public int getSize() {
		return size;
	}

	public PageResult<T> setSize(int size) {
		this.size = size;
		return this;
	}

	@FunctionalInterface
	public interface ConvertResult<I, O>{
		
		O convert(I i);
	}
}
