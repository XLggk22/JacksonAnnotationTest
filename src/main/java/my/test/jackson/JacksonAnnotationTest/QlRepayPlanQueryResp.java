package my.test.jackson.JacksonAnnotationTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 前隆附件上传请求对象
 * <p>Title: QlDocUploadResponse.java</p>  
 * <p>Description: </p>  
 * @author rbh011 
 * @date 2019年2月16日 
 * @version 1.0  
 *
 */
@Data
@NoArgsConstructor
@ToString(callSuper=true)
public class QlRepayPlanQueryResp extends AbstractQlResp{
	
	//多期还款计划list
	@JsonIgnore
	private List<QlRepayPlanQueryRespBody> repayPlanList;
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class QlRepayPlanQueryRespBody{
		//期数
		private String repayNumber;
		
		//本期应还总金额
		private BigDecimal amount;
		
		//应还日期
		private Date planDate;
		
		//实还日期
		private Date actualDate;
		
		//还款状态
		private String status;
		
		//逾期天数
		private int overdueDay;
		
		//逾期费用
		private BigDecimal overdueFee;
		
		//本金
		private BigDecimal repayPrincipal;
		
		//手续费
		private BigDecimal interest;

	}
}