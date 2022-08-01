package hello.core.discount;

import hello.core.annotation.mainDiscountPolicy;
import hello.core.member.grade;
import hello.core.member.member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@mainDiscountPolicy
//@Primary
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(member member, int price) {
        if (member.getGrade() == grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
