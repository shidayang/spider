package spider;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class downloadImg {
	public static void main(String[] args) throws IOException {
		URL url=new URL("http://user.3dmgame.com/data/avatar/004/69/42/85_avatar_small.jpg");
		InputStream is=url.openStream();
		OutputStream os=new FileOutputStream("D:\\exe"+"\\gsss.jpeg");
		byte[] mybyte=new byte[1024];
		int n=0;
		while((n=is.read(mybyte))!=-1){
			os.write(mybyte, 0, n);
		}
		is.close();
		os.close();
	}
}
