package com.zml.nekopara.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiNiuImageUploadUtil {

	// 设置好账号的ACCESS_KEY和SECRET_KEY
	public static String ACCESS_KEY;
	public static String SECRET_KEY ;
	// 要上传的空间
	public static String bucketname ;
	// 上传到七牛后保存的文件名
	// 上传文件的路径

	// 密钥配置
	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	// 创建上传对象
	UploadManager uploadManager = new UploadManager();
	//访问图片的url前缀+图片名称就可以访问
	public static String webUrlPrfix;

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public String getUpToken() {
		return auth.uploadToken(bucketname);
	}
	/**
	 * 静态代码块，初始化七牛配置文件
	 */
	static{
		Properties prop=new Properties();
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("qiniu.properties");
			prop.load(is);
			ACCESS_KEY=prop.getProperty("ACCESS_KEY");
			SECRET_KEY=prop.getProperty("SECRET_KEY");
			bucketname=prop.getProperty("bucketname");
			webUrlPrfix=prop.getProperty("webUrlPrfix");
		} catch (FileNotFoundException e) {
			System.out.println("七牛配置文件-->qiniu.properties未找到");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param file	需要上传的文件
	 * @param key	上传后保存的文件名
	 * @throws IOException
	 */
	public void upload(String file,String key) throws IOException {
		try {
			// 调用put方法上传
			Response res = uploadManager.put(file, key, getUpToken());
			// 打印返回的信息
			System.out.println(res.bodyString());
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			System.out.println(r.toString());
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
	}
	/**
	 * 
	 * @param file	需要上传的文件
	 * @param key	上传后保存的文件名
	 * @throws IOException
	 */
	public void upload(byte[] byteArray,String key) throws IOException {
		try {
			// 调用put方法上传
			Response res = uploadManager.put(byteArray, key, getUpToken());
			// 打印返回的信息
			System.out.println(res.bodyString());
		} catch (QiniuException e) {
			Response r = e.response;
			// 请求失败时打印的异常的信息
			System.out.println(r.toString());
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
	}
}
