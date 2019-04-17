	$(document).ready(function(){//初始化	加载
		var num = 1;
		loadPage(num);//默认
	});
	function loadPage(num) {
	var id = $("#id").val();
     $.ajax({
         type: 'GET',
         url: "/showExercises",
		 data: {"page": num, "id" : id}, //传输的数据
         contentType: "application/json;cherset=utf-8",
         dataType: "json",
         success: function (data){
        	    $(".tr_node").html("");//清空显示的数据
			    $(".prePage").show();//定义
				$(".nextPage").show();//定义
				var lts = data.list;
				for(var i in lts){
					var rowTr = document.createElement('tr')
			          //找到html的tr节点
			           rowTr.className = "tr_node"
			        var child = "<td>" + lts[i].exercise_id +  "</td>"+
					"<td>" + lts[i].exercise_name +  "</td>"+
					"<td>" + lts[i].exercise_answer +  "</td>"+
					"<td>" + lts[i].choice1 +  "</td>"+
					"<td>" + lts[i].choice2 +  "</td>"+
					"<td>" + lts[i].choice3 +  "</td>"+
					"<td>" + lts[i].choice4 +  "</td>"+
					"<td>" + lts[i].et_name +  "</td>"+
					"<td><a href='#' onclick='showDetail()'>修改</a>|<a href='#' onclick='del("+lts[i].exercise_id+")'>删除</a></td>";
					rowTr.innerHTML = child
					$(".table_node").append(rowTr)//显示数据到页面
				}
				//存放页面数据
				$(".msg").html("共<span id='pagesPage' style='font-size:15px; font-weight:bold'>"+
				  data.pages+"</span>页，当前第<span id='nowPage' style='font-size:15px; font-weight:bold'>"+
				  data.pageNum+"</span>页");
				$("#ad_page").html("<span id='prePage' class='ad_page_none'>"+data.prePage+"</span><span id='nextPage' class='ad_page_none'>"+data.nextPage+"</span><span id='pagesPage' class='ad_page_none'>"+data.pages+"</span><span id='nowPage' class='ad_page_none'>"+data.pageNum+"</span>");
				if(data.prePage == 0){//判断上一页按钮
					$(".prePage").hide();
				}
				if(data.pageNum == data.pages){//判断下一页按钮
					$(".nextPage").hide();
				}
			}, 
			error: function() {   //失败的回调函数
				 console.log("error");
			} 
		}) 	 
	}
	function prePage(){//上一页
		var pre = $("#prePage").text();
		loadPage(pre);
	}
	function nextPage(){//下一页
		var next = $("#nextPage").text();
		loadPage(next);
	}
	function goPage(){//跳转
		var go = $(".select_go").val().trim();
		var last = $("#pagesPage").text();
		if(go > 0 && go <= last){
		    loadPage(go);
		    $(".select_go").val("");//清空数据
	    }
		console.log(last);//打印
	}