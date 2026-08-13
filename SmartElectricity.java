import java.util.ArrayList;
import java.util.Scanner;


abstract class Appliance {

    private String name;
    private String brand;
    private int power;

    public Appliance(String name, String brand, int power) {
        this.name = name;
        this.brand = brand;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPower() {
        return power;
    }

    public abstract double calculateEnergy(int hours);

    public void display() {
        System.out.println("--------------------------------");
        System.out.println("Appliance : " + name);
        System.out.println("Brand     : " + brand);
        System.out.println("Power     : " + power + " W");
    }
}

//================ Light Class ================
class Light extends Appliance {

    private int brightness;

    public Light(String name, String brand, int power, int brightness) {
        super(name, brand, power);
        this.brightness = brightness;
    }

    
    public double calculateEnergy(int hours) {
        return (getPower() * (brightness / 100.0) * hours) / 1000.0;
    }

  
    public void display() {
        super.display();
        System.out.println("Brightness : " + brightness + "%");
    }
}

//================ Fan Class ================
class Fan extends Appliance {

    private int speed;

    public Fan(String name, String brand, int power, int speed) {
        super(name, brand, power);
        this.speed = speed;
    }

    
    public double calculateEnergy(int hours) {
        return (getPower() * (speed / 5.0) * hours) / 1000.0;
    }

  
    public void display() {
        super.display();
        System.out.println("Speed Level : " + speed);
    }
}

//================ Air Conditioner Class ================
class AirConditioner extends Appliance {

    private int temperature;

    public AirConditioner(String name, String brand, int power, int temperature) {
        super(name, brand, power);
        this.temperature = temperature;
    }

   
    public double calculateEnergy(int hours) {
        return (getPower() * hours) / 1000.0;
    }

   
    public void display() {
        super.display();
        System.out.println("Temperature : " + temperature + " °C");
    }
}

//================ Electricity Bill Class ================
class ElectricityBill {

    public static double calculate(double units) {

        if (units <= 30)
            return units * 1.90;

        else if (units <= 90)
            return (30 * 1.90) + (units - 30) * 4.50;

        else if (units <= 120)
            return (30 * 1.90) + (60 * 4.50) + (units - 90) * 6.75;

        else
            return (30 * 1.90) + (60 * 4.50) + (30 * 6.75) + (units - 120) * 7.50;
    }
}

//================ SmartEnergy Class ================
class SmartEnergy {

    private ArrayList<Appliance> appliances = new ArrayList<>();

    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public void displayAppliances() {

        System.out.println("\n========== APPLIANCE DETAILS ==========");

        for (Appliance appliance : appliances) {
            appliance.display();
            System.out.println();
        }
    }

    public double calculateTotalEnergy(int[] hours) {

        double total = 0;

        for (int i = 0; i < appliances.size(); i++) {
            total += appliances.get(i).calculateEnergy(hours[i]);
        }

        return total;
    }

    public void displayEnergyReport(int[] hours) {

        System.out.println("\n========== ENERGY REPORT ==========");

        for (int i = 0; i < appliances.size(); i++) {

            Appliance appliance = appliances.get(i);

            appliance.display();

            System.out.println("Hours Used  : " + hours[i]);

            System.out.printf("Energy Used : %.2f kWh%n",
                    appliance.calculateEnergy(hours[i]));

            System.out.println();
        }
    }
}

//================ Main Class ================
public class SmartElectricity {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        SmartEnergy home = new SmartEnergy();

        home.addAppliance(new Light("LED Bulb", "Philips", 100, 80));
        home.addAppliance(new Fan("Ceiling Fan", "LG", 200, 5));
        home.addAppliance(new AirConditioner("Split AC", "Samsung", 500, 22));

        int[] hours = new int[3];

        System.out.print("Enter Light Usage Hours : ");
        hours[0] = input.nextInt();

        System.out.print("Enter Fan Usage Hours : ");
        hours[1] = input.nextInt();

        System.out.print("Enter AC Usage Hours : ");
        hours[2] = input.nextInt();

        home.displayAppliances();

        home.displayEnergyReport(hours);

        double dailyUnits = home.calculateTotalEnergy(hours);

        double dailyBill = ElectricityBill.calculate(dailyUnits);

        System.out.println("==========================================");
        System.out.printf("Daily Energy Consumption : %.2f kWh%n", dailyUnits);
        System.out.printf("Daily Electricity Bill   : Rs. %.2f%n", dailyBill);
        System.out.printf("Monthly Energy           : %.2f kWh%n", dailyUnits * 30);
        System.out.printf("Estimated Monthly Bill   : Rs. %.2f%n", dailyBill * 30);
        System.out.println("==========================================");

        input.close();
    }
}