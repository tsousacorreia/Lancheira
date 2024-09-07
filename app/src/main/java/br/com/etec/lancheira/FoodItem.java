package br.com.etec.lancheira;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodItem implements Parcelable {

    private String name;
    private int imageResource;

    public FoodItem(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    protected FoodItem(Parcel in) {
        name = in.readString();
        imageResource = in.readInt();
    }

    public static final Creator<FoodItem> CREATOR = new Creator<FoodItem>() {
        @Override
        public FoodItem createFromParcel(Parcel in) {
            return new FoodItem(in);
        }

        @Override
        public FoodItem[] newArray(int size) {
            return new FoodItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResource);
    }
}
