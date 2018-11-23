package com.df.dto;

import lombok.Data;

/**
 * 
 *@ClassName ClientPage
 *@Description 分页参数
 *@author tianlingpeng
 *
 */
@Data
public class ClientPage {
	private Integer page=1;
	private Integer rowMax=10;
}
