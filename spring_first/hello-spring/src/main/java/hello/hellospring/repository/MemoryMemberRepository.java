package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    //sequence: 0,1,2 등 키값을 생성하는 역할
    private  static long sequence = 0L;


    @Override
    public Member save(Member member) {
        //id를 세팅
        member.setId(++sequence);
        //store에 저장
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //Optional.ofNullable: id가 null이어도 수행 가능
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //루프를 돌림
        return store.values().stream()
                //getName이 파라미터로 넘어온 name과 같은지 확인
                .filter(member -> member.getName().equals(name))
                //찾으면 반환, 만약 없으면 Optional에 null값 반환
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
