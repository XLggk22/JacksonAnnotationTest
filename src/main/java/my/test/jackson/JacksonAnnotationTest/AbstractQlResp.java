package my.test.jackson.JacksonAnnotationTest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class AbstractQlResp {

	/**
	 * 状态
	 */
	private String status;
	/**
	 * 错误码
	 * 失败时有值，否则为空
	 */
	private String err;
	/**
	 * 返回信息
	 */
	private String msg;
	/**
	 * 返回报文
	 */
	private String res;
	/**
	 * 签名
	 */
	private String sign;
	
	private Integer pageCount;
	
	private String code;
}
