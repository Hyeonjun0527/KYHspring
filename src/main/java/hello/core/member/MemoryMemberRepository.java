package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    /**
     *이렇게 간단하게 메모리상에서 멤버를 저장하는 방식으로 테스트를 해볼 수 있을 것이다.
     *그런데 단순한 해시맵이면 동시에 접근하면 문제가 생길 수 있다.
     *그래서 사실 엄밀하게는 Concurrent HashMap을 사용해야 한다.
     */
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
