package 扇風機;

public class Wings {

	void wingsFun(byte temp)
	{
		/*1=>風量弱
		  2=>風量中
		  3=>風量強
		  それ以外=>羽根を停止、電源OFF*/

		if(temp==1){
			System.out.println("羽根を風量弱で回します。\n");
		}
		else if(temp==2)
		{
			System.out.println("羽根を風量中で回します。\n");
		}
		else if(temp==3)
		{
			System.out.println("羽根を風量強で回します。\n");
		}
		else
		{
			System.out.println("羽根を停止します。");
			System.out.println("電源をOFFにします。\n");
		}
	}
}
