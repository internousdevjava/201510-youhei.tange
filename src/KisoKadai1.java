import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KisoKadai1 {
	public static void main(String args[]) {
		System.out.println("九九の表");

		int x;
		int y;

		// x入力
		System.out.print("xを入力してください: ");
		InputStreamReader isrx = new InputStreamReader(System.in);
		BufferedReader brx = new BufferedReader(isrx);
		try {
			String bufx = brx.readLine();
			x = Integer.parseInt(bufx);
			if (x > 100 || x < 1) {
				System.out.println("xを1～100までの数字でお願いします");
				return;
			}
		} catch (Exception e) {
			System.out.println("xに数字以外が入っています");
			return;
		}

		// y入力
		System.out.print("yを入力してください: ");
		InputStreamReader isry = new InputStreamReader(System.in);
		BufferedReader bry = new BufferedReader(isry);
		try {
			String bufy = bry.readLine();
			y = Integer.parseInt(bufy);
			if (y > 100 || y < 1) {
				System.out.println("yを1～100までの数字でお願いします");
				return;
			}
		} catch (Exception e) {
			System.out.println("yに数字以外が入っています");
			return;
		}


		// 配列の宣言。
		int kuku[][] = new int[y][x];
		
		// 九九の結果を配列に保存。
		for (int i = y; i >= 1; i--) {
			for (int j = 0; j < x; j++) {
				kuku[i - 1][j] = i * (j + 1);
			}
		}

		// 九九の結果を表示。
		for (int i = y; i >= 1; i--) {
			for (int j = 0; j < x; j++) {
				// x*yの桁数によって余白の大きさを変化させることで調整
				if (i * j+1 < 10) {
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
				System.out.print(kuku[i - 1][j]+" ");
			}
			System.out.println();
		}
	}
}
