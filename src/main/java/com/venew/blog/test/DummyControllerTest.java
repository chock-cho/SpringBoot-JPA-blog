package com.venew.blog.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venew.blog.model.RoleType;
import com.venew.blog.model.User;
import com.venew.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired //의존성 주입(DI)
	private UserRepository userRepository;
	
	//save함수는 id를 전달하지 않으면 insert를 해주고
	//save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
	//save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 해요.
	//email, password수정
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		//예외처리
		try {
			userRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다. 해당 id는 DB에 존재하지 않습니다.";
		}
		
		return "삭제되었습니다. id : "+id;
	}
	
	@Transactional //함수 종료 시에 자동 commit이 됨
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		//@RequestBody
		//json 데이터를 요청 -> 자바 오브젝트(MessageConverter의 Jackson라이브러리가 변환하여 받아줘요.)
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		//userRepository.save(user);
		
		//@Transactional을 걸면, 더티 체킹
		return user;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();
	}
	
	//한 페이지당 2건의 데이터를 리턴받아 볼 예정
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size = 2, sort= "id", direction=Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagingUser = userRepository.findAll(pageable);
		List<User> users = pagingUser.getContent();
		return users;
	}
	
	
	// {id}주소로 파라미터를 전달받을 수 있음.
	//http://localhost:9090/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		//user/4을 찾으면, 내가 데이터베이스에서 못 찾아오게 되면 user가 null이 될 것 아냐?
		//그럼 return null이 리턴되니까... 프로그램에 문제가 있지 않겠냐??
		//Optional로 너의 User 객체를 감싸서 가져올테니, null인지 아닌지 판단해서 return해!
		
		
		/*User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id : "+id);
			}
		}*/
		
		// !-- 람다식으로 작성해보기. --!
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 사용자는 없습니다.");
		});
		// 요청 : 웹브라우저
		// user 객체 = 자바 오브젝트
		// 변환 (웹브라우저가 이해할 수 있는 데이터) -> json
		// Spring boot = MesseageConverter라는 애가 응답시에 자동으로 작동된다.
		// 만약에 자바 오브젝트를 리턴하게 되면, MessageConverter가 Jackson 라이브러리를 호출하여
		// user 오브젝트를 json으로 변환하여 브라우저에게 던져준다.
		return user;
	}
	
	//http://localhost/9090/blog/dummy/join(요청)
	//http body에 username, password, email데이터를 가지고 (요청)
	@PostMapping("/dummy/join")
	public String join(User user) {
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		//key=value(약속된 규칙) 
		return "회원가입이 완료되었습니다.";
	}
	
}
