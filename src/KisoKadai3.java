import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


//一応動くようになったけど、処理が終わるといちいち最初の画面に戻ってしまう。
//少し前の処理からスタートさせたいけどやりかたがわからない。
public class KisoKadai3 {
	public static void main(String[] args) {

		int cmd; // コマンド入力用

		while (true) {
			System.out.println("＜メニューモード＞");
			System.out.println("[1]ファイル名入力,[2]終了");
			System.out.print("キーを入力してください: ");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			try {
				String buf = br.readLine();
				cmd = Integer.parseInt(buf);
				switch (cmd) {
				case 1:
					// 新規作成/開く
					System.out.println("<新規作成/開く>");
					System.out.println("ファイルの名前を入れてください:");
					System.out.println("例:c:\\Users\\internous\\ファイル名.txt");
					try{
						String fln = br.readLine();
						// ファイルパスを指定する
						File newfile = new File(fln);
						// ディレクトリパスを取得する
						File dir=new File(newfile.getParent());

						if(!dir.exists()){
							System.out.println("フォルダがありません。:"+newfile.getAbsolutePath());
							dir.mkdirs();
							System.out.println("作成成功");
						} 
						try {
							if (newfile.createNewFile()) {
								System.out.println(fln + "の作成に成功しました");
							} else {
								System.out.println(fln + "を開きました");
							}
							// 編集モードでループ
							boolean edi = true;
							while(edi){
								System.out.println("<編集モード> ["+ fln + "]");
								System.out.println("[1]書き込み,[2]読み込み,[3]メインメニューへ");
								try {
									buf = br.readLine();
									cmd = Integer.parseInt(buf);
								} catch (Exception e) {
									System.out.println("※数字以外が入っています");
									continue;
								}
								switch (cmd) {
								case 1:
									System.out.println("<書き込みモード > ["+ fln + "]");
									System.out.println("[1]上書き,[2]追記,[3]メインメニューへ");
									try {
										buf = br.readLine();
										cmd = Integer.parseInt(buf);
									} catch (Exception e) {
										System.out.println("※数字以外が入っています");
										continue;
									}
									switch (cmd) {
									case 1:
										// 上書き
										System.out.println("<上書きモード> ["+ fln + "]");
										System.out.println("文字を入力してください↓");
										String text = br.readLine();
										try {
											PrintWriter pw = new PrintWriter(new BufferedWriter(
													new FileWriter(fln)));
											System.out.println(fln + "　に「" + text + "」を上書きしました");
											pw.print(text);
											pw.print("\r\n");
											pw.close();
										} catch (IOException e) {
											System.out.println("入出力エラーです。");
										}
										continue;
									case 2:
										// 追記
										System.out.println("<追記モード> ["+ fln + "]");
										System.out.println("文字を入力してください↓");
										text = br.readLine();
										try {
											FileWriter filewriter = new FileWriter(fln,true);
											System.out.println(fln + "に");
											System.out.println("「"+ text + "」を追記しました");
											filewriter.write(text);
											filewriter.write("\r\n");
											filewriter.close();
										} catch (IOException e) {
											System.out.println("入出力エラーです。");
										}
										continue;
									case 3:
										edi=false;
										continue;
									default:
										System.out.println("1～3の数字を入力してください");
										continue;

									}

								case 2:
									// 読み込み
									System.out.println("<読み込みモード> ["+fln+"]");
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
									// メインメニューへ
									edi=false;
									continue;
									// これでうまくメインメニューに戻った

								default:
									System.out.println("1～3の数字を入力してください");
									continue;
								}
							}
							

						} catch (IOException e) {
							System.out.println(e);
						}
					}catch (Exception e){
						System.out.println("入力ミスがあります");
					}

					continue;
				case 2:
					// 終了
					System.out.println("終了します");
					return;
				default:
					System.out.println("1～2の数字を入力してください");
					continue;
				}
			} catch (Exception e) {
				System.out.println("※数字以外が入っています");
				continue;
				// こっちにもこの後にwhile文の頭から開始させたい
				// あと、return;の使い方がいまいちわからない
				// エラーが出るけどとりあえず動く。でもreturn;の意味がわからない。
				// →return;はクラスから抜ける、continue;は後処理をスキップして頭から開始
				// break;はループから抜ける
			}
		}
	}
}