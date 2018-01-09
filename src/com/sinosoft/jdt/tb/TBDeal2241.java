package com.sinosoft.jdt.tb;

import com.sinosoft.jdt.ParseXMLToMapNew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * 处理平安健康承保报文发送和返回报文解析等
 * @author ncc
 *
 */
public class TBDeal2241 implements TBDealInterfaceNew {
	private static final Logger logger = LoggerFactory.getLogger(TBDeal2241.class);

	@Override
	public boolean dealData(HashMap<String, Object> resultMap, String strManageCom, String strOrderSn, String insuredSn) {
		try {
			ParseXMLToMapNew parse = new ParseXMLToMapNew();
			HashMap<String, Object> resMap = parse.dealData("09", strManageCom, strOrderSn, insuredSn);
			
			resultMap.put("BK_SERIAL", resMap.get("BK_SERIAL"));
			resultMap.put("PA_RSLT_CODE", resMap.get("PA_RSLT_CODE"));
			resultMap.put("PA_RSLT_MESG", resMap.get("rtnMessage"));
			String passFlag = resMap.get("passFlag").toString();
			if ("pass".equals(passFlag)) {
				resultMap.put("appStatus", "1");// 标记成功
				resultMap.put("policyNo", resMap.get("policyNo"));
				resultMap.put("policyPath", resMap.get("policyPath"));
			} else {
				resultMap.put("appStatus", "0");// 标记失败
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			resultMap.put("PA_RSLT_MESG", e.getMessage());
			resultMap.put("appStatus", "0");// 标记失败
			return false;
		}
		return true;
	}

	@Override
	public boolean dealCancelData(HashMap<String, Object> resultMap, String comCode, String ordersn, String insuredSn) {
		try{
			ParseXMLToMapNew parse = new ParseXMLToMapNew();
			HashMap<String, Object> resMap = parse.dealData("02", comCode, ordersn, insuredSn);
			resultMap.put("passFlag", resMap.get("passFlag"));
			resultMap.put("rtnMessage", resMap.get("rtnMessage"));// 标记失败
		} catch (Exception e) {
			resultMap.put("rtnMessage", e.getMessage());
			resultMap.put("passFlag", "nopass");// 标记失败
		}
		return true;
	}

}
