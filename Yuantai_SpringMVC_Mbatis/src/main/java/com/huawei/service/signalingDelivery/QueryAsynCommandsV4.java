package com.huawei.service.signalingDelivery;

import java.util.HashMap;
import java.util.Map;

import com.huawei.utils.Constant;
import com.huawei.utils.HttpsUtil;
import com.huawei.utils.JsonUtil;
import com.huawei.utils.StreamClosedHttpResponse;

/**
 * This interface is used by NAs to query delivered commands.
 */
public class QueryAsynCommandsV4 {


	public static String QueryAsynCommandsV4(String idx,Integer pageNo) throws Exception {

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication，get token
        String accessToken = login(httpsUtil);

        //Please make sure that the following parameter values have been modified in the Constant file.
		String appId = Constant.APPID;
        String urlQueryDeviceCMD = Constant.QUERY_DEVICE_CMD;
        
        Map<String, String> paramPostAsynCmd = new HashMap<>();
        paramPostAsynCmd.put("deviceId", idx);
        paramPostAsynCmd.put("pageNo", Integer.toString(pageNo));
        paramPostAsynCmd.put("pageSize", Integer.toString(10));
        
//        String jsonRequest = JsonUtil.jsonObj2Sting(paramPostAsynCmd);
        
        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);
        
        StreamClosedHttpResponse responseQueryDeviceCMD = httpsUtil.doGetWithParasGetStatusLine(urlQueryDeviceCMD, paramPostAsynCmd, header);
        
        System.out.println("QueryAsynCommands, response content:");
		System.out.print(responseQueryDeviceCMD.getStatusLine());
		System.out.println(responseQueryDeviceCMD.getContent());
        System.out.println();
        return responseQueryDeviceCMD.getContent();
    }

    /**
     * Authentication，get token
     * */
    @SuppressWarnings("unchecked")
    public static String login(HttpsUtil httpsUtil) throws Exception {

        String appId = Constant.APPID;
        String secret = Constant.SECRET;
        String urlLogin = Constant.APP_AUTH;

        Map<String, String> paramLogin = new HashMap<>();
        paramLogin.put("appId", appId);
        paramLogin.put("secret", secret);

        StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, paramLogin);

        System.out.println("app auth success,return accessToken:");
        System.out.print(responseLogin.getStatusLine());
        System.out.println(responseLogin.getContent());
        System.out.println();

        Map<String, String> data = new HashMap<>();
        data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
        return data.get("accessToken");
    }

}