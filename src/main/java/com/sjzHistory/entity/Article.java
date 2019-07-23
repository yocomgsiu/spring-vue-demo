package com.sjzHistory.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

/**
 * 每篇报道、新闻
 * Created by Yocomg on 2019/7/21.
 */
@Data
@Entity
@ToString
public class Article {
	// 主键 自增
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; // 主键 自增
	// 唯一 非空
	private String title;
	// 内容
	private String content;
	// 事件发生时间
	private long eventTime;
	// 事件发生时间精确程度，0:精切到天;1:精确到月;2:精确到年
	private int accuracy;
//	long getTime( )
//	返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
//		void setTime(long time)
//	用自1970年1月1日00:00:00 GMT以后time毫秒数设置时间和日期。
	
	// 图片1URL
	private String pic1Url;
	// 图片1名
	private String pic1Name;
	// 图片2URL
	private String pic2Url;
	// 图片2名
	private String pic2Name;
	// 图片3URL
	private String pic3Url;
	// 图片4名
	private String pic3Name;
	
	// 初始作者id
	private long authorId;
	// 初始作者id
	private String authorName;
	// 初始作者id
	private String authorMail;
	// 创建时间
	private long createdTime;

	// 修改人者id
	private long modifierId;
	// 修改人者id
	private String modifierName;
	// 修改人者id
	private long modifierMail;
	

}
