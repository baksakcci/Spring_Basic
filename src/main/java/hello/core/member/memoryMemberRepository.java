package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class memoryMemberRepository implements memberRepository {

    private static Map<Long, member> store = new HashMap<>();

    @Override
    public void save(member member) {
        store.put(member.getId(), member);
    }

    @Override
    public member findById(Long memberId) {
        return store.get(memberId);
    }
}
