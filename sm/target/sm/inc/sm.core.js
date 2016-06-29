new Vue({
	el:"#app",
	data:{
		message:'hello world!'
	}
});

new Vue({
	el:"#todo",
	data:{
		todos:[
		       {text:'vue'},
		       {text:'js'},
		       {text:'java'}
		]
	}
});

new Vue({
	el:"#click",
	data:{
		message:'reverseMessage - alert()!'
	},
	methods:{
		reverseMessage: function(){
			/*alert(0);*/
			this.message = this.message.split('').reverse().join('')
		}
	}
});

new Vue({
	el:'#all',
	data:{
		newTodo:'',
		todos:[
		      {text:'text1'},
		      {text:'text2'},
		      {text:'text3'}
		]
	},
	methods:{
		addTodo:function(){
			var text = this.newTodo.trim();
			if(text){
				this.todos.push({text:text});
				/*this.todos.push({text:'455'});*/
				this.newTodo='';
			}
		},
		removeTodo:function(index){
			/*alert(index);*/
			this.todos.splice(index, 1)
		}
	}
});

/**
 * tab js
 */
//register the grid component
Vue.component('demo-grid', {
  template: '#grid-template',
  props: {
    data: Array,
    columns: Array,
    filterKey: String
  },
  data: function () {
    var sortOrders = {}
    this.columns.forEach(function (key) {
      sortOrders[key] = 1
    })
    return {
      sortKey: '',
      sortOrders: sortOrders
    }
  },
  methods: {
    sortBy: function (key) {
      this.sortKey = key
      this.sortOrders[key] = this.sortOrders[key] * -1
    }
  }
})

// bootstrap the demo 
var demo = new Vue({
  el: '#demo',
  data: {
    searchQuery: '',
    gridColumns: ['name', 'power'],
    gridData: [
      { name: 'Chuck Norris', power: Infinity },
      { name: 'Bruce Lee', power: 9000 },
      { name: 'Jackie Chan', power: 7000 },
      { name: 'Jet Li', power: 8000 }
    ]
  }
})

var example1 = new Vue({
	  el: '#example-1',
	  data: {
	    items: [
	      { message: 'Foo',_uid:'7981gd' },
	      { message: 'Bar',_uid:'7982gd' },
	      { message: 'car',_uid:'7983gd' },
	      { message: 'aara',_uid:'7984gd' },
	      { message: 'dar',_uid:'7985gd' },
	    ]
	  }
	})
/*	
 	example1.items.pop({ message: 'pop' })//减法 从后面开始
 	example1.items.push({ message: 'push' }) //加法 从后面开始
	example1.items.unshift({ message: 'unshift' }) //加法 从前面开始
	example1.items.shift({ message: 'shift' }) //减法 从前面开始
	example1.items.reverse({ message: 'reverse' }) //顺序反转
	 
	example1.items.splice(1,3) //截取数组：（index，how many）
	example1.items.sort() //
*/ 

/*example1.items = example1.items.filter(function (item) {//替换数组
	return item.message.match(/car/)
})*/

/*example1.items.$set(0, { message: 'Changed!'}) 修改数组0位置的值*/ 
/*example1.items.$remove()  等同下面
var index = example1.items.indexOf(item)
if (index !== -1) {
  this.items.splice(index, 1)
}*/

var example2 = new Vue({
	el: '#example-2',
	data: {
		items: [
		        { message: 'Foo' },
		        { message: 'Bar' }
		        ]
	}
})

new Vue({
	  el: '#repeat-object',
	  data: {
	    object: {
	      FirstName: 'John',
	      LastName: 'Doe',
	      Age: 30
	    }
	  }
	})
	
new Vue({
	el: '#repeat-object2',
	data: {
		object: {
			FirstName: 'John',
			LastName: 'Doe',
			Age: 30
		}
	}
})

new Vue({
	  el: '#example-3',
	  methods: {
		  say: function (msg, event) {
			  alert(event.target.tagName);
			    // 现在我们可以访问原生事件对象
			    event.preventDefault();
			  }
	  }
	})


/**-------------validform-------------------**/
var baseURL = 'https://vue-demo.firebaseIO.com/'
	var emailRE = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/

	/**
	 * Setup firebase sync
	 */

	var Users = new Firebase(baseURL + 'users');

	Users.on('child_added', function (snapshot) {
	  var item = snapshot.val()
	  item.id = snapshot.key()
	  app.users.push(item)
	})

	Users.on('child_removed', function (snapshot) {
	  var id = snapshot.key()
	  app.users.some(function (user) {
	    if (user.id === id) {
	      app.users.$remove(user)
	      return true
	    }
	  })
	})

/**
 * Create Vue app
 */

var app = new Vue({

  // element to mount to
  el: '#app2',

  // initial data
  data: {
    users: [],
    newUser: {
      name: '',
      email: ''
    }
  },

  // computed property for form validation state
  computed: {
    validation: function () {
      return {
        name: !!this.newUser.name.trim(),
        email: emailRE.test(this.newUser.email)
      }
    },
    isValid: function () {
      var validation = this.validation
      return Object.keys(validation).every(function (key) {
        return validation[key]
      })
    }
  },

  // methods
  methods: {
    addUser: function () {
      if (this.isValid) {
        Users.push(this.newUser)
        this.newUser.name = ''
        this.newUser.email = ''
      }
    },
    removeUser: function (user) {
      new Firebase(baseURL + 'users/' + user.id).remove()
    }
  }
})
	/**
	 * 自定义的过滤器必须在实例之前定义
	 */
	Vue.filter('wrap', function (value, begin, end) {
		return begin + value + end
	})
	
	 /*Vue.filter('currencyDisplay', {
	  // model -> view
	  // 在更新 `<input>` 元素之前格式化值
	  read: function(val) {
	    return '$'+val.toFixed(2)
	  },
	  // view -> model
	  // 在写回数据之前格式化值
	  write: function(val, oldVal) {
	    var number = +val.replace(/[^\d.]/g, '')
	    return isNaN(number) ? 0 : parseFloat(number.toFixed(2))
	  }
	})
	*/
	var shujubangding = new Vue({
		el:'#shujubangding',
		data:{
			name:'数据绑定',
			pwd:'444444',
			number:'asd',
			ok:false,
			message:' between and ',
			email:'lihua@163.com',
			money:0.26,
			valid_value:''
		},
		filters: {
		    currencyDisplay: {
		      read: function(val) {
		        return '￥'+val.toFixed(2)
		      },
		      write: function(val, oldVal) {
		        var number = +val.replace(/[^\d.]/g, '')
		        return isNaN(number) ? 0 : parseFloat(number.toFixed(2))
		      }
		    }
		  }
	})
	
	
	
	var app = new Vue({
		  el: '#regist',
		  data: {
		    users: [],
		    newUser: {
		      name: '',
		      email: ''
		    },
		    money:0.25,
		    phone:''
		  },
		 
		  filters: {
			    currencyDisplay: {
			      read: function(val) {
			        return '￥'+val.toFixed(2)
			      },
			      write: function(val, oldVal) {
			        var number = +val.replace(/[^\d.]/g, '')
			        return isNaN(number) ? 0 : parseFloat(number.toFixed(2))
			      }
			    },
			    isPhone: {
				      read: function(val) {
//				    	  alert(val+"read");
				        return val;
				      },
				      write: function(val, oldVal) {
				    	  	var reg = /1(\d{2})\d{4}(\d{4})/g;//手机号：11 1开头的数字
				    	  	var phone='';
					    	var isp = reg.test(val);
					    	if(isp){
					    		phone = val;
					    		console.log(phone)
					    	}else{
						    	if(val!=''){
						    		phone='1';
						    	}
					    	}
					    	
					        return phone
				      }
				    }
			  },
		  // computed property for form validation state
	 	  computed: {
		    validation: function () {
		      return {
		        name: !!this.newUser.name.trim(),
		        email: emailRE.test(this.newUser.email)
		      }
		    },
		    isValid: function () {
		      var validation = this.validation
		      return Object.keys(validation).every(function (key) {
		        return validation[key]
		      })
		    }
		  } 
		})
	
	 $(function(){
		  $("button").click(function(){
		   var str = $("p").text();
		   var reg = /1(\d{2})\d{4}(\d{4})/g;
		   str = str.replace(reg,"2222");
		   $("p").text(str);
		  });
		 });