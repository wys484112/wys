package httptest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class httptest {

//	public static void main(String[] args) {
//		
////		
////		String test =  "username=������&password=111111";
////		try {
////			test="username="+URLEncoder.encode("������", "utf-8")+"&password=111111";
////		} catch (UnsupportedEncodingException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		String ans = HttpPostUtils.doPostRequest("login.action", test);
////		System.out.println("���������ص�����Ϊ��" + ans);
////		
//		
//		
////		User user=new User();
////		user.setId(1);
////		try {
////			user.setName(URLEncoder.encode("������", "utf-8"));
////		} catch (UnsupportedEncodingException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		user.setName("111111");
////
////		user.setProductid(333);
////		
////		user.setPassword("aaaa");
////		  JSONObject object = (JSONObject) JSONObject.wrap(user);
////			System.out.println("User��" + object.toString());
////			
////			String aaaa = HttpPostUtils.doJsonPostRequest("testjson.action", object);
////			System.out.println("���������ص�����Ϊ��" + aaaa);
//			
//			
//			
//			
//			
////			User user=new User();
////			user.setId(1);
////			try {
////				user.setName(URLEncoder.encode("������", "utf-8"));
////			} catch (UnsupportedEncodingException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			user.setName("111111");
////
////			user.setProductid(333);
////			
////			user.setPassword("aaaa");
////			  JSONObject object = (JSONObject) JSONObject.wrap(user);
////				System.out.println("User��" + object.toString());
////				
////				String aaaa = null;
////				try {
////					aaaa = HttpPostUtils.doPostRequest("shiro.demo/lightlogin", "username="+URLEncoder.encode("������", "utf-8")+"&password=111111");
////				} catch (UnsupportedEncodingException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////				System.out.println("���������ص�����Ϊ��" + aaaa);
//				
//				
//				
//				
//				
//				
//				
//				
//				
//        String path = "http://localhost:8080/userLogin";
//
//        // 2 ����okhttpclient����
//        OkHttpClient client = new OkHttpClient();
//
//        RequestBody body = new FormBody.Builder().add("username", "admin").add("password", "123456").build();
//        // 3 ��������ʽ
//        Request request = new Request.Builder().url(path).post(body).build();
//
//        // 4 ִ���������
//        try {
//            Response response = client.newCall(request).execute();
//            if(response.isSuccessful()){
//                String string = response.body().string();
//                System.out.println(string);
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        
//        
//        
//        
//        
//        {
//
//        	Request request11 = new Request.Builder()
//        	  .url("http://localhost:8080/module.light/sysLightInfo")
//        	  .get()
//        	  .addHeader("Cache-Control", "no-cache")
//        	  .addHeader("Postman-Token", "68dcc9c1-4cb9-8802-f0e4-13958c096851")
//        	  .build();
//
//        	try {
//				Response response = client.newCall(request11).execute();
//	            if(response.isSuccessful()){
//	                String string = response.body().string();
//	                System.out.println(string);
//	            }
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        }
//        
//        
//        
//        
//    
//	}
	
	
	
	
	public static void main(String[]args){  
        //��ʼ��Cookie������  
        CookieJar cookieJar = new CookieJar() {  
            //Cookie������  
            private final Map<String, List<Cookie>> cookiesMap = new HashMap<String, List<Cookie>>();  
            @Override  
            public void saveFromResponse(HttpUrl arg0, List<Cookie> arg1) {  
                // TODO Auto-generated method stub  
                //�Ƴ���ͬ��url��Cookie  
                String host = arg0.host();  
                List<Cookie> cookiesList = cookiesMap.get(host);  
                if (cookiesList != null){  
                    cookiesMap.remove(host);  
                }  
                //�����������  
                cookiesMap.put(host, arg1);  
            }  
              
            @Override  
            public List<Cookie> loadForRequest(HttpUrl arg0) {  
                // TODO Auto-generated method stub  
                List<Cookie> cookiesList = cookiesMap.get(arg0.host());  
                //ע�����ﲻ�ܷ���null������ᱨNULLException�Ĵ���  
                //ԭ�򣺵�Request ���ӵ������ʱ��OkHttp�����loadForRequest()  
                return cookiesList != null ? cookiesList : new ArrayList<Cookie>();  
            }  
        };  
        //����OkHttpClient  
        OkHttpClient client = new OkHttpClient.Builder()  
                        .connectTimeout(5000, TimeUnit.MILLISECONDS)  
                        .cookieJar(cookieJar)  
                        .build();  
        //������½�ı�  
        FormBody loginBody = new FormBody.Builder()  
                    .add("username", "admin")  
                    .add("password", "123456")  
                    .build();//�˺������Լ���  
        //����Request����  
        Request loginRequest = new Request.Builder()  
                        .url("http://localhost:8080/userLogin")  
                        .post(loginBody)  
                        .build();  
        //�ϴ�  
        Call loginCall = client.newCall(loginRequest);  
          
        try {  
            //���첽ִ��  
            Response loginResponse = loginCall.execute();  
            //�����Ƿ��½�ɹ�  
            System.out.println(loginResponse.body().string());  
            //��ȡ�������ݵ�ͷ��  
            Headers headers = loginResponse.headers();  
            HttpUrl loginUrl = loginRequest.url();  
            //��ȡͷ����Cookie,ע�⣺����ͨ��Cooke.parseAll()����ȡ  
            List<Cookie> cookies = Cookie.parseAll(loginUrl, headers);  
            //��ֹheaderû��Cookie�����  
            if (cookies != null){  
                //�洢��Cookie��������  
                client.cookieJar().saveFromResponse(loginUrl, cookies);//�����ͽ�Cookie�洢����������  
            }  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
          
        //��ȡ��Ҫ�ύ��CookieStr  
        StringBuilder cookieStr = new StringBuilder();  
        //�ӻ����л�ȡCookie  
        List<Cookie> cookies = client.cookieJar().loadForRequest(loginRequest.url());  
        //��Cookie����Ū��һ��  
        for(Cookie cookie : cookies){  
            cookieStr.append(cookie.name()).append("=").append(cookie.value()+";");  
        }  
        System.out.println(cookieStr.toString());  
        //�����ύ������  
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("1111");  

        
//        
//        Request attentionRequest = new Request.Builder()  
//                            .url("http://localhost:8080/area/list")  
//                            .header("Cookie", cookieStr.toString())  
//                            .header("User-Agent", "Android")
//                            .build();  
//        System.out.println("222");  
//
//        Call attentionCall = client.newCall(attentionRequest);  
//        System.out.println("333");  
//
//        try {  
//            System.out.println("4444");  
//
//            //��������  
//            Response attentionResponse = attentionCall.execute();  
//            System.out.println("5555");  
//
//            if (attentionResponse.isSuccessful()){  
//                System.out.println("6666");  
//
//                //��ȡ���ص�����  
//                String data = attentionResponse.body().string();  
//                System.out.println("77777");  
//
//                //����  
//                System.out.println(data);  
//                System.out.println("88888");  
//
//                //��������  
//
//            }  
//        } catch (Exception e) {  
//            System.out.println("999");  
//
//            // TODO Auto-generated catch block  
//            e.printStackTrace();  
//        }  
        
        
        
        
        
        Request request = new Request.Builder()
        		  .url("http://localhost:8080/role/list")
        		  .get()
        		  .addHeader("Cache-Control", "no-cache")
                  .addHeader("Cookie", cookieStr.toString())
                .addHeader("User-Agent", "Android")
                  
        		  .build();
        Call nCall = client.newCall(request);  

        		try {
					Response response = nCall.execute();
					
		            if (response.isSuccessful()){  
		                System.out.println("6666");  

		                //��ȡ���ص�����  
		                String data = response.body().string();  
		                System.out.println("77777");  

		                //����  
		                System.out.println(data);  
		                System.out.println("88888");  

		                //��������  

		            }  
		            
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		
    }  
	

}
