package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class memberServiceImpl implements memberService {

    private final memberRepository memberRepository;

    @Autowired
    public memberServiceImpl(memberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(member member) {
        memberRepository.save(member);
    }

    @Override
    public member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Configuration Test 용도
    public memberRepository getMemberRepository() {
        return memberRepository;
    }
}
