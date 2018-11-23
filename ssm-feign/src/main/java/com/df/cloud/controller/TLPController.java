package com.df.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.df.cloud.service.ITLPService;
import com.df.dto.ClientPage;
import com.df.dto.PageInfo;
import com.df.dto.TianlingpengDTO;
import com.df.vo.TianlingpengVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="运动员信息")
@RestController
public class TLPController {
	
	@Autowired
	private ITLPService tlpService;
	
	@ApiOperation(value="分页查询篮球运动员信息" ,notes="分页查询篮球运动员信息")
	@PostMapping("/find")
	public PageInfo<TianlingpengVO> findPlyer(TianlingpengDTO dto) {
		return tlpService.findByCondition(dto);
	}
	@ApiOperation(value="查询篮球运动员角色信息" ,notes="查询新增篮球运动员角色信息")
	@GetMapping("/findRole")
	public List<String> findRole() {
		return tlpService.findRole();
	}
	@ApiOperation(value="新增篮球运动员信息" ,notes="新增篮球运动员信息")
	@PostMapping("/add")
	public boolean addPlyer(TianlingpengDTO dto) {
		return	tlpService.addPlayer(dto);
	}
	
	@ApiOperation(value="删除篮球运动员信息" ,notes="删除篮球运动员信息")
	@GetMapping("/delete")
	public boolean deletePlyer(String gid) {
		System.out.println("--------------------------");
		System.out.println(gid);
		return	tlpService.deletePlayer(gid);
	}
	
	@ApiOperation(value="更新篮球运动员信息" ,notes="更新篮球运动信息")
	@PostMapping("/update")
	public boolean updatePlyer(TianlingpengDTO dto) {
		return	tlpService.updatePlayer(dto);
	}

}
