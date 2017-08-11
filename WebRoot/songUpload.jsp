<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
      + request.getServerName() + ":" + request.getServerPort()
      + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<title></title>
	<!-- 引入EasyUI -->
	<link rel="stylesheet" href="<%=path%>/css/default.css" type="text/css">
	<link rel="stylesheet" href="<%=path%>/css/index.css" type="text/css">
	<link rel="stylesheet" href="<%=path%>/js/jquery-easyui-1.4.5/themes/default/easyui.css" type="text/css">
	<link rel="stylesheet" href="<%=path%>/js/jquery-easyui-1.4.5/themes/icon.css" type="text/css">
	<link rel="stylesheet" href="<%=path%>/js/jquery-easyui-1.4.5/themes/color.css" type="text/css">
	<script type="text/javascript" src="<%=path%>/js/index.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.4.5/jquery-1.6.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
	 
	<script type="text/javascript">
		$(function(){
			$('#song_album').combobox({
			    editable:false, //不可编辑状态
			    cache: false,
			    panelHeight: 'auto',//自动高度适合
			    valueField:'song_album',
			    textField:'label',
			    data: [{  
	                label: '答唱咏+阿肋路亚',  
	                song_album: '1'},  
	                {label: '弥撒套曲',  
	                song_album: '2'}, 
	                {label: '教会经典歌曲',  
	                song_album: '3'
	            }]
			});

			$('#dg').datagrid({ 
				url:'<%=path%>/songsController/songList', 
				
			}); 

		});
		var url;
		//新增
		function addVideoFilesInfo(){
			$('#dlg').dialog('open').dialog('setTitle','新增歌曲信息');
			url = "<%=path%>/songsController/insertOrUpdateSong";
			$('#fm').form('clear');
		}
		
		//修改
        function editVideoFilesInfo(){
        	var selectedRows = $("#dg").datagrid("getSelections");
			if (selectedRows.length != 1) {
      			$.messager.alert("系统提示", "请选择一条要编辑的数据！");
      			return;
    		}
    		var row = selectedRows[0];
    		$('#title').textbox('setValue',row.title);
    		$("#dlg").dialog("open").dialog("setTitle", "编辑视频信息");
    		url = "<%=path%>/?innerid=" + row.innerid;
    		$("#fm").form("load", row);
       	}
        
        //删除
        function destroyVideoFilesInfo(){
        	var selectedRows = $("#dg").datagrid("getSelections");
    		if (selectedRows.length == 0) {
	     		$.messager.alert("系统提示", "请选择要删除的数据！");
	      		return;
      		}
      		var inneridArray = [];
      		var videoFileUrl = [];
      		for ( var i = 0; i < selectedRows.length; i++) {
      			inneridArray.push(selectedRows[i].innerid);
      			videoFileUrl.push(selectedRows[i].fileUrl);
   			}
   			var innerids = inneridArray.join(",");
   			var videoFileUrls = videoFileUrl.join(",");
   			$.messager.confirm("系统提示", "您确定要删除吗？", function(r) {
      			if (r) {
        			$.post("<%=path%>/", {
          				innerids : innerids,
          				videoFileUrl : videoFileUrls
        			}, function(result) {
          				if (result.success) {
            				$.messager.alert("系统提示", "数据已成功删除！");
            				$("#dg").datagrid("reload");
          				} else {
            				$.messager.alert("系统提示", "数据删除失败！请查看视频是否已经和柜子绑定");
          				}
        			}, "json");
      			}
   		 	});
        }
        
        //查询
        function queryVideoFilesInfo(){
        	var songName = $('#songName').val();
	   		$("#dg").datagrid('load', {
		       "songName":songName
		    });
        }
        
        //重置
        function clearTab(){
           $('#tab').form('clear');
        }
        
		//保存
		function saveVideoFilesInfo(){
	   		$("#fm").form("submit",{
		        url:url,
		        onSubmit:function(){
		        	if ($("#fm").form('validate')){
		        		cmsLoading('dlg');
		        		return true;
		        	}else {
		        		return false;
		        	}
		        },
		        success:function(data){
		        	if(data == 1){
		        		cmsLoadEnd();
		        		$("#dlg").dialog("close");
		        		$.messager.alert("提示", "数据保存成功");
			          	$("#dg").datagrid("reload");
		        	}else{
		        		cmsLoadEnd();
		        		$.messager.alert("提示", "数据保存失败");
		        	}
		      	}
	        });
        }
	</script>
</head>
<body style="margin: 1px">
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div class="queryUnit">
			<ul id="tab">
				<li>
					<span>歌曲名称 ：</span>
					<input class="easyui-textbox" style="padding:5px;height:30px;" id="songName" name="songName"/>
				</li>
				<li class="btn">
					<a href="javascript:;" onclick="queryVideoFilesInfo()">查询</a>
					<a href="javascript:;" onclick="clearTab()">重置</a>
				</li>
			</ul>
		</div>
		<div style="height: 89%;">
			<table id="dg" class="easyui-datagrid" style="height: 100%;" rownumbers="true" pagination="true" data-options="url:'',pageSize:20,fitColumns:true" toolbar="#toolbar">  
			    <thead>  
			        <tr>  
			        	<th data-options="field:'ck',checkbox:true"><br></th>
			        	<th data-options="field:'innerid',hidden:'hid'">innerid</th>
			        	<th data-options="field:'songName'" width="20%">歌名</th>
			        	<th data-options="field:'songSinger'" width="15%">歌手</th>
			        	<th data-options="field:'songUrl'" width="25%">歌曲路径</th>
			        	<th data-options="field:'songLyricUrl',hidden:'hid'">歌词路径</th>
			        	<th data-options="field:'songAlbum'" width="25%">所属专辑</th>
			        	<th data-options="field:'createTime'" width="10%">创建时间</th>
			        	<th data-options="field:'updateTime'" width="10%">修改时间</th>
			        </tr>  
			    </thead>  
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addVideoFilesInfo()">新增</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editVideoFilesInfo()">修改</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyVideoFilesInfo()">删除</a>
            </div>
            
            <div id="dlg" class="easyui-dialog" title="新增歌曲文件信息" style="width: 730px;height:350px;padding:10px 10px;" closed="true" buttons="#dlg-buttons">
      			<form method="post" id="fm" enctype="multipart/form-data">
        			<div class="orderDetailList">
          				<ul>
            				<li style="margin-bottom:10px;">
            					<label for="" style="width:89px;text-align:right;">歌曲名称 ：</label>
           						<input type="text" style="padding:5px;font-size:14px;height:30px;" id="song_name" name="song_name" class="easyui-textbox" required="true"/> 
           	 				</li>
           	 				
           	 				<li style="margin-bottom:10px;">
            					<label for="" style="width:89px;text-align:right;">歌手 ：</label>
           						<input type="text" style="padding:5px;font-size:14px;height:30px;" id="song_singer" name="song_singer" class="easyui-textbox" required="true"/> 
           	 				</li>
           	 				
          					<li style="margin-bottom:10px;">
          						<label for="" style="width:89px;text-align:right;">歌曲文件 ：</label>
								<input type="file" style="padding:5px;font-size:14px;width:190px;height:30px;" id="fileMp3" name="fileMp3"/>
							</li>
							
          					<li style="margin-bottom:10px;">
          						<label for="" style="width:89px;text-align:right;">歌词文件 ：</label>
								<input type="file" style="padding:5px;font-size:14px;width:190px;height:30px;" id="fileLyric" name="fileLyric"/>
							</li>
          				
          					<li style="margin-bottom:10px;">
            					<label for="" style="width:89px;text-align:right;">所属专辑 ：</label>
           						<input style="padding:5px;font-size:14px;height:30px;width:190px;" id="song_album" name="song_album" required="true"/> 
           	 				</li>
           	 				
           	 				
           	 				
          					<%--
          					<li  style="width:100%;margin-bottom:10px;">
          						<label for="" style="width:89px;text-align:right;vertical-align: top;">内容描述 ：</label>
          						<div style="display: inline-block;width:80%;">
          							<textarea  style="padding:5px;width:100%;height:150px;" type="text" id="content" name="content" required="true"></textarea>
          						</div>
							</li>
          					--%>
          				
          				</ul>
          			</div>
          		</form>
          		
          	</div>
			<div id="dlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveVideoFilesInfo()" style="width:90px">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
			</div>
		</div> 
	</div>
</body>
</html>