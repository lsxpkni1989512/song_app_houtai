package owa.com.platform.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



import owa.com.common.Utils;
import owa.com.common.util.ResponseUtil;
import owa.com.common.util.UUIDRandom;
import owa.com.platform.entity.SongTab;
import owa.com.platform.service.SongService;
@Controller
@RequestMapping("/songsController")
public class SongsController{
	
	/** 日志记录 */
	private static final Logger logger = Logger.getLogger(SongsController.class);
	
	@Autowired
	private SongService songService; 

	private String uploadDir="uploadFile";//上传路径
	
	private String newFileName = null;
	
	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	@RequestMapping("/insertOrUpdateSong")
	public String insertOrUpdateSong(HttpServletRequest request,HttpServletResponse response,
			@RequestParam (value="fileMp3",required=false) MultipartFile multipartFileMp3,@RequestParam (value="fileLyric",required=false)MultipartFile multipartFileLyric) throws Exception{
		
		//获取参数
		String songName = request.getParameter("song_name");
		String songSinger = request.getParameter("song_singer");
		String songAlbum = request.getParameter("song_album");
		String innerid = request.getParameter("innerid");
		String songUrl = uploadMp3(request,multipartFileMp3);
		String songLyricUrl = uploadLyric(request,multipartFileLyric);
		
		//封装参数
		SongTab songTab = new SongTab();
		songTab.setInnerid(innerid);
		songTab.setSongAlbum(songAlbum);
		songTab.setSongName(songName);
		songTab.setSongSinger(songSinger);
		
		//判断是否上传，如果返回不为空则说明有上传文件
		if(StringUtils.isNotEmpty(songUrl)){
			songTab.setSongUrl(songUrl);
		}
		if(StringUtils.isNotEmpty(songLyricUrl)){
			songTab.setSongLyricUrl(songLyricUrl);
		}
		
		int i =0;
		//根据innerid在有无判断要进行新增还是修改
		if(StringUtils.isNotEmpty(innerid)){
			//修改
			
		}else{
			//新增
			String id = UUIDRandom.getUUID();
			songTab.setInnerid(id);
			songTab.setCreateTime(Utils.DateForString(new Date()));
			i = songService.insertSong(songTab);
		}
		
		//System.out.println(song_name);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(i);
		out.flush();   
		out.close();
		return null;
			
	}
	
	/***
	 * 上传Mp3
	 * @param file
	 * @param title
	 * @return
	 * @throws Exception
	 */
	public String uploadMp3(HttpServletRequest request,MultipartFile fileMp3) throws Exception {
		String filePath = request.getSession().getServletContext().getRealPath("");//获取该项目的真实路径
		// 得到当前时间自1970年1月1日0时0分0秒开始流逝的毫秒数，将这个毫秒数作为上传文件新的文件名。  
        long now = new Date().getTime();
		String httpUrl = null;
		if (!fileMp3.isEmpty()) { //===========判断 MultipartFile是否为空 =======#######
			//获取文件名字
			//String fileFileName = fileMp3.getOriginalFilename();
			// 得到保存上传文件的目录的真实路径  
			//String path = "C:\\"+uploadDir; 
			String path = filePath+"\\"+uploadDir; 
			String localHost = path+"\\"+now+".mp3";
			File dir = new File(path);  
			// 如果这个目录不存在，则创建它。  
			if (!dir.exists())  
				dir.mkdir();  
			 
			// 读取保存在临时目录下的上传文件，写入到新的文件中。  
			File file = new File(localHost);
			fileMp3.transferTo(file);
			StringBuffer sb = new StringBuffer();
			sb.append("/").append(uploadDir).append("/").append(now+".mp3");
			httpUrl = sb.toString();
			return httpUrl;
		}else{
			return httpUrl;
		}
	}
	
	/***
	 * 上传歌词
	 * @param file
	 * @param title
	 * @return
	 * @throws Exception
	 */
	public String uploadLyric(HttpServletRequest request,MultipartFile fileLyric) throws Exception {
		String filePath = request.getSession().getServletContext().getRealPath("");//获取该项目的真实路径
		// 得到当前时间自1970年1月1日0时0分0秒开始流逝的毫秒数，将这个毫秒数作为上传文件新的文件名。  
        long now = new Date().getTime();
		String httpUrl = null;
		if (!fileLyric.isEmpty()) {  
			//获取文件名字
			//String fileFileName = fileLyric.getOriginalFilename();
			// 得到保存上传文件的目录的真实路径  
			//String path = "C:\\"+uploadDir; 
			String path = filePath+"\\"+uploadDir; 
			String localHost = path+"\\"+now+".lrc";
			File dir = new File(path);  
			// 如果这个目录不存在，则创建它。  
			if (!dir.exists())  
				dir.mkdir();  
			 
			// 读取保存在临时目录下的上传文件，写入到新的文件中。  
			File file = new File(localHost);
			fileLyric.transferTo(file);
			StringBuffer sb = new StringBuffer();
			sb.append("/").append(uploadDir).append("/").append(now+".lrc");
			httpUrl = sb.toString();
			return httpUrl;
		}else{
			return httpUrl;
		}
	}

	/**
	 * 带查询条件的分页列表
	 * @throws Exception 
	 */
	@RequestMapping("/songList")
	public void songList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String songName = request.getParameter("songName");
		int pageNo =  Integer.parseInt(request.getParameter("page")); //当前页
		int pageSize  =  Integer.parseInt(request.getParameter("rows")); //每页显示的数据量
		List<SongTab> songList = songService.getSongListAll(pageNo, pageSize, songName);
		List<SongTab> songListCount = songService.getSongListAll(pageNo, null, songName);
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(songList);
		result.put("total",new Integer(songListCount.size())); //代表所有条数
		result.put("rows", jsonArray);//row是代表显示的页的数据
		ResponseUtil.write(response, result);
	}

}
