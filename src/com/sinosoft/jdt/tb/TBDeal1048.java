package com.sinosoft.jdt.tb;

import com.sinosoft.jdt.ParseXMLToMapNew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * 处理大都会承保报文发送和返回报文解析等
 * @author heyang 11180
 * @createDate 2012-11-14
 */
public class TBDeal1048 implements TBDealInterfaceNew
{
	private static final Logger logger = LoggerFactory.getLogger(TBDeal1048.class);
	@Override
	public boolean dealData(HashMap<String, Object> resultMap, String strManageCom, String strOrderSn,String insuredSn)
	{
		try
		{
			ParseXMLToMapNew parse = new ParseXMLToMapNew();
			HashMap<String, Object> resMap = parse.dealData("09", strManageCom, strOrderSn,insuredSn);
			
			resultMap.put("TRAN_CODE", resMap.get("TRAN_CODE"));
			resultMap.put("BK_SERIAL", resMap.get("BK_SERIAL"));
			resultMap.put("PA_RSLT_CODE", resMap.get("PA_RSLT_CODE"));
			resultMap.put("PA_RSLT_MESG", resMap.get("rtnMessage"));
			String passFlag = resMap.get("passFlag").toString();
			if ("pass".equals(passFlag))
			{
				resultMap.put("appStatus", "1");// 标记成功
				resultMap.put("BDZT", resMap.get("BDZT"));
				resultMap.put("policyNo", resMap.get("policyNo"));
				resultMap.put("remark1", resMap.get("noticeNo"));
				resultMap.put("policyPath", resMap.get("policyPath"));
			}
			else
			{
				resultMap.put("appStatus", "0");// 标记失败
			}
		}
		catch (Exception e)
		{
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
