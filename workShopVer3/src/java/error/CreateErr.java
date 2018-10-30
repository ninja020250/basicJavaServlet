/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package error;

/**
 *
 * @author hp
 */
public class CreateErr {

    String mobileIdLengthErr;
    String descriptionLenghthErr;
    String mobileNameLengthErr;
    String mobileNameExistedErr;

    public CreateErr() {
    }

    public String getMobileNameExistedErr() {
        return mobileNameExistedErr;
    }

    public void setMobileNameExistedErr(String mobileNameExistedErr) {
        this.mobileNameExistedErr = mobileNameExistedErr;
    }

    public String getMobileIdLengthErr() {
        return mobileIdLengthErr;
    }

    public void setMobileIdLengthErr(String mobileIdLengthErr) {
        this.mobileIdLengthErr = mobileIdLengthErr;
    }

    public String getDescriptionLenghthErr() {
        return descriptionLenghthErr;
    }

    public void setDescriptionLenghthErr(String descriptionLenghthErr) {
        this.descriptionLenghthErr = descriptionLenghthErr;
    }

    public String getMobileNameLengthErr() {
        return mobileNameLengthErr;
    }

    public void setMobileNameLengthErr(String mobileNameLengthErr) {
        this.mobileNameLengthErr = mobileNameLengthErr;
    }

}
