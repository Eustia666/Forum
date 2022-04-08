package cn.chonglang.forum.mapper;

import cn.chonglang.forum.dto.TalkQueryDTO;
import cn.chonglang.forum.model.Talk;

/**
 * @author wadao
 * @version 1.0
 * @date 2020/9/24 21:53
 * @site niter.cn
 */
public interface TalkExtMapper {

    Integer count(TalkQueryDTO talkQueryDTO);

    int updateByPrimaryKeySelective(Talk talk);
}
