package owa.com.platform.service;

import java.util.List;
import java.util.Map;

import owa.com.platform.entity.SongTab;


public interface SongService {

	int insertSong(SongTab songTab);

	List<SongTab> getSongListAll(int pageNo,Integer pageSize,String songName);
}
