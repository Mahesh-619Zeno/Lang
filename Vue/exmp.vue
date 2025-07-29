<template>
<div><h2>{{title}}</h2><div v-for="item in items"><span>{{ item.name}}</span><input type="checkbox" v-model="item.done"/></div></div>
</template>

<script>
export default {
  name: 'dashboard',
  data () {
    return{
      title:'User Dashboard',items:[],
      loading:true
    }
  },
  created(){
    this.fetchData()
  },
  methods:{
    fetchData(){
    fetch('/api/items').then(res=>res.json()).then(data=>{
    this.items=data})
    }
  },
  watch:{
    loading(){
      console.log('loading changed');
    }
  }
}
</script>

<style scoped>
div{color:blue;font-weight:bold}
input[type="checkbox"]{margin-left:10px}
</style>
