package com.sinosoft.sms.messageinterface.business;

import com.sinosoft.sms.messageinterface.parse.MessageCode;


/*******************************************************************************
 * <p>Title: Lis 6.0</p>
 * <p>Description: 中科软人寿保险核心业务管理系统</p>
 * <p>Copyright: Copyright (c) 2005 Sinosoft, Co.,Ltd. All Rights Reserved</p>
 * <p>Company: 中科软科技股份有限公司</p>
 * <p>WebSite: http://www.sinosoft.com.cn</p>
 *
 * @author   : zhouxaing
 * @version  : 1.00
 * @date     : 2012-08-08
 * @direction: 修改绑定手机号
 ******************************************************************************/

public class MsgModifyMoibleBindingBusiness extends MessageBusinessBL
{
    private String mobilenum;
    private String membername;
    private String unitcode;
    private String captcha;

    protected boolean checkData()
    {
    	
        mobilenum = super.getInput(MessageCode.MOBILENUM);
        membername= super.getInput(MessageCode.MEMBERNAME);
        unitcode=super.getInput(MessageCode.MANAGECOM);
        captcha=super.getInput(MessageCode.CAPTCHA);
//
//        tSQL.append("select messageid  from LIMessageInteract ");
//        tSQL.append("  where servicecode = '");
//        tSQL.append(MessageCode.Msg_BIRTHDAY);
//        tSQL.append("' and servicebussno = '");
//        tSQL.append(appntno);
//        tSQL.append("' and mobilenum ='");
//        tSQL.append(mobilenum);
//        tSQL.append("' and to_char(makedate, 'yyyy') = to_char(date'");
//        tSQL.append(PubFun.getCurrentDate());
//        tSQL.append("', 'yyyy')  ");
//        tSSRS = tExeSQL.execSQL(tSQL.toString());
//        if (tSSRS.getMaxRow() > 0)
//        {
//        	super.mErrors.clearErrors();
//            super.mErrors.addOneError("此客户相同手机号今年已经发送过生日短信。");
//            return false;
//        }

        return true;
    }
    protected boolean dealData()
    {
    	String senddata =membername+";"+captcha;
        super.addMobileNum(mobilenum);
        super.addSendData(senddata);
        super.addManageCom(unitcode);
        super.addCaptcha(captcha);
        super.addResult();

        return true;

    }

}
