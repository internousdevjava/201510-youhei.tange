import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


//�ꉞ�����悤�ɂȂ������ǁA�������I���Ƃ��������ŏ��̉�ʂɖ߂��Ă��܂��B
//�����O�̏�������X�^�[�g�����������ǂ�肩�����킩��Ȃ��B
public class KisoKadai3 {
	public static void main(String[] args) {

		int cmd; // �R�}���h���͗p

		while (true) {
			System.out.println("�����j���[���[�h��");
			System.out.println("[1]�t�@�C��������,[2]�I��");
			System.out.print("�L�[����͂��Ă�������: ");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			try {
				String buf = br.readLine();
				cmd = Integer.parseInt(buf);
				switch (cmd) {
				case 1:
					// �V�K�쐬/�J��
					System.out.println("<�V�K�쐬/�J��>");
					System.out.println("�t�@�C���̖��O�����Ă�������:");
					System.out.println("��:c:\\Users\\internous\\�t�@�C����.txt");
					try{
						String fln = br.readLine();
						// �t�@�C���p�X���w�肷��
						File newfile = new File(fln);
						// �f�B���N�g���p�X���擾����
						File dir=new File(newfile.getParent());

						if(!dir.exists()){
							System.out.println("�t�H���_������܂���B:"+newfile.getAbsolutePath());
							dir.mkdirs();
							System.out.println("�쐬����");
						} 
						try {
							if (newfile.createNewFile()) {
								System.out.println(fln + "�̍쐬�ɐ������܂���");
							} else {
								System.out.println(fln + "���J���܂���");
							}
							// �ҏW���[�h�Ń��[�v
							boolean edi = true;
							while(edi){
								System.out.println("<�ҏW���[�h> ["+ fln + "]");
								System.out.println("[1]��������,[2]�ǂݍ���,[3]���C�����j���[��");
								try {
									buf = br.readLine();
									cmd = Integer.parseInt(buf);
								} catch (Exception e) {
									System.out.println("�������ȊO�������Ă��܂�");
									continue;
								}
								switch (cmd) {
								case 1:
									System.out.println("<�������݃��[�h > ["+ fln + "]");
									System.out.println("[1]�㏑��,[2]�ǋL,[3]���C�����j���[��");
									try {
										buf = br.readLine();
										cmd = Integer.parseInt(buf);
									} catch (Exception e) {
										System.out.println("�������ȊO�������Ă��܂�");
										continue;
									}
									switch (cmd) {
									case 1:
										// �㏑��
										System.out.println("<�㏑�����[�h> ["+ fln + "]");
										System.out.println("��������͂��Ă���������");
										String text = br.readLine();
										try {
											PrintWriter pw = new PrintWriter(new BufferedWriter(
													new FileWriter(fln)));
											System.out.println(fln + "�@�Ɂu" + text + "�v���㏑�����܂���");
											pw.print(text);
											pw.print("\r\n");
											pw.close();
										} catch (IOException e) {
											System.out.println("���o�̓G���[�ł��B");
										}
										continue;
									case 2:
										// �ǋL
										System.out.println("<�ǋL���[�h> ["+ fln + "]");
										System.out.println("��������͂��Ă���������");
										text = br.readLine();
										try {
											FileWriter filewriter = new FileWriter(fln,true);
											System.out.println(fln + "��");
											System.out.println("�u"+ text + "�v��ǋL���܂���");
											filewriter.write(text);
											filewriter.write("\r\n");
											filewriter.close();
										} catch (IOException e) {
											System.out.println("���o�̓G���[�ł��B");
										}
										continue;
									case 3:
										edi=false;
										continue;
									default:
										System.out.println("1�`3�̐�������͂��Ă�������");
										continue;

									}

								case 2:
									// �ǂݍ���
									System.out.println("<�ǂݍ��݃��[�h> ["+fln+"]");
									try {
										FileReader filereader = new FileReader(fln);

										int ch;
										while ((ch = filereader.read()) != -1) {
											System.out.print((char) ch);
										}
										System.out.println("");
										filereader.close();
									} catch (FileNotFoundException e) {
										System.out.println(e);
									} catch (IOException e) {
										System.out.println(e);
									}
									continue;
								case 3:
									// ���C�����j���[��
									edi=false;
									continue;
									// ����ł��܂����C�����j���[�ɖ߂���

								default:
									System.out.println("1�`3�̐�������͂��Ă�������");
									continue;
								}
							}
							

						} catch (IOException e) {
							System.out.println(e);
						}
					}catch (Exception e){
						System.out.println("���̓~�X������܂�");
					}

					continue;
				case 2:
					// �I��
					System.out.println("�I�����܂�");
					return;
				default:
					System.out.println("1�`2�̐�������͂��Ă�������");
					continue;
				}
			} catch (Exception e) {
				System.out.println("�������ȊO�������Ă��܂�");
				continue;
				// �������ɂ����̌��while���̓�����J�n��������
				// ���ƁAreturn;�̎g���������܂����킩��Ȃ�
				// �G���[���o�邯�ǂƂ肠���������B�ł�return;�̈Ӗ����킩��Ȃ��B
				// ��return;�̓N���X���甲����Acontinue;�͌㏈�����X�L�b�v���ē�����J�n
				// break;�̓��[�v���甲����
			}
		}
	}
}