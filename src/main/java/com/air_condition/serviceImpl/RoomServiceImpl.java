package com.air_condition.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.air_condition.dao.RoomMapper;
import com.air_condition.domain.Room;
import com.air_condition.service.RoomServiceI;
@Service
public class RoomServiceImpl implements RoomServiceI {
	
	@Autowired
	private RoomMapper roomDao;
	
	public List<Map<String, Object>> getAllRooms() {
		// TODO Auto-generated method stub
		return roomDao.getAllRooms();
	}

	public int addNewRoom(Room room) {
		// TODO Auto-generated method stub
		return roomDao.insertSelective(room);
	}

	public int updateRoomInfo(Room room) {
		// TODO Auto-generated method stub
		return roomDao.updateByPrimaryKeySelective(room);
	}

	public int delRoomById(int room_num) {
		// TODO Auto-generated method stub
		return roomDao.deleteByPrimaryKey(room_num);
	}

	public int closeRoom(Room room) {
		// TODO Auto-generated method stub
		return roomDao.updateByPrimaryKeySelective(room);
	}

	public Map<String, Object> getGetRoomInfoById(Integer room_num) {
		// TODO Auto-generated method stub
		return roomDao.getGetRoomInfoById(room_num);
	}

	
	
	

}
