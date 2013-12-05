package primeministers;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 */
public class Downloader extends IO
{
	/**
	 * ここを作成してください。
	 * まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */
	
	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL文字列)を記憶するフィールド。
	 */
	private String url;
	
	/**
	 * ダウンローダのコンストラクタ。
	 */
	public Downloader()
	{
		this.url = this.url();
	}

	/*
	 * 総理大臣の情報を記しCSVファイルをダウンロードする。
	 */
	public void downloadCSV()
	{
		File aFile;
		aFile = new File(this.url);
		ArrayList<String> aCollection = IO.readTextFromFile(aFile);
		aFile = new File("PrimeMinisters.csv");
		IO.writeText(aCollection, aFile);
		return;
	}
	
	
	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadImages()
	{
		int urlMaxNum = 26;	
		BufferedImage readImage[] = new BufferedImage[urlMaxNum];
		for(int i=0;i<urlMaxNum;i++)
		{
			try {
				readImage[i] = ImageIO.read(new URL("http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/images/0"+Integer.toString(i+39)+".jpg"));
			} catch (Exception e) {
				e.printStackTrace();
				readImage = null;
				System.out.println((i+39)+"しっぱい");
			}

		}

		return;
	}

	/**
	 * 総理大臣の画像群またはサムネイル画像群をダウンロードする。
	 */
	private void downloadPictures(int indexOfPicture)
	{
		BufferedImage readImage;
		BufferedImage readThumbnail;
		try {
			readImage = ImageIO.read(new URL("http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/images/0"+Integer.toString(indexOfPicture)+".jpg"));
			readThumbnail = ImageIO.read(new URL("http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/thumbnails/0"+Integer.toString(indexOfPicture)+".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
			readImage = null;
		}

		return;
	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadThumbnails()
	{
		int urlMaxNum = 26;	
		BufferedImage readImage[] = new BufferedImage[urlMaxNum];
		for(int i=0;i<urlMaxNum;i++)
		{
			try {	
				readImage[i] = ImageIO.read(new URL("http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/images/0"+Integer.toString(i+39)+".jpg"));
			} catch (Exception e) {
				e.printStackTrace();
				readImage = null;
				System.out.println((i+39)+"しっぱい");
			}
		}
		return;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群を
	 * ダウンロードし、テーブルで応答する。
	 */
	@Override
		public Table table()
		{
			Reader aReader = new Reader();
			this.table = aReader.table();

			this.downloadImages();
			this.downloadThumbnails();

			return this.table;
		}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答する。
	 */
	public String url(){
		return this.urlStringOfCSV();
	}

	/**
	 * 総理大臣の情報の在処(URL)を文字列で応答するクラスメソッド。
	 */
	public static String urlString() {
		return "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinisters/";
	}
	
	
	/**
	 * 総理大臣の情報を記したCSVファイル在処(URL)を文字列で応答するクラスメソッド。
	 */
	public static String urlStringOfCSV() {
		return Downloader.urlString() + "PrimeMinisters.csv";
	}
}
