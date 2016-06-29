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

