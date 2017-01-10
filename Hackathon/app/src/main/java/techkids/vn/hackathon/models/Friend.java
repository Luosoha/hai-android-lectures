package techkids.vn.hackathon.models;

/**
 * Created by Lush on 12/31/2016.
 */

public class Friend {

    private String url;
    private String name;

    public Friend(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public static final Friend[] FRIENDS = new Friend[] {
            new Friend("http://img.giaoduc.net.vn/Uploaded/quynhtien/2014_03_25/LogoFPT2.jpg", "Luong Son Hai"),
            new Friend("http://www.animated-gifs.eu/category_body/avatars-100x100-eyes/0079.gif", "Le Huy Duc"),
            new Friend("http://sinhvienit.net/forum/anh_dai_dien/avatar561853_2.gif", "Nguyen Van Abc"),
            new Friend("http://orig03.deviantart.net/39a8/f/2012/082/b/1/120x120__x3___commission___nyan_cat_loop_by_hampsteronachute-d4todsk.gif", "Jessica Logcat"),
            new Friend("http://sucanhvietnam.com/forum/images/avatars/noavatar.jpg", "Douglas Question Mark")
    };
}
