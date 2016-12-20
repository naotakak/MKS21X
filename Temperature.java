public class Temperature {
    public static double CtoF(double t) {
	if (t == -40.0) {
	    return -40.0;
	}
	return t * (9.0 / 5.0) + 32.0;
    }

    public static double FtoC(double t) {
	return (t - 32.0) * (5.0 / 9.0);
    }

}
