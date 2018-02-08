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
////		String test =  "username=吴寅生&password=111111";
////		try {
////			test="username="+URLEncoder.encode("吴寅生", "utf-8")+"&password=111111";
////		} catch (UnsupportedEncodingException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		String ans = HttpPostUtils.doPostRequest("login.action", test);
////		System.out.println("服务器返回的数据为：" + ans);
////		
//		
//		
////		User user=new User();
////		user.setId(1);
////		try {
////			user.setName(URLEncoder.encode("吴寅生", "utf-8"));
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
////			System.out.println("User：" + object.toString());
////			
////			String aaaa = HttpPostUtils.doJsonPostRequest("testjson.action", object);
////			System.out.println("服务器返回的数据为：" + aaaa);
//			
//			
//			
//			
//			
////			User user=new User();
////			user.setId(1);
////			try {
////				user.setName(URLEncoder.encode("吴寅生", "utf-8"));
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
////				System.out.println("User：" + object.toString());
////				
////				String aaaa = null;
////				try {
////					aaaa = HttpPostUtils.doPostRequest("shiro.demo/lightlogin", "username="+URLEncoder.encode("吴寅生", "utf-8")+"&password=111111");
////				} catch (UnsupportedEncodingException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////				System.out.println("服务器返回的数据为：" + aaaa);
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
//        // 2 创建okhttpclient对象
//        OkHttpClient client = new OkHttpClient();
//
//        RequestBody body = new FormBody.Builder().add("username", "admin").add("password", "123456").build();
//        // 3 创建请求方式
//        Request request = new Request.Builder().url(path).post(body).build();
//
//        // 4 执行请求操作
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
        //初始化Cookie管理器  
        CookieJar cookieJar = new CookieJar() {  
            //Cookie缓存区  
            private final Map<String, List<Cookie>> cookiesMap = new HashMap<String, List<Cookie>>();  
            @Override  
            public void saveFromResponse(HttpUrl arg0, List<Cookie> arg1) {  
                // TODO Auto-generated method stub  
                //移除相同的url的Cookie  
                String host = arg0.host();  
                List<Cookie> cookiesList = cookiesMap.get(host);  
                if (cookiesList != null){  
                    cookiesMap.remove(host);  
                }  
                //再重新天添加  
                cookiesMap.put(host, arg1);  
            }  
              
            @Override  
            public List<Cookie> loadForRequest(HttpUrl arg0) {  
                // TODO Auto-generated method stub  
                List<Cookie> cookiesList = cookiesMap.get(arg0.host());  
                //注：这里不能返回null，否则会报NULLException的错误。  
                //原因：当Request 连接到网络的时候，OkHttp会调用loadForRequest()  
                return cookiesList != null ? cookiesList : new ArrayList<Cookie>();  
            }  
        };  
        //创建OkHttpClient  
        OkHttpClient client = new OkHttpClient.Builder()  
                        .connectTimeout(5000, TimeUnit.MILLISECONDS)  
                        .cookieJar(cookieJar)  
                        .build();  
        //创建登陆的表单  
        FormBody loginBody = new FormBody.Builder()  
                    .add("username", "admin")  
                    .add("password", "123456")  
                    .build();//账号密码自己填  
        //创建Request请求  
        Request loginRequest = new Request.Builder()  
                        .url("http://localhost:8080/userLogin")  
                        .post(loginBody)  
                        .build();  
        //上传  
        Call loginCall = client.newCall(loginRequest);  
          
        try {  
            //非异步执行  
            Response loginResponse = loginCall.execute();  
            //测试是否登陆成功  
            System.out.println(loginResponse.body().string());  
            //获取返回数据的头部  
            Headers headers = loginResponse.headers();  
            HttpUrl loginUrl = loginRequest.url();  
            //获取头部的Cookie,注意：可以通过Cooke.parseAll()来获取  
            List<Cookie> cookies = Cookie.parseAll(loginUrl, headers);  
            //防止header没有Cookie的情况  
            if (cookies != null){  
                //存储到Cookie管理器中  
                client.cookieJar().saveFromResponse(loginUrl, cookies);//这样就将Cookie存储到缓存中了  
            }  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
          
        //获取需要提交的CookieStr  
        StringBuilder cookieStr = new StringBuilder();  
        //从缓存中获取Cookie  
        List<Cookie> cookies = client.cookieJar().loadForRequest(loginRequest.url());  
        //将Cookie数据弄成一行  
        for(Cookie cookie : cookies){  
            cookieStr.append(cookie.name()).append("=").append(cookie.value()+";");  
        }  
        System.out.println(cookieStr.toString());  
        //设置提交的请求  
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
//            //连接网络  
//            Response attentionResponse = attentionCall.execute();  
//            System.out.println("5555");  
//
//            if (attentionResponse.isSuccessful()){  
//                System.out.println("6666");  
//
//                //获取返回的数据  
//                String data = attentionResponse.body().string();  
//                System.out.println("77777");  
//
//                //测试  
//                System.out.println(data);  
//                System.out.println("88888");  
//
//                //解析数据  
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

		                //获取返回的数据  
		                String data = response.body().string();  
		                System.out.println("77777");  

		                //测试  
		                System.out.println(data);  
		                System.out.println("88888");  

		                //解析数据  

		            }  
		            
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		
    }  
	

}
