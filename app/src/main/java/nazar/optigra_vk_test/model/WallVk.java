package nazar.optigra_vk_test.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by NAZAR on 24/06/2014.
 */
public class WallVk {

    @SerializedName("response")
    public responseVk response;

    static public class responseVk{

        @SerializedName("items")
        public ArrayList<Post> postlist;
        @SerializedName("groups")
        public   ArrayList<Group> groups=new ArrayList<Group>();

        public  class Group {
            @SerializedName("name")
            public String name;
            @SerializedName("id")
            public String id;

            @Override
            public String toString() {
                return "Group{" +
                        "name='" + name + '\'' +
                        ", id='" + id + '\'' +
                        '}';
            }
        }






            static public class Post{

            @SerializedName("from_id")
            public String from_id;
            @SerializedName("text")
            public String text;
            @SerializedName("attachments")
            public ArrayList<attachments> attachmentses;
            @SerializedName("copy_history")
            public ArrayList<CopyHistory> copy_history;

            @Override
            public String toString() {
                return "{" +
                        "from_id=" + from_id + '\n' +
                        "text=" + text + '\n' +
                        "attachmentses=" + attachmentses +'\n' +
                        "copy_history=" + copy_history +'\n' +
                        "}";
            }

            static public class CopyHistory{
                @SerializedName("from_id")
                public String from_id;
                @SerializedName("attachments")
                public ArrayList<attachments> attachmentses;
                @SerializedName("text")
                public String text;

                @Override
                public String toString() {
                    return "{" +
                            "from_id=" + from_id + '\n' +
                            "attachmentses=" + attachmentses + '\n' +
                            "}";
                }
            }
            static public class attachments {

                @SerializedName("type")
                String type;
                @SerializedName("photo")
                photo photos;

                @Override
                public String toString() {
                    return "{" +
                            "type=" + type + '\n' +
                            "photos=" + photos +
                            '}';
                }

                static public class photo{
                    @Override
                    public String toString() {
                        return "{" +
                                "photo_130=" + photo_130 + '\n' +
                                '}';
                    }

                    @SerializedName("photo_604")
                    String photo_130;

                }

            }
         }

    }


}
