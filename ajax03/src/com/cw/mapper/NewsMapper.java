package com.cw.mapper;

import com.cw.bean.News;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {
    /*
        查询全部
     */
    @Select("SELECT * FROM news")
    public abstract List<News> selectAll();
}
