package hello.core.member;

import java.lang.reflect.Member;

public interface memberRepository {

    void save(member member);

    member findById(Long memberId);
}
