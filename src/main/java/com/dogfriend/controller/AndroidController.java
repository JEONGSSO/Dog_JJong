package com.dogfriend.controller;

import javax.servlet.http.HttpServletResponse;

import com.dogfriend.domain.HandleVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/android")
@RestController
public class AndroidController {

    HandleVO handle = new HandleVO();

    //////////////////////////// 안드로이드에서 버튼 전원 온오프(자동모드) 눌렀을때////////////////////////////////////
    @GetMapping("/setpower") // 안드로이드가 전원 온오프 누를때 콜해야 할 주소
    public ResponseEntity<HandleVO> setAndroidPower(@RequestParam("power") int power) { // 아두이노에서 온 값을 @RequestBody는 자바객체로 만들어 vo담음

        //요거 제이슨 key statePower value on/off = String
       //셋 한걸 아두이노에게 바로 아두이노에게 쏴보기
        try {
            handle.setPower(power); // power 받아오면 값을 담아준다. boolean은 isPower == getPower 
            System.out.println("power : " + power);
            return new ResponseEntity<>(handle, HttpStatus.OK); //성공하면 안드로이드에게 성공 리턴
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*/////////////////////////// 안드로이드에서 버튼 전원 온오프(자동모드) 눌렀을때////////////////////////////////////
    @PostMapping("/setpower") // 안드로이드가 전원 온오프 누를때 콜해야 할 주소
    public ResponseEntity<String> setAndroidPower(@RequestBody HandleVO handle) { // 아두이노에서 온 값을 @RequestBody는 자바객체로 만들어 vo담음

        //요거 제이슨 key statePower value on/off = String
       //셋 한걸 아두이노에게 바로 아두이노에게 쏴보기
        try {

            handle.setPower(handle.isPower()); // power 받아오면 값을 담아준다. boolean은 isPower == getPower 
            System.out.println("power : " + handle.isPower());
            return new ResponseEntity<>("Server set Power OK", HttpStatus.OK); //성공하면 안드로이드에게 성공 리턴
        } catch (Exception e) {
            return new ResponseEntity<>("Server set Fail", HttpStatus.BAD_REQUEST);
        }
    }*/

    /////////////////////////// 안드로이드에서 수동모드 클릭했을때/////////////////////////////////////////////////////
    @PostMapping("/setmanual")
    public ResponseEntity<HandleVO> setAndroidManual(@RequestBody HandleVO handle) {

        //셋 한걸 아두이노에게 바로 아두이노에게 쏴보기 response.sendredirect??
        
        try {

            handle.setManual(handle.isManual()); // boolean 타입
            System.out.println("manual : " + handle.isManual());

            return new ResponseEntity<>(handle, HttpStatus.OK); //성공하면 안드로이드에게 성공 리턴
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}