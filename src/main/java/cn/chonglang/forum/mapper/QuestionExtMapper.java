package cn.chonglang.forum.mapper;

import cn.chonglang.forum.dto.QuestionQueryDTO;
import cn.chonglang.forum.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);

    List<Question> selectTop(QuestionQueryDTO questionQueryDTO);


    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}
