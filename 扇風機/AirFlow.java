package 扇風機;

public class AirFlow {
	private byte airFlowSW;

	//風量の状態をもらうため
	public byte getAirFlowSW() {
		return airFlowSW;
	}
	//風量の状態を入れるため
	public void setAirFlowSW(byte i) {
		this.airFlowSW = i;
	}
}
