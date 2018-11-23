package com.df.cloud.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.df.dto.ClientPage;
import com.df.dto.PageInfo;
import com.df.dto.TianlingpengDTO;
import com.df.vo.TianlingpengVO;

/**
 * 
 *@ClassName ITLPService
 *@Description 运动员信息服务层
 *@author tianlingpeng
 *
 */
@FeignClient("springbootssm")
public interface ITLPService {
	/**
	 * 
	 * @Description 根据条件查询
	 * @param 
	 * @return 用户分页结果
	 */
	@PostMapping("/tlp/find")
	PageInfo<TianlingpengVO> findByCondition(@RequestBody TianlingpengDTO dto);
	
	/**
	 * 
	 * @Description 新增信息
	 * @param 
	 * @return 新增是否成功
	 */
	@PostMapping("/tlp/add")
	Boolean addPlayer(@RequestBody TianlingpengDTO dto);
	
	/**
	 * 
	 * @Description 更据gid删除信息
	 * @param gid
	 * @return 删除是否成功
	 */
	@GetMapping("/tlp/delete")
	Boolean deletePlayer(@RequestParam("gid") String gid);
	
	/**
	 * 
	 * @Description 更新信息
	 * @param 
	 * @return 更新是否成功
	 */
	@PostMapping("/tlp/update")
	Boolean updatePlayer(@RequestBody TianlingpengDTO dto);

	/**
	 * 
	 * @Description 查询所有角色
	 * @param 
	 * @return 角色列表
	 */
	@GetMapping("/tlp/findRole")
	 List<String> findRole();
}
