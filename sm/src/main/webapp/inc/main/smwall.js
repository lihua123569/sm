requirejs.config({
    paths: {
        jquery: '/sm/inc/jquery-1.11.3',
        vue:'/sm/inc/vue',
        jaliswall:'/sm/inc/wall/js/jaliswall',
    }
});
 

 require(['jquery','jaliswall','vue'],function(jquery,jaliswall,Vue){
	 var vm = new Vue({
			el : '#arti',
			data : {
				feed : "",
				info : {},
				goodsList : [],
				final : {
					msg : ""
				}
			},
			ready : function() {
				$.ajax({
					type : 'POST',
					url : '/sm/wall/getWallPics.html',
					asycn : false,
					success : function(data) {
						var data = eval('(' + data + ')');
						console.log(data);
						http: // vuejs.org.cn/images/lifecycle.png
						vm.goodsList = data.walls;
						// vm.goodsList.length==$('#arti div').length
						/* $('.wall').jaliswall({ item: '.article' }); */
					}
				});

			},
			beforeDestroy : function() {
				console.log("beforeDestroy");
			},
			destroyed : function() {
				console.log("destroyed");
			}

		});
		function walls() {
			$('.wall').jaliswall({
				item : '.article'
			});
			console.log("33");
		}

		vm.$watch('goodsList', function(val) {
			this.goodsList = val;
			$('.wall').jaliswall({
				item : '.article'
			});
		})

		/*
		 * window.onload = function(){//等待页面内DOM、图片资源加载完毕后触发执行
		 * $('.wall').jaliswall({ item: '.article' }); }
		 */
	 
 }); 
 