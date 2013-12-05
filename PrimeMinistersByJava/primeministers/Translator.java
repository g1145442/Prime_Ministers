package primeministers;

import javax.swing.JOptionPane;

/**
 * トランスレータ：総理大臣のCSVファイルをHTMLページへと変換するプログラム。
 */
public class Translator extends Object
{
	/**
	 * ここを作成してください。
	 * まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */
	
	/**
	 * CSVに由来するテーブルを記憶するフィールド
	 */
	private Table inputTable;
	
	/**
	 * HTMLに由来するテーブルを記憶するフィールド
	 */
	private Table outputTable;
	
	
	/**
	 * トランスレータのコンストラクタ。
	 */
	public Translator()
	{
		super();
		this.inputTable = new Table();
		this.outputTable = new Table();
		return;
	}
	
	/**
	 * 総理大臣のCSVファイルをHTMLページへ変換する。
	 */
	public void perform()
	{
		Downloader aDownload = new Downloader();
		aDownload.downloadCSV();
		
		this.inputTable = aDownload.table();
		
		Table aTable = this.table(this.inputTable);
		
		Writer aWriter = new Writer();
		aWriter.table(aTable);
		
		String aString = "総理大臣のCSVファイルからHTMLページへの変換を無事に完了しました。\n";
		JOptionPane.showMessageDialog(null, aString, "報告", JOptionPane.PLAIN_MESSAGE);
		return;
	}
	
	
	/**
	 * 在位日数を経産して、それを文字列にして応答する。
	 */
	public String computeNumberOfDays(String periodString)
	{
		return null;
	}
	
	/**
	 * サムネイル画像から画像へ飛ぶためのHTMP文字列を生成して、それを応答する。
	 */
	public String computeStringOfImage(String aString,Tuple aTuple,int no)
	{
		return null;
	}
	/**
	 * 総理大臣のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換して、
	 * それを応答する。
	 */
	public Table table(Table aTable)
	{
		//処理内容
		//ここに書く... compute系はここで呼ぶ
		return this.outputTable;
	}
	
}
