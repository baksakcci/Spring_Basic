package hello.core.member;

public interface memberService {

    void join(member member);

    member findMember(Long memberId);
}
