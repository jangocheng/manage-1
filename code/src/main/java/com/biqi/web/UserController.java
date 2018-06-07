package com.biqi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.biqi.model.User;
import com.biqi.service.UserService;
import com.common.result.PageDto;
import com.common.result.ResultDto;

import io.swagger.annotations.ApiOperation;

/**   
 * Description: 用户管理的基础类
 * @Package com.biqi.web 
 * @author  xiebq @date    2018年6月6日 下午10:56:24 
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/save")
    @ApiOperation(value = "保存用户")
	public ResultDto<Integer> saveUser(@RequestBody User user){
		ResultDto<Integer> resultDto = new ResultDto<>();
		resultDto.setData(userService.saveUser(user));
		return resultDto;
	}
	
	
	@PostMapping("/user/delete")
    @ApiOperation(value = "删除用户")
	public ResultDto<Boolean> deleteUser(@RequestParam Integer id){
		ResultDto<Boolean> resultDto = new ResultDto<>();
		resultDto.setData(userService.deleteUser(id));
		return resultDto;
	}
	
	
	@PostMapping("/user/update")
    @ApiOperation(value = "更新用户")
	public ResultDto<Boolean> updateUser(@RequestBody User user){
		ResultDto<Boolean> resultDto = new ResultDto<>();
		resultDto.setData(userService.updateUser(user));
		return resultDto;
	}
	
	
	
	@GetMapping("/user/getUserByid")
    @ApiOperation(value = "根据id查询用户")
	public ResultDto<User> getUserByid(@RequestParam Integer id){
		ResultDto<User> resultDto = new ResultDto<>();
		resultDto.setData(userService.getUserByid(id));
		return resultDto;
	}
	
	
	@GetMapping("/user/list")
    @ApiOperation(value = "获得用户列表")
	public ResultDto<PageDto<User>> listUser(){
		ResultDto<PageDto<User>> resultDto = new ResultDto<>();
		resultDto.setData(userService.listUser());
		return resultDto;
	}
	

}