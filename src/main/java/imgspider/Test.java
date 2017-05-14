package imgspider;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		ImgAdress ia=new ImgAdress();
		String a="http://www.tooopen.com/img/87.aspx";
		ia.spider(a, 50);
		List<String> list=ia.getImgAdress();
		for(String s:list){
			System.out.println(s);
		}
	}
}
