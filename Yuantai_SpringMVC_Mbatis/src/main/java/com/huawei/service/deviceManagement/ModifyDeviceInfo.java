package com.huawei.service.deviceManagement;

import java.util.HashMap;
import java.util.Map;

import com.huawei.common.model.MDeviceInfo;
import com.huawei.utils.Constant;
import com.huawei.utils.HttpsUtil;
import com.huawei.utils.JsonUtil;
import com.huawei.utils.StreamClosedHttpResponse;

/**
 * Set device information:
 * This interface is used by an NA to set or modify device information.
 */
public class ModifyDeviceInfo {

	public static String ModifyDeviceInfo(MDeviceInfo entity) throws Exception {

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication，get token
        String accessToken = login(httpsUtil);

        //Please make sure that the following parameter values have been modified in the Constant file.
		String appId = Constant.APPID;

        //please replace the deviceId, when you use the demo.
        String deviceId = entity.getDeviceId();
        String urlModifyDeviceInfo = Constant.MODIFY_DEVICE_INFO + "/" + deviceId;

        //please replace the following parameter values, when you use the demo.
        //And those parameter values must be consistent with the content of profile that have been preset to IoT platform.
        //The following parameter values of this demo are use the watermeter profile that already initialized to IoT platform.
        String name= entity.getName();        
        String manufacturerId= entity.getManufacturerId();
        String manufacturerName = entity.getManufacturerName();
        String deviceType = entity.getDeviceType();
        String model = entity.getModel();
        String protocolType = entity.getProtocolType();

        Map<String, Object> paramModifyDeviceInfo = new HashMap<>();
        paramModifyDeviceInfo.put("name", name);
        paramModifyDeviceInfo.put("manufacturerId", manufacturerId);
        paramModifyDeviceInfo.put("manufacturerName", manufacturerName);
        paramModifyDeviceInfo.put("deviceType", deviceType);
        paramModifyDeviceInfo.put("model", model);
        paramModifyDeviceInfo.put("protocolType", protocolType);

        String jsonRequest = JsonUtil.jsonObj2Sting(paramModifyDeviceInfo);

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        StreamClosedHttpResponse responseModifyDeviceInfo = httpsUtil.doPutJsonGetStatusLine(urlModifyDeviceInfo,
                header, jsonRequest);

        System.out.println("ModifyDeviceInfo, response content:");
        System.out.print(responseModifyDeviceInfo.getStatusLine());
        System.out.println(responseModifyDeviceInfo.getContent());
        System.out.println();
        return responseModifyDeviceInfo.getContent();
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