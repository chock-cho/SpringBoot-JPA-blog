// ajax 통신을 위한 csrf 설정
//var token = $("meta[name='_csrf']").attr("content");
//var header = $("meta[name='_csrf_header']").attr("content");
//$(document).ajaxSend(function(e, xhr, options) {
//    xhr.setRequestHeader(header, token);
//});

let index = {
	init: function() {
		$("#btn-save").on("click", ()=>{  //jQuery사용, 이벤트를 바인딩하여 리스너를 만드는 것
		//on함수 : 첫번째 파라미터를 하면, 두번째  파라미터에 실행할 내용의 함수가 온다
			this.save();
		}); //btn-save가 실행이 되면 
	},
	
	save: function(){
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		}
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), //http body데이터
			contentType: "application/json; charset=utf-8", //body데이터가 어떤 데이터 타입인지
			dataType: "json"  
		}).done(function(resp){
			alert("글쓰기가 완료되었습니다.");
			location.href = "/";	
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
}

index.init();