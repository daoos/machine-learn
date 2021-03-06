package com.ccx.models.mapper;

import java.util.List;
import java.util.Map;

import com.ccx.models.model.PermissionBean;
import com.ccx.models.model.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.ccx.models.model.Module;
import com.ccx.models.model.User;
import com.ccx.models.model.UserNum;

/**
 * 
 * @description User 表数据库控制层接口
 * @author zxr
 * @date 2017 上午11:57:12
 */
public interface UserMapper extends BaseMapper<User>{

	/**
	 * 根据用户名获取用户信息
	 * @param loginName
	 * @return
	 */
	List<User> selectListByLoginName(@Param("loginName") String loginName);

	/**
	 * 查询分页信息
	 * @param page
	 * @param condition
	 * @return
	 */
	List<Map<String, Object>> selectUserPage(Page<Map<String, Object>> page, Map<String, Object> condition);

	/**
	 * 查询页面显示的用户信息
	 * @return
	 */
	List<UserVo> findAll(Map<String,Object> params);
	
	/**
	 * 展示用户信息
	 * @param id
	 * @return
	 */
	User selectUserById(@Param("id") Long id);

	/**
	 * 修改用户信息
	 * @param user
	 */
	int updateTO(User user);

	/**
	 * 保存新增用户信息
	 * @param user
	 */
	void doAddUser(User user);

	/**
	 * 根据loginName得到user
	 * @param loginName
	 * @return
	 */
	User getUserByName(@Param("loginName") String loginName);

	/**
	 * @Description: 校验登录ip是否存在于数据库，如果不存在，不准登入。
	 * @Author: wxn
	 * @Date: 2017/12/27 18:20:59
	 * @Param:
	 * @Return
	 */
	List<String> getIPList(String loginIp);
	
	List<User> getUserListByName(String loginName);

	/**
	 * 冻结用户
	 * @param id
	 */
	int freezeUser(Long id);

	/**
	 * 解冻用户
	 * @param id
	 */
	int unfreezeUser(Long id);

	/**
	 * 用户被锁定
	 * @param id 
	 */
	void lockUser(Long id);

	/**
	 * 根据id注销用户
	 * @param id
	 */
	int deleteUser(Long id);

	/**
	 * 根据用户ID查询权限（permission）
	 * @param id
	 * @return
	 */
	List<PermissionBean> findUserMenuPermission(Long id);
	
	
}
