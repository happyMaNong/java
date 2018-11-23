package com.df.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @ClassName TianlingpengDTO
 * @Description 用户传入参数基础模型，用于添加和修改
 * @author tianlingpeng
 *
 */
@Data
public class TianlingpengDTO {

	@ApiModelProperty("gid")
	private String gid;
	@ApiModelProperty("姓名")
	private String name;
	@ApiModelProperty("年龄")
	private Integer age;

	@ApiModelProperty(value = "出生日期", notes = "格式：yyyy年MM月dd日")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@ApiModelProperty("角色")
	private String role;

	@ApiModelProperty("工资薪水")
	private BigDecimal salary;

	@ApiModelProperty("性别")
	private Boolean sex;

	@ApiModelProperty("外号")
	private String nickname;
	@ApiModelProperty("当前页")
	private Integer page=1;
	@ApiModelProperty("每页的条数")
	private Integer rowMax=10;
}
