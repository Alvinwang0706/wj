package com.sinosoft.jdt.tb;

import com.sinosoft.jdt.ParseXMLToMapNew;
import com.sinosoft.lis.pubfun.PubFun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * 
 * ClassName: TBDeal2216 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选,不用就删除). <br/>
 * date: 2016年8月19日 上午9:21:27 <br/>
 *
 * @author taoqiwen
 * @version
 */
public class TBDeal2216 implements TBDealInterfaceNew {
	private static final Logger logger = LoggerFactory.getLogger(TBDeal2216.class);

	@Override
	public boolean dealData(HashMap<String, Object> resultMap, String strManageCom, String strOrderSn,String insuredSn)
	{
		try {
			ParseXMLToMapNew parse = new ParseXMLToMapNew();
			HashMap<String, Object> resMap = new HashMap<String, Object>();
			boolean isB2b = PubFun.getChannelsnByOrdersn(strOrderSn);
			if(isB2b){
				resMap = parse.dealData("03", strManageCom, strOrderSn,insuredSn);
			}else{
				resMap = parse.dealData("01", strManageCom, strOrderSn,insuredSn);
			}
			
			resultMap.put("BK_SERIAL", resMap.get("BK_SERIAL"));
			
			String passFlag = resMap.get("passFlag").toString();
			if ("pass".equals(passFlag)) {
				resultMap.put("appStatus", "1");// 标记成功
				resultMap.put("policyNo", resMap.get("policyNo"));
				resultMap.put("policyPath", resMap.get("policyPath"));
				resultMap.put("totalPremium", resMap.get("totalPremium"));
			} else {
				resultMap.put("appStatus", "0");// 标记失败
			}
			resultMap.put("PA_RSLT_CODE", resMap.get("PA_RSLT_CODE") + "");
			resultMap.put("PA_RSLT_MESG", resMap.get("PA_RSLT_MESG") + "");
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap.put("PA_RSLT_MESG", e.getMessage());
			resultMap.put("appStatus", "0");// 标记失败
			return false;
		}
		return true;
	}

	@Override
	public boolean dealCancelData(HashMap<String, Object> resultMap,
			String strManageCom, String ordersn, String insuredSn) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
