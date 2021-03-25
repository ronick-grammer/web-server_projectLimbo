package ronick.projectLimbo.repository;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ronick.projectLimbo.domain.Tb_user;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void 저장(){
        Tb_user tb_user = new Tb_user();
        tb_user.setKakao_name("김영현이다");
        tb_user.setItem("Axe");
        tb_user.setPlay_hour(60);
        tb_user.setRanking(3);
        repository.save(tb_user);

        Tb_user wrong = new Tb_user();
        wrong.setKakao_name("왓더");
        wrong.setItem("sword");
        wrong.setPlay_hour(50);
        wrong.setRanking(1);
        repository.save(wrong);

        Tb_user result = repository.findById(tb_user.getUser_id()).get();
        Assertions.assertThat(wrong).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Tb_user tb_user = new Tb_user();
        tb_user.setKakao_name("김영현이다");
        tb_user.setItem("Axe");
        tb_user.setPlay_hour(60);
        tb_user.setRanking(3);
        repository.save(tb_user);

        Tb_user wrong = new Tb_user();
        wrong.setKakao_name("왓더");
        wrong.setItem("sword");
        wrong.setPlay_hour(50);
        wrong.setRanking(1);
        repository.save(wrong);

        Tb_user result = repository.findByKakaoName(tb_user.getKakao_name()).get();
        Assertions.assertThat(wrong).isEqualTo(result);

    }

    @Test
    public void findByItem(){
        Tb_user tb_user = new Tb_user();
        tb_user.setKakao_name("김영현이다");
        tb_user.setItem("Axe");
        tb_user.setPlay_hour(60);
        tb_user.setRanking(3);
        repository.save(tb_user);

        Tb_user wrong = new Tb_user();
        wrong.setKakao_name("왓더");
        wrong.setItem("sword");
        wrong.setPlay_hour(50);
        wrong.setRanking(1);
        repository.save(wrong);

        Tb_user result = repository.findByItem(tb_user.getItem()).get();
        Assertions.assertThat(wrong).isEqualTo(result);
    }

    @Test
    public void findByRanking(){
        Tb_user tb_user = new Tb_user();
        tb_user.setKakao_name("김영현이다");
        tb_user.setItem("Axe");
        tb_user.setPlay_hour(60);
        tb_user.setRanking(3);
        repository.save(tb_user);

        Tb_user wrong = new Tb_user();
        wrong.setKakao_name("왓더");
        wrong.setItem("sword");
        wrong.setPlay_hour(50);
        wrong.setRanking(1);
        repository.save(wrong);

        Tb_user result = repository.findByRanking(tb_user.getRanking()).get();
        Assertions.assertThat(wrong.getRanking()).isEqualTo(result.getRanking());
    }

    @Test
    public void findAll(){
        Tb_user tb_user1 = new Tb_user();
        tb_user1.setKakao_name("김영현이다");
        tb_user1.setItem("Axe");
        tb_user1.setPlay_hour(60);
        tb_user1.setRanking(3);
        repository.save(tb_user1);

        Tb_user tb_user2 = new Tb_user();
        tb_user2.setKakao_name("왓더");
        tb_user2.setItem("sword");
        tb_user2.setPlay_hour(50);
        tb_user2.setRanking(1);
        repository.save(tb_user2);

        Tb_user tb_user3 = new Tb_user();
        tb_user3.setKakao_name("왓더");
        tb_user3.setItem("sword");
        tb_user3.setPlay_hour(50);
        tb_user3.setRanking(1);
        repository.save(tb_user3);

        List<Tb_user> alltb_users = repository.findAll();

        Assertions.assertThat(alltb_users.size()).isEqualTo(2);
    }

}
