package com.util;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.air_condition.dao.EquipmentMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description 
 * @author 
 *
 */
public class SpringQtz {
	@Autowired
	private DataUtil dataUtil;
	
	//产生随机警告事件
	protected void produceEvent_Inform() {
		dataUtil.produceEvent_Inform();
	}
	
	//产生设备运行数据
	protected void produceEqData(){
		dataUtil.produceEqData();
	}
	//产生设备维修数据
	protected void produceEqRepairData(){
		dataUtil.produceEqRepairData();
	}

	
	
}
