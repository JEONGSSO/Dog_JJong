package com.dogfriend.controller;

import com.dogfriend.domain.HandleVO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/android")
@RestController
public class AndroidController {

    HandleVO handle = new HandleVO();

    //////////////////////////// 안드로이드에서 버튼 전원 온오프(자동모드) 눌렀을때////////////////////////////////////
    @PostMapping("/setpower") // 안드로이드가 전원 온오프 누를때 콜해야 할 주소
    public ResponseEntity<String> setAndroidPower(@RequestBody HandleVO handle) { // 아두이노에서 온 값을 @RequestBody는 자바객체로 만들어 vo담음

        //요거 제이슨 key statePower value on/off = String
        //handle.setPower(handle.isPower()); // power 받아오면 값을 담아준다. boolean은 isPower == getPower 
        //셋 한걸 아두이노에게 쏘기
        

        try {
            return new ResponseEntity<>("Server set Power OK", HttpStatus.OK); //성공하면 안드로이드에게 성공 리턴
        } catch (Exception e) {
            return new ResponseEntity<>("Server set Fail", HttpStatus.BAD_REQUEST);
        }
    }

    /////////////////////////// 안드로이드에서 수동모드 클릭했을때/////////////////////////////////////////////////////
    @PostMapping("/setmanual")
    public ResponseEntity<String> setAndroidauto(@RequestBody HandleVO handle) {

        handle.setAutoMode(handle.isAutoMode()); // boolean 타입
        //셋 한걸 아두이노에게 쏘기

        try {
            return new ResponseEntity<>("Server set AutoMode ", HttpStatus.OK); //성공하면 안드로이드에게 성공 리턴
        } catch (Exception e) {
            return new ResponseEntity<>("Server set Fail", HttpStatus.BAD_REQUEST);
        }
    }
}