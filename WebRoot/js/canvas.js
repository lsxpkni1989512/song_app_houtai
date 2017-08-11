	//圆形刻度颜色
		var scaleColor = "#000";
		
		//表盘大刻度宽度 3 6 9 12
		var scaleBigWidth = 9;
		//表盘大刻度的长度
		var scaleBigLength = 10;
		//表盘小刻度的宽度
		var scaleSmallWidth = 2;
		//表盘小刻度的长度
		var scaleSmallLength = 8;

		//时钟画布
		var canvas = document.getElementById('canvas'); 
		var imageP=document.getElementById("imagesid");
		//时针画布的作图环境（画板）
		var panel = canvas.getContext('2d');

		var circularRadius = 120; 
		var number= 142 ;
		var meiosis = 120;
	 
		//主要实现 黑色短线段 灰色短线段
		function drowScales(p) {
			//画黑色短线段
			for (var i = 22; i < 65; i++) {
				 var width = scaleSmallWidth;
				var length = scaleSmallLength; 
				 var startY = 0; 
				 var startX = meiosis -   scaleSmallWidth*3 ; 
				 var ran = i * 6 * Math.PI / 180;  
				drowLine(p, width, scaleColor, startX, startY, startX + length, startY, ran, number, number);
			}
			//画灰色短线段
			 for (var i = 37; i < 69; i++) {
				 var width = scaleSmallWidth;
				var length = scaleSmallLength; 
				 var startY = 0;
				 var startX = meiosis -   scaleSmallWidth*3; 
				 var ran = i * 6 * Math.PI / 180;  
				drowLine(p, width, "#a9a9a9", startX, startY, startX + length, startY, ran, number, number);
			}
		}

		 //画圆形中间的文字
		function drowCenterText(p,width,centreX,centreY){
			p.save();
			p.lineWidth = width;
			p.beginPath();
			p.font = 'bold 90px 方正兰亭超细黑简体';
			p.textAlign = 'center';
			p.textBaseline = 'middle';
			p.fillStyle = '#f85252'; 
			// 中间的文字
		    p.fillText("90",centreX, centreY); 
			p.stroke();
			p.closePath();
			p.restore();
		 }

		//画黑色 或者 灰色 短线段
		//原理： 在灰色底下一层 绘画一层黑色短线段， 用灰色短线段遮盖黑色短线段
		function drowLine(p, width, color, startX, startY, endX, endY, ran, cX,cY) {
			//保存传入的画板，相当于每次作画新开一个图层
			p.save();
			//设置画笔宽度
			p.lineWidth = width;
			//设置画笔颜色
			p.strokeStyle = color;
			//绘制新的路径，避免和之前画板上的内容产生干扰
			p.beginPath();
			//平移
			p.translate(cX, cY);
			//旋转
			p.rotate(ran);
			//移动画笔到开始位置
			p.moveTo(startX, startY);
			//移动画笔到结束位置
			p.lineTo(endX, endY);
			//开始画线
			p.stroke();
			//关闭作图路径，避免和之后在画板上绘制的内容产生干扰
			p.closePath();
			//在传入的画板对象上覆盖图层
			p.restore();
		}
		
		

		//绘画圆形最外层的数字
		function drawOuterNumber(ctx){
		    ctx.save();
		    ctx.translate(number, number);
		    ctx.beginPath();
		    ctx.font = '14px Arial';
		    ctx.textAlign = 'center';
		    ctx.textBaseline = 'middle';
		    for (var n = 1; n <= 12; n= n+0.5) {
		    	//if(n%2!=0){
		    		var theta = (n - 3) * (Math.PI * 2) / 12;
				    var x = circularRadius * 1.12 * Math.cos(theta);
				    var y = circularRadius * 1.13 * Math.sin(theta);
				    ctx.fillStyle = '#a9a9a9';
		            if(n==1){
			        	ctx.fillText("60", x, y);
			        }else  if(n==3){
			       	 	ctx.fillText("80", x, y);
			        }else  if(n==4.5){
			        	ctx.fillText("100", x, y);
			        } else    if(n==7.5){ 
			        	ctx.fillStyle = '#000';
			        	ctx.fillText("0", x, y);
			        }else    if(n==9){
			        	ctx.fillStyle = '#000';
			       	  	ctx.fillText("20", x, y);
			        }else  if(n==11){
			       		ctx.fillText("40", x, y);
			        }  
		    	//}
		    }
		    ctx.restore();
		}
		
		//绘画 底部的 文字 
		function drawBottomText(ctx) { 
		    ctx.save();
		    ctx.translate(number, number);
		    ctx.beginPath();
		    ctx.font = '20px Arial';
		    ctx.fillStyle = '#f85252';
		    ctx.textAlign = 'center';
		    ctx.textBaseline = 'middle';
		    //在6点钟方向 
		    var topText = (6 - 3) * (Math.PI * 2) / 12;
		    // 0.55 代表 距离中心点的基数
		    var x = circularRadius * 0.65 * Math.cos(topText);
		    var y = circularRadius * 0.65 * Math.sin(topText);
		    ctx.fillStyle = '#323232';
       		ctx.fillText("急救指数", x, y);
	        
       		var bottomText = (6 - 3) * (Math.PI * 2) / 12;
		    var x1 = circularRadius * 0.95 * Math.cos(bottomText);
		    var y1 = circularRadius * 0.9 * Math.sin(bottomText);
		    ctx.font = '10px Arial';
		    ctx.fillStyle = '#838383';
       		ctx.fillText("指数值越低越好", x1, y1);


       		var bottomText1 = (6 - 3) * (Math.PI * 2) / 12;
		    var x2 = circularRadius * 1.15 * Math.cos(bottomText1);
		    var y2 = circularRadius * 1.15* Math.sin(bottomText1);
		    ctx.font = '12px Arial';
		    ctx.fillStyle = '#646464';
		    ctx.fillText("指数超过30%的用户，需要持续关注身体数据变化", x2, y2);
		    ctx.restore();
		}
		 
		//开始绘画
		function drowCircular() {
			
			drowScales(panel); 
			//绘画最外层数字
			 drawOuterNumber(panel);
			//绘画底部的文字
			 drawBottomText(panel);
			//绘画圆形中间的文字，可以将文字从此处传递过去
			 drowCenterText(panel,7, number , number -10 , number -10);
			//绘画五边形，其实就是使用canvas.drawImage 将图片绘画上去
			 drowArrow(panel);
		} 



		//绘画 五边形 （箭头）
		//原理：绘画一张图片，将图片旋转到指数到达的位置 进行显示
		function drowArrow(p) {
			var width = scaleBigWidth * 1.5;
			var length = scaleBigLength * 1.5; 
			var startY = 0;
			var startX = meiosis - scaleBigLength *1.5; 
			var endX = startX + length;
			var endY = 0 ;
			var ran = 7 * 30 * Math.PI / 180 
			 
			p.save();
			p.lineWidth = width;
			p.strokeStyle = scaleColor;
			p.beginPath();
			p.translate(number, number);
			p.rotate(ran);
			p.drawImage(imageP, startX, startY );
			p.stroke();
			p.closePath();
			p.restore();
		}	
		
		



		drowCircular(); 