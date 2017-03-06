package android.hunger.expensetracker.models;

/**
 * Created by hunger on 3/6/2017.
 */

public class Member {

    String membername;
    String memberprofileimageurl;


    public Member() {

    }

    public Member(String membername, String memberprofileimageurl) {
        this.membername = membername;
        this.memberprofileimageurl = memberprofileimageurl;
    }

    public String getMembername() {
        return membername;
    }


    public String getMemberprofileimageurl() {
        return memberprofileimageurl;
    }


}
