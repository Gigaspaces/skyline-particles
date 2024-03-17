package com.mycompany.app;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;

import java.io.Serializable;


/**
 * An Account is a space type that holds some account details
 */
@SpaceClass
public class Account implements Serializable {

    private Integer accountId;
    private Integer districtId;
    private String accountType;
    private String creationDateYymmdd;

    public Account(Integer accountId, Integer districtId, String accountType, String creationDateYymmdd) {
        this.accountId = accountId;
        this.districtId = districtId;
        this.accountType = accountType;
        this.creationDateYymmdd = creationDateYymmdd;
    }
    public Account() {
    }


    // getter and setters are manadatory.

    @SpaceId(autoGenerate = false)
    @SpaceRouting
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCreationDateYymmdd() {
        return creationDateYymmdd;
    }

    public void setCreationDateYymmdd(String creationDateYymmdd) {
        this.creationDateYymmdd = creationDateYymmdd;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", districtId=" + districtId +
                ", accountType='" + accountType + '\'' +
                ", creationDateYymmdd='" + creationDateYymmdd + '\'' +
                '}';
    }
}
