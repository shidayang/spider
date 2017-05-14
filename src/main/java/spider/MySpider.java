package spider;



import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MySpider {
	public static void main(String[] args) throws InterruptedException {
		Queue<String> que=pa("http://www.tooopen.com/img/87.aspx");
//		int i=0;
//		Queue<String> qu=null;
//		while(!que.isEmpty()){
//			qu=pa(que.poll());
//			if(qu!=null&&!qu.isEmpty()){
//				que.addAll(qu);
//			}
//			
//			i++;
//			System.out.println(i+"...................................................................."+que.size());
//		}
		System.out.println(que);
		
		

		
	}
	public static Queue<String> pa(String url){
		Queue<String> que=null;
		try {
			Document doc=Jsoup.connect(url).timeout(5000).get();
			//System.out.println(doc.toString());
			//Element ele=doc.getElementById("wrapper");
			//System.out.println(ele.toString());
			Elements img=doc.getElementsByTag("img");
			que=new LinkedList<String>();
			for(Element e: img){
				String s=stringUtil(e.attr("src"));
				System.out.println(s);
				que.offer(s);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return que;
	}
	public static String stringUtil(String st){
//		String regex="www.";
//		return st.replaceAll(regex, "");
		return st;
	}
}
