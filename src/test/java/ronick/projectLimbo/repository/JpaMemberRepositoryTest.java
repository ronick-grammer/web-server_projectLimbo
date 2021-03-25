package ronick.projectLimbo.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import ronick.projectLimbo.domain.Tb_user;

import javax.persistence.EntityManager;

@SpringBootTest
public class JpaMemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void 아이디_조회(){
        Tb_user member = memberRepository.findByKakaoName("sck").get();

        Assertions.assertThat(member.getKakao_name()).isEqualTo("ronick");
    }

}
