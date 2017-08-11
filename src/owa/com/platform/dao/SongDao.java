package owa.com.platform.dao;

import java.util.List;
import java.util.Map;

import owa.com.platform.entity.SongTab;


public interface SongDao {
	
	int insertSong(SongTab songTab);
	
	List<SongTab> getSongListAll(Map<String,Object> param);
}