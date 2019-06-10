package models;

import java.io.Serializable;

@SuppressWarnings("all")
public class Date implements Serializable {

    int day, year, month;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.year = year;
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public static boolean validateDate(Date mfgDate, Date expDate){

        if (mfgDate.year < expDate.year)
            if (mfgDate.month < expDate.month)
                if (mfgDate.day < expDate.day)
                    return true;
                else
                    return false;
            else
                return false;
        else
            return false;
        

    }


    @Override
    public String toString() {
        return getDay() + "-" + getMonth() + "-" + getYear() + "\n";
    }

}