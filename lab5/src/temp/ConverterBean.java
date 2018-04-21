package temp;

import javax.ejb.Stateless;

@Stateless
public class ConverterBean implements ConverterInterface {

    @Override
    public double Cels2Fahr(double temp) {
        return 9.0 / 5.0 * temp + 32.0;
    }

    @Override
    public double Fahr2Cels(double temp) {
        return 5.0 / 9.0 * (temp - 32.0);
    }


}
