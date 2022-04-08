package cn.chonglang.forum.mapper;

import cn.chonglang.forum.model.UserAccount;

public interface UserAccountExtMapper {

    int incScore(UserAccount userAccount);
    int decScore(UserAccount userAccount);
}
