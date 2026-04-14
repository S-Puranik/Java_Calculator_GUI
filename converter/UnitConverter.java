package calculator.converter;

public class UnitConverter {

    public double convert(String category, String from, String to, double input) {

        switch (category) {

            case "Length":
                if (from.equals("Meter") && to.equals("Kilometer"))
                    return input / 1000;
                else if (from.equals("Kilometer") && to.equals("Meter"))
                    return input * 1000;
                else if (from.equals("Meter") && to.equals("Centimeter"))
                    return input * 100;
                else if (from.equals("Centimeter") && to.equals("Meter"))
                    return input / 100;
                break;

            case "Weight":
                if (from.equals("Gram") && to.equals("Kilogram"))
                    return input / 1000;
                else if (from.equals("Kilogram") && to.equals("Gram"))
                    return input * 1000;
                break;

            case "Temperature":
                if (from.equals("Celsius") && to.equals("Fahrenheit"))
                    return (input * 9/5) + 32;
                else if (from.equals("Fahrenheit") && to.equals("Celsius"))
                    return (input - 32) * 5/9;
                break;

            case "Area":
                if (from.equals("Sq Meter") && to.equals("Sq Kilometer"))
                    return input / 1_000_000;
                else if (from.equals("Sq Kilometer") && to.equals("Sq Meter"))
                    return input * 1_000_000;
                break;

            case "Volume":
                if (from.equals("Liter") && to.equals("Milliliter"))
                    return input * 1000;
                else if (from.equals("Milliliter") && to.equals("Liter"))
                    return input / 1000;
                break;

            case "Speed":
                if (from.equals("m/s") && to.equals("km/h"))
                    return input * 3.6;
                else if (from.equals("km/h") && to.equals("m/s"))
                    return input / 3.6;
                break;
        }

        return 0; // fallback
    }
}
