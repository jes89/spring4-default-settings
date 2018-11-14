<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Javascript Slide Example</title>
</head>
<body>
	<span id="myBarChart0"></span>
    <span id="myBarChart1"></span>
    <span id="myBarChart2"></span>
	
	<script type="text/javascript">
        const BARCHARTWIDTH = 20;
        var getDataStore = function(){ return Math.round(Math.random()*100);}

        //원래 js 따로 빼둔 부분
		var AbstractChart = (function(){

           	var charts 		=   {};
           	var chartName 	=    null;
			var addChart = function (name,chart){	
            	if(typeof(chart) === "function" && charts[name] == null){
            		charts[name] 	    = chart;
					chartName 		    = name;
            	}
            }
			
			var init = function (name, chartInfo) {
                
                var targetEl 		= null;
                var targetElList 	= [];
				var chart           = null;
                
            	//addChart에서 차트만 등록해서 있어서 타입체크는 안 함.
                if(charts[name] == null){
                    alert("해당 차트가 미등록 되어있습니다.");
                    return;
                }
                
            	chart = new charts[name](chartInfo);
                              
                if(chart.targetType && chart.targetType.toLowerCase() === "id"){
					targetEl = document.querySelector(chart.targetName);
			   } else{
					targetElList = document.querySelectorAll(chart.targetName);
					if(targetElList.length > chart.targetIdx){
						targetEl = targetElList[chart.targetIdx];
					} else{
					   alert("해당 엘리먼트의 인덱스가 존재하지 않습니다.");
					}
                }
				
                if(targetEl){
					targetEl.appendChild(chart.canvas);
                } else{
					alert("해당 엘리먼트를 존재하지 않습니다.");
				}

                return chart;
			}
            
			return {
				addChart 	: addChart,
				init 		: init
			}

			return AbstractChart;
	
		})();
        
        
        var BarChart = (function (){
            
            
            function Chart (info){
            	this.x 			= info.x;
                this.y 			= info.y;
                this.width      = info.width;
                this.chartType 	= info.chartType;
                this.targetType = info.targetType;
				this.targetName = info.targetName;
				this.targetIdx 	= info.targetIdx;
                this.canvas     = document.createElement("canvas");
                this.ctx        = this.canvas.getContext("2d");
                this.preHeight  = 0;
                this.height		= info.height;
                this.cWidth     = info.cWidth;
                this.cHeight    = info.cHeight;
                
                this.canvas.width   = this.cWidth;
                this.canvas.height  =   this.cHeight;
            }
            
            Chart.prototype.drawChart = function(){
                
                var that = this;
                var lastHeight  = that.height;
                
                setTimeout(function timer(){

                    if( that.preHeight < lastHeight   ){
                        that.preHeight = that.preHeight + 1;
                    } else if(  that.preHeight > lastHeight   ){
                        that.preHeight = that.preHeight - 1;
                    }
                    
                    setTimeout(function innerTimer(){
                        
                        that.clearChart();
                        that.ctx.fillRect(  that.x    ,  (that.cHeight-that.preHeight) ,   that.width  ,   that.preHeight );
                        
                        if( that.preHeight !== lastHeight    ){
                            timer();
                        } 
                    },5);
                }, 5 )
            };
            
            Chart.prototype.removeChart = function(){
                this.canvas.parentElement.removeChild(this.canvas);
            };
            
            Chart.prototype.clearChart = function(){
                this.ctx.clearRect(0,0, window.innerWidth , window.innerHeight);
            };
            
            return Chart;
            
        })();
        
        
        var PieChart = function(){
            
        }

        
        //차트 등록
        var dataList = [];
        var barChartList = [];
        var spanList = document.getElementsByTagName("span");
        for(var ix = 0, ixLen = spanList.length; ix < ixLen; ix++){
        	dataList[ix] = {"x" : 0, "y":0, "width" : BARCHARTWIDTH, height : getDataStore(), cWidth : 50, cHeight:150, "chartType" : "bar", "targetType" : "id", "targetName" : "#myBarChart"+ix, "targetIdx" : 0 }
        	AbstractChart.addChart("myBarChart"+ ix , BarChart);
            barChartList[ix] = AbstractChart.init("myBarChart"+ix, dataList[ix] );
            barChartList[ix].drawChart();
        }

        setTimeout(function timer(){
            setTimeout(function(){
                
                for(var ix = 0; ix < 3; ix++){
                    barChartList[ix].drawChart();
                    barChartList[ix].height = getDataStore();
                }
                
                timer();
                
            },3000)
        },10)

	</script>
</body>
</html>