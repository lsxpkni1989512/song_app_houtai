function cmsLoading(id){   
    $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",zIndex:9998,height:$(window).height()}).appendTo("#"+id);   
    $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("#"+id).css({display:"block",zIndex:9999,left:($('#'+id).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});   
}
function DSLoading(e){
    $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",zIndex:9998,height:$(window).height()}).appendTo(e);   
    $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo(e).css({display:"block",zIndex:9999,left:($(e).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});   
} 
function cmsLoadEnd(){
    $(".datagrid-mask").remove();   
    $(".datagrid-mask-msg").remove();               
}