package hello.hellospring.controller;

public class MemberForm {
    private String name;

    //getName을 통해 저장되어있는 name값을 꺼낸다.
    public String getName() {
        return name;
    }

    //MemberForm에 변수가 들어오면 setName으로 값을 넣어준다.
    public void setName(String name) {
        this.name = name;
    }
}
