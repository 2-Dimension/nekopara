package com.zml.nekopara.mapper;

import com.zml.nekopara.model.Album;
import com.zml.nekopara.model.AlbumQueryObject;

import java.util.List;


public interface AlbumMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Album record);

    Album selectByPrimaryKey(Long id);

    List<Album> selectAll();

    int updateByPrimaryKey(Album record);

	List<Album> queryForCondition(AlbumQueryObject qo);

	int queryForCount(AlbumQueryObject qo);
}