package primeministers;

import java.util.ArrayList;

/**
 * 属性群：総理大臣の情報テーブルを入出力する際の属性情報を記憶。
 */
public class Attributes extends Object
{
	/**
	 * ここを作成してください。
	 * まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */
	
	/**
	 * 属性リストのキー群を記憶するフィールド。
	 */
	private ArrayList<String> keys;
	
	/**
	 * 属性リストの名前群を記憶するフィールド。
	 */
	private ArrayList<String> names;
	
	/**
	 * 入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。
	 */
	public Attributes(String aString)
	{
		if(aString == "input")
		{
			//input処理
			String[] aCollection = new String[]
			{
				"no", "order", "names", "kana", "period","school",
				"party", "birth", "image", "thumbnail"
			};
			
			for(String each : aCollection){
				this.keys.add(each);
			}
		}
		else if(aString == "output")
		{
			//output処理
			String[] aCollection = new String[]
			{
				"no", "order", "names", "kana", "period","day", "school",
				"party", "birth", "image"
			};
			
			for(String each : aCollection){
				this.keys.add(each);
			}
		}
		else
		{
			System.err.println("Attributes: 想定外の値");
		}
	}
	
	/**
	 * 指定されたインデックスに対応する名前を応答する。名前がないときはキーを応答する。
	 */
	protected String at(int index)
	{
		return this.names.get(index);
	}
	
	/**
	 * 指定されたキー文字列のインデックスを応答する。
	 */
	private int indexOf(String aString)
	{
		return this.names.indexOf(aString);
	}
	
	/**
	 * 在位日数のインデックスを応答する。
	 */
	public int indexOfDays()
	{
		return this.indexOf("在位日数");
	}
	
	/**
	 * 画像のインデックスを応答する。
	 */
	public int indexOfImage()
	{
		return this.indexOf("画像");
	}
	
	/**
	 * ふりがなのインデックスを応答する。
	 */
	public int indexOfKana()
	{
		return this.indexOf("ふりがな");
	}
	
	/**
	 * 氏名のインデックスを応答する。
	 */
	public int indexOfName()
	{
		return this.indexOf("氏名");
	}
	
	/**
	 * 番号のインデックスを応答する。
	 */
	public int indexOfNo()
	{
		return this.indexOf("人目");
	}
	
	/**
	 * 代のインデックスを応答する。
	 */
	public int indexOfOrder()
	{
		return this.indexOf("代");
	}
	
	/**
	 * 政党のインデックスを応答する。
	 */
	public int indexOfParty()
	{
		return this.indexOf("政党");
	}
	
	/**
	 * 在位期間のインデックスを応答する。
	 */
	public int indexOfPeriod()
	{
		return this.indexOf("在位期間");
	}
	
	/**
	 * 出身地のインデックスを応答する。
	 */
	public int indexOfPlace()
	{
		return this.indexOf("出身地");
	}
	
	/**
	 * 出身校のインデックスを応答する。
	 */
	public int indexOfSchool()
	{
		return this.indexOf("出身校");
	}
	
	/**
	 * 画像のインデックスを応答する。
	 */
	public int indexOfThumbnail()
	{
		return this.indexOf("縮小画像");
	}
	
	/**
	 * 指定されたインデックスに対応するキーを応答する。
	 */
	protected String keyAt(int index)
	{
		return names.get(index);
	}
	
	/**
	 * キー群を応答する。
	 */
	public ArrayList<String> keys()
	{
		return this.keys;
	}
	
	/**
	 * 指定されたインデックスに対応する名前を応答する。
	 */
	protected String nameAt(int index)
	{
		return this.names.get(index);
	}
	
	/**
	 * 名前群を応答する。
	 */
	public ArrayList<String> names()
	{
		return names;
	}
	
	/**
	 *	名前群を設定する。
	 */
	public void names(ArrayList<String> aCollection)
	{
		this.names = aCollection;
	}
	
	/**
	 * 属性リストの長さを応答する。
	 */
	public int size()
	{
		return keys.size();
	}
	
	/**
	 * 自分自身を文字列にして、それを応答する。
	 */
	@Override
	public String toString()
	{
		StringBuffer aBuffer = new StringBuffer();
		Class aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[keys=");
		aBuffer.append(keys);
		aBuffer.append(",names=");
		aBuffer.append(names);
		aBuffer.append("]");
		return aBuffer.toString();
	}
}
