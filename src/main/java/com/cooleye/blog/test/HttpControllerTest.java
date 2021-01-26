package com.cooleye.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML 파일)
// @Conteroller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";

	// http://localhost:8080/http/get
	@GetMapping("/http/get")
	//public String getTest(@RequestParam int id) {
	public String getTest(Member m) {  // -> 스프링은 모델의 변수로 파라메터 입력시 모델오브젝트로 자동 파싱해서 넣어준다. -> MessageConverter(스프링부트)
		return "get 요청:"+m.getId() +","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}

	//localhost:8080/http/post
	@PostMapping("/http/post") 
	public String postTest(@RequestBody Member m) { // -> 스프링은 JSON(application/json)으로 데이터 전송시 모델오브젝트로 자동 파싱해서 넣어준다. -> MessageConverter(스프링부트)
		return "post 요청 : "+m.getId() +","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}

	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
	@GetMapping("/http/lombok")
	public String lombokTest() {
		//Member m = new Member(1, "ssar", "1234","email");
		Member m = Member.builder().username("홍길동").password("1234").email("aaaaa").build();
		System.out.println(TAG + "getter : " + m.getUsername());
		m.setUsername("바보");
		System.out.println(TAG + "setter : " + m.getUsername());
		
		return "lombok test 완료";
	}
}
