var lasturl;//记录当前所管理模块的入口url。
//完成管理操作后刷新列表页方法
function refresh(){
	getAjax(lasturl,"_Ajaxspace");
}
//页面跳转函数，分页使用
function gotoPage(iPage) {
	var url= lasturl;
	if(url.indexOf("?") < 0) url += "?";
	else url += "&";
	url += "currentPage=" + iPage;
	getAjax(url,"_Ajaxspace");
}
