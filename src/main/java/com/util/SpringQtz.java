package com.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description 定时器任�?,每隔�?分钟执行�?�?,查找order_state=1的订�?,order_creat_time
 * @author gr
 *
 */
public class SpringQtz {
	

	//课程添加
	protected void execute() {
		System.out.println("45分钟�?始关闭订�?....");
	}
	
	
	
	//修改未确认的订单
	public void updateUnConfirmOrder(){
	System.out.println("-------------");
	}
	
	
}
