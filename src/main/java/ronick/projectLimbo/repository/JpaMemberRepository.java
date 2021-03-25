package ronick.projectLimbo.repository;

import ronick.projectLimbo.domain.Tb_user;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements  MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Tb_user save(Tb_user member) {
        em.persist(member); // insert 쿼리 까지 완료
        return member;
    }

    @Override // 카카오 아이디로 유저 찾기
    public Optional<Tb_user> findById(Long id) {
        Tb_user member = em.find(Tb_user.class, id);
        return Optional.ofNullable(member);
    }

    @Override // 카카오 닉네임으로 유저 찾기
    public Optional<Tb_user> findByKakaoName(String kakao_name) {
        // ** EntityManager 쿼리 문의 테이블명은 엔티티 맵핑된 클래스 명과 토씨하나 틀리지 않고 일치해야한다.(대소문자 구분)
        List<Tb_user> result = em.createQuery("select m from Tb_user m where m.kakao_name = :kakao_name", Tb_user.class)
                .setParameter("kakao_name", kakao_name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override // 아이템 이름으로 유저 찾기
    public Optional<Tb_user> findByItem(String item) {
        List<Tb_user> result = em.createQuery("select m from Tb_user m where m.item = :item", Tb_user.class)
                .setParameter("item", item)
                .getResultList();

        return result.stream().findAny();
    }

    @Override // 랭킹으로 유저 찾기
    public Optional<Tb_user> findByRanking(int ranking) {
        List<Tb_user> result = em.createQuery("select m from Tb_user m where m.ranking = :ranking",Tb_user.class)
                .setParameter("ranking", ranking)
                .getResultList();

        return result.stream().findAny();
    }

    @Override // 모든 유저 찾기
    public List<Tb_user> findAll() {
        List<Tb_user> result = em.createQuery("select m from Tb_user m", Tb_user.class)
                .getResultList();

        return result;
    }
}
