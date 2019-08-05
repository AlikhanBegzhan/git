package kz.test.car.model.form;

public class CarForm {

    private Integer carFormId;
    private String carFormModel;
    private String carFormYear;
    private Integer carFormMileage;
    private String carFormOwnerName;
    private String carFormOwnerNumber;
    private String carFormOwnerAddress;
    private String carFormMasterName;
    private String carFormMasterWork;

    public CarForm(Integer carFormId, String carFormModel, String carFormYear,
                   Integer carFormMileage, String carFormOwnerName, String carFormOwnerNumber,
                   String carFormOwnerAddress, String carFormMasterName, String carFormMasterWork) {
        this.carFormId = carFormId;
        this.carFormModel = carFormModel;
        this.carFormYear = carFormYear;
        this.carFormMileage = carFormMileage;
        this.carFormOwnerName = carFormOwnerName;
        this.carFormOwnerNumber = carFormOwnerNumber;
        this.carFormOwnerAddress = carFormOwnerAddress;
        this.carFormMasterName = carFormMasterName;
        this.carFormMasterWork = carFormMasterWork;
    }

    public CarForm() {
    }

    public Integer getCarFormId() {
        return carFormId;
    }

    public void setCarFormId(Integer carFormId) {
        this.carFormId = carFormId;
    }

    public String getCarFormModel() {
        return carFormModel;
    }

    public void setCarFormModel(String carFormModel) {
        this.carFormModel = carFormModel;
    }

    public String getCarFormYear() {
        return carFormYear;
    }

    public void setCarFormYear(String carFormYear) {
        this.carFormYear = carFormYear;
    }

    public Integer getCarFormMileage() {
        return carFormMileage;
    }

    public void setCarFormMileage(Integer carFormMileage) {
        this.carFormMileage = carFormMileage;
    }

    public String getCarFormOwnerName() {
        return carFormOwnerName;
    }

    public void setCarFormOwnerName(String carFormOwnerName) {
        this.carFormOwnerName = carFormOwnerName;
    }

    public String getCarFormOwnerNumber() {
        return carFormOwnerNumber;
    }

    public void setCarFormOwnerNumber(String carFormOwnerNumber) {
        this.carFormOwnerNumber = carFormOwnerNumber;
    }

    public String getCarFormOwnerAddress() {
        return carFormOwnerAddress;
    }

    public void setCarFormOwnerAddress(String carFormOwnerAddress) {
        this.carFormOwnerAddress = carFormOwnerAddress;
    }

    public String getCarFormMasterName() {
        return carFormMasterName;
    }

    public void setCarFormMasterName(String carFormMasterName) {
        this.carFormMasterName = carFormMasterName;
    }

    public String getCarFormMasterWork() {
        return carFormMasterWork;
    }

    public void setCarFormMasterWork(String carFormMasterWork) {
        this.carFormMasterWork = carFormMasterWork;
    }
}
