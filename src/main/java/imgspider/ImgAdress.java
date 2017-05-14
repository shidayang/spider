package imgspider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImgAdress {
	private  List<String> imgAdress=new ArrayList<>();
	private List<String> overAdress=new ArrayList<>();
	private Queue<String> adressing=new LinkedList<>();
	public   void spider(String rawAdress,int count){
		Document doc=null;
		try {
			doc=Jsoup.connect(rawAdress).ignoreContentType(true).timeout(10000).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements imgele=doc.getElementsByTag("img");
		Elements aele=doc.getElementsByTag("a");
		for(Element e:imgele){
			System.out.println(e);
			String adress=e.attr("src");
			if(adress!=null&&adress.trim()!=""){
				
				String regex="(https|http).*";
				if(adress.matches(regex)){
					imgAdress.add(adress);
					System.out.println(imgAdress.size()+"................"+adress);
				}else{
					adress="https:"+adress;
					imgAdress.add(adress);
					System.out.println(imgAdress.size()+"................"+adress);
				}
				if(imgAdress.size()>=count){
					return;
				}
			}
		}
		for(int i=0;i<aele.size();i++){
			if(imgAdress.size()>=count){
				return;
			}
			String adress=aele.get(i).attr("href");
			String regex="(http|https).*";
			if(adress.matches(regex)){
					if(!overAdress.contains(adress)){
						adressing.offer(adress);
					}
			}
		}
		while(adressing.size()>0){
			if(imgAdress.size()>=count){
				return;
			}
			
			String addre=adressing.poll();
			System.out.println(addre);
			overAdress.add(addre);
			spider(addre, count);
		}
	
	}
	public List<String> getImgAdress(){
		return imgAdress;
	}
}
