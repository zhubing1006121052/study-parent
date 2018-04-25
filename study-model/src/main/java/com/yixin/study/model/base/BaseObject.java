package com.yixin.study.model.base;

import java.io.Serializable;

public abstract class BaseObject implements Serializable{
	private static final long serialVersionUID = -7077418734142354684L;

    public static final String DEFAULT_STRING_ = "";



    public static final int DEFAULT_INTEGER_0 = 0;
    public static final int DEFAULT_INTEGER_1 = 1;
    public static final int DEFAULT_INTEGER_2 = 2;
    public static final int DEFAULT_INTEGER_3 = 3;
    public static final int DEFAULT_INTEGER_4 = 4;

    public static final long DEFAULT_LONG_0 = 0l;
    public static final long DEFAULT_LONG_1 = 1l;
    public static final long DEFAULT_LONG_2 = 2l;
    public static final long DEFAULT_LONG_3 = 3l;
    public static final long DEFAULT_LONG_4 = 4l;

    public static final boolean DEFAULT_BOOLEAN_FALSE = false;
    public static final boolean DEFAULT_BOOLEAN_TRUE = true;

    public static final int VALID = DEFAULT_INTEGER_1;
    public static final int INVALID = DEFAULT_INTEGER_0;
    
    
    private Integer currentPage = 1;//当前页码;默认第一页
	private Integer pageSize = 10;//页面大小;默认一页显示10条 

    public abstract String toString();

    public abstract boolean equals(Object o);

    public abstract int hashCode();

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
    
}

