package ronick.projectLimbo.repository;


import ronick.projectLimbo.domain.Tb_user;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Tb_user save(Tb_user member);
    Optional<Tb_user> findById(Long id);
    Optional<Tb_user> findByKakaoName(String kakaoName);
    Optional<Tb_user> findByItem(String item);
    Optional<Tb_user> findByRanking(int ranking);
    List<Tb_user> findAll();
}
