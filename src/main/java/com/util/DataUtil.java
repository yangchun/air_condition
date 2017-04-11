package com.util;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air_condition.dao.EquipmentMapper;
import com.air_condition.dao.Equipment_DataMapper;
import com.air_condition.dao.Event_InformMapper;
import com.air_condition.domain.Equipment_Data;
import com.air_condition.domain.Event_Inform;
@Service
public class DataUtil {
	@Autowired
	private Event_InformMapper event_informDao;
	@Autowired
	private EquipmentMapper equipmentDao;
	@Autowired
	private Equipment_DataMapper equipmentdataDao;
	
	Random rand=new Random();
	//产生随机警告事件通知
	public void produceEvent_Inform(){
		String[] warning_desc={"温度太高","功率过大"};
		String[] grade={"一级","二级"};
		List<Map<String,Object>> eqs=equipmentDao.getAllEqs();
		Map<String,Object> eq=eqs.get(rand.nextInt(eqs.size()));
		Event_Inform event_inform=new Event_Inform();
		event_inform.setDesc(warning_desc[rand.nextInt(2)]);
		event_inform.setGrade(grade[rand.nextInt(2)]);
		event_inform.setInformtime(new Date());
		event_inform.setState(String.valueOf(rand.nextInt(2)));
		event_inform.setEqid((Integer)eq.get("id"));
		event_inform.setEqname((String)eq.get("eqname"));
		event_informDao.insertSelective(event_inform);
	}
	
	//产生设备运行数据
	public void produceEqData(){
		List<Map<String,Object>> eqs=equipmentDao.getAllEqs();
		Map<Integer,Map<String,String>> datas=new HashMap<Integer,Map<String,String>>();
		//主机参数
		Map<String,String> eq1=new HashMap();
		eq1.put("主机运行状态", "/");
		eq1.put("累计运行时间", String.valueOf(rand.nextInt(1000)+5000)+"h");
		eq1.put("累计起停次数", String.valueOf(rand.nextInt(10)+2)+"次");
		eq1.put("累计运行能耗", String.valueOf(rand.nextInt(5000)+10000)+"W");
		eq1.put("当前运行主机数", "1台");
		eq1.put("COP", String.valueOf(rand.nextInt(40)+60)+"%");
		datas.put(1, eq1);
		//冷却塔1
		Map<String,String> eq2=new HashMap();
		eq2.put("累计运行时间", String.valueOf(rand.nextInt(1000)+5000)+"h");
		eq2.put("累计起停次数", String.valueOf(rand.nextInt(10)+2)+"次");
		eq2.put("当前功率", String.valueOf(rand.nextInt(5000)+10000)+"W");
		eq2.put("累计运行能耗", String.valueOf(rand.nextInt(5000)+10000)+"W");
		eq2.put("出水温度", String.valueOf(rand.nextInt(50)+50)+"℃");
		eq2.put("入水温度", String.valueOf(rand.nextInt(10))+"℃");
		datas.put(2, eq2);
		//冷却塔1
		Map<String,String> eq3=new HashMap();
		eq3.put("累计运行时间", String.valueOf(rand.nextInt(1000)+5000)+"h");
		eq3.put("累计起停次数", String.valueOf(rand.nextInt(10)+2)+"次");
		eq3.put("累计运行能耗", String.valueOf(rand.nextInt(5000)+5000)+"W");
		eq3.put("当前功率", String.valueOf(rand.nextInt(5000)+10000)+"W");
		eq3.put("出水温度", String.valueOf(rand.nextInt(50)+50)+"℃");
		eq3.put("入水温度", String.valueOf(rand.nextInt(10))+"℃");
		datas.put(3, eq3);
		//冷冻水泵1
		Map<String,String> eq4=new HashMap();
		int sendwater=rand.nextInt(5)+5;
		eq4.put("冷冻水送水温度", String.valueOf(sendwater)+"℃");
		int returnwater=rand.nextInt(5)+20;
		eq4.put("冷冻水回水温度", String.valueOf(returnwater)+"℃");
		eq4.put("累计运行时间", String.valueOf(rand.nextInt(1000)+5000)+"h");
		eq4.put("累计起停次数", String.valueOf(rand.nextInt(10)+2)+"次");
		eq4.put("累计运行能耗", String.valueOf(rand.nextInt(5000)+5000)+"W");
		eq4.put("冷冻水回水温差", String.valueOf(returnwater-sendwater)+"℃");
		eq4.put("冷冻水泵出水压力", String.valueOf(rand.nextInt(5)+1)+"Mpa");
		eq4.put("冷冻水泵工作频率", String.valueOf(rand.nextInt(30)+30)+"Hz");
		datas.put(4, eq4);
		//冷冻水泵2
		Map<String,String> eq5=new HashMap();
		int sendwater2=rand.nextInt(5)+5;
		eq5.put("冷冻水送水温度", String.valueOf(sendwater2)+"℃");
		int returnwater2=rand.nextInt(5)+20;
		eq5.put("冷冻水回水温度", String.valueOf(returnwater2)+"℃");
		eq5.put("累计运行时间", String.valueOf(rand.nextInt(1000)+5000)+"h");
		eq5.put("累计起停次数", String.valueOf(rand.nextInt(10)+2)+"次");
		eq5.put("累计运行能耗", String.valueOf(rand.nextInt(5000)+5000)+"W");
		eq5.put("冷冻水回水温差", String.valueOf(returnwater2-sendwater2)+"℃");
		eq5.put("冷冻水泵出水压力", String.valueOf(rand.nextInt(5)+1)+"Mpa");
		eq5.put("冷冻水泵工作频率", String.valueOf(rand.nextInt(30)+30)+"Hz");
		datas.put(5, eq5);
		//冷却泵1
		Map<String,String> eq6=new HashMap();
		eq6.put("当前功率", String.valueOf(rand.nextInt(500)+500)+"W");
		eq6.put("当前温度", String.valueOf(rand.nextInt(50)+50)+"℃");
		eq6.put("累计运行时间", String.valueOf(rand.nextInt(1000)+5000)+"h");
		eq6.put("累计起停次数", String.valueOf(rand.nextInt(10)+2)+"次");
		eq6.put("累计运行能耗", String.valueOf(rand.nextInt(5000)+5000)+"W");
		eq6.put("入水温度", String.valueOf(rand.nextInt(10)+10)+"℃");
		eq6.put("出水温度", String.valueOf(rand.nextInt(10)+30)+"℃");
		datas.put(6, eq6);
		//冷却泵2
		Map<String,String> eq7=new HashMap();
		eq7.put("当前功率", String.valueOf(rand.nextInt(500)+500)+"W");
		eq7.put("当前温度", String.valueOf(rand.nextInt(50)+50)+"℃");
		eq7.put("累计运行时间", String.valueOf(rand.nextInt(5000)+5000)+"h");
		eq7.put("累计运行能耗", String.valueOf(rand.nextInt(5000)+5000)+"W");
		eq7.put("入水温度", String.valueOf(rand.nextInt(10)+10)+"℃");
		eq7.put("出水温度", String.valueOf(rand.nextInt(10)+30)+"℃");
		datas.put(7, eq7);
		//风机盘管
		Map<String,String> eq8=new HashMap();
		eq8.put("风量", String.valueOf(rand.nextInt(500)+500)+"m³/h");
		eq8.put("冷量", String.valueOf(rand.nextInt(500)+1500)+"W");
		eq8.put("热量", String.valueOf(rand.nextInt(1000)+2000)+"W");
		eq8.put("当前功率 ", String.valueOf(rand.nextInt(100)+500)+"W");
		eq8.put("当前温度", String.valueOf(rand.nextInt(10)+30)+"℃");
		eq8.put("累计运行时间", String.valueOf(rand.nextInt(5000)+5000)+"h");
		eq8.put("累计运行能耗", String.valueOf(rand.nextInt(5000)+5000)+"W");
		datas.put(8, eq8);
		//空气处理器
		Map<String,String> eq9=new HashMap();
		eq9.put("当前功率 ", String.valueOf(rand.nextInt(400)+500)+"W");
		eq9.put("当前温度", String.valueOf(rand.nextInt(10)+30)+"℃");
		eq9.put("累计运行时间", String.valueOf(rand.nextInt(5000)+8000)+"h");
		eq9.put("累计运行能耗", String.valueOf(rand.nextInt(5000)+9000)+"W");
		datas.put(9, eq9);
		
		
		Map<String,Object> eq=eqs.get(rand.nextInt(eqs.size()));
		int eqid=(Integer)eq.get("id");
		String eqname=(String)eq.get("eqname");
		Map<String,String> parms=datas.get(eqid);
		Iterator<Map.Entry<String, String>> it = parms.entrySet().iterator();
		while (it.hasNext()) {
			 Equipment_Data eqdata=new Equipment_Data();
			 eqdata.setEqid(eqid);
			 eqdata.setEqname(eqname);
			 eqdata.setRecordtime(new Date());
		     Map.Entry<String, String> entry = it.next();
		     eqdata.setEqparm(entry.getKey());
		     eqdata.setEqvalue(entry.getValue());
		     if(entry.getValue().equals("主机运行状态")){
		    	 eqdata.setEqstate("ON");
		     }else{
		    	 eqdata.setEqstate("正常");
		     }
		     eqdata.setVersion(String.valueOf(new Date()));
		     equipmentdataDao.insertSelective(eqdata);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
