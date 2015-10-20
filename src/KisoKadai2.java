import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 
 */

/**
 * @author internous
 *
 */
public class KisoKadai2 {
	public static void main(String[] args) {
		System.out.println("High&Low GAME");

		int x;
		int cnt=1;

		// 正解の設定
		// Randomクラスのインスタンス化
		Random rnd = new Random();

		int ran = rnd.nextInt(100)+1;
		
		// 完成したら消す
		System.out.println(ran);
		
		System.out.println("<1回目>");

		// 数字の入力
		while (true) {
			System.out.print("1～100までの数字を入れてください: ");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			try {
				String buf = br.readLine();
				x = Integer.parseInt(buf);
				if (x > 100 || x < 1) {
					System.out.println("※1～100までの数字でお願いします");
					continue;
					//↑この後にまたwhile文の頭から開始させたいけどやり方がわからない・・・
					//→continue;でできました！
				}
			} catch (Exception e) {
				System.out.println("※数字以外が入っています");
				continue;
				//こっちにもこの後にwhile文の頭から開始させたい
				//あと、return;の使い方がいまいちわからない
				//エラーが出るけどとりあえず動く。でもreturn;の意味がわからない。
				//→return;はクラスから抜ける、continue;は後処理をスキップして頭から開始
				//break;はループから抜ける
			}
			if (x > ran) {
				System.out.println("正解はそれより小さい数です");
				cnt++;
				System.out.println("<"+cnt+"回目>");
			} else if (x < ran) {
				System.out.println("正解はそれより大きい数です");
				cnt++;
				System.out.println("<"+cnt+"回目>");
			} else {
				System.out.println("正解です！おめでとう");
				System.out.print(cnt+"回で成功しました");
				break;
			}
		}
	}

}
