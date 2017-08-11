package owa.com.platform.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import owa.com.common.Utils;
import owa.com.common.util.StringUtils;
import owa.com.platform.dao.SongDao;
import owa.com.platform.entity.SongTab;
import owa.com.platform.service.SongService;

@Service("songService")
public class SongServiceImpl implements SongService{
	
	@Autowired
	private SongDao songDao;

	@Override
	public int insertSong(SongTab songTab) {
		return songDao.insertSong(songTab);
	}

	@Override
	public List<SongTab> getSongListAll(int pageNo,Integer pageSize,String songName) {
		Map<String,Object> param = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(songName)){
			param.put("songName", songName);
		}else{
			param.put("songName", null);
		}
		if(Utils.isNull(pageSize)){
			param.put("fromIndex", null);
		}else{
			param.put("fromIndex", (pageNo-1)*pageSize);
		}
		param.put("rows", pageSize);
		return songDao.getSongListAll(param);
	}


}
