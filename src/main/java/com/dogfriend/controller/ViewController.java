package com.dogfriend.controller;

import com.dogfriend.domain.TempHumiVO;
import com.dogfriend.domain.WebView;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController	//controller + reponseBody 객체를 리턴하면 json으로 출력 자바객체를 json으로 변환(?)
public class ViewController {

	private TempHumiVO temHum = new TempHumiVO();	//temp humi 값 저장할 객체 생성

//////////////////////////안드로이드에서 온습도 볼때///////////////////////////////////////
	@GetMapping("/view")	//안드로이드가 온습도를 볼때 콜해야 할 주소
	public ResponseEntity<TempHumiVO> sendAndroid() {
		try {
				
			return new ResponseEntity<>(temHum, HttpStatus.OK);	// 전역변수 temHum인 json을 통째로 안드로이드에게 리턴보낸다. 
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

//////////////////////////온습도 아두이노에서 받기///////////////////////////////////////
	@PostMapping("/setTempHumi")	//온습도 requestMapping + mothod post	//@RequestBody 자바 객체를 만들어준다.
	public ModelAndView rcvArduinoTempHumi(@RequestBody TempHumiVO temHumVo) {	//아두이노에서 온 값을 @RequestBody는 자바객체로 만들어 vo담음
		
		ModelAndView mView = new ModelAndView();
		temHumVo.setTemp(temHumVo.getTemp());
		temHumVo.setHumi(temHumVo.getHumi());

		mView.addObject("temp", temHumVo.getTemp());
		mView.addObject("humi", temHumVo.getHumi());

		mView.setViewName("/dogHome");	//jsp 이름

		System.out.println("temp = " + temHumVo.getTemp() + " humi = " + temHumVo.getHumi());	//출력
		return mView;
	}

////////////////////////////////온습도 웹에서 보기//////////////////////////////
	@PostMapping("/webview")	//	JSON방식으로 jsp에 표현해보기 webview에다가 보내야만 보임 고칠 것
	public ModelAndView webview(@RequestBody WebView webview) {	

		ModelAndView mView = new ModelAndView();
		
		webview.setTemp(webview.getTemp());
		webview.setHumi(webview.getHumi());
		webview.setPower(webview.isPower());
		webview.setPower(webview.isPower());
		
		mView.addObject("temp", webview.getTemp());
		mView.addObject("humi", webview.getHumi());
		mView.addObject("power", webview.isPower());
		mView.addObject("manual", webview.isPower());

		mView.setViewName("/dogHome");	//jsp 이름
		return mView;
	}

	// @PostMapping("/model")
	// public @ResponseBody Map<String, Object> tetetest(@RequestBody TempHumiVO temHumVo) {
	// 	Map<String, Object> map = new HashMap<>();

	// 	int temp = temHumVo.getTemp();
	// 	int humi = temHumVo.getHumi();

	// 	map.put("temp", temp);
	// 	map.put("humi", humi);

	// 	return map;
	// }

	/*@PostMapping("/setTempHumi")	//온습도 requestMapping + mothod post	//@RequestBody 자바 객체를 만들어준다.
	public void revArduinoTempHumi(@RequestBody TempHumiVO temHumVo) {	//아두이노에서 온 값을 @RequestBody는 자바객체로 만들어 vo담음
		
		// int temp = temHumVo.getTemp();
		// int humi = temHumVo.getHumi();

		temHumVo.setTemp(temHumVo.getTemp());	//실서버 셋 해주기
		temHumVo.setHumi(temHumVo.getHumi());

		System.out.println("temp = " + temHumVo.getTemp() + " humi = " + temHumVo.getHumi());	//출력
		
		// try {
		// 	return new ResponseEntity<>("success",HttpStatus.OK);	//성공시 success에 ok를 담는다.
		// } catch (Exception e) {
		// 	e.printStackTrace(); //예외 오류
		// 	return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST); //성공시 fail bad 담는다.
		// }
	}*/

}