package com.zml.nekopara.service.impl;

import java.util.List;

import com.zml.nekopara.mapper.AlbumMapper;
import com.zml.nekopara.model.Album;
import com.zml.nekopara.model.AlbumQueryObject;
import com.zml.nekopara.service.IAlbumService;
import com.zml.nekopara.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements IAlbumService {

	@Autowired
	private AlbumMapper albumMapper;
	@Override
	public List<Album> list(AlbumQueryObject qo) {
		
		return albumMapper.queryForCondition(qo);
	}
	@Override
	public void save(Album album) {
		albumMapper.insert(album);
	}
	@Override
	public void delete(Long id) {
		albumMapper.deleteByPrimaryKey(id);
	}
	@Override
	public Album get(Long id) {
		return albumMapper.selectByPrimaryKey(id);
	}
	@Override
	public void update(Album album) {
		albumMapper.updateByPrimaryKey(album);
	}
	@Override
	public PageResult query(AlbumQueryObject qo) {
		int ret=albumMapper.queryForCount(qo);
		if(ret==0){
			return PageResult.emptyPageResult(qo.getPageSize());
		}
		List<Album> listData=albumMapper.queryForCondition(qo);
		
		return new PageResult<>(listData, qo.getCurrentPage(), qo.getPageSize(), ret);
	}
	

}
