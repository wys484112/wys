package httptest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONObject;

public class httptest {

	public static void main(String[] args) {
		
//		
//		String test =  "username=吴寅生&password=111111";
//		try {
//			test="username="+URLEncoder.encode("吴寅生", "utf-8")+"&password=111111";
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String ans = HttpPostUtils.doPostRequest("login.action", test);
//		System.out.println("服务器返回的数据为：" + ans);
//		
		
		
//		User user=new User();
//		user.setId(1);
//		try {
//			user.setName(URLEncoder.encode("吴寅生", "utf-8"));
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		user.setName("111111");
//
//		user.setProductid(333);
//		
//		user.setPassword("aaaa");
//		  JSONObject object = (JSONObject) JSONObject.wrap(user);
//			System.out.println("User：" + object.toString());
//			
//			String aaaa = HttpPostUtils.doJsonPostRequest("testjson.action", object);
//			System.out.println("服务器返回的数据为：" + aaaa);
			
			
			
			
			
			User user=new User();
			user.setId(1);
			try {
				user.setName(URLEncoder.encode("吴寅生", "utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setName("111111");

			user.setProductid(333);
			
			user.setPassword("aaaa");
			  JSONObject object = (JSONObject) JSONObject.wrap(user);
				System.out.println("User：" + object.toString());
				
				String aaaa = null;
				try {
					aaaa = HttpPostUtils.doPostRequest("shiro.demo/lightlogin", "username="+URLEncoder.encode("吴寅生", "utf-8")+"&password=111111");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("服务器返回的数据为：" + aaaa);
				
				
	}

}
