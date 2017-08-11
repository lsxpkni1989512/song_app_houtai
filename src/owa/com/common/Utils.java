package owa.com.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import owa.com.common.util.tools.BASE64Encoder;

import com.alibaba.fastjson.JSON;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * @ClassName: Util
 * @Description: 常用公共方法的调空
 * @author jiangbo
 * @date 2015-10-26 上午10:23:07
 */
public class Utils {

	/**
	 * @Title: isNull
	 * @Description: 判断字符串是否为空
	 * @param str
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isNull(String str) {
		return null == str || "".equals(str.trim()) || str.trim().equals("null") || str.trim().equals("NULL");
	}

	/**
	 * @Title: isNotNull
	 * @Description: 判断字符串是否不为空
	 * @param str
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}

	/**
	 * @Title: isNull
	 * @Description:判断集合<List>是否为空
	 * @param list
	 * @return boolean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static boolean isNull(List list) {
		return null == list || list.size() == 0;
	}

	/**
	 * @Title: isNull
	 * @Description:判断集合<List>是否不为空
	 * @param list
	 * @return boolean 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public static boolean isNotNull(List list) {
		return !isNull(list);
	}

	/**
	 * @Title: isNull
	 * @Description: 判断Object是否为空
	 * @param obj
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isNull(Object obj) {
		return null == obj;
	}

	/**
	 * @Title: isNotNull
	 * @Description: 判断Object是否不为空
	 * @param obj
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	/**
	 * @Title: isNull
	 * @Description: 判断Map是否为空
	 * @author: jiangbo
	 * @param map
	 * @return boolean
	 * @date 2015-10-25 下午10:46:49
	 */
	@SuppressWarnings("unchecked")
	public static boolean isNull(Map map) {
		return map == null || map.size() == 0;
	}

	/**
	 * @Title: isNull
	 * @Description: 判断Map是否不为空
	 * @author: jiangbo
	 * @param map
	 * @return boolean
	 * @date 2015-10-25 下午10:46:49
	 */
	@SuppressWarnings("unchecked")
	public static boolean isNotNull(Map map) {
		return !isNull(map);
	}
	
	/**
	* @Title: isNull 
	* @Description: 判断字符串数组是否为空
	* @author: jiangbo
	* @param str
	* @return
	* @date   2015-10-25 下午04:14:38
	*/
	public static boolean isNull(String[] str){
		return null == str || str.length == 0;
	}
	/**
	* @Title: isNull 
	* @Description: 判断字符串数组是否不为空
	* @author: jiangbo
	* @param str
	* @return
	* @date   2015-10-25 下午04:14:38
	*/
	public static boolean isNotNull(String[] str){
		return !isNull(str);
	}
	/**
	 * @Title: convertToMap
	 * @Description: 将符合Map标准格式的JSON字符数组转换成Map格式 K:V
	 * @param strs
	 * @return Map
	 * @author jiangbo
	 * @date 2015-10-25 下午11:30:34
	 */

	@SuppressWarnings("unchecked")
	public static Map JSONToMap(String strs) {
		 String sb = strs.substring(1, strs.length()-1);
         String[] name =  sb.split("\\\",\\\"");
         String[] nn =null;
         Map map = new HashMap();
         for(int i= 0;i<name.length; i++){
             nn = name[i].split("\\\":\\\"");
             map.put(nn[0], nn[1]);
         }
        return map;
	}

	/**
	 * @Title: convertToMap
	 * @Description: 将Map数据转换成标准JSON格式的字符串
	 * @param map
	 * @return String
	 * @author jiangbo
	 * @date 2015-10-25 下午11:30:34
	 */
	@SuppressWarnings("unchecked")
	public static String MaptoJSONStr(Map map) {
		StringBuilder sb = new StringBuilder();
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			sb.append(isNull(it.next()) ? "" : String.valueOf(it.next()));
			sb.append(":");
			sb.append(isNull(map.get(it.next())) ? "" : String.valueOf(it
					.next()));
		}
		return sb.toString();
	}

	/**
	 * @Title: formatString
	 * @Description: 格式化字符串
	 * @param str
	 * @return
	 * @author jiangbo
	 * @date 2015-10-25 下午5:42:03
	 */
	public static String formatString(String str) {
		return (isNull(str) ? "" : str.trim());
	}
	
	/**
	 * @Title: formatString
	 * @Description: 生成订单号
	 * @param order_code
	 * @return
	 */
	public static String getOrderNum(String order_code){
		return order_code+System.currentTimeMillis();
	}
	
	/**
	 * @Title: formatString
	 * @Description: 生成商城订单号
	 * @return
	 */
	public static String getShopOrderNum(){
		return System.currentTimeMillis()+getUid();
	}
	
	/**
	 * 获得4位的随机数
	 * @param min
	 * @param max
	 * @return
	 */
	public static String getUid(){

		Random random = new Random();

		String result="";

		for(int i=0;i<4;i++){
			result+=random.nextInt(10);
		}
		return result;

	}
	
	public static String getVerificationCode(String phone){
		
		return phone.substring(Constant.verification_code_one-1, Constant.verification_code_one) 
			+ phone.substring(Constant.verification_code_two-1, Constant.verification_code_two) 
			+ phone.substring(Constant.verification_code_three-1, Constant.verification_code_three) 
			+ phone.substring(Constant.verification_code_four-1, Constant.verification_code_four);
	}
	
	/**
	 * date转String方法 （年-月-日  时分秒）
	 * @param date
	 * @return
	 */
	public static String DateForString(Date date){
		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	} 
	
	/**
	 * date转String方法（年月日  时分秒）
	 * @param date
	 * @return
	 */
	public static String DateForString2(Date date){
		Format format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return format.format(date);
	}
	
	/**
	 * date转String方法 （年-月-日）
	 * @param date
	 * @return
	 */
	public static String DateForString3(Date date){
		Format format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	/**
	 * date转String方法（年-月）
	 * @param date
	 * @return
	 */
	public static String DateForString4(Date date){
		Format format = new SimpleDateFormat("yyyy-MM");
		return format.format(date);
	}
	
	/**
	 * String转方法date
	 * @param date
	 * @return
	 */
	public static Date StirngForDate(String date){
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * String转方法date
	 * @param date
	 * @return
	 */
	public static Date StirngForDate2(String date){
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * String转方法date
	 * @param date
	 * @return
	 */
	public static Date StirngForDate3(String date){
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * date转String验证并转换方法
	 * @param date
	 * @return
	 */
	public static String checkDateForString(Date date){
		String tmp = "";
		if(date != null){
			tmp = DateForString(date);
		}
		return tmp; 
	}
	
	/**
	 * date转String验证并转换方法
	 * @param date
	 * @return
	 */
	public static String checkDateForString2(Date date){
		String tmp = "";
		if(date != null){
			tmp = DateForString2(date);
		}
		return tmp; 
	}
	
	/**
	 * date转String验证并转换方法
	 * @param date
	 * @return
	 */
	public static String checkDateForString3(Date date){
		String tmp = "";
		if(date != null){
			tmp = DateForString3(date);
		}
		return tmp; 
	}
	
	/**
	 * 验证字符串是否为空
	 * @param str
	 * @return
	 */
	public static String checkString(String str){
		String tmp = "";
		if(str == null || "".equals(str.trim()) || str.trim().equals("null") || str.trim().equals("NULL")){
			return tmp;
		}else{
			tmp = str.trim();
			return tmp;
		}
	}
	
	/** 
     * 得到几天前的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static String getDateBefore(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
        return DateForString(now.getTime());  
    }  
    
    /** 
     * 得到几天前的日期 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static String getDateBeforeDays(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
        return DateForString3(now.getTime());  
    }
    
    /** 
     * 得到几天后的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static String getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return DateForString(now.getTime());  
    }
	
    /**
     * 得到几天后的时间
     * @param d
     * @param days
     * @return
     */
    public static String getDaysLater(Date d,int days){    	 
    	 Calendar can = Calendar.getInstance();
    	 can.setTime(d);
    	 can.add(Calendar.DAY_OF_MONTH, +days); 
    	 return DateForString(can.getTime());
    }
    
    /**
     * 得到几分钟后的时间
     * @param d
     * @param minutes
     * @return
     */
    public static String getMinutesLater(Date d,int minutes){    	 
    	 Calendar can = Calendar.getInstance();
    	 can.setTime(d);
    	 can.add(Calendar.MINUTE, +minutes); 
    	 return DateForString(can.getTime());
    }
    
    /**
     * 得到几秒钟后的时间
     * @param d
     * @param second
     * @return
     */
    public static String getSecondLater(Date d,int second){    	 
    	 Calendar can = Calendar.getInstance();
    	 can.setTime(d);
    	 can.add(Calendar.SECOND, +second); 
    	 return DateForString(can.getTime());
    }
    
    /**
     * 获取以一个坐标为中心一定范围的四个坐标点
     * @param longitude  //已知经度
     * @param latitude   //已知纬度
     * @param dis  		 //范围(米)
     * @return
     */
    public static Map<String, Object> getCoordinateRange(double longitude,double latitude,double dis){
		Map<String, Object> map = new HashMap<String, Object>();
    	double r = Constant.radius_of_the_earth;//地球半径(米)
		double dlng =  2*Math.asin(Math.sin(dis/(2*r))/Math.cos(latitude*Math.PI/180));
		dlng = dlng*180/Math.PI;//角度转为弧度
		double dlat = dis/r;
		dlat = dlat*180/Math.PI;		
		map.put("minlat", Utils.DoubleForString2(6,latitude - dlat));//最小纬度
		map.put("maxlat", Utils.DoubleForString2(6,latitude + dlat));//最大纬度
		map.put("minlng", Utils.DoubleForString2(6,longitude - dlng));//最小经度
		map.put("maxlng", Utils.DoubleForString2(6,longitude + dlng)); //最大经度
		return map;
    }
    
    /**
     * 计算两个坐标之间的距离
     * @param longitude1 初始经度
     * @param latitude1  初始纬度
     * @param longitude2 比对经度
     * @param latitude2  比对纬度
     * @return
     */
    public static double getCoordinateDistance(double longitude1,double latitude1,double longitude2,double latitude2){
		double x, y, distance;
		double PI = Constant.PI;
		double R = Constant.radius_of_the_earth;
        x = (longitude1 - longitude2) * PI * R
                * Math.cos(((latitude2 + latitude1) / 2) * PI / 180) / 180;
        y = (latitude1 - latitude2) * PI * R / 180;
        distance = Math.hypot(x, y);
    	return distance;
    }
    
    /**
     * 保留两位小数的方法
     * @param d
     * @return
     */
    public static String DoubleForString(double d){
    	NumberFormat numfmt=NumberFormat.getNumberInstance();
    	numfmt.setMaximumFractionDigits(2);
        String tmp= numfmt.format(d) ;
    	return tmp;
    }
    
    /**
     * 保留n位小数的方法（四舍五入）
     * @param d
     * @return
     */
    public static String DoubleForString2(int i,double d){
    	BigDecimal   b   =   new   BigDecimal(d); 
		double   f1   =   b.setScale(i,   BigDecimal.ROUND_HALF_UP).doubleValue();  
    	return String.valueOf(f1);
    }
    
    /**
     * 获取两个日期间的天数
     * @param targetDate
     * @param toDay
     * @return
     */
    public static int getDays(String targetDate,String toDay){
    	long i = 0;
    	SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

		try {
	    	Date toDay1 = ft.parse(toDay);
			Date targetDate1 = ft.parse(targetDate);
	    	i = toDay1.getTime() - targetDate1.getTime();
	    	i = i / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return (int)i;
    }
    
    /**
     * DES 加密方法
     * @param key 密码
     * @param data 加密内容
     * @return
     * @throws Exception
     */
    public static String encode(String key,byte[] data) throws Exception{
    	try{
			DESKeySpec dks = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			//key的长度不能够小于8位字节
			Key secretKey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			IvParameterSpec iv=new IvParameterSpec(key.getBytes());//向量
			AlgorithmParameterSpec paramSpec = iv;
			cipher.init(Cipher.ENCRYPT_MODE, secretKey,paramSpec);
			byte[] bytes = cipher.doFinal(data);
			BASE64Encoder base64encoder = new BASE64Encoder();
			String encode=base64encoder.encode(bytes); 
			return encode;
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
    
	public static byte[] decode(String key,byte[] data) throws Exception{
		try{
			//SecureRandom sr = new SecureRandom();
			DESKeySpec dks = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			//key 的长度不能够小于 8 位字节
			Key secretKey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(key.getBytes());
			AlgorithmParameterSpec paramSpec = iv;
			cipher.init(Cipher.DECRYPT_MODE, secretKey,paramSpec);
			return cipher.doFinal(data);
		} catch (Exception e){
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	/**
	 * 将接收的字符串转换成图片保存
	 * 
	 * @param imgStr
	 *            二进制流转换的字符串
	 * @param imgPath
	 *            图片的保存路径
	 * @param imgName
	 *            图片的名称
	 * @return 1：保存正常 0：保存失败
	 */
	public static int saveToImgByStr(String imgStr, String imgPath,
			String imgName) {
		try {
			System.out.println("=====imgPath===========>"+imgPath+"=====imgName======>"+imgName+ "===imgStr.length()====>" + imgStr.length() + "=====imgStr=====>" + imgStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int stateInt = 0;
		if (imgStr != null && imgStr.length() > 0) {
			try {
				// 将字符串转换成二进制，用于显示图片
				// 将上面生成的图片格式字符串 imgStr，还原成图片显示
				byte[] imgByte = hex2byte(imgStr);
				InputStream in = new ByteArrayInputStream(imgByte);
				//InputStream in = imgStr;
				File file = new File(imgPath, imgName);// 可以是任何图片格式.jpg,.png等
				if(file.exists()){
					//System.out.println("22222222");
					file.delete();
				}
				FileOutputStream fos = new FileOutputStream(file);
				byte[] b = new byte[1024];
				int nRead = 0;
				while ((nRead = in.read(b)) != -1) {
					//System.out.println("test====>"+nRead);
					fos.write(b, 0, nRead);
				}
				fos.flush();
				fos.close();
				in.close();
				stateInt = 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return stateInt;
	}

	/**
	 * 将二进制转换成图片保存
	 * 
	 * @param imgStr
	 *            二进制流转换的字符串
	 * @param imgPath
	 *            图片的保存路径
	 * @param imgName
	 *            图片的名称
	 * @return 1：保存正常 0：保存失败
	 */
	public static int saveToImgByBytes(File imgFile, String imgPath,
			String imgName) {
		int stateInt = 1;
		if (imgFile.length() > 0) {
			try {
				File file = new File(imgPath, imgName);// 可以是任何图片格式.jpg,.png等
				FileOutputStream fos = new FileOutputStream(file);
				FileInputStream fis = new FileInputStream(imgFile);
				byte[] b = new byte[1024];
				int nRead = 0;
				while ((nRead = fis.read(b)) != -1) {
					fos.write(b, 0, nRead);
				}
				fos.flush();
				fos.close();
				fis.close();
			} catch (Exception e) {
				stateInt = 0;
				e.printStackTrace();
			} finally {
			}
		}
		return stateInt;
	}

	/**
	 * 二进制转字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) // 二进制转字符串
	{
		StringBuffer sb = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1) {
				sb.append("0" + stmp);
			} else {
				sb.append(stmp);
			}
		}
		return sb.toString();
	}

	/**
	 * 字符串转二进制
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return 转换后的二进制数组
	 */
	public static byte[] hex2byte(String str) { // 字符串转二进制
		if (str == null)
			return null;
		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1)
			return null;
		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer
						.decode("0X" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}
	
	 /**
     * SMS短息发送方法(阿里大鱼)
     * @param d
     * @return
     */
    public static Map<String, String> SmsSendAl(String phone,Map<String, String> params,String smsCode){
		Map<String, String> srtMap = new HashMap<String, String>();
    	try {
			// 正式地址：http://gw.api.taobao.com/router/rest
			// 沙箱环境：http://gw.api.tbsandbox.com/router/rest
    		if(params != null && !smsCode.equals("")){
				String taoBaoUrl = Constant.taoBaoUrl;
				String taoBaoKey = Constant.taoBaoKey;
				String taoBaoSecret = Constant.taoBaoSecret;
				TaobaoClient client = new DefaultTaobaoClient(taoBaoUrl, taoBaoKey, taoBaoSecret, "json");
				AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
				req.setExtend("extend");
				req.setSmsType("normal");
				// 签名，需审核
				req.setSmsFreeSignName(Constant.taoBaoAiJiuZhu);
				// 以英文逗号分隔，一次调用最多传入200个号码
				req.setRecNum(phone);
				// 短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。示例：针对模板“验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！”，传参时需传入{"code":"1234","product":"alidayu"}
				req.setSmsParamString(JSON.toJSONString(params));
				// 模板ID，需审核
				req.setSmsTemplateCode(smsCode);
				AlibabaAliqinFcSmsNumSendResponse rsp;
				rsp = (AlibabaAliqinFcSmsNumSendResponse) client.execute(req);
				System.out.println(rsp.getBody());
				if(rsp.getSubCode()!= null){
					srtMap.put("success","false");		
				}else{
					srtMap.put("success",rsp.getResult().getSuccess().toString());
				}
				srtMap.put("msg", rsp.getBody());
    		}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return srtMap;
    }
    
    /**
     * 高德地图逆向地址api获取接口方法
     * @param location
     * @param key
     * @return
     */
    public static String addressToGPS(String location,String key) {  
    	String data = "";
        try {  
            String url = String .format("http://restapi.amap.com/v3/geocode/regeo?&output=json&location=%s&key=%s", location, key); 
            URL myURL = null; 
            URLConnection httpsConn = null; 
	    	try { 
	    		myURL = new URL(url); 
	    	} catch (MalformedURLException e) { 
	    		e.printStackTrace(); 
	    	} 
	    	InputStreamReader insr = null;
	    	BufferedReader br = null;
	    	httpsConn = (URLConnection) myURL.openConnection();// 不使用代理 
	    	if (httpsConn != null) { 
		    	insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8"); 
		    	br = new BufferedReader(insr); 
		    	String line = null; 
		    	while((line= br.readLine())!=null){
		    		data+=line;
		    	} 
		    	return data;
	    	}
        }catch (Exception e) {
        	e.printStackTrace(); 
		}
        return data;
    }
    
    
    public static String compilePhone(String phone){
    	String ss = phone.substring(0,phone.length()-(phone.substring(3)).length())+"****"+phone.substring(7); 
    	return ss;
    }
    
    /** 
     * MultipartFile 转换成File 
     *  
     * @param multfile 原文件类型 
     * @return File 
     * @throws IOException 
     *  
     */  
    public static File  multipartToFile(MultipartFile multfile) throws IOException {  
        CommonsMultipartFile cf = (CommonsMultipartFile)multfile;   
        //这个myfile是MultipartFile的  
        if(Utils.isNotNull(cf)){
        	DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        	if(Utils.isNotNull(fi)){
        		
        		File file = fi.getStoreLocation();  
        		//手动创建临时文件  
        		if(file.length() < 2048){  
        			File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +   
        					file.getName());  
        			multfile.transferTo(tmpFile);  
        			return tmpFile;  
        		}  
        		return file;  
        	}
        }
        return null;
    }  
}
