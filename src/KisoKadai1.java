
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KisoKadai1 {
	public static void main(String args[]) {
		System.out.println("九九の表");

		int x = 0;
		int y = 0;

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		// x入力
		boolean bl = true;
		do {
			System.out.print("xを入力してください: ");
			try {
				String bufx = br.readLine();
				x = Integer.parseInt(bufx);
				if (x > 100 || x < 1) {
					System.out.println("xを1～100までの数字でお願いします");
				} else {
					bl = false;
				}
			} catch (Exception e) {
				System.out.println("xに数字以外が入っています");
			}
		} while (bl == true);

		// y入力
		do {
			System.out.print("yを入力してください: ");
			try {
				String bufy = br.readLine();
				y = Integer.parseInt(bufy);
				if (y > 100 || y < 1) {
					System.out.println("yを1～100までの数字でお願いします");
				} else {
					bl = false;
				}
			} catch (Exception e) {
				System.out.println("yに数字以外が入っています");
			}
		} while (bl == true);

		// 入力数値の確認
		System.out.print("xの値:" + x + "   ");
		System.out.println("yの値:" + y);

		// 九九表の表示
		for (int i = y; i > 0; i--) {
			for (int j = 1; j <= x; j++) {
				// x*yの桁数によって余白の大きさを変化させることで調整
				if (i * j < 10) {
					System.out.print("     ");
				} else if (i * j < 100) {
					System.out.print("    ");
				} else if (i * j < 1000) {
					System.out.print("   ");
				} else if (i * j < 10000) {
					System.out.print("  ");
				} else {
					System.out.print(" ");
				}

				// ｘ*ｙの結果を出力
				System.out.print(i * j);
			}
			System.out.println();
		}

	}
}
