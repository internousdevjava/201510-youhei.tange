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

		// �����̐ݒ�
		// Random�N���X�̃C���X�^���X��
		Random rnd = new Random();

		int ran = rnd.nextInt(100)+1;
		
		// �������������
		System.out.println(ran);
		
		System.out.println("<1���>");

		// �����̓���
		while (true) {
			System.out.print("1�`100�܂ł̐��������Ă�������: ");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			try {
				String buf = br.readLine();
				x = Integer.parseInt(buf);
				if (x > 100 || x < 1) {
					System.out.println("��1�`100�܂ł̐����ł��肢���܂�");
					continue;
					//�����̌�ɂ܂�while���̓�����J�n�����������ǂ������킩��Ȃ��E�E�E
					//��continue;�łł��܂����I
				}
			} catch (Exception e) {
				System.out.println("�������ȊO�������Ă��܂�");
				continue;
				//�������ɂ����̌��while���̓�����J�n��������
				//���ƁAreturn;�̎g���������܂����킩��Ȃ�
				//�G���[���o�邯�ǂƂ肠���������B�ł�return;�̈Ӗ����킩��Ȃ��B
				//��return;�̓N���X���甲����Acontinue;�͌㏈�����X�L�b�v���ē�����J�n
				//break;�̓��[�v���甲����
			}
			if (x > ran) {
				System.out.println("�����͂����菬�������ł�");
				cnt++;
				System.out.println("<"+cnt+"���>");
			} else if (x < ran) {
				System.out.println("�����͂�����傫�����ł�");
				cnt++;
				System.out.println("<"+cnt+"���>");
			} else {
				System.out.println("�����ł��I���߂łƂ�");
				System.out.print(cnt+"��Ő������܂���");
				break;
			}
		}
	}

}
