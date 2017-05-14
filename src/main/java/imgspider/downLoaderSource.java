package imgspider;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class downLoaderSource {
	public static void downLoad(){
		ImgAdress ia=new ImgAdress();
		String adress="https://www.taobao.com/markets/nvzhuang/taobaonvzhuang?spm=a21bo.50862.201867-main.2.arTTNa";
		int count=100;
		ia.spider(adress, count);
		List<String> imgAdress=ia.getImgAdress();
		for(String ad:imgAdress){
			System.out.println(ad);
		}
		for(String ad:imgAdress){
			// TODO Auto-generated method stub
			System.out.println("启动一个线程");
		long l1=System.currentTimeMillis();

			OutputStream os=null;
			InputStream is=null;
			String name=ad.substring(ad.lastIndexOf("/")+1,ad.length());
			try {
				os=new FileOutputStream("D:\\exe"+"\\"+name);
				URL url=new URL(ad);
				URLConnection urlc=url.openConnection();
				urlc.setReadTimeout(1000);
				System.out.println("asda");
				is=urlc.getInputStream();
				byte[] bytes=new byte[1024];
				int len=0;
				while((len=is.read(bytes))!=-1){
					os.write(bytes, 0, len);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("1");
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("2");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("3");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				System.out.println("23");
				try {
					os.close();
					is.close();
				} catch (Exception e) {
					System.out.println("5");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		long l2=System.currentTimeMillis();
		System.out.println(l2-l1+".............................."+Thread.currentThread());
		}
		
	}
	public static void main(String[] args) {
		downLoad();
	}	
}

class MyTimerTask extends TimerTask{
	int i;
	List<String> imgAdress;
	MyTimerTask(int i,List<String> imgAdress){
		this.i=i;
		this.imgAdress=imgAdress;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("启动一个线程");
	long l1=System.currentTimeMillis();
		String	ad=imgAdress.get(i);

		OutputStream os=null;
		InputStream is=null;
		String name=ad.substring(ad.lastIndexOf("/")+1,ad.length());
		try {
			os=new FileOutputStream("D:\\exe"+"\\"+name);
			URL url=new URL(ad);
			URLConnection urlc=url.openConnection();
			urlc.setReadTimeout(20000);
			System.out.println("asda");
			is=urlc.getInputStream();
			byte[] bytes=new byte[1024];
			int len=0;
			while((len=is.read(bytes))!=-1){
				os.write(bytes, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("1");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("2");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("3");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("23");
			try {
				os.close();
				is.close();
			} catch (IOException e) {
				System.out.println("5");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	i++;
	long l2=System.currentTimeMillis();
	System.out.println(l2-l1+".............................."+Thread.currentThread());
	}
	
}
