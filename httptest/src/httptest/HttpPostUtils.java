package httptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

/**
 * Created by 桐木木 on 2017/2/8.
 * 发送Http请求，获取Controller返回的数据
 *
 */

public class HttpPostUtils {
    public static String doPostRequest(String path,Object content){
        PrintWriter out = null;
        BufferedReader in = null;
        String resoult = "";
        try {
            System.out.println("要发送的信息是："+content);
            /*拼接url,Android这里需要换上远程地址，因为Android端没办法访问localhost，java的话本地tomcat运行的话倒是无妨*/
            String address = "http://localhost:8080/"+path;
            URL url = new URL(address);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            //这两个参数必须加
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            //设置超时时间
            httpURLConnection.setReadTimeout(10*1000);
            httpURLConnection.setConnectTimeout(10*1000);
            httpURLConnection.setRequestMethod("POST");
//            httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");   
            
            httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");   
            httpURLConnection.setRequestProperty("User-Agent","Android");   
            
            httpURLConnection.connect();

            out = new PrintWriter(httpURLConnection.getOutputStream());
            //在输出流中写入参数
            out.print(content);
            out.flush();
			StringBuilder builder = new StringBuilder();

            if(httpURLConnection.getResponseCode() == 200){
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
                
                
    			Map map = httpURLConnection.getHeaderFields();
    			List<String> list = (List) map.get("Set-Cookie");
    			for(String str : list)
    			{
    				builder.append(str);
    			}
    			
                
                String line;
                while((line=in.readLine())!=null){
                    resoult+=line;
                }
            }
            System.out.println("服务器返回的结果是："+resoult);
            return builder.toString();
        } catch (MalformedURLException e) {
            System.out.println("URL异常");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO异常");
            e.printStackTrace();
        }finally {
            try{
                if(out!=null)
                    out.close();
                if(in!=null)
                    in.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    
    
    
    public static String dogetRequest(String path,Object content){
        PrintWriter out = null;
        BufferedReader in = null;
        String resoult = "";
        try {
            System.out.println("要发送的信息是："+content);
            /*拼接url,Android这里需要换上远程地址，因为Android端没办法访问localhost，java的话本地tomcat运行的话倒是无妨*/
            String address = "http://localhost:8080/"+path;
            URL url = new URL(address);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            //这两个参数必须加
//            httpURLConnection.setDoInput(true);
//            httpURLConnection.setDoOutput(true);
            //设置超时时间
            httpURLConnection.setReadTimeout(10*1000);
            httpURLConnection.setConnectTimeout(10*1000);
            httpURLConnection.setRequestMethod("GET");
//            httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");   
            
            httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");   
//            httpURLConnection.setRequestProperty("Cookie",(String) content);   
            httpURLConnection.setRequestProperty("User-Agent","Android");   

            httpURLConnection.connect();

//            out = new PrintWriter(httpURLConnection.getOutputStream());
//            //在输出流中写入参数
//            out.print(content);
//            out.flush();

//            if(httpURLConnection.getResponseCode() == 200)
            {
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
                String line;
                while((line=in.readLine())!=null){
                    resoult+=line;
                }
            }
            System.out.println("服务器返回的结果是："+resoult);
            return resoult;
        } catch (MalformedURLException e) {
            System.out.println("URL异常");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO异常");
            e.printStackTrace();
        }finally {
            try{
                if(out!=null)
                    out.close();
                if(in!=null)
                    in.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
    
    
    public static String doJsonPostRequest(String path,JSONObject content){
        PrintWriter out = null;
        BufferedReader in = null;
        String resoult = "";
        try {
            System.out.println("要发送的信息是："+content);
            /*拼接url,Android这里需要换上远程地址，因为Android端没办法访问localhost，java的话本地tomcat运行的话倒是无妨*/
            String address = "http://localhost:8080/iot/"+path;
            URL url = new URL(address);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            //这两个参数必须加
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            //设置超时时间
            httpURLConnection.setReadTimeout(10*1000);
            httpURLConnection.setConnectTimeout(10*1000);
            httpURLConnection.setRequestMethod("POST");
//            httpURLConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");   
            
            httpURLConnection.setRequestProperty("Content-Type","application/json");   
            
            httpURLConnection.connect();

            out = new PrintWriter(httpURLConnection.getOutputStream());
            //在输出流中写入参数
            String content1 = content.toString();//java.net.URLEncoder.encode(content.toString(), "utf-8");
			System.out.println("服务器doJsonPostRequest返回的数据为：" + content1);

            out.print(content1);
            out.flush();

            if(httpURLConnection.getResponseCode() == 200){
                in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
                String line;
                while((line=in.readLine())!=null){
                    resoult+=line;
                }
            }
            System.out.println("服务器返回的结果是："+resoult);
            return resoult;
        } catch (MalformedURLException e) {
            System.out.println("URL异常");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO异常");
            e.printStackTrace();
        }finally {
            try{
                if(out!=null)
                    out.close();
                if(in!=null)
                    in.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
