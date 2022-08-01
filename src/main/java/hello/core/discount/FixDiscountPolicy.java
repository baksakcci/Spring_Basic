package hello.core.discount;

import hello.core.member.grade;
import hello.core.member.member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(member member, int price) {
        if (member.getGrade() == grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
