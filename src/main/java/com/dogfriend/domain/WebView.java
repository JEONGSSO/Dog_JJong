package com.dogfriend.domain;

import lombok.Data;

@Data
public class WebView{
    private boolean isPower ;   //스트링?
    private boolean manual ;
    private int temp;
	private int humi;
}