package owa.com.common.util;

import java.util.UUID;

/***
 * 自动生成数据库表的主键
 * @author yangjinbao
 *
 */
public class UUIDRandom {
	public static String getUUID() {
		String uuid = "";
		UUID id = UUID.randomUUID();
		uuid = id.toString();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}
			
}
