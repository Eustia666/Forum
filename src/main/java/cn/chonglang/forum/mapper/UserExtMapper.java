package cn.chonglang.forum.mapper;

import cn.chonglang.forum.dto.UserQueryDTO;
import cn.chonglang.forum.model.User;

import java.util.List;

public interface UserExtMapper {
    List<User> selectLatestLoginUser(UserQueryDTO userQueryDTO);
    Integer count(UserQueryDTO userQueryDTO);
}
