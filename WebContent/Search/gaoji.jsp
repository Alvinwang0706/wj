<%@ page session="false" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" 
	import="com.sinosoft.search.*"
	import="com.sinosoft.cms.api.*" 
	import="com.sinosoft.framework.*"
	import="com.sinosoft.framework.utility.*"
	import="com.sinosoft.framework.data.*"
%>
<%@ taglib uri="controls" prefix="z"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'gaoji.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<style type="text/css">
*{
	margin:0px;
	padding:0px;
}
body{ font-size:12px;}
.wap{ border:1px solid #000; padding:5px; width:600px;margin:100px auto;}
.header1{
text-align: center;}
.logo{
	width:976px;
	height:126px;
	margin: 0 auto;
	background: url(header_bg.jpg) no-repeat center top;
	
}
.logo .date{
	float:left;
	color:#fff;
	margin-left:2px;
	display:inline;
	margin-top:110px;
	_margin-top:-3px;
	*margin-top:-3px;
}
.logo .date span{padding-left:10px;}
table{
	border:1px solid #adb2b6;
	background-color:#f9f7fa;
	border-collapse:collapse;
}
table tr{ border-collapse:collapse;}
table td{border:1px solid #adb2b6; padding:5px 0px 5px 15px;}
.name{width:70px; color:#006666;}
.content{width:700px;}
.content span{margin-right:20px;}
.lable{ text-align:center;}
.lable input{width:70px; color:#fff; font-weight:bold; background-color:#3CF; letter-spacing:5px; border:1px solid #000; padding:2px;}
.lable1 input{width:350px; padding:3px 0px;}
</style>

<style type="text/css">
body{font-size:12px;font-family:Verdana,Arial,"宋体";}
a:link {color:#464646;text-decoration:none;}
a:visited {color:#464646;text-decoration:none;}
a:hover{color:#ed145b;text-decoration:underline;}
a:active{color:#ed145b;text-decoration:underline;}
td{font-size:12px}
/*/*/
/*DateCSS样式*/
.header {font: 12px Arial, Tahoma !important;font-weight: bold !important;font: 11px Arial, Tahoma;font-weight: bold;color: #154BA0;background:#C2DEED;height: 25px;padding-left: 10px;
}
.header td {padding-left: 10px;}
.header a {color: #154BA0;}
.header input {background:none;vertical-align: middle;height: 16px;}
.category {font: 12px Arial, Tahoma !important;font: 11px Arial, Tahoma;color: #92A05A;height:20px;background-color: #FFFFD9;}
.category td {border-bottom: 1px solid #DEDEB8;}
.expire, .expire a:link, .expire a:visited {color: #999999;}
.default, .default a:link, .default a:visited {color: #000000;}
.checked, .checked a:link, .checked a:visited {color: #FF0000;}
.today, .today a:link, .today a:visited {color: #00BB00;}
#calendar_year {display: none;line-height: 130%;background: #FFFFFF;position: absolute;z-index: 10;}
#calendar_year .col {float: left;background: #FFFFFF;margin-left: 1px;border: 1px solid #86B9D6;padding: 4px;}
#calendar_month {display: none;background: #FFFFFF;line-height: 130%;border: 1px solid #86B9D6;padding: 4px;position: absolute;z-index: 11;}
.tableborder {background: white;border: 1px solid #86B9D6;}
#year,#month{padding-right:10px;}
</style>
<script language="javascript">
//下面的代码段如果你页面里有，可以去掉
var ie =navigator.appName=="Microsoft Internet Explorer"?true:false;
function $(objID){
return document.getElementById(objID);
}
</script>
  </head>
  
  <body>
    <div class="header1" align="center">
       <div class="header_top"><img src="er_toplip.jpg" /></div>
       <div class="logo" >
         <p class="date">北京时间：2011年11月17日<span>星期三</span></p>
       </div>
    </div>
<div class="wap">
<script type="text/javascript">
var controlid = null;
var currdate = null;
var startdate = null;
var enddate  = null;
var yy = null;
var mm = null;
var hh = null;
var ii = null;
var currday = null;
var addtime = false;
var today = new Date();
var lastcheckedyear = false;
var lastcheckedmonth = false;
function _cancelBubble(event) {
e = event ? event : window.event ;
if(ie) {
 e.cancelBubble = true;
} else {
 e.stopPropagation();
}
}
function getposition(obj) {
 var r = new Array();
 r['x'] = obj.offsetLeft;
 r['y'] = obj.offsetTop;
 while(obj = obj.offsetParent) {
 r['x'] += obj.offsetLeft;
 r['y'] += obj.offsetTop;
 }
 return r;
}
function loadcalendar() {
s = '';
s += '<div id="calendar" style="display:none; position:absolute; z-index:9;" onclick="_cancelBubble(event)">';
if (ie)
{
s += '<iframe width="200" height="160" src="about:blank" style="position: absolute;z-index:-1;"></iframe>';
}
s += '<div style="width: 200px;"><table class="tableborder" cellspacing="0" cellpadding="0" width="100%" style="text-align: center">';
///
s += '<tr align="center" class="header"><td class="header"><a href="#" onclick="refreshcalendar(yy, mm-1);return false" title="上一月"><<</a></td><td colspan="5" style="text-align: center" class="header"><a href="#" onclick="showdiv(\'year\');_cancelBubble(event);return false" title="点击选择年份" id="year"></a>  -  <a id="month" title="点击选择月份" href="#" onclick="showdiv(\'month\');_cancelBubble(event);return false"></a></td><td class="header"><A href="#" onclick="refreshcalendar(yy, mm+1);return false" title="下一月">>></A></td></tr>';
s += '<tr class="category"><td>日</td><td>一</td><td>二</td><td>三</td><td>四</td><td> 五</td><td>六</td></tr>';
for(var i = 0; i < 6; i++) {
s += '<tr class="altbg2">';
for(var j = 1; j <= 7; j++)
s += "<td id=d" + (i * 7 + j) + " height=\"19\">0</td>";
s += "</tr>";
}
s += '<tr id="hourminute"><td colspan="7" align="center"><input type="text" size="1" value="" id="hour" onKeyUp=\'this.value=this.value > 23 ? 23 : zerofill(this.value);controlid.value=controlid.value.replace(/\\d+(\:\\d+)/ig, this.value+"$1")\'> 点 <input type="text" size="1" value="" id="minute" onKeyUp=\'this.value=this.value > 59 ? 59 : zerofill(this.value);controlid.value=controlid.value.replace(/(\\d+\:)\\d+/ig, "$1"+this.value)\'> 分</td></tr>';
s += '</table></div></div>';///
s += '<div id="calendar_year" onclick="_cancelBubble(event)"><div class="col">';
for(var k = 1930; k <= 2019; k++) {
s += k != 1930 && k % 10 == 0 ? '</div><div class="col">' : '';
s += '<a href="#" onclick="refreshcalendar(' + k + ', mm);$(\'calendar_year\').style.display=\'none\';return false"><span' + (today.getFullYear() == k ? ' class="today"' : '') + ' id="calendar_year_' + k + '">' + k + '</span></a><br />';
}
s += '</div></div>';
s += '<div id="calendar_month" onclick="_cancelBubble(event)">';
for(var k = 1; k <= 12; k++) {
s += '<a href="#" onclick="refreshcalendar(yy, ' + (k - 1) + ');$(\'calendar_month\').style.display=\'none\';return false"><span' + (today.getMonth()+1 == k ? ' class="today"' : '') + ' id="calendar_month_' + k + '">' + k + ( k < 10 ? ' ' : '') + ' 月</span></a><br />';
}
s += '</div>';
var nElement = document.createElement("div");
nElement.innerHTML=s;
document.getElementsByTagName("body")[0].appendChild(nElement);
//document.write(s);
document.onclick = function(event) {
$('calendar').style.display = 'none';
$('calendar_year').style.display = 'none';
$('calendar_month').style.display = 'none';
}
$('calendar').onclick = function(event) {
_cancelBubble(event);
$('calendar_year').style.display = 'none';
$('calendar_month').style.display = 'none';
}
}
function parsedate(s) {
/(\d+)\-(\d+)\-(\d+)\s*(\d*):?(\d*)/.exec(s);
var m1 = (RegExp.$1 && RegExp.$1 > 1899 && RegExp.$1 < 2101) ? parseFloat(RegExp.$1) : today.getFullYear();
var m2 = (RegExp.$2 && (RegExp.$2 > 0 && RegExp.$2 < 13)) ? parseFloat(RegExp.$2) : today.getMonth() + 1;
var m3 = (RegExp.$3 && (RegExp.$3 > 0 && RegExp.$3 < 32)) ? parseFloat(RegExp.$3) : today.getDate();
var m4 = (RegExp.$4 && (RegExp.$4 > -1 && RegExp.$4 < 24)) ? parseFloat(RegExp.$4) : 0;
var m5 = (RegExp.$5 && (RegExp.$5 > -1 && RegExp.$5 < 60)) ? parseFloat(RegExp.$5) : 0;
/(\d+)\-(\d+)\-(\d+)\s*(\d*):?(\d*)/.exec("0000-00-00 00\:00");
return new Date(m1, m2 - 1, m3, m4, m5);
}
function settime(d) {
$('calendar').style.display = 'none';
controlid.value = yy + "-" + zerofill(mm + 1) + "-" + zerofill(d) + (addtime ? ' ' + zerofill($('hour').value) + ':' + zerofill($('minute').value) : '');
}
function showcalendar(event, controlid1, addtime1, startdate1, enddate1) {
controlid = controlid1;
addtime = addtime1;
startdate = startdate1 ? parsedate(startdate1) : false;
enddate = enddate1 ? parsedate(enddate1) : false;
currday = controlid.value ? parsedate(controlid.value) : today;
hh = currday.getHours();
ii = currday.getMinutes();
var p = getposition(controlid);
$('calendar').style.display = 'block';
$('calendar').style.left = p['x']+'px';
$('calendar').style.top = (p['y'] + 20)+'px';
_cancelBubble(event);
refreshcalendar(currday.getFullYear(), currday.getMonth());
if(lastcheckedyear != false) {
$('calendar_year_' + lastcheckedyear).className = 'default';
$('calendar_year_' + today.getFullYear()).className = 'today';
}
if(lastcheckedmonth != false) {
$('calendar_month_' + lastcheckedmonth).className = 'default';
$('calendar_month_' + (today.getMonth() + 1)).className = 'today';
}
$('calendar_year_' + currday.getFullYear()).className = 'checked';
$('calendar_month_' + (currday.getMonth() + 1)).className = 'checked';
$('hourminute').style.display = addtime ? '' : 'none';
lastcheckedyear = currday.getFullYear();
lastcheckedmonth = currday.getMonth() + 1;
}
function refreshcalendar(y, m) {
var x = new Date(y, m, 1);
var mv = x.getDay();
var d = x.getDate();
var dd = null;
yy = x.getFullYear();
mm = x.getMonth();
$("year").innerHTML = yy;
$("month").innerHTML = mm + 1 > 9  ? (mm + 1) : '0' + (mm + 1);
for(var i = 1; i <= mv; i++) {
 dd = $("d" + i);
 dd.innerHTML = " ";
 dd.className = "";
}
while(x.getMonth() == mm) {
 dd = $("d" + (d + mv));
 dd.innerHTML = '<a href="###" onclick="settime(' + d + ');return false">' + d + '</a>';
 if(x.getTime() < today.getTime() || (enddate && x.getTime() > enddate.getTime()) || (startdate && x.getTime() < startdate.getTime())) {
 dd.className = 'expire';
} else {
 dd.className = 'default';
}
if(x.getFullYear() == today.getFullYear() && x.getMonth() == today.getMonth() && x.getDate() == today.getDate()) {
 dd.className = 'today';
 dd.firstChild.title = '今天';
}
if(x.getFullYear() == currday.getFullYear() && x.getMonth() == currday.getMonth() && x.getDate() == currday.getDate()) {
dd.className = 'checked';
}
x.setDate(++d);
}
while(d + mv <= 42) {
 dd = $("d" + (d + mv));
 dd.innerHTML = " ";
 d++;
}
if(addtime) {
$('hour').value = zerofill(hh);
$('minute').value = zerofill(ii);
}
}
function showdiv(id) {
var p = getposition($(id));
$('calendar_' + id).style.left = p['x']+'px';
$('calendar_' + id).style.top = (p['y'] + 16)+'px';
$('calendar_' + id).style.display = 'block';
}
function zerofill(s) {
var s = parseFloat(s.toString().replace(/(^[\s0]+)|(\s+$)/g, ''));
s = isNaN(s) ? 0 : s;
return (s < 10 ? '0' : '') + s.toString();
}
loadcalendar();
</script>
  <div class="tupian"><img src="#" /></div>
  <form action="Search/AdvanceResult.jsp">
  <table>
    <tr>
      <td class="name">撰写时间：</td>
      <td class="content"><span>起始日期：<input type="text" name="startdate"  id="startdate" value="" readonly onClick="showcalendar(event,this);"  /></span>结束日期：<input type="text" name="enddate" id="enddate" value="" readonly onClick="showcalendar(event,this);"/></td>
    </tr>
    <tr>
      <td class="name">标题：</td>
      <td class="lable1"><input type="text" name="title" id="title" value="" /></td>
    </tr>
    <tr>
      <td class="name">内容：</td>
      <td class="lable1"><input type="text" name="content" id="content" value="" /></td>
    </tr>
    <tr>
      <td class="name">作者：</td>
      <td class="lable1"><input type="text" name= "author" id="author" value="" /></td>
    </tr>
    <tr>
      <td class="name">关键字</td>
      <td class="lable1"><input type="text" name="query" id="query" value="" /></td>
    </tr>
    <tr>
    <td class="lable" colspan="2"><input type="button" value="检索" onclick="form.submit();"/></td>
    </tr>
    
  </table>
  <input type="hidden" name="site" id="site" value="219" />
  <input type="hidden" name="id" id="id" value="17" />
  </form>
</div>

  </body>
</html>
