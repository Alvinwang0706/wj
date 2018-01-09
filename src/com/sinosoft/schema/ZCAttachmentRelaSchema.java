package com.sinosoft.schema;

import com.sinosoft.framework.data.DataColumn;
import com.sinosoft.framework.orm.Schema;
import com.sinosoft.framework.orm.SchemaSet;
import com.sinosoft.framework.orm.SchemaColumn;
import com.sinosoft.framework.data.QueryBuilder;

/**
 * 表名称：附件关联表<br>
 * 表代码：ZCAttachmentRela<br>
 * 表主键：ID, RelaID, RelaType<br>
 */
public class ZCAttachmentRelaSchema extends Schema {
	private Long ID;

	private Long RelaID;

	private String RelaType;

	public static final SchemaColumn[] _Columns = new SchemaColumn[] {
		new SchemaColumn("ID", DataColumn.LONG, 0, 0 , 0 , true , true),
		new SchemaColumn("RelaID", DataColumn.LONG, 1, 0 , 0 , true , true),
		new SchemaColumn("RelaType", DataColumn.STRING, 2, 20 , 0 , true , true)
	};

	public static final String _TableCode = "ZCAttachmentRela";

	public static final String _NameSpace = "com.sinosoft.schema";

	protected static final String _InsertAllSQL = "insert into ZCAttachmentRela values(?,?,?)";

	protected static final String _UpdateAllSQL = "update ZCAttachmentRela set ID=?,RelaID=?,RelaType=? where ID=? and RelaID=? and RelaType=?";

	protected static final String _DeleteSQL = "delete from ZCAttachmentRela  where ID=? and RelaID=? and RelaType=?";

	protected static final String _FillAllSQL = "select * from ZCAttachmentRela  where ID=? and RelaID=? and RelaType=?";

	public ZCAttachmentRelaSchema(){
		TableCode = _TableCode;
		NameSpace = _NameSpace;
		Columns = _Columns;
		InsertAllSQL = _InsertAllSQL;
		UpdateAllSQL = _UpdateAllSQL;
		DeleteSQL = _DeleteSQL;
		FillAllSQL = _FillAllSQL;
		HasSetFlag = new boolean[3];
	}

	protected Schema newInstance(){
		return new ZCAttachmentRelaSchema();
	}

	protected SchemaSet newSet(){
		return new ZCAttachmentRelaSet();
	}

	public ZCAttachmentRelaSet query() {
		return query(null, -1, -1);
	}

	public ZCAttachmentRelaSet query(QueryBuilder qb) {
		return query(qb, -1, -1);
	}

	public ZCAttachmentRelaSet query(int pageSize, int pageIndex) {
		return query(null, pageSize, pageIndex);
	}

	public ZCAttachmentRelaSet query(QueryBuilder qb , int pageSize, int pageIndex){
		return (ZCAttachmentRelaSet)querySet(qb , pageSize , pageIndex);
	}

	public void setV(int i, Object v) {
		if (i == 0){if(v==null){ID = null;}else{ID = new Long(v.toString());}return;}
		if (i == 1){if(v==null){RelaID = null;}else{RelaID = new Long(v.toString());}return;}
		if (i == 2){RelaType = (String)v;return;}
	}

	public Object getV(int i) {
		if (i == 0){return ID;}
		if (i == 1){return RelaID;}
		if (i == 2){return RelaType;}
		return null;
	}

	/**
	* 获取字段ID的值，该字段的<br>
	* 字段名称 :附件ID<br>
	* 数据类型 :bigint<br>
	* 是否主键 :true<br>
	* 是否必填 :true<br>
	*/
	public long getID() {
		if(ID==null){return 0;}
		return ID.longValue();
	}

	/**
	* 设置字段ID的值，该字段的<br>
	* 字段名称 :附件ID<br>
	* 数据类型 :bigint<br>
	* 是否主键 :true<br>
	* 是否必填 :true<br>
	*/
	public void setID(long iD) {
		this.ID = new Long(iD);
    }

	/**
	* 设置字段ID的值，该字段的<br>
	* 字段名称 :附件ID<br>
	* 数据类型 :bigint<br>
	* 是否主键 :true<br>
	* 是否必填 :true<br>
	*/
	public void setID(String iD) {
		if (iD == null){
			this.ID = null;
			return;
		}
		this.ID = new Long(iD);
    }

	/**
	* 获取字段RelaID的值，该字段的<br>
	* 字段名称 :附件关联ID<br>
	* 数据类型 :bigint<br>
	* 是否主键 :true<br>
	* 是否必填 :true<br>
	*/
	public long getRelaID() {
		if(RelaID==null){return 0;}
		return RelaID.longValue();
	}

	/**
	* 设置字段RelaID的值，该字段的<br>
	* 字段名称 :附件关联ID<br>
	* 数据类型 :bigint<br>
	* 是否主键 :true<br>
	* 是否必填 :true<br>
	*/
	public void setRelaID(long relaID) {
		this.RelaID = new Long(relaID);
    }

	/**
	* 设置字段RelaID的值，该字段的<br>
	* 字段名称 :附件关联ID<br>
	* 数据类型 :bigint<br>
	* 是否主键 :true<br>
	* 是否必填 :true<br>
	*/
	public void setRelaID(String relaID) {
		if (relaID == null){
			this.RelaID = null;
			return;
		}
		this.RelaID = new Long(relaID);
    }

	/**
	* 获取字段RelaType的值，该字段的<br>
	* 字段名称 :附件关联类别<br>
	* 数据类型 :varchar(20)<br>
	* 是否主键 :true<br>
	* 是否必填 :true<br>
	* 备注信息 :<br>
	-1-代表此图片不属于任何ID，紧紧只是把图片???传了而已<br>
	0-文章图片<br>
	1-图片播放器图片<br>
	2-图片链接<br>
	3-站点Logo<br>
	4-栏目Logo<br>
	*/
	public String getRelaType() {
		return RelaType;
	}

	/**
	* 设置字段RelaType的值，该字段的<br>
	* 字段名称 :附件关联类别<br>
	* 数据类型 :varchar(20)<br>
	* 是否主键 :true<br>
	* 是否必填 :true<br>
	* 备注信息 :<br>
	-1-代表此图片不属于任何ID，紧紧只是把图片???传了而已<br>
	0-文章图片<br>
	1-图片播放器图片<br>
	2-图片链接<br>
	3-站点Logo<br>
	4-栏目Logo<br>
	*/
	public void setRelaType(String relaType) {
		this.RelaType = relaType;
    }

}