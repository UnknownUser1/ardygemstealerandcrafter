package ardygemstealer;

import java.text.DecimalFormat;

public class Variables {
	public static String addDecimals(int item) {
		DecimalFormat form = new DecimalFormat("#,###");
		return "" + form.format(item);

	}

	public int getHourlyRate(int variable) {
		return (int) (((double) (variable - 0) * 3600000D) / (double) (System
				.currentTimeMillis() - Main.startTime));
	}

	public static String runTime(long i) {

		DecimalFormat nf = new DecimalFormat("00");
		long millis = System.currentTimeMillis() - i;
		long hours = millis / (1000 * 60 * 60);
		millis -= hours * (1000 * 60 * 60);
		long minutes = millis / (1000 * 60);
		millis -= minutes * (1000 * 60);
		long seconds = millis / 1000;

		return nf.format(hours) + ":" + nf.format(minutes) + ":"
				+ nf.format(seconds);
	}

}
