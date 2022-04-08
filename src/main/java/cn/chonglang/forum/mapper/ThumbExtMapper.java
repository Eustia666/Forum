package cn.chonglang.forum.mapper;

import cn.chonglang.forum.dto.LikeQueryDTO;
import cn.chonglang.forum.model.Comment;
import cn.chonglang.forum.model.Question;

public interface ThumbExtMapper {
    int incLikeCount(Comment comment);

    int incQuestionLikeCount(Question question);

    Integer count(LikeQueryDTO likeQueryDTO);
}
