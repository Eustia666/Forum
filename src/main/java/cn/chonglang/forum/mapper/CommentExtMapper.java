package cn.chonglang.forum.mapper;

import cn.chonglang.forum.dto.CommentQueryDTO;
import cn.chonglang.forum.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);

    Integer countBySearch(CommentQueryDTO commentQueryDTO);

}
