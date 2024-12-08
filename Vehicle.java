// Conner Wiley CSCE-145 Section 009 //

public class Vehicle {
    private String manufacturer;
    private int cylinders;
    private String owner;

    // Default constructor
    public Vehicle() {
        this.manufacturer = "Unknown";
        this.cylinders = 1;
        this.owner = "Unknown";
    }

    // Parameterized constructor
    public Vehicle(String manufacturer, int cylinders, String owner) {
        if (cylinders > 0) {
            this.cylinders = cylinders;
        } else {
            this.cylinders = 1;
        }
        this.manufacturer = manufacturer;
        this.owner = owner;
    }

    // Accessors and Mutators
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        if (cylinders > 0) {
            this.cylinders = cylinders;
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return cylinders == vehicle.cylinders &&
                manufacturer.equals(vehicle.manufacturer) &&
                owner.equals(vehicle.owner);
    }

    // toString method
    @Override
    public String toString() {
        return "Manufacturer's Name: " + manufacturer + "\n" +
               "Number Of Cylinders: " + cylinders + "\n" +
               "Owner's Name: " + owner;
    }
}

// Truck class which extends Vehicle
class Truck extends Vehicle {
    private double loadCapacity;
    private double towingCapacity;

    public Truck() {
        super();
        this.loadCapacity = 0.0;
        this.towingCapacity = 0.0;
    }

    public Truck(String manufacturer, int cylinders, String owner, double loadCapacity, double towingCapacity) {
        super(manufacturer, cylinders, owner);
        this.loadCapacity = Math.max(loadCapacity, 0.0);
        this.towingCapacity = Math.max(towingCapacity, 0.0);
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        if (loadCapacity >= 0) {
            this.loadCapacity = loadCapacity;
        }
    }

    public double getTowingCapacity() {
        return towingCapacity;
    }

    public void setTowingCapacity(double towingCapacity) {
        if (towingCapacity >= 0) {
            this.towingCapacity = towingCapacity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Truck truck = (Truck) obj;
        return loadCapacity == truck.loadCapacity &&
               towingCapacity == truck.towingCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Load Capacity: " + loadCapacity + "\n" +
               "Towing Capacity: " + towingCapacity;
    }
}

// Car class which extends Vehicle
class Car extends Vehicle {
    private double gasMileage;
    private int passengers;

    public Car() {
        super();
        this.gasMileage = 0.0;
        this.passengers = 0;
    }

    public Car(String manufacturer, int cylinders, String owner, double gasMileage, int passengers) {
        super(manufacturer, cylinders, owner);
        this.gasMileage = Math.max(gasMileage, 0.0);
        this.passengers = Math.max(passengers, 0);
    }

    public double getGasMileage() {
        return gasMileage;
    }

    public void setGasMileage(double gasMileage) {
        if (gasMileage >= 0) {
            this.gasMileage = gasMileage;
        }
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        if (passengers >= 0) {
            this.passengers = passengers;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Car car = (Car) obj;
        return gasMileage == car.gasMileage &&
               passengers == car.passengers;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Gas Mileage: " + gasMileage + " gallons\n" +
               "Number of Passengers: " + passengers;
    }
}
