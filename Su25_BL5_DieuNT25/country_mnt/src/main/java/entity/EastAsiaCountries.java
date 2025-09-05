package entity;


public class EastAsiaCountries extends Country {
    private String countryTerrain;

    public EastAsiaCountries() { }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-6s %-20s %-12.1f %-12s%n",
                countryCode.toUpperCase(), countryName, totalArea, countryTerrain);
    }
}
