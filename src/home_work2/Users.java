package home_work2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Users {
    private long serialNumber;
    private List<Integer> listNumber=new ArrayList<>();

    public Users(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Users(int serialNumber) {
        this.serialNumber = serialNumber;

    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setListNumber(List<Integer> listNumber) {
        this.listNumber = listNumber;
    }

    public List<Integer> getListNumber() {
        return listNumber;
    }
}
