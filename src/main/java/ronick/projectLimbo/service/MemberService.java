package ronick.projectLimbo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ronick.projectLimbo.domain.Tb_user;
import ronick.projectLimbo.domain.Tb_user;
import ronick.projectLimbo.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private MemberRepository memberRepository;

    //DI, 의존성 주입
    public MemberService(MemberRepository memberRepository){

        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Tb_user member){
        validateDuplicatedMember(member);

        memberRepository.save(member);
        return member.getUser_id();
    }

    // 아이디 중복 여부 확인
    private void validateDuplicatedMember(Tb_user member) {
        memberRepository.findByKakaoName(member.getKakao_name())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 모든 유저 찾기
    public List<Tb_user> findMembers(){
        return memberRepository.findAll();
    }

    //
    public Optional<Tb_user> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
