package 扇風機;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerSW {

	private byte timerSW;

	//タイマーの状態をもらうため
	public byte getTimerSW() {
		return timerSW;
	}
	//タイマーの状態を入れるため
	public void setTimerSW(byte timerSW) {
		this.timerSW = timerSW;
	}

	byte time;
	int timeLeft;

	public void timerSetting() {

		Wings wingsTimerSW = new Wings();
		Power powerTimerSW = new Power();
		Timer timer = new Timer();
		time = getTimerSW();

		/*
		0=>タイマーOFF
		1=>タイマー１時間
		2=>タイマー2時間
		3=>タイマーリセット*/

		if (getTimerSW() == 1) {
			System.out.println("タイマーを1時間に設定されます。\n");
			// テストのために数秒を設定しました。
			timeLeft = time * 10;
			// 実際の操作ため
			// timeLeft=3600;
			TimerTask timerTask1 = new TimerTask() {
				@Override
				public void run() {
					//タイマー１時間設定中に2時間設定するため
					if (time == 2) {
						timer.cancel();
					}

					// 残り時間0ではない場合
					else if (timeLeft != 0 && getTimerSW() != 0) {
						System.out.println("\n" + timeLeft);
						timeLeft--;
					}

					// 残り時間0の場合
					else if ((timeLeft == 0 && getTimerSW() == 1) || (timeLeft == 0 && getTimerSW() == 2)) {
						powerTimerSW.setPowerSW(false);
						setTimerSW((byte) 3);
						System.out.println("\n羽根を停止します。");
						System.out.println("電源をOFFにします。");
						timer.cancel();
					}
					// タイマーSWはOFFの場合
					else if (getTimerSW() == 0 && timeLeft != 0) {
						timer.cancel();
					}
				};
			};
			//１秒
			timer.scheduleAtFixedRate(timerTask1, new Date(), 1000);
		} else if (getTimerSW() == 2) {
			System.out.println("タイマーを2時間に設定されます。\n");
			// テストのために数秒を設定しました。
			timeLeft = time * 10;
			// 実際の操作ため
			// timeLeft=7200;
			TimerTask timerTask2 = new TimerTask() {
				@Override
				public void run() {

					// 残り時間0ではない場合
					if (timeLeft != 0 && getTimerSW() != 0) {
						System.out.println("\n" + timeLeft);
						timeLeft--;
					}

					// 残り時間0の場合
					else if ((timeLeft == 0 && getTimerSW() == 1) || (timeLeft == 0 && getTimerSW() == 2)) {
						powerTimerSW.setPowerSW(false);
						setTimerSW((byte) 3);
						System.out.println("\n羽根を停止します。");
						System.out.println("電源をOFFにします。");
						timer.cancel();
					}
					// タイマーSWはOFFの場合
					else if (getTimerSW() == 0 && timeLeft != 0) {
						timer.cancel();
					}
				};
			};
			//１秒
			timer.scheduleAtFixedRate(timerTask2, new Date(), 1000);
		}
	}
}
