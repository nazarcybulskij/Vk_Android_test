package nazar.optigra_vk_test.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by NAZAR on 24/06/2014.
 */
public class AndroidPost  implements Parcelable {
    public String getOther_text() {
        return other_text;
    }

    public String getAvtor() {
        return avtor;
    }

    public String getText() {
        return text;
    }

    public ArrayList<String> getPhotolistpost() {
        return photolistpost;
    }

    public String getOther_avtor() {
        return other_avtor;
    }

    public ArrayList<String> getOther_photolistpost() {
        return other_photolistpost;
    }

    String avtor;
    String text;
    ArrayList<String> photolistpost=new ArrayList<String>();
    String other_avtor;
    String other_text;
    ArrayList<String> other_photolistpost=new ArrayList<String>();



    public AndroidPost(WallVk.responseVk.Post post) {
        avtor=post.from_id;
        text=post.text;
        if (post.attachmentses!=null){
            for (WallVk.responseVk.Post.attachments temp:post.attachmentses){
                if (temp.photos!=null) {
                    photolistpost.add(temp.photos.photo_130);
                    //Log.v("123",temp.photos.photo_130);
                }

            }
        }
        if (post.copy_history!=null) {
                other_avtor=post.copy_history.get(0).from_id;
                other_text=post.copy_history.get(0).text;
                if (post.copy_history.get(0).attachmentses!=null){
                for (WallVk.responseVk.Post.attachments temp:post.copy_history.get(0).attachmentses){
                    if (temp.photos!=null) {
                        other_photolistpost.add(temp.photos.photo_130);
                        //Log.v("123",temp.photos.photo_130);
                    }

                }
                }

        }

    }


    @Override
    public String toString() {
        return "AndroidPost{" +
                "avtor='" + avtor + '\n' +
                ", text='" + text + '\n' +
                ", photolistpost=" + photolistpost +'\n' +
                ", other_avtor='" + other_avtor + '\n' +
                ", other_text='" + other_text + '\n' +
                ", other_photolistpost=" + other_photolistpost +'\n' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(avtor);
        parcel.writeString(text);
        parcel.writeSerializable(photolistpost);
        parcel.writeString(other_avtor);
        parcel.writeString(other_text);
        parcel.writeSerializable(other_photolistpost);



    }

    public static final Parcelable.Creator<AndroidPost> CREATOR = new Parcelable.Creator<AndroidPost>() {
        // распаковываем объект из Parcel
        public AndroidPost createFromParcel(Parcel in) {
            return new AndroidPost(in);
        }

        public AndroidPost[] newArray(int size) {
            return new AndroidPost[size];
        }
    };


    private AndroidPost(Parcel parcel) {
        avtor = parcel.readString();
        text = parcel.readString();
        photolistpost=(ArrayList<String>) parcel.readSerializable();
        other_avtor = parcel.readString();
        other_text = parcel.readString();
        other_photolistpost=(ArrayList<String>) parcel.readSerializable();

    }



}
