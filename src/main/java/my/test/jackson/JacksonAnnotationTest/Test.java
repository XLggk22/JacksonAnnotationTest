package my.test.jackson.JacksonAnnotationTest;

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;

public class Test {
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
    static {
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        MAPPER.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
    }
    
    /**
     * 字符串转为对象
     *
     * @param <T> the type parameter
     * @param str the str
     * @param clz the clz
     * @return t
     */
    public static <T> T str2Obj(String str, Class<T> clz) {
        try {
            return MAPPER.readValue(str, clz);
        } catch (IOException e) {
        	System.out.println("序列化对象出错："+str);
        	e.printStackTrace();
//            throw new ChannelException(ChannelErrorCodeEnum.JSON_DESERIALIZE_ERROR, e);
            return null;
        }

    }
	
	public static void main(String[] args) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", "0");
		jsonObj.put("err", "");
		jsonObj.put("msg", "交易成功");
		jsonObj.put("res", "[{\"amount\":1815.00,\"id\":7,\"interest\":149.00,\"orderId\":42244,\"planDate\":1550764800000,\"repayNumber\":\"1\",\"repayPrincipal\":1666.00,\"status\":\"0\"},{\"amount\":1815.00,\"id\":8,\"interest\":149.00,\"orderId\":42244,\"planDate\":1553184000000,\"repayNumber\":\"2\",\"repayPrincipal\":1666.00,\"status\":\"0\"},{\"amount\":1820.01,\"id\":9,\"interest\":152.01,\"orderId\":42244,\"planDate\":1555862400000,\"repayNumber\":\"3\",\"repayPrincipal\":1668.00,\"status\":\"0\"}]");
		jsonObj.put("sign", "15e648063e0997e003e0d5f9ef978b74");
		String jsonString = jsonObj.toJSONString();
		
		System.out.println("jsonString:" + jsonString);
		
		QlRepayPlanQueryResp resp = str2Obj(jsonString, QlRepayPlanQueryResp.class);
//		QlRepayPlanQueryResp resp = JSONObject.parseObject(jsonString, QlRepayPlanQueryResp.class);
		
		System.out.println("解析出的响应对象："+resp);
	}
}
