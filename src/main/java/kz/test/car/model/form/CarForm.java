package kz.test.car.model.form;

public class CarForm {

    private Integer id;
    private String carModel;
    private String carYear;
    private int carMileage;
    private String carOwnerName;
    private String carOwnerNumber;
    private String carOwnerAddress;
    private String carMasterName;
    private String carMasterWork;

    public CarForm(Integer id, String carModel, String carYear,
                   int carMileage, String carOwnerName, String carOwnerNumber,
                   String carOwnerAddress, String carMasterName, String carMasterWork) {
        this.id = id;
        this.carModel = carModel;
        this.carYear = carYear;
        this.carMileage = carMileage;
        this.carOwnerName = carOwnerName;
        this.carOwnerNumber = carOwnerNumber;
        this.carOwnerAddress = carOwnerAddress;
        this.carMasterName = carMasterName;
        this.carMasterWork = carMasterWork;
    }

    public CarForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
    }

    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }

    public String getCarOwnerNumber() {
        return carOwnerNumber;
    }

    public void setCarOwnerNumber(String carOwnerNumber) {
        this.carOwnerNumber = carOwnerNumber;
    }

    public String getCarOwnerAddress() {
        return carOwnerAddress;
    }

    public void setCarOwnerAddress(String carOwnerAddress) {
        this.carOwnerAddress = carOwnerAddress;
    }

    public String getCarMasterName() {
        return carMasterName;
    }

    public void setCarMasterName(String carMasterName) {
        this.carMasterName = carMasterName;
    }

    public String getCarMasterWork() {
        return carMasterWork;
    }

    public void setCarMasterWork(String carMasterWork) {
        this.carMasterWork = carMasterWork;
    }
}
