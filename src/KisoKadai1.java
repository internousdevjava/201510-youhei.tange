import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KisoKadai1 {
	public static void main(String args[]) {
		System.out.println("���̕\");

		int x;
		int y;

		// x����
		System.out.print("x����͂��Ă�������: ");
		InputStreamReader isrx = new InputStreamReader(System.in);
		BufferedReader brx = new BufferedReader(isrx);
		try {
			String bufx = brx.readLine();
			x = Integer.parseInt(bufx);
			if (x > 100 || x < 1) {
				System.out.println("x��1�`100�܂ł̐����ł��肢���܂�");
				return;
			}
		} catch (Exception e) {
			System.out.println("x�ɐ����ȊO�������Ă��܂�");
			return;
		}

		// y����
		System.out.print("y����͂��Ă�������: ");
		InputStreamReader isry = new InputStreamReader(System.in);
		BufferedReader bry = new BufferedReader(isry);
		try {
			String bufy = bry.readLine();
			y = Integer.parseInt(bufy);
			if (y > 100 || y < 1) {
				System.out.println("y��1�`100�܂ł̐����ł��肢���܂�");
				return;
			}
		} catch (Exception e) {
			System.out.println("y�ɐ����ȊO�������Ă��܂�");
			return;
		}


		// �z��̐錾�B
		int kuku[][] = new int[y][x];
		
		// ���̌��ʂ�z��ɕۑ��B
		for (int i = y; i >= 1; i--) {
			for (int j = 0; j < x; j++) {
				kuku[i - 1][j] = i * (j + 1);
			}
		}

		// ���̌��ʂ�\���B
		for (int i = y; i >= 1; i--) {
			for (int j = 0; j < x; j++) {
				// x*y�̌����ɂ���ė]���̑傫����ω������邱�ƂŒ���
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
