package 扇風機;

import java.util.Scanner;

public class Fan {

	protected static byte sw; // スイッチ

	public static void main(String args[]) {
		Power power = new Power();
		AirFlow airFlow = new AirFlow();
		TimerSW timerSW = new TimerSW();
		Wings wings = new Wings();

		Scanner sc = new Scanner(System.in);

		/*
		1=>電源SW状態
		2=>風量SW状態
		3=>タイマーSW状態
		4=>終了SW状態

		True=>電源ON
		False=>電源OFF*/

		// !終了SW状態
		while (sw != 4) {
			System.out.print("①１ー＞電源SW、２ー＞風量SW、３－＞タイマーSW、4ー＞終了\nスイッチを選んで番号を入力してください:");
			sw = sc.nextByte();
			System.out.println("\n-------------------------------------------------------\n");

			// 終了SW状態
			if (sw == 4) {
				System.exit(0);
			}

			// タイマーリセットの場合
			if (timerSW.getTimerSW() == 3) {
				power.setPowerSW(false);
			}

			// 電源OFF
			if (power.getPowerSW() == false) {
				// ！電源SW状態
				while (sw != 1) {
					System.out.println("最初は電源SWを選んでください!");
					System.out.print("②１ー＞電源SW、２ー＞風量SW、３－＞タイマーSW、4ー＞終了\nスイッチを選んで番号を入力してください:");
					sw = sc.nextByte();
					System.out.println("\n-------------------------------------------------------\n");

					// 終了SW状態
					if (sw == 4) {
						System.exit(0);
					}
				}
			}

			// 電源SW状態
			if (sw == 1) {
				// 電源ON／OFF切り替える(ON=>OFF, OFF=>ON)

				// 電源ON
				if (power.getPowerSW() == false) {
					power.setPowerSW(true); // 電源ON
					airFlow.setAirFlowSW((byte) 2); // 風量中
					timerSW.setTimerSW((byte) 0); // 初期化のためにタイマーをOFF
					wings.wingsFun(airFlow.getAirFlowSW()); // 羽根を中で回す
				}
				// 電源OFF
				else {
					power.setPowerSW(false); // 電源OFF
					timerSW.setTimerSW((byte) 0); // タイマーOFF
					wings.wingsFun((byte) 0); // 羽根を停止する
				}
			}

			// 風量SW状態
			if (sw == 2) {
				// 押下するごとにサイクリックに切り替え出力(弱＝＞中＝＞強＝＞弱)

				// 風量弱
				if (airFlow.getAirFlowSW() == 1) {
					airFlow.setAirFlowSW((byte) 2);
					wings.wingsFun(airFlow.getAirFlowSW()); // 羽根を中で回す
				}
				// 風量中
				else if (airFlow.getAirFlowSW() == 2) {
					airFlow.setAirFlowSW((byte) 3);
					wings.wingsFun(airFlow.getAirFlowSW()); // 羽根を強で回す
				}
				// 風量強
				else if (airFlow.getAirFlowSW() == 3) {
					airFlow.setAirFlowSW((byte) 1);
					wings.wingsFun(airFlow.getAirFlowSW()); // 羽根を弱で回す
				}
			}

			// タイマーSW状態
			if (sw == 3) {
				// 押下するごとにサイクリックに切り替える(OFF＝＞1時間＝＞2時間＝＞OFF)

				// タイマーOFF
				if (timerSW.getTimerSW() == 0) {
					timerSW.setTimerSW((byte) 1);
				}
				// タイマー1時間
				else if (timerSW.getTimerSW() == 1) {
					timerSW.setTimerSW((byte) 2);
				}
				// タイマー2時間
				else if (timerSW.getTimerSW() == 2) {
					timerSW.setTimerSW((byte) 0);
				}

				timerSW.timerSetting();
				// タイマーOFFにする場合
				if (timerSW.getTimerSW() == 0) {
					System.out.println("タイマーをOFFに設定されます。");
				}

			}

		}
	}

}
