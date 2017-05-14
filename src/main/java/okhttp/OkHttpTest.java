package okhttp;

import java.io.IOException;
import java.io.Reader;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class OkHttpTest {
	public static void main(String[] args) {
		OkHttpClient client=new OkHttpClient();
		Request request=new Builder().url("http://www.baidu.com").get().build();
		Call call=client.newCall(request);
		Response response;
		try {
			response = call.execute();
			System.out.println(response.body().contentType());
			Reader reader=response.body().charStream();
			char[] cha=new char[100];
			int i=0;
			while((i=reader.read(cha))!=-1){
				System.out.println(new String(cha,0,i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
