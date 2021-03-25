package ronick.projectLimbo.controller;

// 삽입에 사용될 유저 양식
public class UserForm {
    private String kakao_id;
    private String kakao_name; // 플레이어 이름
    private String kakao_photo_url;
    private int point;
    private String access_token;
    private String item; // 플레이어가 소유한 하나의 아이템
    private int play_hour; // 총 플레이 시간
    private int ranking; // 플레이어의 순위(플레이 시간에 따라 결정됨)
    private int deleted;

    public String getKakao_id() {
        return kakao_id;
    }

    public void setKakao_id(String kakao_id) {
        this.kakao_id = kakao_id;
    }

    public String getKakao_name() {
        return kakao_name;
    }

    public void setKakao_name(String kakao_name) {
        this.kakao_name = kakao_name;
    }

    public String getKakao_photo_url() {
        return kakao_photo_url;
    }

    public void setKakao_photo_url(String kakao_photo_url) {
        this.kakao_photo_url = kakao_photo_url;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPlay_hour() {
        return play_hour;
    }

    public void setPlay_hour(int play_hour) {
        this.play_hour = play_hour;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
