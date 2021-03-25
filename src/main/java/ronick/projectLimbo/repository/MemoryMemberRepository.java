package ronick.projectLimbo.repository;

import org.springframework.stereotype.Repository;
import ronick.projectLimbo.domain.Tb_user;
import ronick.projectLimbo.domain.Tb_user;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long,Tb_user> store = new HashMap<>(); // HashMap을 쓰면 동시성 문제가 생길수 있다.
    private static long sequence = 0L;

    @Override
    public Tb_user save(Tb_user member) { // 시퀀스 값을 제외한 모든 값은 이미 설정함
        member.setUser_id(++sequence);
        store.put(member.getUser_id(), member);
        return member;
    }

    @Override // 카카오 아이디로 유저 찾기
    public Optional<Tb_user> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override // 카카오 닉네임으로 유저 찾기
    public Optional<Tb_user> findByKakaoName(String kakaoName) {
        return store.values().stream()
                .filter(member -> member.getKakao_name().equals(kakaoName))
                .findAny();
    }

    @Override // 아이템으로 유저 찾기
    public Optional<Tb_user> findByItem(String item) {
        return store.values().stream()
                .filter(member -> member.getItem().equals(item))
                .findAny();
    }

    @Override // 랭킹으로 유저 찾기
    public Optional<Tb_user> findByRanking(int ranking) {
        return store.values().stream()
                .filter(member -> member.getRanking() == ranking)
                .findAny();
    }

    @Override // 모든 유저 찾기
    public List<Tb_user> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
