package HotelHDBCTest;

public class HotelVO {
	private int roomNo;
	private String name;
	
	public HotelVO() {
		
	}
	public HotelVO(int roomNo, String name) {
		this.roomNo = roomNo;
		this.name = name;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
