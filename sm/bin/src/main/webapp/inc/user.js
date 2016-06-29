/*queryUserList*/

var list;
var goodsVue = new Vue({
	el: '#user',
	data: {
		goodsList : [],//{} [] '' 对象，list，str
	} 
});
$.ajax({
    type: 'POST',
    url: '/sm/user/queryUserList.html',
    success:function(data) {
		var data = eval('('+data+')');
		console.log(data);
		goodsVue.goodsList = data.userList;
		console.log(list);
    }
});