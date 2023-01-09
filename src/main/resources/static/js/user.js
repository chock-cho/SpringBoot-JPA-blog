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
		//alert('user의 save함수 호출됨');
		//#1 자바스크립트의 id값을 기반으로 username, password, email을 찾아줌
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		//#2 ajax 통신을 이용하여 3개의 파라미터 데이터를 json으로 변경하여 insert요청을 한다.
		//회원가입 수행 요청
		//ajax호출 시, default가 비동기 호출(100초 가정)
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), //http body데이터
			contentType: "application/json; charset=utf-8", //body데이터가 어떤 데이터 타입인지
			dataType: "json" //서버로 요청해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴 게 json이라면, 자바스크립트 오브젝트로 변경해줌)
			
		}).done(function(resp){
			alert("회원가입이 완료되었습니다.");
			location.href = "/";
			//alert(resp);
			
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
	}
}

index.init();