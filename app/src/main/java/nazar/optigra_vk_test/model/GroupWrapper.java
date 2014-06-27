package nazar.optigra_vk_test.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by NAZAR on 26/06/2014.
 */
public class GroupWrapper implements Parcelable {

    public String id;
    public String name;

    public GroupWrapper(WallVk.responseVk.Group group) {
        this.id = group.id;
        this.name = group.name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);

    }

    public static final Parcelable.Creator<GroupWrapper> CREATOR = new Parcelable.Creator<GroupWrapper>() {
        // распаковываем объект из Parcel
        public GroupWrapper createFromParcel(Parcel in) {
            return new GroupWrapper(in);
        }

        public GroupWrapper[] newArray(int size) {
            return new GroupWrapper[size];
        }
    };


    private GroupWrapper(Parcel parcel) {
        id = parcel.readString();
        name = parcel.readString();

    }


}
