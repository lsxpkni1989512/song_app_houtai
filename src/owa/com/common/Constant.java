package owa.com.common;

/**
 * @ClassName: Constant
 * @package org.unbank.platform.web.action.client
 * @Description: 常用变量类
 * @author 蒋博
 * @date 2015-11-04 下午2:42:37
 * @version V1.0
 */

public class Constant {

	
	//极光推送
	/** 极光推送急救柜的key*/ 
	//public static String appKey = "148cb237ec62fc3239003c2f";  
	public static String appKey = "a9f7d307e40da09951cca7ab";
	/** 极光推送急救柜的masterSecret*/
	//public static String masterSecret = "cb259678240807330cbe38d8";
	public static String masterSecret = "d50c3502ef55efa6e9b3da06";
	/** 极光推送app的key*/
	public static String app_Key = "af535a1557df5e0aa43af414";
	/** 极光推送app的masterSecret*/ 
	public static String app_masterSecret = "38eb1661de34df19db6f6861";
	
	
	//用户登录标记
	/** 客户类型（普通用户）*/
	public static String ordinary_users = "ptyh";
	/** 客户类型（志愿者）*/
	public static String volunteer = "zyz";
	/** 客户类型（配货员）*/
	public static String distribution_member = "phy";
	/** 登录成功标记*/
	public static String login_success = "1";
	/** 用户不存在标记*/
	public static String no_user = "0";
	/** 密码错误标记*/
	public static String pwd_error = "-1";
	/** 已登录标记*/
	public static String login = "1";
	/** 未登录标记*/
	public static String logout = "0";
	/** 用户信息不完整可领取物品数量*/
	public static int user_submit_order_restriction = 1;
	/** 用户连续领取物品天数*/
	public static int user_continuous_collection_of_items = 3;
	/** 用户每天领取同一物品次数*/
	public static int number_of_users_per_day = 1;
	/** 可以领取*/
	public static int can_receive = 1;
	/** 不可领取 */
	public static int can_not_receive = 0;
	//用户订单状态
	/** 用户无订单 */
	public static String no_order = "0";
	/** 用户订单物品等待领取 */
	public static String  waiting_to_receive  = "1";
	/** 用户订单物品已领取 */
	public static String  already_receive = "2";
	/** 用户订单物品未归还 */
	public static String not_returned = "3";
	/** 用户订单已归还 */
	public static String already_returned  = "4";
	
	/** 没有维护完整信息*/
	public static int user_information_is_not_complete = 2;
	/** 超出每天领取次数*/
	public static int beyond_the_number_of_times_per_day = 3;
	/** 超出连续n天领取同一物品次数*/
	public static int exceed_the_number_of_consecutive_times = 4;
	/** 用户没有维护身份证信息，无法领取医疗器械 */
	public static int user_identity_is_not_complete = 5;
	/** 分页查询每页记录数*/
	public static int page_number = 12;
	/** 用户住址类型 */
	/** 现住址 */
	public static String user_present_address = "1"; 
	/** 户籍地址 */
	public static String user_permanent_address = "2"; 
	
	//文章收藏标记
	/** 已收藏*/
	public static String already_collected = "1";
	/** 未收藏*/
	public static String not_collecting = "0";
	
	
	//物品相关
	/** 医疗器械类型*/
	public static String instrument = "A";
	/** 药品类型*/
	public static String goods = "B";
	/** 医疗器械未领取状态*/
	public static String instrument_not_receiving = "1";
	/** 医疗器械已领取状态*/
	public static String instrument_have_received = "0";
	/** 医疗器械无效状态*/
	public static String instrument_Invalid = "-1";
	
	
	//器械类型
	/** 除颤仪*/
	public static String defibrillator = "A-AED";
	/** 轮椅*/
	public static String wheelchair = "A-WCHR";
	/** 担架*/
	public static String stretcher = "A-STR";
	
	
	//订单相关 
	/** 订单状态（1:已预定）*/
	public static String order_has_been_scheduled = "1";
	/** 订单状态（2:已领取）*/
	public static String order_have_received = "2";
	/** 订单状态（-1:过期）*/
	public static String order_be_overdue = "-1";
	/** 订单状态（4:未归还）*/
	public static String order_did_not_return = "4";
	/** 订单状态（6:已归还）*/
	public static String order_return = "6";
	/** 订单状态（-2:领取失败）*/
	public static String order_receive_failure = "-2";
	/** 订单领取成功*/
	public static String order_receive_success = "1";
	/** 订单领取未成功*/
	public static String order_receive_no_success = "0";	
	/** 器械归还期限（天）*/
	public static int daysLater = 1;
	/** 器械已归还*/
	public static String successful_return = "2";
	

	//用户相关
	/** 用户启用*/
	public static String user_enabled = "1";
	/** 用户禁用*/
	public static String user_disabled = "0";
	
	
	
	//instruction急救柜接口操作标识参数
	/** 1000测试客户端状态 客户端收到后返回状态信息*/
	public static String instruction_1000 = "1000";
	/** 1001客户要提取急救物品*/
	public static String instruction_1001 = "1001";
    /** 1002 通知客户端有广告文件要下载*/
	public static String instruction_1002 = "1002";
	/** 1003 通知客户端要进行配货*/
	public static String instruction_1003 = "1003";
	
	/**
	 * minutesLater领取码失效时限（分钟）
	 */
	public static int minutesLater = 1;
	
	/**
	 * minutesLater领取码失效时限（秒）
	 */
	public static int secondLater = 300;
	
	/**
	 * nearby_range坐标点附近范围(米)
	 */
	public static double nearby_range = 1000;
	
	/**
	 * radius_of_the_earth 地球半径(米)
	 */
	public static double radius_of_the_earth = 6371229;
	
	/**
	 * PI 圆周率
	 */
	public static double PI = 3.14159265358979323;
	

	//救助记录状态
	/** 救助中*/
	public static String rescue = "0";
	/** 完成救助*/
	public static String manual_end = "1";
	/** 自动救助*/
	public static String auto_end = "2";
	
	
	//实名认证相关
	/** 实名认证接口帐号*/
	public static String real_name_interface_account = "chenbangwenhua1";
	/** 实名验证接口密码*/
	public static String real_name_interface_password = "chenbangwenhua1_2GEGh0p^";
	/** 实名验证接口数据类型*/
	public static String real_name_interface_data_type = "1A020201";
	/** 实名验证加密key*/
	public static String real_name_pwd_key = "12345678";
	/** 实名验证接口开关*/
	public static int real_name_interface_switch = 1;
	/** 有效实名认证记录标记*/
	public static String real_name_status_true = "1";
	/** 无效实名认证记录标记*/
	public static String real_name_status_false = "0";
	
	//参与救助方式
	/** 开始救助*/
	public static String start_rescue = "1";
	/** 立即前往*/
	public static String immediately_go = "2";
	/** 语音通话*/
	public static String voice_calls = "3";
	/** 结束救助*/
	public static String end_rescue = "4";
	/** 立即前往消息*/
	//public static String immediately_go_msg = "有志愿者正在前往，请不要随便移动位置！";
	/** 志愿者协助类型标记*/
	public static String volunteer_assistance = "assist";
	/** 删除事件标记*/
	public static String del_event = "event";
	/** 删除订单标记*/
	public static String del_order = "order";
	
	
	//活动相关
	/** 活动类型-免费*/
	public static String free_activity = "免费";
 	/** 活动类型-招募*/
	public static String recruitment_activity = "招募";
	
	
	//配送相关参数
	/** 补满参数*/
	public static int fill_the_number = 37;
	/** 物品存量过低警戒线*/
	public static int alert_value = 15;
	/** 配送物品状态 not_assigned_personnel 未分配人员*/
	public static String not_assigned_personnel = "0";
	/** 配送物品状态 waiting_for_delivery 等待配送*/
	public static String waiting_for_delivery = "1";
	/** 配送物品状态 distribution_completion 配送完成*/
	public static String distribution_completion = "2";
	/** 已补满*/
	public static String filled = "1";	
	/** 未补满*/
	public static String not_filled = "0";
	
	//服务器链接配置
	/** 后台管理系统url*/
	//public static String cms_url = "http://cms.chenbund.com";//正式环境地址
	public static String cms_url = "http://tst.chenbund.com";//测试环境地址
	
	/**  接口系统url*/
	//public static String app_url = "http://api.chenbund.com";//正式环境地址
	public static String app_url = "http://test.chenbund.com";//测试环境地址
	
	/** 领取物品时不受限制的用户，暂时处理方式，如以后都会存在这个方式，则在用户表增加标识字段。*/
	//public static String [] unrestricted_user = {"15801235768","13716140933","18510364537","13511061341","18610221238","13581670280","13581665943","13501121681"};
	
	
	//文章类型
	/** 家庭医生*/
	public static String family_doctor = "jtys";
	/** 急救知识*/
	public static String first_aid_knowledge = "jjzs";
	
	//消息中心相关参数
	/** 消息类型*/
	public static String message_center = "mc";
	
	//消息菜单类型
	/** 系统类消息*/
	public static String system_msg = "system_msg";
	/** 市场活动类消息*/
	public static String market_msg = "market_msg";
	/** 急救类消息*/
	public static String aid_msg = "aid_msg";
	
	//消息类别
	/** 紧急救助*/
	public static String emergency_rescue = "rescue";
	/** 领用协助*/
	public static String receive_assistance = "assist";
	
	
	//头像上传
	/** 头像上传路径 */
	public static String head_portrait_path = "/upload/images/head_portrait/";
	
	
	//积分相关
	/** 类型——>获得积分 */
	public static String get_points = "obtain";
	/** 类型——>使用积分 */
	public static String use_integral  = "use";
	/** 连续签到天数 */
	public static String ca_sign_days = "4";
	//获得
	/** 获取积分方式——>签到 */
	public static String get_sign = "sign";
	/** 获得积分方式——>签到描述 */
	public static String get_sign_remark = "签到领取";
	/** 获得积分方式——>连续签到 */
	public static String get_ca_sign = "ca_sign";
	/** 获得积分方式——>连续签到描述 */
	public static String get_ca_sign_remark = "连续签到";
	/** 获取积分方式——>物品领用 */
	public static String get_receive = "receive";
	/** 获得积分方式——>物品领用描述 */
	public static String get_receive_remark = "物品领用";
	/** 获取积分方式——>物品归还 */
	public static String get_return = "return";
	/** 获得积分方式——>物品归还描述 */
	public static String get_return_remark = "物品归还";
	/** 获取积分方式——>问答奖励 */
	public static String get_QA = "QA";
	/** 获得积分方式——>问答奖励描述 */                                                    
	public static String get_QA_remark = "问答奖励";
	/** 获得积分方式——>返还商品积分 */
	public static String get_return_integral = "return_integral";
	/** 获得积分方式——>返还商品积分描述 */                                                    
	public static String get_return_integral_remark = "返还积分";
	/** 获得积分方式——>分享 */
	public static String get_share = "share";
	/** 获得积分方式——>分享 描述*/                                                    
	public static String get_share_remark = "分享";
	/** 获得积分方式——>完善用户信息 */
	public static String get_information = "information";
	/** 获得积分方式——>完善用户信息描述 */                                                    
	public static String get_information_remark = "完善信息";
	
	
	//使用
	/** 积分消费方式 */
	public static String use_change = "change";
	/** 积分消费方式——>描述 */
	public static String use_change_remark = "商城消费";
	
	/** 签到背景图片地址 */
	public static String sign_pic = "sign_pic.gif";
	/** 连续签到背景图片地址 */
	public static String ca_sign_pic = "ca_sign_pic.gif";
	
	//知识问答相关
	/** 知识问答类型 ——每日答题*/
	public static String wd_type_mrdt = "wd_mrdt";
	
	
	
	//SMS配置
	/** 阿里大鱼 */
	/** 阿里大鱼url*/
	//测试环境
	//public static String taoBaoUrl = "http://gw.api.tbsandbox.com/router/rest";
	//正式环境
	public static String taoBaoUrl = "http://gw.api.taobao.com/router/rest";
	/** 阿里大鱼appkey */
	public static String taoBaoKey = "23386763";
	/** 阿里大鱼 Secret*/
	public static String taoBaoSecret = "3d399364ea5af09ed33da924d4f2dfda";
	/** 爱救助签名 */
	//public static String taoBaoAiJiuZhu = "爱救助";
	public static String taoBaoAiJiuZhu = "辰邦急救";
	
	//SmsType 短信模版类型
	/** 模版类型 ——> 需要调度配送员 */
	public static String taoBaoTemTypeDistribution  = "distribution";
	/** 模版编号 ——> 需要调度配送员 */
	public static String taoBaoTemCodeDistribution  = "SMS_10617380";
	
	/** 模版类型 ——> 通知配送员补货  */
	public static String taoBaoTemTypeReplenishment  = "replenishment";
	/** 模版编号 ——> 通知配送员补货  */
	public static String taoBaoTemCodeReplenishment  = "SMS_10692094";
	
	/** 模版类型 ——> 到期归还提醒 */
	public static String taoBaoTemTypeRemind  = "remind";
	/** 模版编号 ——> 到期归还提醒 */
	public static String taoBaoTemCodeRemind  = "SMS_10805734";
	
	/** 模版类型 ——>领取医疗器械  */
	public static String taoBaoTemTypeReceive  = "receive";
	/** 模版编号 ——>领取医疗器械  */
	public static String taoBaoTemCodeReceive  = "SMS_11015081";
	
	/** 模版类型 ——>给紧急联系人发送短信 */
	public static String taoBaoTemTypeHelp  = "help";
	/** 模版编号 ——>给紧急联系人发送短信 */
	public static String taoBaoTemCodeHelp  = "SMS_10845720";
	
	/** 模版类型 ——>验证码 */
	public static String taoBaoTemTypeVerify  = "code";
	/** 模版编号 ——>验证码 */
	public static String taoBaoTemCodeVerify  = "SMS_10682004";
	
	
	
	//客服电话 400
	/** 400 */
	public static String customerServiceTelephone = "4008155959";
	
	//系统用户相关
	/** 系统用户角色 */
	/** 用户类型 (物流调度员) */
	public static String sys_role_dispatcher = "dispatcher";
	
	
	//高德地图webApi接口相关
	/** 高德地图webApiKey */
	public static String amap_webapi_key = "332778fcbaab836ec374ecb55eb0fcd4";
	
	//获取验证码参数
	/** 验证码第一位 */
	public static int  verification_code_one = 3; 
	/** 验证码第二位 */
	public static int  verification_code_two = 5; 
	/** 验证码第三位 */
	public static int  verification_code_three = 8; 
	/** 验证码第四位 */
	public static int  verification_code_four = 10; 
	
	
	//经验和等级相关
	//获得经验
	/** 获得经验 ——>答题_编号*/
	public static String exp_zswd_code = "zswd";
	/** 获得经验——>答题——名称 */
	public static String exp_zswd_name = "知识问答";

	
	//徽章相关
	/** 等级徽章 ——编号*/
	public static String grade_badge_code = "grade";
	/** 等级徽章——名称 */
	public static String grade_badge_name = "等级徽章";
	
	//升级有关
	/** 升级-经验 ——编号*/
	public static String up_exp_code = "upExp";
	/** 升级-经验——名称 */
	public static String up_exp_name = "获得经验";
	
	/** 升级-等级——编号 */
	public static String up_lv_code = "upLv";
	/** 升级-等级——名称 */
	public static String up_lv_name = "等级提升";
	
	//api参数加密是否开启
	/** 开启加密 */
	//public static String encrypt_api_start = "1";
	/** 关闭加密 */
	public static String encrypt_api_start = "0";
}
