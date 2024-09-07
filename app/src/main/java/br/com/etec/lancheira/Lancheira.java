package br.com.etec.lancheira;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Lancheira implements Parcelable {

    private ArrayList<FoodItem> construtores;
    private ArrayList<FoodItem> reguladores;
    private ArrayList<FoodItem> energeticos;
    private String dataLancheira;

    public Lancheira(ArrayList<FoodItem> construtores, ArrayList<FoodItem> reguladores, ArrayList<FoodItem> energeticos, String dataLancheira) {
        this.construtores = construtores;
        this.reguladores = reguladores;
        this.energeticos = energeticos;
        this.dataLancheira = dataLancheira;
    }

    protected Lancheira(Parcel in) {
        construtores = in.createTypedArrayList(FoodItem.CREATOR);
        reguladores = in.createTypedArrayList(FoodItem.CREATOR);
        energeticos = in.createTypedArrayList(FoodItem.CREATOR);
        dataLancheira = in.readString();
    }

    public static final Creator<Lancheira> CREATOR = new Creator<Lancheira>() {
        @Override
        public Lancheira createFromParcel(Parcel in) {
            return new Lancheira(in);
        }

        @Override
        public Lancheira[] newArray(int size) {
            return new Lancheira[size];
        }
    };

    public ArrayList<FoodItem> getConstrutores() {
        return construtores;
    }

    public ArrayList<FoodItem> getReguladores() {
        return reguladores;
    }

    public ArrayList<FoodItem> getEnergeticos() {
        return energeticos;
    }

    public String getDataLancheira() {
        return dataLancheira;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(construtores);
        dest.writeTypedList(reguladores);
        dest.writeTypedList(energeticos);
        dest.writeString(dataLancheira);
    }
}