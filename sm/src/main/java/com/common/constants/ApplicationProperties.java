package com.common.constants;

/**
 * 此类统一维护application.properties值的映射<br> 
 * application.properties的key请按照xxx.xxxx的格式编写<br> 
 * 对应的在此类只需按照驼峰结构改写 定义xxxXxxx即可完成资源文件到java的映射<br> 
 * example：资源文件中定义reskeeper.address
 * 此处只需写一条 public static String reskeeperAddress;这样的语句即可；
 * <br> 
 * 〈功能详细描述〉
 *
 * @author 14031966
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ApplicationProperties {
	
	/**
	 * 环境，dev、test、prd
	 */
	public static String  envMark;
	
	//js版本号
	public static String  jsVersion;
	
	public static String  goodsServer;
	
	public static String  messageServer;
	
	public static String  ipsServer;
	
	/**
	 * 微信公共账号appid
	 */
	public static String  wxPublicAppid;
	/**
	 * 微信公共账号secret
	 */
	public static String  wxPublicSecret;
	/**
	 * 订单地址
	 */
	public static String orderServer;
	
	/**
	 * 财务服务
	 */
	public static String financeServer ;
	/**
	 * 商品详情
	 */
	public static String payServer;
	/**
	 * buyer.order
	 */
	public static String buyerOrder;
	
	public static String paternerKey;
	
}
