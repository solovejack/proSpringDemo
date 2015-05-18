package com.demo.util;

import java.util.UUID;

/**
 * 公用方法
 * 
 * @author lijie
 * 
 */
public class UtilMethod {
	public static String SENDFLAG_A = "A";//未发送
	public static String SENDFLAG_B = "B";//已发送
	
	public static String READFLAG_A = "A";//未阅读
	public static String READFLAG_B = "B";//已阅读
	
	/** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
    public static String getUUID(){ 
        return  UUID.randomUUID().toString().replace("-", ""); 
    } 
}
