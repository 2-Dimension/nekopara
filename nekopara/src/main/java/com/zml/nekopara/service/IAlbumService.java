package com.zml.nekopara.service;

import com.zml.nekopara.model.Album;
import com.zml.nekopara.model.AlbumQueryObject;
import com.zml.nekopara.util.PageResult;

import java.util.List;

public interface IAlbumService {

	void save(Album album);
	void delete(Long id);
	Album get(Long id);
	void update(Album album);
	List<Album> list(AlbumQueryObject qo);
	PageResult query(AlbumQueryObject qo);
}
