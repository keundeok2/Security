package com.security.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.security.domain.UserDto;

@Mapper
public interface UserMapper {

	@Insert("INSERT INTO user (email, password) values (#{email}, #{password})")
	@Options(useGeneratedKeys = true, keyProperty = "idx" )
	public void addUser(UserDto userDto);
	
	@Insert("INSERT INTO user_role (user_idx) values (#{userIdx})")
	public void setRole(int userIdx);
	
	@Select("SELECT u.idx, u.email, u.password, ur.role FROM user u "
			+"LEFT JOIN user_role ur ON u.idx = ur.user_idx "
			+"WHERE u.email = #{email}")
	public UserDto getUserByEmail(String email);
	
	
}
