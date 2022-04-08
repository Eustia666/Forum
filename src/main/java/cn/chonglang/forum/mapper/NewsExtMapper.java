package cn.chonglang.forum.mapper;

import cn.chonglang.forum.dto.NewsQueryDTO;
import cn.chonglang.forum.model.News;

import java.util.List;

public interface NewsExtMapper {
    int incView(News record);
    Integer countBySearch(NewsQueryDTO newsQueryDTO);
    List<News> selectBySearch(NewsQueryDTO newsQueryDTO);

}
