package org.example.view;

import org.example.service.MemberService;
import org.example.domain.Admin;
import org.example.domain.Member;

import static java.lang.System.exit;

import java.util.Scanner;

public class mainView {

    public void init(){
        MemberService memberService = new MemberService();

        Scanner sc = new Scanner(System.in);
        unLoginView(sc, memberService);

    }

    public void unLoginView(Scanner sc, MemberService memberService){
        boolean isLogin = false;
        while(!isLogin){
            System.out.println("=========회원 관리 메뉴=========");
            System.out.println("============================");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 이름으로 아이디찾기");
            System.out.println("4. 아이디로 비밀번호찾기");
            System.out.println("0. 프로그램 종료");
            System.out.println("============================");

            int cmd = sc.nextInt();
            switch (cmd){
                case 0:
                    exit(-1);
                case 1:
                    System.out.println("아이디를 입력하세요");
                    String inputId = sc.next();
                    System.out.println("비밀번호를 입력하세요");
                    String inputPw = sc.next();
                    Member foundMember = memberService.getMemeber(inputId, inputPw);
                    if(foundMember == null){
                        Admin foundAdmin = memberService.getAdmin(inputId, inputPw);
                        if(foundAdmin == null){
                            System.out.println("존재하지 않는 사용자입니다 - id/pw 확인하세요");
                        }else{
                            isLogin = true;
                            adminView(sc, foundAdmin, memberService);
                        }
                    }else{
                        System.out.println("로그인 성공");
                        isLogin = true;
                        loginView(sc, foundMember, memberService);
                    }
                    break;
                case 2:
                    System.out.println("회원가입은 총 4단계로 이루어집니다");
                    System.out.println("아이디");
                    String registerId = sc.next();
                    System.out.println("비밀번호");
                    String registerPw = sc.next();
                    System.out.println("이름");
                    String registerName = sc.next();
                    System.out.println("전화번호");
                    String registerPhone = sc.next();

                    if(memberService.isIdExist(registerId)){
                        System.out.println(registerId + "< 해당 아이디는 존재합니다! ");
                        break;
                    }
                    memberService.getMemberList().add(
                        new Member(registerId, registerPw, registerName, registerPhone)
                    );
                    System.out.println("회원가입에 성공했습니다!!");
                    break;
                case 3:
                    System.out.println("이름으로 아이디를 찾습니다...");
                    System.out.println("이름을 입력하세요");
                    String findName = sc.next();
                    String foundId = memberService.getMemberIdFromName(findName);
                    if(foundId != null){
                        System.out.println(findName + "<< 이름으로 등록된 아이디는 " + foundId + "입니다");
                    }else{
                        System.out.println(findName + "이름으로 등록된 아이디는 없습니다!");
                    }
                    break;
                case 4:
                    System.out.println("아이디로 비밀번호를 찾습니다...");
                    System.out.println("아이디를 입력하세요");
                    String findId = sc.next();
                    String foundPw = memberService.getMemberPwFromId(findId);
                    if(foundPw != null){
                        System.out.println(findId + "<< 아이디로 등록된 비밀번호 " + foundPw + "입니다");
                    }else{
                        System.out.println(findId + "아이디으로 등록된 비밀번호는 없습니다!");
                    }
                    break;
            }
        }

    }

    public void loginView(Scanner sc, Member member, MemberService memberService){
        System.out.println("안녕하세요 " + member.getId() + "님! ");
        while(true){
            System.out.println("1. 로그아웃(프로그램종료)");
            System.out.println("2. 내정보조회(로그인시)");
            System.out.println("3. 비밀번호변경(로그인시)");
            System.out.println("4. 내정보 전체 변경(아이디-비밀번호-이름-전화번호 순서)");
            System.out.println("5. 마일리지 올리기!!(5만원단위)");

            int cmd = sc.nextInt();
            switch (cmd){
                case 1:
                    exit(-1);
                case 2:
                    System.out.println("내정보를 조회합니다");
                    System.out.println(member);
                    break;
                case 3:
                    System.out.println("현재 비밀번호 " + member.getPw());
                    System.out.println("변경하고자 하는 비밀번호 ");
                    String tobePw = sc.next();
                    member.setPw(tobePw);
                    System.out.println("비밀번호가 성공적으로 " + tobePw + "로 변경되었습니다");
                    break;
                case 4:
                    System.out.println("내 정보를 전체적으로 변경합니다....");
                    System.out.println("아이디 변경");
                    String tbId = sc.next();
                    member.setId(tbId);
                    String tbPw = sc.next();
                    member.setPw(tbPw);
                    String tbName = sc.next();
                    member.setMemberName(tbName);
                    String tbPhone = sc.next();
                    member.setMobileNumber(tbPhone);
                    System.out.println("현재 회원의 정보가 전체적으로 변경되었습니다");
                    break;
                case 5:
                    System.out.println(member.getId() + "<< 해당 멤버의 마일리지를 5만원 올립니다");
                    System.out.println("현재 해당 사용자의 마일리지 금액은 " + member.getMileage() + "원 입니다");
                    memberService.upgrade(member, 50000);
            }
        }
    }

    public void adminView(Scanner sc, Admin admin, MemberService memberService){
        System.out.println("admin 계정 " + admin.getId() +"으로 로그인했습니다");
        while(true){
            System.out.println("1. 로그아웃(프로그램종료)");
            System.out.println("2. 내정보조회(로그인시)");
            System.out.println("3. 비밀번호변경(로그인시)");
            System.out.println("4. 내정보 전체 변경(아이디-비밀번호-이름-전화번호 순서)");
            System.out.println("=====ADMIN 기능====");
            System.out.println("5. 전체 회원 정보조회(pw는 앞 2자리까지 조회가능)");

            int cmd = sc.nextInt();
            switch (cmd){
                case 1:
                    exit(-1);
                case 2:
                    System.out.println("내정보를 조회합니다");
                    System.out.println(admin);
                    break;
                case 3:
                    System.out.println("현재 비밀번호 " + admin.getPw());
                    System.out.println("변경하고자 하는 비밀번호 ");
                    String tobePw = sc.next();
                    admin.setPw(tobePw);
                    System.out.println("비밀번호가 성공적으로 " + tobePw + "로 변경되었습니다");
                    break;
                case 4:
                    System.out.println("내 정보를 전체적으로 변경합니다....");
                    System.out.println("아이디 변경");
                    String tbId = sc.next();
                    admin.setId(tbId);
                    String tbPw = sc.next();
                    admin.setPw(tbPw);
                    String tbName = sc.next();
                    admin.setName(tbName);
                    String tbPhone = sc.next();
                    admin.setMobileNumber(tbPhone);
                    System.out.println("현재 관리자의 정보가 전체적으로 변경되었습니다");
                    break;
                case 5:
                    System.out.println("현재 등록되어 있는 모든 사용자의 아이디를 조회합니다");
                    memberService.inquiryAllMembers();
                    break;
            }
        }

    }
}
