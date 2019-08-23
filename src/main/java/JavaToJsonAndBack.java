/**
 * 转换 json 成一个 java 对象
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class JavaToJsonAndBack {

    public static void main(String[] args) {
        Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(albums));

    }
}

class Albums {
    public String title;
    public String message;
    public List<String> errors = new ArrayList<String>();
    public String total;
    public int total_pages;
    public int page;
    public String limit;
    public List<Dataset> dataset = new ArrayList<>();

    public static void main(String[] args) {
        Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";

        Dataset dataset = new Dataset();
        dataset.album_id = "7596";
        dataset.album_title = "Album 1";


        AlbumImages image = new AlbumImages();
        image.image_id = "1";

        dataset.images.add(image);
        albums.dataset.add(dataset);

        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        builder.setPrettyPrinting(); // 打印的 json 格式化后的样式
        Gson gson = builder.create();
        System.out.println(gson.toJson(albums));
    }

}


class Dataset {
    public String album_id;
    public String album_title;
    @SerializedName("album_images") // 更改序列化的名称
    public List<AlbumImages> images = new ArrayList<>();

    public static void main(String[] args) {
//        main1();
        main2();
    }

    private static void main1() {
        Dataset dataset = new Dataset();
        dataset.album_id = "7596";
        dataset.album_title = "Album 1";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(dataset));
    }

    private static void main2() {
        Dataset dataset = new Dataset();
        dataset.album_id = "7596";
        dataset.album_title = "Album 1";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(dataset));
    }
}

class AlbumImages {
    public String image_id;
    public String user_id;
    public String albumId;

    /**
     * builder.serializeNulls(); 可以让 null 字段也序列化
     *
     * @param args
     */
    public static void main(String[] args) {
        AlbumImages image = new AlbumImages();
        image.image_id = "1";
        image.albumId = "10";
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls(); // 我们需要显示告诉 null 字段也需要序列化
        builder.setFieldNamingStrategy(f -> {   // 自定义名称对应关系
            if (f.getName().equals("albumId"))
                return "album_id";
            else
                return f.getName();
        });
        Gson gson = builder.create();
        System.out.println(gson.toJson(image));
    }
}
