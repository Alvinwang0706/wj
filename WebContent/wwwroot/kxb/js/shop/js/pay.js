var last_couponsn='';
//支付方式tag切换
  jQuery(function(){ 
	  jQuery(".yhj-des-link li").taghoverbind({showClass:".yhj_jts"});
			 jQuery('#pay_bank_box > div:not(:first)').hide();
			  
            jQuery('#tag_box li a').click(  
			function()
            {
                jQuery(this).parent().addClass('select_banks').siblings().removeClass('select_banks');
                jQuery('#pay_bank_box > div:eq('+ jQuery('#tag_box li').index(jQuery(this).parent()) +')').show().siblings().hide();
            });

	
	/*积分优惠券切换*/
	var jf_gl = jQuery('#pay_yhj_gl');
	var jf_box = jQuery('#pay_yhj_box'); 
	var yhj_gl = jQuery('#pay_jf_gl');
	var yhj_box = jQuery('#pay_jf_box');
	var basePoint = 0;
	var point = 0;
	var shopcartflag = jQuery("#shopcartflag").val();
	if(jQuery('#loginFlag').val()=="true" || shopcartflag=="1"){
		showCoupon();
	}
	
	function showCoupon(){
		/**
		 * 符合此次订单规则的优惠券展示
		 */

		var shopcartflag = jQuery("#shopcartflag").val();
		var path = sinosoft.base + "/shop/pay!showCoupon.action?&OrdId="
				+ jQuery("#yhj_orderId").val();
		if (shopcartflag=="1") {// 购物车
			path = sinosoft.base
					+ "/shop/pay!showShopCartCoupon.action?&OrdId="
					+ jQuery("#yhj_orderId").val();
		}
		jQuery.ajax({
			type : "post",
			url : path,
			dataType : "json",
			async : false,
			success : function(data) {
				jQuery.each(data, function(index, object) {
					if ("success" == index) {
						if (object != "") {
							jQuery("#yhj_jh_div").show();
							jf_box.show();
							jf_gl.addClass("active_s");
						}
						jQuery("#yhj_list").show();
						jQuery("#yhj_list").html(object);
					}
				});
			}
		});
	}
	function initCoupon() {
		if (jf_box.is(":visible")) {
			jf_box.hide();
			jf_gl.removeClass("active_s");
		} else {
			jf_box.show();
			jf_gl.addClass("active_s");
		}

	}
	jf_gl.click(function() {
		initCoupon();
	});
	/**
	 * 初始化会员总积分
	 */
	if (jQuery("#channelsn").val() != 'jfsc' && jQuery("#channelsn").val() != 'wj_jfsc' && jQuery("#channelsn").val() != 'wap_jfsc') {
		if (jQuery("#yhj_orderId").val() != undefined) {
			jQuery.ajax( {
				type : "post",
				url : sinosoft.base + "/shop/pay!showPoint.action?OrdId="+jQuery("#yhj_orderId").val(),
				dataType : "json",
				async : false,
				success : function(data) {
					jQuery.each(data, function(index, object) {
						if ("success" == index) {
							jQuery("#member_jf_one").html(object);
						}
						if ("paysuccess" == index) {
							jQuery("#memberpoint").val(object);
							point=object;
							if(point=='0'){ // 如果不可使用积分抵保费，隐藏'积分抵消部分总额'功能
								jQuery("#pay_jf_box").hide(); 
								jQuery("#pay_jf_gl").hide();
							}
							
						}
						if("BasePoint" == index){
							basePoint=object;
						}
						if("PointScalerUnit" == index){
							jQuery("#PointScalerUnit").val(object);
						}
						
					});
				}
			});
		}
	}
	if(point - basePoint > 0){
		initJF();
	}
	function initJF() {

		if (yhj_box.is(":visible")) {
			yhj_box.hide();
			yhj_gl.removeClass("active_s");
		} else {
			if (jQuery("#jf_zero").val() != "true") {
				return;
			}
			var shopcartflag = jQuery("#shopcartflag").val();
			var p_price = jQuery("#p_price").html();
			var pay_price = jQuery("#pay_price").html();
			var member_jf_one = parseInt(jQuery("#member_jf_one").html());
			var member_jf_two = parseInt(jQuery("#memberpoint").val());
			if (shopcartflag == '1') {
				var ord_price = jQuery("#ord_price").html();
				//var poi = parseInt((p_price * jQuery("#PointScalerUnit").val()).toFixed(0));
				if (parseInt(member_jf_two) < parseInt(member_jf_one)) {
					jQuery("#member_jf_two").html(member_jf_two);
				} else {
					jQuery("#member_jf_two").html(member_jf_one);
				}
			} else {
				if (p_price != '') {
					//var poi = parseInt((p_price * jQuery("#PointScalerUnit").val()).toFixed(0));
					if (parseInt(member_jf_two) < parseInt(member_jf_one)) {
						jQuery("#member_jf_two").html(member_jf_two);
					} else {
						jQuery("#member_jf_two").html(member_jf_one);
					}
				} else {
					//var poi = parseInt((p_price * jQuery("#PointScalerUnit").val()).toFixed(0));
					if (parseInt(member_jf_two) < parseInt(member_jf_one)) {
						jQuery("#member_jf_two").html(member_jf_two);
					} else {
						jQuery("#member_jf_two").html(member_jf_one);
					}
				}
			}
			yhj_box.show();
			yhj_gl.addClass("active_s");
		}

	}
	yhj_gl.click(function() {
		initJF();
//		chooseYHJ();
		if(jQuery("#CouponSn").val()!=''&&jQuery("#CouponSn").val()!='0'){
			var couponsn = jQuery("#CouponSn").val();
			jQuery('input:checkbox[name="yhj_dx_input"]').each(function(){
				if (jQuery(this).val()==couponsn) {
					last_couponsn='';
					jQuery(this).attr("checked",'checked');
					chooseYHJ(this);
				}
			});
		}else{
			chooseYHJ();
		}
	});
	
	/**
	 * 优惠券激活切换
	 */
	var make_yhj = jQuery('#yhj_jh');
	make_yhj.click(function() {
		if (jQuery(".pre_yh_txt").is(":visible")) {
			jQuery(".pre_yh_txt").hide();
		} else {
			jQuery(".pre_yh_txt").show();
		}
	});
	/**
	 * 优惠券激活
	 */
	var yhj_jh_button = jQuery('#yhj_jh_button');
	yhj_jh_button.click(function() {
		var couponsn=jQuery("#jhm_text").val();
		jQuery.ajax({
		    url: sinosoft.base+"/shop/pay!couponVerify.action?couponSn="+couponsn+"&OrdId="+jQuery("#yhj_orderId").val()+"&paySn="+jQuery("#paySn").val()+"&flag=true",
		    type: "post",
			dataType: "json",
			success: function(data) {
				if (data.status == "success") {
					art.dialog({
					    id:'yhj_log',
					    padding: '25px 50px 5px 50px',
					    drag:false,
					    title:'激活优惠券',
					    content: '恭喜您优惠券激活成功！',
					    button:[{name: '确认'}] 
					});
					var shopcartflag=jQuery("#shopcartflag").val();
					var path=sinosoft.base + "/shop/pay!showCoupon.action?&OrdId="+jQuery("#yhj_orderId").val();
					if(shopcartflag=='1'){//购物车
						path=sinosoft.base + "/shop/pay!showShopCartCoupon.action?&OrdId="+jQuery("#yhj_orderId").val();
					}
					jQuery.ajax( {
						type : "post",
						url : path,
						dataType : "json",
						async : false,
						success : function(data) {
							jQuery.each(data, function(index, object) {
								if ("success" == index) {
									jQuery("#yhj_list").show();
									jQuery("#yhj_list").html(object);
								}
							});
						}
					});
					jQuery('input:checkbox[name="yhj_dx_input"]').each(function(){
						if (jQuery(this).val()==couponsn) {
							jQuery(this).attr("checked",'checked');
							chooseYHJ(this);
						}
					})
					
					return;
				}else{
					art.dialog({
					    id:'yhj_log',
					    padding: '25px 50px 5px 50px',
					    drag:false,
					    title:'激活优惠券',
					    content: data.message,
					    button:[{name: '确认'}] 
					});
					return;
					}
				}
		  });  
	});
});
  
 jQuery("#jfzf_botton").click(function(){
	 chooseYHJ();
 });
/**
 * 优惠券单选按钮的选择
 */
function  chooseYHJ(dom) {
	jQuery("#jf_zero").val("true");
	var list = art.dialog.list;
	for (var i in list) {
	    list[i].close();
	};
	jQuery("#yh_price").hide();
	jQuery('input[id="mj_activity"]').attr("checked",false);
	var couponsn=jQuery(dom).val();
	if(couponsn==last_couponsn){
		jQuery('#yhq_price').empty();
		jQuery('#yhq_price').hide();
		last_couponsn='';
		couponsn="0";//CouponSn 隐藏域初始为0 
	}else{
		jQuery('#yhj_list input:checkbox[name="yhj_dx_input"]').removeAttr("checked"); 
		jQuery(dom).attr("checked",true);
		last_couponsn=couponsn;//记录上一次选中的优惠券码
	}
//	var couponsn=jQuery(dom).val();
//	if(jQuery('input:checkbox[name="yhj_dx_input"]:checked').length &&jQuery('input:checkbox[name="yhj_dx_input"]:checked').length>0){
//		var couponsn=jQuery('input:checkbox[name="yhj_dx_input"]:checked').val();
//		alert(couponsn);
//	}else{
//		var couponsn='';
//	}
	jQuery("#CouponSn").val(couponsn);
	var t = jQuery("#yhj_tb_des");  // 优惠价格提示信息
	var p = jQuery("#pay_price");   // 价格信息
	//积分取消
	jQuery("#jf_sy").show();
	jQuery("#jf_qx").hide();
	jQuery('input[name="point_dz"]').eq(0).removeClass("pay_jf_txt pay_errors");
	jQuery('input[name="point_dz"]').eq(0).addClass("pay_jf_txt");
	jQuery('input[name="point_dz"]').eq(0).val('');
	jQuery('input[name="point_dz"]').eq(1).val('');
	jQuery("#jfsy_span").html('');
	jQuery("#jfqx_span").html('');
	 
	jQuery.ajax({
	    url: sinosoft.base+"/shop/pay!couponVerify.action?CouponSn="+couponsn+"&OrdId="+jQuery("#yhj_orderId").val()+"&paySn="+jQuery("#paySn").val(),
	    type: "post",
		dataType: "json",
		success: function(data) {
			// 积分换算一元单位
			var PointScalerUnit = data.PointScalerUnit;
			if (data.status == "success") {
				var ord_num = data.ordernum; //返回订单数目
				jQuery("#ord_num").html(ord_num);
				var pay = data.totalAmount; //返回订单总价格
				//jQuery("#ord_price").html(pay);
				var yh = data.parValue; //返回优惠券优惠价格
				if(Number(yh)!=0){
					jQuery("#yhq_price").html("<td class=\"gwc_js_table\"></td><td class=\"gwc_js_table_w\">" +
							" <span class=\"gwc_dd\" >优惠劵：</span> </td>" +
							"<td class=\"gwc_js_table_pay\"> <span class=\"gwc_dd\"><b>￥</b><i>-"+yh.toFixed(2)+"</span></i></td>");
					jQuery("#yhq_price").show();	
				}
				//var endpay = Number(pay) - Number(yh);//实际支付金额
				var endpay = data.totalAmount;//实际支付金额
				var endpay = data.totalAmount;//实际支付金额
				jQuery("#p_price").html(data.totalAmount);
				jQuery("#CouponSn").val(couponsn);//优惠券号赋值到隐藏域，以便表单提交数据
				if(Number(endpay)<=0){
					jQuery("#jfzf_botton").show();
					jQuery("#p_price").html("0");
					jQuery("#jf_zero").val("false");
					jQuery("#pay_zero_box").show();
					//积分输入收起
					jQuery('#pay_jf_box').hide();
					jQuery('#pay_jf_gl').removeClass("active_s");
				}else{
					jQuery("#pay_zero_box").hide();
					jQuery("#jfzf_botton").hide();
				}
				var maxpoints = data.maxpoints; //订单最多积分
				var memberpoint=jQuery("#memberpoint").val();
				if(parseInt(memberpoint)<=parseInt(maxpoints)){
					jQuery("#member_jf_two").html(memberpoint);
				}else{
					jQuery("#member_jf_two").html(maxpoints);
				}
			}else{
				 // 优惠券号验证错误时清空隐藏域中的值
				 jQuery("#CouponSn").val("");
				 var pay = data.totalAmount; //返回订单总价格
				 //jQuery("#ord_price").html(pay.toFixed(2));
				 jQuery("#p_price").html(pay);
				 jQuery("#pay_zero_box").hide();
				 jQuery("#jfzf_botton").hide();
			}
			//可使用积分发生变化
			//var member_jf_two=jQuery("#member_jf_one").html();
			var member_jf_two=jQuery("#memberpoint").val();;
			var ord_price=jQuery("#p_price").html();
			var maxpoints = data.maxpoints; //订单最多积分
			//var poi=parseInt((ord_price*PointScalerUnit).toFixed(0));
			if(parseInt(member_jf_two)<parseInt(maxpoints)){
				jQuery("#member_jf_two").html(member_jf_two);
			}else{
				jQuery("#member_jf_two").html(maxpoints);
			}
			jQuery("#offsetPoint").val("0");
			//赠送积分
			jQuery("#givepoint").html(data.givepoint);
			jQuery("#givepointvalue").html(data.givepointvalue);
		}
	  });  
};
/**
 * 积分使用
 * @return
 */
function jfsy() {
	var point = jQuery('input[name="point_dz"]').eq(0).val();
	var numreg = /^[0-9]*[1-9][0-9]*$/;
	if (!numreg.test(point)) {
		jQuery("#jf_sy").show();
		jQuery("#jf_qx").hide();
		jQuery('input[name="point_dz"]').eq(0).addClass("pay_jf_txt pay_errors");
		jQuery("#jfsy_span").html("<span class=\"red\">请输入正确的数字</span>");
		return false;
	}
	if(parseInt(point)<1){
		jQuery("#jf_sy").show();
		jQuery("#jf_qx").hide();
		jQuery('input[name="point_dz"]').eq(0).addClass("pay_jf_txt pay_errors");
		jQuery("#jfsy_span").html("<span class=\"red\">积分抵值的数额不能小于1</span>");
		return false;
	}
	var can_use_poit=jQuery('#member_jf_two').html();
	if(parseInt(point)>parseInt(can_use_poit)){
		jQuery("#jf_sy").show();
		jQuery("#jf_qx").hide();
		jQuery('input[name="point_dz"]').eq(0).addClass("pay_jf_txt pay_errors");
		jQuery("#jfsy_span").html("<span class=\"red\">您本次最多使用" + can_use_poit+ "积分</span>");
		return false;
	}
	jQuery.ajax( {
				type : "post",
				url : sinosoft.base + "/shop/pay!usePoint.action?point="+point+"&OrdId="+jQuery("#yhj_orderId").val()+"&CouponSn="+jQuery("#CouponSn").val(),
				dataType : "json",
				async : false,
				success : function(data) {
					if (data.status == "success") {
						var PointScalerUnit = parseInt(data.PointScalerUnit);
						jQuery("#jf_sy").hide();
						jQuery("#jf_qx").show();
						jQuery('input[name="point_dz"]').eq(1).val(data.usepoint);
						jQuery("#jfqx_span").html("使用<span class=\"red\">"+data.usepoint+ "</span>积分，折合人民币<span class=\"red\">"+data.pointValue+"</span>元");
						
						jQuery("#yh_price").show();
						var ord_num = data.ordernum; //返回订单数目
						jQuery("#ord_num").html(ord_num);
						var pay = data.totalAmount; //返回订单总价格
						//jQuery("#ord_price").html(pay.toFixed(2));
						var yh = data.parValue; //返回优惠券优惠价格
						
						
						jQuery("#jf_price_div").remove();
						jQuery("#yh_price").html("<td class=\"gwc_js_table\"></td><td class=\"gwc_js_table_w\">" +
								" <span class=\"gwc_dd\" >积分抵值：</span> </td>" +
								"<td class=\"gwc_js_table_pay\"> <span class=\"gwc_dd\"><b>￥</b><i>-"+data.pointValue.toFixed(2)+"</i></span></td>");
						//隐藏域中赋值抵值积分
						jQuery("#offsetPoint").val(data.usepoint);
						var realamount=data.realamount;//实际支付金额
						jQuery("#p_price").html(realamount.toFixed(2));
						//赠送积分
						jQuery("#givepoint").html(data.givepoint);
						jQuery("#givepointvalue").html(data.givepointvalue);
						if(Number(realamount)<=0){
							jQuery("#jfzf_botton").show();
							jQuery("#p_price").html("0");
							jQuery("#pay_zero_box").show();
						}else{
							jQuery("#pay_zero_box").hide();
							jQuery("#jfzf_botton").hide();
						}
						return;
					} else {
						jQuery("#jf_sy").show();
						jQuery("#jf_qx").hide();
						jQuery('input[name="point_dz"]').eq(0).addClass("pay_jf_txt pay_errors");
						jQuery("#jfsy_span").html("<span class=\"red\">" + data.message+ "</span>");
					}
				}
			});
};
/**
 * 积分取消
 * @return
 */
function jfqx() {
	jQuery("#jf_sy").show();
	jQuery("#jf_qx").hide();
	jQuery("#yh_price").hide();
	jQuery('input[name="point_dz"]').eq(0).removeClass("pay_jf_txt pay_errors");
	jQuery('input[name="point_dz"]').eq(0).addClass("pay_jf_txt");
	jQuery('input[name="point_dz"]').eq(0).val('');
	jQuery('input[name="point_dz"]').eq(1).val('');
	jQuery("#jfsy_span").html('');
	jQuery("#jfqx_span").html('');
	//隐藏域中抵值积分清空
	jQuery("#offsetPoint").val("0");
	if(jQuery("#CouponSn").val()!=''&&jQuery("#CouponSn").val()!='0'){
		var couponsn = jQuery("#CouponSn").val();
		jQuery('input:checkbox[name="yhj_dx_input"]').each(function(){
			if (jQuery(this).val()==couponsn) {
				last_couponsn='';
				jQuery(this).attr("checked",'checked');
				chooseYHJ(this);
			}
		});
//		chooseYHJ();
	}else{
		chooseYHJ();
	}
};
/**
 * 保留两位小数，末位用0补齐
 * @return
 */
function format(val){
	val=val+"";
	if(val.indexOf(".")!=-1){
		if((val.length-val.indexOf("."))==2){
			return val+"0";
		}else{
			return val;
		}
	}else{
		return val+".00";
	}
}