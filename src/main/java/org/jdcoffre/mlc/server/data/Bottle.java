package org.jdcoffre.mlc.server.data;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Bottle {

    @NotEmpty
    private String name;

    @NotNull
    private WineType type;

    private List<Grape> grapes;

    private String year;

    private Boolean vintage = false;

    private Boolean grandCru = false;

    private Boolean bio = false;

    private String country;

    private String area;

    private String appellation;

    private String size;

    private WineMaker wineMaker;

    private String castle;

    private Boolean gift = false;

    private String giftFrom;

    private String acquisitionDate;

    private String comment;

    private String tastingDate;

    private String tastingComment;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WineType getType() {
        return type;
    }

    public void setType(WineType type) {
        this.type = type;
    }

    public List<Grape> getGrapes() {
        return grapes;
    }

    public void setGrapes(List<Grape> grapes) {
        this.grapes = grapes;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Boolean getVintage() {
        return vintage;
    }

    public void setVintage(Boolean vintage) {
        this.vintage = vintage;
    }

    public Boolean getGrandCru() {
        return grandCru;
    }

    public void setGrandCru(Boolean grandCru) {
        this.grandCru = grandCru;
    }

    public Boolean getBio() {
        return bio;
    }

    public void setBio(Boolean bio) {
        this.bio = bio;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public WineMaker getWineMaker() {
        return wineMaker;
    }

    public void setWineMaker(WineMaker wineMaker) {
        this.wineMaker = wineMaker;
    }

    public String getCastle() {
        return castle;
    }

    public void setCastle(String castle) {
        this.castle = castle;
    }

    public boolean isGift() {
        return gift;
    }

    public void setGift(boolean gift) {
        this.gift = gift;
    }

    public String getGiftFrom() {
        return giftFrom;
    }

    public void setGiftFrom(String giftFrom) {
        this.giftFrom = giftFrom;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTastingDate() {
        return tastingDate;
    }

    public void setTastingDate(String tastingDate) {
        this.tastingDate = tastingDate;
    }

    public String getTastingComment() {
        return tastingComment;
    }

    public void setTastingComment(String tastingComment) {
        this.tastingComment = tastingComment;
    }
}
