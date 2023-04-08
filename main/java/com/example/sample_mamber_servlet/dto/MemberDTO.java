package com.example.sample_mamber_servlet.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {

    private String id;
    private String password;
    private String name;
    private String gender;
    private String birth;
    private String mail;
    private String phone;
    private String zipcode;     //우편번호
    private String address01;
    private String address02;   //상세주소
    private String registDay;

}
