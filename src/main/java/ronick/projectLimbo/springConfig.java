package ronick.projectLimbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ronick.projectLimbo.repository.JpaMemberRepository;
import ronick.projectLimbo.repository.MemberRepository;
import ronick.projectLimbo.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class springConfig {
    private final DataSource dataSourse;
    private final EntityManager em;

    public springConfig(DataSource dataSourse, EntityManager em) {
        this.dataSourse = dataSourse;
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }
}
