/*
	1、找box
	2、为box添加mousedown,执行以下动作
		3、获取鼠标在盒子上的位置:水平位置=client-box.offsetLeft
		4、为document添加mousemove事件，执行的动作是：
			5、访问事件对象，通过clientX及clientY获取到鼠标的位置
			6、设置box的left及top为鼠标的位置
		7、为document添加mouseup事件，执行动作：删除mousemove事件

*/

var Drag=function(ID){
	this.box=document.getElementById(ID);//获取盒子
	this.disX=0;
	this.disY=0;
	//调用方法
	this.bindEvent();

}
//创建构造函数
Drag.prototype={
	bindEvent:function(){
		var that=this;
		this.box.onmousedown=function(e){
			//获取鼠标在盒子上的位置
			that.getPosition(e);
			document.onmousemove=function(e){
				//设置盒子的位置为鼠标的位置
				that.startMove(e);
			}
			document.onmouseup=function(){
				//停止移动
				that.stopMove();
			}
		}

	},
	getPosition:function(e){
		var event= e || window.event;
			this.disX=event.clientX-this.box.offsetLeft;//水平的位置
			this.disY=event.clientY-this.box.offsetTop;//垂直位置
	},
	startMove:function(e){
		var event=e || window.event,
				X=event.clientX,
				Y=event.clientY,
				l=X-this.disX,
				t=Y-this.disY;
			this.box.style.left=l+"px";
			this.box.style.top=t+"px";
	},

	stopMove:function(){
		document.onmousemove=null;
		document.onmouseup=null;
	}

}



var limit=function(as)
	{
		Drag.call(this,as)
	}
	//limit.prototype=Drag.prototype;
	for(i in Drag.prototype)
	{
		limit.prototype[i]=Drag.prototype[i]
	}
	limit.prototype.startMove=function(e)
	{
		var event=e || window.event,
		X=event.clientX,Y=event.clientY,
		l=X-this.disX,t=Y-this.disY;
		if(l<0) l=0;
		if(t<0) t=0;
		if(l>(document.documentElement.clientWidth||document.body.clientWidth)-this.box.offsetWidth)
		 l=(document.documentElement.clientWidth||document.body.clientWidth)-this.box.offsetWidth;
		if(t>(document.documentElement.clientHeight||document.body.clientHeight)-this.box.offsetHeight)
		 t=(document.documentElement.clientHeight||document.body.clientHeight)-this.box.offsetHeight;
		this.box.style.left=l+"px";
		this.box.style.top=t+"px";
	}