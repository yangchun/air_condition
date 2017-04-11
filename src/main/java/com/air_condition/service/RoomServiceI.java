package com.air_condition.service;
import java.util.*;

import com.air_condition.domain.Room;
public interface RoomServiceI {
	
	public List<Map<String,Object>> getAllRooms();
	public int addNewRoom(Room room);
	public int updateRoomInfo(Room room);
	public int delRoomById(int room_num);
	public int closeRoom(Room room);
	Map<String,Object> getGetRoomInfoById(Integer room_num);	

}
