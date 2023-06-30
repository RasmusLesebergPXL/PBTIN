package be.pxl.car;

import java.util.ArrayList;
import java.util.List;

public class CollisionRecord {

    private String month;
    private String dayNight;
    private boolean weekend;
    private String vehicleSegment;
    private String ownerType;
    private List<CarType> carTypes = new ArrayList<>();
    private Province province;
    private String weather;
    private String lightCondition;
    private String roadType;
    private String accidentClass;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDayNight() {
        return dayNight;
    }

    public void setDayNight(String dayNight) {
        this.dayNight = dayNight;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    public String getVehicleSegment() {
        return vehicleSegment;
    }

    public void setVehicleSegment(String vehicleSegment) {
        this.vehicleSegment = vehicleSegment;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public List<CarType> getCarTypes() {
        return carTypes;
    }

    public void setCarTypes(List<CarType> carTypes) {
        this.carTypes = carTypes;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getLightCondition() {
        return lightCondition;
    }

    public void setLightCondition(String lightCondition) {
        this.lightCondition = lightCondition;
    }

    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    public String getAccidentClass() {
        return accidentClass;
    }

    public void setAccidentClass(String accidentClass) {
        this.accidentClass = accidentClass;
    }

    @Override
    public String toString() {
        return "CollisionRecord{" +
                "monthCollision='" + month + '\'' +
                ", dayNight='" + dayNight + '\'' +
                ", weekend=" + weekend +
                ", vehicleSegment='" + vehicleSegment + '\'' +
                ", ownerType='" + ownerType + '\'' +
                ", carTypes=" + carTypes +
                ", province='" + province + '\'' +
                ", weather='" + weather + '\'' +
                ", lightCondition='" + lightCondition + '\'' +
                ", roadType='" + roadType + '\'' +
                ", accidentClass='" + accidentClass + '\'' +
                '}';
    }
}
